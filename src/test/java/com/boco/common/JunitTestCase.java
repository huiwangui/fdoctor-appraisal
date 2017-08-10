package com.boco.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ReflectionUtils;

import com.boco.common.utils.BeanUtils;
import com.boco.common.utils.JsonUtils;
import com.boco.modules.fdoc.common.Checkingalgorithm;
import com.boco.modules.fdoc.model.score.AppraisalMonthOrgScoreEntity;
import com.boco.modules.fdoc.model.sign.AppraisalMonthSignOrgIncrementEntity;
import com.boco.modules.fdoc.model.system.AppraisalQuotaEntity;
import com.boco.modules.fdoc.service.score.AppraisalMonthOrgScoreService;
import com.boco.modules.fdoc.service.score.AppraisalMonthTeamScoreService;
import com.boco.modules.fdoc.service.sign.AppraisalMonthSignOrgIncrementService;
import com.boco.modules.fdoc.service.sign.AppraisalMonthSignTeamIncrementService;
import com.boco.modules.fdoc.service.system.AppraisalQuotaService;
import com.boco.modules.fdoc.vo.AppraisalMonthSignOrgIncrementVo;
import com.boco.modules.fdoc.vo.AppraisalMonthSignTeamIncrementVo;
import com.boco.modules.fdoc.vo.MaptoBeanVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:mybatis-config.xml",
		"classpath:datasource-druid.xml",
		"classpath:spring-context.xml",
		"classpath:spring-mybatis.xml",
		"classpath:spring-dozer.xml"})
public class JunitTestCase {
	protected Logger logger = Logger.getLogger(getClass());
	
	
	@Resource
	AppraisalMonthSignOrgIncrementService Service;
	@Resource
	AppraisalMonthSignTeamIncrementService signTeamService;
	@Resource
	AppraisalMonthOrgScoreService ogrScore;
	
	@Resource
	AppraisalMonthTeamScoreService teamScore;
	
	  @Autowired
	  Mapper mapper;
	
	@Resource
	AppraisalQuotaService quotaService;
	
	@Test
	public void gets() throws Exception{
		Checkingalgorithm cal=new Checkingalgorithm();
		List<AppraisalMonthSignTeamIncrementVo> teamList= signTeamService.getMonthSignTeamDataList("201705");
		List<AppraisalMonthSignOrgIncrementVo>  SignOrglist=Service.getMonthSignOrgDataList("201705");
		System.out.println(JsonUtils.getJsonFormat(SignOrglist));
		List<AppraisalQuotaEntity> zb=quotaService.getAll();
		try {
			Map<String, Object> okmap=cal.getSecondPeriodScore(SignOrglist, cal.getMap(zb,2),2);
			Map<String, Object> okmap2=cal.getSecondPeriodScore(teamList, cal.getMap(zb,2),2);
			
			System.out.println(JsonUtils.getJsonFormat(cal.getSecondPeriodScore(SignOrglist, cal.getMap(zb,2),2)));
			List<Map> listorg=(List<Map>) okmap.get("items");
			for (Map map:listorg) {
				MaptoBeanVo vo=(MaptoBeanVo) BeanUtils.mapToObject(map,MaptoBeanVo.class);
				System.out.println(JsonUtils.getJsonFormat(vo));
				AppraisalMonthOrgScoreEntity xo= mapper.map(vo, AppraisalMonthOrgScoreEntity.class);
				 System.out.println(JsonUtils.getJsonFormat(xo));
			}
			
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchMethodException | SecurityException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}

		
}
