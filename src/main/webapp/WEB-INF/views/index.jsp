<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../views/include/taglib.jsp"%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="utf-8">
		<title>健康管理绩效考核系统</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">

		<link rel="stylesheet" href="/fdoctor-appsaisal/statics/beginnerAdmin/plugins/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="/fdoctor-appsaisal/statics/beginnerAdmin/css/global.css" media="all">
		<link rel="stylesheet" href="/fdoctor-appsaisal/statics/beginnerAdmin/plugins/font-awesome/css/font-awesome.min.css">
		<link rel="shortcut icon" type="image/x-icon" href="/fdoctor-appsaisal/statics/image/bitbug_favicon.ico" media="screen" /> 
	</head>

	<body>
		<div class="layui-layout layui-layout-admin" style="border-bottom: solid 5px #1aa094; width: 100%">
			<div class="layui-header header header-demo">
				<div class="layui-main">
					<div class="admin-login-box">
						<a class="logo" style="left: 0;" href="">
							<span style="font-size: 18px;">健康管理绩效考核系统</span>
						</a>
						<div class="admin-side-toggle">
							<i class="fa fa-bars" aria-hidden="true"></i>
						</div>
						<div class="admin-side-full">
							<i class="fa fa-life-bouy" aria-hidden="true"></i>
						</div>
					</div>
					<ul class="layui-nav admin-header-item">
						<li class="layui-nav-item">
							<a href="javascript:;">清除缓存</a>
						</li>
						<li class="layui-nav-item">
							<a href="javascript:;" class="admin-header-user">
								<img src="http://182.151.199.4:8115/upload/img/default.jpg" />
								<span id="userNameSpan">${sessionScope.user_in_session.userName}</span>
							</a>
							<dl class="layui-nav-child">
								<!-- 
								<dd>
									<a href="javascript:;"><i class="fa fa-user-circle" aria-hidden="true"></i> 个人信息</a>
								</dd>
								<dd>
									<a href="javascript:;"><i class="fa fa-gear" aria-hidden="true"></i> 设置</a>
								</dd>
								 -->
								<dd>
									<a href=""><i class="fa fa-sign-out" aria-hidden="true"></i> 注销</a>
								</dd>
							</dl>
						</li>
					</ul>
					<ul class="layui-nav admin-header-item-mobile">
						<li class="layui-nav-item">
							<a href="login.html"><i class="fa fa-sign-out" aria-hidden="true"></i> 注销</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="layui-side layui-bg-black" id="admin-side">
				<div class="layui-side-scroll" id="admin-navbar-side" lay-filter="side"></div>
			</div>
			<div class="layui-body" style="bottom: 0;border-left: solid 2px #1AA094;" id="admin-body">
				<div class="layui-tab admin-nav-card layui-tab-brief" lay-filter="admin-tab">
					<ul class="layui-tab-title">
						<li class="layui-this">
							<i class="fa fa-dashboard" aria-hidden="true"></i>
							<cite>控制面板</cite>
						</li>
					</ul>
					<div class="layui-tab-content" style="min-height: 150px; padding: 5px 0 0 0;">
						<div class="layui-tab-item layui-show">
							<iframe src="/fdoctor-apprairal/sys/mainPage" style="min-height: 500px;" filter="main"></iframe>
						</div>
					</div>
				</div>
			</div>
			<div class="layui-footer footer footer-demo" id="admin-footer">
				<div class="layui-main">
					<p>2017 &copy;
						<a href="">亿阳信通</a> 健康管理绩效考核系统
					</p>
				</div>
			</div>
			<div class="site-tree-mobile layui-hide">
				<i class="layui-icon">&#xe602;</i>
			</div>
			<div class="site-mobile-shade"></div>
			
			<!--锁屏模板 start-->
			<script type="text/template" id="lock-temp">
				<div class="admin-header-lock" id="lock-box">
					<div class="admin-header-lock-img">
						<img src="http://182.151.199.4:8115/upload/img/default.jpg"/>
					</div>
					<div class="admin-header-lock-name" id="lockUserName">beginner</div>
					<input type="text" class="admin-header-lock-input" value="输入密码解锁.." name="lockPwd" id="lockPwd" />
					<button class="layui-btn layui-btn-small" id="unlock">解锁</button>
				</div>
			</script>
			<!--锁屏模板 end -->
			
			<script type="text/javascript" src="/fdoctor-apprairal/statics/beginnerAdmin/plugins/layui/layui.js"></script>
			<script>
				layui.use('layer', function() {
					var $ = layui.jquery,
						layer = layui.layer;
				});
				var navs = [
				            {
				                title: "服务包管理",
				                spread: true,
				                icon: "fa-cubes",
				                href: "a",
				                children: [
				                    {
				                       title: "包类型管理",
				                        icon: "&#xe641;",
				                        href: "/fdoctor-appsaisal/servicePack/showPack"
				                    },
				                    {
				                        title: "服务项目管理",
				                        icon: "&#xe63c;",
				                        href: "/fdoctor-appsaisal/servicePack/showDetail"
				                    },
				                    {
				                        title: "服务项目管理（新版）",
				                        icon: "&#xe63c;",
				                        href: "/fdoctor-appsaisal/servicePack/showDetailNew"
				                    },
				                    {
				                        title: "管理服务关系",
				                        icon: "&#xe64c;",
				                        href: "/fdoctor-appsaisal/servicePack/showRelation"
				                    }
				                ]
				            },
				            {
				                title: "预约免疫管理",
				                icon: "&#xe62a;",
				                href: "b",
				                parentId: 0,
				                children: [
				                    {
				                        title: "预约号源管理",
				                        icon: "fa-table",
				                        href: "/fdoctor-appsaisal/outpatientSource/showPage"
				                    },
				                    {
				                        title: "预约信息管理",
				                        icon: "&#xe687;",
				                        href: "/fdoctor-appsaisal/outpatientOrder/showPage"
				                    },
				                    {
				                        title: "免疫停诊管理",
				                        icon: "&#xe60b;",
				                        href: "/fdoctor-appsaisal/outpatientStop/showPage"
				                    }
				                ]
				            },
				            {
				                title: "设置",
				                icon: "&#xe638;",
				                href: "c",
				                children: [
				                    {
				                        title: "指标设置",
				                        icon: "&#xe629;",
				                        href: "/fdoctor-apprairal/hospital/showPage"
				                    },
				                    {
				                        title: "分数线设置",
				                        icon: "&#xe61d;",
				                        href: "/fdoctor-appsaisal/team/showPage"
				                    },
				                    {
				                        title: "密码设置",
				                        icon: "&#xe613;",
				                        href: "/fdoctor-appsaisal/doctor/showPage"
				                    }
				                ]
				            }
				        ]
			</script>
			<script src="/fdoctor-apprairal/statics/beginnerAdmin/js/index.js"></script>
		</div>
	</body>

</html>