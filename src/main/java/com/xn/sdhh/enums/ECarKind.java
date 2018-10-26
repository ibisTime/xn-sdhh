/**
 * @Title EDictType.java 
 * @Package com.std.security.enums 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月17日 下午5:15:02 
 * @version V1.0   
 */
package com.xn.sdhh.enums;

import java.util.HashMap;
import java.util.Map;

/** 
 * @author: haiqingzheng 
 * @since: 2016年4月17日 下午5:15:02 
 * @history:
 */
public enum ECarKind {

    CAR_OTHER("0", "其他车"), CAR_SECOND("1", "二手车");

    public static Map<String, ECarKind> getDictTypeMap() {
        Map<String, ECarKind> map = new HashMap<String, ECarKind>();
        for (ECarKind dictType : ECarKind.values()) {
            map.put(dictType.getCode(), dictType);
        }
        return map;
    }

    ECarKind(String code, String value) {
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
