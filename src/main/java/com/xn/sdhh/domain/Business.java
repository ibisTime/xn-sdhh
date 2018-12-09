package com.xn.sdhh.domain;

import java.util.Date;

import com.xn.sdhh.dao.base.ABaseDO;

/**
 * 业务
 * @author: 55484 
 * @since: 2018年10月24日 下午4:33:11 
 * @history:
 */
public class Business extends ABaseDO {

    private static final long serialVersionUID = -6344063950447428650L;

    // 编号
    private String code;

    // 区域负责人名称
    private String qyfzrmc;

    // 汽车种类
    private String qczl;

    // 客户名称
    private String khmc;

    // 贷款金额
    private Long dkje;

    // 综合利率
    private Double zhll;

    // 打款日期
    private Date dkrq;

    // 银行放款日期
    private Date yhfkrq;

    // 公司回款日期
    private Date gshkrq;

    // 发保合回收日期
    private Date fbhhsrq;

    // 发保合日差
    private Integer fbhrc;

    // 温州垫资日期
    private Date wzdzrq;

    // 打件日期
    private Date djrq;

    // 打件日差
    private Integer djrc;

    // 调额日期
    private Date terq;

    // 放款日差
    private Integer fkrc;

    // 抵押日期
    private Date dyrq;

    // 抵押日差
    private Integer dyrc;

    // 返点金额
    private Long fdje;

    // 评估费
    private Long pgf;

    // 垫资利息
    private Long dzlx;

    // 应收返点金额
    private Long ysfdje;

    // 渠道费
    private Long qdf;

    // 渠道费发放日期
    private Date qdfffrq;

    // 绩效
    private Long jx;

    // 其他利润
    private Long qtlr;

    // 保证金贷款额
    private Long bzjdke;

    // 毛利润
    private Long mlr;

    // 状态
    private String status;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // *******************db****************
    // 区域负责人查询
    private String qyfzrmcForQuery;

    // 客户名称
    private String khmcForQuery;

    // 打款日期起
    private Date dkrqStart;

    // 打款日期止
    private Date dkrqEnd;

    // 银行放款日期起
    private Date yhfkrqStart;

    // 银行放款日期止
    private Date yhfkrqEnd;

    // 打件日期起
    private Date djrqStart;

    // 打件日期止
    private Date djrqEnd;

    public Date getDjrqStart() {
        return djrqStart;
    }

    public void setDjrqStart(Date djrqStart) {
        this.djrqStart = djrqStart;
    }

    public Date getDjrqEnd() {
        return djrqEnd;
    }

    public void setDjrqEnd(Date djrqEnd) {
        this.djrqEnd = djrqEnd;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Date getDkrqStart() {
        return dkrqStart;
    }

    public void setDkrqStart(Date dkrqStart) {
        this.dkrqStart = dkrqStart;
    }

    public Date getDkrqEnd() {
        return dkrqEnd;
    }

    public void setDkrqEnd(Date dkrqEnd) {
        this.dkrqEnd = dkrqEnd;
    }

    public Date getYhfkrqStart() {
        return yhfkrqStart;
    }

    public void setYhfkrqStart(Date yhfkrqStart) {
        this.yhfkrqStart = yhfkrqStart;
    }

    public Date getYhfkrqEnd() {
        return yhfkrqEnd;
    }

    public void setYhfkrqEnd(Date yhfkrqEnd) {
        this.yhfkrqEnd = yhfkrqEnd;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getQdfffrq() {
        return qdfffrq;
    }

    public void setQdfffrq(Date qdfffrq) {
        this.qdfffrq = qdfffrq;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Long getDkje() {
        return dkje;
    }

    public void setDkje(Long dkje) {
        this.dkje = dkje;
    }

    public Double getZhll() {
        return zhll;
    }

    public void setZhll(Double zhll) {
        this.zhll = zhll;
    }

    public Date getDkrq() {
        return dkrq;
    }

    public void setDkrq(Date dkrq) {
        this.dkrq = dkrq;
    }

    public Date getYhfkrq() {
        return yhfkrq;
    }

    public void setYhfkrq(Date yhfkrq) {
        this.yhfkrq = yhfkrq;
    }

    public Date getGshkrq() {
        return gshkrq;
    }

    public void setGshkrq(Date gshkrq) {
        this.gshkrq = gshkrq;
    }

    public Date getFbhhsrq() {
        return fbhhsrq;
    }

    public void setFbhhsrq(Date fbhhsrq) {
        this.fbhhsrq = fbhhsrq;
    }

    public Integer getFbhrc() {
        return fbhrc;
    }

    public void setFbhrc(Integer fbhrc) {
        this.fbhrc = fbhrc;
    }

    public Date getWzdzrq() {
        return wzdzrq;
    }

    public void setWzdzrq(Date wzdzrq) {
        this.wzdzrq = wzdzrq;
    }

    public Date getDjrq() {
        return djrq;
    }

    public void setDjrq(Date djrq) {
        this.djrq = djrq;
    }

    public Date getTerq() {
        return terq;
    }

    public void setTerq(Date terq) {
        this.terq = terq;
    }

    public Date getDyrq() {
        return dyrq;
    }

    public void setDyrq(Date dyrq) {
        this.dyrq = dyrq;
    }

    public Long getFdje() {
        return fdje;
    }

    public void setFdje(Long fdje) {
        this.fdje = fdje;
    }

    public Long getPgf() {
        return pgf;
    }

    public void setPgf(Long pgf) {
        this.pgf = pgf;
    }

    public Long getDzlx() {
        return dzlx;
    }

    public void setDzlx(Long dzlx) {
        this.dzlx = dzlx;
    }

    public Long getYsfdje() {
        return ysfdje;
    }

    public void setYsfdje(Long ysfdje) {
        this.ysfdje = ysfdje;
    }

    public Long getQdf() {
        return qdf;
    }

    public void setQdf(Long qdf) {
        this.qdf = qdf;
    }

    public Long getJx() {
        return jx;
    }

    public void setJx(Long jx) {
        this.jx = jx;
    }

    public Long getQtlr() {
        return qtlr;
    }

    public void setQtlr(Long qtlr) {
        this.qtlr = qtlr;
    }

    public Long getBzjdke() {
        return bzjdke;
    }

    public void setBzjdke(Long bzjdke) {
        this.bzjdke = bzjdke;
    }

    public Long getMlr() {
        return mlr;
    }

    public void setMlr(Long mlr) {
        this.mlr = mlr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDjrc() {
        return djrc;
    }

    public void setDjrc(Integer djrc) {
        this.djrc = djrc;
    }

    public Integer getFkrc() {
        return fkrc;
    }

    public void setFkrc(Integer fkrc) {
        this.fkrc = fkrc;
    }

    public Integer getDyrc() {
        return dyrc;
    }

    public void setDyrc(Integer dyrc) {
        this.dyrc = dyrc;
    }

    public String getQyfzrmcForQuery() {
        return qyfzrmcForQuery;
    }

    public void setQyfzrmcForQuery(String qyfzrmcForQuery) {
        this.qyfzrmcForQuery = qyfzrmcForQuery;
    }

    public String getKhmcForQuery() {
        return khmcForQuery;
    }

    public void setKhmcForQuery(String khmcForQuery) {
        this.khmcForQuery = khmcForQuery;
    }

}
