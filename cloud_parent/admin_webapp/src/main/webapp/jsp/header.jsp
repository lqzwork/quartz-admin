<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<header class="top-nav">
	<div class="top-nav-inner">
		<div class="nav-header">
			<button type="button" class="navbar-toggle pull-left sidebar-toggle"
				id="sidebarToggleSM">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

			<ul class="nav-notification pull-right">
				<li><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
						class="fa fa-cog fa-lg"></i></a> <span
					class="badge badge-danger bounceIn">1</span>
					<ul class="dropdown-menu dropdown-sm pull-right user-dropdown">
						<li class="user-avatar"><img
							src="${base}/resources/images/profile/profile1.jpg" alt=""
							class="img-circle">
							<div class="user-content">
								<h5 class="no-m-bottom">Jane Doe</h5>
								<div class="m-top-xs">
									<a href="profile.html" class="m-right-sm">Profile</a> <a
										href="signin.html">Log out</a>
								</div>
							</div></li>
						<li><a href="inbox.html"> Inbox <span
								class="badge badge-danger bounceIn animation-delay2 pull-right">1</span>
						</a></li>
						<li><a href="#"> Notification <span
								class="badge badge-purple bounceIn animation-delay3 pull-right">2</span>
						</a></li>
						<li><a href="#" class="sidebarRight-toggle"> Message <span
								class="badge badge-success bounceIn animation-delay4 pull-right">7</span>
						</a></li>
						<li class="divider"></li>
						<li><a href="#">Setting</a></li>
					</ul></li>
			</ul>
			<a href="${base}/jsp/main/main.jsp" class="brand">
			      <div style="float: left; hight">
                          <i style="padding-top: 10px;display: inline-block;"><img style="width:32px" src="${base }/resources/images/login/logo.png" /></i>
                   </div>
                   <span class="brand-name" id="ffxlName">后台管理系统</span>
			</a>
		</div>
		<div class="nav-container">
			<button type="button" class="navbar-toggle pull-left sidebar-toggle"
				id="sidebarToggleLG">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
            <div class="user-block pull-left hidden-xs">
                    <a href="#" id="userToggle" data-toggle="dropdown">
                        <div class="user-detail inline-block">
                            设置 <i class="fa fa-angle-down"></i>
                        </div>
                    </a>
                    <div class="panel border dropdown-menu user-panel">
                        <div class="panel-body paddingTB-sm">
                            <ul>
                             	<li><a href="${base}/admin/list"> <span class="m-left-xs">用户管理</span></a></li>
                                <li><a href="${base}/menu/list"> <span class="m-left-xs">菜单管理</span></a></li>
                                <li><a href="${base}/privilege"> <span class="m-left-xs">权限设置</span></a></li>
                                <li><a href="${base}/task/list"> <span class="m-left-xs">任务列表</span></a></li>
                            </ul>
                        </div>
                    </div>
                </div>

			<div class="pull-right m-right-sm">
				<div class="user-block hidden-xs">
					<a href="#" id="userToggle" data-toggle="dropdown"> <img
						src="${base}/resources/images/profile/profile1.jpg" alt=""
						class="img-circle inline-block user-profile-pic">
						<div class="user-detail inline-block">
							admin <i class="fa fa-angle-down"></i>
						</div>
					</a>
					<div class="panel border dropdown-menu user-panel">
						<div class="panel-body paddingTB-sm">
							<ul>
								<li><a href="${base }/jsp/main/profile.jsp"> <i class="fa fa-edit fa-lg"></i><span
										class="m-left-xs">个人信息</span>
								</a></li>
								<li><a href="${base }/jsp/main/main.jsp"> <i class="fa fa-exchange fa-lg"></i><span
                                        class="m-left-xs">系统切换</span>
                                </a></li>
								<li><a href="${base}/login_logout"> <i
										class="fa fa-power-off fa-lg"></i><span class="m-left-xs">注销</span>
								</a></li>
							</ul>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
	<!-- ./top-nav-inner -->
</header>
<script>

</script>