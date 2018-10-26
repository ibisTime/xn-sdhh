package com.xn.sdhh.api.impl;

import com.xn.sdhh.ao.IBusinessAO;
import com.xn.sdhh.api.AProcessor;
import com.xn.sdhh.common.JsonUtil;
import com.xn.sdhh.core.ObjValidater;
import com.xn.sdhh.dto.req.XN301221Req;
import com.xn.sdhh.dto.res.BooleanRes;
import com.xn.sdhh.exception.BizException;
import com.xn.sdhh.exception.ParaException;
import com.xn.sdhh.spring.SpringContextHolder;

/**
 * 删除业务
 * @author: 55484 
 * @since: 2018年10月24日 下午8:01:59 
 * @history:
 */
public class XN301221 extends AProcessor {

    private IBusinessAO businessAO = SpringContextHolder
        .getBean(IBusinessAO.class);

    private XN301221Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        businessAO.removeBusiness(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN301221Req.class);
        ObjValidater.validateReq(req);
    }

}
