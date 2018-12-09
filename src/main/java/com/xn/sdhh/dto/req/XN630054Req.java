package com.xn.sdhh.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 根据旧密码修改新密码
 * @author: CYL 
 * @since: 2018年12月9日 下午4:04:43 
 * @history:
 */
public class XN630054Req {

    // userId
    @NotBlank(message = "userId不能为空")
    private String userId;

    // 原登录密码
    @NotBlank(message = "原登录密码不能为空")
    private String oldLoginPwd;

    // 新登录密码
    @NotBlank(message = "新登录密码不能为空")
    private String newLoginPwd;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOldLoginPwd() {
        return oldLoginPwd;
    }

    public void setOldLoginPwd(String oldLoginPwd) {
        this.oldLoginPwd = oldLoginPwd;
    }

    public String getNewLoginPwd() {
        return newLoginPwd;
    }

    public void setNewLoginPwd(String newLoginPwd) {
        this.newLoginPwd = newLoginPwd;
    }

}
