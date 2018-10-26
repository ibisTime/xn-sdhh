package com.xn.sdhh.api.impl;

import com.xn.sdhh.ao.ISYSMenuAO;
import com.xn.sdhh.api.AProcessor;
import com.xn.sdhh.common.JsonUtil;
import com.xn.sdhh.core.ObjValidater;
import com.xn.sdhh.dto.req.XN630010Req;
import com.xn.sdhh.dto.res.PKCodeRes;
import com.xn.sdhh.exception.BizException;
import com.xn.sdhh.exception.ParaException;
import com.xn.sdhh.spring.SpringContextHolder;

/**
 * 菜单-增加
 * @author: xieyj 
 * @since: 2016年5月16日 下午10:59:56 
 * @history:
 */
public class XN630010 extends AProcessor {

    private ISYSMenuAO sysMenuAO = SpringContextHolder
        .getBean(ISYSMenuAO.class);

    private XN630010Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        return new PKCodeRes(sysMenuAO.addSYSMenu(req));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630010Req.class);
        ObjValidater.validateReq(req);
    }
}
