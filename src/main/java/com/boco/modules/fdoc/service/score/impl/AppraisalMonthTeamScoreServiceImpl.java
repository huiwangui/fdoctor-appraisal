package com.boco.modules.fdoc.service.score.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.boco.common.utils.StringUtils;
import com.boco.modules.fdoc.dao.score.AppraisalMonthTeamScoreDao;
import com.boco.modules.fdoc.dao.system.AppraisalGradeLineDao;
import com.boco.modules.fdoc.model.score.AppraisalMonthTeamScoreEntity;
import com.boco.modules.fdoc.model.system.AppraisalGradeLineEntity;
import com.boco.modules.fdoc.service.score.AppraisalMonthTeamScoreService;
import com.boco.modules.fdoc.vo.AppraisalMonthSignTeamIncrementVo;
import com.boco.modules.fdoc.vo.AppraisalMonthTeamScoreVo;
@Service
public class AppraisalMonthTeamScoreServiceImpl implements AppraisalMonthTeamScoreService {
	@Resource
	AppraisalMonthTeamScoreDao appraisalMonthTeamScoreDao;
	@Resource
	AppraisalGradeLineDao gradeLineDao;
	
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
	public Map<String, Object> getAppraisalMonthTeamScoreWithGrade(String month, String target)throws Exception {
		//获取月度机构评分列表
		List<AppraisalMonthTeamScoreVo> scoreList = appraisalMonthTeamScoreDao.getAppraisalMonthTeamScoreListByMonth(month);
		
		//获取所有分数线
		List<AppraisalGradeLineEntity> gradeLins = gradeLineDao.findAll();
		
		//根据分数线进行分组
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		for (AppraisalGradeLineEntity line : gradeLins) {
			//若在分数线内，则加入到当前分组中
			List<AppraisalMonthTeamScoreVo> gradeList = new ArrayList<AppraisalMonthTeamScoreVo>();
			
			for (AppraisalMonthTeamScoreVo scoreItem : scoreList) {
				
				//获取item字节码对象
				Class<? extends AppraisalMonthTeamScoreVo> cls = scoreItem.getClass();
				
				//调用对应字段的get方法
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

}
