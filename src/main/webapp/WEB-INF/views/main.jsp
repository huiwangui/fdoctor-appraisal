<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="/fdoctor-appraisal/statics/css/estyle.css" />
<link rel="stylesheet"
	href="/fdoctor-appraisal/statics/css/easydropdown.css" />
<script type="text/javascript"
	src="/fdoctor-appraisal/statics/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript"
	src="/fdoctor-appraisal/statics/js/jquery.easydropdown.js"></script>
<script type="text/javascript"
	src="/fdoctor-appraisal/statics/echarts.min.js"></script>
<script type="text/javascript"
	src="/fdoctor-appraisal/statics/js/inputTools.js"></script>
</head>

<body>
	<div class="right_part">
		<!--上面的tab选项卡-->
		<div class="tab_nav clearfix">
			<ul>
				<li class="tab_item ">指标分类</li>
				<li class="tab_item active">签约管理</li>
				<li class="tab_item">公卫服务</li>
				<li class="tab_item">健康管理</li>
			</ul>

			<div class="time_chose">
				<select tabindex="4" class="dropdown" id="select_year">
					<c:forEach items="${years}" var="year">
						<option value="${year}">${year}</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<!--tab选项卡内容-->
		<div class="tab_content">
		
			<!-- 隐藏域，用于记录当前加载的是总人数还是其他特殊人群 -->
			<input type="hidden" id="sign_item_type">
			
			<ul class="num_blocks">
				<li class="item active"><a href="javascript:void(0)" onclick="changeSignItem('sign', this)">
						<p>
							<span class="num" inc-data-name="signIncrement"></span><span>人</span>
						</p>
						<p class="p2">总人数</p>
				</a></li>
				<li class="item"><a href="javascript:void(0)" onclick="changeSignItem('hyper', this)">
						<p>
							<span class="num" inc-data-name="hyperIncrement"></span><span>人</span>
						</p>
						<p class="p2">高血压 &nbsp;占比 : <span pro-data-name="hyperProportion"></span></p>
				</a></li>
				<li class="item"><a href="javascript:void(0)" onclick="changeSignItem('diabetes', this)">
						<p>
							<span class="num" inc-data-name="diabetesIncrement"></span><span>人</span>
						</p>
						<p class="p2">糖尿病 &nbsp;占比 :  <span pro-data-name="diabetesProportion"></span></p>
				</a></li>
				<li class="item"><a href="javascript:void(0)" onclick="changeSignItem('phychosis', this)">
						<p>
							<span class="num" inc-data-name="phychosisIncrement"></span><span>人</span>
						</p>
						<p class="p2">重性精神病 &nbsp;占比 : <span pro-data-name="phychosisProportion"></span> </p>
				</a></li>
				<li class="item"><a href="javascript:void(0)" onclick="changeSignItem('old', this)">
						<p>
							<span class="num" inc-data-name="oldIncrement"></span><span>人</span>
						</p>
						<p class="p2">老年人 &nbsp;占比 :  <span pro-data-name="oldProportion"></span></p>
				</a></li>
				<li class="item"><a href="javascript:void(0)" onclick="changeSignItem('maternal', this)">
						<p>
							<span class="num" inc-data-name="maternalIncrement"></span><span>人</span>
						</p>
						<p class="p2">孕产妇 &nbsp;占比 :  <span pro-data-name="maternalProportion"></span></p>
				</a></li>
				<li class="item"><a href="javascript:void(0)" onclick="changeSignItem('children', this)">
						<p>
							<span class="num" inc-data-name="childrenIncrement"></span><span>人</span>
						</p>
						<p class="p2">儿童 &nbsp;占比 :  <span pro-data-name="childrenProportion"></span></p>
				</a></li>
			</ul>

			<!--下面是表单模块-->
			<!--第一排的-->
			<div class="section clearfix">
				<div class="box1" id="sign_charts_div"></div>
			</div>

			<!--第二排的-->
			<div class="section clearfix">
				
				<!-- 隐藏域，用于存放当前记录的月份 -->
				<input type="hidden" id="sign_month">
				
				<div class="month">
					<ul>
						<li class="active"><a href="javascript:void(0)" onclick="changeSignMonth('01', this)">01月</a></li>
						<li><a href="javascript:void(0)" onclick="changeSignMonth('02', this)">02月</a></li>
						<li><a href="javascript:void(0)" onclick="changeSignMonth('03', this)">03月</a></li>
						<li><a href="javascript:void(0)" onclick="changeSignMonth('04', this)">04月</a></li>
						<li><a href="javascript:void(0)" onclick="changeSignMonth('05', this)">05月</a></li>
						<li><a href="javascript:void(0)" onclick="changeSignMonth('06', this)">06月</a></li>
						<li><a href="javascript:void(0)" onclick="changeSignMonth('07', this)">07月</a></li>
						<li><a href="javascript:void(0)" onclick="changeSignMonth('08', this)">08月</a></li>
						<li><a href="javascript:void(0)" onclick="changeSignMonth('09', this)">09月</a></li>
						<li><a href="javascript:void(0)" onclick="changeSignMonth('10', this)">10月</a></li>
						<li><a href="javascript:void(0)" onclick="changeSignMonth('11', this)">11月</a></li>
						<li><a href="javascript:void(0)" onclick="changeSignMonth('12', this)">12月</a></li>

					</ul>
				</div>
				<div class="box3" id="excellent_org_charts_div"></div>
				<div class="box4">
					<div id="org_detail_div">
						<h5 class="tc" org-field-name="orgName"></h5>
						<table>
							<tr>
								<td><img src="/fdoctor-appraisal/statics/image/main/i1.png" alt="" /></td>
								<td org-field-name="orgAddress"></td>
							</tr>
							<tr>
								<td><img src="/fdoctor-appraisal/statics/image/main/i2.png" alt="" /></td>
								<td>
									<p>
										医生团队总数：<span class="blue_color" org-field-name="teamTotal"></span>
									</p>
									<p class="s_block">
										<span class="tc blue_color"> 合格 <span org-field-name="qualifiedIncrement"></span> </span> <span class="tc">
											不合格<span org-field-name="unQualifiedIncrement"></span>  </span> <span class="tc red_color"> 优秀
											 <span org-field-name="excellentIncrement"></span> </span>
									</p>
								</td>
							</tr>
							<tr>
								<td><img src="/fdoctor-appraisal/statics/image/main/i3.png" alt="" /></td>
								<td>签约户数：<span class="blue_color" org-field-name="familyIncrement"></span>户
								</td>
							</tr>
							<tr>
								<td><img src="/fdoctor-appraisal/statics/image/main/i4.png" alt="" /></td>
								<td>签约居民数：<span class="blue_color" org-field-name="signIncrement"></span>人
								</td>
							</tr>
							<tr>
								<td><img src="/fdoctor-appraisal/statics/image/main/i5.png" alt="" /></td>
								<td>慢病人数：<span class="blue_color" org-field-name="chronicDiseaseNumber"></span>人
								</td>
							</tr>
							<tr>
								<td><img src="/fdoctor-appraisal/statics/image/main/i7.png" alt="" /></td>
								<td>考核得分：<span class="blue_color" org-field-name="resultScore"></span> <a href="javascript:void(0)"
									class="treat">医疗机构实力</a>
								</td>
							</tr>
						</table>
					</div>
					<div style="display: none;" id="org_not_found_div">
						暂无优秀签约机构数据.
					</div>
				</div>
				<div class="box5"></div>
			</div>

			<!--第三排的-->
			<div class="section mt10 clearfix">
				<div class="box3" id="excellent_team_charts_div"></div>
				<div class="box4">
					<div id="team_detail_div">
						<h5 class="tc" team-field-name="doctorName"></h5>
						<table>
							<tr>
								<td><img src="/fdoctor-appraisal/statics/image/main/i8.png" alt="" /></td>
								<td team-field-name="orgAddress"></td>
							</tr>
							<tr>
								<td><img src="/fdoctor-appraisal/statics/image/main/i1.png" alt="" /></td>
								<td team-field-name="orgName"></td>
							</tr>
							<tr>
								<td><img src="/fdoctor-appraisal/statics/image/main/i3.png" alt="" /></td>
								<td>签约户数：<span class="blue_color" team-field-name="familyIncrement"></span>户
								</td>
							</tr>
							<tr>
								<td><img src="/fdoctor-appraisal/statics/image/main/i4.png" alt="" /></td>
								<td>签约居民数：<span class="blue_color" team-field-name="signIncrement"></span>人
								</td>
							</tr>
							<tr>
								<td><img src="/fdoctor-appraisal/statics/image/main/i5.png" alt="" /></td>
								<td>慢病人数：<span class="blue_color" team-field-name="chronicDiseaseNumber"></span>户
								</td>
							</tr>
							<tr>
								<td><img src="/fdoctor-appraisal/statics/image/main/i7.png" alt="" /></td>
								<td>考核得分：<span class="blue_color" team-field-name="resultScore"></span> <a href="javascript:void(0)"
									class="treat">医疗团队实力</a>
								</td>
							</tr>
						</table>
					</div>
					<div id="team_not_found_div" style="display: none;">
						
						暂无优秀签约团队数据.
					</div>
				</div>
				<div class="box5"></div>
			</div>


		</div>

	</div>



</body>

<script type="text/javascript">
	/**
	*	---------------------------------------全局事件、函数声明--------------------------------------------
	*/
	//切换“签约管理”下面的内容，变换为糖尿病、高血压等
	function changeSignItem(type, obj){
		//切换之后的显示效果
		$('.num_blocks li').removeClass('active');
		$(obj).parent().addClass('active');
		
		$('#sign_item_type').val(type);	//设置隐藏域中的值为点击的值
		
		loadSignBar(type);	//重新加载签约总量数据
		loadExcellentOrgBar();	//重新加载优秀机构数据
		loadExcellentTeamBar();	//重新加载优秀团队数据
	}
	
	//切换“签约管理”下面的月份
	function changeSignMonth(month, obj){
		//切换之后的显示效果
		$('.month li').removeClass('active');
		$(obj).parent().addClass('active');
		
		$('#sign_month').val(month);	//设置隐藏域中的值为点击的值
		
		loadExcellentOrgBar();	//重新加载优秀机构数据
		loadExcellentTeamBar();	//重新加载优秀团队数据
	}
	
	//加载通用柱状图
	function loadCommonBarCharts(chartsObj, legend, unit, xAxisData, seriesData){
		var option = {
				tooltip: {
			        trigger: 'axis',
			        formatter: '{b0}' + legend + ': {c0}' + unit
			    },
			    legend: {
			        data:[legend]
			    },
			    xAxis: [
			        {
			            type: 'category',
			            data: xAxisData,
			            axisPointer: {
			                type: 'shadow'
			            }
			        }
			    ],
			    yAxis: [
			        {
			            type: 'value',
			            name: legend,
			            axisLabel: {
			                formatter: '{value} ' + unit
			            }
			        }
			    ],
			    series: [
			        {
			            name:legend,
			            type:'bar',
			            data: seriesData
			        }
			    ],
			    color : ['#6699FF']
		}
		chartsObj.setOption(option);
	}
	
	$('#sign_item_type').val('sign');	//默认查看总人数
	$('#sign_month').val('01');	//默认月份为1月
	
	
	
	
	/**
	*	----------------------------------------签约管理------------------------------------------------
	*/
	
	//============================页面第一排相关======================
	//加载签约总量数据
	function loadSignTotalData(){
		$.ajax({
 			type : 'GET',
 			url : '/fdoctor-appraisal/main/getSignTotalData',
 			data : {
 				year : $('#select_year').val()
 			},
 			success : function(data) {
				$.each(data.data, function(name, value) {
					$("[inc-data-name='" + name + "']").text(value);
					$("[pro-data-name='" + name + "']").text((value * 100).toFixed(1) + '%');
				});
 			}
 		});
	}
	
	loadSignTotalData();
	
	//实例化总签约charts
	var signBarChart = echarts.init(document.getElementById('sign_charts_div'));
	
	//加载所有年份签约趋势数据
	function loadSignBar(type){
		$.ajax({
 			type : 'GET',
 			url : '/fdoctor-appraisal/main/getMonthSignList',
 			data : {
 				year : $('#select_year').val()
 			},
 			success : function(data) {
 				//封装charts数据
				var chartsData = [];
				for(var i = 0; i < data.data.length; i++){
					chartsData.push(data.data[i][type + 'Increment']);
				}
				
				
				var option = {
						tooltip: {
					        trigger: 'axis',
					        formatter: '{b0}签约量: {c0}人'
					    },
					    legend: {
					        data:['签约量']
					    },
					    xAxis: [
					        {
					            type: 'category',
					            data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
					            axisPointer: {
					                type: 'shadow'
					            }
					        }
					    ],
					    yAxis: [
					        {
					            type: 'value',
					            name: '签约量',
					            axisLabel: {
					                formatter: '{value} 人'
					            }
					        }
					    ],
					    series: [
					        {
					            name:'签约量',
					            type:'bar',
					            data: chartsData
					        },
					        {
					            name:'签约量',
					            type:'line',
					            data: chartsData
					        }
					    ],
					    color : ['#6699FF']
				}
				signBarChart.setOption(option);
 			}
 		});
	}
	
	loadSignBar('sign');	//默认为查询签约人数
	
	//============================页面第二排相关======================
	
	//封装target参数，将参数转化为后台模型中的字段，用于后台反射调用
	function signParamTarget(param){
		if(param == 'sign'){
			return 'signManageScore';
		}else{
			return 'sign' + titleUpperCase(param) + 'Score';
		}
	}
	
	//实例化优秀团队柱状图charts
	var signExcellentOrgBarChart = echarts.init(document.getElementById('excellent_org_charts_div'));
	signExcellentOrgBarChart.on('click', function (params) {
		//发送请求获取机构的信息
		$.ajax({
 			type : 'GET',
 			url : '/fdoctor-appraisal/main/getOrgDetail',
 			data : {
 				month : $('#select_year').val() + $('#sign_month').val(),
 				orgId : params.data.orgId
 			},
 			success : function(orgScoreInfo) {
 				if(orgScoreInfo.code == 200){
 					//展示机构得分详情
 					$('#org_detail_div').removeAttr('style');
 					$('#org_not_found_div').attr('style', 'display:none;');
 					
 					$("[org-field-name]").text('');
 					
 					$.each(orgScoreInfo.data, function(name, value) {
 						$("[org-field-name='" + name + "']").text(value);
 					});
 				}else{
 					//隐藏机构得分详情，展示提示信息
 					$('#org_not_found_div').removeAttr('style');
 					$('#org_detail_div').attr('style', 'display:none;');
 				}
 			}
 		});
	});
	
	//加载优秀机构charts
	function loadExcellentOrgBar(){
		$.ajax({
 			type : 'GET',
 			url : '/fdoctor-appraisal/main/getMonthSignExcellentOrgList',
 			data : {
 				month : $('#select_year').val() + $('#sign_month').val(),
 				target : signParamTarget($('#sign_item_type').val())
 			},
 			success : function(data) {
 				if(data.code == '200'){
 					var orgNameArr = [];
 					var incrementArr = [];
 					//分别封装机构名数组、机构对应数据数组
 					for(var i = 0; i < data.data.length; i++){
 						orgNameArr.push(data.data[i].orgName);
 						var dataObj = {
 								orgId : data.data[i].orgId,
 								value : data.data[i][$('#sign_item_type').val() + 'Increment']
 						}
 						incrementArr.push(dataObj);
 					}
 					
 					//加载柱状图
 					loadCommonBarCharts(signExcellentOrgBarChart, '签约量', '人', orgNameArr, incrementArr);
 					
 					if(data.data.length > 0){
 						//发送请求获取第一个机构的信息
 						$.ajax({
 				 			type : 'GET',
 				 			url : '/fdoctor-appraisal/main/getOrgDetail',
 				 			data : {
 				 				month : $('#select_year').val() + $('#sign_month').val(),
 				 				orgId : data.data[0].orgId
 				 			},
 				 			success : function(orgScoreInfo) {
 				 				if(orgScoreInfo.code == 200){
 				 					//展示机构得分详情
 				 					$('#org_detail_div').removeAttr('style');
 				 					$('#org_not_found_div').attr('style', 'display:none;');
 				 					
 				 					$("[org-field-name]").text('');
 				 					
 				 					$.each(orgScoreInfo.data, function(name, value) {
 				 						$("[org-field-name='" + name + "']").text(value);
 				 					});
 				 				}else{
 				 					//隐藏机构得分详情，展示提示信息
 				 					$('#org_not_found_div').removeAttr('style');
 				 					$('#org_detail_div').attr('style', 'display:none;');
 				 				}
 				 			}
 				 		});
 					}else{
 						//隐藏机构得分详情，展示提示信息
	 					$('#org_not_found_div').removeAttr('style');
	 					$('#org_detail_div').attr('style', 'display:none;');
 					}
 				}
 			}
 		});
	}
	
	loadExcellentOrgBar();
	
	//============================页面第三排相关======================
		
	//实例化优秀团队柱状图charts
	var signExcellentTeamBarChart = echarts.init(document.getElementById('excellent_team_charts_div'));
	signExcellentTeamBarChart.on('click', function (params) {
		//发送请求获取团队的信息
		$.ajax({
 			type : 'GET',
 			url : '/fdoctor-appraisal/main/getTeamDetail',
 			data : {
 				month : $('#select_year').val() + $('#sign_month').val(),
 				teamId : params.data.teamId
 			},
 			success : function(teamScoreInfo) {
 				if(teamScoreInfo.code == 200){
 					//展示团队得分详情
 					$('#team_detail_div').removeAttr('style');
 					$('#team_not_found_div').attr('style', 'display:none;');
 					
 					$("[team-field-name]").text('');
 					
 					$.each(teamScoreInfo.data, function(name, value) {
 						$("[team-field-name='" + name + "']").text(value);
 					});
 					$("[team-field-name='doctorName']").text(teamScoreInfo.data.doctorName + '医生团队');
 				}else{
 					//隐藏团队得分详情，展示提示信息
 					$('#team_not_found_div').removeAttr('style');
 					$('#team_detail_div').attr('style', 'display:none;');
 				}
 			}
 		});
	});
	
	//加载优秀团队charts
	function loadExcellentTeamBar(){
		$.ajax({
 			type : 'GET',
 			url : '/fdoctor-appraisal/main/getMonthSignExcellentTeamList',
 			data : {
 				month : $('#select_year').val() + $('#sign_month').val(),
 				target : signParamTarget($('#sign_item_type').val())
 			},
 			success : function(data) {
 				if(data.code == '200'){
 					var teamNameArr = [];
 					var incrementArr = [];
 					//分别封装机构名数组、机构对应数据数组
 					for(var i = 0; i < data.data.length; i++){
 						teamNameArr.push(data.data[i].doctorName + '医生团队');
 						var dataObj = {
 								teamId : data.data[i].teamId,
 								value : data.data[i][$('#sign_item_type').val() + 'Increment']
 						}
 						incrementArr.push(dataObj);
 					}
 					
 					//加载柱状图
 					loadCommonBarCharts(signExcellentTeamBarChart, '签约量', '人', teamNameArr, incrementArr);
 					
 					if(data.data.length > 0){
 						$.ajax({
 				 			type : 'GET',
 				 			url : '/fdoctor-appraisal/main/getTeamDetail',
 				 			data : {
 				 				month : $('#select_year').val() + $('#sign_month').val(),
 				 				teamId : data.data[0].teamId
 				 			},
 				 			success : function(teamScoreInfo) {
 				 				if(teamScoreInfo.code == 200){
 				 					//展示团队得分详情
 				 					$('#team_detail_div').removeAttr('style');
 				 					$('#team_not_found_div').attr('style', 'display:none;');
 				 					
 				 					$("[team-field-name]").text('');
 				 					
 				 					$.each(teamScoreInfo.data, function(name, value) {
 				 						$("[team-field-name='" + name + "']").text(value);
 				 					});
 				 					$("[team-field-name='doctorName']").text(teamScoreInfo.data.doctorName + '医生团队');
 				 				}else{
 				 					//隐藏团队得分详情，展示提示信息
 				 					$('#team_not_found_div').removeAttr('style');
 				 					$('#team_detail_div').attr('style', 'display:none;');
 				 				}
 				 			}
 				 		});
 					}else{
 						//隐藏团队得分详情，展示提示信息
	 					$('#team_not_found_div').removeAttr('style');
	 					$('#team_detail_div').attr('style', 'display:none;');
 					}
 				}
 			}
 		});
	}
	
	loadExcellentTeamBar();
	
</script>

</html>