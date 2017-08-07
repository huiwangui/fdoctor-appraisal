<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
	<link rel="stylesheet" href="/fdoctor-appraisal/statics/beginnerAdmin/plugins/layui/css/layui.css">
	<script src="/fdoctor-appraisal/statics/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="/fdoctor-appraisal/statics/beginnerAdmin/plugins/layui/layui.js"></script>
<title>密码设置</title>
</head>
<body>
	<div style="margin-top:10px">
		<form class="layui-form" action="">
		  <div class="layui-form-item">
		    <label class="layui-form-label">原密码</label>
		    <div class="layui-input-inline">
		      <input type="password" name="password" id="password" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  
		  <div class="layui-form-item">
		    <label class="layui-form-label">新密码</label>
		    <div class="layui-input-inline">
		      <input type="password" name="newpassword" id="newpassword" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  
		  <div class="layui-form-item">
		    <label class="layui-form-label">新密码</label>
		    <div class="layui-input-inline">
		      <input type="password" name="repassword" id="repassword" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  
		  <div class="layui-form-item" style="margin-left:120px;width:200px">
		    <button class="layui-btn layui-btn-big" lay-submit="" lay-filter="sub" id="loginButton" type="button">确定</button>
		 
		  </div>
		
		</form>
		
	</div>
	
	
	<script type="text/javascript">
    layui.use(['form', 'layer'], function () {

        // 操作对象
        var form    = layui.form()
            ,layer  = layui.layer
            ,$      = layui.jquery;

        // 验证
        form.verify({
            newpassword: function (value) {
                if ($('#newpassword').val()!=""){
                	
                	if($('#newpassword').val()!=value){
                       return "两次密码不一致";
                	}
                }
            },
            repassword: function (value) {
                if ($('#newpassword').val()!= "") {
                	if($('#newpassword').val()!=value){
                        return "两次密码不一致";
                 	}
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
        	if($('#newpassword').val()!=$('#repassword').val()){
        		layer.msg("两次新密码不一致")
        		return;
        	}else{
        	var data=data.field
        	console.log(data)
	        	$.ajax({
	        		scriptCharset: 'utf-8',
					type : 'POST',
					url : '/fdoctor-appraisal/user/updatePassword',
					data : {
						password : $('#password').val(),
						repassword : $('#repassword').val(),
						newpassword : $('#newpassword').val(),
						
					},
					success : function(a) {
						if (a.code == 200) {
							layer.msg('密码修改成功！');
							
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