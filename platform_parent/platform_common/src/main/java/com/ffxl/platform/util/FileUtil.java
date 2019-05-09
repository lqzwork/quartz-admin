package com.ffxl.platform.util;


/**
 * 文件操作
 * @author jiawei
 *
 */
public class FileUtil {

    /**
     * 获取工程跟目录
     * @param str
     * @return 返回WEB-INF/temp 目录
     * @author jiawei
     */
    public static String getRootPath() {
        String path = FileUtil.class.getResource("/").getPath();
        path=path.replace("classes", "temp"); //去掉file:  
        return path;
    }
}
