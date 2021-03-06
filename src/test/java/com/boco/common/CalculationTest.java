package com.boco.common;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.dozer.Mapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.boco.common.utils.BeanUtils;
import com.boco.common.utils.JsonUtils;
import com.boco.modules.fdoc.common.Checkingalgorithm;
import com.boco.modules.fdoc.model.score.AppraisalMonthOrgScoreEntity;
import com.boco.modules.fdoc.model.score.AppraisalMonthTeamScoreEntity;
import com.boco.modules.fdoc.model.score.HospitalEntity;
import com.boco.modules.fdoc.model.system.AppraisalQuotaEntity;
import com.boco.modules.fdoc.service.score.AppraisalMonthOrgScoreService;
import com.boco.modules.fdoc.service.score.AppraisalMonthTeamScoreService;
import com.boco.modules.fdoc.service.sign.AppraisalMonthSignOrgIncrementService;
import com.boco.modules.fdoc.service.sign.AppraisalMonthSignTeamIncrementService;
import com.boco.modules.fdoc.service.system.AppraisalQuotaService;
import com.boco.modules.fdoc.service.system.HospitalService;
import com.boco.modules.fdoc.vo.AppraisalMonthSignOrgIncrementVo;
import com.boco.modules.fdoc.vo.AppraisalMonthSignTeamIncrementVo;
import com.boco.modules.fdoc.vo.MaptoBeanVo;

@ContextConfiguration(locations = {
		"classpath:spring-dozer.xml"})
public class CalculationTest extends JunitTestCase{
	Logger log =LoggerFactory.getLogger(this.getClass());
	
	@Resource
	AppraisalMonthSignTeamIncrementService signTeamService;
	@Resource
	AppraisalMonthOrgScoreService ogrScore;
	@Resource
	AppraisalMonthTeamScoreService teamScore;
    @Autowired
    Mapper mapper;
    @Resource
	AppraisalMonthSignOrgIncrementService orgService;
	@Resource
	AppraisalQuotaService quotaService;
	@Resource
	HospitalService hospital;
	
/*	@Test
	public void org() throws Exception{
		Checkingalgorithm cal=new Checkingalgorithm();
		List<AppraisalMonthSignOrgIncrementVo>  SignOrglist=orgService.getMonthSignOrgDataList("201705");//机构签约管理
		System.out.println(JsonUtils.getJsonFormat(SignOrglist));
		List<AppraisalQuotaEntity> zb=quotaService.getAll();//---指标
		 Map<String, Double> zbmap=cal.getMap(zb, 2);
		try {
		 	List<Map<String,Object>> rlist=(List<Map<String,Object>>) cal.getSecondPeriodScore(SignOrglist, cal.getMap(zb,2),2);
					
			System.out.println(JsonUtils.getJsonFormat(cal.getSecondPeriodScore(SignOrglist, cal.getMap(zb,2),2)));
			
			for (Map<String,Object> map:rlist) {
				 MaptoBeanVo vo=(MaptoBeanVo) BeanUtils.mapToObject(map,MaptoBeanVo.class);
				 System.out.println("MapBeanVo"+JsonUtils.getJsonFormat(vo));
				 AppraisalMonthOrgScoreEntity xo= mapper.map(vo, AppraisalMonthOrgScoreEntity.class);
				 System.out.println("Entity"+JsonUtils.getJsonFormat(xo));
				 Double result=xo.getSignManageScore()*zbmap.get("signManageScore");
				 xo.setResultScore(result);
				 xo.setCreateTime(new Date());
				 System.out.println(JsonUtils.getJsonFormat(xo));
				 ogrScore.insert(xo);
			}
			
			
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchMethodException | SecurityException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}*/
	
//	
//	@Test
//	public void team() throws Exception{
//		Checkingalgorithm cal=new Checkingalgorithm();
//		List<AppraisalMonthSignTeamIncrementVo>  SignTeamlist=signTeamService.getMonthSignTeamDataList("201703");//机构签约管理
//		//System.out.println(JsonUtils.getJsonFormat(SignTeamlist));
//		List<AppraisalQuotaEntity> zb=quotaService.getAll();//---指标
//		 Map<String, Double> zbmap=cal.getMap(zb, 2);
//		 System.out.println(JsonUtils.getJsonFormat(zbmap));
//		 //log.error("指标{}"+JsonUtils.getJsonFormat(zbmap));
//		try {
//		 	List<Map<String,Object>> rlist=(List<Map<String,Object>>) cal.getSecondPeriodScore(SignTeamlist, cal.getMap(zb,2),2);
//			//System.out.println(JsonUtils.getJsonFormat(rlist));
//			//System.out.println(JsonUtils.getJsonFormat(cal.getSecondPeriodScore(SignTeamlist, cal.getMap(zb,2),2)));
//			//
//			/*for (Map<String,Object> map:rlist) {
//				 MaptoBeanVo vo=(MaptoBeanVo) BeanUtils.mapToObject(map,MaptoBeanVo.class);
//				 //System.out.println("MapBeanVo"+JsonUtils.getJsonFormat(vo));
//				 AppraisalMonthTeamScoreEntity xo= mapper.map(vo, AppraisalMonthTeamScoreEntity.class);
//				// System.out.println("Entity"+JsonUtils.getJsonFormat(xo));
//				 Double result=xo.getSignManageScore()*zbmap.get("signManageScore");
//				 xo.setResultScore(result);
//				 xo.setCreateTime(new Date());
//				// System.out.println(JsonUtils.getJsonFormat(xo));
//				 teamScore.insert(xo);
//			}*/
//			
//			
//		} catch (IllegalArgumentException | IllegalAccessException | NoSuchMethodException | SecurityException
//				| InvocationTargetException e) {
//			e.printStackTrace();
//		}
//		
//	}
//   
	
/*	@Test
	public void ccc() throws Exception{
		
		List<AppraisalMonthSignTeamIncrementVo>  teamList=signTeamService.getMonthSignTeamDataList("201703");
		teamScore.insert(teamList, null, null);
		
	}*/
	
	
//	@Test
//	public void dddd() throws Exception{
//		Checkingalgorithm cal=new Checkingalgorithm();
//	  	List<AppraisalQuotaEntity> zb1=quotaService.getByParentId(10);//---指标
//	  	System.out.println(JsonUtils.getJsonFormat(zb1));
//		 Map<String, Double> zbmap=cal.getMap(zb1, 2);
//		 System.out.println(JsonUtils.getJsonFormat(zbmap));
//		
//	}
	
	
	@Test
	public void eee() throws Exception{
		List<HospitalEntity> list=hospital.getHospitalList();
		ogrScore.insert(list, "201701");
		
	}
}
