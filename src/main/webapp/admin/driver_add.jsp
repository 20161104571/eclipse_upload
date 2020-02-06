<%@ page language="java" contentType="text/html; charset= utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>新增司机信息</title>
<link rel="icon" href="favicon.ico" type="image/ico">
<meta name="author" content="yinqi">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/materialdesignicons.min.css" rel="stylesheet">
<!--标签插件-->
<link rel="stylesheet" href="js/jquery-tags-input/jquery.tagsinput.min.css">
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
            <span class="navbar-page-title"> 新增司机信息 </span>
          </div>
          
          <ul class="topbar-right">
            <!-- <li class="dropdown dropdown-profile">
              <a href="javascript:void(0)" data-toggle="dropdown">
                <img class="img-avatar img-avatar-48 m-r-10" src="images/users/avatar.jpg" alt="笔下光年" />
                <span>笔下光年 <span class="caret"></span></span>
              </a>
              <ul class="dropdown-menu dropdown-menu-right">
                <li> <a href="lyear_pages_profile.html"><i class="mdi mdi-account"></i> 个人信息</a> </li>
                <li> <a href="lyear_pages_edit_pwd.html"><i class="mdi mdi-lock-outline"></i> 修改密码</a> </li>
                <li> <a href="javascript:void(0)"><i class="mdi mdi-delete"></i> 清空缓存</a></li>
                <li class="divider"></li>
                <li> <a href="lyear_pages_login.html"><i class="mdi mdi-logout-variant"></i> 退出登录</a> </li>
              </ul>
            </li> -->
            
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
              <div class="card-body">
                
                <form action="${pageContext.request.contextPath }/admins/adddriver.action" method="post" class="row">
                	<div class="form-group col-md-12">
                    <label for="drivername">司机姓名</label>
                    <input type="text" class="form-control" id="drivername" name="drivername" value="" placeholder="请输入司机姓名" />
                  </div>
                  <div class="form-group col-md-12">
                    <label for="drivernum">工号</label>
                    <input type="text" class="form-control" id="drivernum" name="drivernum" value="" placeholder="输入司机工号" />
                  </div>
                  <div class="form-group col-md-12">
                    <label for="driverphone">电话</label>
                    <input type="text" class="form-control" id="driverphone" name="driverphone" value="" placeholder="输入司机电话" />
                  </div>
                  <!-- <div class="form-group col-md-12">
                    <label>多图上传</label>
                    <div class="form-controls">
                      
                      <ul class="list-inline clearfix lyear-uploads-pic">
                        <li class="col-xs-4 col-sm-3 col-md-2">
                          <figure>
                            <img src="images/gallery/15.jpg" alt="图片一">
                            <figcaption>
                              <a class="btn btn-round btn-square btn-primary" href="#!"><i class="mdi mdi-eye"></i></a>
                              <a class="btn btn-round btn-square btn-danger" href="#!"><i class="mdi mdi-delete"></i></a>
                            </figcaption>
                          </figure>
                        </li>
                        <li class="col-xs-4 col-sm-3 col-md-2">
                          <figure>
                            <img src="images/gallery/16.jpg" alt="图片二">
                            <figcaption>
                              <a class="btn btn-round btn-square btn-primary" href="#!"><i class="mdi mdi-eye"></i></a>
                              <a class="btn btn-round btn-square btn-danger" href="#!"><i class="mdi mdi-delete"></i></a>
                            </figcaption>
                          </figure>
                        </li>
                        <li class="col-xs-4 col-sm-3 col-md-2">
                          <figure>
                            <img src="images/gallery/17.jpg" alt="图片三">
                            <figcaption>
                              <a class="btn btn-round btn-square btn-primary" href="#!"><i class="mdi mdi-eye"></i></a>
                              <a class="btn btn-round btn-square btn-danger" href="#!"><i class="mdi mdi-delete"></i></a>
                            </figcaption>
                          </figure>
                        </li>
                        <li class="col-xs-4 col-sm-3 col-md-2">
                          <a class="pic-add" id="add-pic-btn" href="#!" title="点击上传"></a>
                        </li>
                      </ul>
                    </div>
                  </div> -->
                  <div class="form-group col-md-12">
                    <label for="drivertime">驾龄</label>
                    <input class="form-control" type="text" id="drivertime" name="drivertime" value="" placeholder="输入司机驾龄"/>
                  </div>
                  </div>
                  <div class="form-group col-md-12">
                    <button type="submit" class="btn btn-primary ajax-post" target-form="add">确 定</button>
                    <button type="button" class="btn btn-default" onclick="javascript:history.back(-1);return false;">返 回</button>
                  </div>
                </form>
                  
				</div>
             </div>
            </div>
          </div>
       </main>
   </div>
</div>
<script type="text/javascript">
$(function(){
	$.post("${pageContext.request.contextPath}/admins/adddriver",
		function(result){
		console.add(result);
	
		"json"
	});
});
//监听提交
form.on('submit(add)', function(data){
  console.log(data);
  //发异步，把数据提交给php
  layer.alert("增加成功", {icon: 4},function () {
      // 获得frame索引
      var index = parent.layer.getFrameIndex(window.name);
      //关闭当前frame
      parent.layer.close(index);
  });
  return false;
});
</script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/perfect-scrollbar.min.js"></script>
<!--标签插件-->
<script src="js/jquery-tags-input/jquery.tagsinput.min.js"></script>
<script type="text/javascript" src="js/main.min.js"></script>
</body>
</html>