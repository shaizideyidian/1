<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
	<%@ include file="../../static/head.jsp"%>
	<link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css" rel="stylesheet">
	<script type="text/javascript" charset="utf-8">
	    window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
	</script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
  	<style>
		label.error{
			color: red !important;
			width: auto !important;
		}
	</style>
<body>
	<div id="main-container">
		<!-- Top Navigation -->
		<%@ include file="../../static/topNav.jsp"%>
		
		<!-- Menu -->
		<div id="menu-container" class="navbar">
			<ul class="navbar-nav navbar-vertical" id="navUl">
				
			</ul>
		</div>
		<!-- /Menu -->
		
		<!-- Breadcrumb -->
		<div id="breadcrumb-container">
			<h3 class="breadcrumb-title">编辑宠物商品</h3>
			<ol class="breadcrumb-list">
				<li class="breadcrumb-item-home">
					<a href="#">
						<span class="ti-home"></span>
					</a>
				</li>
				<li class="breadcrumb-item-one"><span>宠物商品管理</span></li>
				<li class="breadcrumb-item-two"><span>编辑宠物商品</span></li>
			</ol>
		</div>

		<!-- Main Content -->
		<div id="add-container">
			<form id="addOrUpdateForm">
				<input id="updateId" name="id" type="hidden">
				<div class="form-item">
					<label>商品名称</label>
					<input name="shangpinmingcheng" id="shangpinmingcheng" name="shangpinmingcheng" class="form-control" placeholder="请输入商品名称">
				</div>
				<div class="form-item">
					<label>商品分类</label>
					<select id="shangpinfenleiSelect" name="shangpinfenlei" class="form-control">
							<option value="">请选择商品分类</option>
					</select>	
				</div>	
				<div class="form-item-img">
					<label>商品图片</label>
                    <div style="display: flex;align-items: center;">
                        <div v-for="(item,index) in shangpintupianImgList" :key="index" style="position: relative;">
                            <div style="position: absolute;right: 10px;top: 0;width: 32px;height: 32px;background: #fff;padding: 6px;font-size: 0;cursor: pointer;border-radius: 0 20px 0 0;" @click="shangpintupianDelClick(index)">
                                <img src="../../../resources/images/shanchu.png" style="width: 20px;height: 20px;margin: 0;box-shadow: none;min-height:20px">
                            </div>
                            <img :src="baseUrl + item" width="100" height="100">
                        </div>
                    </div>
					<div class="upload btn-img">选择文件<input name="file" type="file" id="shangpintupianupload" class="form-control-file"></div>
					<input name="shangpintupian" id="shangpintupian-input" type="hidden">
				</div>
				<div class="form-item">
					<label>商品规格</label>
					<input name="shangpinguige" id="shangpinguige" name="shangpinguige" class="form-control" placeholder="请输入商品规格">
				</div>
				<div class="form-item">
					<label>商品品牌</label>
					<input name="shangpinpinpai" id="shangpinpinpai" name="shangpinpinpai" class="form-control" placeholder="请输入商品品牌">
				</div>
				<div class="form-item">
					<label>商品折扣</label>
					<select id="shangpinzhekouSelect" name="shangpinzhekou" class="form-control">
							<option value="">请选择商品折扣</option>
							<option class="shangpinzhekouOption" value="是">
								是
							</option>
							<option class="shangpinzhekouOption" value="否">
								否
							</option>
					</select>	
				</div>	
				<div class="form-item">
					<label>商家名称</label>
					<input name="shangjiamingcheng" id="shangjiamingcheng" name="shangjiamingcheng" class="form-control" placeholder="请输入商家名称">
				</div>
				<div class="form-item">
					<label>商家地址</label>
					<input name="shangjiadizhi" id="shangjiadizhi" name="shangjiadizhi" class="form-control" placeholder="请输入商家地址">
				</div>
				<div class="form-item">
					<label>单限</label>
					<input name="onelimittimes" id="onelimittimes" name="onelimittimes" class="form-control" placeholder="请输入单限">
				</div>
				<div class="form-item">
					<label>库存</label>
					<input name="alllimittimes" id="alllimittimes" name="alllimittimes" class="form-control" placeholder="请输入库存">
				</div>
				<div class="form-item">
					<label>价格</label>
					<input id="price" type="number" name="price" class="form-control" placeholder="价格">
				</div>	
				<div class="form-item">
					<label>会员价</label>
					<input id="vipprice" name="vipprice" type="number" class="form-control" placeholder="会员价">
				</div>	
										
				<div class="form-item-file" >
					<label>商品详情</label>
					<div class="upload btn-file">
						插入图片
						<input id="shangpinxiangqingupload" name="file" type="file">
					</div>
					<script id="shangpinxiangqingEditor" type="text/plain"></script>
					<script type="text/javascript">
						//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
					   //相见文档配置属于你自己的编译器
					 var shangpinxiangqingUe = UE.getEditor('shangpinxiangqingEditor', {
						toolbars: [
							[
								'undo', //撤销
								'bold', //加粗
								'redo', //重做
								'underline', //下划线
								'horizontal', //分隔线
								'inserttitle', //插入标题
								'cleardoc', //清空文档
								'fontfamily', //字体
								'fontsize', //字号
								'paragraph', //段落格式
								'inserttable', //插入表格
								'justifyleft', //居左对齐
								'justifyright', //居右对齐
								'justifycenter', //居中对
								'justifyjustify', //两端对齐
								'forecolor', //字体颜色
								'fullscreen', //全屏
								'edittip ', //编辑提示
								'customstyle', //自定义标题
								 ]
							]
						});
					</script>
					<input type="hidden" name="shangpinxiangqing" id="shangpinxiangqing-input">
				</div>
				<div class="form-btn">
					<button  id="submitBtn" type="button" class="btn btn-primary btn-add">提交</button>
					<button id="exitBtn" type="button" class="btn btn-primary btn-close">取消</button>
				</div>
			</form>
		</div>
	</div>
	
	<!-- Back to Top -->
	<a id="back-to-top" href="#" class="back-to-top">Top</a>
	<!-- /Back to Top -->
	
	<%@ include file="../../static/foot.jsp"%>
	<script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js"></script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/js/validate/messages_zh.js"></script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/js/validate/card.js"></script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
	<script>
		<%@ include file="../../utils/menu.jsp"%>
		<%@ include file="../../static/setMenu.js"%>
		<%@ include file="../../static/utils.js"%>
		<%@ include file="../../utils/baseUrl.jsp"%>   	

		var tableName = "chongwushangpin";
		var pageType = "add-or-update";
		var updateId = "";
		var crossTableId = -1;
		var crossTableName = '';
		var ruleForm = {};
		var crossRuleForm = {};

		var shangpinfenleiOptions = [];


		function shangpinfenleiSelect(){
			http("option/shangpinfenlei/shangpinfenlei","GET",{},(res)=>{
				if(res.code == 0){
					shangpinfenleiOptions = res.data;
					var shangpinfenleiSelect = document.getElementById('shangpinfenleiSelect');
					for(var i=0;i<shangpinfenleiOptions.length;i++){
						var shangpinfenleiOption = document.createElement('option');
						shangpinfenleiOption.setAttribute('name','shangpinfenleiOption');
						shangpinfenleiOption.setAttribute('value',shangpinfenleiOptions[i]);
						shangpinfenleiOption.innerHTML = shangpinfenleiOptions[i];									
						if(ruleForm.shangpinfenlei == shangpinfenleiOptions[i]){
							shangpinfenleiOption.setAttribute('selected','selected');
						}
						shangpinfenleiSelect.appendChild(shangpinfenleiOption);
					}
				}
			});
		}	

		var ruleForm = {};
		var vm = new Vue({
		  el: '#addOrUpdateForm',
		  data:{
			  ruleForm : {},
              shangpintupianImgList:[],
              baseUrl:baseUrl,
			},
		  beforeCreate: function(){
			  var id = window.sessionStorage.getItem("id");
				if(id != null && id != "" && id != "null"){
					$.ajax({ 
		                type: "GET",
		                url: baseUrl + "chongwushangpin/info/" + id,
		                beforeSend: function(xhr) {xhr.setRequestHeader("token", window.sessionStorage.getItem('token'));},
		                success: function(res){               	
		                	if(res.code == 0){
		                		vm.ruleForm = res.data;
				    		}else if(res.code == 401) {
				    			<%@ include file="../../static/toLogin.jsp"%>    
				    		}else{ alert(res.msg)}
		                },
		            });
				}
			},
			methods: { 
                shangpintupianDelClick(index){
                    var mymessage = confirm("确定移除图片？");
                    if (mymessage == true) {
                        this.shangpintupianImgList.splice(index,1)  
                    }
                    
                },
            }
	  	});		

		// 文件上传
		function upload(){
			$('#shangpintupianupload').fileupload({
				url: baseUrl + 'file/upload',
				headers:{ token: window.sessionStorage.getItem("token")},
				dataType: 'json',
				done: function (e, data) {				
					document.getElementById('shangpintupian-input').setAttribute('value',"upload/"+data.result.file);
					if(document.getElementById('shangpintupianFileName') != null){
						document.getElementById('shangpintupianFileName').innerHTML = "上传成功!";
					}				
                    vm.shangpintupianImgList.push("upload/"+data.result.file)
				}
			});
			$('#shangpinxiangqingupload').fileupload({
				url: baseUrl + 'file/upload',
				headers:{ token: window.sessionStorage.getItem("token")},
				dataType: 'json',
				done: function (e, data) {	
					UE.getEditor('shangpinxiangqingEditor').execCommand('insertHtml','<img src=\"'+ baseUrl +'upload/'+ data.result.file + '\" width=900 height=560>');					
				}
			});
		}  
		//取消 
		function cancel() {
            window.location.href = "list.jsp";
		}
		function getQueryString(name) { 
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
			var r = window.location.search.substr(1).match(reg); 
			if (r != null) return unescape(r[2]); 
			return null; 
		}

		// 表单提交
		function submit() {

			var crossFlag = getQueryString("cross");
			if(validform() ==true && compare() == true){
				if(crossFlag) {
				}
				let data = {};
				getContent();
				let value = $('#addOrUpdateForm').serializeArray();
				$.each(value, function (index, item) { 
							data[item.name] = item.value;
						});
                if(vm.shangpintupianImgList.length){
                    data.shangpintupian = vm.shangpintupianImgList.join(',')
                }
				let json = JSON.stringify(data);
				var urlParam;
				var successMes = '';
				if(updateId!=null && updateId!="null" && updateId!=''){
					urlParam = 'update';
					successMes = '修改成功';
				}else{		
					urlParam = 'save';
					successMes = '添加成功';
				}
				//更新跨表属性
			       var crossuserid;
			       var crossrefid;
			       var crossoptnum;
				if(crossFlag) {
					var statusColumnName = window.sessionStorage.getItem('statusColumnName'); 
					var statusColumnValue = window.sessionStorage.getItem('statusColumnValue'); 
					var obj = JSON.parse(window.sessionStorage.getItem('crossObj'));
					if(statusColumnName!='') {
						if(!statusColumnName.startsWith("[")) {
							for (var o in obj){
								if(o==statusColumnName){
									obj[o] = statusColumnValue;
								}
							}
							var table = window.sessionStorage.getItem('crossTableName');
							httpJson(crossTableName + "/update","POST",obj,(res)=>{
								if(res.code == 0){
									console.log('更新属性成功');
								}
							});   
						} else  {
							crossuserid = Number(window.sessionStorage.getItem('userid'));
							crossrefid = obj["id"];
							crossoptnum = window.sessionStorage.getItem('statusColumnName');
							crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
						}
					}
				}
				if(crossrefid && crossuserid) {
					data.crossuserid=crossuserid;
					data.crossrefid=crossrefid;
					http("chongwushangpin/page","GET",{
						page:1,
						limit:10,
						crossuserid:data.crossuserid,
						crossrefid:data.crossrefid,			
					},(res)=>{
						if(res.data.total >= crossoptnum){
							alert(window.sessionStorage.getItem('tips'));
							return false;
						} else {
							httpJson("chongwushangpin/"+urlParam,"POST",data,(res)=>{
								if(res.code == 0){
									window.sessionStorage.removeItem('id');
									let flag = true;
									if(crossFlag) {
									}

									if(flag){
										alert(successMes);
									}
									if(window.sessionStorage.getItem('onlyme') != null && window.sessionStorage.getItem('onlyme') == "true"){
										window.sessionStorage.removeItem('onlyme');
										window.location.href="${pageContext.request.contextPath}/index.jsp";
									}else{
                                        window.location.href = "list.jsp";
									}
									
								}
							});
						}
					});
				} else {
					httpJson("chongwushangpin/"+urlParam,"POST",data,(res)=>{
						if(res.code == 0){
							window.sessionStorage.removeItem('id');
							let flag = true;
							if(crossFlag) {
							}

							if(flag){
								alert(successMes);
							}
							if(window.sessionStorage.getItem('onlyme') != null && window.sessionStorage.getItem('onlyme') == "true"){
								window.sessionStorage.removeItem('onlyme');
								window.location.href="${pageContext.request.contextPath}/index.jsp";
							}else{
                                        window.location.href = "list.jsp";
							}
							
						}
					});
				}
			}else{
				alert("表单未填完整或有错误");
			}
		}

		// 填充富文本框
		function setContent(){
			if(ruleForm.shangpinxiangqing != null && ruleForm.shangpinxiangqing != 'null' && ruleForm.shangpinxiangqing != ''){
				var shangpinxiangqingMes = '' + ruleForm.shangpinxiangqing;
				var shangpinxiangqingUeditor = UE.getEditor('shangpinxiangqingEditor');
				shangpinxiangqingUeditor.ready(function() {
					shangpinxiangqingUeditor.setContent(shangpinxiangqingMes);
				});
			}
		}  

		// 获取富文本框内容
		function getContent(){
			if(UE.getEditor('shangpinxiangqingEditor').hasContents()){
				$('#shangpinxiangqing-input').attr('value',UE.getEditor('shangpinxiangqingEditor').getContent());
			}
		}

		// 表单校验
		function validform() {
			return $("#addOrUpdateForm").validate({ 
				rules: {
				    shangpinmingcheng: {
					required: true,
					},
				    shangpinfenlei: {
					required: true,
					},
				    shangpintupian: {
					},
				    shangpinguige: {
					},
				    shangpinpinpai: {
					},
				    shangpinzhekou: {
					required: true,
					},
				    shangpinxiangqing: {
					},
				    shangjiamingcheng: {
					},
				    shangjiadizhi: {
					},
				    onelimittimes: {
					digits: true,
					},
				    alllimittimes: {
					digits: true,
					},
				    clicktime: {
					},
				    price: {
					required: true,
					number: true,
					},
				    vipprice: {
					number: true,
					},
				},
				messages: {
					shangpinfenlei: {
						required: "商品分类不能为空",
					},
					shangpintupian: {
					},
					shangpinguige: {
					},
					shangpinpinpai: {
					},
					shangpinzhekou: {
						required: "商品折扣不能为空",
					},
					shangpinxiangqing: {
					},
					shangjiamingcheng: {
					},
					shangjiadizhi: {
					},
					onelimittimes: {
						digits: "请输入整数",
					},
					alllimittimes: {
						digits: "请输入整数",
					},
					clicktime: {
					},
					price: {
						required: "价格不能为空",
					},
					vipprice: {
						number: "请输入数字",	
					},
				}
			}).form();
		}
		// 添加表单校验方法
		function addValidation(){
			jQuery.validator.addMethod("isPhone", function(value, element) {
					var length = value.length;
					var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(19[0-9]{1})|(17[0-9]{1}))+\d{8})$/;
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
		// 获取当前详情
		function getDetails() {
			var id = window.sessionStorage.getItem("id");
			if(id != null && id != "" && id != "null"){
				updateId = id;
				window.sessionStorage.removeItem('id');
				http("chongwushangpin/info/" + id,"GET",{},(res)=>{
					if(res.code == 0){
						ruleForm = res.data
						// 是/否下拉框回显
						setSelectOption();
						// 设置图片src
						showImg();
						// 数据填充
						dataBind();
						// 富文本框回显	
						setContent();
												shangpinfenleiSelect();
						//注册表单验证
						$(validform());	
					}
				});
			}else{
				shangpinfenleiSelect();	

				var shangpinzhekouOptions = document.getElementsByClassName("shangpinzhekouOption");
				for(var shangpinzhekouCount = 0; shangpinzhekouCount < shangpinzhekouOptions.length;shangpinzhekouCount++){
					if(shangpinzhekouOptions[shangpinzhekouCount].getAttribute('value') == "是"){
						shangpinzhekouOptions[shangpinzhekouCount].setAttribute('selected','selected');
					}
				}
				$("#onelimittimes").val("-1");
				$("#alllimittimes").val("-1");


		 		fill()
				//注册表单验证
		    		$(validform());
			}
		}	
		// 下拉框选项回显
		function setSelectOption(){
		}			
		// 关联下拉框改变
		function lvSelectChange(level){
			let data = {};
			let value = $('#addOrUpdateForm').serializeArray();
			$.each(value, function (index, item) { 
			            data[item.name] = item.value;
			        });
			
		}		
		// 清除可能会重复渲染的selection
		function clear(className){
			var elements = document.getElementsByClassName(className);
        	for(var i = elements.length - 1; i >= 0; i--) { 
        	  elements[i].parentNode.removeChild(elements[i]); 
        	}
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
			$("#clicktime-input").datetimepicker({ 
				autoclose: true,
				format:'yyyy-mm-dd hh:ii:00',
				minuteStep:1,
				language:'zh-CN',
			});

		}		
		
		function calculation(){
			//积
			var x = 0;
			//和
			var y = 0;
			var flag = 0;



		}		
		function calculationSE(colName){
			//单列求和接口
			http("chongwushangpin"+colName,"GET",{
				tableName: "chongwushangpin",
				columnName: colName
			},(res)=>{
				if(res.code == 0){
					$("#"+colName).attr("value",res.data);
				}
			});
		}	
		function calculationPre(){
			//进入该页面就填充"单列求和"的列
		}			
		
		
			//新增时填充字段
			function fill(){
				var username = window.sessionStorage.getItem('username');
				var accountTableName = window.sessionStorage.getItem('accountTableName');
				http(accountTableName+'/session','GET',{},(res)=>{
					if(res.code == 0){
						var myId = res.data.id;
						if(res.data !=null && res.data.shangjiamingcheng != null && res.data.shangjiamingcheng != ''){
							$('#shangjiamingcheng').val(res.data.shangjiamingcheng)
							$("#shangjiamingcheng").attr('readonly','readonly');
						}
						if(res.data !=null && res.data.shangjiadizhi != null && res.data.shangjiadizhi != ''){
							$('#shangjiadizhi').val(res.data.shangjiadizhi)
							$("#shangjiadizhi").attr('readonly','readonly');
						}
						$(validform());
					}
				});
							
			}	
			
		function dataBind(){
			$("#updateId").val(ruleForm.id);	
			$("#shangpinmingcheng").val(ruleForm.shangpinmingcheng);	
			var shangpinfenleiOptions = document.getElementsByClassName("shangpinfenleiOption");
			for(var shangpinfenleiCount = 0; shangpinfenleiCount < shangpinfenleiOptions.length;shangpinfenleiCount++){
				if(shangpinfenleiOptions[shangpinfenleiCount].getAttribute('value') == ruleForm.shangpinfenlei){
					shangpinfenleiOptions[shangpinfenleiCount].setAttribute('selected','selected');
				}
			}
            if(ruleForm.shangpintupian){
                vm.shangpintupianImgList = ruleForm.shangpintupian.split(',')
            }
			$("#shangpintupian-input").val(ruleForm.shangpintupian);
			$("#shangpinguige").val(ruleForm.shangpinguige);	
			$("#shangpinpinpai").val(ruleForm.shangpinpinpai);	
			var shangpinzhekouOptions = document.getElementsByClassName("shangpinzhekouOption");
			for(var shangpinzhekouCount = 0; shangpinzhekouCount < shangpinzhekouOptions.length;shangpinzhekouCount++){
				if(shangpinzhekouOptions[shangpinzhekouCount].getAttribute('value') == ruleForm.shangpinzhekou){
					shangpinzhekouOptions[shangpinzhekouCount].setAttribute('selected','selected');
				}
			}
			$("#shangpinxiangqing").val(ruleForm.shangpinxiangqing);	
			$("#shangjiamingcheng").val(ruleForm.shangjiamingcheng);	
			$("#shangjiadizhi").val(ruleForm.shangjiadizhi);	
			$("#onelimittimes").val(ruleForm.onelimittimes);	
			$("#alllimittimes").val(ruleForm.alllimittimes);	
			$("#price").val(ruleForm.price);	
			$("#vipprice").val(ruleForm.vipprice);	
		}		
		//图片显示
		function showImg(){
			var shangpintupianFileName = "\"" + ruleForm.shangpintupian + "\"";
			$("#shangpintupianImg").attr("src",baseUrl+ruleForm.shangpintupian);
		}		
		//跨表

        //跨表
        function crossTable(){
		crossTableName = window.sessionStorage.getItem('crossTableName');
		crossTableId = window.sessionStorage.getItem('crossTableId');
		if(crossTableName != null && crossTableName != '' && crossTableId != null && crossTableId != '' && crossTableId != -1){
			http(crossTableName + "/info/" + crossTableId,"GET",{},(res)=>{
				if(res.code == 0){
					crossRuleForm = res.data;
					$('#updateId').val(crossTableId);
					if(res.data != null && res.data != '' && res.data.shangpinmingcheng != null && res.data.shangpinmingcheng != ''){

						$("#shangpinmingcheng").val(res.data.shangpinmingcheng);
						$("#shangpinmingcheng").attr('readonly','readonly');
					}
					if(res.data != null && res.data != '' && res.data.shangpinfenlei != null && res.data.shangpinfenlei != ''){

						var shangpinfenleiOptions = document.getElementsByClassName("shangpinfenleiOption");
						for(var shangpinfenleiCount = 0; shangpinfenleiCount < shangpinfenleiOptions.length;shangpinfenleiCount++){
							if(shangpinfenleiOptions[shangpinfenleiCount].getAttribute('value') == res.data.shangpinfenlei){
								shangpinfenleiOptions[shangpinfenleiCount].setAttribute('selected','selected');
							}
						}
					}
					if(res.data != null && res.data != '' && res.data.shangpintupian != null && res.data.shangpintupian != ''){

                        vm.shangpintupianImgList = res.data.shangpintupian.split(',')
					}
					if(res.data != null && res.data != '' && res.data.shangpinguige != null && res.data.shangpinguige != ''){

						$("#shangpinguige").val(res.data.shangpinguige);
						$("#shangpinguige").attr('readonly','readonly');
					}
					if(res.data != null && res.data != '' && res.data.shangpinpinpai != null && res.data.shangpinpinpai != ''){

						$("#shangpinpinpai").val(res.data.shangpinpinpai);
						$("#shangpinpinpai").attr('readonly','readonly');
					}
					if(res.data != null && res.data != '' && res.data.shangpinzhekou != null && res.data.shangpinzhekou != ''){

						var shangpinzhekouOptions = document.getElementsByClassName("shangpinzhekouOption");
						for(var shangpinzhekouCount = 0; shangpinzhekouCount < shangpinzhekouOptions.length;shangpinzhekouCount++){
							if(shangpinzhekouOptions[shangpinzhekouCount].getAttribute('value') == res.data.shangpinzhekou){
								shangpinzhekouOptions[shangpinzhekouCount].setAttribute('selected','selected');
							}
						}
					}
					if(res.data != null && res.data != '' && res.data.shangpinxiangqing != null && res.data.shangpinxiangqing != ''){

						$("#shangpinxiangqing").val(res.data.shangpinxiangqing);
                        var shangpinxiangqingMes = '' + res.data.shangpinxiangqing;
                        var shangpinxiangqingUeditor = UE.getEditor('shangpinxiangqingEditor');
                        shangpinxiangqingUeditor.ready(function() {
                            shangpinxiangqingUeditor.setContent(shangpinxiangqingMes);
                        });
					}
					if(res.data != null && res.data != '' && res.data.shangjiamingcheng != null && res.data.shangjiamingcheng != ''){

						$("#shangjiamingcheng").val(res.data.shangjiamingcheng);
						$("#shangjiamingcheng").attr('readonly','readonly');
					}
					if(res.data != null && res.data != '' && res.data.shangjiadizhi != null && res.data.shangjiadizhi != ''){

						$("#shangjiadizhi").val(res.data.shangjiadizhi);
						$("#shangjiadizhi").attr('readonly','readonly');
					}
					if(res.data != null && res.data != '' && res.data.onelimittimes != null && res.data.onelimittimes != ''){

						$("#onelimittimes").val(res.data.onelimittimes);
						$("#onelimittimes").attr('readonly','readonly');
					}
					if(res.data != null && res.data != '' && res.data.alllimittimes != null && res.data.alllimittimes != ''){

						$("#alllimittimes").val(res.data.alllimittimes);
						$("#alllimittimes").attr('readonly','readonly');
					}
					if(res.data != null && res.data != '' && res.data.clicktime != null && res.data.clicktime != ''){

					}
					if(res.data != null && res.data != '' && res.data.price != null && res.data.price != ''){

						$("#price").val(res.data.price);
						$("#price").attr('readonly','readonly');
					}
					if(res.data != null && res.data != '' && res.data.vipprice != null && res.data.vipprice != ''){

						$("#vipprice").val(res.data.vipprice);
						$("#vipprice").attr('readonly','readonly');
					}
				}
			});  
            }
		window.sessionStorage.removeItem('crossTableName');
		window.sessionStorage.removeItem('crossTableId');
        }
		
		//跨表更新字段
		function crossTableUpdate(){
			let flag = crossTableUpdateValidation();
			if(flag){
				httpJson(crossTableName + "/update","POST",{
					id: crossTableId,
				},(res)=>{
					if(res.code == 0){
						console.log('跨表更新成功');
						return true;
					}
				});   
			}
			return false;
		}

		//跨表更新前验证
		function crossTableUpdateValidation(){
			//防止减法导致库存负值
			return true;
		}
		$(document).ready(function() { 
			//设置右上角用户名
            $('.dropdown-menu h5').html(window.sessionStorage.getItem('username')+'('+window.sessionStorage.getItem('role')+')')
			//设置项目名
			$('.sidebar-header h3 a').html(projectName)
			//设置导航栏菜单
			setMenu();
			//初始化时间插件
			dateTimePick();
			//添加表单校验信息文本
			addValidation();
			getDetails();
			//初始化上传按钮
			upload();
			//单列求和
			calculationPre();
			//跨表
			crossTable();
			<%@ include file="../../static/myInfo.js"%>
			$('#submitBtn').on('click', function(e) {
			    e.preventDefault();
			    //console.log("点击了...提交按钮");
			    submit();
			});
			$('#exitBtn').on('click', function(e) {
			    cancel();
			});
			readonly();
		});		

		function readonly(){
            if(window.sessionStorage.getItem('role')!="管理员") {
				$('#money').attr('readonly','readonly');
            }
		}

		//比较大小
		function compare(){
			var largerVal = null;
			var smallerVal = null;
			if(largerVal !=null && smallerVal != null){
				if(parseInt(largerVal)<=parseInt(smallerVal)){
					alert(smallerName+'不能大于等于'+largerName);
					return false;
				}
			}
			return true;
		}


		// 用户登出
        <%@ include file="../../static/logout.jsp"%>		
	</script>
</body>

</html>
