package com.boco.modules.fdoc.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Checkingalgorithm {
	
	
	public <T> Map<String,Integer> getZr(List<T> list,Integer toatal) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException{
		
//		if(list!=null){
//			for(T obj:list){
//				Integer valueList=0;
//				Field[] fields=obj.getClass().getDeclaredFields();
//				if ( fields != null )  {
//					for (Field field : fields) {
//						if(field!=null){
//							  String type = field.getGenericType().toString();  //field.getName();field.get(obj);
//							  if (type.equals("class java.lang.Integer")) {  
//				                    Method m = obj.getClass().getMethod("get" + field.getName());  
//				                    Integer value = (Integer) m.invoke(obj);  
//				                    if (value != null) {  
//				                            System.out.println("属性值为：" + value);  
//				                    } else {  
//				                            System.out.println("属性值为：空");  
//				                    }  
//				              }  
//							  
//						}
//					}
//				}
//				
//			}
//		}
//		
		
		//每项总和数据
		Map<String,Integer> maps=new HashMap<String, Integer>();	
		for (int i = 0; i < list.size(); i++) {
			Field[] fields=list.get(i).getClass().getDeclaredFields();
			for (int j = 0; j < fields.length; j++) {
				Field field = fields[j];
				if(field!=null){
					  String type = field.getGenericType().toString();  //field.getName();field.get(obj);
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
	
		// 每项平均值
		Map<String,Integer> avgmaps=new HashMap<String, Integer>();	
	    
		Field[] fieldx=list.get(0).getClass().getDeclaredFields();
		for (int j = 0; j < fieldx.length; j++) {
			Field field = fieldx[j];
			if(field!=null){
				  String type = field.getGenericType().toString();  //field.getName();field.get(obj);
				  if (type.equals("class java.lang.Integer")) {  
					  avgmaps.put(field.getName(), maps.get(field.getName())/list.size());  
	              }  
				  
			}
			
		}
		//每项得分
		List slist=new ArrayList<>();
		//每项最高分后得到的区间值
		Map<String,Double> Highmap=new HashMap<String, Double>();
		for (int i = 0; i < list.size(); i++) {
			Map<String,Double> xmap=new HashMap<String, Double>();	
			Field[] fields=list.get(i).getClass().getDeclaredFields();
			for (int j = 0; j < fields.length; j++) {
				Field field = fields[j];
				if(field!=null){
					  String type = field.getGenericType().toString();  //field.getName();field.get(obj);
					  if (type.equals("class java.lang.Integer")) {  
		                    Integer value = (Integer) field.get(list.get(i)); 
		                    if(value==null){
		                    	value=0;
		                    }
		                Double xscore= (double) (value/avgmaps.get(field.getName())*100);
		                xmap.put(field.getName(), xscore);
		                //得到最高分
		                if (Highmap.containsKey(field.getName())){
		                	if((Double)Highmap.get(field.getName())<xscore){
		                		Highmap.put(field.getName(), xscore/100);
		                	}
                        } else{
                        	Highmap.put(field.getName(), xscore/100);
                        }   
		              }  
				}
			}
			slist.add(xmap);
		}
		
		
		return null;
		
	}
	
	
	

}
