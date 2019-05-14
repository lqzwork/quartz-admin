package com.ffxl.common.util;

import java.util.HashMap;
import java.util.Map;

public class JsonResult {
	public static final String DEPRECATED_STATUS = "-1";

    public static final String SUCCESS_STATUS = "2000";

    public static final String FAIL_STATUS = "5000";
    
    public static final String AUTHORIZE_STATUS = "1000";

    /**
     * 
     */
    private String module;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误消息
     */
    private String message;

    /**
     * 数据
     */
    private Object data;
    
    

    /**
     * 附加数据
     */
    private Map<String, Object> extraData = new HashMap<String, Object>();


    public JsonResult() {
        this(Boolean.TRUE);
    }

    /**
     * 
     * @param success
     */
    public JsonResult(boolean success) {
        this.code = success ? "2000" : "5000";
        this.message = Message.getMessage(this.code);
        this.data = null;
    }

    /**
     * 
     * @param data
     */
    public JsonResult(boolean success, Object data) {
        this.code = success ? "2000" : "5000";
        this.message = Message.getMessage(this.code);
        this.data = data;
    }

    /**
     *
     * 
     * @param success
     * @param message
     * @param data
     */
    public JsonResult(boolean success, String message, Object data) {
        this.code = success ? "2000" : "5000";
        this.message = message;
        this.data = data;
    }

    /**
     * 
     * @param code
     */
    public JsonResult(String code) {
        this.code = code;
        this.message = Message.getMessage(this.code);
        this.data = null;
    }

    /**
     * 
     * @param code
     * @param data
     */
    public JsonResult(String code, Object data) {
        this.code = code;
        this.message = Message.getMessage(this.code);
        this.data = data;

    }

 
    /**
     * 
     * 
     * @param code
     * @param message
     * @param data
     */
    public JsonResult(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getExtraData() {
        return extraData;
    }

    public void addExtra(String key, Object value) {
        if (this.extraData == null) {
            this.extraData = new HashMap<String, Object>();
        }
        this.extraData.put(key, value);
    }

    public boolean isSuccess() {
        return this.code.equals("2000");
    }

    @Override
    public String toString() {
        return "JsonResult [module=" + module + ", code=" + code + ", message=" + message + ", data=" + data
                + ", extraData=" + extraData + "]";
    }
}
