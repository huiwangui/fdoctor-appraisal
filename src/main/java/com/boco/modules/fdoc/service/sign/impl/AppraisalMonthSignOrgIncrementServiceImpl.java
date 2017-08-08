package com.boco.modules.fdoc.service.sign.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.boco.modules.fdoc.dao.sign.AppraisalMonthSignOrgIncrementDao;
import com.boco.modules.fdoc.dao.system.AppraisalGradeLineDao;
import com.boco.modules.fdoc.model.system.AppraisalGradeLineEntity;
import com.boco.modules.fdoc.service.sign.AppraisalMonthSignOrgIncrementService;
import com.boco.modules.fdoc.vo.AppraisalMonthSignOrgIncrementVo;

@Service
public class AppraisalMonthSignOrgIncrementServiceImpl implements AppraisalMonthSignOrgIncrementService{
	
	@Resource
	AppraisalMonthSignOrgIncrementDao signOrgIncrementDao;
	@Resource
	AppraisalGradeLineDao gradeLineDao;

	@Override
	public List<AppraisalMonthSignOrgIncrementVo> getMonthSignOrgDataList(
			String month) {
		return signOrgIncrementDao.getMonthSignOrgDataList(month);
	}

	@Override
	public List<AppraisalMonthSignOrgIncrementVo> getMonthSignExcellentOrgDataList(
			String month) {
		//获取所有机构签约管理集合
		List<AppraisalMonthSignOrgIncrementVo> dataList = signOrgIncrementDao.getMonthSignOrgDataList(month);
		
		//获取优秀分数线
		AppraisalGradeLineEntity excellentGradeLine = gradeLineDao.getExcellentGradeLine();
		
		//声明返回list
		List<AppraisalMonthSignOrgIncrementVo> resultList = new ArrayList<AppraisalMonthSignOrgIncrementVo>();
		for (AppraisalMonthSignOrgIncrementVo item : dataList) {
			
			//如果当前机构得分大于优秀分数线最低值，则判断为优秀机构
			if (item.getResultScore() >= excellentGradeLine.getLower()) {
				resultList.add(item);
			}
		}
		return resultList;
	}
	
	

}
