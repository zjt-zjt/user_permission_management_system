package com.lanou.upms.web;


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
public class editController {

    @RequestMapping("/edit")

    public String edit(HttpServletRequest request){


        InputStream is= null;
        try {
            is = Resources.getResourceAsStream("mybatis_conf.xml");

        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession =  sqlSessionFactory.openSession(true);
        TestMapper testMapper =   sqlSession.getMapper(TestMapper.class);
             String  useranme =  request.getParameter("username");
              String   password    =  request.getParameter("password");
              String phone = request.getParameter("phone");
              String  email = request.getParameter("email");
              String  rolename = request.getParameter("rolename");
                 User user = new User();
                 user.setUsername(useranme);
                 user.setPassword(password);
                 user.setPhone(phone);
                 user.setEmail(email);
                 testMapper.updateUser(user);
                   return "编辑成功";
    }

}
