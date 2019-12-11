<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<%
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
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form role="form" id="res" action="./loginres/res" enctype="multipart/form-data" method="post" class="registration-form">
			                    	<div class="form-group">
			                    		<label class="sr-only" " for="form-first-name">账号</label>
			                        	<input type="text" onblur="validate();" onfocus="resetname();" name="username" placeholder="请输入账号..." class="form-first-name form-control" id="user_name">
			                        </div>
			                        <p style="color: red;font-size: 12px;width: 100px;clear: both" id="showname"></p>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-last-name">密码</label>
			                        	<input type="password" style="height: 50px;font-size: 16px" name="password" placeholder="请输入密码..." class="form-last-name form-control" id="u_pasd">
			                        </div>
			                        <div class="form-group">
			                    		<label class="sr-only" for="form-first-name">姓名</label>
			                        	<input type="text" style="height: 50px;font-size: 16px" name="name" placeholder="请输入姓名..." class="form-first-name form-control" >
			                        </div>
			                        <div class="form-group">
			                    		<label class="sr-only" for="form-first-name">性别</label>
			                        	<input type="text" style="height: 50px;font-size: 16px" name="sex" placeholder="请输入性别..." class="form-first-name form-control">
			                        </div>
			                        <div class="form-group">
			                    		<label class="sr-only" for="form-first-name">生日</label>
			                        	<input type="text" style="height: 50px;font-size: 16px" name="birthday" placeholder="请输入生日..." class="form-first-name form-control" >
			                        </div>
			                        <div class="form-group">
				                        <select style="padding: 7px" id="s_province" name="s_province">
				                        <option>省、自治区级</option>
				                        </select>
				                        <select style="padding: 7px" id="s_city" name="s_city">
				                        <option>市级</option>
				                        </select>
				                        <select style="padding: 7px" id="s_county" name="s_county">
				                        <option>区、县级</option>
				                        </select>
				                       <!--  <script class="resources library" src="area.js" type="text/javascript"></script>
    									<script type="text/javascript">_init_area();</script> -->
			                        </div>
			                        <input type="hidden" id="addr" name="addr">
			                        <div id="show"></div>
			                        <div class="form-group">
			                    		<label class="sr-only" for="form-first-name">微信</label>
			                        	<input type="text" style="height: 50px;font-size: 16px" name="wechat" placeholder="请输入微信 ..." class="form-first-name form-control" id="">
			                        </div>
			                        <div class="form-group">
			                    		<label class="sr-only" for="form-first-name">e-mail</label>
			                        	<input type="text" style="height: 50px;font-size: 16px" name="email" placeholder="输输入email..." class="form-first-name form-control" id="">
			                        </div>
			                        <div class="form-group">
			                    		<label class="sr-only" for="form-first-name">电话</label>
			                        	<input type="text" style="height: 50px;font-size: 16px" name="phone" placeholder="请输入电话..." class="form-first-name form-control" id="">
			                        </div>
			                        <div class="form-group">
			                    		<input type="file" id="img" name="img" style="height: 50px;font-size: 16px" title="上传头像" >
			                    		<img alt="" style="height: 70px;font-size: 70px" id="photo" src="">
			                    		<input type="button" value="上传" id="upload" >
			                        </div>
			                         <div class="form-group">
			                        <!-- <input type="button" onclick="validate();" value="注册" style="border:1px ;border-radius:5px; width: 100px;color:#68838B;height: 50px;background-color: #00B2EE;"></input> -->
			                        <input type="submit" value="注册" style="border:1px ;border-radius:5px; width: 100px;color:#68838B;height: 50px;background-color: #00B2EE;"></input>
			                        <a style="font-size: 10px; float: right" id="iforget" href="Login.jsp">返回登录</a>
			                        </div>
			                    </form>

</body>
</html>