package com.xn.sdhh.common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesUtil {

    private static Properties props = null;

    public static void init(String configFile) {
        props = new Properties();
        try {
            InputStream in = PropertiesUtil.class
                .getResourceAsStream(configFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            props.load(br);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        if (props == null) {
            // throw new Exception("配置文件初始化失败");
        }
        return props.getProperty(key);
    }

    public static final class Config {

        public static String ACCOUNT_URL = props.getProperty("ACCOUNT_URL");

        public static String SMS_URL = props.getProperty("SMS_URL");

        public static String WECHAT_H5_BACKURL = props
            .getProperty("WECHAT_H5_BACKURL");

        public static String WECHAT_H5_CZ_BACKURL = props
            .getProperty("WECHAT_H5_CZ_BACKURL");

        public static String WECHAT_H5_IN_ORDER_BACKURL = props
            .getProperty("WECHAT_H5_IN_ORDER_BACKURL");

        public static String WECHAT_H5_OUT_ORDER_BACKURL = props
            .getProperty("WECHAT_H5_OUT_ORDER_BACKURL");

        public static String WECHAT_H5_INNER_ORDER_BACKURL = props
            .getProperty("WECHAT_H5_INNER_ORDER_BACKURL");

        public static String WECHAT_XCX_ORDER_BACKURL = props
            .getProperty("WECHAT_XCX_ORDER_BACKURL");
    }
}
