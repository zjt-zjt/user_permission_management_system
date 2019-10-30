package com.lanou.upms.mapper;



import com.lanou.upms.bean.Role;
import com.lanou.upms.bean.User;

import java.util.List;

public interface TestMapper {
    List<User> queryAll();
    int update(String id);
    int insertUser(User user);
    int insertRole(Role role);
    void updateUser(User user);

}
