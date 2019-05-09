package com.ffxl.platform.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;

public class ImgUtil {
    /**
     * 判断网络图片地址是否有效
     * @param imgUrl
     * @return
     * @throws ParseException
     * @throws IOException
     * @author jiawei
     */
     public static boolean imgExist(String imgUrl) throws ParseException, IOException{
            //设置此类是否应该自动执行 HTTP 重定向（响应代码为 3xx 的请求）。
            HttpURLConnection.setFollowRedirects(false);
            //到 URL 所引用的远程对象的连接
            HttpURLConnection con = (HttpURLConnection) new URL(imgUrl).openConnection();
            /* 设置 URL 请求的方法， GET POST HEAD OPTIONS PUT DELETE TRACE 以上方法之一是合法的，具体取决于协议的限制。*/
            con.setRequestMethod("HEAD");
            //从 HTTP 响应消息获取状态码 
            boolean b = con.getResponseCode()==HttpURLConnection.HTTP_OK?true :false;
            return b;
        }
}
