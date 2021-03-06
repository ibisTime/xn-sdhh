package com.xn.sdhh.bo;

import java.util.List;

import com.xn.sdhh.bo.base.IPaginableBO;
import com.xn.sdhh.domain.Business;
import com.xn.sdhh.dto.req.XN301220Req;

public interface IBusinessBO extends IPaginableBO<Business> {

    public String saveBusiness(XN301220Req req, Long dzlx, Long fdje, Long pgf,
            Long bzjdke, Long ywfxbzj, Integer fbhrc, Integer fkrc,
            Integer dyrc, Integer djrc, double zhll, Long ysfdje);

    public void removeBusiness(Business data);

    public void refreshBusiness(Business data, XN301220Req req, Long dzlx,
            Long fdje, Long pgf, Long bzjdke, Long ywfxbzj, Integer fbhrc,
            Integer fkrc, Integer dyrc, Integer djrc, double zhll, Long ysfdje);

    // 列表查询业务
    public List<Business> queryBusinessList(Business condition);

    // 详情查询业务
    public Business getBusiness(String code);

}
