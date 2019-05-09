<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>定时任务管理</title>
<%@include file="/jsp/common/tag.jsp"%>
<%@include file="/jsp/common/css.jsp"%>
<style>
.btnstyle {
	padding: 0px 5px;
	border-radius: 5px;
	border: 1px solid #565656;
	color: #565656;
}
</style>
</head>
<body>
	<div class="wrapper preload">
		<%@include file="/jsp/header.jsp"%>
		<%@include file="/jsp/menu.jsp"%>
		<div id="main" class="main-container padding-md bootstrap-easy-ui">
			<div class="smart-widget">
				<div class="smart-widget-header">
					定时任务管理 <span class="smart-widget-option"> <span
						class="refresh-icon-animated"> <i
							class="fa fa-circle-o-notch fa-spin"></i>
					</span> <a href="#" class="widget-toggle-hidden-option"> <i
							class="fa fa-cog"></i>
					</a> <a href="#" class="widget-collapse-option" data-toggle="collapse">
							<i class="fa fa-chevron-up"></i>
					</a> <a href="#" class="widget-refresh-option"> <i
							class="fa fa-refresh"></i>
					</a> <a href="#" class="widget-remove-option"> <i
							class="fa fa-times"></i>
					</a>
					</span>
				</div>
				<div class="smart-widget-inner">
					<div class="smart-widget-hidden-section">
						<ul class="widget-color-list clearfix">
							<li style="background-color: #20232b;" data-color="widget-dark"></li>
							<li style="background-color: #4c5f70;"
								data-color="widget-dark-blue"></li>
							<li style="background-color: #23b7e5;" data-color="widget-blue"></li>
							<li style="background-color: #2baab1;" data-color="widget-green"></li>
							<li style="background-color: #edbc6c;" data-color="widget-yellow"></li>
							<li style="background-color: #fbc852;" data-color="widget-orange"></li>
							<li style="background-color: #e36159;" data-color="widget-red"></li>
							<li style="background-color: #7266ba;" data-color="widget-purple"></li>
							<li style="background-color: #f5f5f5;"
								data-color="widget-light-grey"></li>
							<li style="background-color: #fff;" data-color="reset"></li>
						</ul>
					</div>
					<div class="smart-widget-body">
						<fieldset class="default">
							<legend>查询栏</legend>
							<div id="taskList_queryForm" class="form-inline no-margin">
								<div class="btn-group">
									<label class="control-label">&nbsp;&nbsp;&nbsp;任务名称：</label>
									<div class="input-group">
									<input type="text"
												name="name" id="name" class="form-control" />
									</div>
								</div> 
								<div class="btn-group">
									<label class="control-label">&nbsp;&nbsp;&nbsp;任务状态：</label> 
										<select class="form-control" id="cycle" name="jobStatus">
										<option value=''>全部</option>
		                                   <option value='1'>已发布</option>
		                                   <option value='0'>未发布</option>
									</select>
								</div> 	
								<div class="paddingTB-sm btn-group pull-right">
												<a href="#" class="btn btn-sm btn-success" onclick="queryData('taskList_queryForm','taskList','${base}/task/task_list')"><font>查询</font></a>
								</div>   
							</div>
						</fieldset>
						<div id="datagrid-toolbar">
							<a href="#" id="createButton" class="easyui-linkbutton"
								onclick="add()" iconCls="icon-add" plain="true">新增</a>
								<a href="#" id="createButton" class="easyui-linkbutton"
								onclick="publish()" iconCls="icon-redo" plain="true">发布</a>
								<a href="#" id="createButton" class="easyui-linkbutton"
								onclick="nopublish()" iconCls="icon-remove" plain="true">取消发布</a>
								
							<a href="#" id="createButton" class="easyui-linkbutton"
								onclick="del()" iconCls="icon-remove" plain="true">删除</a>
						</div>
						<table id="taskList" class="easyui-datagrid" fitcolumns="true"
							data-options="pagination:true,rownumbers:true,singleSelect:false,sortName:'mdseName',pageSize:20,
									sortOrder:'desc',toolbar:'#datagrid-toolbar'">
							<thead>
								<tr>
								   <th data-options="field:'ck',checkbox:true"></th>
									<th data-options="field:'name',width:80">任务名</th>
									<th field="groupName" width="50">任务组</th>
									<th field="cron" width="60">cron表达式</th>
									<th field="jobStatus" width="40" data-options="formatter:formatJobStatus">任务状态</th>
									<th field="planStatus" width="40" data-options="formatter:formatPlan">计划状态</th>
									<th field="methodName" width="40"  >执行方法</th>
									<th field="beanName" width="150" >bean实例</th>
									<th field="opt" width="150" data-options="formatter:formatOpt">操作</th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/jsp/common/js.jsp"%>
	<script type="text/javascript">
		$(function() {
			load("taskList", "${base}/task/task_list");
		})

		function add() {
			location.href = "${base}/task/task_detail";
		}
		
		function formatJobStatus(value, rowData, rowIndex){
			if(value=='1'){
				return "<span class='text-success'>已发布</span>"
			}else{
				return "<span class='text-danger'>未发布</span>"
			}
		}
		function formatPlan(value, rowData, rowIndex){
			if(value=="None"){
				return "<span class='text-danger'>None</span>"
			}
			if(value=="NORMAL"){
				return "<span class='text-success'>正常运行</span>"
			}
			if(value=="PAUSED"){
				return "<span class='text-yellow'>已暂停</span>"
			}
			if(value=="COMPLETE"){
				return "<span class='text-success'>任务执行中</span>"
			}
			if(value=="BLOCKED"){
				return "<span class='text-danger'>线程阻塞</span>"
			}
			if(value=="ERROR"){
				return "<span class='text-danger'>错误</span>"
			}else{
				return "<span class='text-danger'>未计划</span>"
			}	
				}
		function formatConcurrent(value, rowData, rowIndex){
			if(value){
				return "<span class='text-success'>运行中</span>"
			}else{
				return "<span class='text-danger'>未运行</span>"
			}
		}
		function formatOpt(value, rowData, rowIndex) {
			var msg = "";
			msg+="<a href='#' class='btnstyle'  onclick='showDetail(\""
			    + rowData.id + "\")'>编辑</a>";
			//已发布，
			if(rowData.jobStatus=='1'){
				var value = rowData.planStatus;
				if(value=="None"|| value==null){
					msg +='<a  href="#"class="btnstyle"  onclick="addJob(\''+rowData.id+'\')" '
						+'onMouseOver="popTip(this,\' '+rowData+' \' )" class="btn btn-info btn-xs" data-toggle="tooltip"'
						+' data-placement="top" title="定时任务按照计划开始执行" >计划</a>';
				}
				if(value=="NORMAL"){
					msg +=	'<a  href="#"class="btnstyle"  onclick="runJob(\''+rowData.id+'\')" '
					+'onMouseOver="popTip(this,\' '+rowData+' \' )" class="btn btn-info btn-xs" data-toggle="tooltip"'
					+' data-placement="top" title="紧执行一次" >立即执行</a>'
					+	'<a  href="#"class="btnstyle"  onclick="stopJob(\''+rowData.id+'\')" '
					+'onMouseOver="popTip(this,\' '+rowData+' \' )" class="btn btn-info btn-xs" data-toggle="tooltip"'
					+' data-placement="top" title="定时任务暂时停止执行" >暂停</a>'
					+'<a  href="#"class="btnstyle"  onclick="removeJob(\''+rowData.id+'\')" '
					+'onMouseOver="popTip(this,\' '+rowData+' \' )" class="btn btn-info btn-xs" data-toggle="tooltip"'
					+' data-placement="top" title="定时任务从计划列表中移除" >移除</a>';
				}
				if(value=="PAUSED"){
					msg +=	'<a  href="#"class="btnstyle"  onclick="runJob(\''+rowData.id+'\')" '
					+'onMouseOver="popTip(this,\' '+rowData+' \' )" class="btn btn-info btn-xs" data-toggle="tooltip"'
					+' data-placement="top" title="紧执行一次" >立即执行</a>'
					
						 +	'<a  href="#"class="btnstyle"  onclick="addJob(\''+rowData.id+'\')" '
						+'onMouseOver="popTip(this,\' '+rowData+' \' )" class="btn btn-info btn-xs" data-toggle="tooltip"'
						+' data-placement="top" title="定时任务按照计划开始执行" >计划</a>'
						+'<a  href="#"class="btnstyle"  onclick="removeJob(\''+rowData.id+'\')" '
						+'onMouseOver="popTip(this,\' '+rowData+' \' )" class="btn btn-info btn-xs" data-toggle="tooltip"'
						+' data-placement="top" title="定时任务从计划列表中移除" >移除</a>';
				}
				if(value=="COMPLETE"){
					msg +=	'<a  href="#"class="btnstyle"  onclick="runJob(\''+rowData.id+'\')" '
					+'onMouseOver="popTip(this,\' '+rowData+' \' )" class="btn btn-info btn-xs" data-toggle="tooltip"'
					+' data-placement="top" title="紧执行一次" >立即执行</a>'
				}
				if(value=="BLOCKED"){
					msg +=	'<a  href="#"class="btnstyle"  onclick="runJob(\''+rowData.id+'\')" '
					+'onMouseOver="popTip(this,\' '+rowData+' \' )" class="btn btn-info btn-xs" data-toggle="tooltip"'
					+' data-placement="top" title="紧执行一次" >立即执行</a>'
				}
				if(value=="ERROR"){
					
				}
			}
			return  msg;
		}

		

		function showDetail(id) {
			location.href = "${base}/task/task_detail?id=" + id;
		}

		function formatDate(value, rowData, rowIndex) {
			return new Date(value).Format("yyyy-MM-dd hh:mm:ss");
		}
		//立即执行
		function runJob(id) {
			$.messager.confirm('确认', 'job立即执行一次，执行结束后不会再执行，仅用于测试定时任务的业务逻辑是否正确？', function(r) {
				if (r) {
					$.post("${base}/task/run_task2job", {
						"id" : id
					}, function(data) {
						if(data.code =='5000'){
							alert(data.message);
							return;
						}
						load("taskList", "${base}/task/task_list");
					})
				}
			});
		}

		//计划
		function addJob(id) {
			$.messager.confirm('确认', 'job添加后会定时执行，是否确认把job添加到计划中？', function(r) {
				if (r) {
					$.post("${base}/task/add_task2job", {
						"id" : id
					}, function(data) {
						if(data.code =='5000'){
							alert(data.message);
							return;
						}
						load("taskList", "${base}/task/task_list");
					})
				}
			});
		}
		//暂停
		function stopJob(id) {
			$.messager.confirm('确认', 'job暂停后会定时任务不再执行，可能会影响到业务状态的变更，是否确认暂停？', function(r) {
				if (r) {
					$.post("${base}/task/stop_task2job", {
						"id" : id
					}, function(data) {
						load("taskList", "${base}/task/task_list");
					})
				}
			});
		}
		//移除
		function removeJob(id) {
			$.messager.confirm('确认', '移除job会导致定时任务永久不再执行，是否确认移除？', function(r) {
				if (r) {
					$.post("${base}/task/remove_task2job", {
						"id" : id
					}, function(data) {
						if(data.code =='5000'){
							alert(data.message);
							return;
						}
						load("taskList", "${base}/task/task_list");
					})
				}
			});
		}
		
		function publish() {
			$.messager.confirm('确认', '确定要执行此操作吗？', function(r) {
				if (r) {
					var ids = [];
					var rows = $('#taskList').datagrid('getSelections');
					if (rows.length == 0) {
						$.messager.alert('提示', '必须选中一条数据！', 'info');
						return false;
					}
					for (var i = 0; i < rows.length; i++) {
						if (rows[i].jobStatus != "0" ) {
							$.messager.alert('提示', '已发布的任务不可重复发布', 'info');
							return false;
						}
						ids.push(rows[i].id);
					}
					
					for (var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
					var idstr = ids.join(",");
					$.post("${base}/task/update_task", {
						"ids" : idstr,
						"type": 'publish'
					}, function(data) {
						load("taskList", "${base}/task/task_list");
					})
				}
			});
		}
		
		function nopublish() {
			$.messager.confirm('确认', '确定要执行此操作吗？', function(r) {
				if (r) {
					var ids = [];
					var rows = $('#taskList').datagrid('getSelections');
					if (rows.length == 0) {
						$.messager.alert('提示', '必须选中一条数据！', 'info');
						return false;
					}
					for (var i = 0; i < rows.length; i++) {
						if (rows[i].planStatus != null) {
							$.messager.alert('提示', '只有未计划的任务可取消发布！，请先将任务移除计划', 'info');
							return false;
						}
						ids.push(rows[i].id);
					}
					
					for (var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
					var idstr = ids.join(",");
					$.post("${base}/task/update_task", {
						"ids" : idstr,
						"type": 'remove'
					}, function(data) {
						load("taskList", "${base}/task/task_list");
					})
				}
			});
		}

		function del() {
			$.messager.confirm('确认', '确定要执行此操作吗？', function(r) {
				if (r) {
					var ids = [];
					var rows = $('#taskList').datagrid('getSelections');
					if (rows.length == 0) {
						$.messager.alert('提示', '必须选中一条数据！', 'info');
						return false;
					}
					for (var i = 0; i < rows.length; i++) {
						if (rows[i].jobStatus!='0') {
							$.messager.alert('提示', '已发布的任务不可删除，请先将任务取消发布！', 'info');
							return false;
						}
						ids.push(rows[i].id);
					}
					
					for (var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
					var idstr = ids.join(",");
					$.post("${base}/task/delete_task", {
						"ids" : idstr
					}, function(data) {
						load("taskList", "${base}/task/task_list");
					})
				}
			});
		}
	</script>
</body>
</html>