package com.ffxl.common.util.eap;

/**
 * ID生成器接口, 用于生成全局唯一的ID号
 * @author liqz and liyj
 *
 */
public interface IdGenerator {
    /**
     * 生成下一个不重复的流水号
     * @return
     */
    String next();
    
    /**
     * 对字符串进行MD5加密后生成16位秘钥，对16位秘钥进行二次AES加密
     * @return
     * @author liqz and liyj
     */
    String toMd5AndAes(String str);
}
