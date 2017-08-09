/**
 * 全选、不全选实现方法
 * 
 * @param tdId
 *            checkbox所在td的id
 * @param allCheckId
 *            全选那个checkbox的id
 */
function getAllCheck(tdId, allCheckId) {
	// 设置全选复选框
	$("#" + tdId + " :checkbox").click(function() {
		if ($(this).attr('id') != $("#" + allCheckId).attr('id')) {
			allchk();
		}
		;
	});
	function allchk() {
		var chknum = $("#" + tdId + " :checkbox").size() - 1;// 选项总个数
		var chk = 0;
		$("#" + tdId + " :checkbox").each(
				function() {
					if ($(this).attr('id') != $("#" + allCheckId).attr('id')
							&& this.checked) {
						chk++;
					}
				});
		if (chknum == chk) {// 全选
			$("#" + allCheckId).prop("checked", true);
		} else {// 不全选
			$("#" + allCheckId).prop("checked", false);
		}
	}
};

/**
 * 设置下拉框回显
 * 
 * @param selectId:下拉框的id
 * @param selectValue：后台传过来的这个下拉框的value值
 */
function setSelect(selectId, selectValue) {
	var $options = $("#" + selectId + " option");
	for (var i = 0; i < $options.length; i++) {
		var oprion = $($options.get(i));
		if (oprion.attr("value") == selectValue) {
			oprion.attr("selected", "selected");
		}
	}
};

/**
 * 设置checkbox回显
 * 
 * @param data
 *            传入的数据值，必须是0,1,2...格式
 * @param tdId
 *            checkbox容器id
 */
function setChecked(data, tdId) {
	var strs = data.split(",");
	var boxs = $("#" + tdId + " :checkbox");
	for (var i = 0; i < strs.length; i++) {
		for (var j = 0; j < boxs.length; j++) {
			if (strs[i] == $(boxs[j]).val()) {
				$(boxs[j]).prop("checked", true);
			}
		}
	}
}

/**
 * 控制输入框只能输入数字
 */
$.fn.number = function() {
	$(this).css("ime-mode", "disabled");
	this.bind("keypress", function(e) {
		var code = (e.keyCode ? e.keyCode : e.which); // 兼容火狐 IE
		if (!$.support.msie && (e.keyCode == 0x8)) { // 火狐下不能使用退格键
			return;
		}
		if (this.value.indexOf(".") == -1) {
			return (code >= 48 && code <= 57) || (code == 46);
		} else {
			return code >= 48 && code <= 57
		}
	});
	this.bind("paste", function() {
		return false;
	});
	this.bind("keyup", function() {
		if (this.value.slice(0, 1) == ".") {
			this.value = "";
		}
	});
	this.bind("blur", function() {
		if (this.value.slice(-1) == ".") {
			this.value = this.value.slice(0, this.value.length - 1);
		}
	});
};

/**
 * 将字符串首字母大写
 */
function titleUpperCase(s){
	return s.toLowerCase().split(/\s+/).reduce(function(prev, item, array, array) {  
        return prev + (prev.trim() && ' ') + item.slice(0, 1).toUpperCase() + item.slice(1);  
    }, '');  
}
