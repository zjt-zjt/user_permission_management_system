package com.lanou.upms.web;

import com.lanou.upms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/role")
public class RoleDelectController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/delete")
    public  int delete( HttpServletRequest req){
        String id =    req.getParameter("id");
        System.out.println(id);
        return roleService.update(id);
    }
}
