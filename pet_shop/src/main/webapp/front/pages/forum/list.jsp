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
		#swiper {
			overflow: hidden;
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
		
		.index-title {
		    text-align: center;
		    box-sizing: border-box;
		    width: 980px;
		    display: flex;
		    justify-content: center;
		    align-items: center;
		    flex-direction: column;
		}
		.forum-container .btn-container {
			display: flex;
			    align-items: center;
			    box-sizing: border-box;
			    width: 100%;
			    flex-wrap: wrap;
		}
		.forum-container .btn-container button i {
			margin-right: 4px;
		}
		
		.layui-laypage .layui-laypage-count {
		  padding: 0 10px;
		}
		.layui-laypage .layui-laypage-skip {
		  padding-left: 10px;
		}
	</style>
	<body>

		<div id="app">

			<!-- 轮播图 -->
			<div class="layui-carousel" id="swiper" :style='{"boxShadow":"0 0 6px rgba(0,0,0,0.3)","margin":"20px auto","borderColor":"rgba(0,0,0,.3)","borderRadius":"20px","borderWidth":"0","width":"80%","borderStyle":"solid"}'>
			  <div carousel-item id="swiper-item">
				<div v-for="(item,index) in swiperList" :key="index">
					<img style="width: 100%;height: 100%;object-fit:cover;" :src="item.img" />
				</div>
			  </div>
			</div>
			<!-- 轮播图 -->

			<!-- 标题 -->
			<div class="index-title" :style='{"padding":"10px","boxShadow":"0 0 6px rgba(0,0,0,0.5)","margin":"10px auto","borderColor":"rgba(0,0,0,.3)","backgroundColor":"rgba(0, 0, 0, 1)","color":"rgba(251, 251, 251, 1)","borderRadius":"4px","borderWidth":"0","fontSize":"20px","borderStyle":"solid","height":"auto"}'>
			  <span>FORUM / INFORMATION</span><span>养宠心得</span>
			</div>
			<!-- 标题 -->

			<div class="forum-container">
				<div class="btn-container" :style='{"padding":"0 10px","boxShadow":"0 0 6px rgba(0,0,0,0.3)","margin":"10px 0 10px 0","borderColor":"rgba(0,0,0,.3)","backgroundColor":"rgba(0, 0, 0, 1)","borderRadius":"4px","alignItems":"center","borderWidth":"0","borderStyle":"solid","justifyContent":"flex-end","height":"64px"}'>
					<!-- <input type="" name="" id="" value="" />
					<button :style='{"padding":"0 15px","boxShadow":"0 0 8px rgba(0,0,0,0)","margin":"0 0 0 10px","borderColor":"#409EFF","backgroundColor":"rgba(15, 141, 80, 1)","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","borderWidth":"0","width":"auto","fontSize":"20px","borderStyle":"solid","height":"40px"}'  type="button" class="layui-btn layui-btn-lg btn-theme">
						<i v-if="true" class="layui-icon">&#xe654;</i> 搜索
					</button> -->
                    <input type="text" :style='{"boxShadow":"0 0 6px rgba(255,0,0,0)","borderColor":"#ccc","backgroundColor":"#fff","color":"#333","borderRadius":"8px","textAlign":"center","borderWidth":"1px","width":"140px","fontSize":"16px","borderStyle":"solid","height":"44px"}' name="title" id="title" placeholder="标题" autocomplete="off" class="layui-input">
                    <button :style='{"padding":"0 15px","boxShadow":"0 0 8px rgba(0,0,0,0)","margin":"0 0 0 10px","borderColor":"#409EFF","backgroundColor":"rgba(15, 141, 80, 1)","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","borderWidth":"0","width":"auto","fontSize":"20px","borderStyle":"solid","height":"40px"}' id="btn-search" type="button" class="layui-btn layui-btn-normal">
                        <i class="layui-icon layui-icon-search"></i>搜索
                    </button>
					<button :style='{"padding":"0 15px","boxShadow":"0 0 8px rgba(0,0,0,0)","margin":"0 0 0 10px","borderColor":"#409EFF","backgroundColor":"rgba(15, 141, 80, 1)","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","borderWidth":"0","width":"auto","fontSize":"20px","borderStyle":"solid","height":"40px"}'  @click="jump('../forum/add.jsp')" type="button" class="layui-btn layui-btn-lg btn-theme">
						<i v-if="true" class="layui-icon">&#xe654;</i> 发布帖子
					</button>
				</div>
				<div class="forum-list">
					<div v-for="(item,index) in dataList" v-bind:key="index" href="javascript:void(0);" @click="jump('../forum/detail.jsp?id='+item.id);" class="forum-item">
						<h2 class="h2">{{item.title}}（发布人：{{item.username}}）</h2>
						<div class="create-time">
							{{item.addtime}}
						</div>
					</div>
				</div>
				<div class="pager" id="pager" :style="{textAlign:3==1?'left':3==2?'center':'right'}"></div>
			</div>
		</div>

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
				data: {
					// 轮播图
					swiperList: [{
						img: '../../img/banner.jpg'
					}],
					dataList: []
				},
				filters: {
					newsDesc: function(val) {
						if (val) {
							if (val.length > 200) {
								return val.substring(0, 200).replace(/<[^>]*>/g).replace(/undefined/g, '');
							} else {
								return val.replace(/<[^>]*>/g).replace(/undefined/g, '');
							}
						}
						return '';
					}
				},
				methods: {
					jump(url) {
						jump(url)
					}
				}
			})

			layui.use(['layer', 'element', 'carousel', 'laypage', 'http', 'jquery'], function() {
				var layer = layui.layer;
				var element = layui.element;
				var carousel = layui.carousel;
				var laypage = layui.laypage;
				var http = layui.http;
				var jquery = layui.jquery;

				var limit = 10;

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
									'<img class="swiper-item" style="width: 100%;height: 100%;object-fit:cover;" src="' + http.baseurl+item.value + '">' +
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

                  pageList(); 

                  // 搜索按钮
                  jquery('#btn-search').click(function(e) {
                    pageList();
                  });
                  function pageList() {
                    // 获取列表数据
                    http.request('forum/flist?isdone=开放&sort=addtime&order=desc', 'get', {
                        page: 1,
                        limit: limit,
                        title: '%' + jquery('#title').val() + '%',
                    }, function(res) {
                        vue.dataList = res.data.list
                        // 分页
                        laypage.render({
                            elem: 'pager',
                            count: res.data.total,
                            limit: limit,
                            groups: 5,
                            layout: ["prev","page","next","count"],
                            theme: '#0F8D50',
                            jump: function(obj, first) {
                                //首次不执行
                                if (!first) {
                                    http.request('forum/flist?isdone=开放&sort=addtime&order=desc', 'get', {
                                        page: obj.curr,
                                        limit: obj.limit
                                    }, function(res) {
                                        vue.dataList = res.data.list
                                    })
                                }
                            }
                        });
                    })
                }

			});
		</script>
	</body>
</html>
