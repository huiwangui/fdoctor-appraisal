package com.boco.modules.fdoc.service.sign.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.boco.common.utils.StringUtils;
import com.boco.modules.fdoc.dao.sign.AppraisalMonthSignTeamIncrementDao;
import com.boco.modules.fdoc.dao.system.AppraisalGradeLineDao;
import com.boco.modules.fdoc.model.system.AppraisalGradeLineEntity;
import com.boco.modules.fdoc.service.sign.AppraisalMonthSignTeamIncrementService;
import com.boco.modules.fdoc.vo.AppraisalMonthSignOrgIncrementVo;
import com.boco.modules.fdoc.vo.AppraisalMonthSignTeamIncrementVo;

@Service
public class AppraisalMonthSignTeamIncrementServiceImpl implements AppraisalMonthSignTeamIncrementService{

	@Resource
	AppraisalGradeLineDao gradeLineDao;
	@Resource
	AppraisalMonthSignTeamIncrementDao teamIncrementDao;
	
	@Override
	public List<AppraisalMonthSignTeamIncrementVo> getMonthSignTeamDataList(
			String month) {
		return teamIncrementDao.getMonthSignTeamDataList(month);
	}

	@Override
	public List<AppraisalMonthSignTeamIncrementVo> getMonthSignExcellentTeamDataList(
			String month, String target) throws Exception{
		//获取所有机构签约管理集合
		List<AppraisalMonthSignTeamIncrementVo> dataList = teamIncrementDao.getMonthSignTeamDataList(month);
		
		//获取优秀分数线
		AppraisalGradeLineEntity excellentGradeLine = gradeLineDao.getExcellentGradeLine();
		
		//声明返回list
		List<AppraisalMonthSignTeamIncrementVo> resultList = new ArrayList<AppraisalMonthSignTeamIncrementVo>();
		for (AppraisalMonthSignTeamIncrementVo item : dataList) {
			
			//获取item字节码对象
			Class<? extends AppraisalMonthSignTeamIncrementVo> cls = item.getClass();
			
			//调用对应字段的get方法
			Method getMethod = cls.getDeclaredMethod("get" + StringUtils.captureUpName(target));
			double score = (double) getMethod.invoke(item);
			
			//如果当前机构得分大于优秀分数线最低值，则判断为优秀机构
			if (score >= excellentGradeLine.getLower()) {
				resultList.add(item);
			}
		}
		return resultList;
	}

}
