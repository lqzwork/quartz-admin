/**
 * 默认的表格参数 dep:easyui
 */
var defPagiGridOpts = {
	title : '列表',
	fitColumns : true,
	loadMsg : "数据加载中，请稍后...",
	singleSelect : true,
	rownumbers : true,
	pagination : true,
	showFooter : true,
	toolbar : '#tb',
	exportb : '#exportBtn',
	deltb : '#delBtn',
	onLoadError : function(data) {
		var json = eval(data)
		alert(json.responseText);
	}

};

var selector;
var exurl;
var delurl;
/**
 * 加载table
 * 
 * @param {Object}
 *            tableOptions 参数明细： exportb:导出按钮:默认'#exportBtn' exportURL:导出url
 *            delayLoad:false 延迟加载数据
 */
function DefDataGrid(tableOptions) {

	var emp = {};
	$.extend(emp, defPagiGridOpts, tableOptions);
	if (emp.delayLoad) {
		this.dataUrl = emp.url;
		delete emp.url;
	}
	this.opts = emp;
	var dg = this;
	selector = dg.opts.selector;
	exurl = dg.opts.exportURL;
	delurl = dg.opts.deleteURL;
	$(dg.opts.selector).datagrid(dg.opts);
	// 分页器
	var p1 = $(dg.opts.selector).datagrid('getPager');
	var opt = $(dg.opts.selector).datagrid.options;
	$(p1).pagination({
		pageSize : 10,// 每页显示的记录条数，默认为10
		pageList : [ 10, 50, 100 ],// 可以设置每页记录条数的列表
		beforePageText : '第',// 页数文本框前显示的汉字
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	});
}
function exportOnclick() {
	exportExcel(selector, exurl);
}

function delOnclick() {
	delRow(selector, delurl);
}

function delRow(tableSelector, delurl) {
	var datagrid_rows = $(tableSelector).datagrid("getRows");
	var selected_row = $(tableSelector).datagrid("getSelected");
	if (JSON.stringify(datagrid_rows) == '[]') {
		alert("查询结果区域没有数据可删除");
	} else if (JSON.stringify(selected_row) == null) {
		alert("请选中要删除的公告");
	} else {

		if (selected_row.id == "-1") {
			alert("公告不存在");
		}
		var noticeId = selected_row.id;
		var serverId = selected_row.serverId;
		$.ajax({
			type : 'post',
			url : delurl,
			data : "noticeId=" + noticeId + "&serverId=" + serverId,
			dataType : 'json',
			success : function(result) {
				$.ajax({
					type : 'post',
					url : "/gmJson/querybroadcast.do?page=1&&rows=10",
					dataType : 'json',
					success : function(result) {
						var tableOptions = {
							// 数据url
							url : '/gmJson/querybroadcast.do',
							selector : '#list_data',
							title : '公告查询',
							exportURL : '/excel/exportExcel.do',
							deleteURL : '/gmJson/deletebroadcast.do'

						};
						DefDataGrid(tableOptions);
					},
					error : function(XMLHttpRequest, textStatus, errorThrown,
							result) {
						alert(JSON.stringify(XMLHttpRequest.responseText));
					}
				});
			},
			error : function(XMLHttpRequest, textStatus, errorThrown, result) {

				alert(JSON.stringify(XMLHttpRequest.responseText));

			}
		});
	}
}
/**
 * 导出datagrid excel
 * 
 * @param {Object}
 *            datagrid选择器
 * @param {Object}
 *            导出地址 dep:easyui
 */
function exportExcel(tableSelector, exportUrl) {
	var datagrid_rows = $(tableSelector).datagrid("getRows");
	if (JSON.stringify(datagrid_rows) == '[]') {
		alert("查询结果区域没有数据可导出");
	} else {
		$('#excelForm').remove();
		var fields = [];
		$($(tableSelector).datagrid('getColumnFields', true)).each(function() {
			var co = $(tableSelector).datagrid("getColumnOption", this);
			if ((co.hidden == undefined || co.hidden == false) && !co.checkbox)
				fields.push(co);
		});
		$($(tableSelector).datagrid('getColumnFields', false)).each(function() {
			var co = $(tableSelector).datagrid("getColumnOption", this);
			if ((co.hidden == undefined || co.hidden == false) && !co.checkbox)
				fields.push(co);
		});
		var rowsData = [];
		$(datagrid_rows).each(function() {
			rowsData.push(this);
		});
		var form = $('<form></form>');
		form.attr('method', 'post').attr('action', exportUrl).attr('id',
				'excelForm').css('display', 'none').appendTo($('body'));
		addRowsToForm('#excelForm', 'fields', fields);
		// addRowsToForm('#excelForm', 'rowsData', rowsData);
		addSringToForm('#excelForm', 'rowsData', JSON.stringify(rowsData));
		submitFormData('#excelForm');
		form.remove();
	}
}
/**
 * 提交表单
 * 
 * @param {String}
 *            selector 选择器字符串
 * @param {Function}
 *            onSubmit 提交前执行
 * @param {Function}
 *            success 成功后执行
 * @param {Function}
 *            failed 失败时执行
 * @param {Function}
 *            error 未知错误时执行 dep:easyui
 */
function submitFormData(selector, onSubmit, success, failed, error) {

	$(selector).form('submit', {
		success : function(downloadpath) {
			var wr = window.location.href.toString();
			var s = wr.substring(0, wr.indexOf("/", 10));
			var dlp = downloadpath.split("/");
			var ws = s + "/" + dlp[1] + "/" + dlp[2];
			window.location.href = ws;
		}
	})
}
/**
 * 
 * @param {String}
 *            selector 选择器字符串
 * @param {String}
 *            prefix 表格input name 前缀
 * @param {Object}
 *            rows 数据对象集合 dep:jquery
 */
function addRowsToForm(selector, prefix, rows) {
	var form = $(selector);
	var temp = $('<div class="temp"></div>');
	var temp2 = document.createDocumentFragment();
	var index = 0;
	$(rows).each(
			function() {
				for (v in this) {
					var name = prefix + '[' + index + '].' + v;
					var input = $(
							'<input type="hidden" class="temp" name="' + name
									+ '" />').val(this[v]);
					input.appendTo(temp2);
				}
				index++;
			});
	var input2 = $('<input type="hidden"  name="' + prefix + 'Length'
			+ '" value="' + rows.length + '" class="temp"/>');
	input2.appendTo(temp2);
	temp.append(temp2);
	form.append(temp);

}
/**
 * 
 * @param {String}
 *            selector 选择器字符串
 * @param {String}
 *            prefix 表格input name 前缀
 * @param {Object}
 *            rows 数据对象集合 dep:jquery
 */
function addSringToForm(selector, prefix, str) {
	var form = $(selector);
	var temp = $('<div class="temp"></div>');
	var temp2 = document.createDocumentFragment();
	var index = 0;
	var name = prefix;
	var input = $('<input type="hidden" class="temp" name="' + name + '" />')
			.val(str);
	input.appendTo(temp2);
	temp.append(temp2);
	form.append(temp);

}
// 解决IE下无样式问题
$(function() {
	$('body').css('visibility', 'visible');
	$('.easyui-panel').panel('resize');
});
// 扩展
function load(id, url, paged) {
	var pageNo = getCookie(id);
	if(pageNo == undefined || pageNo == '' || pageNo==null){
		pageNo = 1
	}
	$("#" + id).datagrid({
		onSortColumn : function(sort, order) {
			var param = {};
			param.sortName=s = sort.replace(/([A-Z])/g,"_$1").toLowerCase();;
			param.orderBy=order;
			refreshGrid(id, parseInt(pageNo), 10, url,param);
		}
	});
	$("#" + id).datagrid("getPager").pagination('refresh');
	if(paged == undefined){
		var opts = $("#" + id).datagrid("getPager").pagination("options");
		var pageSize = opts.pageSize;
		refreshGrid(id, pageNo, pageSize, url);
		$("#" + id).datagrid("getPager").pagination({
			onSelectPage : function(pageNumber, pageSize) {
//				 alert('pageNumber:'+pageNumber+',pageSize:'+pageSize);
				setCookie(id,pageNumber);
				refreshGrid(id, pageNumber, pageSize, url);
			},
			pageNumber:parseInt(pageNo)
		});
		opts.pageNumber = parseInt(pageNo);
	}else{ 
		refreshGrid(id, pageNo, 99999, url);
	}
}

function refreshGrid(id, pageNumber, pageSize, url, param) {
	if (param == undefined) {
		param = {};
	}
	param.pageSize = pageSize;
	param.pageNo = pageNumber;
	console.log(param)
	param = buildParam(id + "_queryForm", param);
	$.post(url, param, function(result) {
		if (result.code == 2000) {
			var data = result.data;
			$("#" + id).datagrid('loadData', {
				total : data.recordsTotal,
				rows : data.data
			});
		}
	})
}

function queryData(id, datagridId, url) {
	var param = {};
	param = buildParam(id, param);
	var opts = $("#" + datagridId).datagrid("getPager").pagination("options");
	var pageSize = opts.pageSize;
	refreshGrid(datagridId, 1, pageSize, url, param)
}

function loadPage(datagridId,id,url) {
	var param = {};
	param = buildParam(id, param);
	var opts = $("#" + datagridId).datagrid("getPager").pagination("options");
	var pageSize = opts.pageSize;
	var pageNo = opts.pageNumber;
	refreshGrid(datagridId, pageNo, pageSize, url, param)
}

function buildParam(id, param) {
	$("#" + id).find("input").each(function() {
		var name = $(this).attr("name");
		if (name != undefined) {
			param[name] = $(this).val();
		}
	})
	$("#" + id).find("select").each(function() {
		var name = $(this).attr("name");
		if (name != undefined) {
			param[name] = $(this).val();
		}
	})
	return param;
}

$.fn.extend({
	openPanel : function(url) {
		var con = '<iframe style="width:100%;height:100%;border:0;" src="'
				+ url + '"></iframe>';
		$(this).html(con);
		$(this).window('open');
	}
});

function ajaxLoading() {  
    var id = "body";
    var left = ($(window).outerWidth(true) - 190) / 2;  
    var top = ($(window).height() - 35) / 2;  
    var height = $(window).height() * 2;  
    $("<div class=\"datagrid-mask\"></div>").css({ display: "block", width: "100%", height: height }).appendTo(id);  
    $("<div class=\"datagrid-mask-msg\"></div>").html("正在加载,请稍候...").appendTo(id).css({ display: "block", left: left, top: top });  
}  
  
function ajaxLoadEnd() {  
    $(".datagrid-mask").remove();  
    $(".datagrid-mask-msg").remove();  
} 

/*
 *取url地址后面的参数，例：getQueryString("id")
 * */
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r != null) return unescape(r[2]); return null; 
}

//写cookies 

function setCookie(name,value) 
{ 
    var Days = 30; 
    var exp = new Date(); 
    exp.setTime(exp.getTime() + Days*24*60*60*1000); 
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString(); 
} 

//读取cookies 
function getCookie(name) 
{ 
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
 
    if(arr=document.cookie.match(reg))
 
        return unescape(arr[2]); 
    else 
        return null; 
} 


function getOssContent(base,content){
	var results = "";
	var imgReg = /<img.*?(?:>|\/>)/gi;
	//匹配src属性
	var srcReg = /src=[\'\"]?([^\'\"]*)[\'\"]?/i;
	var arr = content.match(imgReg);
	var x = 0;
	if (arr!=undefined && arr!=''&&arr!=null) {
		for (var i = 0; i < arr.length; i++) {
			var src = arr[i].match(srcReg);
			//获取图片地址
			if(src[1] ){
				if(src[1].indexOf("ffxl.oss-cn-shanghai.aliyuncs.com") < 0){
					content = content.replace(src[1],"######"+x+"######")
					results = results+"," + src[1].split("?")[0];
					x++;
				}
			}
		}
	}
	
	if(results != ""){
		$.ajax({
			dataType : 'json',
			type : 'POST',
			url : base+"/f_infos/uploadToOss",
			async:false,
			data : {urls:results.replace(",","")},
			success : function(result) {
				if (result.code == "2000") {
					var data = result.data;
					for(var i = 0; i < data.length; i++ ){
						content = content.replace("######"+i+"######",data[i]);
					}
				} else
					alert("操作失败");
			},
		});
	}
	return content;
}