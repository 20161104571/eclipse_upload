<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<%-- <%
    String path = request.getContextPath();
    
    String basePath = request.getScheme() 
    + "://" + request.getServerName() 
    + ":" 
    + request.getServerPort() 
    + "/jltp" 
    + "/";
    /* path就是项目名字的前边有 "/" ，例如你的项目名字叫做 Apple ，那么 path = /Apple
    *	basePath就是项目的完整路径，basePath = http://localhost:8080/Apple */
%>
 --%>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
</head>
<body style="width: 100%;height: 100%;">
    <div style="margin-top: 15%;">
        <div class="layui-main" style="width: 700px;">
            <h1 style="text-align: center">请输入注册信息</h1>
            <form class="layui-form layui-form-pane" enctype="multipart/form-data"  method="post"> <!-- action="./loginres/res" -->
                
                <div class="layui-form-item">
                    <label class="layui-form-label">用户名：</label>
                    <div class="layui-input-block">
                        <input id="username" type="text" name="username" class="layui-input" lay-verify="required"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码：</label>
                    <div class="layui-input-block">
                        <input id="password" type="password" name="password" class="layui-input" lay-verify="required"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">真实姓名：</label>
                    <div class="layui-input-block">
                        <input id="name" type="text" name="name" class="layui-input" lay-verify="required"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">手机号：</label>
                    <div class="layui-input-block">
                        <input id="phone" type="text" name="phone" class="layui-input" lay-verify="required"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="register">确认</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <script>
        layui.use("form",function () {
            var form = layui.form;
            var $ = layui.$;
            
            form.on("submit(register)",function (data) {
                var inputCheckCode = $("#checkCode").val();
                if (inputCheckCode == checkCode){
                    $.ajax({
                        url:"./loginres/res",
                        type:"POST",
                        data:data.field,
                        async:false,
                        success:function (text) {
                            if ("ok" == text){
                                layer.alert("注册成功",function () {
                                    window.location.href = "index.jsp";
                                });
                            }else{
                                layer.alert("注册失败");
                            }
                        }
                    });
                } else{
                    layer.msg("验证码输入错误");
                }
                return false;
            });
 
            //验证码
            var checkCode = "";
 
            $("#sendCheckCode").click(function () {
                var email = $("#email").val();
                if (email == null || email == ""){
                    layer.msg("请输入邮箱！！！");
                    return;
                }
                var index = layer.open({
                    type:3,
                    content:"邮件发送中..."
                });
 
                $.ajax({
                    url:"/getCheckCode?email="+email,
                    type:"get",
                    success:function (text) {
                        if (text != null && text != ""){
                            layer.close(index);
                            layer.msg("已发送");
                            checkCode = text;
                            countDown();
                        } else{
                            layer.alert("获取失败，请重新获取")
                        }
                    }
                });
            });
 
            var maxTime = 60;
            function countDown(){
                if (maxTime == 0){
                    checkCode = "";
                    $("#sendCheckCode").removeClass("layui-btn-disabled");
                    $("#sendCheckCode").removeAttr("disabled")
                    $("#sendCheckCode").html("获取验证码");
                    maxTime = 60;
                }else{
                    $("#sendCheckCode").attr("disabled","disabled");
                    $("#sendCheckCode").addClass("layui-btn-disabled");
                    form.render();
                    $("#sendCheckCode").html(maxTime+"秒后重新获取");
                    maxTime--;
                    setTimeout(countDown,1000);
                }
            }
 
        });
    </script>
</body>
</html>