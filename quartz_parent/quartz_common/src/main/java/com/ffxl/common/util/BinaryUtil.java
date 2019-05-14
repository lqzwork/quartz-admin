package com.ffxl.common.util;
/**
 * 二进制转换工具类
 * @author wison
 *
 */
public class BinaryUtil {
	
	// 二进制转字符串
    public static String toBinary(int bit) {
       String result = Integer.toBinaryString(bit);
       return result;
    }
    
 // 字符串转二进制
    public static int binStrToInt(String binStr) {
    	 Integer result = Integer.valueOf(binStr, 2);  
       return result;
    }
}
