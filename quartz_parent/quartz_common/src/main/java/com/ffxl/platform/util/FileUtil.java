package com.ffxl.platform.util;


/**
 * 文件操作
 * @author liqz and liyj
 *
 */
public class FileUtil {

    /**
     * 获取工程跟目录
     * @param str
     * @return 返回WEB-INF/temp 目录
     * @author liqz and liyj
     */
    public static String getRootPath() {
        String path = FileUtil.class.getResource("/").getPath();
        path=path.replace("classes", "temp"); //去掉file:  
        return path;
    }
}
