<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>
<!-- 个人中心 -->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>订单</title>
		<link rel="stylesheet" href="../../layui/css/layui.css">
		<!-- 样式 -->
		<link rel="stylesheet" href="../../css/style.css" />
		<!-- 主题（主要颜色设置） -->
		<link rel="stylesheet" href="../../css/theme.css" />
		<!-- 通用的css -->
		<link rel="stylesheet" href="../../css/common.css" />
	</head>
	<body>

		<div id="app">
			<!-- 轮播图 -->
			<div class="layui-carousel" id="swiper">
				<div carousel-item id="swiper-item">
					<div v-for="(item,index) in swiperList" v-bind:key="index">
						<img class="swiper-item" :src="item.img">
					</div>
				</div>
			</div>
			<!-- 轮播图 -->

			<!-- 标题 -->
			<h2 style="margin-top: 20px;" class="index-title">CONFIRM / ORDER</h2>
			<div class="line-container">
				<p class="line"> 确认下单 </p>
			</div>
			<!-- 标题 -->

			<div class="container">
				<h2 v-if="seat!=1">选择收货地址</h2>
				<table v-if="seat!=1" class="layui-table address-table" lay-skin="nob">
					<!-- <colgroup>
				    <col width="150">
				    <col width="200">
				    <col>
				  </colgroup> -->
					<thead>
						<tr>
							<th>选择</th>
							<th>收件人</th>
							<th>联系方式</th>
							<th>地址</th>
						</tr>
					</thead>
					<tbody>
						<tr v-for="(item,index) in addressList" v-bind:key="index">
                            <td v-if="item.isdefault=='是'"><input type="radio" checked="checked" :value="index" name="address" /></td>
                            <td v-if="item.isdefault!='是'"><input type="radio" :value="index" name="address" /></td>
							<td>{{item.name}} </td>
							<td>{{item.phone}}</td>
							<td>{{item.address}}</td>
						</tr>
					</tbody>
				</table>
				<h2>清单列表</h2>
				<table class="layui-table" lay-skin="nob" style="border: 3px dotted #EEEEEE;margin: 20px 0;">
					<thead>
						<tr>
							<th>购买商品</th>
							<th>价格</th>
							<th v-if="seat==1">座位</th>
							<th v-else>数量</th>
							<th>总价</th>
						</tr>
					</thead>
					<tbody>
						<tr v-for="(item,index) in dataList" v-bind:key="index">
							<td style="display: flex;text-align: left;">
								<img :src="baseurl+item.picture" style="width: 100px;height: 100px;object-fit: cover;">
								<div style="margin-left: 10px;margin-top: 10px;">
									{{item.goodname}}
								</div>
							</td>
							<td v-if="type==2" style="width: 100px;">{{item.price}} 积分</td>
							<td v-else style="width: 100px;"><span :style='{"fontSize":"12px"}'>￥</span>{{Number(item.price).toFixed(2)}}</td>
							<td v-if="seat==1" style="width: 140px;">
								{{item.activeSeat}}
							</td>
							<td  v-else style="width: 140px;">
								{{item.buynumber}}
							</td>
							<td v-if="type==2" style="width: 100px;">{{item.price*item.buynumber}} 积分</td>
							<td v-else-if="seat==1"  style="width: 100px;"><span :style='{"fontSize":"12px"}'>￥</span>{{Number(item.total).toFixed(2)}}</td>
							<td v-else  style="width: 100px;"><span :style='{"fontSize":"12px"}'>￥</span>{{Number((item.price*item.buynumber)).toFixed(2)}}</td>
						</tr>
					</tbody>
				</table>
                <div>
                    <span>备注：</span> <input type="text" name="remark" style="width: 70%;" />
                </div>

				<div v-if="seat==1" class="btn-container">
					<span style="font-size: 18px;font-weight: bold;color: #ce0b07;margin-right: 20px;">
						总价：<span :style='{"fontSize":"12px"}'>￥</span>{{Number(dataList[0].total).toFixed(2)}}
					</span>
					<button @click="xuanzuoClick()" type="button" class="layui-btn layui-btn-lg btn-theme">
						<i class="layui-icon">&#xe657;</i> 余额支付
					</button>
					<button @click="xuanzuoAlipayClick()" type="button" class="layui-btn layui-btn-lg btn-theme">
						沙箱支付
					</button>
				</div>
				<div v-else-if="type==2" class="btn-container">
					<span style="font-size: 18px;font-weight: bold;color: #ce0b07;margin-right: 20px;">
						总价：{{totalPrice}}积分
					</span>
					<button @click="jfClick()" type="button" class="layui-btn layui-btn-lg btn-theme">
						<i class="layui-icon">&#xe657;</i> 兑换
					</button>
				</div>
				<div v-else class="btn-container">
					<span style="font-size: 18px;font-weight: bold;color: #ce0b07;margin-right: 20px;">
						总价：<span :style='{"fontSize":"12px"}'>￥</span>{{Number(totalPrice).toFixed(2)}}
					</span>
					<button @click="payClick()" type="button" class="layui-btn layui-btn-lg btn-theme">
						<i class="layui-icon">&#xe657;</i> 余额支付
					</button>
					<button @click="alipayClick()" type="button" class="layui-btn layui-btn-lg btn-theme">
						沙箱支付
					</button>
				</div>
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
		<!-- 校验格式工具类 -->
		<script src="../../js/validate.js"></script>

		<script>
			var vue = new Vue({
				el: '#app',
				data: {
					// 轮播图
					swiperList: [{
						img: '../../img/banner.jpg'
					}],
					dataList: [],
					baseurl: '',
					addressList: [],
					seat: 0,
					type: 0,
					// 当前用户信息
					user: {}
				},
				computed: {
					totalPrice: function() {
						var total = 0;
						for (var item of this.dataList) {
							total += item.price * item.buynumber
						}
						return total;
					}
				},
				methods: {
					jump(url) {
						jump(url)
					},
					// 正常下单，生成订单，减少余额，添加积分，减少库存，修改状态已支付
					payClick() {
						console.log('payClick')
						var index = layui.jquery('input[name=address]:checked').val();
						console.log(index);
						if (!index) {
							layui.layer.msg('请选择收货地址', {
								time: 2000,
								icon: 5
							});
							return
						}
                        var remark = layui.jquery('input[name=remark]').val();

						// 生成订单
						for (let item of this.dataList) {
							
							// 获取商品详情信息
							layui.http.request(`${item.tablename}/info/${item.goodid}`, 'get', {}, (res) => {
								// 订单编号
								var orderId = genTradeNo();
								let data = res.data;
								// 减少库存
                                data.alllimittimes = data.alllimittimes - item.buynumber;
								// 更新库存信息
								layui.http.requestJson(`${item.tablename}/update`, 'post', data, (res) => {
									// 添加订单信息
									let order = {
										orderid: orderId,
										tablename: item.tablename,
										userid: this.user.id,
										goodid: item.goodid,
										goodname: item.goodname,
										shangjiamingcheng: item.shangjiamingcheng,
                                        goodtype: item.goodtype,
										picture: item.picture,
										buynumber: item.buynumber,
										discountprice: item.price,
										price: item.price,
										total: item.price * item.buynumber,
										discounttotal: item.price * item.buynumber,
										type: 1,
										//total: this.totalPrice,
										address: this.addressList[index].address,
										tel: this.addressList[index].phone,
                                        consignee: this.addressList[index].name,
                                        remark: remark,
										status: '未支付'
									}
									layui.http.requestJson(`orders/add`, 'post', order, (res) => {
										// 减少余额，更新订单状态
                                        // 判断余额是否充足
                                        if (this.user.money < Number(item.price * item.buynumber)) {
                                            layui.layer.msg('余额不足，请先充值', {
                                                time: 2000,
                                                icon: 5
                                            });
                                            return
                                        }
										// 如果该商品存在积分
										if (data.jf) {
											this.user.jf = Number(this.user.jf) + Number(item.price * item.buynumber);
										}
										this.user.money = this.user.money - item.price * item.buynumber;
										// 更新用户余额
										layui.http.requestJson(`${localStorage.getItem("userTable")}/update`, 'post', this.user, (res) => {
                                            order.status = '已支付'
											layui.http.request(`orders/list`, 'get', {
												orderid: orderId,
												page: 1,
												limit: 1,
											}, (res) => {
												order.id = res.data.list[0].id;
												layui.http.requestJson(`orders/update`, 'post', order, (res) => {
													// 删除购物车数据(如果是购物车下单)
													if (item.id) {
														layui.http.requestJson(`cart/delete`, 'post', [item.id], (res) => {});
													}
                                                    layui.layer.msg('购买成功', {
                                                        time: 2000,
                                                        icon: 6
                                                    }, function() {
                                                        window.location.href='../shop-order/list.jsp'
                                                    });
												});
											});
										});
									})
								})
							});
						}
					},
					alipayClick() {
						var index = layui.jquery('input[name=address]:checked').val();
						if (!index) {
							layui.layer.msg('请选择收货地址', {
								time: 2000,
								icon: 5
							});
							return
						}
                        var remark = layui.jquery('input[name=remark]').val();

						// 生成订单
						for (let item of this.dataList) {
							
							// 获取商品详情信息
							layui.http.request(`${item.tablename}/info/${item.goodid}`, 'get', {}, (res) => {
								// 订单编号
								var orderId = genTradeNo();
								let data = res.data;
								// 减少库存
								data.alllimittimes = data.alllimittimes - item.buynumber;
								// 更新库存信息
								layui.http.requestJson(`${item.tablename}/update`, 'post', data, (res) => {
									// 添加订单信息
									let order = {
										orderid: orderId,
										tablename: item.tablename,
										userid: this.user.id,
										goodid: item.goodid,
										goodname: item.goodname,
										shangjiamingcheng: item.shangjiamingcheng,
                                        goodtype: item.goodtype,
										picture: item.picture,
										buynumber: item.buynumber,
										discountprice: item.price,
										price: item.price,
										total: item.price * item.buynumber,
										discounttotal: item.price * item.buynumber,
										type: 1,
										//total: this.totalPrice,
										address: this.addressList[index].address,
										tel: this.addressList[index].phone,
                                        consignee: this.addressList[index].name,
                                        remark: remark,
										status: '未支付'
									}
                                    layui.http.requestJson(`orders/add`, 'post', order, (res) => {
                                        layui.http.request(`orders/alipay`, 'get',{"tradeno":order.orderid,"totalamount":order.total,"subject":order.goodname}, (res) => {
                                            if(res.code == 0){
                                                var newWin = window.open('_blank');
                                                newWin.document.querySelector('body').innerHTML = res.data;
                                                const div = document.createElement('div') // 创建div
                                                div.innerHTML = res.data // 将返回的form 放入div
                                                newWin.document.body.appendChild(div)
                                                newWin.document.forms[0].submit()
                                            }
                                        });
                                    })
								})
							});
						}
					},
					// 积分兑换，生成订单，减少用户积分，减少库存
					jfClick() {
						var index = layui.jquery('input[name=address]:checked').val();
						console.log(index);
						if (!index) {
							layui.layer.msg('请选择收货地址', {
								time: 2000,
								icon: 5
							});
							return
						}

						// 生成订单
						for (let item of this.dataList) {
							// 订单编号
							var orderId = genTradeNo();
							layui.http.request(`${item.tablename}/info/${item.goodid}`, 'get', {}, (res) => {
								let data = res.data;
								// 减少库存
								data.alllimittimes = data.alllimittimes - item.buynumber;
								// 更新库存信息
								layui.http.requestJson(`${item.tablename}/update`, 'post', data, (res) => {
									// 判断积分是否充足
									if (this.user.jf < this.totalPrice) {
										layui.layer.msg('积分不足，兑换失败', {
											time: 2000,
											icon: 5
										});
										return
									}
									// 添加订单信息
									let order = {
										orderid: orderId,
										tablename: item.tablename,
										userid: this.user.id,
										goodid: item.goodid,
										goodname: item.goodname,
										shangjiamingcheng: item.shangjiamingcheng,
                                        goodtype: item.goodtype,
										picture: item.picture,
										buynumber: item.buynumber,
										discountprice: item.price,
										price: item.price,
										total: item.price * item.buynumber,
										discounttotal: item.price * item.buynumber,
										type: 2,
										total: this.totalPrice,
										address: this.addressList[index].address,
										tel: this.addressList[index].phone,
                                        consignee: this.addressList[index].name,
										status: '已支付'
									}
									layui.http.requestJson(`orders/add`, 'post', order, (res) => {
										this.user.jf = this.user.jf - item.price * item.buynumber;
										// 更新用户余额
										layui.http.requestJson(`${localStorage.getItem("userTable")}/update`, 'post', this.user, (res) => {
											layui.layer.msg('兑换成功', {
												time: 2000,
												icon: 6
											}, function() {
												window.location.href='../shop-order/list.jsp'
											});
										});
									})
								})
							});
						}
					},
					// 选座下单,生成订单，减少余额，添加积分，减少库存，修改状态为已支付
					xuanzuoClick() {
						console.log('xuanzuoClick')
						// 生成订单
						for (let item of this.dataList) {
							// 订单编号
							var orderId = genTradeNo();
							// 获取商品详情信息
							layui.http.request(`${item.tablename}/info/${item.goodid}`, 'get', {}, (res) => {
								let data = res.data;
								// 减少库存
								data.alllimittimes = data.alllimittimes - item.buynumber;
								// 获取已经被预定的座位号
                                let selectArray = data.selected?data.selected.split(','):[];
								// 获取用户预定的座位号
								let activeArray = item.address.split(',');
								// 新的预定座位号
								let newSelectArray = selectArray.concat(activeArray);
								// 赋值给参数
								data.selected = newSelectArray.join(',');
								// 更新库存,座位信息
								layui.http.requestJson(`${item.tablename}/update`, 'post', data, (res) => {
									// 添加订单信息
									let order = {
										orderid: orderId,
										tablename: item.tablename,
										userid: this.user.id,
										goodid: item.goodid,
										goodname: item.goodname,
										shangjiamingcheng: item.shangjiamingcheng,
                                        goodtype: item.goodtype, 
										picture: item.picture,
										buynumber: item.buynumber,
										discountprice: item.price,
										price: item.price,
										total: item.total,
										discounttotal: item.total,
										type: 1,
										address: item.address,
										status: '未支付'
									}
                                    // 判断余额是否充足
									layui.http.requestJson(`orders/add`, 'post', order, (res) => {
										// 减少余额，更新订单状态
                                        if (this.user.money < Number(item.price * item.buynumber)) {
                                            layui.layer.msg('余额不足，请先充值', {
                                                time: 2000,
                                                icon: 5
                                            });
                                            return
                                        }
										// 如果该商品存在积分
										if (data.jf) {
											this.user.jf = Number(this.user.jf) + Number(data.jf * item.buynumber);
										}
										this.user.money = this.user.money - item.price * item.buynumber;
										// 更新用户余额
										layui.http.requestJson(`${localStorage.getItem("userTable")}/update`, 'post', this.user, (res) => {
											order.status = '已支付'
											layui.http.request(`orders/list`, 'get', {
												orderid: orderId,
												page: 1,
												limit: 1,
											}, (res) => {
												order.id = res.data.list[0].id;
												layui.http.requestJson(`orders/update`, 'post', order, (res) => {
													layui.layer.msg('购买成功', {
														time: 2000,
														icon: 6
													}, function() {
														window.location.href='../shop-order/list.jsp'
													});
												});
											});
										});
									})
								})
							});
						}
					},
                    //选座沙箱支付
					xuanzuoAlipayClick() {
						console.log('xuanzuoClick')
						// 生成订单
						for (let item of this.dataList) {
							// 订单编号
							var orderId = genTradeNo();
							// 获取商品详情信息
							layui.http.request(`${item.tablename}/info/${item.goodid}`, 'get', {}, (res) => {
								let data = res.data;
								// 减少库存
								data.alllimittimes = data.alllimittimes - item.buynumber;
								// 获取已经被预定的座位号
                                let selectArray = data.selected?data.selected.split(','):[];
								// 获取用户预定的座位号
								let activeArray = item.address.split(',');
								// 新的预定座位号
								let newSelectArray = selectArray.concat(activeArray);
								// 赋值给参数
								data.selected = newSelectArray.join(',');
								// 更新库存,座位信息
								layui.http.requestJson(`${item.tablename}/update`, 'post', data, (res) => {
									// 添加订单信息
									let order = {
										orderid: orderId,
										tablename: item.tablename,
										userid: this.user.id,
										goodid: item.goodid,
										goodname: item.goodname,
										shangjiamingcheng: item.shangjiamingcheng,
                                        goodtype: item.goodtype, 
										picture: item.picture,
										buynumber: item.buynumber,
										discountprice: item.price,
										price: item.price,
										total: item.total,
										discounttotal: item.total,
										type: 1,
										address: item.address,
										status: '未支付'
									}
                                    layui.http.requestJson(`orders/add`, 'post', order, (res) => {
                                        layui.http.request(`orders/alipay`, 'get',{"tradeno":order.orderid,"totalamount":order.total,"subject":order.goodname}, (res) => {
                                            if(res.code == 0){
                                                var newWin = window.open('_blank');
                                                newWin.document.querySelector('body').innerHTML = res.data;
                                                const div = document.createElement('div') // 创建div
                                                div.innerHTML = res.data // 将返回的form 放入div
                                                newWin.document.body.appendChild(div)
                                                newWin.document.forms[0].submit()
                                            }
                                        });
                                    })
								})
							});
						}
					},
				}
			})

			layui.use(['layer', 'element', 'carousel', 'http', 'jquery', 'form', 'upload'], function() {
				var layer = layui.layer;
				var element = layui.element;
				var carousel = layui.carousel;
				var http = layui.http;
				var jquery = layui.jquery;
				var form = layui.form;
				var upload = layui.upload;
				vue.baseurl = http.baseurl;

				// 订单类型，2则是积分兑换，其他是正常下单
				vue.type = http.getParam('type');
				// 订单类型，seat存在值则是选座下单，否则是其他类型
				vue.seat = http.getParam('seat');

				// 充值
				jquery('#btn-recharge').click(function(e) {
					layer.open({
						type: 2,
						title: '用户充值',
						area: ['900px', '600px'],
						content: '../shop-recharge/recharge.jsp'
					});
				});

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
									'<img class="swiper-item" src="' + http.baseurl+item.value + '">' +
									'</div>';
							}
						}
						jquery('#swiper-item').html(swiperItemHtml);
						// 轮播图
						carousel.render({
							elem: '#swiper',
							width: swiper.width,height:swiper.height,
							arrow: swiper.arrow,
							anim: swiper.anim,
							interval: swiper.interval,
							indicator: "none"
						});
					}
				});

				// 获取地址数据
				http.request('address/page', 'get', {
					userid: localStorage.getItem('userid')
				}, function(res) {
					vue.addressList = res.data.list
				})

				// 获取商品购买的清单列表
				var orderGoods = localStorage.getItem('orderGoods')
				// 转换成json类型，localstorage保存的是string数据
				vue.dataList = JSON.parse(orderGoods);

				// 用户当前用户信息
				let table = localStorage.getItem("userTable");
                if(table) {
                    http.request(`${table}/session`, 'get', {}, function(data) {
                        vue.user = data.data;
                    });
                }

			});
		</script>
	</body>
</html>
