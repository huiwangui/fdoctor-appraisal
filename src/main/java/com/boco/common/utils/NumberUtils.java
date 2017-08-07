package com.boco.common.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NumberUtils {
	/**
	 * double四舍五入
	 * 
	 * @param num
	 *            目标double
	 * @param length
	 *            保留小数点后位数
	 * @return
	 */
	public static double roundHalfUp(double num, int length) {
		double f = num;
		BigDecimal b = new BigDecimal(f);
		double f1 = b.setScale(length, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1;
	}

	/**
	 * 
	 * bitand:(把2的幂次方数分解为几个单独的数，组成字符串用逗号隔开。比如传入19，返回1,2,16). <br/>
	 * 
	 * @author q
	 * @param itemNum
	 * @return
	 */
	public static String bitand(int itemNum) {
		int sum = itemNum;
		if (sum == 0) {
			sum = 1;
		}
		int j = 0;
		String returnStr = "";
		// 这里需要预先指定sum最大的位数，这里假设11（SUM最大由11位组成）
		for (int i = 0; i < 26; ++i) {
			j = (sum >>> i) % 2; // 取出右移的那一位
			j = j << i; // j * 2的次幂 = 当前的十进制数
			if (j > 0) {
				returnStr = returnStr + j + ",";
			}
		}
		return returnStr.substring(0, returnStr.length() - 1);
	}

	/**
	 * 
	 * bitand:(把2的幂次方数分解为几个单独的数，组成字符串用逗号隔开。比如传入19，返回[1,2,16]). <br/>
	 * 
	 * @author q
	 * @param itemNum
	 * @return
	 */
	public static List<Integer> bitandArray(int itemNum) {
		int sum = itemNum;
		if (sum == 0) {
			sum = 1;
		}
		int j = 0;
		List<Integer> list = new ArrayList<Integer>();
		// 这里需要预先指定sum最大的位数，这里假设11（SUM最大由11位组成）
		for (int i = 0; i < 26; ++i) {
			j = (sum >>> i) % 2; // 取出右移的那一位
			j = j << i; // j * 2的次幂 = 当前的十进制数
			if (j > 0) {
				list.add(j);
			}
		}
		return list;
	}
	
	/**
	 * 整数间除法运算
	 * @param dividend 被除数
	 * @param divisor 除数
	 * @param length 保留小数点后位数
	 */
	public static Double division(int dividend, int divisor, int length){
		//除数为0， 直接返回0
		if (divisor == 0) {
			return 0.0;
		}else {
			Double result = Double.valueOf(dividend) / Double.valueOf(divisor);
			//保留小数位数运算
			return roundHalfUp(result, length);
		}
	}
	
	/**
	 * 小数间除法运算
	 * @param dividend 被除数
	 * @param divisor 除数
	 * @param length 保留小数点后位数
	 */
	public static Double division(double dividend, double divisor, int length){
		//除数为0， 直接返回0
		if (divisor == 0) {
			return 0.0;
		}else {
			Double result = dividend / divisor;
			//保留小数位数运算
			return roundHalfUp(result, length);
		}
	}
}
