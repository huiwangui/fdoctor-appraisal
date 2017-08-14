package com.boco.modules.fdoc.service.score.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boco.common.utils.BeanUtils;
import com.boco.common.utils.JsonUtils;
import com.boco.common.utils.NumberUtils;
import com.boco.common.utils.StringUtils;
import com.boco.modules.fdoc.common.Checkingalgorithm;
import com.boco.modules.fdoc.dao.score.AppraisalMonthOrgScoreDao;
import com.boco.modules.fdoc.dao.system.AppraisalGradeLineDao;
import com.boco.modules.fdoc.dao.system.HospitalDao;
import com.boco.modules.fdoc.model.score.AppraisalMonthOrgScoreEntity;
import com.boco.modules.fdoc.model.score.HospitalEntity;
import com.boco.modules.fdoc.model.system.AppraisalGradeLineEntity;
import com.boco.modules.fdoc.model.system.AppraisalQuotaEntity;
import com.boco.modules.fdoc.service.score.AppraisalMonthOrgScoreService;
import com.boco.modules.fdoc.service.system.AppraisalQuotaService;
import com.boco.modules.fdoc.vo.AppraisalMonthOrgScoreVo;
import com.boco.modules.fdoc.vo.AppraisalMonthSignOrgIncrementVo;
import com.boco.modules.fdoc.vo.MaptoBeanVo;

@Service
public class AppraisalMonthOrgScoreServiceImpl implements AppraisalMonthOrgScoreService {

	@Resource
	AppraisalMonthOrgScoreDao appraisalMonthOrgScoreDao;
	@Resource
	HospitalDao hospitalDao;
	@Resource
	AppraisalGradeLineDao gradeLineDao;
	@Autowired
	Mapper mapper;
	@Resource
	AppraisalQuotaService quotaService;

	@Override
	public List<HospitalEntity> getHospitalList() {
		return hospitalDao.getHospitalList();
	}

	@Override
	public AppraisalMonthOrgScoreVo getAppraisalMonthOrgScoreByMonth(AppraisalMonthOrgScoreEntity entity) {

		return appraisalMonthOrgScoreDao.getAppraisalMonthOrgScoreByMonth(entity);
	}

	@Override
	public List<AppraisalMonthOrgScoreVo> getAppraisalMonthOrgScoreListByMonth(String month) {

		return appraisalMonthOrgScoreDao.getAppraisalMonthOrgScoreListByMonth(month);
	}

	@Override
	public Map<String, Object> getAppraisalMonthOrgScoreWithGrade(String month, String target) throws Exception {

		// 获取月度机构评分列表
		List<AppraisalMonthOrgScoreVo> scoreList = appraisalMonthOrgScoreDao
				.getAppraisalMonthOrgScoreListByMonth(month);

		// 获取所有分数线
		List<AppraisalGradeLineEntity> gradeLins = gradeLineDao.findAll();

		// 根据分数线进行分组
		Map<String, Object> returnMap = new HashMap<String, Object>();

		for (AppraisalGradeLineEntity line : gradeLins) {
			// 若在分数线内，则加入到当前分组中
			List<AppraisalMonthOrgScoreVo> gradeList = new ArrayList<AppraisalMonthOrgScoreVo>();

			for (AppraisalMonthOrgScoreVo scoreItem : scoreList) {
				// 获取item父类字节码对象
				Class<?> cls = scoreItem.getClass().getSuperclass();

				// 调用对应字段的get方法
				Method getMethod = cls.getDeclaredMethod("get" + StringUtils.captureUpName(target));

				double score = (double) getMethod.invoke(scoreItem);

				if (score >= line.getLower() && score < line.getUpper()) {
					gradeList.add(scoreItem);
				}
			}
			returnMap.put(line.getName(), gradeList);
		}

		return returnMap;
	}

	@Override
	public List<AppraisalMonthOrgScoreVo> getOrganizationScoreList(AppraisalMonthOrgScoreVo vo) {
		return appraisalMonthOrgScoreDao.getOrganizationScoreList(vo);
	}

	@Override
	public int getOrganizationScoreListCount(AppraisalMonthOrgScoreVo vo) {
		return appraisalMonthOrgScoreDao.getOrganizationScoreListCount(vo);
	}

	@Override
	public AppraisalMonthOrgScoreVo getAppraisalMonthOrgScoreByOrgId(String orgId) {
		return appraisalMonthOrgScoreDao.getAppraisalMonthOrgScoreByOrgId(orgId);
	}

	@Override
	public int insert(AppraisalMonthOrgScoreEntity entity) {
		return appraisalMonthOrgScoreDao.insert(entity);
	}

	@Override
	public int update(AppraisalMonthOrgScoreEntity entity) {
		return appraisalMonthOrgScoreDao.update(entity);
	}

	@Override
	@Transactional
	public int insert(List<AppraisalMonthSignOrgIncrementVo> list1, List<?> listPublicHealthVo, List<?> listHealthMange)
			throws Exception {
		if (list1 == null) {
			return 0;
		}
		int ok = 0;
		Checkingalgorithm cal = new Checkingalgorithm();
		List<AppraisalQuotaEntity> zb1=quotaService.getByParentId(10);//---签约指标
		List<AppraisalQuotaEntity> zb2=quotaService.getByParentId(20);//---随访体检指标
		List<AppraisalQuotaEntity> zb3=quotaService.getByParentId(30);//---健康管理指标
		List<AppraisalQuotaEntity> zb=quotaService.getByParentId(0);//---一类指标占比
		Map<String, Double> zbmap1 = cal.getMap(zb1, 2);
		try {
			List<Map<String, Object>> rlist = (List<Map<String, Object>>) cal.getSecondPeriodScore(list1,
					cal.getMap(zb1, 2), 2);


			for (Map<String, Object> map : rlist) {
				MaptoBeanVo vo = (MaptoBeanVo) BeanUtils.mapToObject(map, MaptoBeanVo.class);
				AppraisalMonthOrgScoreEntity xo = mapper.map(vo, AppraisalMonthOrgScoreEntity.class);
				Double result = xo.getSignManageScore() * zbmap1.get("signManageScore");//加全平均值需要加入后兩項todo
				xo.setResultScore(result);
				xo.setCreateTime(new Date());
				int inInt = appraisalMonthOrgScoreDao.insert(xo);
				ok=ok+inInt;
				if(inInt==0){
					throw new RuntimeException();
					
				}
			}

		} catch (IllegalArgumentException | IllegalAccessException | NoSuchMethodException | SecurityException
				| InvocationTargetException e) {
			e.printStackTrace();
		}

		return ok;
	}

	@Override
	public int insert(List<HospitalEntity> list, String month) throws IllegalArgumentException, IllegalAccessException {
		int ok=0;
		
		for (HospitalEntity hospitalEntity : list) {
			//获取团队数量
			if(hospitalEntity!=null){
				int teams=appraisalMonthOrgScoreDao.getTeamCount(hospitalEntity.getId());
				//获取各项得分,封装查询参数
				Map<String,Object> map=new HashMap<String,Object>();
				map.put("orgId", hospitalEntity.getId());
				map.put("month", month);
				AppraisalMonthOrgScoreEntity secondScore=appraisalMonthOrgScoreDao.getScoreByOrgIdAndMonth(map);
				System.out.println(JsonUtils.getJsonFormat(secondScore));
				if(secondScore!=null){
					//计算二类指标的最终得分
					Double signManageScore=0.0;
					Double publicHealthScore=0.0;
					Double healthManageScore=0.0;
					Checkingalgorithm cal = new Checkingalgorithm();
					List<AppraisalQuotaEntity> zb1=quotaService.getByParentId(10);//---签约指标
					List<AppraisalQuotaEntity> zb2=quotaService.getByParentId(20);//---随访体检指标
					List<AppraisalQuotaEntity> zb3=quotaService.getByParentId(30);//---健康管理指标
					Map<String, Double> zbmap1 = cal.getMap(zb1, 2);
					Map<String, Double> zbmap2 = cal.getMap(zb2, 2);
					Map<String, Double> zbmap3 = cal.getMap(zb3, 2);
					Field[] fields = secondScore.getClass().getDeclaredFields();
					for (int j = 0; j < fields.length; j++) {
						Field field = fields[j];
						field.setAccessible(true); // 设置些属性是可以访问的
						if (field != null) {
							if ("orgId".equals(field.getName()) || "signIncrement".equals(field.getName())|| "familyIncrement".equals(field.getName())) {
								//
							} else {
								String type = field.getGenericType().toString();
								if (type.equals("class java.lang.Double")||type.equals("double")) {
									if(!(field.get(secondScore)==null)){
										Double value = (Double) field.get(secondScore);
										if(zbmap1.get(field.getName())!=null){
											value = value * (zbmap1.get(field.getName()));
											signManageScore = signManageScore+value;//最后取长度
										}
										if(zbmap2.get(field.getName())!=null){
											value = value * (zbmap2.get(field.getName()));
											publicHealthScore = publicHealthScore+value;//最后取长度
										}
										if(zbmap3.get(field.getName())!=null){
											value = value * (zbmap3.get(field.getName()));
											healthManageScore = healthManageScore+value;//最后取长度
										}
									
									}
								}
								
							}
						}
					}
					//计算最后得分
					List<AppraisalQuotaEntity> zb=quotaService.getByParentId(0);//---健康管理指标
					Map<String, Double> zbmap = cal.getMap(zb, 2);
					Double resultScore=signManageScore*zbmap.get("signManageScore")+publicHealthScore*zbmap.get("publicHealthScore")+healthManageScore*zbmap.get("healthManageScore");
					//得到的对象
					secondScore.setOrgId(hospitalEntity.getId());
					secondScore.setSignManageScore(signManageScore);
					secondScore.setPublicHealthScore(publicHealthScore);
					secondScore.setHealthManageScore(healthManageScore);
					secondScore.setTeamTotal(teams);
					//优秀的团队
					//1.查找优秀的最低分数线
					AppraisalGradeLineEntity gradeLine=gradeLineDao.getExcellentGradeLine();
					//2.查找分数高于或等于最低分数线的团队数量
					map.put("lowerLine", gradeLine.getLower());
					int goodTeams=appraisalMonthOrgScoreDao.getGoodteams(map);
					secondScore.setExcellentIncrement(goodTeams);
					//不优秀团队
					//1.不优秀团队的最低分数线
					map.put("unLine", gradeLineDao.getUnQualified_incrementGradeLine().getUpper());
					//2.查找分数小于或等于最低分数线的团队数量
					int unQualified=appraisalMonthOrgScoreDao.getGoodteams(map);
					secondScore.setUnQualifiedIncrement(unQualified);
					//合格的团队
					secondScore.setQualifiedIncrement(teams-unQualified-goodTeams);
					//插入数据
					 ok=ok+appraisalMonthOrgScoreDao.insert(secondScore);
					
				}
				
			}
			
		}
		return ok;
	}

	@Override
	public int getTeamCount(String orgId) {
		return appraisalMonthOrgScoreDao.getTeamCount(orgId);
	}

	@Override
	public AppraisalMonthOrgScoreEntity getScoreByOrgIdAndMonth(Map map) {
		
		return appraisalMonthOrgScoreDao.getScoreByOrgIdAndMonth(map);
	}

}
