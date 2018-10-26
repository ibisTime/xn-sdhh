package com.xn.sdhh.dto.res;

public class XN630051Res {
    private String userId;

    private String status;

    public XN630051Res() {
    }

    public XN630051Res(String userId) {
        this.userId = userId;
    }

    public XN630051Res(String userId, String status) {
        super();
        this.userId = userId;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
