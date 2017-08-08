package com.boco.modules.fdoc.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.boco.modules.fdoc.model.system.AppraisalQuotaEntity;

public class Checkingalgorithm {
	/**
	 * 
	 * 
	 * @param list
	 * @param zbMap key值需要和传入的 list里对象的属性相同相对应
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 *
	 */
	
	public <T> List<Map<String,Double>> getZr(List<T> list,Map<String,Double> zbMap) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException{

		//每项总和数据maps
		List<Map<String,Integer>> listone=new ArrayList<Map<String,Integer>>();
		Map<String,Integer> maps=new HashMap<String, Integer>();	
		for (int i = 0; i < list.size(); i++) {
			Field[] fields=list.get(i).getClass().getDeclaredFields();
			for (int j = 0; j < fields.length; j++) {
				Field field = fields[j];
				if(field!=null){
					  String type = field.getGenericType().toString();  //field.getName();field.get(obj);
					  if("id".equals(field.getName())){
						 //
					  }else{
						  if (type.equals("class java.lang.Integer")) {  
			                    Integer value = (Integer) field.get(list.get(i)); 
			                    if(value==null){
			                    	value=0;
			                    }
			                  if (maps.containsKey(field.getName())){
			                	  maps.put(field.getName(),maps.get(field.getName())+value);
	                          } else{
	                        	  maps.put(field.getName(), value);
	                          }    
			                 
			              }  
					  }
				}
			}
		  
		}
	
		// 每项平均值
		Map<String,Integer> avgmaps=new HashMap<String, Integer>();	
	    for(Map.Entry<String, Integer> entry :maps.entrySet()){
	    	avgmaps.put( entry.getKey() , entry.getValue()/list.size());
	    }
		
		//每项得分(未处理区间值)
		List<Map<String,Double>> slist=new ArrayList<Map<String,Double>>();
		//每项最高分后得到的区间值
		Map<String,Double> Highmap=new HashMap<String, Double>();
		for (int i = 0; i < list.size(); i++) {
			Map<String,Double> xmap=new HashMap<String, Double>();	
			Field[] fields=list.get(i).getClass().getDeclaredFields();
			for (int j = 0; j < fields.length; j++) {
				Field field = fields[j];
				if(field!=null){
					  if(!"id".equals(field.getName())){
						  String type = field.getGenericType().toString();  //field.getName();field.get(obj);
						  if (type.equals("class java.lang.Integer")) {  
			                    Integer value = (Integer) field.get(list.get(i)); 
			                    if(value==null){
			                    	value=0;
			                    }
				                Double xscore= (double) (value/avgmaps.get(field.getName())*100);//原始得分
				                xmap.put(field.getName(), xscore);
				                //得到最高分算区间值 ：100/最高分=区间值
				                if (Highmap.containsKey(field.getName())){
				                	if((Double)Highmap.get(field.getName())<xscore){
				                		Highmap.put(field.getName(), 100/xscore);
				                	}
		                        } else{
		                        	Highmap.put(field.getName(), 100/xscore);//区间值
		                        }   
			              }  
					  }else{
						  xmap.put("id",  (Double) field.get(list.get(i)));
					  }
					 
				}
			}
			slist.add(xmap);
		}
		
		//处理区间值后的得到的得分  原始得分*区间值
		//每项得分(未处理区间值)
				List<Map<String,Double>> qjscorelist=new ArrayList<Map<String,Double>>();
				//经过区间处理后
				//Map<String,Double> Highmap=new HashMap<String, Double>();
				for (int i = 0; i < slist.size(); i++) {
					Map<String,Double> endmap=new HashMap<String, Double>();	
					Field[] fields=list.get(i).getClass().getDeclaredFields();
					for (int j = 0; j < fields.length; j++) {
						Field field = fields[j];
						if(field!=null){
							  if(!"id".equals(field.getName())){
								  String type = field.getGenericType().toString(); 
								  if (type.equals("class java.lang.Integer")) {  
					                    Integer value = (Integer) field.get(list.get(i)); 
					                    if(value==null){
					                    	value=0;
					                    }
						                Double endscore= (double) (value*Highmap.get(field.getName()));//区间过后的每项得分
						                endmap.put(field.getName(), endscore);
						               
					              }  
							  }else{
								  endmap.put("id",  (Double) field.get(list.get(i)));
							  }
							 
						}
					}
					qjscorelist.add(endmap);
				}
				
		        //计算最后得分  需要签约二类占比*区间+
				//存放最后得分的list
				//List<Map<String,Double>> resultlist=new ArrayList<Map<String,Double>>();
				for (Map<String, Double> map : qjscorelist) {
					//Map<String,Double> resultMap=new HashMap<String,Double>();
					for(Map.Entry<String, Double> entry:map.entrySet()){
						if(!"id".equals(entry.getKey())){
							Double value=entry.getValue();
							value=value*(zbMap.get(entry.getKey()));
							if (map.containsKey("resultScore")){
								map.put("resultScore", map.get("resultScore")+value);
	                        } else{
	                        	map.put("resultScore", value);
	                        }   
							
						}
					}
					
				}
				
		return qjscorelist;
		
	}
	
	
	

}
