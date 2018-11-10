package com.xn.sdhh.ao;

import java.util.List;

import com.xn.sdhh.bo.base.Paginable;
import com.xn.sdhh.domain.Business;
import com.xn.sdhh.dto.req.XN301220Req;

public interface IBusinessAO {

    String DEFAULT_ORDER_COLUMN = "code";

    // 开始录入
    public String addBusiness(XN301220Req req);

    // 删除业务
    public void removeBusiness(String code);

    // 修改业务
    public void editBusiness(XN301220Req req);

    // 归档
    public void archiveBusiness(XN301220Req req);

    // 分页查询业务
    public Paginable<Business> queryBusinessPage(Business condition, int start,
            int limit);

    // 列表查询业务
    public List<Business> queryBusinessList(Business condition);

    // 详情查询业务
    public Business getBusiness(String code);

}
