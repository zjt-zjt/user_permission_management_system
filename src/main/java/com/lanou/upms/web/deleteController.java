package com.lanou.upms.web;


import com.lanou.upms.service.UserListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class deleteController {

    @Autowired
    private UserListService userListService;
    @RequestMapping("/delete")
    public  int delete( HttpServletRequest req){
       String id =    req.getParameter("id");
        System.out.println(id);
          return userListService.update(id);
    }

}
