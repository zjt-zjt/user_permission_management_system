<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2019/10/29
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <title>Title</title>


<%--    <link rel="stylesheet" href="/static/layui/css/layui.css">--%>
<%--    <script type="text/javascript" src="/static/layui/layui.js"></script>--%>
</head>
<body>
<form action="/user/edit"  method="post" class="layui-form">
    <table style="width:500px;height:300px;margin-left: 50px;margin-right: 20px">
        <tr>
            <td>
                管理员:
            </td>
            <td>
               <input type="hidden" id="admin_id" name="admin_id" value="${admin_id }" />
                <input type="text" name="username" id="employee" required lay-verify="required" autocomplete="off" class="layui-input" value="${username}">
            </td>
        </tr>
        <tr>
            <td>
                初始密码:
            </td>
            <td>
                <input type="password" name="password" id="password1" required lay-verify="required" value="${password}"  autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
            <td>
                确认密码:
            </td>
            <td>
                <input type="password" name="password1" id="password2"  value="123"  required lay-verify="required" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
            <td>
                性别:
            </td>
            <td>
                <div class="layui-input-block">
                  <input type="radio" name="sex" value="男" title="男" id="sex1" checked="">男
                   <input type="radio" name="sex" value="女" title="女" id="sex2">女
                </div>
            </td>
        </tr>
        <tr>
            <td>
                手机:
            </td>
            <td>
                <input type="number" name="phone" id="phone" required lay-verify="required" autocomplete="off" class="layui-input" value="${phone}">
            </td>
        </tr>
        <tr>
            <td>
                邮箱:
            </td>
            <td>
                <input type="email" name="email" id="email" value="${email}" required lay-verify="required" autocomplete="off" class="layui-input">
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
                    <option value="${rolename}">${rolename}</option>
                    <option value="栏目编辑">管理员列表</option>
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

    <script>

        // layui.use(['form'], function() {
        //     var form = layui.form;
        //     aa(form);
        //     bb(form);
        // });
        //
        // function bb(lay_form) {
        //     var url = "/user/edit";
        //     $.ajax(url,{
        //         type:"get",
        //         datatype:"json",
        //         data:{
        //             id:id
        //         },
        //         success:function (data, textStatus, jqXhr) {
        //             data = JSON.parse(data);
        //             lay_form.render();
        //         }
        //     });
        // }

    </script>


</html>
