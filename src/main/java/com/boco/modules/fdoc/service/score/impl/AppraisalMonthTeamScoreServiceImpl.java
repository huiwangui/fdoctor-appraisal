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
import com.boco.common.utils.StringUtils;
import com.boco.modules.fdoc.common.Checkingalgorithm;
import com.boco.modules.fdoc.dao.score.AppraisalMonthTeamScoreDao;
import com.boco.modules.fdoc.dao.system.AppraisalGradeLineDao;
import com.boco.modules.fdoc.model.score.AppraisalMonthTeamScoreEntity;
import com.boco.modules.fdoc.model.system.AppraisalGradeLineEntity;
import com.boco.modules.fdoc.model.system.AppraisalQuotaEntity;
import com.boco.modules.fdoc.service.score.AppraisalMonthTeamScoreService;
import com.boco.modules.fdoc.service.system.AppraisalQuotaService;
import com.boco.modules.fdoc.vo.AppraisalMonthSignTeamIncrementVo;
import com.boco.modules.fdoc.vo.AppraisalMonthTeamScoreVo;
import com.boco.modules.fdoc.vo.MaptoBeanVo;

@Service
public class AppraisalMonthTeamScoreServiceImpl implements AppraisalMonthTeamScoreService {
	@Resource
	AppraisalMonthTeamScoreDao appraisalMonthTeamScoreDao;
	@Resource
	AppraisalGradeLineDao gradeLineDao;
	@Autowired
	Mapper mapper;
	@Resource
	AppraisalQuotaService quotaService;

	@Override
	public List<AppraisalMonthTeamScoreVo> getTeamScoreList(AppraisalMonthTeamScoreVo vo) {
		return appraisalMonthTeamScoreDao.getTeamScoreList(vo);
	}

	@Override
	public int getTeamScoreListCount(AppraisalMonthTeamScoreVo vo) {
		return appraisalMonthTeamScoreDao.getTeamScoreListCount(vo);
	}

	@Override
	public AppraisalMonthTeamScoreVo getAppraisalMonthTeamScoreByMonth(AppraisalMonthTeamScoreEntity entity) {
		return appraisalMonthTeamScoreDao.getAppraisalMonthTeamScoreByMonth(entity);
	}

	@Override
	public AppraisalMonthTeamScoreVo getAppraisalMonthTeamScoreByTeamId(String teamId) {
		return appraisalMonthTeamScoreDao.getAppraisalMonthTeamScoreByTeamId(teamId);
	}

	@Override
	public List<AppraisalMonthTeamScoreVo> getAppraisalMonthTeamScoreListByMonth(String month) {
		return appraisalMonthTeamScoreDao.getAppraisalMonthTeamScoreListByMonth(month);
	}

	@Override
	public Map<String, Object> getAppraisalMonthTeamScoreWithGrade(String month, String target) throws Exception {
		// 获取月度机构评分列表
		List<AppraisalMonthTeamScoreVo> scoreList = appraisalMonthTeamScoreDao
				.getAppraisalMonthTeamScoreListByMonth(month);

		// 获取所有分数线
		List<AppraisalGradeLineEntity> gradeLins = gradeLineDao.findAll();

		// 根据分数线进行分组
		Map<String, Object> returnMap = new HashMap<String, Object>();

		for (AppraisalGradeLineEntity line : gradeLins) {
			// 若在分数线内，则加入到当前分组中
			List<AppraisalMonthTeamScoreVo> gradeList = new ArrayList<AppraisalMonthTeamScoreVo>();

			for (AppraisalMonthTeamScoreVo scoreItem : scoreList) {

				// 获取item字节码对象
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
	public int insert(AppraisalMonthTeamScoreEntity entity) {
		return appraisalMonthTeamScoreDao.insert(entity);
	}

	@Override
	public int update(AppraisalMonthTeamScoreEntity entity) {
		return appraisalMonthTeamScoreDao.update(entity);
	}

	@Override
	@Transactional
	public int insert(List<AppraisalMonthSignTeamIncrementVo> list1, List<?> listTeamPublicHealthVo,
			List<?> listTeamHealthMange) throws Exception {

		if (list1 == null) {
			return 0;
		}
		int ok = 0;
		Checkingalgorithm cal = new Checkingalgorithm();
		List<AppraisalQuotaEntity> zb = quotaService.getAll();// ---指标
		Map<String, Double> zbmap = cal.getMap(zb, 2);// 指标转换
		try {
			List<Map<String, Object>> rlist = (List<Map<String, Object>>) cal.getSecondPeriodScore(list1,
					cal.getMap(zb, 2), 2);
			for (Map<String, Object> map : rlist) {
				MaptoBeanVo vo = (MaptoBeanVo) BeanUtils.mapToObject(map, MaptoBeanVo.class);
				AppraisalMonthTeamScoreEntity xo = mapper.map(vo, AppraisalMonthTeamScoreEntity.class);
				Double result = xo.getSignManageScore() * zbmap.get("signManageScore");// 这以后需加入后两项的权值
				xo.setResultScore(result);
				xo.setCreateTime(new Date());
				int inInt = appraisalMonthTeamScoreDao.insert(xo);
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
