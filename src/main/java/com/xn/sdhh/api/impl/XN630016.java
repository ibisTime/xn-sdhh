package com.xn.sdhh.api.impl;

import com.xn.sdhh.ao.ISYSMenuAO;
import com.xn.sdhh.api.AProcessor;
import com.xn.sdhh.common.JsonUtil;
import com.xn.sdhh.core.ObjValidater;
import com.xn.sdhh.dto.req.XN630016Req;
import com.xn.sdhh.exception.BizException;
import com.xn.sdhh.exception.ParaException;
import com.xn.sdhh.spring.SpringContextHolder;

/**
 * 菜单-详情
 * @author: xieyj 
 * @since: 2016年5月16日 下午9:39:48 
 * @history:
 */
public class XN630016 extends AProcessor {
    private ISYSMenuAO sysMenuAO = SpringContextHolder
        .getBean(ISYSMenuAO.class);

    private XN630016Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return sysMenuAO.getSYSMenu(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630016Req.class);
        ObjValidater.validateReq(req);
    }
}
