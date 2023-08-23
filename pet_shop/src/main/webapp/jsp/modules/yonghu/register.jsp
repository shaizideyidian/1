<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>注册</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/assets2/js/jquery.min.js"></script>
    <link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css" rel="stylesheet">
<!--  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets2/css/style.css"> -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets2/css/loader-style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets2/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets2/css/signin.css">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
<!-- Fav and touch icons -->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/assets2/ico/minus.png">
	</head>

<style>
	.error{
		color:red;
	}
	
	html, body {
		width: 100%;
		height: 100%;
	}
	
	.content {
				background-repeat: no-repeat;
				background-size: 100% 100%;
				background: url(http://codegen.caihongy.cn/20221201/760046d0cca14ba09053b57a5cd9d3af.jpg);
				display: flex;
				width: 100%;
				min-height: 100vh;
				justify-content: center;
				align-items: center;
				background-position: center center;
			}
	
	#registerForm {
				border-radius: 4px;
				padding: 40px 0px 60px 20px;
				margin: 40px auto 0 auto;
				background-size: auto 100%;
				background: url(http://codegen.caihongy.cn/20221201/39914ca6890e4a7eb7035a0f85f78ca2.png) no-repeat center top;
				display: flex;
				width: 850px;
				min-height: 853px;
				flex-wrap: wrap;
				height: auto;
			}
	
	#registerForm .title {
				margin: 50px 0px 10px 0px;
				color: #fff;
				background: none;
				width: 100%;
				font-size: 20px;
				line-height: 40px;
				text-align: center;
			}
	
	#registerForm .list-item {
				padding: 0;
				margin: 0 auto 8px 220px;
				width: 80%;
				height: auto;
			}
	
	#registerForm .list-item .item-label {
				color: rgba(64, 158, 255, 1);
				width: 64px;
				font-size: 14px;
				line-height: 44px;
			}
	
	#registerForm .list-item>input {
				border-radius: 20px;
				padding: 0 10px;
				box-shadow: 0 0 0px rgba(64, 158, 255, .5);
				outline: none;
				color: #ccc;
				background: none;
				width: 360px;
				font-size: 14px;
				border-color: #d0cddb;
				border-width: 1px;
				border-style: solid;
				height: 36px;
			}
	
	#registerForm .list-item>select {
				padding: 0 10px;
				color: #ccc;
				font-size: 14px;
				border-color: #d0cddb;
				line-height: 36px;
				border-radius: 20px;
				box-shadow: 0 0 0px rgba(64, 158, 255, .5);
				outline: none;
				background: none;
				width: 360px;
				border-width: 1px;
				border-style: solid;
				height: 36px;
			}
	
	#registerForm .list-item .date {
				padding: 0 10px;
				color: #ccc;
				font-size: 14px;
				border-color: #d0cddb;
				line-height: 36px;
				border-radius: 20px;
				box-shadow: 0 0 0px rgba(64, 158, 255, .5);
				outline: none;
				background: none;
				width: 360px;
				border-width: 1px;
				border-style: solid;
				height: 36px;
			}
	
	#registerForm .list-item-img {
				padding: 0;
				margin: 0 auto 8px 220px;
				width: 80%;
				height: auto;
			}
	
	#registerForm .list-item-img .item-label {
				padding: 0 10px 0 0;
				color: #666;
				font-weight: 500;
				width: 84px;
				font-size: 14px;
				line-height: 40px;
				text-align: right;
			}
	
	#registerForm .list-item-img img {
				border-radius: 20px;
				margin: 0 10px 0 0;
				max-width: 120px;
				object-fit: cover;
				display: inline-block;
				width: 120px;
				min-height: 60px;
				height: auto;
			}
	
	#registerForm .list-item-img .btn-img {
				cursor: pointer;
				border-radius: 20px;
				padding: 0 12px;
				color: #333;
				background: #fefeff;
				display: inline-block;
				width: auto;
				font-size: 14px;
				line-height: 36px;
				position: relative;
				text-align: center;
				height: 36px;
			}
	
	#registerForm .list-item-img .btn-img input {
		position: absolute;
		opacity: 0;
		width: 100%;
		height: 100%;
		left: 0;
		top: 0;
	}
	
	#registerForm .list-item.emails .item-body input {
				padding: 0 12px;
				margin: 0 10px 0 0;
				color: #ccc;
				font-size: 14px;
				border-color: #d0cddb;
				border-radius: 20px;
				box-shadow: 0 0 0px rgba(64, 158, 255, .5);
				outline: none;
				background: none;
				width: 250px;
				border-width: 1px;
				border-style: solid;
				height: 36px;
			}
	
	#registerForm .list-item.emails .item-body button {
				border: 0px solid #ddd;
				cursor: pointer;
				border-radius: 20px;
				padding: 0;
				box-shadow: 0 0 0px rgba(64, 158, 255, .5);
				margin: 0;
				outline: none;
				color: #333;
				background: #fefeff;
				width: 100px;
				font-size: 14px;
				height: 36px;
			}
	
	#submitBtn {
				border: 0;
				cursor: pointer;
				padding: 0 10px;
				margin: 12px 220px 4px ;
				color: #fff;
				display: block;
				font-size: 16px;
				border-radius: 20px;
				box-shadow: 0 0 0px rgba(64, 158, 255, .5);
				outline: none;
				background: #17a5ff;
				width: 40%;
				height: 36px;
			}
	
	#loginBtn {
				cursor: pointer;
				padding: 0 10%;
				margin: 8px 0 0 220px;
				color: rgba(159, 159, 159, 1);
				display: inline-block;
				text-decoration: underline;
				font-size: 12px;
				line-height: 1;
			}
</style>

<body>
	
	<div class="content">
			<form id="registerForm" action="" method="post">
				<div class="title">注册</div>
				<div class="list-item">
					<input  name="yonghuming"  placeholder="请输入用户名" class="form-control-i">
				</div>
				<div class="list-item">
					<input type="password"#elsetype="text" name="mima"  placeholder="请输入密码" class="form-control-i">
				</div>
				<div class="list-item">
					<input type="password" name="mima2" placeholder="确认密码" class="form-control-i">
				</div>
				<div class="list-item">
					<input  name="xingming"  placeholder="请输入姓名" class="form-control-i">
				</div>
                <div class="list-item">
                    <select id="xingbieSelect" name="xingbie"  class="form-control">
                            <option value="">请选择性别</option>
                            <option class="xingbieOption" value="男">
                                男
                            </option>
                            <option class="xingbieOption" value="女">
                                女
                            </option>
                    </select>
                </div>
                <div class="list-item-img">
                    <img id="touxiangImg" src="" width="100" height="100">
                    <div class="upload btn-img">请选择头像<input name="file" type="file" id="touxiangupload" class="form-control-file"></div>
                    <input name="touxiang" id="touxiang-input" type="hidden">
                </div>
				<div class="list-item">
					<input  name="shouji"  placeholder="请输入手机" class="form-control-i">
				</div>
                <div class="list-item">
                    <select id="vipSelect" name="vip"  class="form-control">
                            <option value="">请选择是否会员</option>
                            <option class="vipOption" value="是">
                                是
                            </option>
                            <option class="vipOption" value="否">
                                否
                            </option>
                    </select>
                </div>
				<button id="submitBtn" class="btn btn-primary" type="button">注 册</button>
				<a id="loginBtn" href="javascript:window.location.href='../../login.jsp'">已有账号，直接登录</a>
			</form>
	</div>

	<!--  END OF PAPER WRAP -->

	<!-- MAIN EFFECT -->
    <script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets2/js/bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>

	<!--<script src="http://maps.googleapis.com/maps/api/js?sensor=false" type="text/javascript"></script> -->
	<!--<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets2/js/map/gmap3.js"></script> -->
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js"></script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/js/validate/messages_zh.js"></script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/js/validate/card.js"></script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
		<script type="text/javascript">
		
	<%@ include file="../../utils/menu.jsp"%>
	<%@ include file="../../static/utils.js"%>	
	<%@ include file="../../utils/baseUrl.jsp"%>




        // 文件上传
        function upload(){
            $('#touxiangupload').fileupload({
                url: baseUrl + 'file/upload',
                headers:{ token: window.sessionStorage.getItem("token")},
                dataType: 'json',
                done: function (e, data) {
                    document.getElementById('touxiang-input').setAttribute('value',"upload/"+data.result.file);
                    if(document.getElementById('touxiangFileName') != null){
                        document.getElementById('touxiangFileName').innerHTML = "上传成功!";
                    }
                    $("#touxiangImg").attr("src",baseUrl+"upload/"+data.result.file);
                }
            });
        }

		// 表单校验
		function validform() {
			return $("#registerForm").validate({ 
				rules: {
							mima: {
								required: true,
							},
							xingming: {
								required: true,
							},
							xingbie: {
							},
							touxiang: {
							},
							shouji: {
								isPhone: true,
							},
							sfsh: {
							},
							shhf: {
							},
							money: {
								number: true,
							},
							vip: {
							},
				},
				messages: {
							mima: {
								required: "密码不能为空",
							},
							xingming: {
								required: "姓名不能为空",
							},
							xingbie: {
							},
							touxiang: {
							},
							shouji: {
							},
							sfsh: {
							},
							shhf: {
							},
							money: {
								number: "请输入数字",
							},
							vip: {
							},
				}
			}).form();
		}
		// 添加表单校验方法
		function addValidation(){
			jQuery.validator.addMethod("isPhone", function(value, element) {
					var length = value.length;
					var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/;
					return this.optional(element) || (length == 11 && mobile.test(value));
			}, "请填写正确的手机号码");
			jQuery.validator.addMethod("isIdCardNo", function(value, element) {
				return this.optional(element) || value.length == 18;
			}, "请正确输入您的身份证号码");
			jQuery.validator.addMethod("isTel", function(value, element) {
		          var length = value.length;
		          var phone = /(^(\d{3,4}-)?\d{6,8}$)|(^(\d{3,4}-)?\d{6,8}(-\d{1,5})?$)|(\d{11})/;
		          return this.optional(element) || (phone.test(value));
		         }, "请填写正确的固定电话");//可以自定义默认提示信息
		}


        function dateTimePick(){
            $.fn.datetimepicker.dates['zh-CN'] = { 
                    days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
                    daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
                    daysMin:  ["日", "一", "二", "三", "四", "五", "六", "日"],
                    months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
                    monthsShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
                    today: "今天",
                    suffix: [],
                    meridiem: ["上午", "下午"]
            };
        }

        function init() {
        }

		// 表单提交
		function submit() {
			if(validform() ==true){
				let data = {};
				let value = $('#registerForm').serializeArray();
				$.each(value, function (index, item) { 
							data[item.name] = item.value;
						});
                if(data.mima!=data.mima2) {
                    alert("两次密码输入不一致");
                    return;
                }
				let json = JSON.stringify(data);
				//console.log('json : ',json);
				var url = baseUrl + "yonghu/register";
				$.ajax({ 
					type: "POST",
					url: url,
					contentType: "application/json",
					data:json,
					beforeSend: function(xhr) {xhr.setRequestHeader("token", window.sessionStorage.getItem('token'));},
					success: function(res){    
						if(res.code == 0){
						alert("注册成功!");
						window.location.href="${pageContext.request.contextPath}/jsp/login.jsp";
						}else if(res.code == 401){
							<%@ include file="../../static/toLogin.jsp"%> 	
						}else{
							alert(res.msg)
						}
					},
				});      
			}else{
				alert("表单未填完整或有错误");
			}
		}    

		function ready() {
			addValidation();
            init();
            //初始化上传按钮
            upload();
            //初始化时间插件
            dateTimePick();
			//注册表单验证
		    // $(validform());
			$('#submitBtn').on('click', function(e) {
				e.preventDefault();
				//console.log("点击了...提交按钮");
				submit();
			});
		}
		document.addEventListener("DOMContentLoaded", ready);
	</script>

</body>

</html>
