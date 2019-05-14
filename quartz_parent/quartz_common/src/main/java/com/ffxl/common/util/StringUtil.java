package com.ffxl.common.util;



import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;


public class StringUtil {

	private static final String MOBILE_REGEX = "^[1][0-9]{10}$"; // 手机号码
    private static final String AREA_CODE_AND_CELLPHONE_REGEX = "(^[0][1-9]{2,3}-[0-9]{5,10}$)|(^[0][1-9]{2,3}[0-9]{5,10}$)"; // 带区号的电话号码
    private static final String CELLPHONE_REGEX = "^[0][1-9]{2,3}-[0-9]{5,10}$"; // 没有区号的电话号码
    private static final String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"; // email
    private static final String LOGIN_ID_REGEX = "^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){3,15}$";// 闪邮号
    private static final String PASSPORT_REGEX = "^(P\\d{7}|G\\d{8}|S\\d{7,8}|D\\d+|1[4,5]\\d{7})$";// 护照
    private static final String ID_CARD_NO_REGEX = "^\\d{15}|(\\d{17}(\\d|x|X))$";// 身份证号码

    private StringUtil() {
    }

    /**
     * 手机号验证
     * 
     * @param str
     * @return 验证通过返回true
     */
    public static Boolean isMobile(String str) {
        Boolean b = false;
        b = str.matches(MOBILE_REGEX);
        return b;
    }

    /**
     * 电话号码验证
     * 
     * @param str
     * @return 验证通过返回true
     */
    public static Boolean isPhone(String str) {
        Boolean b = false;
        if (str.length() > 9) {
            b = str.matches(AREA_CODE_AND_CELLPHONE_REGEX);
        } else {
            b = str.matches(CELLPHONE_REGEX);
        }
        return b;
    }

    /**
     * 电子邮箱地址验证
     * 
     * @param str
     * @return 验证通过返回true
     */
    public static Boolean isEmail(String str) {
        Boolean b = str.matches(EMAIL_REGEX);
        return b;
    }

    /**
     * 闪邮号验证
     * 
     * @param str
     * @return 验证通过返回true
     */
    public static Boolean isLoginId(String str) {
        Boolean b = str.matches(LOGIN_ID_REGEX);
        return b;
    }

    /**
     * 验证护照
     * 
     * @param str
     * @return 验证通过返回true
     */
    public static Boolean isPassport(String str) {
        Boolean b = str.matches(PASSPORT_REGEX);
        return b;
    }

    /**
     * 验证身份证
     * 
     * @param str
     * @return 验证通过返回true
     */
    public static Boolean isIdCardNo(String str) {
        Boolean b = str.matches(ID_CARD_NO_REGEX);
        return b;
    }

    /**
     * 中文字符串截取（来自于网络）
     * 
     * @param str
     *            源字符串
     * @param length
     *            截取长度（单位：字节）
     * @param suffix
     *            后缀
     * @return
     */
    public static String subStringByte(final String str, final int length, final String suffix) {
        if (str == null) {
            return str;
        }

        int suffixLen = StringUtils.isBlank(suffix) ? 0 : suffix.length();

        final StringBuffer sbuffer = new StringBuffer();
        final char[] chr = str.trim().toCharArray();
        int len = 0;
        for (int i = 0; i < chr.length; i++) {

            if (chr[i] >= 0xa1) {
                len += 2;
            } else {
                len++;
            }
        }

        if (len <= length) {
            return str;
        }

        len = 0;
        for (int i = 0; i < chr.length; i++) {

            if (chr[i] >= 0xa1) {
                len += 2;
                if (len + suffixLen > length) {
                    break;
                } else {
                    sbuffer.append(chr[i]);
                }
            } else {
                len++;
                if (len + suffixLen > length) {
                    break;
                } else {
                    sbuffer.append(chr[i]);
                }
            }
        }
        sbuffer.append(suffix);

        return sbuffer.toString();
    }

    /**
     * 判断多参数是否存在空的值
     * 
     */
    public static boolean isEmpty(CharSequence... arg) {
        for (CharSequence cs : arg) {
            if (cs == null || cs.length() == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 字符ID串转List集合.
     * 
     * @param stringIds
     *            the string ids
     * @return the list
     */
    public static List<String> str2StringList(String stringIds) {
        List<String> idList = new LinkedList<String>();
        if (stringIds != null && !stringIds.trim().isEmpty()) {
            StringTokenizer st = new StringTokenizer(stringIds, " ,|");
            while (st.hasMoreElements()) {
                try {
                    idList.add(st.nextToken());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        return idList;
    }

    /**
     * 生成length位的随机数字（随机数的组成由于0123456789构成）
     * 
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        StringBuffer buffer = new StringBuffer("0123456789");
        StringBuffer sb = new StringBuffer();
        Random r = new Random();
        int range = buffer.length();
        for (int i = 0; i < length; i++) {
            sb.append(buffer.charAt(r.nextInt(range)));
        }
        return sb.toString();
    }
    
    /**
     * List集合转化为字符串
     * @param list 集合
     * @param separator 分隔符
     * @return
     */
    public static String listToString(List<String> list,String separator) {
       if(list == null || list.isEmpty()){
           return null;
       }
       
       StringBuffer result = new StringBuffer();
       int size = list.size();
       for (int i = 0; i < size; i++) {
           result.append(list.get(i)+separator);
       }
       
       if(result.length()>0){
           result.deleteCharAt(result.length()-1);
       }
       
       return result.toString();
    }
    
    /**
     * 获取1~9随机数
     * @param i 位数
     * @return
     * @author liqz and liyj
     */
    public static String getRandomStr(int i) {
        String randomStr = RandomStringUtils.random(i, "123456789");
        return randomStr;
    }
    
    
    /**
     * 获取范围随机数
     * @param i 位数
     * @return
     * @author liqz and liyj
     */
    public static int getRandomStr(int min, int max) {
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        return s;
    }
    
    public static boolean equals(String preStr, String str){
        if(preStr==null){
            preStr ="";
        }
        preStr = preStr.replaceAll("\r\n",""); 
        preStr = preStr.replaceAll("\r","");   
        preStr = preStr.replaceAll("\n","");   
        if(str==null){
            str ="";
        }
        str = str.replaceAll("\r\n",""); 
        str = str.replaceAll("\r","");   
        str = str.replaceAll("\n","");   
        return ObjectUtils.equals(preStr, str);
    }
    
}
