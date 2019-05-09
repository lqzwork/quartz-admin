package com.ffxl.platform.config;

import java.util.Properties;

public class CommonProperties {
    //通用配置参数
    public static Properties commonProperties;

    public static Properties getCommonProperties() {
        return commonProperties;
    }

    public static void setCommonProperties(Properties commonProperties) {
        CommonProperties.commonProperties = commonProperties;
    }

   
    
}
