package com.boco.modules.fdoc.common;

import java.util.List;
import java.util.Map;
/**
 * 
 * 分数计算
 * @author j
 *
 * @date 2017年8月9日
 */
public interface Calculation {
	
	
   /**
    * 此方法要求 map中的key值和Class的成员变量名一致
    * @param list 原始对象
    * @param zbMap 占比集合 
    * @param length 小数点位数
    * @return
    * @throws Exception
    *
    */
	<T> Object getSecondPeriodScore(List<T> list, Map<String, Double> zbMap,int length) throws Exception;
	/**
	 * 一类指标算法
	 * @param list
	 * @param zbMap
	 * @param length
	 * @return
	 *
	 */
	public Object getOnePeriodScore(List<Map<String,Object>> list, Map<String, Double> zbMap, int length);
			

}
