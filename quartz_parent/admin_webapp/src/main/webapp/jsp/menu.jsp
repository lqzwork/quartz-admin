<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<aside class="sidebar-menu fixed">
	<div class="sidebar-inner scrollable-sidebar">
		<div class="main-menu">
			<ul class="accordion">
				<li class="bg-palette1">
					<a href="">
						 <span class="menu-content block">
						  <span class="menu-icon"><i class="block fa fa-tasks fa-lg"></i></span> 
						  	<span class="text m-left-sm">定时任务 </span> 
						</span> 
					</a>
				</li>
			</ul>
		</div>
		<div class="sidebar-fix-bottom clearfix">
			<div class="user-dropdown dropup pull-left">
				<a href="#" class="dropdwon-toggle font-18" data-toggle="dropdown"><i
					class="ion-person-add"></i> </a>
				<ul class="dropdown-menu">
					<li><a href="inbox.html"> 收信箱 <span
							class="badge badge-danger bounceIn animation-delay2 pull-right">1</span>
					</a></li>
					<li><a href="#"> 通知 <span
							class="badge badge-purple bounceIn animation-delay3 pull-right">2</span>
					</a></li>
					<li><a href="#" class="sidebarRight-toggle"> 消息 <span
							class="badge badge-success bounceIn animation-delay4 pull-right">7</span>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">设置</a></li>
				</ul>
			</div>
			<a href="${base}/login_toLockscreen" class="pull-right font-18"><i
				class="ion-log-out"></i></a>
		</div>
	</div>
	<!-- sidebar-inner -->
</aside>
<script type="text/javascript">
</script>