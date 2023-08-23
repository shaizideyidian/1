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
						<label :style='{"width":"114px","padding":"0 12px 0 0","fontSize":"16px","color":"rgba(0, 0, 0, 1)","textAlign":"right"}' class="layui-form-label">商家名称：</label>
						<div class="layui-input-block">
							<input :style='{"padding":"0 12px","boxShadow":"0 0 6px rgba(0,0,0,0.3)","borderColor":"#DCDFE6","backgroundColor":"rgba(255, 255, 255, 0.5)","color":"#333","borderRadius":"4px","textAlign":"left","borderWidth":"1px","fontSize":"14px","borderStyle":"solid","height":"40px"}' v-model="detail.shangjiamingcheng" type="text" :readonly="ro.shangjiamingcheng" name="shangjiamingcheng" id="shangjiamingcheng" autocomplete="off" class="layui-input">
						</div>
					</div>
		            <div :style='{"padding":"10px","boxShadow":"none","margin":"0 0 10px 0","borderColor":"rgba(110,22,64,.3)","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"4px","borderWidth":"0","borderStyle":"solid"}' class="layui-form-item" pane>
						<label :style='{"width":"114px","padding":"0 12px 0 0","fontSize":"16px","color":"rgba(0, 0, 0, 1)","textAlign":"right"}' class="layui-form-label">咨询时间：</label>
						<div class="layui-input-block">
							<input :style='{"padding":"0 12px","boxShadow":"0 0 6px rgba(0,0,0,0.3)","borderColor":"#DCDFE6","backgroundColor":"rgba(255, 255, 255, 0.5)","color":"#333","borderRadius":"4px","textAlign":"left","borderWidth":"1px","fontSize":"14px","borderStyle":"solid","height":"40px"}' type="text" name="zixunshijian" id="zixunshijian" autocomplete="off" class="layui-input" disabled>
						</div>
					</div>
		            <div :style='{"padding":"10px","boxShadow":"none","margin":"0 0 10px 0","borderColor":"rgba(110,22,64,.3)","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"4px","borderWidth":"0","borderStyle":"solid"}' class="layui-form-item" pane>
						<label :style='{"width":"114px","padding":"0 12px 0 0","fontSize":"16px","color":"rgba(0, 0, 0, 1)","textAlign":"right"}' class="layui-form-label">用户名：</label>
						<div class="layui-input-block">
							<input :style='{"padding":"0 12px","boxShadow":"0 0 6px rgba(0,0,0,0.3)","borderColor":"#DCDFE6","backgroundColor":"rgba(255, 255, 255, 0.5)","color":"#333","borderRadius":"4px","textAlign":"left","borderWidth":"1px","fontSize":"14px","borderStyle":"solid","height":"40px"}' v-model="detail.yonghuming" type="text" :readonly="ro.yonghuming" name="yonghuming" id="yonghuming" autocomplete="off" class="layui-input">
						</div>
					</div>
		            
		            <div :style='{"padding":"10px","boxShadow":"none","margin":"0 0 10px 0","borderColor":"rgba(110,22,64,.3)","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"4px","borderWidth":"0","borderStyle":"solid"}' class="layui-form-item" pane>
						<label :style='{"width":"114px","padding":"0 12px 0 0","fontSize":"16px","color":"rgba(0, 0, 0, 1)","textAlign":"right"}' class="layui-form-label">咨询内容：</label>
						<div class="layui-input-block">
							<textarea name="zixunneirong" id="zixunneirong">请输入咨询内容</textarea>
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
                                        shangjiamingcheng : false,
                                        zixunneirong : false,
                                        zixunshijian : false,
                                        yonghuming : false,
                                        sfsh : false,
                                        shhf : false,
					},
                    detail: {
                        shangjiamingcheng: '',
                        zixunneirong: '',
                        zixunshijian: '',
                        yonghuming: '',
                        sfsh: '',
                        shhf: '',
                    },
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

                var edit = tinymce.render({
                    elem: "#zixunneirong",
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
                                jquery('#zixunshijian').val(getCurDateTime());
				laydate.render({
					elem: '#zixunshijian',
					type: 'datetime'
				});
				
                // session独取
				let table = localStorage.getItem("userTable");
				http.request(`${table}/session`, 'get', {}, function(data) {
					// 表单赋值
					//form.val("myForm", data.data);
					data = data.data
					for(var key in data){
                                        vue.ro.shangjiamingcheng = true;
                                        vue.ro.zixunshijian = true;
                        if(key=='yonghuming'){
                                vue.detail['yonghuming'] = data[`${key}`]
                                vue.ro.yonghuming = true;
                                continue;
                        }
					}
				});

                // 跨表计算
                if(http.getParam('corss')){
					var obj = JSON.parse(localStorage.getItem('crossObj'));
					//form.val("myForm", obj);
					for(var o in obj){
                                        if(o=='shangjiamingcheng'){
                                                vue.detail[o] = obj[o];
                                                vue.ro.shangjiamingcheng = true;
                                                continue;
                                        }
                                        if(o=='zixunneirong'){
                                                vue.detail[o] = obj[o];
                                                vue.ro.zixunneirong = true;
                                                continue;
                                        }
                                        if(o=='zixunshijian'){
                                                vue.detail[o] = obj[o];
                                                vue.ro.zixunshijian = true;
                                                jquery('#zixunshijian').val(obj[o]);
                                                continue;
                                        }
                                        if(o=='yonghuming'){
                                                vue.detail[o] = obj[o];
                                                vue.ro.yonghuming = true;
                                                continue;
                                        }
					}
				}
				

				// 提交
				form.on('submit(*)', function(data) {
					data = data.field;
					
                    // 数据校验
					var zixunneirong = tinymce.get('#zixunneirong').getContent()
					data.zixunneirong = zixunneirong;
                    if(!data.zixunneirong){
                        layer.msg('咨询内容不能为空', {
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
                                http.request('lianxijilu/list', 'get', {
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
                                            http.requestJson('lianxijilu' + '/add', 'post', data, function(res) {
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
                                http.requestJson('lianxijilu' + '/add', 'post', data, function(res) {
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
