<%@ page language="java" contentType="text/html; charset= utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>司机信息</title>

<link rel="icon" href="favicon.ico" type="image/ico">
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="yinqi">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/materialdesignicons.min.css" rel="stylesheet">
<link href="css/style.min.css" rel="stylesheet">
</head>
  
<body>
<div class="lyear-layout-web">
  <div class="lyear-layout-container">
    <!--左侧导航-->
    <aside class="lyear-layout-sidebar">
       
      <!-- logo -->
      <div id="logo" class="sidebar-header">
        <a href="index.html"><img src="images/logo-sidebar.png" title="LightYear" alt="LightYear" /></a>
      </div>
      <div class="lyear-layout-sidebar-scroll">
        
        <nav class="sidebar-main">
          <ul class="nav nav-drawer">
            <li class="nav-item active"> <a href="index.jsp"><i class="mdi mdi-home"></i> 后台首页</a> </li>
            
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-file-outline"></i> 用户管理</a>
              <ul class="nav nav-subnav">
              	<li class="nav-item nav-item-has-subnav"> 
                  <a href="#">用户信息管理</a>
                  <ul class="nav nav-subnav">
                    <li> <a href="${pageContext.request.contextPath }/admin/user_list.jsp">教师信息管理</a> </li>
                    <li> <a href="${pageContext.request.contextPath }/admin/driver_list.jsp">司机信息管理</a> </li>
                      <!-- <ul class="nav nav-subnav">
                        <li> <a href="#!">三级菜单</a> </li>
                        <li> <a href="#!">三级菜单</a> </li>
                      </ul> -->
                    
                  </ul>
                </li>
                <!-- <li> <a href="lyear_pages_doc.html">用户信息管理</a> </li> -->
                
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-file-outline"></i> 车辆管理</a>
              <ul class="nav nav-subnav">
                <li> <a href="lyear_pages_doc.html">文档列表</a> </li>
                <li> <a href="lyear_pages_gallery.html">图库列表</a> </li>
                <li> <a href="lyear_pages_config.html">网站配置</a> </li>
                <li> <a href="lyear_pages_rabc.html">设置权限</a> </li>
                <li> <a href="lyear_pages_add_doc.html">新增文档</a> </li>
                <li> <a href="lyear_pages_guide.html">表单向导</a> </li>
                <li> <a href="lyear_pages_login.html">登录页面</a> </li>
                <li> <a href="lyear_pages_error.html">错误页面</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-file-outline"></i> 预约管理</a>
              <ul class="nav nav-subnav">
                <li> <a href="lyear_pages_doc.html">文档列表</a> </li>
                <li> <a href="lyear_pages_gallery.html">图库列表</a> </li>
                <li> <a href="lyear_pages_config.html">网站配置</a> </li>
                <li> <a href="lyear_pages_rabc.html">设置权限</a> </li>
                <li> <a href="lyear_pages_add_doc.html">新增文档</a> </li>
                <li> <a href="lyear_pages_guide.html">表单向导</a> </li>
                <li> <a href="lyear_pages_login.html">登录页面</a> </li>
                <li> <a href="lyear_pages_error.html">错误页面</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-file-outline"></i> 留言管理</a>
              <ul class="nav nav-subnav">
                <li> <a href="lyear_pages_doc.html">文档列表</a> </li>
                <li> <a href="lyear_pages_gallery.html">图库列表</a> </li>
                <li> <a href="lyear_pages_config.html">网站配置</a> </li>
                <li> <a href="lyear_pages_rabc.html">设置权限</a> </li>
                <li> <a href="lyear_pages_add_doc.html">新增文档</a> </li>
                <li> <a href="lyear_pages_guide.html">表单向导</a> </li>
                <li> <a href="lyear_pages_login.html">登录页面</a> </li>
                <li> <a href="lyear_pages_error.html">错误页面</a> </li>
              </ul>
            </li>
           
          </ul>
        </nav>
        
        <div class="sidebar-footer">
          <p class="copyright">Copyright &copy; 2019. <a target="_blank" href="http://lyear.itshubao.com">IT书包</a> All rights reserved. More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
        </div>
      </div>
      
    </aside>
    <!--End 左侧导航-->
    
    <!--头部信息-->
    <header class="lyear-layout-header">
      
      <nav class="navbar navbar-default">
        <div class="topbar">
          
          <div class="topbar-left">
            <div class="lyear-aside-toggler">
              <span class="lyear-toggler-bar"></span>
              <span class="lyear-toggler-bar"></span>
              <span class="lyear-toggler-bar"></span>
            </div>
            <span class="navbar-page-title"> 示例页面 - 文档列表 </span>
          </div>
          
          <ul class="topbar-right">
            <li class="dropdown dropdown-profile">
              <a href="javascript:void(0)" data-toggle="dropdown">
                <img class="img-avatar img-avatar-48 m-r-10" src="images/users/avatar.jpg" alt="笔下光年" />
                <span>admin <span class="caret"></span></span>
              </a>
              <ul class="dropdown-menu dropdown-menu-right">
                <li> <a href="lyear_pages_edit_pwd.html"><i class="mdi mdi-lock-outline"></i> 修改密码</a> </li>
                <li class="divider"></li>
                <li> <a href="lyear_pages_login.html"><i class="mdi mdi-logout-variant"></i> 退出登录</a> </li>
              </ul>
            </li>
            
          </ul>
          
        </div>
      </nav>
      
    </header>
    <!--End 头部信息-->
    
    <!--页面主要内容-->
    <main class="lyear-layout-content">
      
      <div class="container-fluid">
        
        <div class="row">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-toolbar clearfix">
              
                <form class="pull-right search-bar" method="get" action="#!" role="form">
                  <div class="input-group">
                    <div class="input-group-btn">
                      <input type="hidden" name="search_field" id="search-field" value="title">
                      <button class="btn btn-default dropdown-toggle" id="search-btn" data-toggle="dropdown" type="button" aria-haspopup="true" aria-expanded="false">
                      标题 <span class="caret"></span>
                      </button>
                      <ul class="dropdown-menu">
                        <li> <a tabindex="-1" href="javascript:void(0)" data-field="title">标题</a> </li>
                        <li> <a tabindex="-1" href="javascript:void(0)" data-field="cat_name">栏目</a> </li>
                      </ul>
                    </div>
                    <input type="text" class="form-control" value="" name="keyword" placeholder="请输入名称">
                  </div>
                </form>
                <div class="toolbar-btn-action">
                  <a class="btn btn-primary m-r-5" href="#!"><i class="mdi mdi-plus"></i> 新增</a>
                  <a class="btn btn-danger" href="#!"><i class="mdi mdi-window-close"></i> 删除</a>
                </div>
              </div>
              <div class="card-body">
                
                <div class="table-responsive">
                
                <form action="./admin/driverlist.action" method="post">
                	<table class="table table-bordered">
                    <thead>
                      <tr>
                        <th>
                          <label class="lyear-checkbox checkbox-primary">
                            <input type="checkbox" id="check-all"><span></span>
                          </label>
                        </th>
                        <th width="80">编号</th>
			            <th width="80">司机姓名</th>
			            <th width="90">工号</th>
			            <th width="90">电话</th>
			            <th width="100">驾龄</th>
			            <th width="250">操作</th>
                      </tr>
                    </thead>
                    <tbody name="s">
                    	<c:forEach items="${dl }" var="driver">
                    		<td>
                          <label class="lyear-checkbox checkbox-primary">
                            <input type="checkbox" name="ids[]" value="1"><span></span>
                          </label>
                        	</td>
                        <td>${driver.dId }</td>
                        <td>${driver.dname }</td>
                        <td>${driver.dnumber }</td>
                        <td>${driver.dphone }</td>
                        <td>${driver.diverTime }</td>
                        <td>
                          <div class="btn-group">
                            <a class="btn btn-xs btn-default" href="#!" title="编辑" data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>
                            <a class="btn btn-xs btn-default" href="#!" title="删除" data-toggle="tooltip"><i class="mdi mdi-window-close"></i></a>
                          </div>
                        </td>
                    	</c:forEach>
                      	<tr
				style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
	
				<td align="center" width="18%" colspan="8">
				当前${pageInfo.pageNum}页,
              	共${pageInfo.pages}页,
                             共${pageInfo.total}条记录
				<a
					href="${ pageContext.request.contextPath }/admin/findDriverByPage.action?page=1">首页</a>
					|<a
					href="${ pageContext.request.contextPath }/admin/findDriverByPage.action?page=${pageInfo.pageNum==1?1:pageInfo.pageNum-1}">上一页</a>
					| <a
					href="${ pageContext.request.contextPath }/admin/findDriverByPage.action?page=${pageInfo.pageNum==pageInfo.pages?pageInfo.pages:pageInfo.pageNum+1}">下一页</a>
					|<a
					href="${ pageContext.request.contextPath }/admin/findDrivertByPage.action?page=${pageInfo.pages}">尾页</a></td>
	
			</tr> 
                    </tbody>
                  </table>
                </form>
                  
                </div>
                <!-- <ul class="pagination">
                  <li class="disabled"><span>«</span></li>
                  <li class="active"><span>1</span></li>
                  <li><a href="#1">2</a></li>
                  <li><a href="#1">3</a></li>
                  <li><a href="#1">4</a></li>
                  <li><a href="#1">5</a></li>
                  <li><a href="#1">6</a></li>
                  <li><a href="#1">7</a></li>
                  <li><a href="#1">8</a></li>
                  <li class="disabled"><span>...</span></li>
                  <li><a href="#!">14452</a></li>
                  <li><a href="#!">14453</a></li>
                  <li><a href="#!">»</a></li>
                </ul> -->
       
              </div>
            </div>
          </div>
          
        </div>
        
      </div>
      
    </main>
    <!--End 页面主要内容-->
  </div>
</div>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="js/main.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>

<script type="text/javascript">
/* $(function(){
    $('.search-bar .dropdown-menu a').click(function() {
        var field = $(this).data('field') || '';
        $('#search-field').val(field);
        $('#search-btn').html($(this).text() + ' <span class="caret"></span>');
    });
}); */
$(function(){
	$.post("${pageContext.request.contextPath}/admins/driverlist",
		function(result){
		console.log(result);
			/* var pselect=$("tbody[name='s']");
			var pchild="";
			for(var i=0;i<result.length;i++){
				pchild+="<td>"+
				"<label class='lyear-checkbox checkbox-primary'>"+
				 " <input type='checkbox' name='ids[]' value='1'><span></span>"+
				"</label>"+
				"</td>"+
				"<td>"+result[i].dId+"</td>"+
				"<td>"+result[i].dname+"</td>"+
				"<td>"+result[i].dnumber+"</td>"+
				"<td>"+result[i].dphone+"</td>"+
				"<td>"+result[i].diver_time+"</td>"+
				"<td>"+
				"<div class='btn-group'>"+
				 " <a class='btn btn-xs btn-default' href='#!' title='编辑' data-toggle='tooltip'><i class='mdi mdi-pencil'></i></a>"+
				  "<a class='btn btn-xs btn-default' href=''#!' title='删除' data-toggle='tooltip'><i class='mdi mdi-window-close'></i></a>"+
				"</div>"+
				"</td>"
			}
			pselect.html(pchild); */
			
		},
		"json"
	);
});

/* <td>${dl.dname }</td>
<td>${dl.dnumber }</td>
<td>${dl.dphone }</td>
<td>${dl.diver_time }</td>
href=javascript:void(0); value='"+result[i].fId+"' onclick=showkindgoods('"+result[i].fId+"')>"+result[i].fName+" */
</script>
</body>
</html>