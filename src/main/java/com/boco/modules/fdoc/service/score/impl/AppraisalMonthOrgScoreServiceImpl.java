package com.boco.modules.fdoc.service.score.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boco.common.utils.BeanUtils;
import com.boco.common.utils.JsonUtils;
import com.boco.common.utils.StringUtils;
import com.boco.modules.fdoc.common.Checkingalgorithm;
import com.boco.modules.fdoc.dao.score.AppraisalMonthOrgScoreDao;
import com.boco.modules.fdoc.dao.system.AppraisalGradeLineDao;
import com.boco.modules.fdoc.dao.system.HospitalDao;
import com.boco.modules.fdoc.model.score.AppraisalMonthOrgScoreEntity;
import com.boco.modules.fdoc.model.score.HospitalEntity;
import com.boco.modules.fdoc.model.system.AppraisalGradeLineEntity;
import com.boco.modules.fdoc.model.system.AppraisalQuotaEntity;
import com.boco.modules.fdoc.service.score.AppraisalMonthOrgScoreService;
import com.boco.modules.fdoc.service.system.AppraisalQuotaService;
import com.boco.modules.fdoc.vo.AppraisalMonthOrgScoreVo;
import com.boco.modules.fdoc.vo.AppraisalMonthSignOrgIncrementVo;
import com.boco.modules.fdoc.vo.MaptoBeanVo;

@Service
public class AppraisalMonthOrgScoreServiceImpl implements AppraisalMonthOrgScoreService {

	@Resource
	AppraisalMonthOrgScoreDao appraisalMonthOrgScoreDao;
	@Resource
	HospitalDao hospitalDao;
	@Resource
	AppraisalGradeLineDao gradeLineDao;
	@Autowired
	Mapper mapper;
	@Resource
	AppraisalQuotaService quotaService;

	@Override
	public List<HospitalEntity> getHospitalList() {
		return hospitalDao.getHospitalList();
	}

	@Override
	public AppraisalMonthOrgScoreVo getAppraisalMonthOrgScoreByMonth(AppraisalMonthOrgScoreEntity entity) {

		return appraisalMonthOrgScoreDao.getAppraisalMonthOrgScoreByMonth(entity);
	}

	@Override
	public List<AppraisalMonthOrgScoreVo> getAppraisalMonthOrgScoreListByMonth(String month) {

		return appraisalMonthOrgScoreDao.getAppraisalMonthOrgScoreListByMonth(month);
	}

	@Override
	public Map<String, Object> getAppraisalMonthOrgScoreWithGrade(String month, String target) throws Exception {

		// 获取月度机构评分列表
		List<AppraisalMonthOrgScoreVo> scoreList = appraisalMonthOrgScoreDao
				.getAppraisalMonthOrgScoreListByMonth(month);

		// 获取所有分数线
		List<AppraisalGradeLineEntity> gradeLins = gradeLineDao.findAll();

		// 根据分数线进行分组
		Map<String, Object> returnMap = new HashMap<String, Object>();

		for (AppraisalGradeLineEntity line : gradeLins) {
			// 若在分数线内，则加入到当前分组中
			List<AppraisalMonthOrgScoreVo> gradeList = new ArrayList<AppraisalMonthOrgScoreVo>();

			for (AppraisalMonthOrgScoreVo scoreItem : scoreList) {
				// 获取item父类字节码对象
				Class<?> cls = scoreItem.getClass().getSuperclass();

				// 调用对应字段的get方法
				Method getMethod = cls.getDeclaredMethod("get" + StringUtils.captureUpName(target));

				double score = (double) getMethod.invoke(scoreItem);

				if (score >= line.getLower() && score < line.getUpper()) {
					gradeList.add(scoreItem);
				}
			}
			returnMap.put(line.getName(), gradeList);
		}

		return returnMap;
	}

	@Override
	public List<AppraisalMonthOrgScoreVo> getOrganizationScoreList(AppraisalMonthOrgScoreVo vo) {
		return appraisalMonthOrgScoreDao.getOrganizationScoreList(vo);
	}

	@Override
	public int getOrganizationScoreListCount(AppraisalMonthOrgScoreVo vo) {
		return appraisalMonthOrgScoreDao.getOrganizationScoreListCount(vo);
	}

	@Override
	public AppraisalMonthOrgScoreVo getAppraisalMonthOrgScoreByOrgId(String orgId) {
		return appraisalMonthOrgScoreDao.getAppraisalMonthOrgScoreByOrgId(orgId);
	}

	@Override
	public int insert(AppraisalMonthOrgScoreEntity entity) {
		return appraisalMonthOrgScoreDao.insert(entity);
	}

	@Override
	public int update(AppraisalMonthOrgScoreEntity entity) {
		return appraisalMonthOrgScoreDao.update(entity);
	}

	@Override
	@Transactional
	public int insert(List<AppraisalMonthSignOrgIncrementVo> list1, List<?> listPublicHealthVo, List<?> listHealthMange)
			throws Exception {
		if (list1 == null) {
			return 0;
		}
		int ok = 0;
		Checkingalgorithm cal = new Checkingalgorithm();
		List<AppraisalQuotaEntity> zb = quotaService.getAll();// ---指标
		Map<String, Double> zbmap = cal.getMap(zb, 2);
		try {
			List<Map<String, Object>> rlist = (List<Map<String, Object>>) cal.getSecondPeriodScore(list1,
					cal.getMap(zb, 2), 2);

			System.out.println(JsonUtils.getJsonFormat(cal.getSecondPeriodScore(list1, cal.getMap(zb, 2), 2)));

			for (Map<String, Object> map : rlist) {
				MaptoBeanVo vo = (MaptoBeanVo) BeanUtils.mapToObject(map, MaptoBeanVo.class);
				AppraisalMonthOrgScoreEntity xo = mapper.map(vo, AppraisalMonthOrgScoreEntity.class);
				Double result = xo.getSignManageScore() * zbmap.get("signManageScore");//加全平均值需要加入后兩項
				xo.setResultScore(result);
				xo.setCreateTime(new Date());
				int inInt = appraisalMonthOrgScoreDao.insert(xo);
				ok=ok+inInt;
				if(inInt==0){
					throw new RuntimeException();
					
				}
			}

		} catch (IllegalArgumentException | IllegalAccessException | NoSuchMethodException | SecurityException
				| InvocationTargetException e) {
			e.printStackTrace();
		}

		return ok;
	}

}
