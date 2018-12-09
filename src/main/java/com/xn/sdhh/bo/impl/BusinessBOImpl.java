package com.xn.sdhh.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xn.sdhh.bo.IBusinessBO;
import com.xn.sdhh.bo.base.PaginableBOImpl;
import com.xn.sdhh.common.DateUtil;
import com.xn.sdhh.core.EGeneratePrefix;
import com.xn.sdhh.core.OrderNoGenerater;
import com.xn.sdhh.core.StringValidater;
import com.xn.sdhh.dao.IBusinessDAO;
import com.xn.sdhh.domain.Business;
import com.xn.sdhh.dto.req.XN301220Req;
import com.xn.sdhh.enums.EBusinessStatus;
import com.xn.sdhh.exception.BizException;

@Component
public class BusinessBOImpl extends PaginableBOImpl<Business>
        implements IBusinessBO {

    @Autowired
    IBusinessDAO businessDAO;

    @Override
    public String saveBusiness(XN301220Req req, Long dzlx, Long fdje, Long pgf,
            Long bzjdke, Integer fbhrc, Integer fkrc, Integer dyrc,
            Integer djrc, double zhll, Long ysfdje) {
        String code = OrderNoGenerater
            .generate(EGeneratePrefix.BUSINESS.getCode());
        Business data = new Business();
        data.setCode(code);
        data.setQyfzrmc(req.getQyfzrmc());
        data.setQczl(req.getQczl());

        data.setKhmc(req.getKhmc());
        data.setDkje(StringValidater.toLong(req.getDkje()));
        data.setZhll(zhll);
        data.setDyrc(dyrc);
        data.setPgf(pgf);

        data.setQdf(StringValidater.toLong(req.getQdf()));
        data.setQdfffrq(DateUtil.strToDate(req.getQdfffrq(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setJx(StringValidater.toLong(req.getJx()));
        data.setQtlr(StringValidater.toLong(req.getQtlr()));
        data.setYhfkrq(DateUtil.strToDate(req.getYhfkrq(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setDkrq(DateUtil.strToDate(req.getDkrq(),
            DateUtil.FRONT_DATE_FORMAT_STRING));

        data.setFkrc(fkrc);
        data.setGshkrq(DateUtil.strToDate(req.getGshkrq(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setFbhhsrq(DateUtil.strToDate(req.getFbhhsrq(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setFbhrc(fbhrc);
        data.setWzdzrq(DateUtil.strToDate(req.getWzdzrq(),
            DateUtil.FRONT_DATE_FORMAT_STRING));

        data.setDjrq(DateUtil.strToDate(req.getDjrq(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setDjrc(djrc);
        data.setTerq(DateUtil.strToDate(req.getTerq(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setDyrq(DateUtil.strToDate(req.getDyrq(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setFdje(fdje);

        data.setPgf(pgf);
        data.setDzlx(dzlx);
        if (StringUtils.isNotBlank(req.getQdf())) {
            data.setQdf(StringValidater.toLong(req.getQdf()));
        } else {
            data.setQdf(0L);
        }

        if (StringUtils.isNotBlank(req.getJx())) {
            data.setJx(StringValidater.toLong(req.getJx()));
        } else {
            data.setJx(0L);
        }
        if (StringUtils.isNotBlank(req.getQtlr())) {
            data.setQtlr(StringValidater.toLong(req.getQtlr()));
        } else {
            data.setQtlr(0L);
        }

        data.setFdje(fdje);
        data.setBzjdke(bzjdke);
        data.setYsfdje(ysfdje);
        // 毛利润=应收返点金额-渠道费-绩效+其他利
        data.setMlr(
            data.getYsfdje() - data.getQdf() - data.getJx() + data.getQtlr());
        data.setStatus(EBusinessStatus.ARCHIVE_NO.getCode());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());

        businessDAO.insert(data);
        return code;
    }

    @Override
    public List<Business> queryBusinessList(Business condition) {
        return businessDAO.selectList(condition);
    }

    @Override
    public Business getBusiness(String code) {
        Business data = null;
        if (StringUtils.isNotBlank(code)) {
            Business condition = new Business();
            condition.setCode(code);
            data = businessDAO.select(condition);
            if (null == data) {
                throw new BizException("xn00000", "业务:" + code + "不存在");
            }
        }
        return data;
    }

    @Override
    public void refreshBusiness(Business data, XN301220Req req, Long dzlx,
            Long fdje, Long pgf, Long bzjdke, Integer fbhrc, Integer fkrc,
            Integer dyrc, Integer djrc, double zhll, Long ysfdje) {
        data.setQyfzrmc(req.getQyfzrmc());
        data.setQczl(req.getQczl());
        data.setKhmc(req.getKhmc());

        data.setDyrc(dyrc);
        data.setDkje(StringValidater.toLong(req.getDkje()));
        data.setZhll(zhll);

        data.setPgf(pgf);
        data.setQdf(StringValidater.toLong(req.getQdf()));
        data.setQdfffrq(DateUtil.strToDate(req.getQdfffrq(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setJx(StringValidater.toLong(req.getJx()));
        data.setQtlr(StringValidater.toLong(req.getQtlr()));

        data.setYhfkrq(DateUtil.strToDate(req.getYhfkrq(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setDkrq(DateUtil.strToDate(req.getDkrq(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setFkrc(fkrc);

        data.setGshkrq(DateUtil.strToDate(req.getGshkrq(),
            DateUtil.FRONT_DATE_FORMAT_STRING));

        data.setFbhhsrq(DateUtil.strToDate(req.getFbhhsrq(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setFbhrc(fbhrc);
        data.setWzdzrq(DateUtil.strToDate(req.getWzdzrq(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setDjrq(DateUtil.strToDate(req.getDjrq(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setDjrc(djrc);

        data.setTerq(DateUtil.strToDate(req.getTerq(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setDyrq(DateUtil.strToDate(req.getDyrq(),
            DateUtil.FRONT_DATE_FORMAT_STRING));

        data.setFdje(fdje);
        data.setPgf(pgf);
        data.setDzlx(dzlx);
        if (StringUtils.isNotBlank(req.getQdf())) {
            data.setQdf(StringValidater.toLong(req.getQdf()));
        } else {
            data.setQdf(0L);
        }

        if (StringUtils.isNotBlank(req.getJx())) {
            data.setJx(StringValidater.toLong(req.getJx()));
        } else {
            data.setJx(0L);
        }

        if (StringUtils.isNotBlank(req.getQtlr())) {
            data.setQtlr(StringValidater.toLong(req.getQtlr()));
        } else {
            data.setQtlr(0L);
        }

        data.setFdje(fdje);
        data.setBzjdke(bzjdke);
        data.setYsfdje(ysfdje);
        // 毛利润=应收返点金额-渠道费-绩效+其他利
        data.setMlr(
            data.getYsfdje() - data.getQdf() - data.getJx() + data.getQtlr());

        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());

        businessDAO.update(data);
    }

    @Override
    public void removeBusiness(Business data) {
        businessDAO.delete(data);
    }

}
