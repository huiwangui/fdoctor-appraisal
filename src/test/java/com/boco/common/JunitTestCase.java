package com.boco.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ReflectionUtils;

import com.boco.common.utils.JsonUtils;
import com.boco.modules.fdoc.common.Checkingalgorithm;
import com.boco.modules.fdoc.model.sign.AppraisalMonthSignOrgIncrementEntity;
import com.boco.modules.fdoc.model.system.AppraisalQuotaEntity;
import com.boco.modules.fdoc.service.sign.AppraisalMonthSignOrgIncrementService;
import com.boco.modules.fdoc.service.system.AppraisalQuotaService;
import com.boco.modules.fdoc.vo.AppraisalMonthSignOrgIncrementVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:mybatis-config.xml",
		"classpath:datasource-druid.xml",
		"classpath:spring-context.xml",
		"classpath:spring-mybatis.xml" })
public class JunitTestCase {
	protected Logger logger = Logger.getLogger(getClass());
	
	
	@Resource
	AppraisalMonthSignOrgIncrementService Service;
	@Resource
	AppraisalQuotaService quotaService;
	
	@Test
	public void gets(){
		Checkingalgorithm cal=new Checkingalgorithm();

		//List<AppraisalMonthSignOrgIncrementEntity>  list=Service.getMonthSignOrgDataListEntity("201705");
		List<AppraisalMonthSignOrgIncrementVo>  list=Service.getMonthSignOrgDataList("201705");
		
		System.out.println(list.size());
		System.out.println(JsonUtils.getJsonFormat(list));
		List<AppraisalQuotaEntity> zb=quotaService.getAll();
		try {
			cal.getSecondPeriodScore(list, cal.getMap(zb,2),2);
			System.out.println(JsonUtils.getJsonFormat(cal.getSecondPeriodScore(list, cal.getMap(zb,2),2)));
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchMethodException | SecurityException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}

		
}
