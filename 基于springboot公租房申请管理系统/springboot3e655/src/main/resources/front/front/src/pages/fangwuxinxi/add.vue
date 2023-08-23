<template>
<div :style='{"border":"1px solid #eee","padding":"20px","boxShadow":"0px 0px 0px #ccc,inset 0px 0px 0px 0px #eee","margin":"20px auto 0","borderRadius":"4px","background":"#fff","width":"1200px","position":"relative"}'>
    <el-form
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
          <el-form-item :style='{"border":"0px solid #dfdfdf","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"none"}' label="小区名称" prop="xiaoqumingcheng">
            <el-select  @change="xiaoqumingchengChange" v-model="ruleForm.xiaoqumingcheng" placeholder="请选择小区名称">
              <el-option
                  v-for="(item,index) in xiaoqumingchengOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"border":"0px solid #dfdfdf","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"none"}' label="小区类型" prop="xiaoquleixing">
            <el-input v-model="ruleForm.xiaoquleixing" 
                placeholder="小区类型" clearable readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"0px solid #dfdfdf","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"none"}' label="小区位置" prop="xiaoquweizhi">
            <el-input v-model="ruleForm.xiaoquweizhi" 
                placeholder="小区位置" clearable readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"0px solid #dfdfdf","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"none"}' label="房屋名称" prop="fangwumingcheng">
            <el-input v-model="ruleForm.fangwumingcheng" 
                placeholder="房屋名称" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"0px solid #dfdfdf","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"none"}' label="房屋图片" v-if="type!='cross' || (type=='cross' && !ro.fangwutupian)" prop="fangwutupian">
            <file-upload
            tip="点击上传房屋图片"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.fangwutupian?ruleForm.fangwutupian:''"
            @change="fangwutupianUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"border":"0px solid #dfdfdf","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"none"}' class="upload" v-else label="房屋图片" prop="fangwutupian">
                <img v-if="ruleForm.fangwutupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.fangwutupian.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.fangwutupian.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"border":"0px solid #dfdfdf","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"none"}' label="房屋楼号" prop="fangwulouhao">
            <el-input v-model="ruleForm.fangwulouhao" 
                placeholder="房屋楼号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"0px solid #dfdfdf","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"none"}' label="房屋房号" prop="fangwufanghao">
            <el-input v-model="ruleForm.fangwufanghao" 
                placeholder="房屋房号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"0px solid #dfdfdf","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"none"}' label="建筑面积" prop="jianzhumianji">
            <el-input v-model="ruleForm.jianzhumianji" 
                placeholder="建筑面积" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"0px solid #dfdfdf","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"none"}' label="房屋租金" prop="fangwuzujin">
            <el-input v-model="ruleForm.fangwuzujin" 
                placeholder="房屋租金" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"0px solid #dfdfdf","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"none"}'  label="房屋状态" prop="fangwuzhuangtai">
            <el-select v-model="ruleForm.fangwuzhuangtai" placeholder="请选择房屋状态"  >
              <el-option
                  v-for="(item,index) in fangwuzhuangtaiOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"border":"0px solid #dfdfdf","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"none"}' label="表格文件" prop="biaogewenjian">
            <file-upload
            tip="点击上传表格文件"
            action="file/upload"
            :limit="1"
            :multiple="true"
            :fileUrls="ruleForm.biaogewenjian?ruleForm.biaogewenjian:''"
            @change="biaogewenjianUploadChange"
            ></file-upload>
          </el-form-item>  
          <el-form-item :style='{"border":"0px solid #dfdfdf","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"none"}' label="发布日期" prop="faburiqi" disabled>
              <el-date-picker
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd"
                  v-model="ruleForm.faburiqi" 
                  type="date"
                  placeholder="发布日期">
              </el-date-picker> 
          </el-form-item>
          <el-form-item :style='{"border":"0px solid #dfdfdf","padding":"10px","boxShadow":"0px 0px 0px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"none"}' label="登记信息" prop="dengjixinxi">
            <editor 
                :style='{"minHeight":"200px","padding":"0","margin":"0","borderColor":"#ccc","backgroundColor":"#fff","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}'
                v-model="ruleForm.dengjixinxi" 
                class="editor" 
                action="file/upload">
            </editor>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"20px 0 20px 0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","boxShadow":"1px 2px 4px #ccc","margin":"0 20px 0 0","color":"#fff","outline":"none","borderRadius":"20px","background":"radial-gradient(circle, rgba(43,224,232,1) 0%, rgba(0,173,181,1) 100%)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"1px solid #bbb","cursor":"pointer","padding":"0","boxShadow":"4px 4px 8px #eee","margin":"0","color":"#999","outline":"none","borderRadius":"20px","background":"#fff","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
      return {
        id: '',
        baseUrl: '',
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
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
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
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
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
        },
      };
    },
    computed: {



    },
    components: {
    },
    created() {
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
      this.ruleForm.faburiqi = this.getCurDate()
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
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
              this.ruleForm.fangwutupian = obj[o].split(",")[0];
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
        }
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
          }
        });
        this.$http.get('option/xiaoquxinxi/xiaoqumingcheng', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.xiaoqumingchengOptions = res.data.data;
          }
        });
        this.fangwuzhuangtaiOptions = "已申请,未申请".split(',')
      },
      // 下二随
      xiaoqumingchengChange () {
        this.$http.get('follow/xiaoquxinxi/xiaoqumingcheng?columnValue=' + this.ruleForm.xiaoqumingcheng, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            if(res.data.data.xiaoquleixing){
              this.ruleForm.xiaoquleixing = res.data.data.xiaoquleixing
            }
            if(res.data.data.xiaoquweizhi){
              this.ruleForm.xiaoquweizhi = res.data.data.xiaoquweizhi
            }
          }
        });
      },

    // 多级联动参数
      // 多级联动参数
      info(id) {
        this.$http.get('fangwuxinxi/detail/${id}', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

        //更新跨表属性
        var crossuserid;
        var crossrefid;
        var crossoptnum;
        this.$refs["ruleForm"].validate(valid => {
          if(valid) {
            if(this.type=='cross'){
                 var statusColumnName = localStorage.getItem('statusColumnName');
                 var statusColumnValue = localStorage.getItem('statusColumnValue');
                 if(statusColumnName && statusColumnName!='') {
                     var obj = JSON.parse(localStorage.getItem('crossObj'));
                     if(!statusColumnName.startsWith("[")) {
                         for (var o in obj){
                             if(o==statusColumnName){
                                 obj[o] = statusColumnValue;
                             }
                         }
                         var table = localStorage.getItem('crossTable');
                         this.$http.post(table+'/update', obj).then(res => {});
                     } else {
                            crossuserid=Number(localStorage.getItem('userid'));
                            crossrefid=obj['id'];
                            crossoptnum=localStorage.getItem('statusColumnName');
                            crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                     }
                 }
            }
            if(crossrefid && crossuserid) {
                 this.ruleForm.crossuserid=crossuserid;
                 this.ruleForm.crossrefid=crossrefid;
                 var params = {
                     page: 1,
                     limit: 10,
                     crossuserid:crossuserid,
                     crossrefid:crossrefid,
                 }
                 this.$http.get('fangwuxinxi/list', {
                  params: params
                 }).then(res => {
                     if(res.data.data.total>=crossoptnum) {
                         this.$message({
                          message: localStorage.getItem('tips'),
                          type: 'success',
                          duration: 1500,
                         });
                          return false;
                     } else {
                         // 跨表计算


                          this.$http.post('fangwuxinxi/add', this.ruleForm).then(res => {
                              if (res.data.code == 0) {
                                  this.$message({
                                      message: '操作成功',
                                      type: 'success',
                                      duration: 1500,
                                      onClose: () => {
                                          this.$router.go(-1);
                                      }
                                  });
                              } else {
                                  this.$message({
                                      message: res.data.msg,
                                      type: 'error',
                                      duration: 1500
                                  });
                              }
                          });
                     }
                 });
             } else {


                  this.$http.post('fangwuxinxi/add', this.ruleForm).then(res => {
                     if (res.data.code == 0) {
                          this.$message({
                              message: '操作成功',
                              type: 'success',
                              duration: 1500,
                              onClose: () => {
                                  this.$router.go(-1);
                              }
                          });
                      } else {
                          this.$message({
                              message: res.data.msg,
                              type: 'error',
                              duration: 1500
                          });
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
        this.$router.go(-1);
      },
      fangwutupianUploadChange(fileUrls) {
          this.ruleForm.fangwutupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
      biaogewenjianUploadChange(fileUrls) {
          this.ruleForm.biaogewenjian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #666;
	  font-weight: 500;
	  width: 80px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 80px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 1px solid #00adb5;
	  border-radius: 4px;
	  padding: 0 12px;
	  outline: none;
	  color: #666;
	  background: radial-gradient(circle, rgba(237,250,251,1) 35%, rgba(162,233,236,1) 100%);
	  width: 400px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 1px solid #00adb5;
	  border-radius: 4px;
	  padding: 0 10px;
	  outline: none;
	  color: #666;
	  background: radial-gradient(circle, rgba(237,250,251,1) 35%, rgba(162,233,236,1) 100%);
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border: 1px solid #00adb5;
	  border-radius: 4px;
	  padding: 0 10px 0 30px;
	  outline: none;
	  color: #666;
	  background: radial-gradient(circle, rgba(237,250,251,1) 35%, rgba(162,233,236,1) 100%);
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
	  border: 1px solid #00adb5;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #00adb5;
	  background: radial-gradient(circle, rgba(237,250,251,1) 35%, rgba(162,233,236,1) 100%);
	  width: 200px;
	  font-size: 32px;
	  line-height: 120px;
	  text-align: center;
	  height: auto;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  border: 1px solid #00adb5;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #00adb5;
	  background: radial-gradient(circle, rgba(237,250,251,1) 35%, rgba(162,233,236,1) 100%);
	  width: 200px;
	  font-size: 32px;
	  line-height: 120px;
	  text-align: center;
	  height: auto;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  border: 1px solid #00adb5;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #00adb5;
	  background: radial-gradient(circle, rgba(237,250,251,1) 35%, rgba(162,233,236,1) 100%);
	  width: 200px;
	  font-size: 32px;
	  line-height: 120px;
	  text-align: center;
	  height: auto;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid #00adb5;
	  border-radius: 4px;
	  padding: 12px;
	  outline: none;
	  color: #666;
	  background: radial-gradient(circle, rgba(237,250,251,1) 35%, rgba(162,233,236,1) 100%);
	  width: 400px;
	  font-size: 14px;
	  min-height: 120px;
	}
</style>
