package com.xn.sdhh.bo;

import java.util.List;

import com.xn.sdhh.bo.base.IPaginableBO;
import com.xn.sdhh.domain.Business;
import com.xn.sdhh.dto.req.XN301220Req;
import com.xn.sdhh.dto.req.XN301222Req;

public interface IBusinessBO extends IPaginableBO<Business> {

    public String saveBusiness(XN301220Req req, Long dzlx, Long fdje, Long pgf,
            Long bzjdke, Integer fbhrc, Integer fkrc, Integer dyrc,
            Integer djrc);

    public void removeBusiness(Business data);

    public void refreshBusiness(Business data, XN301222Req req, Long dzlx,
            Long fdje, Long pgf, Long bzjdke, Integer fbhrc, Integer fkrc,
            Integer dyrc, Integer djrc);

    // 列表查询业务
    public List<Business> queryBusinessList(Business condition);

    // 详情查询业务
    public Business getBusiness(String code);

}
