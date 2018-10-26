package com.xn.sdhh.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 会计补充信息
 * @author: 55484 
 * @since: 2018年10月24日 下午8:52:34 
 * @history:
 */
public class XN301237Req {

    // 编号
    @NotBlank(message = "编号不能为空")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
