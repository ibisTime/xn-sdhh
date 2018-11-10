package com.xn.sdhh.api.impl;

import com.xn.sdhh.ao.IBusinessAO;
import com.xn.sdhh.api.AProcessor;
import com.xn.sdhh.common.JsonUtil;
import com.xn.sdhh.core.StringValidater;
import com.xn.sdhh.dto.req.XN301220Req;
import com.xn.sdhh.dto.res.PKCodeRes;
import com.xn.sdhh.exception.BizException;
import com.xn.sdhh.exception.ParaException;
import com.xn.sdhh.spring.SpringContextHolder;

/**
 * 录入业务
 * @author: nyc 
 * @since: 2018年7月29日 下午5:16:47 
 * @history:
 */
public class XN301220 extends AProcessor {

    private IBusinessAO businessAO = SpringContextHolder
        .getBean(IBusinessAO.class);

    private XN301220Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(businessAO.addBusiness(req));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN301220Req.class);
        StringValidater.validateBlank(req.getUpdater());
    }

}
