package com.boco.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * map与对象互转
 * 
 * @author j
 *
 * @date 2017年8月10日
 */
public class BeanUtils {
	private final static Logger log=(Logger) LoggerFactory.getLogger(BeanUtils.class);
	
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
    

    
    /**
     * 合并对象(无编译时型别检查版),将src的值合并入des，如果值为null，则不覆盖 (使用时请确认需要合并的两个对象的field的定义一致!!)
     * @param srcObj source Object
     * @param desObj destine Object
     */
    @SuppressWarnings("rawtypes")
	public static void mergeObject_diff(Object srcObj, Object desObj) {
	     if(srcObj == null || desObj == null) return;
	     
	     Class srcObjcz=srcObj.getClass().getSuperclass();
	     Class desObjcz=desObj.getClass().getSuperclass();
	     Field[] fs1=null;
	     Field[] fs2=null;
	     if(srcObjcz.toString().equals("class java.lang.Object")){//没有继承某个类
	        fs1= srcObj.getClass().getDeclaredFields();
	     	
	     }else{//继承了 
	     	fs1 = srcObj.getClass().getSuperclass().getDeclaredFields();
	     }
	     if(desObjcz.toString().equals("class java.lang.Object")){//没有继承某个类
	         fs2= srcObj.getClass().getDeclaredFields();
	      	
	      }else{//继承了 
	      	fs2 = srcObj.getClass().getSuperclass().getDeclaredFields();
	      }
	      for (int i=0; i<fs1.length; i++) {
		      try{
		       fs1[i].setAccessible(true);
		       Object value = fs1[i].get(srcObj);
		       fs1[i].setAccessible(false);
		       if(null != value){
		        fs2[i].setAccessible(true);
		        fs2[i].set(desObj, value);
		        fs2[i].setAccessible(false);
		       }
		      }catch(Exception e){
		       log.error(e.toString());
		      }
	     }
    }

}
