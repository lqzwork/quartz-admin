package com.ffxl.platform.util.utf8;



import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

import org.apache.commons.lang.StringUtils;

public class Utf8Mb4Utils {
	
	/**
	  * 检测是否有emoji字符
	  * @param source
	  * @return 一旦含有就抛出
	  */
	  public static boolean containsEmoji(String source) {
	  if (StringUtils.isBlank(source)) {
	  return false;
	  }
	  
	  int len = source.length();
	  
	  for (int i = 0; i < len; i++) {
	  char codePoint = source.charAt(i);
	  
	  if (isEmojiCharacter(codePoint)) {
	  //do nothing，判断到了这里表明，确认有表情字符
	  return true;
	  }
	  }
	  
	  return false;
	  }
	  
	  private static boolean isEmojiCharacter(char codePoint) {
	  return (codePoint == 0x0) ||
	  (codePoint == 0x9) ||
	  (codePoint == 0xA) ||
	  (codePoint == 0xD) ||
	  ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) ||
	  ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) ||
	  ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
	  }
	  
	  /**
	  * 过滤emoji 或者 其他非文字类型的字符
	  * @param source
	  * @return
	  */
	  public static String filterEmoji(String source) {
	  
	  if (!containsEmoji(source)) {
	  return source;//如果不包含，直接返回
	  }
	  //到这里铁定包含
	  StringBuilder buf = null;
	  
	  int len = source.length();
	  
	  for (int i = 0; i < len; i++) {
	  char codePoint = source.charAt(i);
	  
	  if (isEmojiCharacter(codePoint)) {
	  if (buf == null) {
	  buf = new StringBuilder(source.length());
	  }
	  
	  buf.append(codePoint);
	  } else {
	  }
	  }
	  
	  if (buf == null) {
	  return source;//如果没有找到 emoji表情，则返回源字符串
	  } else {
	  if (buf.length() == len) {//这里的意义在于尽可能少的toString，因为会重新生成字符串
	  buf = null;
	  return source;
	  } else {
	  return buf.toString();
	  }
	  }
	  
	  }
	
	public static String filterOffUtf8Mb4(String text) 
		        throws UnsupportedEncodingException 
		    { 
			//return text;
		 	//return filterEmoji(text);
		  		if(text ==null){
		  			return text;
		  		}
		        byte[] bytes = text.getBytes("utf-8"); 
		        ByteBuffer buffer = ByteBuffer.allocate(bytes.length); 
		        int i = 0; 
		        while (i < bytes.length) 
		        { 
		            short b = bytes[i]; 
		            if (b > 0) 
		            { 
		                buffer.put(bytes[i++ ]); 
		                continue; 
		            } 
		            b += 256; 
		            if ((b ^ 0xC0) >> 4 == 0) 
		            { 
		                buffer.put(bytes, i, 2); 
		                i += 2; 
		            } 
		            else if ((b ^ 0xE0) >> 4 == 0) 
		            { 
		                buffer.put(bytes, i, 3); 
		                i += 3; 
		            } 
		            else if ((b ^ 0xF0) >> 4 == 0) 
		            { 
		                i += 4; 
		            } 
		            //添加处理如b的指为-48等情况出现的死循环 
		            else 
		            { 
		                buffer.put(bytes[i++ ]); 
		                continue; 
		            } 
		        } 
		        buffer.flip(); 
		        return new String(buffer.array(), "utf-8"); 
		         
		    } 
	
}
