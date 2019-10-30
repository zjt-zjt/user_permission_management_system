<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2019/10/29
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
<form action="/user/edit"  method="post" class="layui-form">
    <table style="width:500px;height:300px;margin-left: 50px;margin-right: 20px">
        <tr>
            <td>
                管理员:
            </td>
            <td>
                <input type="text" name="username" id="employee" required lay-verify="required" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
            <td>
                初始密码:
            </td>
            <td>
                <input type="password" name="password" id="password1" required lay-verify="required" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
            <td>
                确认密码:
            </td>
            <td>
                <input type="password" name="password1" id="password2" required lay-verify="required" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
            <td>
                性别:
            </td>
            <td>
                <div class="layui-input-block">
                    男  <input type="radio" name="sex" value="男" title="男" id="sex1" checked="">
                    女  <input type="radio" name="sex" value="女" title="女" id="sex2">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                手机:
            </td>
            <td>
                <input type="number" name="phone" id="phone" required lay-verify="required" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
            <td>
                邮箱:
            </td>
            <td>
                <input type="email" name="email" id="email" required lay-verify="required" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
            <td>
                角色:
            </td>
            <td>
                <%-- <select lay-verify="required" id="role" name="role">
                 </select>--%>

                <select name="rolename" >
                    <option value="超级管理员">超级管理员</option>
                    <option value="栏目编辑">栏目编辑</option>
                    <option value="总编">总编</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                备注:
            </td>
            <td>
                <textarea  id="content" name="content" class="layui-textarea"></textarea>
            </td>
        </tr>
        <tr>
            <td>
            </td>
            <td>
                <input type="hidden" name="action" value="send">
                <input type="submit" class="layui-btn layui-btn-normal">
            </td>
            <td>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
