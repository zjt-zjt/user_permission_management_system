package com.lanou.upms.service;


import com.lanou.upms.bean.User;

public interface LoginService {
    User findUserByUsername(String username);
}
