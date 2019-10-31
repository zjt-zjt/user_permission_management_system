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

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/user")
public class editController {

    @RequestMapping("/edit")

    public String edit(HttpServletRequest request, HttpServletResponse resp){


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
              String admin_id = request.getParameter("admin_id");
               HttpSession session = request.getSession();

               testMapper.editRole(rolename,admin_id);

//                 User user = new User();
//                 Role role = new Role();
//                 user.setUsername(useranme);
//                 user.setPassword(password);
//                 user.setPhone(phone);
//                 user.setEmail(email);
//                 role.setRoleName(rolename);
                 testMapper.edit(useranme, password, phone, email,admin_id);
                   return "编辑成功";
    }

    @RequestMapping("/edit2")
    public void  edit2(HttpServletRequest request){
        String   id =  request.getParameter("id");
        request.getSession().setAttribute("admin_id", id);

        InputStream is= null;
        try {
            is = Resources.getResourceAsStream("mybatis_conf.xml");

        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession =  sqlSessionFactory.openSession(true);
        TestMapper testMapper =   sqlSession.getMapper(TestMapper.class);
        List<User> users = testMapper.queryById(id);
        HttpSession session = request.getSession();
        Role role = testMapper.queryByIdRole(id);
        request.getSession().setAttribute("rolename",role.getRoleName());

        for(User user:users){
            request.getSession().setAttribute("username",user.getUsername());
            request.getSession().setAttribute("password",user.getPassword());
            request.getSession().setAttribute("phone",user.getPhone());
            request.getSession().setAttribute("email",user.getEmail());
        }


//        request.getSession().setAttribute("username","username");
//        request.getSession().setAttribute("password","password");
//        request.getSession().setAttribute("phone","phone");
//       request.getSession().setAttribute("email","email");




    }



}
