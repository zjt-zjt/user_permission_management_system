package com.lanou.upms.service;

import com.lanou.upms.bean.LayUITableData;
import com.lanou.upms.bean.Role;

import java.util.List;

public interface RoleService {
    //List<Role> queryRole(Role condition);
    LayUITableData<Role> queryRoleForLayUI(Role condition, Integer pageSize, Integer currentPage);

    List<Role> queryAll();

    int update(String id);

}
