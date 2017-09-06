package com.boco.modules.fdoc.api;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boco.common.utils.DateUtils;
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

}
