package com.lanou.upms.service;

import com.lanou.upms.bean.Data;
import com.lanou.upms.bean.User;

import java.util.List;

public interface UserListService {
//    List<User> queryusers(User user);
    Data<User> queryUserList(User user, Integer pageSize, Integer currentPage);
    List<User> queryAll();
    int update(String  id );
    //int insertUser(User user);
    //int edit(String  id );
}
