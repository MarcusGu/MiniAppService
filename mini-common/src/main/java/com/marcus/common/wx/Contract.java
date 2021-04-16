package com.marcus.common.wx;

public class Contract {

    private final static String AppId = "wx28992e3c47ec0115";

    private final static String AppSecret = "d4568760c132d874c40dc8066aef08fc";

    private final static String WE_CHART_SNS = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";

    /**
     * 封装微信SNS地址
     *
     * @param code 小程序登陆授权码
     * @return
     */
    public static String createWeChartSnsUrl(String code) {
        return String.format(WE_CHART_SNS, AppId, AppSecret, code);
    }


}
