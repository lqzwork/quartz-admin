<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>定时任务详情</title>
<%@include file="/jsp/common/tag.jsp"%>
<%@include file="/jsp/common/css.jsp"%>
</head>
<body id="body" class="overflow-hidden">
	<div class="wrapper preload">
		<%@include file="/jsp/header.jsp"%>
		<%@include file="/jsp/menu.jsp"%>
		<div id="main" class="main-container">
			<div class="padding-md bootstrap-easy-ui">
				<form class="form-horizontal no-margin" id="inputForm"
					modelAttribute="STimetask" method="post" action="${base}/task/task_save">
					<div class="smart-widget">
						<div class="smart-widget-header">定时任务详情  
						<span class="smart-widget-option"> <span
								class="refresh-icon-animated"> <i
									class="fa fa-circle-o-notch fa-spin"></i>
							</span> <a href="#" class="widget-toggle-hidden-option"> <i
									class="fa fa-cog"></i>
							</a> <a href="javascript:void(0)" class="widget-collapse-option"
								data-toggle="collapse"> <i class="fa fa-chevron-up"></i>
							</a> <a href="javascript:void(0)" class="widget-refresh-option">
									<i class="fa fa-refresh"></i>
							</a> <a href="javascript:void(0)" class="widget-remove-option"> <i
									class="fa fa-times"></i>
							</a>
							</span>
						</div>
						<div class="smart-widget-inner">
							<div class="smart-widget-hidden-section">
								<ul class="widget-color-list clearfix">
									<li style="background-color: #40232b;" data-color="widget-dark"></li>
									<li style="background-color: #4c5f70;"
										data-color="widget-dark-blue"></li>
									<li style="background-color: #23b7e5;" data-color="widget-blue"></li>
									<li style="background-color: #2baab1;"
										data-color="widget-green"></li>
									<li style="background-color: #edbc6c;"
										data-color="widget-yellow"></li>
									<li style="background-color: #fbc852;"
										data-color="widget-orange"></li>
									<li style="background-color: #e36159;" data-color="widget-red"></li>
									<li style="background-color: #7266ba;"
										data-color="widget-purple"></li>
									<li style="background-color: #f5f5f5;"
										data-color="widget-light-grey"></li>
									<li style="background-color: #fff;" data-color="reset"></li>
								</ul>
							</div>
							<div class="smart-widget-body">
								<input type="hidden" id="id" name="id" value="${model.id}">
								<div class="form-group">
									<label class="control-label col-lg-1">任务组</label>
									<div class="col-lg-3">
										<input type="text"  value="${model.groupName}" id="groupName" name="groupName"
											class="form-control input-sm">
									</div>
								</div>
								<div class="form-group">
									<!-- /.col -->
									<label class="control-label col-lg-1">任务名称</label>
									<div class="col-lg-3">
										<input type="text" name="name" id="name"
											value="${model.name}" class="form-control input-sm">
									</div>
									<!-- /.col -->
								</div>
                                <!-- /form-group -->
                                <div class="form-group">
                                    <label class="control-label col-lg-1">任务所在服务器IP</label>
                                    <div class="col-lg-3">
                                        <input type="text"  name="runningIp"
                                               value="${model.runningIp}" class="form-control input-sm">
                                    </div>
                                    <!-- /.col -->
                                </div>
								<div class="form-group">
									<!-- /.col -->
									<label class="control-label col-lg-1">任务描述</label>
									<div class="col-lg-10">
			                                  	<textarea rows="3"  name="description" id="description" class="form-control input-sm">${model.description}</textarea>
			                         </div>
									<!-- /.col -->
								</div>
								<div class="form-group">
									<!-- /.col -->
									
									
									<label class="control-label col-lg-1">规则</label>
									<!-- 
									<div class="col-lg-3">
									<div class=input-group>
										<input type="text" disabled="disabled"
											value="${model.cron}" class="form-control ">
											<span class="input-group-btn"><a href="#cronModal" class="btn btn-danger" data-toggle="modal">规则</a></span>
											
									</div>
									</div>
									 -->
									<div class="col-lg-3">
									<div class=input-group>
										<input type="text" disabled="disabled" name="cron" id="cron" 
											value="${model.cron}" class="form-control ">
											<span class="input-group-btn"><button  onclick="showCron()" type="button" class="btn btn-danger">规则</button></span>
											
									</div>
									</div>
									<!-- /.col -->
								</div>
								
								<div class="form-group">
									<!-- /.col -->
									<label class="control-label col-lg-1">任务状态</label>
									<div class="col-lg-3">
										<c:if test="${model.jobStatus == '1'}">
											<input type="text" disabled="disabled" value="已发布" 
											 class="form-control input-sm">
										</c:if>
										<c:if test="${model.jobStatus == '0'}">
											<input type="text" disabled="disabled" value="未发布"
											 class="form-control input-sm">
										</c:if>
									</div>
								</div>
								<div class="form-group">
									<!-- /.col -->
									<label class="control-label col-lg-1">Bean实例</label>
									<div class="col-lg-3">
										<input type="text"   name="beanName"
											value="${model.beanName}" class="form-control input-sm">
									</div>
									<!-- /.col -->
								</div>
								
								<div class="form-group">
									<!-- /.col -->
									<label class="control-label col-lg-1">方法名</label>
									<div class="col-lg-3">
										<input type="text"  name="methodName"
											value="${model.methodName}" class="form-control input-sm">
									</div>
									<!-- /.col -->
								</div>
								<!-- /form-group -->
								<div class="form-group">
								    <label class="control-label col-lg-1">开始执行时间</label>
                                    <div class="col-lg-3">
                                            <input type="text" id="startTimeId" name="startTime"
                                                value='<fmt:formatDate value="${model.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>'
                                                class="form-control input-sm" >
                                        </div>
                                    <!-- /.col -->
								</div>
								<!-- /form-group -->
								<div class="form-group">
								    <label class="control-label col-lg-1">结束执行时间</label>
                                    <div class="col-lg-3">
                                            <input type="text" id="endTimeId" name="endTime"
                                                value='<fmt:formatDate value="${model.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>'
                                                class="form-control input-sm">
                                        </div>
                                    <!-- /.col -->
								</div>

								<!-- /form-group -->
								 <div class="text-right m-top-md">
			                                   	   <input type="button" onclick="backoneHome()" id="" class="btn btn-default" value="返回">
			                                       <input type="submit" id="submit-btn" class="btn btn-info" value="保存">
			                                   </div>
							</div>
						</div>
						<!-- ./smart-widget-inner -->
					</div>
					<!-- ./smart-widget -->
				</form>
			</div>
			<!-- ./padding-md -->
		</div>
		<!-- /main-container -->
	</div>
	<div id="win"></div>
</body>
<%@include file="/jsp/common/js.jsp"%>
<script type="text/javascript">
function backoneHome() {
	window.location='${base}/task/list?pageNo=${homepNo}'
}
function showCron(){
	//$('#cronModal').show();
	/***/
	$.messager.confirm('确认', '修改cron表达式会导致计划取消，是否正确？', function(r) {
				if (r) {
					$('#win').window({
						title:"规则",
					    width:900,
					    height:650,
					    modal:true,
					    onBeforeClose : function() {

						}
					});
					$('#win').openPanel("${base}/jsp/system/cron.jsp");
				}
	});
}

	var cron = "${model.cron}";
	
	function setCron(wincron) {
		var v = $("#cron").val();
		if(v !=null && v !=wincron){
			var taskId =  $("#id").val();
			removeJob(taskId);
		}
		//alert("回调成功："+cron);
		$("#cron").val(wincron);
		cron = wincron;
	}
	
	function removeJob(id) {
				$.post("${base}/task/remove_task2job", {
					"id" : id
				}, function(data) {
					if(data.code =='2000'){
						alert("定时任务计划取消")
					}
					if(data.code =='5000'){
						alert("定时任务计划未执行，无须取消")
					}
				})
	}

    $(function() {
		//对表单进行验证
		var id = $("#id").val();
		var groupName="${model.groupName}";
		var name="${model.name}";
		var gn = groupName+"."+name;
		$("#inputForm").validate({
			debug : false, //调试模式取消submit的默认提交功能
			errorClass : "error",//默认为错误的样式类为：error
			validClass : "check",//验证成功后的样式，默认字符串valid
			focusInvalid : true,//表单提交时,焦点会指向第一个没有通过验证的域
			//为表单中的某些元素添加验证规则
			rules : {
				"groupName" : {
					required : true,
					maxlength : 50
				},
				"name" : {
					required : true,
					maxlength : 50,
					//设置远程校验方法
					remote : {
						url : "${base}/task/check_name", //设置后台处理程序
						type : "post", //数据发送方式
						dataType : "json", //接受数据格式   
						data : { //要传递的数据
							"id" : id,
							"groupName" : function() {
								if (gn != ($("#groupName").val()+"."+$("#name").val()))
									return $("#groupName").val();
								else
									return groupName;
							},
							"name" : function() {
								if (gn != ($("#groupName").val()+"."+$("#name").val()))
									return $("#name").val();
								else
									return name;
							}
						}
					},
				},
				"cron" : {
					required : true,
					maxlength : 50,
				},
				"beanName" : {
					required : true,
					maxlength : 100
				},
				"methodName" : {
					required : true,
					maxlength : 50
				}
			},
			//设置校验提示信息
			messages : {
				"groupName" : {
					required : "此处不能为空",
					maxlength : "此处长度不能大于50"
				},
				"name" : {
					required : "此处不能为空",
					maxlength : "此处长度不能大于50",
					remote : "分组下的任务名已经存在，请修改"
				},
				"cron" : {
					required : "此处不能为空",
					maxlength : "此处长度不能大于50"
				},
				"beanName" : {
					required : "此处不能为空",
					maxlength : "此处长度不能大于100"
				},
				"methodName" : {
					required : "此处不能为空",
					maxlength : "此处长度不能大于50"
				}
			},
			//设置默认的提交处理方式
			submitHandler : function(form) {
				var options = {
					dataType : 'json',
					type : 'POST',
					data : $.extend( $("#inputForm").serialize(), {"cron":cron} ),
					beforeSubmit : function() {
						var flag = $('#inputForm').valid();
						return flag;
					},
					success : function(result) {
						if (result.code == "2000") {
							$("#id").val(result.data.id);
							alert("保存成功");
							//window.location.reload();
						} else
							alert(result.message);
					},
					error : function(msg) {
						bootbox.alert('通信失败');
					},
				};
				//alert("回调成功---："+$("#cron").val());
				
                $("#inputForm").ajaxSubmit(options);
				
			}
		});
	})
</script>
</html>