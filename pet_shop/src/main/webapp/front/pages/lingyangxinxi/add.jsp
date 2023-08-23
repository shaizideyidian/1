<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>注册</title>
		<!-- bootstrap样式，地图插件使用 -->
		<link rel="stylesheet" href="../../css/bootstrap.min.css" />
		<link rel="stylesheet" href="../../layui/css/layui.css">
		<!-- 样式 -->
		<link rel="stylesheet" href="../../css/style.css" />
		<!-- 主题（主要颜色设置） -->
		<link rel="stylesheet" href="../../css/theme.css" />
		<!-- 通用的css -->
		<link rel="stylesheet" href="../../css/common.css" />
	</head>
	<style>
		html::after {
			position: fixed;
			top: 0;
			right: 0;
			left: 0;
			bottom: 0;
			content: '';
			display: block;
			background-attachment: fixed;
			background-size: cover;
			background-position: center;
			z-index: -1;
		}
		#swiper {
			overflow: hidden;
			margin: 0 auto;
		}
		#swiper .layui-carousel-ind li {
			width: 16px;
			height: 10px;
			border-width: 0;
			border-style: solid;
			border-color: rgba(0,0,0,.3);
			border-radius: 10px;
			background-color: #f7f7f7;
			box-shadow: 0 0 6px rgba(110,22,64,.8);
		}
		#swiper .layui-carousel-ind li.layui-this {
			width: 24px;
			height: 10px;
			border-width: 0;
			border-style: solid;
			border-color: rgba(0,0,0,.3);
			border-radius: 10px;
			background-color: rgba(244, 208, 208, 0.67);
			box-shadow: 0 0 6px rgba(110,22,64,.8);
		}
		
		button, button:focus {
			outline: none;
		}
		
		.data-add-container .add .layui-select-title .layui-unselect {
			padding: 0 12px;
			height: 40px;
			font-size: 14px;
			color: #333;
			border-radius: 4px;
			border-width: 1px;
			border-style: solid;
			border-color: #DCDFE6;
			background-color: rgba(255, 255, 255, 0.5);
			box-shadow: 0 0 6px rgba(0,0,0,0.3);
			text-align: left;
		}
		.data-add-container .add .layui-form-item {
			display: flex;
			align-items: center;
			justify-content: center;
		}
		.data-add-container .layui-form-pane .layui-form-item[pane] .layui-form-label {
			margin: 0;
			position: inherit;
			background: transparent;
			border: 0;
		}
		.data-add-container .add .layui-input-block {
			margin: 0;
			flex: 1;
		}
		.data-add-container .layui-form-pane .layui-form-item[pane] .layui-input-inline {
			margin: 0;
			flex: 1;
			display: flex;
		}
	</style>
	<body>


		<div id="app">
		
			<!-- 轮播图 -->
			<!-- <div class="layui-carousel" id="swiper">
				<div carousel-item id="swiper-item">
					<div v-for="(item,index) in swiperList" v-bind:key="index">
						<img class="swiper-item" :src="item.img">
					</div>
				</div>
			</div> -->
			<div class="layui-carousel" id="swiper" :style='{"boxShadow":"0 0 6px rgba(0,0,0,0.3)","margin":"20px auto","borderColor":"rgba(0,0,0,.3)","borderRadius":"20px","borderWidth":"0","width":"80%","borderStyle":"solid"}'>
			  <div carousel-item id="swiper-item">
				<div v-for="(item,index) in swiperList" :key="index">
					<img style="width: 100%;height: 100%;object-fit:cover;" :src="item.img" />
				</div>
			  </div>
			</div>
			<!-- 轮播图 -->
		
			<div class="data-add-container" :style='{"padding":"20px","boxShadow":"1px 1px 6px rgba(0,0,0,0.3)","margin":"30px auto","borderColor":"rgba(0, 0, 0, 1)","backgroundColor":"rgba(0, 0, 0, 0)","borderRadius":"10px","borderWidth":"1px","borderStyle":"dashed"}'>
		
				<form class="layui-form layui-form-pane add" lay-filter="myForm">
					
		            <div :style='{"padding":"10px","boxShadow":"none","margin":"0 0 10px 0","borderColor":"rgba(110,22,64,.3)","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"4px","borderWidth":"0","borderStyle":"solid"}' class="layui-form-item" pane>
						<label :style='{"width":"114px","padding":"0 12px 0 0","fontSize":"16px","color":"rgba(0, 0, 0, 1)","textAlign":"right"}' class="layui-form-label">宠物名称：</label>
						<div class="layui-input-block">
							<input :style='{"padding":"0 12px","boxShadow":"0 0 6px rgba(0,0,0,0.3)","borderColor":"#DCDFE6","backgroundColor":"rgba(255, 255, 255, 0.5)","color":"#333","borderRadius":"4px","textAlign":"left","borderWidth":"1px","fontSize":"14px","borderStyle":"solid","height":"40px"}' v-model="detail.chongwumingcheng" type="text" :readonly="ro.chongwumingcheng" name="chongwumingcheng" id="chongwumingcheng" autocomplete="off" class="layui-input">
						</div>
					</div>
		            <div :style='{"padding":"10px","boxShadow":"none","margin":"0 0 10px 0","borderColor":"rgba(110,22,64,.3)","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"4px","borderWidth":"0","borderStyle":"solid"}' class="layui-form-item" pane>
						<label :style='{"width":"114px","padding":"0 12px 0 0","fontSize":"16px","color":"rgba(0, 0, 0, 1)","textAlign":"right"}' class="layui-form-label">宠物分类：</label>
						<div class="layui-input-block">
							<input :style='{"padding":"0 12px","boxShadow":"0 0 6px rgba(0,0,0,0.3)","borderColor":"#DCDFE6","backgroundColor":"rgba(255, 255, 255, 0.5)","color":"#333","borderRadius":"4px","textAlign":"left","borderWidth":"1px","fontSize":"14px","borderStyle":"solid","height":"40px"}' v-model="detail.chongwufenlei" type="text" :readonly="ro.chongwufenlei" name="chongwufenlei" id="chongwufenlei" autocomplete="off" class="layui-input">
						</div>
					</div>
		            <div :style='{"padding":"10px","boxShadow":"none","margin":"0 0 10px 0","borderColor":"rgba(110,22,64,.3)","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"4px","borderWidth":"0","borderStyle":"solid"}' class="layui-form-item" pane>
						<label :style='{"width":"114px","padding":"0 12px 0 0","fontSize":"16px","color":"rgba(0, 0, 0, 1)","textAlign":"right"}' class="layui-form-label">宠物图片：</label>
						<div v-if="detail.chongwutupian" class="layui-input-block">
							<img id="chongwutupianImg" style="width: 100px;height: 100px;border-radius: 50%;border: 2px solid #EEEEEE;" :src="baseurl+detail.chongwutupian">
							<input :style='{"padding":"0 12px","boxShadow":"0 0 6px rgba(0,0,0,0.3)","borderColor":"#DCDFE6","backgroundColor":"rgba(255, 255, 255, 0.5)","color":"#333","borderRadius":"4px","textAlign":"left","borderWidth":"1px","fontSize":"14px","borderStyle":"solid","height":"40px"}' type="hidden" :value="detail.chongwutupian" id="chongwutupian" name="chongwutupian" />
						</div>
						<div class="layui-input-block">
							<button v-if="!ro.chongwutupian" :style='{"padding":"0 10px","boxShadow":"0 0 6px rgba(0,0,0,0.3)","margin":"0 10px 0 0","borderColor":"#ccc","backgroundColor":"rgba(15, 141, 80, 1)","color":"#fff","borderRadius":"8px","borderWidth":"0","width":"auto","fontSize":"18px","borderStyle":"solid","height":"44px"}' type="button" class="layui-btn btn-theme" id="chongwutupianUpload">
								<i v-if="true" :style='{"color":"#fff","show":true,"fontSize":"18px"}' class="layui-icon">&#xe67c;</i>上传宠物图片
							</button>
						</div>
					</div>
		            <div :style='{"padding":"10px","boxShadow":"none","margin":"0 0 10px 0","borderColor":"rgba(110,22,64,.3)","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"4px","borderWidth":"0","borderStyle":"solid"}' class="layui-form-item" pane>
						<label :style='{"width":"114px","padding":"0 12px 0 0","fontSize":"16px","color":"rgba(0, 0, 0, 1)","textAlign":"right"}' class="layui-form-label">宠物品种：</label>
						<div class="layui-input-block">
							<input :style='{"padding":"0 12px","boxShadow":"0 0 6px rgba(0,0,0,0.3)","borderColor":"#DCDFE6","backgroundColor":"rgba(255, 255, 255, 0.5)","color":"#333","borderRadius":"4px","textAlign":"left","borderWidth":"1px","fontSize":"14px","borderStyle":"solid","height":"40px"}' v-model="detail.chongwupinzhong" type="text" :readonly="ro.chongwupinzhong" name="chongwupinzhong" id="chongwupinzhong" autocomplete="off" class="layui-input">
						</div>
					</div>
		            <div :style='{"padding":"10px","boxShadow":"none","margin":"0 0 10px 0","borderColor":"rgba(110,22,64,.3)","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"4px","borderWidth":"0","borderStyle":"solid"}' class="layui-form-item" pane>
		                <label :style='{"width":"114px","padding":"0 12px 0 0","fontSize":"16px","color":"rgba(0, 0, 0, 1)","textAlign":"right"}' class="layui-form-label">宠物性别</label>
		                <div class="layui-input-block">
		                    <select name="chongwuxingbie" id="chongwuxingbie" lay-filter="chongwuxingbie"  >
		                        <option value="">请选择</option>
		                        <option v-for="(item,index) in chongwuxingbie" v-bind:key="index" :value="item">{{item}}</option>
		                    </select>
		                </div>
		            </div>
		            <div :style='{"padding":"10px","boxShadow":"none","margin":"0 0 10px 0","borderColor":"rgba(110,22,64,.3)","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"4px","borderWidth":"0","borderStyle":"solid"}' class="layui-form-item" pane>
						<label :style='{"width":"114px","padding":"0 12px 0 0","fontSize":"16px","color":"rgba(0, 0, 0, 1)","textAlign":"right"}' class="layui-form-label">宠物性格：</label>
						<div class="layui-input-block">
							<input :style='{"padding":"0 12px","boxShadow":"0 0 6px rgba(0,0,0,0.3)","borderColor":"#DCDFE6","backgroundColor":"rgba(255, 255, 255, 0.5)","color":"#333","borderRadius":"4px","textAlign":"left","borderWidth":"1px","fontSize":"14px","borderStyle":"solid","height":"40px"}' v-model="detail.chongwuxingge" type="text" :readonly="ro.chongwuxingge" name="chongwuxingge" id="chongwuxingge" autocomplete="off" class="layui-input">
						</div>
					</div>
		            <div :style='{"padding":"10px","boxShadow":"none","margin":"0 0 10px 0","borderColor":"rgba(110,22,64,.3)","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"4px","borderWidth":"0","borderStyle":"solid"}' class="layui-form-item" pane>
						<label :style='{"width":"114px","padding":"0 12px 0 0","fontSize":"16px","color":"rgba(0, 0, 0, 1)","textAlign":"right"}' class="layui-form-label">宠物年龄：</label>
						<div class="layui-input-block">
							<input :style='{"padding":"0 12px","boxShadow":"0 0 6px rgba(0,0,0,0.3)","borderColor":"#DCDFE6","backgroundColor":"rgba(255, 255, 255, 0.5)","color":"#333","borderRadius":"4px","textAlign":"left","borderWidth":"1px","fontSize":"14px","borderStyle":"solid","height":"40px"}' v-model="detail.chongwunianling" type="text" :readonly="ro.chongwunianling" name="chongwunianling" id="chongwunianling" autocomplete="off" class="layui-input">
						</div>
					</div>
		            <div :style='{"padding":"10px","boxShadow":"none","margin":"0 0 10px 0","borderColor":"rgba(110,22,64,.3)","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"4px","borderWidth":"0","borderStyle":"solid"}' class="layui-form-item" pane>
		                <label :style='{"width":"114px","padding":"0 12px 0 0","fontSize":"16px","color":"rgba(0, 0, 0, 1)","textAlign":"right"}' class="layui-form-label">宠物疫苗</label>
		                <div class="layui-input-block">
		                    <select name="chongwuyimiao" id="chongwuyimiao" lay-filter="chongwuyimiao"  >
		                        <option value="">请选择</option>
		                        <option v-for="(item,index) in chongwuyimiao" v-bind:key="index" :value="item">{{item}}</option>
		                    </select>
		                </div>
		            </div>
		            <div :style='{"padding":"10px","boxShadow":"none","margin":"0 0 10px 0","borderColor":"rgba(110,22,64,.3)","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"4px","borderWidth":"0","borderStyle":"solid"}' class="layui-form-item" pane>
		                <label :style='{"width":"114px","padding":"0 12px 0 0","fontSize":"16px","color":"rgba(0, 0, 0, 1)","textAlign":"right"}' class="layui-form-label">领养状态</label>
		                <div class="layui-input-block">
		                    <select name="lingyangzhuangtai" id="lingyangzhuangtai" lay-filter="lingyangzhuangtai"  >
		                        <option value="">请选择</option>
		                        <option v-for="(item,index) in lingyangzhuangtai" v-bind:key="index" :value="item">{{item}}</option>
		                    </select>
		                </div>
		            </div>
		            <div :style='{"padding":"10px","boxShadow":"none","margin":"0 0 10px 0","borderColor":"rgba(110,22,64,.3)","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"4px","borderWidth":"0","borderStyle":"solid"}' class="layui-form-item" pane>
						<label :style='{"width":"114px","padding":"0 12px 0 0","fontSize":"16px","color":"rgba(0, 0, 0, 1)","textAlign":"right"}' class="layui-form-label">领养地址：</label>
						<div class="layui-input-block">
							<input :style='{"padding":"0 12px","boxShadow":"0 0 6px rgba(0,0,0,0.3)","borderColor":"#DCDFE6","backgroundColor":"rgba(255, 255, 255, 0.5)","color":"#333","borderRadius":"4px","textAlign":"left","borderWidth":"1px","fontSize":"14px","borderStyle":"solid","height":"40px"}' v-model="detail.lingyangdizhi" type="text" :readonly="ro.lingyangdizhi" name="lingyangdizhi" id="lingyangdizhi" autocomplete="off" class="layui-input">
						</div>
					</div>
		            <div :style='{"padding":"10px","boxShadow":"none","margin":"0 0 10px 0","borderColor":"rgba(110,22,64,.3)","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"4px","borderWidth":"0","borderStyle":"solid"}' class="layui-form-item" pane>
						<label :style='{"width":"114px","padding":"0 12px 0 0","fontSize":"16px","color":"rgba(0, 0, 0, 1)","textAlign":"right"}' class="layui-form-label">商家名称：</label>
						<div class="layui-input-block">
							<input :style='{"padding":"0 12px","boxShadow":"0 0 6px rgba(0,0,0,0.3)","borderColor":"#DCDFE6","backgroundColor":"rgba(255, 255, 255, 0.5)","color":"#333","borderRadius":"4px","textAlign":"left","borderWidth":"1px","fontSize":"14px","borderStyle":"solid","height":"40px"}' v-model="detail.shangjiamingcheng" type="text" :readonly="ro.shangjiamingcheng" name="shangjiamingcheng" id="shangjiamingcheng" autocomplete="off" class="layui-input">
						</div>
					</div>
		            <div :style='{"padding":"10px","boxShadow":"none","margin":"0 0 10px 0","borderColor":"rgba(110,22,64,.3)","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"4px","borderWidth":"0","borderStyle":"solid"}' class="layui-form-item" pane>
						<label :style='{"width":"114px","padding":"0 12px 0 0","fontSize":"16px","color":"rgba(0, 0, 0, 1)","textAlign":"right"}' class="layui-form-label">咨询电话：</label>
						<div class="layui-input-block">
							<input :style='{"padding":"0 12px","boxShadow":"0 0 6px rgba(0,0,0,0.3)","borderColor":"#DCDFE6","backgroundColor":"rgba(255, 255, 255, 0.5)","color":"#333","borderRadius":"4px","textAlign":"left","borderWidth":"1px","fontSize":"14px","borderStyle":"solid","height":"40px"}' v-model="detail.zixundianhua" type="text" :readonly="ro.zixundianhua" name="zixundianhua" id="zixundianhua" autocomplete="off" class="layui-input">
						</div>
					</div>
		            
		            <div :style='{"padding":"10px","boxShadow":"none","margin":"0 0 10px 0","borderColor":"rgba(110,22,64,.3)","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"4px","borderWidth":"0","borderStyle":"solid"}' class="layui-form-item" pane>
						<label :style='{"width":"114px","padding":"0 12px 0 0","fontSize":"16px","color":"rgba(0, 0, 0, 1)","textAlign":"right"}' class="layui-form-label">宠物详情：</label>
						<div class="layui-input-block">
							<textarea name="chongwuxiangqing" id="chongwuxiangqing">请输入宠物详情</textarea>
						</div>
					</div>
		
					<div :style='{"padding":"10px","boxShadow":"none","margin":"0 0 10px 0","borderColor":"rgba(110,22,64,.3)","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"4px","borderWidth":"0","borderStyle":"solid"}' class="layui-form-item">
						<div class="layui-input-block" style="text-align: right;margin-right: 30px;">
							<button :style='{"padding":"0 10px","boxShadow":"0 0 6px rgba(0,0,0,0.3)","margin":"0 10px 0 180px","borderColor":"#ccc","backgroundColor":"rgba(15, 141, 80, 1)","color":"#fff","borderRadius":"8px","borderWidth":"0","width":"25%","fontSize":"20px","borderStyle":"solid","height":"44px"}'  class="layui-btn btn-submit" lay-submit lay-filter="*">提交</button>
							<button :style='{"padding":"0 10px","boxShadow":"0 0 6px rgba(0,0,0,0.3)","margin":"0 10px","borderColor":"#ccc","backgroundColor":"#fff","color":"rgba(15, 141, 80, 1)","borderRadius":"8px","borderWidth":"0","width":"25%","fontSize":"20px","borderStyle":"solid","height":"44px"}' type="reset" class="layui-btn layui-btn-primary">重置</button>
						</div>
					</div>
				</form>
			</div>
		</div>

		<script src="../../layui/layui.js"></script>
		<script src="../../js/vue.js"></script>
		<!-- 组件配置信息 -->
		<script src="../../js/config.js"></script>
		<!-- 扩展插件配置信息 -->
		<script src="../../modules/config.js"></script>
		<!-- 工具方法 -->
		<script src="../../js/utils.js"></script>
		<!-- 校验格式工具类 -->
		<script src="../../js/validate.js"></script>
		<!-- 地图 -->
		<script type="text/javascript" src="../../js/jquery.js"></script>
		<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=ca04cee7ac952691aa67a131e6f0cee0"></script>
		<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../../js/bootstrap.AMapPositionPicker.js"></script>

		<script>
			var jquery = $;
			
			var vue = new Vue({
				el: '#app',
				data: {
					// 轮播图
					swiperList: [{
						img: '../../img/banner.jpg'
					}],
					baseurl: '',
					dataList: [],
					ro:{
                                        chongwumingcheng : false,
                                        chongwufenlei : false,
                                        chongwutupian : false,
                                        chongwupinzhong : false,
                                        chongwuxingbie : false,
                                        chongwuxingge : false,
                                        chongwunianling : false,
                                        lingyangyaoqiu : false,
                                        chongwuyimiao : false,
                                        lingyangzhuangtai : false,
                                        chongwuxiangqing : false,
                                        lingyangdizhi : false,
                                        shangjiamingcheng : false,
                                        zixundianhua : false,
                                        sfsh : false,
                                        shhf : false,
					},
                    detail: {
                        chongwumingcheng: '',
                        chongwufenlei: '',
                        chongwutupian: '',
                        chongwupinzhong: '',
                        chongwuxingbie: '',
                        chongwuxingge: '',
                        chongwunianling: '',
                        lingyangyaoqiu: '',
                        chongwuyimiao: '',
		        lingyangzhuangtai: '待领养',
                        chongwuxiangqing: '',
                        lingyangdizhi: '',
                        shangjiamingcheng: '',
                        zixundianhua: '',
                        sfsh: '',
                        shhf: '',
                    },
					chongwuxingbie: '公,母'.split(','),
					chongwuyimiao: '是,否'.split(','),
					lingyangzhuangtai: '已领养,待领养'.split(','),
					centerMenu: centerMenu
				},
				updated: function() {
					layui.form.render('select', 'myForm');
				},
                computed: {



                },
				methods: {
					jump(url) {
						jump(url)
					}
				}
			})


			layui.use(['layer', 'element', 'carousel', 'http', 'jquery', 'form', 'upload', 'laydate','tinymce'], function() {
				var layer = layui.layer;
				var element = layui.element;
				var carousel = layui.carousel;
				var http = layui.http;
				var jquery = layui.jquery;
				var form = layui.form;
				var upload = layui.upload;
				var laydate = layui.laydate;
				var tinymce = layui.tinymce;
				vue.baseurl = http.baseurl;

				// 获取轮播图 数据
				http.request('config/list', 'get', {
					page: 1,
					limit: 5
				}, function(res) {
					if (res.data.list.length > 0) {
						var swiperItemHtml = '';
						for (let item of res.data.list) {
							if (item.name.indexOf('picture') >= 0 && item.value && item.value != "" && item.value != null) {
								swiperItemHtml +=
									'<div>' +
									'<img style="width: 100%;height: 100%;object-fit:cover;" class="swiper-item" src="' + http.baseurl+item.value + '">' +
									'</div>';
							}
						}
						jquery('#swiper-item').html(swiperItemHtml);
						// 轮播图
						vue.$nextTick(() => {
						  carousel.render({
						  	elem: '#swiper',
							width: '80%',
						  	height: '400px',
						  	arrow: 'hover',
						  	anim: 'default',
						  	autoplay: 'true',
						  	interval: '3000',
						  	indicator: 'inside'
						  });
						
						})
					}
				});

				// 上传图片
				var chongwutupianUpload = upload.render({
					//绑定元素
					elem: '#chongwutupianUpload',
					//上传接口
					url: http.baseurl + 'file/upload',
					// 请求头
					headers: {
						Token: localStorage.getItem('Token')
					},
					// 允许上传时校验的文件类型
					accept: 'images',
					before: function() {
						//loading层
						var index = layer.load(1, {
							shade: [0.1, '#fff'] //0.1透明度的白色背景
						});
					},
					// 上传成功
					done: function(res) {
						console.log(res);
						layer.closeAll();
						if (res.code == 0) {
							layer.msg("上传成功", {
								time: 2000,
								icon: 6
							})
							var url = 'upload/' + res.file;
							jquery('#chongwutupian').val(url);
							jquery('#chongwutupianImg').attr('src', http.baseurl +url)
							vue.detail.chongwutupian = url;
						} else {
							layer.msg(res.msg, {
								time: 2000,
								icon: 5
							})
						}
					},
					//请求异常回调
					error: function() {
						layer.closeAll();
						layer.msg("请求接口异常", {
							time: 2000,
							icon: 5
						})
					}
				});
                form.on('select(chongwuxingbie)', function (data) {
                    vue.detail.chongwuxingbie=data.value;
                });
                form.on('select(chongwuyimiao)', function (data) {
                    vue.detail.chongwuyimiao=data.value;
                });
                $("#lingyangzhuangtai").val('待领养')
                form.on('select(lingyangzhuangtai)', function (data) {
                    vue.detail.lingyangzhuangtai=data.value;
                });
                var edit = tinymce.render({
                    elem: "#chongwuxiangqing",
                    height: 600,
                    images_upload_handler: function(blobInfo, succFun, failFun) {
                        var xhr, formData;
                        var file = blobInfo.blob(); //转化为易于理解的file对象
                        xhr = new XMLHttpRequest();
                        xhr.withCredentials = false;
                        xhr.open('POST', http.baseurl + 'file/upload');
                        xhr.setRequestHeader("Token", localStorage.getItem('Token')); //设置请求头
                        xhr.onload = function() {
                            var json;
                            if (xhr.status != 200) {
                                failFun('HTTP Error: ' + xhr.status);
                                return;
                            }
                            json = JSON.parse(xhr.responseText);
                            if (!json || typeof json.file != 'string') {
                                failFun('Invalid JSON: ' + xhr.responseText);
                                return;
                            }
                            succFun(http.baseurl + '/upload/' + json.file);
                        };
                        formData = new FormData();
                        formData.append('file', file, file.name); //此处与源文档不一样
                        xhr.send(formData);
                    }
                }, (opt) => {

                });
				
                // session独取
				let table = localStorage.getItem("userTable");
				http.request(`${table}/session`, 'get', {}, function(data) {
					// 表单赋值
					//form.val("myForm", data.data);
					data = data.data
					for(var key in data){
                        if(key=='shangjiamingcheng'){
                                vue.detail['shangjiamingcheng'] = data[`${key}`]
                                vue.ro.shangjiamingcheng = true;
                                continue;
                        }
                        if(key=='zixundianhua'){
                                vue.detail['zixundianhua'] = data[`${key}`]
                                vue.ro.zixundianhua = true;
                                continue;
                        }
					}
				});

                // 跨表计算
                if(http.getParam('corss')){
					var obj = JSON.parse(localStorage.getItem('crossObj'));
					//form.val("myForm", obj);
					for(var o in obj){
                                        if(o=='chongwumingcheng'){
                                                vue.detail[o] = obj[o];
                                                vue.ro.chongwumingcheng = true;
                                                continue;
                                        }
                                        if(o=='chongwufenlei'){
                                                vue.detail[o] = obj[o];
                                                vue.ro.chongwufenlei = true;
                                                continue;
                                        }
                                        if(o=='chongwutupian'){
                                                vue.detail[o] = obj[o];
                                                vue.ro.chongwutupian = true;
                                                continue;
                                        }
                                        if(o=='chongwupinzhong'){
                                                vue.detail[o] = obj[o];
                                                vue.ro.chongwupinzhong = true;
                                                continue;
                                        }
                                        if(o=='chongwuxingbie'){
                                                vue.detail[o] = obj[o];
                                                vue.ro.chongwuxingbie = true;
                                                continue;
                                        }
                                        if(o=='chongwuxingge'){
                                                vue.detail[o] = obj[o];
                                                vue.ro.chongwuxingge = true;
                                                continue;
                                        }
                                        if(o=='chongwunianling'){
                                                vue.detail[o] = obj[o];
                                                vue.ro.chongwunianling = true;
                                                continue;
                                        }
                                        if(o=='lingyangyaoqiu'){
                                                vue.detail[o] = obj[o];
                                                vue.ro.lingyangyaoqiu = true;
                                                continue;
                                        }
                                        if(o=='chongwuyimiao'){
                                                vue.detail[o] = obj[o];
                                                vue.ro.chongwuyimiao = true;
                                                continue;
                                        }
                                        if(o=='lingyangzhuangtai'){
                                                vue.detail[o] = obj[o];
                                                vue.ro.lingyangzhuangtai = true;
                                                continue;
                                        }
                                        if(o=='chongwuxiangqing'){
                                                vue.detail[o] = obj[o];
                                                vue.ro.chongwuxiangqing = true;
                                                continue;
                                        }
                                        if(o=='lingyangdizhi'){
                                                vue.detail[o] = obj[o];
                                                vue.ro.lingyangdizhi = true;
                                                continue;
                                        }
                                        if(o=='shangjiamingcheng'){
                                                vue.detail[o] = obj[o];
                                                vue.ro.shangjiamingcheng = true;
                                                continue;
                                        }
                                        if(o=='zixundianhua'){
                                                vue.detail[o] = obj[o];
                                                vue.ro.zixundianhua = true;
                                                continue;
                                        }
					}
				}
				

				// 提交
				form.on('submit(*)', function(data) {
					data = data.field;
					
                    // 数据校验
                    if(!data.chongwumingcheng){
                        layer.msg('宠物名称不能为空', {
							time: 2000,
							icon: 5
						});
                        return false
                    }
                    if(!data.chongwufenlei){
                        layer.msg('宠物分类不能为空', {
							time: 2000,
							icon: 5
						});
                        return false
                    }
                    if(!data.chongwupinzhong){
                        layer.msg('宠物品种不能为空', {
							time: 2000,
							icon: 5
						});
                        return false
                    }
                    if(!data.chongwuxingbie){
                        layer.msg('宠物性别不能为空', {
							time: 2000,
							icon: 5
						});
                        return false
                    }
                    if(!data.chongwuyimiao){
                        layer.msg('宠物疫苗不能为空', {
							time: 2000,
							icon: 5
						});
                        return false
                    }
					var chongwuxiangqing = tinymce.get('#chongwuxiangqing').getContent()
					data.chongwuxiangqing = chongwuxiangqing;
                    if(!isMobile(data.zixundianhua)){
                        layer.msg('咨询电话应输入手机格式', {
							time: 2000,
							icon: 5
						});
                        return false
                    }

					// 跨表计算判断
					
                    // 比较大小

                //更新跨表属性
               var crossuserid;
               var crossrefid;
               var crossoptnum;
                if(http.getParam('corss')){
                        var statusColumnName = localStorage.getItem('statusColumnName');
                        var statusColumnValue = localStorage.getItem('statusColumnValue');
                        if(statusColumnName!='') {
                                var obj = JSON.parse(localStorage.getItem('crossObj'));
				if(!statusColumnName.startsWith("[")) {
					for (var o in obj){
						if(o==statusColumnName){
							obj[o] = statusColumnValue;
						}
					}
					var table = localStorage.getItem('crossTable');
					http.requestJson(`${table}/update`,'post',obj,(res)=>{});
				} else {
                                       crossuserid=Number(localStorage.getItem('userid'));
                                       crossrefid=obj['id'];
                                       crossoptnum=localStorage.getItem('statusColumnName');
                                       crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
				}
                        }
                }
                        if(crossrefid && crossuserid) {
                                data.crossuserid=crossuserid;
                                data.crossrefid=crossrefid;
                                http.request('lingyangxinxi/list', 'get', {
                                        page: 1,
                                        limit: 10,
                                        crossuserid:crossuserid,
                                        crossrefid:crossrefid,
                                }, function(res) {
                                        if(res.data.total>=crossoptnum) {
                                                layer.msg(localStorage.getItem('tips'), {
                                                        time: 2000,
                                                        icon: 6
                                                })
                                             return false;
                                        } else {
                                            // 跨表计算



                                            // 提交数据
                                            http.requestJson('lingyangxinxi' + '/add', 'post', data, function(res) {
                                                    layer.msg('提交成功', {
                                                            time: 2000,
                                                            icon: 6
                                                    }, function() {
                                                            back();
                                                    });
                                             });
                                        }
                                });
                        } else {
                                // 跨表计算

                                // 提交数据
                                http.requestJson('lingyangxinxi' + '/add', 'post', data, function(res) {
                                        layer.msg('提交成功', {
                                                time: 2000,
                                                icon: 6
                                        }, function() {
                                                back();
                                        });
                                 });
                        }
			return false
			});
		});
		</script>
	</body>
</html>
