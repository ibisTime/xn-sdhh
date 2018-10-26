package com.xn.sdhh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xn.sdhh.dao.ISYSUserDAO;
import com.xn.sdhh.dao.base.support.AMybatisTemplate;
import com.xn.sdhh.domain.SYSUser;

@Repository("sysuserDAOImpl")
public class SYSUserDAOImpl extends AMybatisTemplate implements ISYSUserDAO {

    @Override
    public int insert(SYSUser data) {
        return super.insert(NAMESPACE.concat("insert_sysuser"), data);
    }

    @Override
    public SYSUser select(SYSUser condition) {
        return super.select(NAMESPACE.concat("select_sysuser"), condition,
            SYSUser.class);
    }

    @Override
    public List<SYSUser> selectList(SYSUser condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_sysuser"), start,
            count, condition, SYSUser.class);
    }

    @Override
    public List<SYSUser> selectList(SYSUser condition) {
        return super.selectList(NAMESPACE.concat("select_sysuser"), condition,
            SYSUser.class);
    }

    @Override
    public long selectTotalCount(SYSUser condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_sysuser_count"),
            condition);
    }

    @Override
    public int updateLoginName(SYSUser data) {
        return super.update(NAMESPACE.concat("update_sysuser_loginName"), data);
    }

    @Override
    public int updateLoginPwd(SYSUser data) {
        return super.update(NAMESPACE.concat("update_login_pwd"), data);
    }

    @Override
    public int update(SYSUser data) {
        return super.update(NAMESPACE.concat("update_sysuser"), data);
    }

    @Override
    public void resetBindMobile(SYSUser user) {
        super.update(NAMESPACE.concat("update_mobile"), user);
    }

    @Override
    public void updateStatus(SYSUser data) {
        super.update(NAMESPACE.concat("update_status"), data);
    }

    @Override
    public int updateRole(SYSUser data) {
        return super.update(NAMESPACE.concat("update_role"), data);
    }

    @Override
    public int delete(SYSUser data) {
        return 0;
    }

}
