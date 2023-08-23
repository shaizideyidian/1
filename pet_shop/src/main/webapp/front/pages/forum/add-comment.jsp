<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>
<!-- 论坛中心 -->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>养宠心得</title>
		<link rel="stylesheet" href="../../layui/css/layui.css">
		<!-- 样式 -->
		<link rel="stylesheet" href="../../css/style.css" />
		<!-- 主题（主要颜色设置） -->
		<link rel="stylesheet" href="../../css/theme.css" />
		<!-- 通用的css -->
		<link rel="stylesheet" href="../../css/common.css" />
	</head>
	<style>
		html, body, #app, .layui-form {
			height: 100%;
		}
		.layui-form {
			height: 100%;
			    margin: 0 !important;
			    box-sizing: border-box;
		}
	</style>
	<body>

		<div id="app">
			<form class="layui-form message-form" :style='{"padding":"20px","boxShadow":"none","margin":"0 0 20px 0","borderColor":"rgba(0, 0, 0, 0.3)","backgroundColor":"#fff","borderRadius":"0","borderWidth":"0 0 2px 0","borderStyle":"dashed"}'>
				<div class="layui-form-item layui-form-text" style="display: flex;align-items: center;margin:0">
					<label style="width: auto;" :style='{"padding":"0","minWidth":"54px","fontSize":"14px","color":"#333","textAlign":"center"}' class="layui-form-label">评论</label>
					<div class="layui-input-block" style="margin:0;flex:1;">
						<textarea :style='{"padding":"10px","boxShadow":"0 0 6px rgba(0,0,0,0.3)","borderColor":"rgba(0,0,0,.3)","backgroundColor":"#fff","color":"#333","borderRadius":"4px","borderWidth":"0","fontSize":"14px","borderStyle":"solid","height":"120px"}' name="content" required lay-verify="required" placeholder="请输入评论" class="layui-textarea"></textarea>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button :style='{"padding":"0 10px","boxShadow":"0 0 6px rgba(0,0,0,0.3)","margin":"10px 5px 0","borderColor":"rgba(0,0,0,.3)","backgroundColor":"rgba(15, 141, 80, 1)","color":"#fff","borderRadius":"4px","borderWidth":"0","width":"auto","lineHeight":"34px","fontSize":"14px","borderStyle":"solid"}' class="layui-btn btn-submit" lay-submit lay-filter="*">评论</button>
						<button :style='{"padding":"0 10px","boxShadow":"0 0 6px rgba(110,22,64,.3)","margin":"10px 5px 0","borderColor":"rgba(0,0,0,.3)","backgroundColor":"#fff","color":"rgba(110,22,64,1)","borderRadius":"4px","borderWidth":"0","width":"auto","lineHeight":"34px","fontSize":"14px","borderStyle":"solid"}' type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>

			<!-- layui -->
			<script src="../../layui/layui.js"></script>
			<!-- vue -->
			<script src="../../js/vue.js"></script>
			<!-- 组件配置信息 -->
			<script src="../../js/config.js"></script>
			<!-- 扩展插件配置信息 -->
			<script src="../../modules/config.js"></script>
			<!-- 工具方法 -->
			<script src="../../js/utils.js"></script>

			<script>
				var vue = new Vue({
					el: '#app',
					data: {},
					methods: {
						jump(url) {
							jump(url)
						}
					}
				})

				layui.use(['layer', 'element', 'http', 'jquery', 'form'], function() {
					var layer = layui.layer;
					var element = layui.element;
					var http = layui.http;
					var form = layui.form;
					var jquery = layui.jquery;
					var pid = http.getParam('pid');
					form.on('submit(*)', function(data) {
						// 获取富文本的内容
						data = data.field;
						data.username = localStorage.getItem('adminName');
						data.userid = localStorage.getItem('userid');
						data.parentid = pid;
						http.requestJson('forum/add', 'post', data, function(res) {
							layer.msg('发表成功', {
								time: 2000,
								icon: 6
							}, function() {
								window.parent.location.reload();
							});
						});
						return false;
					});

				});
			</script>
	</body>
</html>
