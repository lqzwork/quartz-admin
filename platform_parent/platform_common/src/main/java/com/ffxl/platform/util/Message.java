package com.ffxl.platform.util;



import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 消息统一管理类
 * 
 * @author xieyingbin
 *
 */
public class Message {
    private static final Logger LOG = LoggerFactory.getLogger(Message.class);

    /**
     * 平台接口返回错误码分类： 操作成功:2000： 程序正常的处理了客户端的请求； 
     * 业务类错误:3xxx： 程序执行中断，存在不符合业务规则的错误，如:账号不存在，密码不正确，账号重复等；
     * 程序类错误:4xxx： 如:参数为空，参数格式不正确；
     * 服务执行错误:5xxx：程序执行非正常结束，主线业务处理失败，如数据库连接失败，图片处理失败，图片上传失败等错误；
     * 正常的中英文字符翻译(文案信息):6xxx
     * 
     * 消息文案文件：message_zh.properties、message_en.properties
     */

    /**
     * 未登录，需要授权
     */
    public static final String M1000 = "1000";
    /**
     * 未关注公众号
     */
    public static final String M1001 = "1001";
    /**
     * 手机号已注册
     */
    public static final String M1002 = "1002";
    /**
     * 手机号未注册
     */
    public static final String M1003 = "1003";
    /**
     *app_id无效
     */
    public static final String M1004 = "1004";
    /**
     * 请求失效
     */
    public static final String M1005 = "1005";
    /**
     * 加密验证错误
     */
    public static final String M1006 = "1006";
    
    //----------------------------融云短信错误码
    /**
     * 调用超过频率上限    429
     */
    public static final String M1008= "1008";
    /**
     * 没有开启图验功能    400
     */
    public static final String M1009= "1009";    
    /**
     * 未使用已开启的图验功能 400
     */
    public static final String M1010= "1010";  
    /**
     * 剩余条数不足，需要充值 430
     */
    public static final String M1011= "1011";    
    /**
     * 图片验证码不正确    430
     */
    public static final String M1012= "1012";
    /**
     *  短信通道不可用 430
     */
    public static final String M1013= "1013";   
    /**
     * 短信验证码已验证过，再次验证失效    430
     */
    public static final String M1014= "1014";    
    /**
     * 短信验证码过期无效
     */
    public static final String M1015= "1015";   
    /**
     * 内部服务响应超时    504
     */
    public static final String M1050= "1050";    
    
  //----------------------------融云短信错误码
    
    /**
     * 操作成功
     */
    public static final String M2000 = "2000";
    /**
     * 正常的中英文字符翻译(文案信息):6xxx
     */
    
    public static final String M6000 = "6000";
    public static final String M6001 = "6001";
    public static final String M6002 = "6002";
    /**
     * 服务执行错误:5xxx
     */
    /**
     * 处理失败
     */
    public static final String M5000 = "5000";
    public static final String M5001 = "5001";
    /**
     * 系统繁忙
     */
    public static final String M5002 = "5002";
    /**
     * 上传异常
     */
    public static final String M5003 = "5003";
    /**
     * 发送失败
     */
    public static final String M5004 = "5004";
    /**
     * 访问失败
     */
    public static final String M5005 = "5005";
    /**
     * 删除失败
     */
    public static final String M5006 = "5006";
    /**
     * 修改失败
     */
    public static final String M5007 = "5007";
    /**
     * 添加失败
     */
    public static final String M5009 = "5009";
    /**
     * 数据库操作错误
     */
    public static final String M5010 = "5010";
    /**
     * 短信发送失败
     */
    public static final String M5011 = "5011";
    /**
     * 手机号验证码缓存失效，请重新获取验证码
     */
    public static final String M5012 = "5012";
    /**
     * 短信验证失败
     */
    public static final String M5013 = "5013";
    /**
     * 微信支付参数配置错误
     */
    public static final String M5014 = "5014";
    /**
     * AliPay参数配置错误
     */
    public static final String M5015 = "5015";
    
    

    /**
     * 程序类错误:4xxx
     */
    /**
     * 未知类型
     */
    public static final String M4000 = "4000";
    /**
     * {0}参数不正确
     */
    public static final String M4001 = "4001";
    /**
     * {0}参数不能为空
     */
    public static final String M4002 = "4002";
    /**
     * 
     * 参数不能为空
     */
    public static final String M4003 = "4003";
    /**
     * 参数不正确
     */
    public static final String M4004 = "4004";
    /**
     * 参数格式不正确
     */
    public static final String M4005 = "4005";
    /**
     * {0}参数类型错误
     */
    public static final String M4006 = "4006";
    /**
     * 请求头参数不完整
     */
    public static final String M4007 = "4007";
    /**
     * 数据不存在
     */
    public static final String M4008 = "4008";
    public static final String M4009 = "4009";

    /**
     * 业务类错误:3xxx
     */
    
    /**
     * 账号不存在!
     */
    public static final String M3001 = "3001";
    /**
     * 密码错误
     */
    public static final String M3002 = "3002";
    /**
     * app_id无效
     */
    public static final String M3003 = "3003"; 
    /**
     * 手机号格式错误
     */
    public static final String M3004 = "3004";
    /**
     * 图片数据不完整，请换一张
     */
    public static final String M3005 = "3005";
    /**
     * 该时段已被其他用户预约，请重新选择服务时段
     */
    public static final String M3006 = "3006";
    /**
     * 咨询师的互联账号未初始化
     */
    public static final String M3007 = "3007";
    /**
     * 未找到咨询师提供的服务内容
     */
    public static final String M3008 = "3008";
    public static final String M3009 = "3009";
    /**
     * 订单不存在
     */
    public static final String M3010 = "3010";
    /**
     * 订单金额错误
     */
    public static final String M3011 = "3011";
    /**
     * 商户appId不匹配
     */
    public static final String M3012 = "3012";
    /**
     * 支付宝签名验证失败
     */
    public static final String M3013 = "3013";

    /**
     * 未绑定互联账号
     */
    public static final String M3014 = "3014";
    /**
     * 服务不存在
     */
    public static final String M3015 = "3015";
    /**
     * 您已点赞
     */
    public static final String M3016 = "3016";
    public static final String M3017 = "3017";
    public static final String M3018 = "3018";
    public static final String M3019 = "3019";
    public static final String M3020 = "3020";
    public static final String M3021 = "3021";
    public static final String M3022 = "3022";
    public static final String M3023 = "3023";
    /**
     * 企业合同未到期，不允许加入其它企业
     */
    public static final String M3025 = "3025";
    /**
     * 企业合同到期
     */
    public static final String M3026 = "3026";
    /**
     * 暂未加入任何企业
     */
    public static final String M3027 = "3027";
    /**
     * 验证码无效
     */
    public static final String M3028 = "3028";
    /**
     * 该卡已被激活
     */
    public static final String M3029 = "3029";
    /**
     * 个人信息未填写
     */
    public static final String M3030 = "3030";
    /**
     * 卡号不存在
     */
    public static final String M3031 = "3031";
    /**
     * 卡号已被绑定
     */
    public static final String M3032 = "3032";
    /**
     * 与之前卡号所绑定的企业不同
     */
    public static final String M3033 = "3033";
    /**
     * 卡号已绑定过期
     */
    public static final String M3034 = "3034";
    /**
     * 卡号未绑定过期
     */
    public static final String M3035 = "3035";
    /***
     * 获取openid失败 
     **/
    public static final String M3036 = "3036";
    /**
     * 该名称无效，请填写正确姓名
     */
    public static final String M3037 = "3037";
    /**
     * 非咨询师不可预约咨询室
     */
    public static final String M3038 = "3038";
    /**
     * 题目单维度-选项多维度的量表不可创建多个一级维度
     */
    public static final String M3039 = "3039";
    /**
     * 测试不存在
     */
    public static final String M3040 = "3040";
    /**
    * 该类型充值不存在
    */
    public static final String M3041 = "3041";
    /**
     * 活动时间设置错误或活动已过期未下架
     */
    public static final String M3042 = "3042";
    public static final String M3043 = "3043";
    public static final String M3045 = "3045";
    public static final String M3046 = "3046";
    public static final String M3047 = "3047";
    public static final String M3048 = "3048";
    public static final String M3049 = "3049";
    public static final String M3050 = "3050";
    /**
     * 卡卷已过期 无法支付
     */
    public static final String M3051 = "3051";
    /**
     * 支付失败
     */
    public static final String M3052 = "3052";
    /**
     * 此团已满 请重新下单另开新团
     */
    public static final String M3053 = "3053";
    /**
     * 活动人数已满
     */
    public static final String M3054 = "3054";
    /**
     * 该手机号已购买
     */
    public static final String M3055 = "3055";
    /**
     * 该用户已够买5张票
     */
    public static final String M3056 = "3056";
    /**
     * 报名时间已过
     */
    public static final String M3057 = "3057";
    public static final String M3058 = "3058";
    public static final String M3059 = "3059";
    public static final String M3060 = "3060";
    public static final String M3061 = "3061";
    public static final String M3062 = "3062";
    /**
     * 验证码错误！
     */
    public static final String M3063 = "3063";
    /**
     * 购买时间已过
     */
    public static final String M3064 = "3064";
    /**
     * 当前活动限购一份！
     */
    public static final String M3065 = "3065";
    /**
     * 该订单已申请过退款！
     */
    public static final String M3067 = "3067";
    /**
     * 微信用户 unionId为空 需重新登录
     */
    public static final String M3068 = "3068";
    /**
     * 此作品已点赞
     */
    public static final String M3069 = "3069";
    /**
     * 此第三方账号已生成账号
     */
    public static final String M3070 = "3070";
    /**
     * 最少绑定一个第三方信息或绑定手机号码
     */
    public static final String M3071 = "3071";
    /**
     * 未加入场景
     */
    public static final String M3072 = "3072";
    /**
     * 头信息未设置
     */
    public static final String M3073 = "3073";
    /**
     * 未加入队伍
     */
    public static final String M3074 = "3074";
    /**
     * 无答题资格
     */
    public static final String M3075 = "3075";
    /**
     * 您已经加入该团体
     */
    public static final String M3076 = "3076";
    /**
     * 已加入队伍
     */
    public static final String M3077 = "3077";
    /**
     * 该场景下已激活过卡号，如有疑问可联系客服
     */
    public static final String M3078 = "3078";
    /**
     * 没有激活任何卡服务
     */
    public static final String M3079 = "3079";
    /**
     * 所激活的服务卡 不支持免费咨询服务
     */
    public static final String M3080 = "3080";
    /**
     * 场景下无免费咨询服务
     */
    public static final String M3081 = "3081";
    /**
     * 服务已过期
     */
    public static final String M3082 = "3082";
    /**
     * 免费时长已用尽
     */
    public static final String M3083 = "3083";
    /**
     * 服务卡不支持该商品免费使用
     */
    public static final String M3084 = "3084";
    public static final String M3085 = "3085";
    public static final String M3086 = "3086";
    public static final String M3087 = "3087";
    public static final String M3088 = "3088";
    public static final String M3089 = "3089";
    /**
     * 活动不存在
     */
    public static final String M3090 = "3090";
    /**
     * 活动未上架
     */
    public static final String M3091 = "3091";
    /**
     * 活动未开始
     */
    public static final String M3092 = "3092";
    /**
     * 活动已结束
     */
    public static final String M3093 = "3093";
    /**
     * 优惠券已领取
     */
    public static final String M3094 = "3094";
    /**
     * 您来晚了，优惠券已被抢光了
     */
    public static final String M3095 = "3095";
    /**
     * 活动未配置优惠券
     */
    public static final String M3096 = "3096";
    /**
     * 用户无领取权限
     */
    public static final String M3097 = "3097";
    /**
     * 优惠券领取失败
     */
    public static final String M3098 = "3098";
    /**
     * 优惠券未配置规则
     */
    public static final String M3099 = "3099";
    /**
     * 优惠券有效期类型配置错误
     */
    public static final String M3100 = "3100";
    /**
     * 无领取记录
     */
    public static final String M3101 = "3101";
    /**
     * 优惠券还未生效
     */
    public static final String M3102 = "3102";
    /**
     * 优惠券已过期
     */
    public static final String M3103 = "3103";
    /**
     * 优惠券已使用
     */
    public static final String M3104 = "3104";
    /**
     * 订单未达到优惠券的使用最低金额
     */
    public static final String M3105 = "3105";
    /**
     * 优惠券类型不匹配
     */
    public static final String M3106 = "3106";
    /**
     * 一个订单只能存在一种优惠券的使用记录
     */
    public static final String M3107 = "3107";
    /**
     * 您没有管理权限
     */
    public static final String M3108 = "3108";
    /**
     * 没有优惠券
     */
    public static final String M3109 = "3109";
    /**
     * 队伍名称已存在
     */
    public static final String M3110 = "3110";
    /**
     * 场景名称已存在
     */
    public static final String M3111 = "3111";
    /**
     * 同类型作品只可报名一次
     */
    public static final String M3112 = "3112";
    /**
     * 余额不足
     */
    public static final String M3113 = "3113";
    /**
     * 分享获取抽奖机会已达上限
     */
    public static final String M3114 = "3114";
    /**
     * 抽奖次数已用完
     */
    public static final String M3115 = "3115";
    /**
     * 谢谢参与
     */
    public static final String M3116 = "3116";
    /**
     * 激活码已被使用
     */
    public static final String M3117 = "3117";
    /**
     * 代言人数量已达上限
     */
    public static final String M3118 = "3118";
    /**
     * 您已经是代言人
     */
    public static final String M3119 = "3119";
    /**
     * 奖励已领取
     */
    public static final String M3120 = "3120";
    /**
     * 只能答题一次
     */
    public static final String M3121 = "3121";
    /**
     * 已经站队
     */
    public static final String M3122 = "3122";
    /**
     * 未站队 无资格领取奖励
     */
    public static final String M3123 = "3123";
    /**
     * 抽奖机会未使用
     */
    public static final String M3124 = "3124";
    /**
     * 试题已做，请不要重复点击
     */
    public static final String M3125 = "3125";
    /**
     * 只能删除自己的数据
     */
    public static final String M3126 = "3126";
    /**
     * 您已报名
     */
    public static final String M3127 = "3127";
    /**
     * 该数据已删除
     */
    public static final String M3128 = "3128";
    /**
     * 活动已结束
     */
    public static final String M3129 = "3129";
    public static final String M3130 = "3130";
    public static final String M3131 = "3131";
    public static final String M3132 = "3132";
    public static final String M3133 = "3133";
    public static final String M3134 = "3134";
    public static final String M3135 = "3135";
    public static final String M3136 = "3136";
    public static final String M3137 = "3137";
    public static final String M3138 = "3138";
    public static final String M3139 = "3139";
    public static final String M3140 = "3140";
    public static final String M3141 = "3141";
    public static final String M3142 = "3142";
    public static final String M3143 = "3143";
    public static final String M3144 = "3144";
    public static final String M3145 = "3145";
    public static final String M3146 = "3146";
    public static final String M3147 = "3147";
    public static final String M3148 = "3148";
    public static final String M3149 = "3149";
    public static final String M3150 = "3150";
    public static final String M3151 = "3151";
    public static final String M3152 = "3152";
    public static final String M3153 = "3153";
    public static final String M3154 = "3154";
    public static final String M3155 = "3155";
    public static final String M3156 = "3156";
    public static final String M3157 = "3157";
    public static final String M3158 = "3158";
    public static final String M3159 = "3159";
    public static final String M3160 = "3160";
    public static final String M3161 = "3161";
    public static final String M3162 = "3162";
    public static final String M3163 = "3163";
    public static final String M3164 = "3164";
    public static final String M3165 = "3165";
    public static final String M3166 = "3166";
    public static final String M3167 = "3167";
    public static final String M3168 = "3168";
    public static final String M3169 = "3169";
    public static final String M3170 = "3170";
    public static final String M3171 = "3171";
    public static final String M3172 = "3172";
    public static final String M3173 = "3173";
    public static final String M3174 = "3174";
    public static final String M3175 = "3175";
    public static final String M3176 = "3176";
    public static final String M3177 = "3177";
    public static final String M3178 = "3178";
    public static final String M3179 = "3179";
    public static final String M3180 = "3180";
    public static final String M3181 = "3181";
    public static final String M3190 = "3190";
    public static final String M3191 = "3191";
    public static final String M3192 = "3192";
    public static final String M3193 = "3193";
    public static final String M3194 = "3194";
    public static final String M3195 = "3195";
    public static final String M3196 = "3196";
    public static final String M3197 = "3197";
    public static final String M3198 = "3198";
    public static final String M3199 = "3199";
    public static final String M3200 = "3200";
    public static final String M3211 = "3211";
    public static final String M3212 = "3212";
    private static Properties PROP_ZH = new Properties();
    private static Properties PROP_EN = new Properties();

    static {
        loads();
    }

    /**
     * 加载消息初始化信息
     */
    synchronized static public void loads() {
        LOG.info("载入消息信息   开始");
        InputStream is1 = Message.class.getResourceAsStream("/message_zh.properties");
        try {
            PROP_ZH.load(is1);
            is1.close();
        } catch (Exception e) {
            // System.err.println("不能读取属性文件. ");
            LOG.error("不能读取属性文件.");
        }

        InputStream is2 = Message.class.getResourceAsStream("/message_en.properties");
        try {
            PROP_EN.load(is2);
            is2.close();
        } catch (Exception e) {
            // System.err.println("不能读取属性文件. ");
            LOG.error("不能读取属性文件.");
        }
        LOG.info("载入消息信息   结束");
    }

    /**
     * 根据消息code获取消息文案信息
     * 
     * @param code
     *            消息code
     * @return 消息文案
     */
    public static String getMessage(String code) {
        Thread current = Thread.currentThread();
//        LOG.info("$$$$$$$$ getMessage Thread id=" + current.getId() + "  name=" + current.getName());

        boolean isEnglish = false;
        HttpHeader header = HttpHeader.get();
        if (header != null) {
            LOG.info("$$$$$$$$ getMessage header=" + header.toString());
            isEnglish = header.isLanguage(HttpHeader.LANGUAGE_EN);
        }

//        LOG.info("$$$$$$$$ getMessage isEnglish=" + isEnglish);

        String msg = "";
        if (isEnglish) {
            // 英文
            msg = String.valueOf(PROP_EN.get(code));
        } else {
            // 中文
            msg = String.valueOf(PROP_ZH.get(code));
        }
        LOG.info("$$$$$$$$ getMessage code值："+code+"；message内容 : " + msg);
        return msg;
        
    }

    /**
     * 可传递参数，并根据消息code获取消息文案信息
     * 
     * @param code
     *            消息code
     * @param args
     *            消息参数
     * @return 消息文案
     */
    public static String getMessage(String code, Object... args) {
        String msg = MessageFormat.format(getMessage(code), args);
        return msg;
    }
}
