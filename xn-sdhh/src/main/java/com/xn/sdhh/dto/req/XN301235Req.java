package com.xn.sdhh.dto.req;

/**
 * 会计补充信息
 * @author: 55484 
 * @since: 2018年10月24日 下午8:52:34 
 * @history:
 */
public class XN301235Req extends APageReq {

    private static final long serialVersionUID = 3953489672057508474L;

    // 汽车种类
    private String qczl;

    // 状态
    private String status;

    // 区域负责人名称
    private String qyfzrmc;

    // 客户名称
    private String khmc;

    public String getQyfzrmc() {
        return qyfzrmc;
    }

    public void setQyfzrmc(String qyfzrmc) {
        this.qyfzrmc = qyfzrmc;
    }

    public String getQczl() {
        return qczl;
    }

    public void setQczl(String qczl) {
        this.qczl = qczl;
    }

    public String getKhmc() {
        return khmc;
    }

    public void setKhmc(String khmc) {
        this.khmc = khmc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
