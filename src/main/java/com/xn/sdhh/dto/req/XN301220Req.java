package com.xn.sdhh.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 录入业务
 * @author: 55484 
 * @since: 2018年10月24日 下午5:47:10 
 * @history:
 */
public class XN301220Req {

    // 编号
    @NotBlank
    private String code;

    // 区域负责人名称
    private String qyfzrmc;

    // 汽车种类
    private String qczl;

    // 客户名称
    private String khmc;

    // 贷款金额
    private String dkje;

    // 综合利率
    private String zhll;

    // 打款日期
    private String dkrq;

    // 渠道费
    private String qdf;

    // 渠道费发放日期
    private String qdfffrq;

    // 绩效
    private String jx;

    // 其他利润
    private String qtlr;

    // 业务风险保证金
    private String ywfxbzj;

    // 银行放款日期
    private String yhfkrq;

    // 公司回款日期
    private String gshkrq;

    // 温州垫资日期
    private String wzdzrq;

    // 打件日期
    private String djrq;

    // 调额日期
    private String terq;

    // 发保合回收日期
    private String fbhhsrq;

    // 抵押日期
    private String dyrq;

    // 更新人
    @NotBlank
    private String updater;

    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getQdfffrq() {
        return qdfffrq;
    }

    public void setQdfffrq(String qdfffrq) {
        this.qdfffrq = qdfffrq;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
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

    public String getYwfxbzj() {
        return ywfxbzj;
    }

    public void setYwfxbzj(String ywfxbzj) {
        this.ywfxbzj = ywfxbzj;
    }

    public String getKhmc() {
        return khmc;
    }

    public void setKhmc(String khmc) {
        this.khmc = khmc;
    }

    public String getDkje() {
        return dkje;
    }

    public void setDkje(String dkje) {
        this.dkje = dkje;
    }

    public String getZhll() {
        return zhll;
    }

    public void setZhll(String zhll) {
        this.zhll = zhll;
    }

    public String getDkrq() {
        return dkrq;
    }

    public void setDkrq(String dkrq) {
        this.dkrq = dkrq;
    }

    public String getQdf() {
        return qdf;
    }

    public void setQdf(String qdf) {
        this.qdf = qdf;
    }

    public String getJx() {
        return jx;
    }

    public void setJx(String jx) {
        this.jx = jx;
    }

    public String getQtlr() {
        return qtlr;
    }

    public void setQtlr(String qtlr) {
        this.qtlr = qtlr;
    }

    public String getYhfkrq() {
        return yhfkrq;
    }

    public void setYhfkrq(String yhfkrq) {
        this.yhfkrq = yhfkrq;
    }

    public String getGshkrq() {
        return gshkrq;
    }

    public void setGshkrq(String gshkrq) {
        this.gshkrq = gshkrq;
    }

    public String getWzdzrq() {
        return wzdzrq;
    }

    public void setWzdzrq(String wzdzrq) {
        this.wzdzrq = wzdzrq;
    }

    public String getDjrq() {
        return djrq;
    }

    public void setDjrq(String djrq) {
        this.djrq = djrq;
    }

    public String getTerq() {
        return terq;
    }

    public void setTerq(String terq) {
        this.terq = terq;
    }

    public String getFbhhsrq() {
        return fbhhsrq;
    }

    public void setFbhhsrq(String fbhhsrq) {
        this.fbhhsrq = fbhhsrq;
    }

    public String getDyrq() {
        return dyrq;
    }

    public void setDyrq(String dyrq) {
        this.dyrq = dyrq;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
