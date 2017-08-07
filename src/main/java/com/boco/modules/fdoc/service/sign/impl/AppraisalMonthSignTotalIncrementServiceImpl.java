package com.boco.modules.fdoc.service.sign.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.boco.common.utils.NumberUtils;
import com.boco.modules.fdoc.dao.sign.AppraisalMonthSignTotalIncrementDao;
import com.boco.modules.fdoc.service.sign.AppraisalMonthSignTotalIncrementService;
import com.boco.modules.fdoc.vo.AppraisalMonthSignTotalIncrementVo;

@Service
public class AppraisalMonthSignTotalIncrementServiceImpl implements AppraisalMonthSignTotalIncrementService{
	
	@Resource
	AppraisalMonthSignTotalIncrementDao signTotalDao;

	@Override
	public AppraisalMonthSignTotalIncrementVo getSignTotalData(
			String monthOrYear) {
		
		//获取签约管理基础数据
		AppraisalMonthSignTotalIncrementVo signTotalData = signTotalDao.getSignTotalData(monthOrYear);
		int signTotal = signTotalData.getSignIncrement();
		
		//封装占比
		signTotalData.setHyperProportion(NumberUtils.division(signTotalData.getHyperIncrement(), signTotal, 3));	//高血压占比
		signTotalData.setDiabetesProportion(NumberUtils.division(signTotalData.getDiabetesIncrement(), signTotal, 3));	//糖尿病占比
		signTotalData.setPhychosisProportion(NumberUtils.division(signTotalData.getPhychosisIncrement(), signTotal, 3));//重性精神病占比
		signTotalData.setOldProportion(NumberUtils.division(signTotalData.getOldIncrement(), signTotal, 3));//老年人占比
		signTotalData.setMaternalProportion(NumberUtils.division(signTotalData.getMaternalIncrement(), signTotal, 3));	//孕产妇占比
		signTotalData.setChildrenProportion(NumberUtils.division(signTotalData.getChildrenIncrement(), signTotal, 3));	//儿童占比
		
		return signTotalData;
	}

}
