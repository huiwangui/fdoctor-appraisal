<%@ page language="Java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>机构实力</title>        
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
  <script src="statics/echarts.min.js"></script>
 </head>
 <body>
	<table class="layui-table" lay-even="" lay-skin="nob">
		<tbody>
			<tr>
				<td><img src="statics/image/appraisal/address.png" /> ${organization.orgAddress }</td>
				<td><img src="statics/image/appraisal/sign.png" /> 签约户数：${organization.familyIncrement }户</td>
				<td><img src="statics/image/appraisal/person.png" /> 签约居民数：${organization.signIncrement }人</td>
			</tr>
			<tr>
				<td><img src="statics/image/appraisal/team.png" /> 医生团队总数：${organization.teamTotal}</td>
				<td><img src="statics/image/appraisal/sick.png" /> 慢病人数：${organization.chronicDiseaseNumber }人</td>
				<td><img src="statics/image/appraisal/score.png" /> 考核得分：${organization.resultScore }</td>
			</tr>
			<tr>
				<td>合格团队数量：${organization.qualifiedIncrement }</td>
				<td>不合格团队数量：${organization.unQualifiedIncrement }</td>
				<td>优秀团队数量：${organization.excellentIncrement }</td>

			</tr>
		</tbody>
	</table>

	<table class="layui-table" lay-even="" lay-skin="nob">
		<tr>
			<td><div id="comprehensive" style="width: 500px; height: 420px;"></div></td>
			<td><div id="sign" style="width: 500px; height: 420px;"></div></td>
		</tr>
		<tr>
			<td><div id="followUp" style="width: 500px; height: 420px;"></div></td>
			<td><div id="healthManage" style="width: 500px; height: 420px;"></div></td>
		</tr>
	</table>
	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    <div id="main" style="width: 500px;height:150px;"></div>  
     <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var comprehensiveChart = echarts.init(document.getElementById('comprehensive'));
        var signChart = echarts.init(document.getElementById('sign'));
        var followUpChart = echarts.init(document.getElementById('followUp'));
        var healthManageChart = echarts.init(document.getElementById('healthManage'));
	     // 指定图表的配置项和数据
	     //综合实力
	     comprehensiveChartOption = {
	         title: {
	             text: '医疗机构综合实力',
	             x:'center'
	         },
	         tooltip: {},
	         radar: {
	             indicator: [               
	                { name: '签约能力',max: 100,min:0},
	                { name: '随访管理',max: 100 ,min:0},
	                { name: '健康管理' ,max: 100,min:0},
	                { name: '居民满意度' ,max: 100,min:0},
	                 
	             ]
	         },
	         series: [{
	             name: '',
	             type: 'radar',           
	             data : [                 
	                  {
	                     value : [${organization.signManageScore}, ${organization.publicHealthScore}, ${organization.healthManageScore}, ${organization.customerScore}],
	                     name : '得分情况'
	                 } 
	             ],	          
	             itemStyle : { normal: {label : {show: true, position: 'top'}}},
	         }]
	    };
	     //签约
	     signOption = {
		         title: {
		             text: '医疗机构签约实力',
		             x:'center'
		         },
		         tooltip: {},
		         radar: {
		             indicator: [               
		                { name: '高血压',max: 100,min:0},
		                { name: '糖尿病',max: 100 ,min:0},
		                { name: '重症精神病' ,max: 100,min:0},
		                { name: '老年人' ,max: 100,min:0},
		                { name: '孕产妇' ,max: 100,min:0},
		                { name: '儿童' ,max: 100,min:0}		                 
		             ]
		         },
		         series: [{
		             name: '',
		             type: 'radar',           
		             data : [                 
		                  {
		                     value : [${organization.signHyperScore}, ${organization.signDiabetesScore}, ${organization.signPhychosisScore}, ${organization.signOldScore}, ${organization.signMaternalScore}, ${organization.signChildrenScore}],
		                     name : '得分情况'
		                 } 
		             ],	          
		             itemStyle : { normal: {label : {show: true, position: 'top'}}},
		         }]
		    };
	     
	     //随访
	     followUpOption = {
		         title: {
		             text: '医疗机构随访实力',
		             x:'center'
		         },
		         tooltip: {},
		         radar: {
		             indicator: [               
		                        { name: '高血压',max: 100,min:0},
		 		                { name: '糖尿病',max: 100 ,min:0},
		 		                { name: '重症精神病' ,max: 100,min:0},
		 		                { name: '老年人' ,max: 100,min:0},
		 		                { name: '孕产妇' ,max: 100,min:0},
		 		                { name: '儿童' ,max: 100,min:0}
		             ]
		         },
		         series: [{
		             name: '',
		             type: 'radar',           
		             data : [                 
		                  {
		                     value : [${organization.publicHealthHyperScore}, ${organization.publicHealthDiabetesScore}, ${organization.publicHealthPhychosisScore}, ${organization.publicHealthOldScore}, ${organization.publicHealthMaternalScore}, ${organization.publicHealthChildrenScore}],
		                     name : '得分情况'
		                 } 
		             ],	          
		             itemStyle : { normal: {label : {show: true, position: 'top'}}},
		         }]
		    };
	     //健康管理
	     healthManageOption = {
		         title: {
		             text: '医疗机构健康管理实力',
		             x:'center'
		         },
		         tooltip: {},
		         radar: {
		             indicator: [               
		                { name: '健康教育',max: 100,min:0},
		                { name: '问诊次数',max: 100 ,min:0},
		                { name: '建档数' ,max: 100,min:0},
		                { name: '健康评估' ,max: 100,min:0}
		             ]
		         },
		         series: [{
		             name: '',
		             type: 'radar',           
		             data : [                 
		                  {
		                     value : [${organization.healthManageEduScore}, ${organization.healthManageDailyActivityScore}, ${organization.healthManageDocumentScore}, ${organization.healthManageAssessmentScore} ],
		                     name : '得分情况'
		                 } 
		             ],	          
		             itemStyle : { normal: {label : {show: true, position: 'top'}}},
		         }]
		    };
	   

        // 使用刚指定的配置项和数据显示图表。
        comprehensiveChart.setOption(comprehensiveChartOption);
        signChart.setOption(signOption);
        followUpChart.setOption(followUpOption);
        healthManageChart.setOption(healthManageOption);
        </script>
 </body>
</html>