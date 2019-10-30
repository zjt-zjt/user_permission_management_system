package com.lanou.upms.web;

import com.lanou.upms.bean.Data;
import com.lanou.upms.bean.User;
import com.lanou.upms.service.UserListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class userlistController {
    @Autowired
    private UserListService userListService;

    @RequestMapping("/list")
    public Data<User> queryusers(Model model,
                                 @RequestParam(value = "page", required = false, defaultValue = "1") Integer currentPage,
                                 @RequestParam(value = "limit", required = false, defaultValue = "10") Integer pageSize,
                                 @RequestParam(required = false)  User user){

         return userListService.queryUserList(null, pageSize, currentPage);

    }





}
