package com.xn.sdhh.ao;

import java.util.List;

import com.xn.sdhh.bo.base.Paginable;
import com.xn.sdhh.domain.SYSMenu;
import com.xn.sdhh.dto.req.XN630010Req;

/**
 * 系统菜单
 * @author: Gejin 
 * @since: 2016年4月16日 下午7:38:53 
 * @history:
 */
public interface ISYSMenuAO {

    String DEFAULT_ORDER_COLUMN = "order_no";

    // 添加系统菜单
    public String addSYSMenu(XN630010Req req);

    // 删除系统菜单
    public boolean dropSYSMenu(String code);

    // 修改系统菜单
    public boolean editSYSMenu(SYSMenu data);

    // 分页查询
    public Paginable<SYSMenu> querySYSMenuPage(int start, int limit,
            SYSMenu condition);

    // 列表查询
    public List<SYSMenu> querySYSMenuList(SYSMenu condition);

    // 详细查询
    public SYSMenu getSYSMenu(String code);
}
