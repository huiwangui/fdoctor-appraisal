<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>签约管理</title>
<head>
    <meta charset="utf-8">
    <title>签约管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">

    <link rel="stylesheet" href="/fdoctor-appraisal/statics/beginnerAdmin/plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="/fdoctor-appraisal/statics/beginnerAdmin/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/fdoctor-appraisal/statics/beginnerAdmin/css/btable.css" />
    <link rel="stylesheet" href="/fdoctor-appraisal/statics/css/ecstyle.css" />
    
    <script type="text/javascript" src="/fdoctor-appraisal/statics/beginnerAdmin/plugins/layui/layui.js"></script>
    <script type="text/javascript" src="/fdoctor-appraisal/statics/js/jquery-2.1.4.min.js"></script>
    
</head>

<body style=" background-color: gainsboro;">
<div class="right_part">
    <div style="margin:0px; background-color: white;">
        <blockquote class="layui-elem-quote" style=" height: 175px;">
        <form class="layui-form" action="">
        	<div class="layui-form-item" align="left" style="margin-left: 0px;margin-top: 10px;">
			  	<div class="layui-inline"  >
			  	<label class="layui-form-label" > 医院：</label>
			    <div class="layui-input-inline" ">
			      	<select name="orgId" id="orgId" lay-search lay-filter="orgId">
						<option value="" style="width: 190px;">可输入医院名搜索</option>
						<option value="0" >全部</option>
							<c:forEach items="${hospitalList}" var="hospitalItem">
								<option value="${hospitalItem.id}">${hospitalItem.orgName}</option>
							</c:forEach>
					</select>  
			    </div>
			  	</div>
			  	
			  	<div class="layui-inline" >
			    <label class="layui-form-label" > 团队队长：</label>
					<div class="layui-input-inline">
						<select name="teamId" id="teamId"  >
							<option value="" style="width: 190px;">请选择医院</option>
						</select> 
					</div>     
			    </div>
			    
			    <div class="layui-inline" >
			    	 <div class="layui-input-inline">
			    	<button class="layui-btn layui-btn-radius" style="width: 150px;margin-left: 50px;" id="selectButton" type="button">查询</button>
			    	</div>
			    </div>
			    </div> 
			    
			    <%-- <div class="layui-input-inline">
			    		<input type="radio" name="personType" id="p0" title="总人数${dataEntity.signCount}人" value="0" checked>
			    		
			    	</div>
			    	<div class="layui-input-inline">
			    		<input type="radio" name="personType" id="p1" title="高血压${dataEntity.hyperCount}人" value="1">
			    		<br/><span id=d1>占比&nbsp;${dataEntity.hyperPercent}</span>
			    	</div>
			    	<div class="layui-input-inline">
			    		<input type="radio" name="personType" id="p2" title="糖尿病${dataEntity.diabetesCount}人" value="2">
			    		<br/><span id=d2>占比&nbsp;${dataEntity.diabetesPercent}</span>
			    	</div>
			    	<div class="layui-input-inline">
			    		<input type="radio" name="personType" id="p3" title="重症精神病${dataEntity.majorPsychosisCount}人" value="3">
			    		<br/><span id=d3>占比&nbsp;${dataEntity.majorPsychosisPercent}</span>
			    	</div>
			    	<div class="layui-input-inline">
			    		<input type="radio" name="personType" id="p4" title="老年人${dataEntity.oldCount}人" value="4">
			    		<br/><span id=d4>占比&nbsp;${dataEntity.oldPercent}</span>
			    	</div>
			    	<div class="layui-input-inline">
			    		<input type="radio" name="personType" id="p5" title="孕产妇${dataEntity.maternalCount}人" value="5">
			    		<br/><span id=d5>占比&nbsp;${dataEntity.maternalPercent}</span>
			    	</div>
			    	<div class="layui-input-inline">
			    		<input type="radio" name="personType" id="p6" title="儿童${dataEntity.childrenCount}人" value="6">
			    		<br/><span id=d6>占比&nbsp;${dataEntity.hyperPercent}</span>
			    	</div> --%>
		</form>
		<form class="" action="">
		<div class="" style=" width: 1100px;">
		<div class="clearfix">
		<ul class="num_blocks1">
					<li class="item active">
						<input type="radio" name="personType" title=" "  value="0" checked class="radio">
						<a href="/">
							<p>
								<span class="num" id="p0">${dataEntity.signCount}</span><span>人</span>
							</p>
							<p>
							&nbsp;
							</p>
							<p class="p2">
								总签约人数 
							</p>
						</a>
					</li>
					<li class="item">
						<a href="/">
						<input type="radio" name="personType" title=" "  value="1"  class="radio">
							<p>
								<span class="num" id="p1">${dataEntity.hyperCount}</span><span>人</span>
							</p>
							<p>
							高血压&nbsp;
							</p>
							<p class="p2">
								 占比 : <span id="d1">${dataEntity.hyperPercent}</span>
							</p>
						</a>
					</li>
					<li class="item">
						<input type="radio" name="personType" title=" "  value="2" class="radio">
						<a href="/">
							<p>
								<span class="num" id="p2">${dataEntity.diabetesCount}</span><span>人</span>
							</p>
							<p>
							糖尿病&nbsp;
							</p>
							<p class="p2">
								 占比 : <span id="d2">${dataEntity.diabetesPercent}</span>
							</p>
						</a>
					</li>
					<li class="item">
						<input type="radio" name="personType" title=" "  value="3" class="radio">
						<a href="/">
							<p>
								<span class="num" id="p3">${dataEntity.majorPsychosisCount}</span><span>人</span>
							</p>
							<p>
							重症精神病&nbsp;
							</p>
							<p class="p2">
								 占比 : <span id="d3">${dataEntity.majorPsychosisPercent}</span>
							</p>
						</a>
					</li>
					<li class="item">
					<input type="radio" name="personType" title=" "  value="4" class="radio">
						<a href="/">
							<p>
								<span class="num" id="p4">${dataEntity.oldCount}</span><span>人</span>
							</p>
							<p>
							老年人 &nbsp; 
							</p>
							<p class="p2">
								占比 : <span id="d4">${dataEntity.oldPercent}</span>
							</p>
						</a>
					</li>
					<li class="item">
					<input type="radio" name="personType" title=" "  value="5" class="radio">
						<a href="/">
							<p>
								<span class="num" id="p5">${dataEntity.maternalCount}</span><span>人</span>
							</p>
							<p>
							孕产妇 &nbsp
							</p>
							<p class="p2">
								 占比 : <span id="d5">${dataEntity.maternalPercent}</span>
							</p>
						</a>
					</li>
					<li class="item">
						<input type="radio" name="personType" title=" "  value="6" class="radio">
						<a href="/">
							<p>
								<span class="num" id="p6">${dataEntity.childrenCount}</span><span>人</span>
							</p>
							<p>
							儿童 &nbsp;
							</p>
							<p class="p2">
								 占比 : <span id="d6">${dataEntity.hyperPercent}</span>
							</p>
						</a>
					</li>
				</ul>
				</div>
		 </div>
		</form>
        </blockquote>
		<!-- <div class="layui-btn-group">
			<button class="layui-btn layui-btn-primary layui-btn-small" id="detailButton"><i class="layui-icon">&#xe654;</i>签约详情</button>
		</div> -->
        <div id="content" style="width: 100%;height: 500px;"></div>
    	</div>
</div>
    <script>
    
    	function tableConfig(){
    		layui.config({
                base: '/fdoctor-appraisal/statics/beginnerAdmin/js/'
            }).use(['btable','layer'], function () {
                var layer = layui.layer;
                
                var btable = layui.btable(),
                    $ = layui.jquery;
                
                
                
                //layer.config({
                	//id : Math.ceil(100)	//防止重复弹窗
                //});
                btable.set({
                    elem: '#content',
                    url: '/fdoctor-appraisal/sign/getSignDetail',
                    type: 'GET',
                    pageSize: 10,
                    columns: [{
                        fieldName: '合同id',
                        field: 'id',
                        hidden: true
                    },{
                        fieldName: '签约家庭',
                        field: 'personName',
                        colRender : 'typeRenderB'
                    },{
                        fieldName: '团队名称',
                        field: 'docName',
                        colRender : 'typeRenderA'
                    },{
                        fieldName: '所属机构',
                        field: 'orgName'
                    },{
                        fieldName: '签约服务包',
                        field: 'packName'
                    },{
                        fieldName: '签约年限',
                        field: 'lastTime'
                    },{
                        fieldName: '签约时间',
                        field: 'signTimeStr'
                    }],
                    even: true,
                    //skin: 'row',
                    checkbox: false,
                    field: 'id',
                    paged: true,
                    singleSelect: true,
                    params : packParams(),
                });
                btable.render();
                
                $('#detailButton').on('click', function () {
                    //获取选择的数据
                    btable.getSelections(function (obj) {
                    	if(obj.count == 0){
                    		layer.msg('请选择要修改的数据',{icon: 7,id : Math.ceil(100)});
                    	}else{
                    		layer.open({
                         		  type: 2,
                         		  title: false,
                         		  id : Math.ceil(100),
                         		  area: ['600px', '480px'],
                         		  closeBtn: 1,
                         		  content: '/fdoctor-appraisal/team/toUpdateTeam?teamId='+obj.ids[0]
                          	});
                    	}
                    });

                });
                
                

               $(window).on('resize', function (e) {
                    var $that = $(this);
                    $('#content').height($that.height() - 92);
                }).resize();
                
            });
    	}
    	
    	tableConfig();
    
    	layui.use(['jquery', 'form'], function() {
		     $ = layui.jquery;
		     form = layui.form();
		     $form = $('form');
		     
		     $('.num_blocks1 li.item').on('click',function(){
					$(this).addClass('active').siblings().removeClass('active');
					$(this).find("input[type=radio]").prop("checked","checked");
					form.render();
					return false;
			 })
		     
		     form.on('select(orgId)', function(data) {
		    	 if(data.value != '0'){
			    	$.ajax({
					 			type : 'GET',
					 			url : '/fdoctor-appraisal/sign/getTeamLeader',
					 			data :{
					 				orgId:data.value
					 			},
					 			success : function(data) {
					 				var proHtml = '';
					 				for(i = 0; i < data.length; i++){
					 					proHtml += '<option value="'+data[i].teamId+'">'+data[i].docName+'</option>';
					 				}
					 				$('#teamId').html('<option value="">--请选择医生--</option>');
					 				$('#teamId').append(proHtml);
					 				form.render();
					 			}
					 	});
			  }else{
				  $('#teamId').html('<option value="0">--请先选择医院--</option>');
		    		 form.render();
		     }
		     })
    	})
    	
    	function dataRefresh(){
    		layui.config({
                base: '/fdoctor-appraisal/statics/beginnerAdmin/js/'
            }).use(['layer'], function () {
                var layer = layui.layer;
                 $ = layui.jquery;
                
                 
                 $.ajax({
			 			type : 'GET',
			 			url : '/fdoctor-appraisal/sign/getCountData',
			 			data :{
			 				orgId:$("#orgId").val()=='0'?'':$("#orgId").val(),
			 				teamId:$("#teamId").val()=='0'?'':$("#teamId").val()
			 			},
			 			success : function(data) {
			 				console.log(data);
			 	        	$('#p0').text(data.signCount);
			 	        	$('#p1').text(data.hyperCount);
			 	        	$('#p2').text(data.diabetesCount);
			 	        	$('#p3').text(data.majorPsychosisCount);
			 	        	$('#p4').text(data.oldCount);
			 	        	$('#p5').text(data.maternalCount);
			 	        	$('#p6').text(data.childrenCount);
			 	        	
			 	        	$('#d1').text(data.hyperPercent);
			 	        	$('#d2').text(data.diabetesPercent);
			 	        	$('#d3').text(data.majorPsychosisPercent);
			 	        	$('#d4').text(data.oldPercent);
			 	        	$('#d5').text(data.maternalPercent);
			 	        	$('#d6').text(data.childrenPercent);
			 	        	form.render();
			 			}
			 	});
            })
    		
    	}
    	//查询按钮声明点击事件，查询逻辑
        $('#selectButton').on('click', function(){
        	
        	dataRefresh();
        	tableConfig();
        });
        function packParams(){
        	var orgId=$("#orgId").val();
        	if(orgId=='0'){
        		orgId='';
        	}
        	var teamId=$("#teamId").val();
        	if(teamId=='0'){
        		teamId='';
        	}
        	var personTypeList=$("input[name='personType']");
        	var personType="";
        	for(i=0;i<personTypeList.length;i++){
        		if(personTypeList[i].checked){
        			personType=personTypeList[i].value;
        		}
        	}
        	
    		var param = {
    				orgId:orgId,
    				teamId:teamId,
    				personType:personType
    		}
    		return param;
    	}
        function typeRenderB(data){
        	if(data==undefined){
        		return "";
        	}else{
        		return data;
        	}
        }
        function typeRenderA(data){
        	if(data==undefined){
        		return "";
        	}else{
        		return data+'的团队';
        	}
        }
        
    </script>
</body>
</html>