package com.lanou.upms.service.impl;

import com.lanou.upms.bean.User;
import com.lanou.upms.bean.UserExample;
import com.lanou.upms.mapper.UserMapper;
import com.lanou.upms.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByUsername(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if (username != null) {
            criteria.andUsernameLike(username);
        }
        List<User> users = userMapper.selectByExample(userExample);

        if (users.size() == 0) {
            User user = null;
            return user;
        }

        System.out.println("==================");
        System.out.println(users.get(0));

        return users.get(0);
    }
}
