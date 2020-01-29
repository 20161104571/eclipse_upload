<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>欢迎注册校园通勤车管理系统</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="assets/css/form-elements.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">

    </head>

    <body>

        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>注册</strong></h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3> </h3>
                            		<p>填入你的基本信息来加入我们:</p>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" action="./loginres/res" method="post" class="login-form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">用户名:</label>
			                        	<input type="text" name="username" placeholder="用户名..." class="form-username form-control" id="username">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">密码:</label>
			                        	<input type="password" name="password" placeholder="密码..." class="form-password form-control" id="password">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">真实姓名:</label>
			                        	<input type="text" name="name" placeholder="真实姓名..." class="form-realname form-control" id="name">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">学号（工号）:</label>
			                        	<input type="text" name="number" placeholder="学工号..." class="form-number form-control" id="number">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">手机号:</label>
			                        	<input type="text" name="phone" placeholder="手机号..." class="form-phone form-control" id="phone">
			                        </div>
			                        
			                        <button class="btn">下一步</button>
			                        <div class="form-group">
										<p>Already registered? <a href="login.jsp">登 录</a></p>
									</div>
			                    </form>
		                    </div>
                        </div>
                    </div>
                    
                </div>
            </div>
            
        </div>


        <!-- Javascript -->
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/scripts.js"></script>
        
       
    </body>

</html>