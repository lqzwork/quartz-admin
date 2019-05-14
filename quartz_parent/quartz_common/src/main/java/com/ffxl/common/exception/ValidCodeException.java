package com.ffxl.common.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 验证码自定义异常
 */
public class ValidCodeException extends AuthenticationException {  
	private static final long serialVersionUID = 1L;

	public ValidCodeException(String msg){  
        super(msg);  
    }  
}  
