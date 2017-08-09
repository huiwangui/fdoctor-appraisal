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
						<li class="active"><a href="javascript:void(0)">01月</a></li>
						<li><a href="javascript:void(0)">02月</a></li>
						<li><a href="javascript:void(0)">03月</a></li>
						<li><a href="javascript:void(0)">04月</a></li>
						<li><a href="javascript:void(0)">05月</a></li>
						<li><a href="javascript:void(0)">06月</a></li>
						<li><a href="javascript:void(0)">07月</a></li>
						<li><a href="javascript:void(0)">08月</a></li>
						<li><a href="javascript:void(0)">09月</a></li>
						<li><a href="javascript:void(0)">10月</a></li>
						<li><a href="javascript:void(0)">11月</a></li>
						<li><a href="javascript:void(0)">12月</a></li>

					</ul>
				</div>
				<div class="box3"></div>
				<div class="box4">
					<div>
						<h5 class="tc">成都天爱基层卫生院</h5>
						<table>
							<tr>
								<td><img src="/fdoctor-appraisal/statics/image/main/i1.png" alt="" /></td>
								<td>成都市xxxxxxxxxxxxxxxxxxxx</td>
							</tr>
							<tr>
								<td><img src="/fdoctor-appraisal/statics/image/main/i2.png" alt="" /></td>
								<td>
									<p>
										医生团队总数：<span class="blue_color">220</span>
									</p>
									<p class="s_block">
										<span class="tc blue_color"> 合格 60 </span> <span class="tc">
											不合格 30 </span> <span class="tc red_color"> 优秀 10 </span>
									</p>
								</td>
							</tr>
							<tr>
								<td><img src="/fdoctor-appraisal/statics/image/main/i3.png" alt="" /></td>
								<td>签约户数：<span class="blue_color">400</span>户
								</td>
							</tr>
							<tr>
								<td><img src="/fdoctor-appraisal/statics/image/main/i4.png" alt="" /></td>
								<td>签约居民数：<span class="blue_color">366</span>人
								</td>
							</tr>
							<tr>
								<td><img src="/fdoctor-appraisal/statics/image/main/i5.png" alt="" /></td>
								<td>慢病人数：<span class="blue_color">400</span>户
								</td>
							</tr>
							<tr>
								<td><img src="/fdoctor-appraisal/statics/image/main/i6.png" alt="" /></td>
								<td>特殊人群：<span class="blue_color">400</span>户
								</td>
							</tr>
							<tr>
								<td><img src="/fdoctor-appraisal/statics/image/main/i7.png" alt="" /></td>
								<td>考核得分：<span class="blue_color">98</span> <a href="/"
									class="treat">医疗机构实力</a>
								</td>
							</tr>
						</table>
					</div>
					<div style="display: none;">
						暂无优秀签约机构数据.
					</div>
				</div>
				<div class="box5"></div>
			</div>

			<!--第三排的-->
			<div class="section mt10 clearfix">
				<div class="box3"></div>
				<div class="box4">
					<div style="display: none;">
						<h5 class="tc">成都天爱基层卫生院</h5>
						<table>
							<tr>
								<td><img src="/fdoctor-appraisal/statics/image/main/i8.png" alt="" /></td>
								<td>成都市xxxxxxxxxxxxxxxxxxxx</td>
							</tr>
							<tr>
								<td><img src="/fdoctor-appraisal/statics/image/main/i1.png" alt="" /></td>
								<td>啥爽肤水的根深蒂固街道</td>
							</tr>
							<tr>
								<td><img src="/fdoctor-appraisal/statics/image/main/i3.png" alt="" /></td>
								<td>签约户数：<span class="blue_color">400</span>户
								</td>
							</tr>
							<tr>
								<td><img src="/fdoctor-appraisal/statics/image/main/i4.png" alt="" /></td>
								<td>签约居民数：<span class="blue_color">366</span>人
								</td>
							</tr>
							<tr>
								<td><img src="/fdoctor-appraisal/statics/image/main/i5.png" alt="" /></td>
								<td>慢病人数：<span class="blue_color">400</span>户
								</td>
							</tr>
							<tr>
								<td><img src="/fdoctor-appraisal/statics/image/main/i6.png" alt="" /></td>
								<td>特殊人群：<span class="blue_color">400</span>户
								</td>
							</tr>
							<tr>
								<td><img src="/fdoctor-appraisal/statics/image/main/i7.png" alt="" /></td>
								<td>考核得分：<span class="blue_color">98</span> <a href="/"
									class="treat">医疗机构实力</a>
								</td>
							</tr>
						</table>
					</div>
					<div>
						
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
	*	---------------------------------------全局事件声明--------------------------------------------
	*/
	//切换“签约管理”下面的内容，变换为糖尿病、高血压等
	function changeSignItem(type, obj){
		//切换之后的显示效果
		$('.num_blocks li').removeClass('active');
		$(obj).parent().addClass('active');
		
		$('#sign_item_type').val(type);	//设置隐藏域中的值为点击的值
		
		loadSignBar(type);	//重新加载签约总量数据
	}
	
	$('#sign_item_type').val('sign');	//默认查看总人数
	$('#sign_month').val('01');	//默认月份为1月
	/**
	*	----------------------------------------签约管理------------------------------------------------
	*/
	
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
				
				//实例化echarts
				var myChart = echarts.init(document.getElementById('sign_charts_div'));
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
				myChart.setOption(option);
 			}
 		});
	}
	
	loadSignBar('sign');	//默认为查询签约人数
	
	//加载
</script>

</html>