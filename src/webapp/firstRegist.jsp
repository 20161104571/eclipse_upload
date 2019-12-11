<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>验证邮箱</title>
</head>
<body>
	<form role="form" id="email" action="./verEmail/email" method="post" class="verEmail-form">
		<div class="email-text">
			<label class="form-group" for="form-email">邮箱</label>
			<input type="text" style="height: 50px;font-size: 16px" name="email" placeholder="请输入邮箱" class="form-first-email form-control" >
		</div>
		<div class="form-item">
			<label>  </label>
			<button type="submit" id="J_BtnEmailForm" class="btn btn-large tsl" data-phase-id="r_p_next">点击验证</button>
		</div>
	</form>

</body>
</html>