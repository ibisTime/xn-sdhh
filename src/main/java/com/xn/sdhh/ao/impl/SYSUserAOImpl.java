package com.xn.sdhh.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xn.sdhh.ao.ISYSUserAO;
import com.xn.sdhh.bo.ISYSRoleBO;
import com.xn.sdhh.bo.ISYSUserBO;
import com.xn.sdhh.bo.ISmsOutBO;
import com.xn.sdhh.bo.base.Paginable;
import com.xn.sdhh.common.DateUtil;
import com.xn.sdhh.common.MD5Util;
import com.xn.sdhh.common.PhoneUtil;
import com.xn.sdhh.common.PwdUtil;
import com.xn.sdhh.core.OrderNoGenerater;
import com.xn.sdhh.domain.SYSRole;
import com.xn.sdhh.domain.SYSUser;
import com.xn.sdhh.enums.EBizErrorCode;
import com.xn.sdhh.enums.ESystemCode;
import com.xn.sdhh.enums.EUser;
import com.xn.sdhh.enums.EUserStatus;
import com.xn.sdhh.exception.BizException;

@Service
public class SYSUserAOImpl implements ISYSUserAO {

    @Autowired
    ISYSUserBO sysUserBO;

    @Autowired
    ISYSRoleBO sysRoleBO;

    @Autowired
    ISmsOutBO smsOutBO;

    // 新增用户
    @Override
    public String addSYSUser(String mobile, String loginPwd, String realName,
            String photo, String remark) {
        sysUserBO.isMobileExist(mobile);
        SYSUser data = new SYSUser();
        String userId = OrderNoGenerater.generate("U");
        data.setUserId(userId);
        data.setMobile(mobile);

        data.setRealName(realName);
        data.setLoginName(mobile);
        data.setLoginPwd(MD5Util.md5(loginPwd));
        data.setLoginPwdStrength(PwdUtil.calculateSecurityLevel(loginPwd));
        data.setPhoto(photo);

        data.setStatus(EUserStatus.NORMAL.getCode());
        data.setCreateDatetime(new Date());
        data.setSystemCode(ESystemCode.BH.getCode());
        data.setRemark(remark);
        sysUserBO.doSaveSYSuser(data);

        return userId;
    }

    // 用户登录
    @Override
    public String doLogin(String loginName, String loginPwd) {
        SYSUser condition = new SYSUser();
        condition.setLoginName(loginName);
        List<SYSUser> userList1 = sysUserBO.queryUserList(condition);
        if (CollectionUtils.isEmpty(userList1)) {
            throw new BizException("xn805050", "登录名不存在");
        }
        condition.setLoginPwd(MD5Util.md5(loginPwd));
        List<SYSUser> userList2 = sysUserBO.queryUserList(condition);
        if (CollectionUtils.isEmpty(userList2)) {
            throw new BizException("xn805050", "登录密码错误");
        }
        SYSUser user = userList2.get(0);
        return user.getUserId();
    }

    // 注销，激活其他管理员
    @Override
    public void doCloseOpen(String userId, String updater, String remark) {
        SYSUser user = sysUserBO.getSYSUser(userId);
        if (user == null) {
            throw new BizException("li01004", "用户不存在");
        }
        // admin 不注销
        if (EUser.ADMIN.getCode().equals(user.getLoginName())) {
            throw new BizException("li01004", "管理员无法注销");
        }
        String mobile = user.getMobile();
        String smsContent = "";
        EUserStatus userStatus = null;
        if (EUserStatus.NORMAL.getCode().equalsIgnoreCase(user.getStatus())) {
            smsContent = "您的账号已被管理员封禁";
            userStatus = EUserStatus.Ren_Locked;
        } else {
            smsContent = "您的账号已被管理员解封,请遵守平台相关规则";
            userStatus = EUserStatus.NORMAL;
        }
        sysUserBO.refreshStatus(userId, userStatus, updater, remark);
        if (PhoneUtil.isMobile(mobile)) {
            // 发送短信
            smsOutBO.sendSmsOut(mobile, "尊敬的" + PhoneUtil.hideMobile(mobile)
                    + smsContent, "805091");
        }

    }

    // 设置角色
    @Override
    public void doRoleSYSUser(String userId, String roleCode, String updater,
            String remark) {
        SYSUser user = sysUserBO.getSYSUser(userId);
        if (user == null) {
            throw new BizException("li01004", "用户不存在");
        }
        SYSRole role = sysRoleBO.getSYSRole(roleCode);
        if (role == null) {
            throw new BizException("li01004", "角色不存在");
        }
        sysUserBO.refreshRole(userId, roleCode, updater, remark);
    }

    // 重置其他管理员密码
    @Override
    public void resetAdminLoginPwd(String userId, String newLoginPwd) {
        SYSUser user = sysUserBO.getSYSUser(userId);
        sysUserBO.resetAdminLoginPwd(user, newLoginPwd);
    }

    // 重置登录密码
    @Override
    public void resetSelfPwd(String mobile, String smsCaptcha,
            String newLoginPwd) {
        // 判断手机号是否存在

        SYSUser user = sysUserBO.getUserByMobile(mobile);
        String oldPwd = user.getLoginPwd();
        if (newLoginPwd.equals(oldPwd)) {
            throw new BizException("xn000000", "新密码与原密码一致");
        }

        // 新密码验证
        smsOutBO.checkCaptcha(mobile, smsCaptcha, "627090",
            user.getSystemCode());
        sysUserBO.resetSelfPwd(user, newLoginPwd);
        // 发送短信
        smsOutBO.sendSmsOut(
            mobile,
            "尊敬的"
                    + PhoneUtil.hideMobile(mobile)
                    + "用户，您于"
                    + DateUtil.dateToStr(new Date(),
                        DateUtil.DATA_TIME_PATTERN_1) + "已更改登录密码"
                    + "，请妥善保管您的账户相关信息。", "631072");
    }

    @Override
    public void editPwd(String userId, String oldPwd, String newPwd) {
        SYSUser user = sysUserBO.getSYSUser(userId);
        if (!user.getLoginPwd().equals(MD5Util.md5(oldPwd))) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "旧密码错误");
        }
        sysUserBO.resetSelfPwd(user, newPwd);
    }

    // 更换绑定手机号
    @Override
    public void doResetMoblie(String userId, String newMobile, String smsCaptcha) {
        SYSUser user = sysUserBO.getSYSUser(userId);
        String oldMobile = user.getMobile();
        if (newMobile.equals(oldMobile)) {
            throw new BizException("xn000000", "新手机与原手机一致");
        }
        // 判断手机号是否存在
        sysUserBO.isMobileExist(newMobile);
        // 新手机号验证
        smsOutBO.checkCaptcha(newMobile, smsCaptcha, "627090",
            user.getSystemCode());
        sysUserBO.resetBindMobile(user, newMobile);
        // 发送短信
        smsOutBO.sendSmsOut(
            oldMobile,
            "尊敬的"
                    + PhoneUtil.hideMobile(oldMobile)
                    + "用户，您于"
                    + DateUtil.dateToStr(new Date(),
                        DateUtil.DATA_TIME_PATTERN_1) + "已将手机号码改为" + newMobile
                    + "，您的登录名更改为" + newMobile + "，请妥善保管您的账户相关信息。", "631072");

    }

    // 分页查询
    @Override
    public Paginable<SYSUser> querySYSUserPage(int start, int limit,
            SYSUser condition) {

        if (condition.getCreateDatetimeStart() != null
                && condition.getCreateDatetimeEnd() != null
                && condition.getCreateDatetimeStart().after(
                    condition.getCreateDatetimeEnd())) {
            throw new BizException("xn00000", "开始时间不能大于结束时间");
        }

        return sysUserBO.getPaginable(start, limit, condition);
    }

    // 列表查询
    public List<SYSUser> querySYSUserList(SYSUser condition) {
        List<SYSUser> list = sysUserBO.queryUserList(condition);
        return list;

    }

    // 详细查询
    public SYSUser getSYSUser(String code) {
        return sysUserBO.getSYSUser(code);

    }

    @Override
    public void doModifyLoginPwd(String userId, String oldLoginPwd,
            String newLoginPwd) {
        if (oldLoginPwd.equals(newLoginPwd)) {
            throw new BizException("li01006", "新登录密码不能与原有密码重复");
        }
        // 验证当前登录密码是否正确
        sysUserBO.checkLoginPwd(userId, oldLoginPwd);
        // 重置
        sysUserBO.refreshLoginPwd(userId, newLoginPwd);
        // 发送短信
        // SYSUser user = sysUserBO.getUser(userId);
        // if (!EUserKind.Plat.getCode().equals(user.getType())) {
        // smsOutBO.sendSmsOut(user.getMobile(),
        // "尊敬的" + PhoneUtil.hideMobile(user.getMobile())
        // + "用户，您的登录密码修改成功。请妥善保管您的账户相关信息。",
        // "805064", user.getCompanyCode(), user.getSystemCode());
        // }
    }
}
