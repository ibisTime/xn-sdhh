package com.xn.sdhh.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 系统参数
 * @author: xieyj 
 * @since: 2017年9月4日 下午8:00:03 
 * @history:
 */
public enum ESysConfigType {
    QINIU("qiniu", "七牛参数"), COST("cost", "工程费用");

    public static Map<String, ESysConfigType> getMap() {
        Map<String, ESysConfigType> map = new HashMap<String, ESysConfigType>();
        for (ESysConfigType domain : ESysConfigType.values()) {
            map.put(domain.getCode(), domain);
        }
        return map;
    }

    ESysConfigType(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
