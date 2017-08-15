package com.boco.modules.fdoc.task;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
	@Resource
	HospitalService hospitalService;
	@Resource
	AppraisalMonthOrgScoreService orgScoreService;
	@Resource
	AppraisalMonthTeamScoreService teamScoreService;
	
	
	
	//@Scheduled(cron = "0 0/1 * * * ?")	//每分钟触发
	@Scheduled(cron = "0 0 1 1 * ?")	//每个月的1号凌晨1点触发，统计上个月
	public void scoreTask() throws Exception{
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
        
        List<HospitalEntity> hospitalList = hospitalService.getHospitalList();
        //团队算分
        List<AppraisalMonthSignTeamIncrementVo> teamList = teamIncrementService.getMonthSignTeamDataList(year + month);
        teamScoreService.insert(teamList, null, null);
        
        //机构算分
        orgScoreService.insert(hospitalList, year + month);
	}
}
