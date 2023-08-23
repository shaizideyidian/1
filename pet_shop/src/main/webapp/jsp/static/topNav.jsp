<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<style>
		#top-container {
						padding: 0 20px 0 0;
						z-index: 1001;
						display: flex;
						border-color: #ccc;
						border-radius: 0;
						box-shadow: 0 0px 0px rgba(0, 0, 0, .1);
						top: 0;
						left: 0;
						background: url() no-repeat center top,rgba(255,255,255,.3);
						width: 100%;
						justify-content: space-between;
						border-width: 0 0 4px;
						position: fixed;
						border-style: solid;
						height: 64px;
					}
		
		#top-container .top-logo {
						color: #fff;
						background: url(http://codegen.caihongy.cn/20221125/927123c4a8b641a696bfbd8cede1c50a.gif);
						width: 210px;
						font-size: 16px;
						height: 64px;
					}
		
		#top-container .top-title {
						padding: 0 20px;
						margin: 0 0 0 20%;
						color: #fff;
						left: 0;
						background: none;
						width: 1200px;
						font-size: 20px;
						line-height: 54px;
						position: absolute;
						text-align: center;
					}
		
		#top-container .top-nav {
						margin: 0 10% 0 0;
						display: flex;
						line-height: 64px;
						align-items: center;
						position: absolute;
						right: 0;
						list-style: none;
						height: 100%;
						order: 2;
					}
		
		#top-container .top-nav .nav-item-full {
						padding: 0px 0;
						margin: 0px 0 0;
						position: relative;
						height: 100%;
						order: 2;
					}
		
		#top-container .top-nav .nav-item-full a {
						cursor: pointer;
						padding: 0;
						text-decoration: none;
						display: block;
					}
		
		#top-container .top-nav .nav-item-full a span {
						border: 3px solid #fff;
						border-radius: 30px;
						padding: 10px;
						margin: 0 10px 0 0;
						color: #fff;
						background: rgba(255,255,255,.1);
						font-size: 16px;
					}
		
		#top-container .top-nav .nav-item {
						padding: 0px 0;
						margin: 0px 12px 0;
						position: relative;
						height: 100%;
					}
		
		#top-container .top-nav .nav-item>a {
						cursor: pointer;
						padding: 0;
						text-decoration: none;
						display: block;
					}
		
		#top-container .top-nav .nav-item>a span {
						border: 3px solid #fff;
						border-radius: 30px;
						padding: 10px;
						margin: 0;
						color: #fff;
						background: rgba(255,255,255,.1);
						font-size: 16px;
					}
		
		#top-container .top-nav .nav-item .dropdown-menu {
						border-radius: 4px;
						box-shadow: 0 1px 6px rgba(0, 0, 0, .3);
						top: 100%;
						left: inherit;
						background: #fff;
						width: 150px;
						margin-top: 9px;
						position: absolute;
						right: 0;
						min-width: auto;
						height: auto;
					}
		
		#top-container .top-nav .nav-item .dropdown-menu h5 {
						padding: 0 12px;
						color: #fff;
						background: #000;
						width: 100%;
						font-size: 16px;
						line-height: 44px;
					}
		
		#top-container .top-nav .nav-item .dropdown-menu a {
						padding: 0 12px;
						color: #333;
						background: #fff;
						display: block;
						width: 100%;
						font-size: 14px;
						height: auto;
					}
		
		#top-container .top-nav .nav-item .dropdown-menu a:hover {
						padding: 0 10px;
						color: #fff;
						background: red;
						display: block;
						width: 100%;
						font-size: 14px;
						height: auto;
					}
		
		#top-container .top-nav .nav-item .dropdown-menu a .icon {
						border-radius: 100%;
						padding: 2px;
						margin: 0 10px 0 0;
						color: inherit;
						font-size: inherit;
						line-height: 44px;
					}
		
		#top-container .top-nav .nav-item .dropdown-menu a .text {
						color: inherit;
						font-size: inherit;
						line-height: 44px;
					}
		
		#top-container .nav-item .dropdown-toggle::after {
			content: none;
		}
	</style>
	<div id="top-container">
		<a class="top-title" href="${pageContext.request.contextPath}/index.jsp">基于SSM框架的宠物商城系统</a>
		<ul class="top-nav">
			<li class="nav-item-full">
				<a class="nav-link">
					<span class="ti-fullscreen fullscreen"></span>
				</a>							
			</li>
			<li class="nav-item">
				<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
					<span class="ti-user"></span>
				</a>
				<div class="dropdown-menu lochana-box-shadow2 profile animated flipInY">
					<h5></h5>
					<a class="dropdown-item web" href="#" id='toFront' onclick="toFront()">
						<span class="icon ti-desktop"></span>
						<span class="text">跳到前台</span>
					</a>
					<a class="dropdown-item exit" href="#" onclick="logout()">
						<span class="icon ti-power-off"></span>
						<span class="text">退出</span>
					</a>
				</div>
			</li>
		</ul>
	</div>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script>
    $(document).ready(function() {
        if(window.sessionStorage.getItem('role')=='管理员') {
            $('#toFront').hide();
        }
        if(window.sessionStorage.getItem('role')!='管理员') {
            $('#backUp').hide();
        }
    });
</script>
