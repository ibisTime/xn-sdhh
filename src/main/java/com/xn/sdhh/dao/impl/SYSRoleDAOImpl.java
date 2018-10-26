package com.xn.sdhh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xn.sdhh.dao.ISYSRoleDAO;
import com.xn.sdhh.dao.base.support.AMybatisTemplate;
import com.xn.sdhh.domain.SYSRole;

@Repository("sysRoleDAOImpl")
public class SYSRoleDAOImpl extends AMybatisTemplate implements ISYSRoleDAO {

    @Override
    public int insert(SYSRole data) {
        return super.insert(NAMESPACE.concat("insert_sysRole"), data);
    }

    @Override
    public int delete(SYSRole data) {
        return super.delete(NAMESPACE.concat("delete_sysRole"), data);
    }

    @Override
    public SYSRole select(SYSRole condition) {
        return super.select(NAMESPACE.concat("select_sysRole"), condition,
            SYSRole.class);
    }

    @Override
    public long selectTotalCount(SYSRole condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_sysRole_count"),
            condition);
    }

    @Override
    public List<SYSRole> selectList(SYSRole condition) {
        return super.selectList(NAMESPACE.concat("select_sysRole"), condition,
            SYSRole.class);
    }

    @Override
    public List<SYSRole> selectList(SYSRole condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_sysRole"), start,
            count, condition, SYSRole.class);
    }

    @Override
    public int update(SYSRole data) {
        return super.update(NAMESPACE.concat("update_sysRole"), data);
    }

}
