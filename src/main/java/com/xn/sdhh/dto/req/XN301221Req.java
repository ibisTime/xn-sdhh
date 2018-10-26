package com.xn.sdhh.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN301221Req {

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
