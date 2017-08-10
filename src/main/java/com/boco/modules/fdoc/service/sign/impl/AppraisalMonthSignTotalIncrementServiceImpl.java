package com.boco.modules.fdoc.service.sign.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.boco.common.constants.BusinessConstants;
import com.boco.common.utils.DateUtils;
import com.boco.common.utils.NumberUtils;
import com.boco.modules.fdoc.dao.sign.AppraisalMonthSignTotalIncrementDao;
import com.boco.modules.fdoc.model.sign.AppraisalMonthSignTotalIncrementEntity;
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
		
		//如果为0，设定为全属性为0的对象
		signTotalData = (signTotalData != null) ? signTotalData : new AppraisalMonthSignTotalIncrementVo();
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

	@Override
	public List<AppraisalMonthSignTotalIncrementEntity> getYearSignDataList(
			String year) {
		
		//获取年份数据
		List<AppraisalMonthSignTotalIncrementEntity> yearSignDataList = signTotalDao.getYearSignDataList(year);
		
		//没有的月份用0填充
		String[] months = {year + "01", year + "02", year + "03", year + "04", year + "05", year + "06", year + "07",
				year + "08", year + "09", year + "10", year + "11", year + "12"};
		
		for (int i = 0; i < months.length; i++) {
			//设置flag, 判断list中有没有当前循环的月份
			boolean flag = false;
			for (AppraisalMonthSignTotalIncrementEntity item : yearSignDataList) {
				if (months[i].equals(item.getMonth())) {
					flag = true;
				}
			}
			if (!flag) {
				AppraisalMonthSignTotalIncrementEntity entity = new AppraisalMonthSignTotalIncrementEntity();
				entity.setMonth(months[i]);
				yearSignDataList.add(entity);
			}
		}
		
		//重新排序
		Collections.sort(yearSignDataList,new Comparator<AppraisalMonthSignTotalIncrementEntity>(){
            public int compare(AppraisalMonthSignTotalIncrementEntity arg0, AppraisalMonthSignTotalIncrementEntity arg1) {
                return arg0.getMonth().compareTo(arg1.getMonth());
            }
        });
		
		return yearSignDataList;
	}

	@Override
	public List<String> getYears() {
		return signTotalDao.getYears();
	}

	@Override
	public String doMonthSignTotalIncrementStatistics(Date monthBegin,
			Date monthEnd) {
		
		//封装查询参数
		AppraisalMonthSignTotalIncrementVo paramVo = new AppraisalMonthSignTotalIncrementVo();
		paramVo.setMonthBegin(monthBegin);
		paramVo.setMonthEnd(monthEnd);
		
		AppraisalMonthSignTotalIncrementEntity entity = signTotalDao.getMonthSignTotalDataSource(paramVo);
		entity.setMonth(DateUtils.formatDate(monthEnd, "yyyyMM"));
		entity.setCreateTime(new Date());
		signTotalDao.insert(entity);
		
		return BusinessConstants.SUCCESS;
	}

}
