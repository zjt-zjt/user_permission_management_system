package com.lanou.upms.mapper;



import com.lanou.upms.bean.Role;
import com.lanou.upms.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestMapper {
    List<User> queryAll();
    int update(String id);
    int insertUser(User user);
    int insertRole(Role role);
    //void updateUser(User user);
    //void updateRole(Role role);

    List<User> queryById( String id);


    Role queryByIdRole( String id);

    int editRole(@Param("roleName") String rolename,@Param("role_id") String role_id);

    int edit(@Param("username")  String username, @Param("password")String password, @Param("phone") String phone, @Param("email")String email, @Param("user_id") String user_id);
}
