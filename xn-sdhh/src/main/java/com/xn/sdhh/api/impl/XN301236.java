package com.xn.sdhh.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xn.sdhh.ao.IBusinessAO;
import com.xn.sdhh.api.AProcessor;
import com.xn.sdhh.common.JsonUtil;
import com.xn.sdhh.core.ObjValidater;
import com.xn.sdhh.domain.Business;
import com.xn.sdhh.dto.req.XN301236Req;
import com.xn.sdhh.exception.BizException;
import com.xn.sdhh.exception.ParaException;
import com.xn.sdhh.spring.SpringContextHolder;

/**
 * 列表查询业务
 * @author: 55484 
 * @since: 2018年10月24日 下午8:01:59 
 * @history:
 */
public class XN301236 extends AProcessor {

    private IBusinessAO businessAO = SpringContextHolder
        .getBean(IBusinessAO.class);

    private XN301236Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Business condition = new Business();
        condition.setStatus(req.getStatus());
        condition.setQczl(req.getQczl());

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IBusinessAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());

        return businessAO.queryBusinessList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN301236Req.class);
        ObjValidater.validateReq(req);
    }

}
