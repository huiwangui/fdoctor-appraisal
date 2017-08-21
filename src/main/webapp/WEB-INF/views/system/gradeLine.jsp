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
	<style>
		.datagrid-btable tr{height: 46px;}
	</style>   
  </head>
  
  <body>
	<table id="gradeLine" >
	</table>
	
	<script>
	 $(function () {
            var datagrid; //定义全局变量datagrid
            var editRow = undefined; //定义全局变量：当前编辑的行
            datagrid = $("#gradeLine").datagrid({
                url: '/fdoctor-appraisal/grade/findAll', //请求的数据源
                method: 'get',
    		    striped: true,
    		    height: 'auto',
    		    fitColumns: true,
    		    singleSelect: true,
    		    rownumbers: false,
    		    nowrap: false,
    		    showFooter: true,
                idField: 'id', //主键
                columns: [[//显示的列
                {field: 'id', title: '编号', sortable: true,width:18, checkbox: true },
                 { field: 'name', title: '等级名称',  sortable: true,width:8,
                     editor: { type: 'validatebox', options: { required: true} }
                 },
                  { field: 'lower', title: '分数下限',width:18,
                	  editor: {
  		                type: 'numberbox',
  		                options: {
  		                    min: 0,
  		                    max:100,
  		                    precision: 0,
  		                    required:true
  		                }
  		            },
                  },
                   { field: 'upper', title: '分数上限', width:18,
                	  editor: {
  		                type: 'numberbox',
  		                options: {
  		                    min: 0,
  		                    max:100,
  		                    precision: 0,
  		                    required:true
  		                }
  		            },
                   },
                   { field: 'remark', title: '备注',width:8,
                       editor: { type: 'validatebox', }
                   },
                   { field: 'updateTime', title: '更新时间',width:18,  align: 'left', formatter: formatDatebox },
                   ]],
               
                toolbar: [{ text: '添加', iconCls: 'icon-add', handler: function () {//添加列表的操作按钮添加，修改，删除等
                    //添加时先判断是否有开启编辑的行，如果有则把开户编辑的那行结束编辑
                    if (editRow != undefined) {
                        datagrid.datagrid("endEdit", editRow);
                    }
                    //添加时如果没有正在编辑的行，则在datagrid的第一行插入一行
                    if (editRow == undefined) {
                        datagrid.datagrid("insertRow", {
                            index: 0, // index start with 0
                            row: {

                            }
                        });
                        //将新插入的那一行开户编辑状态
                        datagrid.datagrid("beginEdit", 0);
                        //给当前编辑的行赋值
                        editRow = 0;
                    }

                }
                }, '-',
                 { text: '删除', iconCls: 'icon-remove', handler: function () {
                     //删除时先获取选择行
                     var rows = datagrid.datagrid("getSelections");
                     //选择要删除的行
                     if (rows.length > 0) {
                         $.messager.confirm("提示", "你确定要删除吗?", function (r) {
                             if (r) {
                            	 $.post("/fdoctor-appraisal/grade/delete",{body:JSON.stringify(rows)},function(result){
              				       if(result.code==200){
              				    	   jQuery.messager.alert('提示:','你好,删除成功，下月统计时生效!','info');
              				    	   $("#gradeLine").datagrid('reload');
              				       }else{
              				    	   jQuery.messager.alert('提示:','删除失败!','warning'); 
              				       }
              			         });
                             }
                         });
                     }
                     else {
                         $.messager.alert("提示", "请选择要删除的行", "error");
                     }
                 }
                 }, '-',
                 { text: '修改', iconCls: 'icon-edit', handler: function () {
                     //修改时要获取选择到的行
                     var rows = datagrid.datagrid("getSelections");
                     //如果只选择了一行则可以进行修改，否则不操作
                     if (rows.length == 1) {
                         //修改之前先关闭已经开启的编辑行，当调用endEdit该方法时会触发onAfterEdit事件
                         /*if (editRow != undefined) {
                             datagrid.datagrid("endEdit", editRow);
                         }  */
                         //当无编辑行时
                         if (editRow == undefined) {
                             //获取到当前选择行的下标
                             var index = datagrid.datagrid("getRowIndex", rows[0]);
                             //开启编辑
                             datagrid.datagrid("beginEdit", index);
                             //把当前开启编辑的行赋值给全局变量editRow
                             editRow = index;
                             //当开启了当前选择行的编辑状态之后，
                             //应该取消当前列表的所有选择行，要不然双击之后无法再选择其他行进行编辑
                             datagrid.datagrid("unselectAll");
                         }
                     }else{
                    	  $.messager.alert("提示", "请选择要修改的行", "error");
                     }
                 }
                 }, '-',
                 { text: '保存', iconCls: 'icon-save', handler: function () {
                     //保存时结束当前编辑的行，自动触发onAfterEdit事件如果要与后台交互可将数据通过Ajax提交后台
                     datagrid.datagrid("endEdit", editRow);
                 }
                 }, '-',
                 { text: '取消编辑', iconCls: 'icon-redo', handler: function () {
                     //取消当前编辑行把当前编辑行罢undefined回滚改变的数据,取消选择的行
                     editRow = undefined;
                     datagrid.datagrid("rejectChanges");
                     datagrid.datagrid("unselectAll");
                 }
                 }, '-'],
                onAfterEdit: function (rowIndex, rowData, changes) {
                    //endEdit该方法触发此事件
                    console.info(rowData);
                    console.info(changes);
                    editRow = undefined;
                    if(rowData.id){
                    	//提交修改
                    	delete rowData["updateTime"];
        			    $.post("/fdoctor-appraisal/grade/update",rowData,function(result){
        				       if(result.code==200){
        				    	   jQuery.messager.alert('提示:','你好,修改成功，下月统计时生效!','info'); 
        				    	   $("#gradeLine").datagrid('reload');	
        				       }else{
        				    	   jQuery.messager.alert('提示:','修改失败!','warning'); 
        				       }
        			     });
                    	
                    }else{
                    	//提交保存
        			    $.post("/fdoctor-appraisal/grade/save",rowData,function(result){
        				       if(result.code==200){
        				    	   jQuery.messager.alert('提示:','你好,保存成功，下月统计时生效!','info'); 
        				    	   $("#gradeLine").datagrid('reload');
        				       }else{
        				    	   jQuery.messager.alert('提示:','保存失败!','warning'); 
        				       }
        			     });
                    }
                    
                },
               /*  onLoadSuccess: function(data){   
                    var panel = $(this).datagrid('getPanel');   
                    var tr = panel.find('div.datagrid-body tr');   
                    tr.each(function(){   
                        var td = $(this).children('td');   
                        td.children("div").css({   
                            "height": "38px" 
                        });   
                    });   
                }, */
                onDblClickRow: function (rowIndex, rowData) {
                //双击开启编辑行
                   /*  if (editRow != undefined) {
                        datagrid.datagrid("endEdit", editRow);
                    }
                    if (editRow == undefined) {
                        datagrid.datagrid("beginEdit", rowIndex);
                        editRow = rowIndex;
                    } */
                }
            });
        });
	 
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