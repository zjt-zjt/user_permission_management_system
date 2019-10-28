package com.lanou.upms.web;

import com.lanou.upms.bean.ResponseInfo;
import com.lanou.upms.bean.User;
import com.lanou.upms.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    private static ResponseInfo ret = new ResponseInfo();
    @Autowired
    private LoginService loginService;

//    @RequestParam String username, @RequestParam String password, @RequestParam Boolean rememberMe,
    @RequestMapping("/login")
    public ResponseInfo login(HttpServletRequest req, HttpServletResponse resp) {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean rememberMe = Boolean.parseBoolean(req.getParameter("rememberMe"));

        System.out.println("rem: " + rememberMe + ", user: " + username + ", pwd: " + password);

        String error = "";
        if (username == null || username.trim().equals("")) {
            ret.setCode(406);
            ret.setMessage("用户名或密码错误!");
            return ret;
//            resp.getWriter().println(ret);
//            error = "用户名或密码错误";
//            sendError(req, resp, error);
        }
        if (password == null || password.trim().equals("")) {
            ret.setCode(407);
            ret.setMessage("用户名或密码错误!");
            return ret;
//            resp.getWriter().println(ret);
//            error = "用户名或密码错误";
//            sendError(req, resp, error);
        }

        // 从数据库中获取用户信息，和页面传来的信息作对比
        User user = loginService.findUserByUsername(username);
        if (user == null) {
            // 代表用户不存在
            ret.setCode(408);
            ret.setMessage("用户不存在!");
            return ret;
//            error = "用户不存在";
//            sendError(req, resp, error);
        }

        // 用户存在时，检查密码是否一致
        if (!user.getPassword().equals(password)) {
            // 代表密码不正确
            ret.setCode(409);
            ret.setMessage("用户名或密码错误!");
            return ret;
//            error = "用户名或密码错误";
//            sendError(req, resp, error);
        }


        // 获取显示在头像后面的昵称，添加到cookie内，在jsp内通过EL表达式获取显示
        System.out.println("当前登录用户昵称为：" + user.getUsername());
        // 添加到cookie
        Cookie adminCookie = new Cookie("username", user.getUsername());
        resp.addCookie(adminCookie);

        // 记住密码功能，如果复选框值为trur则添加cookie，否则添加空的cookie清理原有的cookie
        if (rememberMe != false) {
            System.out.println(user.getUsername());

            Cookie usernameCookie = new Cookie("username", username);
            Cookie pwdCookie = new Cookie("password", password);
            System.out.println(usernameCookie);

            resp.addCookie(usernameCookie);
            resp.addCookie(pwdCookie);
        } else {
            Cookie usernameCookie = new Cookie("username", null);
            Cookie pwdCookie = new Cookie("password", null);

            usernameCookie.setMaxAge(0);
            pwdCookie.setMaxAge(0);

            resp.addCookie(usernameCookie);
            resp.addCookie(pwdCookie);
        }

        if (user != null) {
            System.out.println("------------开始创建Session--------------");
            req.getSession().setAttribute("user", user);
            System.out.println("创建了Session：" + req.getSession().getAttribute("user").toString());
        }
        HttpSession session = req.getSession();
        System.out.println(session);

        ret.setCode(200);
        ret.setMessage("登录成功");
        ret.setData("/homePage");
        return ret;

    }

}
