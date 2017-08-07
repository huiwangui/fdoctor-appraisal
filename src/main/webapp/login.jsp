<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>健康管理绩效考核系统</title>
    <link rel="stylesheet" href="/fdoctor-appraisal/statics/beginnerAdmin/plugins/layui/css/layui.css">
    <link rel="stylesheet" href="/fdoctor-appraisal/statics/css/login.css" />
    <script src="/fdoctor-appraisal/statics/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="/fdoctor-appraisal/statics/beginnerAdmin/plugins/layui/layui.js"></script>
</head>

<body>
		<div class="header">
			<span></span>
			<img src="/fdoctor-appraisal/statics/image/login/logo.png" alt="" />
		</div>
				
		
	<div class="main">
			<div class="login_box">
				<div class="title tc">
					<h4>用户登录</h4>
					<h5>LOGIN</h5>
				</div>
				<div class="content">
					<form action="">
						<div style="margin-top: 10%; " class="clearfix">
							<span class="left_icon1"></span>
							<input type="text" name="account" id="account" value="" placeholder="用户名" class="username"/>
						</div>
						<div class="clearfix">
							<span class="left_icon2"></span>
							<input type="password" name="password" id="password" value=""  placeholder="密码" class="password"/>
						</div>
						<!-- <div class="chk clearfix">
							<label >
								<input type="checkbox" name="" id="" value=""  />  记住密码
							</label>
						</div> -->
						<div  class="clearfix" style="margin-top:6%">
							<a  class="login_btn" id="loginButton" lay-submit="" lay-filter="sub">登录</a>
						</div>
						<!-- <div  class="clearfix">
							<a href="/" class="forget_pws">忘记密码？</a>
						</div> -->
					</form>
				</div>
			</div>
		</div>
		
		<div class="bottom tc">
			<p class="other_link">
				<a href="/">版权声明</a>
				<a href="/">法律责任</a>
				<a href="/">隐私声明</a>
				<a href="/" style="border-right:1px solid #999">联系我们</a>
			</p>
			<p>
				地址：成都市成华区双庆路10号华润大厦7楼 邮编： 610000 Copyright@ 2017 - 2版权所有
			</p>
			<p>
				建议使用IE8及以上版本浏览器 川ICP备 09003078号
			</p>
		</div>
	</body>
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
				url : '/fdoctor-appraisal/user/login',
				data : {
					username : $('#account').val().trim(),
					password : $('#password').val().trim()
					
				},
				success : function(a) {
					if (a.code == 200) {
						layer.msg('登录成功，正在跳转到首页');
						setTimeout(function(){
							location.href = "/fdoctor-appraisal/user/index";
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