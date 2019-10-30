package com.lanou.upms.web;


import com.lanou.upms.service.UserListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class deleteAll {

    @Autowired
    private UserListService userListService;
    @RequestMapping("/deleteAll")
    public  int delete( HttpServletRequest req){
        String id =    req.getParameter("id");
        for (String string : id.split(",")) {
            userListService.update(string);
        }
          return  1;
    }
}
