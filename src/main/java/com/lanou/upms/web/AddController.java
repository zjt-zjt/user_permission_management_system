package com.lanou.upms.web;


import com.lanou.upms.bean.Role;
import com.lanou.upms.bean.User;
import com.lanou.upms.mapper.TestMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/user")
public class AddController {

    @RequestMapping("/add")
    public  String add(HttpServletRequest request){
        InputStream is= null;
        try {
            is = Resources.getResourceAsStream("mybatis_conf.xml");

        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession =  sqlSessionFactory.openSession(true);
        TestMapper testMapper =   sqlSession.getMapper(TestMapper.class);


         String   username =  request.getParameter("username");
         String password  = request.getParameter("password");
         String    phone  =      request.getParameter("phone");
         String email =  request.getParameter("email");
         String  rolename =   request.getParameter("rolename");
           System.out.println(rolename);
           Role role  = new Role();
          User  user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setPhone(phone);
            user.setEmail(email);
            role.setRoleName(rolename);
            testMapper.insertUser(user);
            testMapper.insertRole(role);
           return  "添加成功！";
    }

}
