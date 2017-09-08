package com.boco.modules.fdoc.service.sign.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.boco.common.constants.BusinessConstants;
import com.boco.common.utils.DateUtils;
import com.boco.common.utils.JsonUtils;
import com.boco.common.utils.StringUtils;
import com.boco.modules.fdoc.dao.sign.AppraisalMonthSignOrgIncrementDao;
import com.boco.modules.fdoc.dao.system.AppraisalGradeLineDao;
import com.boco.modules.fdoc.dao.system.HospitalDao;
import com.boco.modules.fdoc.model.score.HospitalEntity;
import com.boco.modules.fdoc.model.sign.AppraisalMonthSignOrgIncrementEntity;
import com.boco.modules.fdoc.model.sign.AppraisalMonthSignTeamIncrementEntity;
import com.boco.modules.fdoc.model.system.AppraisalGradeLineEntity;
import com.boco.modules.fdoc.service.sign.AppraisalMonthSignOrgIncrementService;
import com.boco.modules.fdoc.vo.AppraisalMonthSignOrgIncrementVo;

@Service
public class AppraisalMonthSignOrgIncrementServiceImpl implements AppraisalMonthSignOrgIncrementService{
	
	@Resource
	AppraisalMonthSignOrgIncrementDao signOrgIncrementDao;
	@Resource
	AppraisalGradeLineDao gradeLineDao;
	@Resource
	HospitalDao hospitalDao;

	@Override
	public List<AppraisalMonthSignOrgIncrementVo> getMonthSignOrgDataList(
			String month) {
		return signOrgIncrementDao.getMonthSignOrgDataList(month);
	}

	@Override
	public List<AppraisalMonthSignOrgIncrementVo> getMonthSignExcellentOrgDataList(
			String month, String target) throws Exception {
			//获取所有机构签约管理集合
			List<AppraisalMonthSignOrgIncrementVo> dataList = signOrgIncrementDao.getMonthSignOrgDataList(month);
			System.out.println(month);
		//	System.out.println(JsonUtils.getJsonFormat(dataList));
			//获取优秀分数线
			AppraisalGradeLineEntity excellentGradeLine = gradeLineDao.getExcellentGradeLine();
			
			//声明返回list
			List<AppraisalMonthSignOrgIncrementVo> resultList = new ArrayList<AppraisalMonthSignOrgIncrementVo>();
			for (AppraisalMonthSignOrgIncrementVo item : dataList) {
				//获取item字节码对象
				Class<? extends AppraisalMonthSignOrgIncrementVo> cls = item.getClass();
				
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

	@Override
	public String doMonthSignOrgIncrementStatistics(Date monthBegin,
			Date monthEnd) {
		//封装查询参数
		AppraisalMonthSignOrgIncrementVo paramVo = new AppraisalMonthSignOrgIncrementVo();
		paramVo.setMonthBegin(monthBegin);
		paramVo.setMonthEnd(monthEnd);
		
		//获取所有机构列表
		List<HospitalEntity> hospitalList = hospitalDao.getHospitalList();
		for (HospitalEntity hospitalEntity : hospitalList) {
			
			paramVo.setOrgId(hospitalEntity.getId());
			
			//获取数据
			AppraisalMonthSignOrgIncrementEntity entity = signOrgIncrementDao.getMonthSignOrgDataSource(paramVo);
			entity.setOrgId(hospitalEntity.getId());
			entity.setMonth(DateUtils.formatDate(monthEnd, "yyyyMM"));
			entity.setCreateTime(new Date());
			int num=signOrgIncrementDao.update(entity);
			if(num==0){
				signOrgIncrementDao.insert(entity);
			}
		}
		return BusinessConstants.SUCCESS;
	}

	
	

}
