package com.xn.sdhh.dto.req;

/**
 * 业务分页查询
 * @author: xieyj 
 * @since: 2018年11月21日 下午4:44:14 
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

    // 打款日期
    private String dkrqStart;

    // 打款日期
    private String dkrqEnd;

    // 银行放款日期起
    private String yhfkrqStart;

    // 银行放款日期止
    private String yhfkrqEnd;

    // 打件日期起
    private String djrqStart;

    // 打件日期止
    private String djrqEnd;

    public String getYhfkrqStart() {
        return yhfkrqStart;
    }

    public void setYhfkrqStart(String yhfkrqStart) {
        this.yhfkrqStart = yhfkrqStart;
    }

    public String getDkrqStart() {
        return dkrqStart;
    }

    public void setDkrqStart(String dkrqStart) {
        this.dkrqStart = dkrqStart;
    }

    public String getDkrqEnd() {
        return dkrqEnd;
    }

    public void setDkrqEnd(String dkrqEnd) {
        this.dkrqEnd = dkrqEnd;
    }

    public String getYhfkrqEnd() {
        return yhfkrqEnd;
    }

    public void setYhfkrqEnd(String yhfkrqEnd) {
        this.yhfkrqEnd = yhfkrqEnd;
    }

    public String getDjrqStart() {
        return djrqStart;
    }

    public void setDjrqStart(String djrqStart) {
        this.djrqStart = djrqStart;
    }

    public String getDjrqEnd() {
        return djrqEnd;
    }

    public void setDjrqEnd(String djrqEnd) {
        this.djrqEnd = djrqEnd;
    }

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
