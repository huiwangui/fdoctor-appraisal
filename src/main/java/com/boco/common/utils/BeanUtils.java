package com.boco.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * map与对象互转
 * 
 * @author j
 *
 * @date 2017年8月10日
 */
public class BeanUtils {
	
	
	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {    
        if (map == null)  
            return null;    
  
        Object obj = beanClass.newInstance();  
        
        Class supercz=obj.getClass().getSuperclass();
        Field[] fields=null;
        if(supercz.toString().equals("class java.lang.Object")){
        	fields = obj.getClass().getDeclaredFields();
        	
        }else{ 
        	fields = obj.getClass().getSuperclass().getDeclaredFields();
        }
        for (Field field : fields) {    
            int mod = field.getModifiers();    
            if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){    
                continue;    
            }    
            field.setAccessible(true);    
            String type = field.getGenericType().toString();
            
		
           // if ("teamId".equals(field.getName()) || "orgId".equals(field.getName())|| "familyIncrement".equals(field.getName())) {
            	field.set(obj, map.get(field.getName()));
          //  }
             
        }   
  
        return obj;    
    }    
  
    public static Map<String, Object> objectToMap(Object obj) throws Exception {    
        if(obj == null){    
            return null;    
        }   
  
        Map<String, Object> map = new HashMap<String, Object>();    
  
        Field[] declaredFields = obj.getClass().getDeclaredFields();    
        for (Field field : declaredFields) {    
            field.setAccessible(true);  
            map.put(field.getName(), field.get(obj));  
        }    
  
        return map;  
    }   

}
