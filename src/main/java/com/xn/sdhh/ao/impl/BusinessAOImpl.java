package com.xn.sdhh.ao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xn.sdhh.ao.IBusinessAO;
import com.xn.sdhh.bo.IBusinessBO;
import com.xn.sdhh.bo.ISYSConfigBO;
import com.xn.sdhh.bo.base.Paginable;
import com.xn.sdhh.common.AmountUtil;
import com.xn.sdhh.common.DateUtil;
import com.xn.sdhh.common.SysConstant;
import com.xn.sdhh.core.StringValidater;
import com.xn.sdhh.domain.Business;
import com.xn.sdhh.domain.SYSConfig;
import com.xn.sdhh.dto.req.XN301220Req;
import com.xn.sdhh.enums.EBusinessStatus;
import com.xn.sdhh.enums.ECarKind;
import com.xn.sdhh.enums.ESysConfigType;
import com.xn.sdhh.exception.BizException;

@Service
public class BusinessAOImpl implements IBusinessAO {

    @Autowired
    IBusinessBO businessBO;

    @Autowired
    ISYSConfigBO sysConfigBO;

    @Override
    public String addBusiness(XN301220Req req) {
        return calculate(null, req);
    }

    @Override
    @Transactional
    public void editBusiness(XN301220Req req) {
        Business data = businessBO.getBusiness(req.getCode());
        if (!EBusinessStatus.ARCHIVE_NO.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "当前记录不是待归档状态");
        }
        this.calculate(data, req);
    }

    @Override
    public void removeBusiness(String code) {
        Business data = businessBO.getBusiness(code);
        if (!EBusinessStatus.ARCHIVE_NO.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "当前记录不是待归档状态");
        }
        businessBO.removeBusiness(data);
    }

    @Override
    @Transactional
    public void archiveBusiness(XN301220Req req) {
        Business data = businessBO.getBusiness(req.getCode());
        if (!EBusinessStatus.ARCHIVE_NO.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "当前记录不是待归档状态");
        }
        data.setStatus(EBusinessStatus.ARCHIVE_YES.getCode());
        this.calculate(data, req);

    }

    // 计算返点金额
    private String calculate(Business data, XN301220Req req) {
        Long fdje = 0L;
        // Long bzjdke = 0L;
        Long dkje = StringValidater.toLong(req.getDkje());

        Map<String, String> map = sysConfigBO
            .getConfigsMap(ESysConfigType.COST.getCode());
        Long gpsDjFee = 0L;
        if (StringUtils.isNotBlank(req.getDkje())) {
            double zhll = StringValidater.toDouble(req.getZhll());
            // GPS打件费用
            gpsDjFee = AmountUtil.mul(1000L, StringValidater
                .toDouble(map.get(SysConstant.GPSDJ_FEE)).doubleValue());
            fdje = (long) (AmountUtil.div(AmountUtil.mul(dkje, (zhll - 0.118)),
                1.1107) - AmountUtil.mul(dkje, 0.01) - gpsDjFee);
            // bzjdke = (long) AmountUtil.mul(dkje, 0.01);
        }

        // 评估费
        Long pgFee = 0L;
        if (ECarKind.CAR_SECOND.getCode().equals(req.getQczl())) {
            SYSConfig config = sysConfigBO.getConfig(SysConstant.PG_AMOUNT);
            if (null != config) {
                pgFee = AmountUtil.mul(1000L,
                    StringValidater.toDouble(config.getCvalue()).doubleValue());
            } else {
                throw new BizException("xn0000", "评估费配置不能为空");
            }
        }

        // 垫资利息:贷款金额*1.6%/30*（银行放款日期-温州垫资日期）
        Long dzlx = 0L;
        if (StringUtils.isNotBlank(req.getYhfkrq())
                && StringUtils.isNotBlank(req.getWzdzrq())
                && StringUtils.isNotBlank(req.getDkje())) {
            Date yhfkrq = DateUtil.strToDate(req.getYhfkrq(),
                DateUtil.FRONT_DATE_FORMAT_STRING);
            Date wzdzrq = DateUtil.strToDate(req.getWzdzrq(),
                DateUtil.FRONT_DATE_FORMAT_STRING);
            dzlx = AmountUtil.mul(
                AmountUtil.div(AmountUtil.mul(dkje, 0.016), 30.0),
                DateUtil.daysBetween(wzdzrq, yhfkrq) + 1);// 10.1 ---10.7
                                                          // 方法算出来6天要加一天，按公式再加一个天
        }

        // 发保和日差
        Integer fbhrc = null;
        if (StringUtils.isNotBlank(req.getFbhhsrq())
                && StringUtils.isNotBlank(req.getDkrq())) {
            fbhrc = DateUtil.daysBetween(
                DateUtil.strToDate(req.getDkrq(),
                    DateUtil.FRONT_DATE_FORMAT_STRING),
                DateUtil.strToDate(req.getFbhhsrq(),
                    DateUtil.FRONT_DATE_FORMAT_STRING));
        }

        // 打件日差
        Integer djrc = null;
        if (StringUtils.isNotBlank(req.getDjrq())
                && StringUtils.isNotBlank(req.getDkrq())) {
            djrc = DateUtil.daysBetween(
                DateUtil.strToDate(req.getDkrq(),
                    DateUtil.FRONT_DATE_FORMAT_STRING),
                DateUtil.strToDate(req.getDjrq(),
                    DateUtil.FRONT_DATE_FORMAT_STRING));
        }

        // 放款日差
        Integer fkrc = null;
        if (StringUtils.isNotBlank(req.getYhfkrq())
                && StringUtils.isNotBlank(req.getDkrq())) {
            fkrc = DateUtil.daysBetween(
                DateUtil.strToDate(req.getDkrq(),
                    DateUtil.FRONT_DATE_FORMAT_STRING),
                DateUtil.strToDate(req.getYhfkrq(),
                    DateUtil.FRONT_DATE_FORMAT_STRING));
        }

        // 抵押日差
        Integer dyrc = null;
        if (StringUtils.isNotBlank(req.getDyrq())
                && StringUtils.isNotBlank(req.getDkrq())) {
            dyrc = DateUtil.daysBetween(
                DateUtil.strToDate(req.getDkrq(),
                    DateUtil.FRONT_DATE_FORMAT_STRING),
                DateUtil.strToDate(req.getDyrq(),
                    DateUtil.FRONT_DATE_FORMAT_STRING));
        }

        double zhll = StringValidater.toDouble(req.getZhll());

        // 原： 应收返点金额=((综合利率-11.07%)/1.1107+11.07%-11.8%）*贷款额-贷款额*1%
        // Long ysfdje = AmountUtil.mul(
        // (AmountUtil.div((zhll - 0.1107), 1.1107) + 0.1107 - 0.118), dkje)
        // - AmountUtil.mul(dkje, 0.01);

        // 现： 应收返点金额=返点金额-评估费-垫资利息-（隐藏的GPS打件费400那个金额）
        Long ysfdje = fdje - pgFee - dzlx - gpsDjFee;
        String code = null;
        if (data == null) {
            code = businessBO.saveBusiness(req, dzlx, fdje, pgFee,
                AmountUtil.mul(dkje, 0.01),
                StringValidater.toLong(req.getYwfxbzj()), fbhrc, fkrc, dyrc,
                djrc, zhll, ysfdje);
        } else {
            businessBO.refreshBusiness(data, req, dzlx, fdje, pgFee,
                AmountUtil.mul(data.getDkje(), 0.01),
                StringValidater.toLong(req.getYwfxbzj()), fbhrc, fkrc, dyrc,
                djrc, zhll, ysfdje);
            code = data.getCode();
        }
        return code;
    }

    public static void main(String[] args) {
        // double div = AmountUtil.div((0.01 - 0.1107), 1.1107);
        // BigDecimal d1 = new BigDecimal("0.1107").add(new BigDecimal(div));
        // BigDecimal d2 = d1.subtract(new BigDecimal("0.118"));
        // BigDecimal divide = d2.multiply(new BigDecimal("12000"));
        // BigDecimal long2 = new BigDecimal("12000")
        // .multiply(new BigDecimal("0.01"));
        // BigDecimal s = divide.subtract(long2);
        // System.out.println(s);

        Double d1 = AmountUtil.div((0.2 - 0.1107), 1.1107);
        Double d2 = d1 + 0.1107 - 0.118;
        Long long1 = AmountUtil.mul((d2), 12000);
        Long long2 = AmountUtil.mul(12000, 0.01);
        Long ysfdje = long1 - long2;
        System.out.println(ysfdje);
    }

    @Override
    public Paginable<Business> queryBusinessPage(Business condition, int start,
            int limit) {
        Paginable<Business> page = businessBO.getPaginable(start, limit,
            condition);
        return page;
    }

    @Override
    public List<Business> queryBusinessList(Business condition) {
        return businessBO.queryBusinessList(condition);
    }

    @Override
    public Business getBusiness(String code) {
        return businessBO.getBusiness(code);
    }
}
