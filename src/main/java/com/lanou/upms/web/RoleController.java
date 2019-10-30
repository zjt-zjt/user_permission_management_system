package com.lanou.upms.web;

import com.lanou.upms.bean.LayUITableData;
import com.lanou.upms.bean.Role;
import com.lanou.upms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public LayUITableData<Role> queryRole(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") Integer currentPage,
                                          @RequestParam(value = "limit", required = false, defaultValue = "10") Integer pageSize,
                                          @RequestParam(required = false) Role condition) {

        return roleService.queryRoleForLayUI(null, pageSize, currentPage);
    }
}

