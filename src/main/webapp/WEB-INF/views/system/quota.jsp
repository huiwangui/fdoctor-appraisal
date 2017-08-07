<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>指标配置</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="/fdoctor-appraisal/statics/beginnerAdmin/plugins/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="/fdoctor-appraisal/statics/beginnerAdmin/css/global.css" media="all">
	<link rel="stylesheet" href="/fdoctor-appraisal/statics/beginnerAdmin/plugins/font-awesome/css/font-awesome.min.css">
	<link rel="shortcut icon" type="image/x-icon" href="/fdoctor-appraisal/statics/image/bitbug_favicon.ico" media="screen" />
	<script src="/fdoctor-appraisal/statics/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="/fdoctor-appraisal/statics/beginnerAdmin/plugins/layui/layui.js"></script>
    <link rel="stylesheet" type="text/css" href="/fdoctor-appraisal/statics/jquery-easyui-1.5.2/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="/fdoctor-appraisal/statics/jquery-easyui-1.5.2/themes/icon.css" />
    <script type="text/javascript" src="/fdoctor-appraisal/statics/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/fdoctor-appraisal/statics/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
	    
  </head>
  
  <body>
		<!-- <table id="dg" class="easyui-datagrid" title="Cell Editing in DataGrid" style="width:700px;height:auto"
			data-options="
				iconCls: 'icon-edit',
				singleSelect: true,
				url: '/fdoctor-appraisal/system/getAll',
				method:'get',
				onClickCell: onClickCell
			">
		<thead>
			<tr>
				<th data-options="field:'id',width:80">Item ID</th>
				<th data-options="field:'name',width:100,editor:'text'">Product</th>
				<th data-options="field:'rate',width:80,align:'right',editor:{type:'numberbox',options:{precision:1}}">List Price</th>
				<th data-options="field:'parentId',width:80,align:'right',editor:'numberbox'">Unit Cost</th>
				<th data-options="field:'remark',width:250,editor:'text'">Attribute</th>
				<th data-options="field:'updateTime',width:60,align:'center',editor:{type:'checkbox',options:{on:'P',off:''}}">Status</th>
			</tr>
		</thead>
	</table>
 
	<script type="text/javascript">
		$.extend($.fn.datagrid.methods, {
			editCell: function(jq,param){
				return jq.each(function(){
					var opts = $(this).datagrid('options');
					var fields = $(this).datagrid('getColumnFields',true).concat($(this).datagrid('getColumnFields'));
					for(var i=0; i<fields.length; i++){
						var col = $(this).datagrid('getColumnOption', fields[i]);
						col.editor1 = col.editor;
						if (fields[i] != param.field){
							col.editor = null;
						}
					}
					$(this).datagrid('beginEdit', param.index);
					for(var i=0; i<fields.length; i++){
						var col = $(this).datagrid('getColumnOption', fields[i]);
						col.editor = col.editor1;
					}
				});
			}
		});
		
		var editIndex = undefined;
		function endEditing(){
			if (editIndex == undefined){return true}
			if ($('#dg').datagrid('validateRow', editIndex)){
				$('#dg').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}
		function onClickCell(index, field){
			if (endEditing()){
				$('#dg').datagrid('selectRow', index)
						.datagrid('editCell', {index:index,field:field});
				editIndex = index;
			}
		}
	</script> -->
	
	<table id="dg" 
	</table>
	
	<a id="save" >保存</a>
		
 
	<script type="text/javascript">
		$('#dg').datagrid({
		    url: '/fdoctor-appraisal/system/getAll',
		    method: 'get',
		    striped: true,
		    height: 'auto',
		    fitColumns: true,
		    singleSelect: true,
		    rownumbers: false,
		    nowrap: false,
		    showFooter: true,
		    columns: [[
		       
		        { field: 'id', title: '--', width: 18, align: 'left',height: 100, hidden:'true'   },
		        { field: 'name', title: '指标名称', width:12,
		        	 styler:function cellStyler(value,row,index){  
		        		    if(value =='签约管理'||value =='随访体检'||value =='健康管理'){  
		        		            return 'color:red;font-weight:bold;text-align:left';  
		        		     }else{
		        		    	 return 'text-align:center'
		        		     }
		        		     
		        		}  
		        
		        },
		 
		        { field: 'rate', title: '考核占比（%）',  align: 'left',width:5,
		            editor: {
		                type: 'numberbox',
		                options: {
		                    min: 0,
		                    max:100,
		                    precision: 0,
		                    required:true
		                }
		            },
		            styler:function cellStyler(value,row,index){  
	        		    if(row.parentId!=0){  
	        		            return 'color:blue;';  
	        		     }else{
	        		    	 return 'color:red;'
	        		     }
	        		     
	        		}  
		        },
		        { field: 'remark', title: '备注', width: 16, align: 'left', editor:'text'  },
		        { field: 'updateTime', title: '更新时间', width: 8, align: 'left', formatter: formatDatebox },
		        { field: 'parentId', title: '父ID', width: 16, align: 'left', hidden:'true'  },
		    ]],
		    onBeforeLoad: function (param) {
		    },
		    onLoadSuccess: function (data) {
		    },
		    onLoadError: function () {
		        
		    },
		    onClickCell: function (rowIndex, field, value) {
		    	
		    	onClickCell2(rowIndex,field)
		        
		    }
		});
	
		$('#save').on('click',function(){
				var obj = $("#dg").datagrid("getRows");
				console.log(obj)
			    var firstRate=0;
			    var signRate=0;
			    var sfRate=0;
			    var healthRate=0;
				jQuery.each(obj, function(i) {  
					if(obj[i].parentId==0){
						firstRate=parseInt(firstRate)+parseInt(obj[i].rate)
					}
					if(obj[i].parentId==10){
						signRate=parseInt(signRate)+parseInt(obj[i].rate)
					}
					if(obj[i].parentId==20){
						sfRate=parseInt(sfRate)+parseInt(obj[i].rate)
					}
					if(obj[i].parentId==30){
						healthRate=parseInt(healthRate)+parseInt(obj[i].rate)
					}
				}); 
			    if(firstRate!=100){
			    	//提示 1级和不等100
			    	jQuery.messager.alert('提示:','你好,保存失败，请确保一级指标之和为100!','warning'); 
			    	return
			    }
			    if(healthRate!=100){
			    	jQuery.messager.alert('提示:','你好,保存失败，请确保二级健康管理指标之和为100!'+healthRate,'warning'); 
			   	    return
			    }
			    if(sfRate!=100){
			    	jQuery.messager.alert('提示:','你好,保存失败，请确保二级随访体检指标之和为100!'+sfRate,'warning'); 
			    	return
			    }
			    if(signRate!=100){
			    	jQuery.messager.alert('提示:','你好,保存失败，请确保二级签约管理指标之和为100!'+signRate,'warning'); 
			   	    return
			    }
			    //提交保存
			    $.post("/fdoctor-appraisal/system/save",{body:JSON.stringify(obj)},function(result){
				       if(result.code==200){
				    	   jQuery.messager.alert('提示:','你好,保存成功，下月统计时生效!','info'); 
				       }
			     });
		})
	
	
		$.extend($.fn.datagrid.methods, {
			editCell: function(jq,param){
				return jq.each(function(){
					var opts = $(this).datagrid('options');
					var fields = $(this).datagrid('getColumnFields',true).concat($(this).datagrid('getColumnFields'));
					for(var i=0; i<fields.length; i++){
						var col = $(this).datagrid('getColumnOption', fields[i]);
						col.editor1 = col.editor;
						if (fields[i] != param.field){
							col.editor = null;
						}
					}
					$(this).datagrid('beginEdit', param.index);
					for(var i=0; i<fields.length; i++){
						var col = $(this).datagrid('getColumnOption', fields[i]);
						col.editor = col.editor1;
					}
				});
			}
		});
		
		var editIndex = undefined;
		function endEditing(){
			if (editIndex == undefined){return true}
			if ($('#dg').datagrid('validateRow', editIndex)){
				$('#dg').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}
		function onClickCell2(index, field){
			if (endEditing()){
				$('#dg').datagrid('selectRow', index)
						.datagrid('editCell', {index:index,field:field});
				editIndex = index;
			}
		}
		
		
		Date.prototype.format = function (format) {  
		    var o = {  
		        "M+": this.getMonth() + 1, // month  
		        "d+": this.getDate(), // day  
		        "h+": this.getHours(), // hour  
		        "m+": this.getMinutes(), // minute  
		        "s+": this.getSeconds(), // second  
		        "q+": Math.floor((this.getMonth() + 3) / 3), // quarter  
		        "S": this.getMilliseconds()  
		        // millisecond  
		    }  
		    if (/(y+)/.test(format))  
		        format = format.replace(RegExp.$1, (this.getFullYear() + "")  
		            .substr(4 - RegExp.$1.length));  
		    for (var k in o)  
		        if (new RegExp("(" + k + ")").test(format))  
		            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));  
		    return format;  
		}  
		function formatDatebox(value) {  
		    if (value == null || value == '') {  
		        return '';  
		    }  
		    var dt;  
		    if (value instanceof Date) {  
		        dt = value;  
		    } else {  
		        dt = new Date(value);  
		    }  
		  
		    return dt.format("yyyy-MM-dd"); //扩展的Date的format方法(上述插件实现)  
		} 
	</script>
            
  </body>
  
</html>