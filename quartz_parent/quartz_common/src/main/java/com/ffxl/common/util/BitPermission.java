package com.ffxl.common.util;


import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.Permission;

/**
 * 
 * 2的幂次计算工具
 */
public class BitPermission implements  Permission {
	
	public String resourceIdentify;  
	public int permissionBit;  //操作之和
    public String instanceId;  
    public BitPermission(String permissionString) {  
        String[] array = permissionString.split("\\+");  
        if(array.length > 1) {  
            resourceIdentify = array[1];  
        }  
        if(StringUtils.isEmpty(resourceIdentify)) {  
            resourceIdentify = "*";  
        }  
        if(array.length > 2) {  
            permissionBit = Integer.valueOf(array[2]);  
        }  
        if(array.length > 3) {  
            instanceId = array[3];  
        }  
        if(StringUtils.isEmpty(instanceId)) {  
            instanceId = "*";  
        }  
    }  
  
    public boolean implies(Permission p) {  
        if(!(p instanceof BitPermission)) {  
            return false;  
        }  
        BitPermission other = (BitPermission) p;  
        if(!("*".equals(this.resourceIdentify) || this.resourceIdentify.equals(other.resourceIdentify))) {  
            return false;  
        }  
        if(!(this.permissionBit ==0 || (this.permissionBit & other.permissionBit) != 0)) {  
            return false;  
        }  
        if(!("*".equals(this.instanceId) || this.instanceId.equals(other.instanceId))) {  
            return false;  
        }  
        return true;  
    }  
}
