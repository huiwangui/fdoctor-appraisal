package com.boco.modules.fdoc.api;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boco.common.utils.DateUtils;
import com.boco.common.utils.StringUtils;
import com.boco.modules.fdoc.model.score.HospitalEntity;
import com.boco.modules.fdoc.service.score.AppraisalMonthOrgScoreService;
import com.boco.modules.fdoc.service.score.AppraisalMonthTeamScoreService;
import com.boco.modules.fdoc.service.sign.AppraisalMonthSignOrgIncrementService;
import com.boco.modules.fdoc.service.sign.AppraisalMonthSignTeamIncrementService;
import com.boco.modules.fdoc.service.sign.AppraisalMonthSignTotalIncrementService;
import com.boco.modules.fdoc.service.system.HospitalService;
import com.boco.modules.fdoc.vo.AppraisalMonthSignTeamIncrementVo;
/**
 * 统计接口
 * 
 * 
 * @author mojun
 *
 * @date 2017年9月6日
 */
@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
public class StatisticsApi {
	
	
	@Resource
	AppraisalMonthSignTeamIncrementService teamIncrementService;
	@Resource
	AppraisalMonthSignOrgIncrementService orgIncrementService;
	@Resource
	AppraisalMonthSignTotalIncrementService totalIncrementService;
	@Resource
	HospitalService hospitalService;
	@Resource
	AppraisalMonthOrgScoreService orgScoreService;
	@Resource
	AppraisalMonthTeamScoreService teamScoreService;
	
	@RequestMapping(value = "/statistic", method = RequestMethod.GET)
	@ResponseBody
	public String tongji() {
		Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, -1);
       
        String year = DateUtils.formatDate(cal.getTime(), "yyyy");
        String month = DateUtils.formatDate(cal.getTime(), "MM");
        
        Date startOfLastMonth = DateUtils.getStartOfMonth(Integer.parseInt(year), Integer.parseInt(month));
        Date endOfLastMonth = DateUtils.getEndOfMonth(Integer.parseInt(year), Integer.parseInt(month));
        
        //团队、机构、总体表统计
        teamIncrementService.doMonthSignTeamIncrementStatistics(startOfLastMonth, endOfLastMonth);
        orgIncrementService.doMonthSignOrgIncrementStatistics(startOfLastMonth, endOfLastMonth);
        totalIncrementService.doMonthSignTotalIncrementStatistics(startOfLastMonth, endOfLastMonth);
        
        List<HospitalEntity> hospitalList = hospitalService.getHospitalList();
        //团队算分
        List<AppraisalMonthSignTeamIncrementVo> teamList = teamIncrementService.getMonthSignTeamDataList(year + month);
        try {
			teamScoreService.insert(teamList, null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "团队分数插入异常！";
		}
        
        //机构算分
        try {
			orgScoreService.insert(hospitalList, year + month);
		} catch (Exception e) {
			
			e.printStackTrace();
			return "机构分数插入异常！";
		} 
		
		return "成功";
		
	}
	
	
	@RequestMapping(value = "/tj", method = RequestMethod.GET)
	@ResponseBody
	public String statisticYear(String yearMonth) {
		if(StringUtils.isEmpty(yearMonth)){
			return "日期不能为空！";
		}
		 /** 
         * 判断日期格式和范围 
         */  
      //  String rexp = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";  
		String rexp = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
        Pattern pat = Pattern.compile(rexp);    
        Matcher mat = pat.matcher(yearMonth);    
         
        if(!mat.matches()){
    	   return "日期格式错误！必须为yyy-MM-dd";
        };  
   
		 //获取上个月起始时间、结束时间
		Calendar cal = Calendar.getInstance();
        cal.setTime(DateUtils.parseDate(yearMonth));
        cal.add(Calendar.MONTH, -1);
       
        String year = DateUtils.formatDate(cal.getTime(), "yyyy");
        String month = DateUtils.formatDate(cal.getTime(), "MM");
        
        Date startOfLastMonth = DateUtils.getStartOfMonth(Integer.parseInt(year), Integer.parseInt(month));
        Date endOfLastMonth = DateUtils.getEndOfMonth(Integer.parseInt(year), Integer.parseInt(month));
        
        
        //团队、机构、总体表统计
        teamIncrementService.doMonthSignTeamIncrementStatistics(startOfLastMonth, endOfLastMonth);
        orgIncrementService.doMonthSignOrgIncrementStatistics(startOfLastMonth, endOfLastMonth);
        totalIncrementService.doMonthSignTotalIncrementStatistics(startOfLastMonth, endOfLastMonth);
        
        List<HospitalEntity> hospitalList = hospitalService.getHospitalList();
        	
        //团队算分
        List<AppraisalMonthSignTeamIncrementVo> teamList = teamIncrementService.getMonthSignTeamDataList(year + month);
        try {
			teamScoreService.insert(teamList, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			return "团队算分异常";
		}
        
        //机构算分
        try {
			orgScoreService.insert(hospitalList, year + month);
		}  catch (Exception e) {
			e.printStackTrace();
			return "机构算分异常";
		}
        
        return "操作成功";
		
	}


}
