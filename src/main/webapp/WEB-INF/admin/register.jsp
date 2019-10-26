<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SMS短信息系统注册</title>
    <link href="/static/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="/static/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
    <script src="/static/bootstrap/js/jQuery.js"></script>
    <script src="/static/bootstrap/js/bootstrap.js"></script>

    <script type="text/javascript">
        function checkForm() {
            var userName = document.getElementById("userName").value;
            var password = document.getElementById("password").value;
            if (userName == null || userName == "") {
                document.getElementById("error").innerHTML = "用户名不能为空";
                return false;
            }
            if (password == null || password == "") {
                document.getElementById("error").innerHTML = "密码不能为空";
                return false;
            }
            return true;
        }
    </script>

    <style type="text/css">
        body {
            padding-top: 200px;
            padding-bottom: 40px;
            background-image: url('/static/img/bg2.png');
            /*background:url('/static/img/bg2.png');*/
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }

        .radio {
            padding-top: 10px;
            padding-bottom:10px;
        }

        .form-signin-heading{
            text-align: center;
        }

        .form-signin {
            max-width: 300px;
            padding: 19px 29px 0px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
            -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
            box-shadow: 0 1px 2px rgba(0,0,0,.05);
        }
        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }
        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }
    </style>

</head>
<body>
<div class="container">
    <form name="myForm" class="form-signin" action="RegisterServlet" method="post" onsubmit="return checkForm()">
        <h2 class="form-signin-heading"><font color="gray">SMS短信息系统注册</font></h2>
        <input id="account" name="account" type="text" class="input-block-level" placeholder="用户名..." >
        <input id="account" name="nickName" type="text" class="input-block-level" placeholder="昵称..." >
        <input id="account" name="email" type="text" class="input-block-level" placeholder="邮箱..." >
        <input id="password" name="password"  type="password" class="input-block-level" placeholder="密码..." >

        <button class="btn btn-large btn-primary" type="submit">注册</button>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<%--    <button class="btn btn-large btn-primary" type="button" >注册</button>--%>
<%--        <a href="register.jsp" target="_blank"><button class="btn btn-large btn-primary" type="button" >注册</button></a>--%>

        <p align="center" style="padding-top: 15px;"></p>
    </form>
</div>
</body>
</html>
