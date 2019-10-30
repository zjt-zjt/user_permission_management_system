package com.lanou.upms.mapper;

import com.lanou.upms.bean.Role;

import java.util.List;

public interface TestRoleMapper {
    List<Role> queryAll();
    int update(String id);
}
