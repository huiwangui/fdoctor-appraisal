<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>健康管理绩效考核系统</title>
    <link rel="stylesheet" href="/fdoctor-appraisal/statics/beginnerAdmin/plugins/layui/css/layui.css">
    <link rel="stylesheet" href="/fdoctor-appraisal/statics/css/style.css">
    <link rel="stylesheet" href="/fdoctor-appraisal/statics/css/work.css" />
    <link rel="icon" href="/fdoctor-appraisal/statics/image/icon.png">
</head>
<!-- <body class="login-body body">

<div class="login-box">
   <form class="layui-form layui-form-pane" method="post" action="">
        <div class="layui-form-item">
            <h3>健康管理医生工作站</h3>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">账号：</label>

            <div class="layui-input-inline">
                <input type="text" id="account" name="account" class="layui-input" lay-verify="account" placeholder="账号" autocomplete="on" maxlength="20"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码：</label>

            <div class="layui-input-inline">
                <input type="password"  id="password" name="password" class="layui-input" lay-verify="password" placeholder="密码" maxlength="20"/>
            </div>
        <div class="layui-form-item">
            <button type="reset" class="layui-btn layui-btn-danger btn-reset">重置</button>
            <button type="button" id="loginButton" class="layui-btn btn-submit" lay-submit="" lay-filter="sub">立即登录</button>
        </div>
    </form> 
</div> -->
<body>
		<div class="wrap">
			<div class="bg2"></div>
			<div class="loginUser">
				<div class="t">
					<img src="/fdoctor-appraisal/statics/image/img2/greenWork.png" alt="" />
					<span class="span2">健康管理绩效考核系统</span>
				</div>
				<h3>登录</h3>
				<form class="userPass">
					<input type="text" name="account" id="account" value="" class="userName"/> <br />
					<input type="password" name="password" id="password" value="" class="password"/>
					<div class="fr ">
						<a type="button" id="loginButton" class="loginBtn" lay-submit="" lay-filter="sub">登录</a>
					</div>
				</form>
			</div>
			<div class="msg_detail">
				<p>
					健康管理医生工作站是针对家庭医生服务所开发的一个资源整合、统一高效的医生工作平台。在签约医生团队和居民之间建立一套健康管理体系，使签约医生团队可以随时关注居民的身体健康，并最大化提升医生的工作效率。
				</p>
			</div>
		</div>
	<script type="text/javascript">
		//这段是控制屏幕大小变化时候html的根字体大小 百分比形势
		(function (doc, win) {
		var docEl = doc.documentElement,
		resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
		recalc = function () {
		var clientWidth = docEl.clientWidth;
		if (!clientWidth) return;
		docEl.style.fontSize = 20 * (clientWidth / 3600) + 'px';
		};
		
		if (!doc.addEventListener) return;
		win.addEventListener(resizeEvt, recalc, false);
		doc.addEventListener('DOMContentLoaded', recalc, false);
		})(document, window);
	</script>
<script src="${fws}/statics/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${fwsStatic}/plugins/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['form', 'layer'], function () {

        // 操作对象
        var form    = layui.form()
            ,layer  = layui.layer
            ,$      = layui.jquery;

        // 验证
        form.verify({
            account: function (value) {
                if (value == "") {
                    return "请输入用户名";
                }
            },
            password: function (value) {
                if (value == "") {
                    return "请输入密码";
                }
            }
        });

        // 提交监听
        form.on('submit(sub)', function (data) {
        	if( $('#account').val().trim()==''||$('#password').val().trim()==''){
        		layer.msg("账户密码不能为空")
        		return;
        	}else{
        	var data=data.field
        	console.log(data)
        	$.ajax({
        		scriptCharset: 'utf-8',
				type : 'POST',
				url : '/fdoctor-appraisal/sys/login',
				data : {
					username : $('#account').val(),
					password : $('#password').val()
					
				},
				success : function(a) {
					if (a.code == 200) {
						layer.msg('登录成功，正在跳转到首页');
						setTimeout(function(){
							location.href = "/fdoctor-appraisal/sys/login";
						},200);
					} else {
						layer.msg(a.msg);
					}
				}
			});
          }
        }); 
        
    })

</script>
</body>
</html>