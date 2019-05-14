package com.ffxl.common.util;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

public class SystemUtil {
    
    /**
     * 图片文件类型枚举
     * 
     * @author liqz and liyj
     *
     */
    public enum ImgEnum  {
        BMP, PCX, PNG,JPG, JPEG, GIF, TIFF ,PSD, SWF, SVG ;
    }
    
    /**
     * 音频文件类型枚举
     * 
     * @author liqz and liyj
     *
     */
    public enum SoundEnum  {
        CD, OGG, MP3, ASF, WMA, WAV, MP3PRO, RM, REAL, MIDI ;
    }
    
    
    /** 
     * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址, 
     * 参考文章： http://developer.51cto.com/art/201111/305181.htm 
     *  
     * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？ 
     * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。 
     *  
     * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130, 
     * 192.168.1.100 
     *  
     * 用户真实IP为： 192.168.1.110 
     *  
     * @param request 
     * @return 
     */  
    public static String getIpAddress(HttpServletRequest request) {  
        String ip = request.getHeader("x-forwarded-for");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }  
        return ip;  
    }  
      
    public static BigDecimal getSaleAmount(int level, BigDecimal payAmount){
    	final double level1 = 0.15;
    	final double level2 = 0.1;
    	final double level3 = 0.05;
    	BigDecimal saleAmount = BigDecimal.ZERO;
    	switch (level) {
		case 1:
			saleAmount = payAmount.multiply(BigDecimal.valueOf(level1));
			break;
		case 2:
			saleAmount = payAmount.multiply(BigDecimal.valueOf(level2));
			break;	
		case 3:
			saleAmount = payAmount.multiply(BigDecimal.valueOf(level3));
			break;
		default:
			break;
		}
    	return saleAmount;
    }
    

}
