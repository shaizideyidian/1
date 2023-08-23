<template>
	<div class="addEdit-block" :style='{"padding":"30px 0 0 0"}' style="width: 100%;">
		<el-form
			:style='{"padding":"20px 0px 120px"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="140px"
		>
			<template >
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="select" v-if="type!='info'" label="小区名称" prop="xiaoqumingcheng">
					<el-select :disabled="ro.xiaoqumingcheng" @change="xiaoqumingchengChange" v-model="ruleForm.xiaoqumingcheng" placeholder="请选择小区名称">
						<el-option
							v-for="(item,index) in xiaoqumingchengOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-else-if="ruleForm.xiaoqumingcheng" label="小区名称" prop="xiaoqumingcheng">
					<el-input v-model="ruleForm.xiaoqumingcheng" placeholder="小区名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-if="type!='info'"  label="小区类型" prop="xiaoquleixing">
					<el-input v-model="ruleForm.xiaoquleixing" placeholder="小区类型" clearable  :readonly="ro.xiaoquleixing"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label="小区类型" prop="xiaoquleixing">
					<el-input v-model="ruleForm.xiaoquleixing" placeholder="小区类型" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-if="type!='info'"  label="小区位置" prop="xiaoquweizhi">
					<el-input v-model="ruleForm.xiaoquweizhi" placeholder="小区位置" clearable  :readonly="ro.xiaoquweizhi"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label="小区位置" prop="xiaoquweizhi">
					<el-input v-model="ruleForm.xiaoquweizhi" placeholder="小区位置" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-if="type!='info'"  label="房屋名称" prop="fangwumingcheng">
					<el-input v-model="ruleForm.fangwumingcheng" placeholder="房屋名称" clearable  :readonly="ro.fangwumingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label="房屋名称" prop="fangwumingcheng">
					<el-input v-model="ruleForm.fangwumingcheng" placeholder="房屋名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="upload" v-if="type!='info' && !ro.fangwutupian" label="房屋图片" prop="fangwutupian">
					<file-upload
						tip="点击上传房屋图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.fangwutupian?ruleForm.fangwutupian:''"
						@change="fangwutupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="upload" v-else-if="ruleForm.fangwutupian" label="房屋图片" prop="fangwutupian">
					<img v-if="ruleForm.fangwutupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.fangwutupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.fangwutupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-if="type!='info'"  label="房屋楼号" prop="fangwulouhao">
					<el-input v-model="ruleForm.fangwulouhao" placeholder="房屋楼号" clearable  :readonly="ro.fangwulouhao"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label="房屋楼号" prop="fangwulouhao">
					<el-input v-model="ruleForm.fangwulouhao" placeholder="房屋楼号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-if="type!='info'"  label="房屋房号" prop="fangwufanghao">
					<el-input v-model="ruleForm.fangwufanghao" placeholder="房屋房号" clearable  :readonly="ro.fangwufanghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label="房屋房号" prop="fangwufanghao">
					<el-input v-model="ruleForm.fangwufanghao" placeholder="房屋房号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-if="type!='info'"  label="建筑面积" prop="jianzhumianji">
					<el-input v-model="ruleForm.jianzhumianji" placeholder="建筑面积" clearable  :readonly="ro.jianzhumianji"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label="建筑面积" prop="jianzhumianji">
					<el-input v-model="ruleForm.jianzhumianji" placeholder="建筑面积" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-if="type!='info'"  label="房屋租金" prop="fangwuzujin">
					<el-input v-model="ruleForm.fangwuzujin" placeholder="房屋租金" clearable  :readonly="ro.fangwuzujin"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label="房屋租金" prop="fangwuzujin">
					<el-input v-model="ruleForm.fangwuzujin" placeholder="房屋租金" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="select" v-if="type!='info'"  label="房屋状态" prop="fangwuzhuangtai">
					<el-select :disabled="ro.fangwuzhuangtai" v-model="ruleForm.fangwuzhuangtai" placeholder="请选择房屋状态" >
						<el-option
							v-for="(item,index) in fangwuzhuangtaiOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label="房屋状态" prop="fangwuzhuangtai">
					<el-input v-model="ruleForm.fangwuzhuangtai"
						placeholder="房屋状态" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="upload" v-if="type!='info'&& !ro.biaogewenjian" label="表格文件" prop="biaogewenjian">
					<file-upload
						tip="点击上传表格文件"
						action="file/upload"
						:limit="1"
						:multiple="true"
						:fileUrls="ruleForm.biaogewenjian?ruleForm.biaogewenjian:''"
						@change="biaogewenjianUploadChange"
					></file-upload>
				</el-form-item>  
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else-if="ruleForm.biaogewenjian" label="表格文件" prop="biaogewenjian">
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 15px","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#797979","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="text" size="small" @click="download($base.url+ruleForm.biaogewenjian)">下载</el-button>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else-if="!ruleForm.biaogewenjian" label="表格文件" prop="biaogewenjian">
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 15px","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#797979","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="text" size="small">无</el-button>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="date" v-if="type!='info'" label="发布日期" prop="faburiqi">
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.faburiqi" 
						type="date"
						:readonly="ro.faburiqi"
						placeholder="发布日期"
					></el-date-picker> 
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-else-if="ruleForm.faburiqi" label="发布日期" prop="faburiqi">
					<el-input v-model="ruleForm.faburiqi" placeholder="发布日期" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-if="type!='info'"  label="登记信息" prop="dengjixinxi">
					<editor 
						style="min-width: 200px; max-width: 600px;"
						v-model="ruleForm.dengjixinxi" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else-if="ruleForm.dengjixinxi" label="登记信息" prop="dengjixinxi">
                    <span :style='{"fontSize":"14px","lineHeight":"40px","color":"#333","fontWeight":"500","display":"inline-block"}' v-html="ruleForm.dengjixinxi"></span>
                </el-form-item>
			<el-form-item :style='{"padding":"0","margin":"0"}' class="btn">
				<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"40px","background":"rgba(27, 167, 166, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
				<el-button :style='{"border":"1px solid rgba(27, 167, 166, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"rgba(27, 167, 166, 1)","borderRadius":"40px","background":"rgba(255, 255, 255, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
				<el-button :style='{"border":"1px solid rgba(27, 167, 166, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"rgba(27, 167, 166, 1)","borderRadius":"40px","background":"rgba(255, 255, 255, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("请输入正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("请输入正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("请输入正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("请输入正确的邮箱地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				xiaoqumingcheng : false,
				xiaoquleixing : false,
				xiaoquweizhi : false,
				fangwumingcheng : false,
				fangwutupian : false,
				fangwulouhao : false,
				fangwufanghao : false,
				jianzhumianji : false,
				fangwuzujin : false,
				fangwuzhuangtai : false,
				biaogewenjian : false,
				dengjixinxi : false,
				faburiqi : false,
			},
			
			
			ruleForm: {
				xiaoqumingcheng: '',
				xiaoquleixing: '',
				xiaoquweizhi: '',
				fangwumingcheng: '',
				fangwutupian: '',
				fangwulouhao: '',
				fangwufanghao: '',
				jianzhumianji: '',
				fangwuzujin: '',
				fangwuzhuangtai: '未申请',
				biaogewenjian: '',
				dengjixinxi: '',
				faburiqi: '',
			},
		
			xiaoqumingchengOptions: [],
			fangwuzhuangtaiOptions: [],
			
			rules: {
				xiaoqumingcheng: [
					{ required: true, message: '小区名称不能为空', trigger: 'blur' },
				],
				xiaoquleixing: [
				],
				xiaoquweizhi: [
				],
				fangwumingcheng: [
					{ required: true, message: '房屋名称不能为空', trigger: 'blur' },
				],
				fangwutupian: [
				],
				fangwulouhao: [
				],
				fangwufanghao: [
				],
				jianzhumianji: [
				],
				fangwuzujin: [
					{ required: true, message: '房屋租金不能为空', trigger: 'blur' },
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				fangwuzhuangtai: [
					{ required: true, message: '房屋状态不能为空', trigger: 'blur' },
				],
				biaogewenjian: [
				],
				dengjixinxi: [
				],
				faburiqi: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
		this.ruleForm.faburiqi = this.getCurDate()
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='xiaoqumingcheng'){
							this.ruleForm.xiaoqumingcheng = obj[o];
							this.ro.xiaoqumingcheng = true;
							continue;
						}
						if(o=='xiaoquleixing'){
							this.ruleForm.xiaoquleixing = obj[o];
							this.ro.xiaoquleixing = true;
							continue;
						}
						if(o=='xiaoquweizhi'){
							this.ruleForm.xiaoquweizhi = obj[o];
							this.ro.xiaoquweizhi = true;
							continue;
						}
						if(o=='fangwumingcheng'){
							this.ruleForm.fangwumingcheng = obj[o];
							this.ro.fangwumingcheng = true;
							continue;
						}
						if(o=='fangwutupian'){
							this.ruleForm.fangwutupian = obj[o];
							this.ro.fangwutupian = true;
							continue;
						}
						if(o=='fangwulouhao'){
							this.ruleForm.fangwulouhao = obj[o];
							this.ro.fangwulouhao = true;
							continue;
						}
						if(o=='fangwufanghao'){
							this.ruleForm.fangwufanghao = obj[o];
							this.ro.fangwufanghao = true;
							continue;
						}
						if(o=='jianzhumianji'){
							this.ruleForm.jianzhumianji = obj[o];
							this.ro.jianzhumianji = true;
							continue;
						}
						if(o=='fangwuzujin'){
							this.ruleForm.fangwuzujin = obj[o];
							this.ro.fangwuzujin = true;
							continue;
						}
						if(o=='fangwuzhuangtai'){
							this.ruleForm.fangwuzhuangtai = obj[o];
							this.ro.fangwuzhuangtai = true;
							continue;
						}
						if(o=='biaogewenjian'){
							this.ruleForm.biaogewenjian = obj[o];
							this.ro.biaogewenjian = true;
							continue;
						}
						if(o=='dengjixinxi'){
							this.ruleForm.dengjixinxi = obj[o];
							this.ro.dengjixinxi = true;
							continue;
						}
						if(o=='faburiqi'){
							this.ruleForm.faburiqi = obj[o];
							this.ro.faburiqi = true;
							continue;
						}
				}
				










				this.ruleForm.fangwuzhuangtai='未申请'



			}
			
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
					if(this.$storage.get("role")!="管理员") {
						this.ro.xiaoquleixing = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.xiaoquweizhi = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.faburiqi = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
			
            this.$http({
				url: `option/xiaoquxinxi/xiaoqumingcheng`,
				method: "get"
            }).then(({ data }) => {
				if (data && data.code === 0) {
					this.xiaoqumingchengOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
            });
            this.fangwuzhuangtaiOptions = "已申请,未申请".split(',')
			
		},
			// 下二随
			xiaoqumingchengChange () {
				this.$http({
					url: `follow/xiaoquxinxi/xiaoqumingcheng?columnValue=`+ this.ruleForm.xiaoqumingcheng,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						if(data.data.xiaoquleixing){
							this.ruleForm.xiaoquleixing = data.data.xiaoquleixing
						}
						if(data.data.xiaoquweizhi){
							this.ruleForm.xiaoquweizhi = data.data.xiaoquweizhi
						}
					} else {
						this.$message.error(data.msg);
					}
				});
			},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `fangwuxinxi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        this.ruleForm.dengjixinxi = this.ruleForm.dengjixinxi.replace(reg,'../../../springboot3e655/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {










	if(this.ruleForm.fangwutupian!=null) {
		this.ruleForm.fangwutupian = this.ruleForm.fangwutupian.replace(new RegExp(this.$base.url,"g"),"");
	}












	if(this.ruleForm.biaogewenjian!=null) {
		this.ruleForm.biaogewenjian = this.ruleForm.biaogewenjian.replace(new RegExp(this.$base.url,"g"),"");
	}





var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = { 
				page: 1, 
				limit: 10, 
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			} 
			this.$http({ 
				url: "fangwuxinxi/page", 
				method: "get", 
				params: params 
			}).then(({ 
				data 
			}) => { 
				if (data && data.code === 0) { 
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `fangwuxinxi/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.fangwuxinxiCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else { 
				} 
			});
		 } else {
			 this.$http({
			   url: `fangwuxinxi/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.fangwuxinxiCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
			   }
			 });
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.fangwuxinxiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    fangwutupianUploadChange(fileUrls) {
	    this.ruleForm.fangwutupian = fileUrls;
    },
    biaogewenjianUploadChange(fileUrls) {
	    this.ruleForm.biaogewenjian = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #333;
	  	  width: 140px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 140px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 300px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 0 10px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 0 10px 0 30px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  	  border: 2px dashed #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  width: 150px;
	  	  font-size: 32px;
	  	  line-height: 150px;
	  	  text-align: center;
	  	  height: 150px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 2px dashed #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  width: 150px;
	  	  font-size: 32px;
	  	  line-height: 150px;
	  	  text-align: center;
	  	  height: 150px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 2px dashed #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  width: 150px;
	  	  font-size: 32px;
	  	  line-height: 150px;
	  	  text-align: center;
	  	  height: 150px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 12px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 120px;
	  	}
</style>
