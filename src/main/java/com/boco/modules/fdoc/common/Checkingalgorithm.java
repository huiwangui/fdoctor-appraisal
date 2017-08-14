package com.boco.modules.fdoc.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.boco.common.constants.BusinessConstants;
import com.boco.common.utils.JsonUtils;
import com.boco.common.utils.NumberUtils;
import com.boco.modules.fdoc.model.system.AppraisalQuotaEntity;

public class Checkingalgorithm implements Calculation {
	
	
	Logger log =LoggerFactory.getLogger(this.getClass());
	/**
	 * 
	 * 二类指标算法
	 * 
	 * @param list
	 * @param length
	 *            小数点位数
	 * @param zbMap
	 *            key值需要和传入的 list里对象的属性相同相对应
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 *
	 */
	@SuppressWarnings("unused")
	@Override
	public <T> List<Map<String,Object>> getSecondPeriodScore(List<T> list, Map<String, Double> zbMap, int length)
			throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException,
			InvocationTargetException {

		// 每项总和数据maps
		List<Map<String, Double>> listone = new ArrayList<Map<String, Double>>(list.size());
		Map<String, Double> maps = new HashMap<String, Double>();
		for (int i = 0; i < list.size(); i++) {
            Class supercz=list.get(i).getClass().getSuperclass();
            Field[] fields=null;
            if(supercz.toString().equals("class java.lang.Object")){//没有继承某个类
            	fields = list.get(i).getClass().getDeclaredFields();
            	
            }else{//继承了 
            	fields = list.get(i).getClass().getSuperclass().getDeclaredFields();
            }
        	for (int j = 0; j < fields.length; j++) {
				Field field = fields[j];
				field.setAccessible(true); // 设置些属性是可以访问的
				if (field != null) {
					if ("id".equals(field.getName())) {
						//
					} else {
						
						String type = field.getGenericType().toString();
						if (type.equals("class java.lang.Integer")||type.equals("int")) {
							if(!(field.get(list.get(i))==null)){
								Double value = Double.parseDouble((String) String.valueOf(field.get(list.get(i))));
								if (maps.containsKey(field.getName())) {
									maps.put(field.getName(), maps.get(field.getName()) + value);
								} else {
									maps.put(field.getName(), value);
								}
							}
						}
						
					}
				}
			}
		

		}
		//System.out.println("每项总和"+JsonUtils.getJsonFormat(maps));

		// 每项平均值
		Map<String, Double> avgmaps = new HashMap<String, Double>();
		for (Map.Entry<String, Double> entry : maps.entrySet()) {
			avgmaps.put(entry.getKey(), NumberUtils.division(entry.getValue(),
					Double.parseDouble((String) String.valueOf(list.size())), 8));// 结果为Double
		//	avgmaps.put(entry.getKey(), entry.getValue()/Double.parseDouble((String) String.valueOf(list.size())));
		}
		
		//System.out.println("每项平均值"+JsonUtils.getJsonFormat(avgmaps));
		
		
		
		// 每项得分(未处理区间值)slist
		List<Map<String, Object>> slist = new ArrayList<Map<String, Object>>(list.size());
		// 每项最高分后得到的区间值
		Map<String, Double> Highmap = new HashMap<String, Double>();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> xmap = new HashMap<String, Object>();
		    Class supercz=list.get(i).getClass().getSuperclass();
            Field[] fields=null;
            if(supercz.toString().equals("class java.lang.Object")){//没有继承某个类
            	fields = list.get(i).getClass().getDeclaredFields();
            }else{//继承了 
            	fields = list.get(i).getClass().getSuperclass().getDeclaredFields();
            }
			for (int j = 0; j < fields.length; j++) {
				Field field = fields[j];
				field.setAccessible(true); // 设置些属性是可以访问的
				if (field != null) {
					if ("teamId".equals(field.getName()) || "orgId".equals(field.getName())|| "familyIncrement".equals(field.getName())) {
						xmap.put(field.getName(),  field.get(list.get(i)));
					} else {
                        if("signIncrement".equals(field.getName())){
                        	xmap.put(field.getName(),  field.get(list.get(i)));
                        }
						if (!"id".equals(field.getName())) {
							String type = field.getGenericType().toString();
							if (type.equals("class java.lang.Integer")||type.equals("int")) {
								if(!(field.get(list.get(i))==null)){
									Double value = Double.parseDouble((String) String.valueOf(field.get(list.get(i))));
									//System.out.println("TEST===="+value);
									Double xscore = (double) ((NumberUtils.division(value, avgmaps.get(field.getName()),
											8)) * 100);// 原始得分
									xmap.put(field.getName()+"ScoreYS", xscore);
									// 得到最高分算区间值 ：100/最高分=区间值
									if (Highmap.containsKey(field.getName()+"ScoreYS")) {
										if ((Double) Highmap.get(field.getName()+"ScoreYS") >(NumberUtils.division(100, xscore, 8))) {
											//Highmap.put(field.getName(), NumberUtils.division(100, xscore, 8));
											//System.out.println("小的分数："+Highmap.get(field.getName()+"ScoreYS"));
											//Highmap.put(field.getName()+"ScoreYS",100/xscore);
											Highmap.put(field.getName()+"ScoreYS",NumberUtils.division(100, xscore, 8));
											//System.out.println("大的分数："+Highmap.get(field.getName()+"ScoreYS"));
										}
									} else {
										Highmap.put(field.getName()+"ScoreYS", NumberUtils.division(100, xscore, 8));// 区间值
										 // Highmap.put(field.getName()+"ScoreYS",100/xscore);
									}
								}
							}
							if (type.equals("class java.util.Date")||type.equals("class java.lang.String")) {//----假日日期格式的
								xmap.put(field.getName(),field.get(list.get(i)));
							}
						} else {
							xmap.put("id", field.get(list.get(i)));
						}

					}

				}
			}
			slist.add(xmap);
		}
		
		//System.out.println("每项未区间前的得分"+JsonUtils.getJsonFormat(slist));

		System.out.println("区间值"+JsonUtils.getJsonFormat(Highmap));


		// 处理区间值后的得到的得分 原始得分*区间值
		// 经过区间处理后
		List<Map<String, Object>> qjscorelist = new ArrayList<Map<String, Object>>(list.size());
		for (Map<String, Object> ysmap : slist) {
			Map<String, Object> endmap = new HashMap<String, Object>();
			for (Map.Entry<String, Object> entry : ysmap.entrySet()) {
				if ("teamId".equals(entry.getKey()) || "orgId".equals(entry.getKey())||"createTime".equals(entry.getKey())||
				    "familyIncrement".equals(entry.getKey())||"signIncrement".equals(entry.getKey())||("month".equals(entry.getKey()))) {
					endmap.put(entry.getKey(),  entry.getValue());
				} else {
					 
					if (!"id".equals(entry.getKey())) {
						//System.out.println(entry.getKey());
						Double value = (Double) entry.getValue();
						Double endscore = (double) (value * Highmap.get(entry.getKey()));// 区间过后的每项得分
						endscore = NumberUtils.roundHalfUp(endscore, length);
						endmap.put(entry.getKey().substring(0,entry.getKey().length()-7)+"Score", endscore);
					} else {
						endmap.put(entry.getKey(), entry.getValue());
					}

				}

			}
			qjscorelist.add(endmap);

		}

		//System.out.println("每项区间后得分"+JsonUtils.getJsonFormat(qjscorelist));

		// 计算最后得分 需要签约二类占比*区间+
		// 存放最后得分的list
		List<Map<String, Object>> resultlist = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> map : qjscorelist) {
			Map<String, Object> resultMap = new HashMap<String, Object>();
			for (Map.Entry<String, Object> entry : map.entrySet()) {

				if ("teamId".equals(entry.getKey()) || "orgId".equals(entry.getKey())||"createTime".equals(entry.getKey())||
				   "familyIncrement".equals(entry.getKey())||"signIncrement".equals(entry.getKey())||("month".equals(entry.getKey()))) {
					resultMap.put(entry.getKey(),  entry.getValue());
				} else {
					 
					if (!"id".equals(entry.getKey())) {
						resultMap.put(entry.getKey(), entry.getValue());
						Double value = (Double) Double.valueOf(String.valueOf(entry.getValue()));
						if (zbMap.get(entry.getKey()) != null) {
							System.out.println(zbMap.get(entry.getKey()));
							value = value * (zbMap.get(entry.getKey()));
							value = NumberUtils.roundHalfUp(value, length);//最后取长度
							if (resultMap.containsKey("resultScore")) {
								resultMap.put("resultScore", (Double) resultMap.get("resultScore") + value);
							} else {
								resultMap.put("resultScore", value);
							}

						}
					} else {
						resultMap.put(entry.getKey(), entry.getValue());
					}

				}

			}
			resultlist.add(resultMap);
		}
	//	System.out.println("最终后得分"+JsonUtils.getJsonFormat(resultlist));
		//Map<String, Object> returnMap = new HashMap<String, Object>();
		//returnMap.put("items", qjscorelist);
		//returnMap.put("score", resultlist);
		return resultlist;

	}

	
	//一类算法   
	@Override
	public Object getOnePeriodScore(List<Map<String,Object>> list, Map<String, Double> zbMap, int length){
		List<Map<String, Object>> resultlist = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> map : list) {
			Map<String, Object> resultMap = new HashMap<String, Object>();
			for (Map.Entry<String, Object> entry : map.entrySet()) {

				if ("teamId".equals(entry.getKey()) || "orgId".equals(entry.getKey())||"createTime".equals(entry.getKey())||
						   "familyIncrement".equals(entry.getKey())||"signIncrement".equals(entry.getKey())||("month".equals(entry.getKey()))) {
				} else {
					if (!"id".equals(entry.getKey())) {

						Double value = (Double) Double.valueOf(String.valueOf(entry.getValue()));
						if (zbMap.get(entry.getKey()) != null) {
							value = value * (zbMap.get(entry.getKey()));
							value = NumberUtils.roundHalfUp(value, length);
							if (resultMap.containsKey("ResultScore")) {
								resultMap.put("ResultScore", (Double) resultMap.get("ResultScore") + value);
							} else {
								resultMap.put("ResultScore", value);
							}

						}
					} else {
						resultMap.put(entry.getKey(), entry.getValue());
					}

				}

			}
			resultlist.add(resultMap);
		}

		
		
		return resultlist;
		
	}
	/**
	 * 查到的指标转换成MAP
	 * @param list
	 * @param length
	 * @return
	 *
	 */
	public static Map<String, Double> getMap(List<AppraisalQuotaEntity> list, int length) {

		Map<String, Double> map = new HashMap<String, Double>();
		for (AppraisalQuotaEntity entity : list) {
			switch (entity.getName()) {
			case BusinessConstants.SIGN_ADMIN:
				map.put("signManageScore", (double) NumberUtils.division(entity.getRate(), 100, length));
				break;
			case BusinessConstants.SIGN_COUNT:
				map.put("signIncrementScore", (double) NumberUtils.division(entity.getRate(), 100, length));
				break;
			case BusinessConstants.SIGN_HY:
				map.put("hyperIncrementScore", (double) NumberUtils.division(entity.getRate(), 100, length));
				break;
			case BusinessConstants.SIGN_DIA:
				map.put("diabetesIncrementScore", (double) NumberUtils.division(entity.getRate(), 100, length));
				break;
			case BusinessConstants.SIGN_MAT:
				map.put("maternalIncrementScore", (double) NumberUtils.division(entity.getRate(), 100, length));
				break;
			case BusinessConstants.SIGN_OLD:
				map.put("oldIncrementScore", (double) NumberUtils.division(entity.getRate(), 100, length));
				break;
			case BusinessConstants.SIGN_CHI:
				map.put("childrenIncrementScore", (double) NumberUtils.division(entity.getRate(), 100, length));
				break;
			case BusinessConstants.SIGN_ZXJ:
				map.put("phychosisI11ncrementScore", (double) NumberUtils.division(entity.getRate(), 100, length));
				break;
				
			case BusinessConstants.UP_ADMIN:
				map.put("publicHealthScore", (double) NumberUtils.division(entity.getRate(), 100, length));
				break;
			case BusinessConstants.UP_COUNT:
				map.put("serviceIncrementScore", (double) NumberUtils.division(entity.getRate(), 100, length));
				break;
			case BusinessConstants.UP_HY:
				map.put("hyperIncrementScore", (double) NumberUtils.division(entity.getRate(), 100, length));
				break;
			case BusinessConstants.UP_DIA:
				map.put("diabetesIncrementScore", (double) NumberUtils.division(entity.getRate(), 100, length));
				break;
			case BusinessConstants.UP_MAT:
				map.put("maternalIncrementScore", (double) NumberUtils.division(entity.getRate(), 100, length));
				break;
			case BusinessConstants.UP_OLD:
				map.put("oldIncrementScore", (double) NumberUtils.division(entity.getRate(), 100, length));
				break;
			case BusinessConstants.UP_CHI:
				map.put("childrenIncrementScore", (double) NumberUtils.division(entity.getRate(), 100, length));
				break;
			case BusinessConstants.UP_ZX:
				map.put("phychosisIncrementScore", (double) NumberUtils.division(entity.getRate(), 100, length));
				break;

			case BusinessConstants.HEALTH_ADMIN:
				map.put("healthManageScore", (double) NumberUtils.division(entity.getRate(), 100, length));
				break;
			case BusinessConstants.HEALTH_EDU:
				map.put("educationIncrementScore", (double) NumberUtils.division(entity.getRate(), 100, length));
				break;
			case BusinessConstants.HEALTH_WZ:
				map.put("dailyActivityScore", (double) NumberUtils.division(entity.getRate(), 100, length));
				break;
			case BusinessConstants.HEALTH_CP:
				map.put("assessmentIncrementScore", (double) NumberUtils.division(entity.getRate(), 100, length));
				break;
			case BusinessConstants.HEALTH_DOC:
				map.put("documentIncrementScore", (double) NumberUtils.division(entity.getRate(), 100, length));
				break;

			}

		}

		return map;

	}
	
	

}
