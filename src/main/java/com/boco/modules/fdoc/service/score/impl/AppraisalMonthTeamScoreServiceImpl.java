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
import com.boco.sp.external.api.dictionary.JsonUtils;

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

		
		int ok = 0;
		
		Checkingalgorithm cal = new Checkingalgorithm();
		List<AppraisalQuotaEntity> zb1=quotaService.getByParentId(10);//---签约指标
		List<AppraisalQuotaEntity> zb2=quotaService.getByParentId(20);//---随访体检指标
		List<AppraisalQuotaEntity> zb3=quotaService.getByParentId(30);//---健康管理指标
		List<AppraisalQuotaEntity> zb=quotaService.getByParentId(0);//---一类指标占比
		Map<String, Double> zbmap1 = cal.getMap(zb1, 2);
		Map<String, Double> zbmap2 = cal.getMap(zb2, 2);
		Map<String, Double> zbmap3 = cal.getMap(zb3, 2);
		Map<String, Double> zbmap = cal.getMap(zb, 2);
		Double result=0.0;//总得分
		
		try {
			if(list1!=null){
				List<Map<String, Object>> rlist = (List<Map<String, Object>>) cal.getSecondPeriodScore(list1,
						cal.getMap(zb1, 2), 2);//签约得分
                if(rlist!=null&&rlist.size()>0){
                	for (Map<String, Object> map : rlist) {
        				MaptoBeanVo vo = (MaptoBeanVo) BeanUtils.mapToObject(map, MaptoBeanVo.class);
        				AppraisalMonthTeamScoreEntity teamScoreEntity = mapper.map(vo, AppraisalMonthTeamScoreEntity.class);
        			    result = teamScoreEntity.getSignManageScore() *zbmap .get("signManageScore");
        			   // System.out.println(JsonUtils.getJsonFormat(teamScoreEntity));
        				int update=appraisalMonthTeamScoreDao.update(teamScoreEntity);
        				if(update==0){
        					teamScoreEntity.setResultScore(result);
        					teamScoreEntity.setCreateTime(new Date());
        					int inInt = appraisalMonthTeamScoreDao.insert(teamScoreEntity);
        					if(inInt>0){
        						ok++;
        					}else{
        						throw new RuntimeException("添加数据异常");
        					}
        				}else{
        					ok++;
        				}
        				
        			}
				}
			}
			
			if(listTeamPublicHealthVo!=null){
				List<Map<String, Object>> list2 = (List<Map<String, Object>>) cal.getSecondPeriodScore(listTeamPublicHealthVo,
						cal.getMap(zb2, 2), 2);//随访体检得分
				if(list2!=null&&list2.size()>0){
					for (Map<String, Object> map : list2) {
						MaptoBeanVo vo = (MaptoBeanVo) BeanUtils.mapToObject(map, MaptoBeanVo.class);
						AppraisalMonthTeamScoreEntity teamScoreEntity=mapper.map(vo, AppraisalMonthTeamScoreEntity.class);
					    result =result+ teamScoreEntity.getSignManageScore() *zbmap .get("publicHealthScore");
					    appraisalMonthTeamScoreDao.update(teamScoreEntity);
					    int update=appraisalMonthTeamScoreDao.update(teamScoreEntity);
        				if(update==0){
        					teamScoreEntity.setResultScore(result);
        					teamScoreEntity.setCreateTime(new Date());
        					int inInt = appraisalMonthTeamScoreDao.insert(teamScoreEntity);
        					if(inInt>0){
        						ok++;
        					}else{
        						throw new RuntimeException("添加数据异常");
        					}
        				}else{
        					ok++;
        				}
						
					}
				}
				
			}
            if(listTeamHealthMange!=null){
            	List<Map<String, Object>> list3 = (List<Map<String, Object>>) cal.getSecondPeriodScore(listTeamHealthMange,
						cal.getMap(zb3, 2), 2);//健康管理得分
                if(list3!=null&&list3.size()>0){
					
					for (Map<String, Object> map : list3) {
						MaptoBeanVo vo = (MaptoBeanVo) BeanUtils.mapToObject(map, MaptoBeanVo.class);
						AppraisalMonthTeamScoreEntity teamScoreEntity=mapper.map(vo, AppraisalMonthTeamScoreEntity.class);
					    result =result+ teamScoreEntity.getSignManageScore() *zbmap .get("healthManageScore");
					    appraisalMonthTeamScoreDao.update(teamScoreEntity);
					    int update=appraisalMonthTeamScoreDao.update(teamScoreEntity);
        				if(update==0){
        					teamScoreEntity.setResultScore(result);
        					teamScoreEntity.setCreateTime(new Date());
        					int inInt = appraisalMonthTeamScoreDao.insert(teamScoreEntity);
        					if(inInt>0){
        						ok++;
        					}else{
        						throw new RuntimeException("添加数据异常");
        					}
        				}else{
        					ok++;
        				}
						
					}
				}
				
				
			}

		} catch (IllegalArgumentException | IllegalAccessException | NoSuchMethodException | SecurityException
				| InvocationTargetException e) {
			e.printStackTrace();
		}

		return ok;
	}

}
