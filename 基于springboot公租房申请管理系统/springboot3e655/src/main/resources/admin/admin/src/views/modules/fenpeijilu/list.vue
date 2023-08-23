<template>
	<div class="main-content" :style='{"padding":"30px 0 0 0"}'>
		<!-- 列表页 -->
		<template v-if="showFlag">
			<el-form class="center-form-pv" :style='{"width":"180px","margin":"0 0 20px 20px","position":"absolute","zIndex":"1003"}' :inline="true" :model="searchForm">
				<el-row :style='{"display":"block"}' >
					<div :style='{"margin":"0 0px 15px 0","display":"inline-block"}'>
						<label :style='{"margin":"0 10px 0 0","color":"#666","textAlign":"center","display":"inline-block","width":"auto","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">合同编号</label>
						<el-input v-model="searchForm.hetongbianhao" placeholder="合同编号" clearable></el-input>
					</div>
					<div :style='{"margin":"0 0px 15px 0","display":"inline-block"}'>
						<label :style='{"margin":"0 10px 0 0","color":"#666","textAlign":"center","display":"inline-block","width":"auto","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">房屋名称</label>
						<el-input v-model="searchForm.fangwumingcheng" placeholder="房屋名称" clearable></el-input>
					</div>
					<div :style='{"margin":"0 0px 15px 0","display":"inline-block"}'>
						<label :style='{"margin":"0 10px 0 0","color":"#666","textAlign":"center","display":"inline-block","width":"auto","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">分配日期</label>
						<el-date-picker v-model="searchForm.fenpeiriqistart" type="date" value-format="yyyy-MM-dd" format="yyyy-MM-dd" placeholder="分配日期起始"></el-date-picker>
						至
						<el-date-picker v-model="searchForm.fenpeiriqiend" type="date" value-format="yyyy-MM-dd" format="yyyy-MM-dd" placeholder="分配日期结束"></el-date-picker>
					</div>
					<el-button :style='{"border":"2px solid #3CB5AF","cursor":"pointer","padding":"0 20px","outline":"none","margin":"0px 0 5px 0","color":"#3CB5AF","borderRadius":"40px","background":"#fff","width":"160px","fontSize":"14px","height":"40px"}' type="success" @click="search()">查询</el-button>
				</el-row>

				<el-row :style='{"width":"170px","margin":"10px 0 0","flexDirection":"column","display":"flex"}'>
					<el-button :style='{"border":"2px solid #3CB5AF","cursor":"pointer","padding":"0 24px","margin":"0 10px 5px 0","outline":"none","color":"#3CB5AF","borderRadius":"40px","background":"#fff","width":"160px","fontSize":"14px","height":"40px"}' v-if="isAuth('fenpeijilu','新增')" type="success" @click="addOrUpdateHandler()">新增</el-button>
					<el-button :style='{"border":"2px solid #3CB5AF","cursor":"pointer","padding":"0 24px","margin":"0 10px 5px 0","outline":"none","color":"#3CB5AF","borderRadius":"40px","background":"#fff","width":"160px","fontSize":"14px","height":"40px"}' v-if="isAuth('fenpeijilu','删除')" :disabled="dataListSelections.length <= 0" type="danger" @click="deleteHandler()">删除</el-button>




				</el-row>
			</el-form>
			
			<!-- <div> -->
				<el-table class="tables"
					:stripe='false'
					:style='{"padding":"0","boxShadow":" 0px 4px 10px 0px rgba(0,0,0,0.3020)","borderColor":"#eee","margin":"0 0 15px 210px","borderWidth":"1px 0 0 1px","background":"#fff","width":"calc(100% - 230px)","borderStyle":"solid"}' 
					v-if="isAuth('fenpeijilu','查看')"
					:data="dataList"
					v-loading="dataListLoading"
				@selection-change="selectionChangeHandler">
					<el-table-column :resizable='true' type="selection" align="center" width="50"></el-table-column>
					<el-table-column :resizable='true' :sortable='false' label="索引" type="index" width="50" />
					<el-table-column :resizable='true' :sortable='false'  
						prop="hetongbianhao"
					label="合同编号">
						<template slot-scope="scope">
							{{scope.row.hetongbianhao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="xiaoqumingcheng"
					label="小区名称">
						<template slot-scope="scope">
							{{scope.row.xiaoqumingcheng}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="fangwumingcheng"
					label="房屋名称">
						<template slot-scope="scope">
							{{scope.row.fangwumingcheng}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false' prop="fangwutupian" width="200" label="房屋图片">
						<template slot-scope="scope">
							<div v-if="scope.row.fangwutupian">
								<img v-if="scope.row.fangwutupian.substring(0,4)=='http'" :src="scope.row.fangwutupian.split(',')[0]" width="100" height="100">
								<img v-else :src="$base.url+scope.row.fangwutupian.split(',')[0]" width="100" height="100">
							</div>
							<div v-else>无图片</div>
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="fangwulouhao"
					label="房屋楼号">
						<template slot-scope="scope">
							{{scope.row.fangwulouhao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="fangwufanghao"
					label="房屋房号">
						<template slot-scope="scope">
							{{scope.row.fangwufanghao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="jianzhumianji"
					label="建筑面积">
						<template slot-scope="scope">
							{{scope.row.jianzhumianji}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="fangwuzujin"
					label="房屋租金">
						<template slot-scope="scope">
							{{scope.row.fangwuzujin}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false' prop="hetongwenjian" label="合同文件">
						<template slot-scope="scope">
							<el-button v-if="scope.row.hetongwenjian" type="text" size="small" @click="download($base.url+scope.row.hetongwenjian)">下载</el-button>
                            <span v-else >无</span>
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="fenpeiriqi"
					label="分配日期">
						<template slot-scope="scope">
							{{scope.row.fenpeiriqi}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="yonghuming"
					label="用户名">
						<template slot-scope="scope">
							{{scope.row.yonghuming}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="shouji"
					label="手机">
						<template slot-scope="scope">
							{{scope.row.shouji}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="shenfenzheng"
					label="身份证">
						<template slot-scope="scope">
							{{scope.row.shenfenzheng}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="xinxibeizhu"
					label="信息备注">
						<template slot-scope="scope">
							{{scope.row.xinxibeizhu}}
						</template>
					</el-table-column>
					<el-table-column width="300" label="操作">
						<template slot-scope="scope">
							<el-button :style='{"border":"1px solid rgba(135, 154, 108, 1)","cursor":"pointer","padding":"0 10px","margin":"0 10px 5px 0","outline":"none","color":"rgba(135, 154, 108, 1)","borderRadius":"4px","background":"#fff","width":"auto","fontSize":"14px","height":"32px"}' v-if=" isAuth('fenpeijilu','查看')" type="success" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">详情</el-button>
							<el-button :style='{"border":"1px solid rgba(135, 154, 108, 1)","cursor":"pointer","padding":"0 10px","margin":"0 10px 5px 0","outline":"none","color":"rgba(135, 154, 108, 1)","borderRadius":"4px","background":"#fff","width":"auto","fontSize":"14px","height":"32px"}' v-if="isAuth('fenpeijilu','添加缴费')" type="success" size="mini" @click="jiaofeijiluCrossAddOrUpdateHandler(scope.row,'cross','','','')">添加缴费</el-button>
							<el-button :style='{"border":"1px solid rgba(135, 154, 108, 1)","cursor":"pointer","padding":"0 10px","margin":"0 10px 5px 0","outline":"none","color":"rgba(135, 154, 108, 1)","borderRadius":"4px","background":"#fff","width":"auto","fontSize":"14px","height":"32px"}' v-if="isAuth('fenpeijilu','换房申请')" type="success" size="mini" @click="huanfangshenqingjiluCrossAddOrUpdateHandler(scope.row,'cross','','[1]','请勿重复操作！')">换房申请</el-button>
							<el-button :style='{"border":"1px solid rgba(135, 154, 108, 1)","cursor":"pointer","padding":"0 10px","margin":"0 10px 5px 0","outline":"none","color":"rgba(135, 154, 108, 1)","borderRadius":"4px","background":"#fff","width":"auto","fontSize":"14px","height":"32px"}' v-if=" isAuth('fenpeijilu','修改')" type="primary" size="mini" @click="addOrUpdateHandler(scope.row.id)">修改</el-button>





							<el-button :style='{"border":"1px solid rgba(135, 154, 108, 1)","cursor":"pointer","padding":"0 10px","margin":"0 10px 5px 0","outline":"none","color":"rgba(135, 154, 108, 1)","borderRadius":"4px","background":"#fff","width":"auto","fontSize":"14px","height":"32px"}' v-if="isAuth('fenpeijilu','删除') " type="danger" size="mini" @click="deleteHandler(scope.row.id)">删除</el-button>
						</template>
					</el-table-column>
				</el-table>
				<el-pagination
					@size-change="sizeChangeHandle"
					@current-change="currentChangeHandle"
					:current-page="pageIndex"
					background
					:page-sizes="[10, 20, 30, 50]"
					:page-size="pageSize"
					:layout="layouts.join()"
					:total="totalPage"
					prev-text="<"
					next-text=">"
					:hide-on-single-page="false"
					:style='{"padding":"0","margin":"20px 0 10px 210px","whiteSpace":"nowrap","color":"#333","textAlign":"center","width":"calc(100% - 230px)","fontWeight":"500"}'
				></el-pagination>
			<!-- </div> -->
		</template>
		
		<!-- 添加/修改页面  将父组件的search方法传递给子组件-->
		<add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>

		<jiaofeijilu-cross-add-or-update v-if="jiaofeijiluCrossAddOrUpdateFlag" :parent="this" ref="jiaofeijiluCrossaddOrUpdate"></jiaofeijilu-cross-add-or-update>
		<huanfangshenqingjilu-cross-add-or-update v-if="huanfangshenqingjiluCrossAddOrUpdateFlag" :parent="this" ref="huanfangshenqingjiluCrossaddOrUpdate"></huanfangshenqingjilu-cross-add-or-update>




	</div>
</template>

<script>
import axios from 'axios'
import AddOrUpdate from "./add-or-update";
import jiaofeijiluCrossAddOrUpdate from "../jiaofeijilu/add-or-update";
import huanfangshenqingjiluCrossAddOrUpdate from "../huanfangshenqingjilu/add-or-update";
export default {
  data() {
    return {
      searchForm: {
        key: ""
      },
      form:{},
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: true,
      sfshVisiable: false,
      shForm: {},
      chartVisiable: false,
      chartVisiable1: false,
      chartVisiable2: false,
      chartVisiable3: false,
      chartVisiable4: false,
      chartVisiable5: false,
      addOrUpdateFlag:false,
      jiaofeijiluCrossAddOrUpdateFlag: false,
      huanfangshenqingjiluCrossAddOrUpdateFlag: false,
      layouts: ["total","prev","pager","next","sizes","jumper"],

    };
  },
  created() {
    this.init();
    this.getDataList();
    this.contentStyleChange()
  },
  mounted() {
  },
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
    }
  },
  components: {
    AddOrUpdate,
    jiaofeijiluCrossAddOrUpdate,
    huanfangshenqingjiluCrossAddOrUpdate,
  },
  methods: {

    contentStyleChange() {
      this.contentPageStyleChange()
    },
    // 分页
    contentPageStyleChange(){
      let arr = []

      // if(this.contents.pageTotal) arr.push('total')
      // if(this.contents.pageSizes) arr.push('sizes')
      // if(this.contents.pagePrevNext){
      //   arr.push('prev')
      //   if(this.contents.pagePager) arr.push('pager')
      //   arr.push('next')
      // }
      // if(this.contents.pageJumper) arr.push('jumper')
      // this.layouts = arr.join()
      // this.contents.pageEachNum = 10
    },

    jiaofeijiluCrossAddOrUpdateHandler(row,type,crossOptAudit,statusColumnName,tips,statusColumnValue){
      this.showFlag = false;
      this.addOrUpdateFlag = false;
      this.jiaofeijiluCrossAddOrUpdateFlag = true;
      this.$storage.set('crossObj',row);
      this.$storage.set('crossTable','fenpeijilu');
      this.$storage.set('statusColumnName',statusColumnName);
      this.$storage.set('statusColumnValue',statusColumnValue);
      this.$storage.set('tips',tips);
	if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
		var obj = this.$storage.getObj('crossObj');
		for (var o in obj){
		  if(o==statusColumnName && obj[o]==statusColumnValue){
		    this.$message({
		      message: tips,
		      type: "success",
		      duration: 1500,
		      onClose: () => {
			this.getDataList();
		      }
		    });
		      this.showFlag = true;
		      this.jiaofeijiluCrossAddOrUpdateFlag = false;
			return;
		  }
		}
	}
      this.$nextTick(() => {
      this.$refs.jiaofeijiluCrossaddOrUpdate.init(row.id,type);
      });
    },
    huanfangshenqingjiluCrossAddOrUpdateHandler(row,type,crossOptAudit,statusColumnName,tips,statusColumnValue){
      this.showFlag = false;
      this.addOrUpdateFlag = false;
      this.huanfangshenqingjiluCrossAddOrUpdateFlag = true;
      this.$storage.set('crossObj',row);
      this.$storage.set('crossTable','fenpeijilu');
      this.$storage.set('statusColumnName',statusColumnName);
      this.$storage.set('statusColumnValue',statusColumnValue);
      this.$storage.set('tips',tips);
	if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
		var obj = this.$storage.getObj('crossObj');
		for (var o in obj){
		  if(o==statusColumnName && obj[o]==statusColumnValue){
		    this.$message({
		      message: tips,
		      type: "success",
		      duration: 1500,
		      onClose: () => {
			this.getDataList();
		      }
		    });
		      this.showFlag = true;
		      this.huanfangshenqingjiluCrossAddOrUpdateFlag = false;
			return;
		  }
		}
	}
      this.$nextTick(() => {
      this.$refs.huanfangshenqingjiluCrossaddOrUpdate.init(row.id,type);
      });
    },







    init () {
    },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },

    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
        order: 'desc',
      }
           if(this.searchForm.hetongbianhao!='' && this.searchForm.hetongbianhao!=undefined){
            params['hetongbianhao'] = '%' + this.searchForm.hetongbianhao + '%'
          }
           if(this.searchForm.fangwumingcheng!='' && this.searchForm.fangwumingcheng!=undefined){
            params['fangwumingcheng'] = '%' + this.searchForm.fangwumingcheng + '%'
          }
    params['sort'] = 'fenpeiriqi';
    params['order'] = 'desc';
           if(this.searchForm.fenpeiriqistart!='' && this.searchForm.fenpeiriqistart!=undefined ){
            params['fenpeiriqistart'] = this.searchForm.fenpeiriqistart
          }
          if(this.searchForm.fenpeiriqiend!='' && this.searchForm.fenpeiriqiend!=undefined){
            params['fenpeiriqiend'] = this.searchForm.fenpeiriqiend
          }
      this.$http({
        url: "fenpeijilu/page",
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
    // 下载
    download(file){
      window.open(`${file}`)
    },
    // 删除
    deleteHandler(id) {
      var ids = id
        ? [Number(id)]
        : this.dataListSelections.map(item => {
            return Number(item.id);
          });
      this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "fenpeijilu/delete",
          method: "post",
          data: ids
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.search();
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },


  }

};
</script>
<style lang="scss" scoped>
	
	.center-form-pv {
	  .el-date-editor.el-input {
	    width: auto;
	  }
	}
	
	.el-input {
	  width: auto;
	}
	
	// form
	.center-form-pv .el-input /deep/ .el-input__inner {
				border: 2px solid #3CB5AF;
				border-radius: 4px;
				padding: 0 12px;
				box-shadow: 5px 2px 0px 0px #3CB5AF;
				outline: none;
				color: #333;
				width: 160px;
				font-size: 14px;
				height: 40px;
			}
	
	.center-form-pv .el-select /deep/ .el-input__inner {
				border: 2px solid #3CB5AF;
				border-radius: 4px;
				padding: 0 10px;
				box-shadow: 5px 2px 0px 0px #3CB5AF;
				outline: none;
				color: #333;
				width: 160px;
				font-size: 14px;
				height: 40px;
			}
	
	.center-form-pv .el-date-editor /deep/ .el-input__inner {
				border: 2px solid #3CB5AF;
				border-radius: 4px;
				padding: 0 10px 0 30px;
				box-shadow: 5px 2px 0px 0px #3CB5AF;
				outline: none;
				color: #333;
				width: 160px;
				font-size: 14px;
				height: 40px;
			}
	
	// table
	.el-table /deep/ .el-table__header-wrapper thead {
				color: #fff;
				font-weight: 500;
				width: 100%;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr {
				background: #fff;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr th {
				padding: 12px 0;
				background: rgba(27, 167, 166, 1);
				border-color: #eee;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: center;
			}

	.el-table /deep/ .el-table__header-wrapper thead tr th .cell {
				padding: 0 10px;
				word-wrap: normal;
				word-break: break-all;
				white-space: normal;
				font-weight: bold;
				display: inline-block;
				vertical-align: middle;
				width: 100%;
				line-height: 24px;
				position: relative;
				text-overflow: ellipsis;
			}

	
	.el-table /deep/ .el-table__body-wrapper tbody {
				width: 100%;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr {
				background: #fff;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 12px 0;
				color: #999;
				background: #fff;
				border-color: #eee;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: center;
			}
	
		
	.el-table /deep/ .el-table__body-wrapper tbody tr:hover td {
				padding: 12px 0;
				color: #000;
				border-color: #eee;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: center;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 12px 0;
				color: #999;
				background: #fff;
				border-color: #eee;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: center;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .cell {
				padding: 0 10px;
				overflow: hidden;
				word-break: break-all;
				white-space: normal;
				line-height: 24px;
				text-overflow: ellipsis;
			}
	
	// pagination
	.main-content .el-pagination /deep/ .el-pagination__total {
				margin: 0 10px 0 0;
				color: #666;
				font-weight: 400;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-prev {
				border: none;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #666;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-next {
				border: none;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #666;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-prev:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #C0C4CC;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-next:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #C0C4CC;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .el-pager {
				padding: 0;
				margin: 0;
				display: inline-block;
				vertical-align: top;
			}

	.main-content .el-pagination /deep/ .el-pager .number {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 5px;
				color: #666;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 2px;
				background: #f4f4f5;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pager .number:hover {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 5px;
				color: #1ba7a6;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 2px;
				background: #f4f4f5;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pager .number.active {
				cursor: default;
				padding: 0 4px;
				margin: 0 5px;
				color: #FFF;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 2px;
				background: #1ba7a6;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes {
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input {
				margin: 0 5px;
				width: 100px;
				position: relative;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
				border: 1px solid #DCDFE6;
				cursor: pointer;
				padding: 0 25px 0 8px;
				color: #606266;
				display: inline-block;
				font-size: 13px;
				line-height: 28px;
				border-radius: 3px;
				outline: 0;
				background: #FFF;
				width: 100%;
				text-align: center;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
				top: 0;
				position: absolute;
				right: 0;
				height: 100%;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
				cursor: pointer;
				color: #C0C4CC;
				width: 25px;
				font-size: 14px;
				line-height: 28px;
				text-align: center;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump {
				margin: 0 0 0 24px;
				color: #606266;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input {
				border-radius: 3px;
				padding: 0 2px;
				margin: 0 2px;
				display: inline-block;
				width: 50px;
				font-size: 14px;
				line-height: 18px;
				position: relative;
				text-align: center;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
				border: 1px solid #DCDFE6;
				cursor: pointer;
				padding: 0 3px;
				color: #606266;
				display: inline-block;
				font-size: 14px;
				line-height: 28px;
				border-radius: 3px;
				outline: 0;
				background: #FFF;
				width: 100%;
				text-align: center;
				height: 28px;
			}
</style>
