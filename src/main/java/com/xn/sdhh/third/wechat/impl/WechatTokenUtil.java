package com.xn.sdhh.third.wechat.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.xn.sdhh.bo.ISYSConfigBO;
import com.xn.sdhh.common.MD5Util;
import com.xn.sdhh.common.SysConstant;
import com.xn.sdhh.dto.res.XN630052Res;
import com.xn.sdhh.enums.EConfigType;
import com.xn.sdhh.exception.BizException;
import com.xn.sdhh.util.HttpsUtil;
import com.xn.sdhh.util.SignUtil;

@Component
public class WechatTokenUtil {

    private static Logger logger = Logger.getLogger(WechatTokenUtil.class);

    @Autowired
    ISYSConfigBO sysConfigBO;

    private Map<String, String> map = new HashMap<>();

    public XN630052Res getSign(String systemCode, String companyCode,
            String url) {
        getMap(systemCode, companyCode);
        String prefixStr = systemCode + "." + companyCode;
        String jsapiTicket = map.get(prefixStr + ".jsapi_token");
        String timestamp = map.get(prefixStr + ".time");
        String nonceStr = createNonceStr();
        String sign = SignUtil.getSignature(jsapiTicket, timestamp, nonceStr,
            url);
        logger.info("jsapiTicket:" + jsapiTicket + ";timestamp" + timestamp
                + ";nonceStr:" + nonceStr + ";sign:" + sign);
        return new XN630052Res(map.get("appId"), timestamp, nonceStr, sign);
    }

    public Map<String, String> getMap(String systemCode, String companyCode) {

        String time = map.get(systemCode + "." + companyCode + ".time");
        String accessToken = map
            .get(systemCode + "." + companyCode + ".access_token");
        Long nowDate = new Date().getTime() / 1000;
        if (accessToken != null && time != null
                && nowDate - Long.parseLong(time) < 3000 * 1000) {
            System.out.println("accessToken存在，且没有超时，返回单例");
        } else {
            System.out.println("accessToken超时，或者不存在，重新获取");
            map = getJsapiToken(systemCode, companyCode, map, nowDate);
        }

        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public String getAccessToken(String systemCode, String companyCode) {
        String accessToken = null;

        return accessToken;
    }

    public static String createNonceStr() {
        Random random = new Random();
        return MD5Util.md5(String.valueOf(random.nextInt(1000)));
    }

    public Map<String, String> getJsapiToken(String systemCode,
            String companyCode, Map<String, String> map, Long nowDate) {
        String jsapi_ticket = null;
        String appId = "";
        String appSecret = "";
        Map<String, String> resultMap = sysConfigBO.getConfigsMap(
            EConfigType.WEIXIN_H5.getCode(), companyCode, systemCode);
        appId = resultMap.get(SysConstant.WX_H5_ACCESS_KEY);
        appSecret = resultMap.get(SysConstant.WX_H5_SECRET_KEY);
        if (StringUtils.isBlank(appId)) {
            throw new BizException("XN000000", "微信公众号appId配置获取失败，请检查配置");
        }
        if (StringUtils.isBlank(appSecret)) {
            throw new BizException("XN000000", "微信公众号appSecret配置获取失败，请检查配置");
        }
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/token?";
        String params = "grant_type=client_credential&appid=" + appId
                + "&secret=" + appSecret + "";
        String result1;
        try {
            result1 = new String(HttpsUtil.post(requestUrl, params, "utf-8"));
            String access_token = JSONObject.parseObject(result1)
                .getString("access_token");
            logger.info("********微信分享结果result1:" + result1 + "********");
            requestUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?";
            params = "access_token=" + access_token + "&type=jsapi";
            result1 = new String(HttpsUtil.post(requestUrl, params, "utf-8"));
            jsapi_ticket = JSONObject.parseObject(result1).getString("ticket");

            map.put(systemCode + "." + companyCode + ".time", nowDate + "");
            map.put(systemCode + "." + companyCode + ".access_token",
                access_token);
            map.put(systemCode + "." + companyCode + ".jsapi_token",
                jsapi_ticket);
            map.put("appId", appId);
        } catch (Exception e) {
            throw new BizException("xn0000", e.getMessage());
        }
        return map;
    }
}
