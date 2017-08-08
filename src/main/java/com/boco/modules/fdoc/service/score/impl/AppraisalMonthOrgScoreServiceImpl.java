package com.boco.modules.fdoc.service.score.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.boco.modules.fdoc.dao.score.AppraisalMonthOrgScoreDao;
import com.boco.modules.fdoc.dao.system.AppraisalGradeLineDao;
import com.boco.modules.fdoc.dao.system.HospitalDao;
import com.boco.modules.fdoc.model.score.AppraisalMonthOrgScoreEntity;
import com.boco.modules.fdoc.model.score.HospitalEntity;
import com.boco.modules.fdoc.model.system.AppraisalGradeLineEntity;
import com.boco.modules.fdoc.service.score.AppraisalMonthOrgScoreService;
import com.boco.modules.fdoc.vo.AppraisalMonthOrgScoreVo;
 
@Service
public class AppraisalMonthOrgScoreServiceImpl implements AppraisalMonthOrgScoreService {

	@Resource
	AppraisalMonthOrgScoreDao appraisalMonthOrgScoreDao;
	@Resource
	HospitalDao hospitalDao;
	@Resource
	AppraisalGradeLineDao gradeLineDao;
	
	@Override
	public List<HospitalEntity> getHospitalList() {		 
		return hospitalDao.getHospitalList();
	}
	
	@Override
	public AppraisalMonthOrgScoreVo getAppraisalMonthOrgScoreByMonth(AppraisalMonthOrgScoreEntity entity) {
		 
		return  appraisalMonthOrgScoreDao.getAppraisalMonthOrgScoreByMonth(entity);
	}
	
	@Override
	public List<AppraisalMonthOrgScoreVo> getAppraisalMonthOrgScoreListByMonth(String month) {
		 
		return appraisalMonthOrgScoreDao.getAppraisalMonthOrgScoreListByMonth(month);
	}
	
	@Override
	public Map<String, Object> getAppraisalMonthOrgScoreWithGrade(String month) {
		
		//获取月度机构评分列表
		List<AppraisalMonthOrgScoreVo> scoreList = appraisalMonthOrgScoreDao.getAppraisalMonthOrgScoreListByMonth(month);
		
		//获取所有分数线
		List<AppraisalGradeLineEntity> gradeLins = gradeLineDao.findAll();
		
		//根据分数线进行分组
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		for (AppraisalGradeLineEntity line : gradeLins) {
			//若在分数线内，则加入到当前分组中
			List<AppraisalMonthOrgScoreVo> gradeList = new ArrayList<AppraisalMonthOrgScoreVo>();
			
			for (AppraisalMonthOrgScoreVo scoreItem : scoreList) {
				if (scoreItem.getResultScore() >= line.getLower() && scoreItem.getResultScore() < line.getUpper()) {
					gradeList.add(scoreItem);
				}
			}
			returnMap.put(line.getName(), gradeList);
		}
		
		return returnMap;
	}

}
