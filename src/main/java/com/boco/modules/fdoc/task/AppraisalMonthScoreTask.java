package com.boco.modules.fdoc.task;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.boco.common.utils.DateUtils;
import com.boco.modules.fdoc.service.sign.AppraisalMonthSignOrgIncrementService;
import com.boco.modules.fdoc.service.sign.AppraisalMonthSignTeamIncrementService;
import com.boco.modules.fdoc.service.sign.AppraisalMonthSignTotalIncrementService;

/**
 * 月度统计算分定时任务
 * @author q
 *
 */
@Component("appraisalMonthScoreTask")
public class AppraisalMonthScoreTask {
	
	@Resource
	AppraisalMonthSignTeamIncrementService teamIncrementService;
	@Resource
	AppraisalMonthSignOrgIncrementService orgIncrementService;
	@Resource
	AppraisalMonthSignTotalIncrementService totalIncrementService;
	
	
	
	//@Scheduled(cron = "0 0/1 * * * ?")	//每分钟触发
	@Scheduled(cron = "0 0 1 1 * ?")	//每个月的1号凌晨1点触发，统计上个月
	public void scoreTask(){
		//获取上个月起始时间、结束时间
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
        
        
        
	}
}
