<%@ page language="Java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../../views/include/taglib.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>医疗机构考核结果</title>        
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">    
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <link rel="stylesheet" href="statics/beginnerAdmin/plugins/layui/css/layui.css" media="all" />
  <link rel="stylesheet" href="statics/beginnerAdmin/plugins/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="statics/beginnerAdmin/css/btable.css" />
  <script type="text/javascript" src="statics/js/jquery-2.1.4.min.js"></script>  
  <script type="text/javascript" src="statics/beginnerAdmin/plugins/layui/layui.js"></script>
  <script type="text/javascript" src="statics/js/My97DatePicker/WdatePicker.js"></script>
  
 </head>
 <body style=" background-color: gainsboro;">
 
      <div style="margin:0px; background-color: white;">
        <blockquote class="layui-elem-quote">
          <form class="layui-form" action="">
        	<div class="layui-form-item" align="left" style="margin-left: 0px;margin-top: 10px;">
			  	<div class="layui-inline"  >
				  	<label class="layui-form-label" style="padding:9px 0"> 医疗机构：</label>
				    <div class="layui-input-inline" ">
				      	<select name="orgId" id="orgId" lay-search>
							<option value="" style="width: 210px;">请选择</option>			 
								<c:forEach items="${organizationList}" var="organizationItem">
									<option value="${organizationItem.id}">${organizationItem.orgName}</option>
								</c:forEach> 
						</select>  
				    </div>
			  	</div>
			  	
			  	<div class="layui-inline" >
			   	    <label class="layui-form-label"  style="width: 100px; padding:9px 0"> 月份：</label>
					<div class="layui-input-inline">
						<input type="text" id="month" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy年MM月'})" class="Wdate" style="color:#666;height:38px;text-indent:10px;border:1px solid #e6e6e6;line-height:38px;"/> 
					</div>     
			    </div>

			    <div class="layui-inline" >
			    	 <div class="layui-input-inline">
			    	<button class="layui-btn layui-btn-radius" style="width: 150px;" id="selectButton" type="button">查询</button>
			    	</div>
			    </div>
			    
			 </div>
			</form>
        </blockquote>
		 
        <div id="content" style="width: 100%;height: 500px;"></div>
    </div>
    
     <script>
	     //首页默认展示上月数据
	     var date=new Date();
	     var year=date.getFullYear(); 
	     var lastMonth=date.getMonth();
	     if(lastMonth<10){
	    	 lastMonth = "0"+lastMonth;
	     }
	     var lastTime = (year.toString()+"年"+lastMonth.toString()+"月");     	 
	     document.getElementById('month').value=lastTime;
		 
		 function tableConfig(){
	    		layui.config({
	                base: '/fdoctor-appraisal/statics/beginnerAdmin/js/'
	            }).use(['btable','layer'], function () {
	                var layer = layui.layer;
	                
	                var btable = layui.btable(),
	                    $ = layui.jquery;
	                
	                
	                btable.set({
	                    elem: '#content',
	                    url: '/fdoctor-appraisal/organization/organizationScoreList',
	                    type: 'GET',
	                    pageSize: 15,
	                    columns: [{
	                        fieldName: '医疗机构名称',
	                        field: 'orgName'                        
	                    },{
	                        fieldName: '签约户数/人数',
	                        field: 'signFamilyAndPerson'                        
	                    },{
	                        fieldName: '签约管理考评',
	                        field: 'signManageScore'
	                    },{
	                        fieldName: '随访管理考评',
	                        field: 'publicHealthScore'
	                    },{
	                        fieldName: '健康管理考评',
	                        field: 'healthManageScore'
	                    },{
	                    	fieldName: '居民满意度考评',
	                        field: 'customerScore'	                      
	                    },{
	                    	fieldName: '考核结果',
	                    	field : 'resultScore'                        
	                    } ,{
	                    	fieldName: '机构实力',
	                    	field : 'map', 
	                    	colRender : 'typeRender'	                        
	                    }],
	                    even: true,
	                    //skin: 'row',
	                    checkbox: false,
	                    field: 'id',
	                    paged: true,
	                    //singleSelect: true,
	                    params : packParams(),
	                });
	                btable.render();
	               $(window).on('resize', function (e) {
	                    var $that = $(this);
	                    $('#content').height($that.height() - 92);
	                }).resize();
	                
	            });
	    		
	    		
	    	}
	    	
	    	tableConfig();
	    
	    	//查询按钮声明点击事件，查询逻辑
	        $('#selectButton').on('click', function(){
	        	tableConfig();
	        });
	  	  	
	        function packParams(){
	        	var orgId=$("#orgId").val();
	        	if(orgId=='0'){
	        		orgId='';
	        	}
	        	
	    		var param = {
	    				orgId:orgId,
	    				month:$("#month").val()
	    				 
	    		}
	    		return param;
	    	}
	         function typeRender(data){
	        	var data=eval(data);
	        	return '<button data-method="offset" data-type="auto" style="width:125px" class="layui-btn" onclick="goHand(\''+data.orgId+'\',\''+data.month+'\')" >查看</button>';
	        	 
		 
	        } 
			 function goHand(orgId,month){
				layer.open({
             		  type: 2,
             		  title: false,
             		  id : Math.ceil(150),
             		  area: ['1100px', '580px'],
             		  closeBtn: 1,
             		  content: "/fdoctor-appraisal/organization/organizationStrength?month="+month+"&orgId="+orgId
              	});
 
			} 
	</script>
 </body>
</html>