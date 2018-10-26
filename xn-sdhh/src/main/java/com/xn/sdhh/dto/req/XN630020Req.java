package com.xn.sdhh.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 菜单角色-查询菜单列表Req
 * @author: xieyj 
 * @since: 2016年5月16日 下午10:45:20 
 * @history:
 */
public class XN630020Req extends AListReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -7984371747655264073L;

    // 角色编号（必填）
    @NotBlank
    private String roleCode;

    // 类型(选填)
    private String type;

    // 父菜单编号(选填)
    private String parentCode;

    // 系统编号(必填)
    @NotBlank
    private String systemCode;

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
