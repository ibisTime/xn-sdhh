package com.xn.sdhh.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xn.sdhh.ao.IBusinessAO;
import com.xn.sdhh.bo.IBusinessBO;
import com.xn.sdhh.bo.ISYSConfigBO;
import com.xn.sdhh.bo.base.Paginable;
import com.xn.sdhh.common.DateUtil;
import com.xn.sdhh.core.StringValidater;
import com.xn.sdhh.domain.Business;
import com.xn.sdhh.domain.SYSConfig;
import com.xn.sdhh.dto.req.XN301220Req;
import com.xn.sdhh.dto.req.XN301222Req;
import com.xn.sdhh.enums.EBusinessStatus;
import com.xn.sdhh.enums.ECarKind;
import com.xn.sdhh.enums.ESysConfigType;

@Service
public class BusinessAOImpl implements IBusinessAO {

    @Autowired
    IBusinessBO businessBO;

    @Autowired
    ISYSConfigBO sysConfigBO;

    @Override
    public String addBusiness(XN301220Req req) {
        // 计算返点金额
        Long fdje = 0L;
        Long bzjdke = 0L;
        if (StringUtils.isNotBlank(req.getDkje())) {
            Long dkje = StringValidater.toLong(req.getDkje());
            Double d = (StringValidater.toDouble(req.getZhll()) / 100 - 0.118)
                    / 1.1107;
            fdje = (long) (dkje * d - (dkje * 0.01) - 400);
            bzjdke = (long) (dkje * 0.01);
        }

        // 评估费
        Long pgf = 0L;
        if (ECarKind.CAR_SECOND.getCode().equals(req.getQczl())) {
            SYSConfig config = sysConfigBO
                .getConfig(ESysConfigType.PG_AMOUNT.getCode());
            if (null != config) {
                pgf = StringValidater.toLong(config.getCvalue());
            }
        }

        // 垫资利息
        Long dzlx = 0L;
        if (StringUtils.isNotBlank(req.getYhfkrq())
                && StringUtils.isNotBlank(req.getWzdzrq())
                && StringUtils.isNotBlank(req.getDkje())) {
            Long dkje = StringValidater.toLong(req.getDkje());
            Date yhfkrq = DateUtil.strToDate(req.getYhfkrq(),
                DateUtil.FRONT_DATE_FORMAT_STRING);
            Date wzdzrq = DateUtil.strToDate(req.getWzdzrq(),
                DateUtil.FRONT_DATE_FORMAT_STRING);
            dzlx = (long) ((dkje * 0.016) / 30
                    * (DateUtil.daysBetween(wzdzrq, yhfkrq) + 1));
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
        // 获取评估费
        return businessBO.saveBusiness(req, dzlx, fdje, pgf, bzjdke, fbhrc,
            fkrc, dyrc, djrc);
    }

    @Override
    public Paginable<Business> queryBusinessPage(Business condition, int start,
            int limit) {
        return businessBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Business> queryBusinessList(Business condition) {
        return businessBO.queryBusinessList(condition);
    }

    @Override
    public Business getBusiness(String code) {
        return businessBO.getBusiness(code);
    }

    @Override
    public void editBusiness(XN301222Req req) {
        Business data = businessBO.getBusiness(req.getCode());
        this.js(data, req);
    }

    @Override
    public void removeBusiness(String code) {
        Business data = businessBO.getBusiness(code);
        businessBO.removeBusiness(data);

    }

    @Override
    public void archiveBusiness(XN301222Req req) {
        Business data = businessBO.getBusiness(req.getCode());
        data.setStatus(EBusinessStatus.ARCHIVE_YES.getCode());
        this.js(data, req);

    }

    private void js(Business data, XN301222Req req) {
        // 计算返点金额
        Long fdje = 0L;
        Long bzjdke = 0L;
        if (StringUtils.isNotBlank(req.getDkje())) {
            Long dkje = StringValidater.toLong(req.getDkje());
            Double d = (StringValidater.toDouble(req.getZhll()) / 100 - 0.118)
                    / 1.1107;
            fdje = (long) (dkje * d - (dkje * 0.01) - 400);
            bzjdke = (long) (dkje * 0.01);
        }

        // 评估费
        Long pgf = 0L;
        if (ECarKind.CAR_SECOND.getCode().equals(req.getQczl())) {
            SYSConfig config = sysConfigBO
                .getConfig(ESysConfigType.PG_AMOUNT.getCode());
            if (null != config) {
                pgf = StringValidater.toLong(config.getCvalue());
            }
        }

        // 垫资利息
        Long dzlx = 0L;
        if (StringUtils.isNotBlank(req.getYhfkrq())
                && StringUtils.isNotBlank(req.getWzdzrq())
                && StringUtils.isNotBlank(req.getDkje())) {
            Long dkje = StringValidater.toLong(req.getDkje());
            Date yhfkrq = DateUtil.strToDate(req.getYhfkrq(),
                DateUtil.FRONT_DATE_FORMAT_STRING);
            Date wzdzrq = DateUtil.strToDate(req.getWzdzrq(),
                DateUtil.FRONT_DATE_FORMAT_STRING);
            dzlx = (long) ((dkje * 0.016) / 30
                    * (DateUtil.daysBetween(wzdzrq, yhfkrq) + 1));
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
        businessBO.refreshBusiness(data, req, dzlx, fdje, pgf, bzjdke, fbhrc,
            fkrc, dyrc, djrc);
    }

}
