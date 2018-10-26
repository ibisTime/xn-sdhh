package com.xn.sdhh.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630090Req {
    // 系统编号(必填)
    @NotBlank
    private String systemCode;

    // 公司编号(必填)
    @NotBlank
    private String companyCode;

    // 手机号(必填)
    @NotBlank
    private String mobile;

    // 业务类型(必填)
    @NotBlank
    private String bizType;

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }
}
