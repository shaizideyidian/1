<template>
<div class="home-preview" :style='{"width":"100%","margin":"20px 0 0","flexWrap":"wrap","justifyContent":"center","display":"flex"}'>




	<!-- 关于我们 -->
	<div :style='{"border":"1px solid #eee","padding":"0 20px 0px 0","boxShadow":"0px 0px 0px #eee","margin":"20px auto 40px","overflow":"hidden","borderRadius":"4px","background":"#fff","width":"1200px","position":"relative","height":"auto","order":"0"}'>
	  <div :style='{"padding":"0px 20px 0px  20px ","margin":"0px 0 0px 0","color":"#fff","textAlign":"right","top":"0px","left":"0","background":"#00adb5","width":"50%","lineHeight":"50px","fontSize":"24px","position":"absolute","textShadow":"0px 0px 0px #eee","zIndex":"9","height":"50px"}'>{{aboutUsDetail.title}}</div>
	  <div :style='{"padding":"0px 20px 0px  20px ","margin":"0 0 80px 0px","color":"#999","textAlign":"left","display":"block","right":"0","top":"0","background":"#d4f2f3","width":"50%","lineHeight":"50px","fontSize":"24px","position":"absolute","zIndex":"9","height":"50px"}'>{{aboutUsDetail.subtitle}}</div>
	  <div :style='{"width":"600px","padding":"0","margin":"80px 0 40px 0px","float":"left","display":"inline-block","height":"400px"}'>
	    <img :style='{"boxShadow":"0px 0px 0px #1170d2","margin":"0px","objectFit":"cover","borderRadius":"0","display":"block","width":"100%","float":"left","height":"100%"}' :src="baseUrl + aboutUsDetail.picture1">
	    <img :style='{"margin":"0 0px","objectFit":"cover","borderRadius":"8px","display":"none","width":"48%","float":"right","height":"170px"}' :src="baseUrl + aboutUsDetail.picture2">
	    <img :style='{"margin":"0 10px","objectFit":"cover","flex":1,"display":"none","height":"120px"}' :src="baseUrl + aboutUsDetail.picture3">
	  </div>
	  <div :style='{"padding":"20px 20px 20px 20px","boxShadow":"12px 12px 0px #f0f0f0","margin":"140px 30px 0 0","borderColor":"#00adb5","color":"#333","display":"inline-block","right":"0","float":"right","textIndent":"2em","overflow":"hidden","borderRadius":"0px","background":"#e6f5f6","borderWidth":"4px","width":"550px","lineHeight":"24px","fontSize":"15px","position":"absolute","borderStyle":"solid double solid double","height":"300px","zIndex":"9"}' v-html="aboutUsDetail.content"></div>
	  <div :style='{"margin":"80px 0 40px 0px","background":"url(http://codegen.caihongy.cn/20221123/807c54bbbc784f6fb0be96bee216fb28.png) no-repeat center top","display":"block","width":"600px","position":"absolute","height":"400px","zIndex":"1"}' />
	  <div :style='{"width":"285px","background":"url(\"http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg\") 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
	  <div :style='{"width":"285px","background":"url(\"http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg\") 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
	  <div :style='{"width":"285px","background":"url(\"http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg\") 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
	</div>
	
<div class="news" :style='{"border":"0px solid #dfdfdf","padding":"20px 0","boxShadow":"0px 0px 0px #eee","margin":"0px auto 0px auto","overflow":"hidden","borderRadius":"0px","background":"url(http://codegen.caihongy.cn/20221123/02b65dd190a741a1ae9c37c17624c5aa.jpg) fixed no-repeat center top,#d4f2f3","width":"100%","position":"relative","height":"auto","order":"6"}'>
	<div v-if="false" class="idea newsIdea" :style='{"padding":"0","margin":"0 auto","flexWrap":"wrap","background":"none","display":"flex","width":"1200px","justifyContent":"space-between"}'>
		<div class="box1" :style='{"width":"1200px","margin":"0 auto","position":"absolute","top":"74px","background":"#08b344","height":"1px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"padding":"0","margin":"40px auto","borderRadius":"4px 4px 0 0","textAlign":"center","background":"url(http://codegen.caihongy.cn/20221123/8ac6eb514177419daf62911e596cd805.png) no-repeat center top","width":"1200px","lineHeight":"50px","position":"relative","height":"50px"}'>
		<span :style='{"padding":"0","fontSize":"24px","color":"#fff","textShadow":"0px 0px 0px #eee","background":"none"}'>政策新闻</span>
	</div>
	
	
	
	
	
	
	
	
	
	<!-- 样式八 -->
	<div v-if="newsList.length" class="list list8 index-pv1" :style='{"cursor":"pointer","padding":"0px","margin":"0 auto","flexWrap":"wrap","background":"none","display":"flex","width":"1200px","justifyContent":"space-between","height":"auto"}'>
	  <div @click="toDetail('newsDetail', newsList[0])" v-if="newsList.length>0" :style='{"padding":"10px","margin":"0 0px 20px","borderRadius":"8px","background":"none","display":"flex","width":"49%","justifyContent":"space-between","height":"auto"}' class="list-item animation-box">
	    <div :style='{"width":"calc(100% - 260px)","padding":"10px 40px","borderRadius":"30%","background":"rgba(255,255,255,.9)","height":"auto","order":"2"}'>
	      <div :style='{"whiteSpace":"nowrap","overflow":"hidden","color":"#333","textAlign":"center","fontSize":"14px","lineHeight":"24px","textOverflow":"ellipsis","fontWeight":"bold"}'>{{newsList[0].title}}</div>
	      <div :style='{"overflow":"hidden","color":"#666","background":"none","fontSize":"14px","lineHeight":"24px","textIndent":"2em","height":"168px"}'>{{newsList[0].introduction}}</div>
	      <div :style='{"fontSize":"12px","lineHeight":"24px","color":"#999","textAlign":"center"}'>{{newsList[0].addtime.split(" ")[0]}}</div>
	    </div>
	    <img :style='{"width":"240px","objectFit":"cover","borderRadius":"100%","height":"240px"}' :src="baseUrl + newsList[0].picture" >
	  </div>
	  <div @click="toDetail('newsDetail', newsList[1])" v-if="newsList.length>1" :style='{"padding":"10px","margin":"0 0px 20px","borderRadius":"8px","background":"none","display":"flex","width":"49%","justifyContent":"space-between","height":"auto"}' class="list-item animation-box">
	    <img :style='{"width":"240px","objectFit":"cover","borderRadius":"100%","height":"240px","order":"2"}' :src="baseUrl + newsList[1].picture" >
	    <div :style='{"width":"calc(100% - 260px)","padding":"10px 40px","borderRadius":"30%","background":"rgba(255,255,255,.9)","height":"auto"}'>
	      <div :style='{"whiteSpace":"nowrap","overflow":"hidden","color":"#333","textAlign":"center","fontSize":"14px","lineHeight":"24px","textOverflow":"ellipsis","fontWeight":"bold"}'>{{newsList[1].title}}</div>
	      <div :style='{"fontSize":"14px","lineHeight":"24px","overflow":"hidden","color":"#666","textIndent":"2em","height":"168px"}'>{{newsList[1].introduction}}</div>
	      <div :style='{"fontSize":"12px","lineHeight":"24px","color":"#999","textAlign":"center"}'>{{newsList[1].addtime.split(" ")[0]}}</div>
	    </div>
	  </div>
	  <div @click="toDetail('newsDetail', newsList[2])" v-if="newsList.length>2" :style='{"padding":"10px","margin":"0 0px 0px","borderRadius":"8px","background":"none","display":"flex","width":"49%","justifyContent":"space-between","height":"auto"}' class="list-item animation-box">
	    <div :style='{"width":"calc(100% - 260px)","padding":"10px 40px","borderRadius":"30%","background":"rgba(255,255,255,.9)","height":"auto"}'>
	      <div :style='{"whiteSpace":"nowrap","overflow":"hidden","color":"#333","textAlign":"center","fontSize":"14px","lineHeight":"28px","textOverflow":"ellipsis","fontWeight":"bold"}'>{{newsList[2].title}}</div>
	      <div :style='{"fontSize":"14px","lineHeight":"24px","overflow":"hidden","color":"#666","textIndent":"2em","height":"168px"}'>{{newsList[2].introduction}}</div>
	      <div :style='{"fontSize":"12px","lineHeight":"24px","color":"#999","textAlign":"center"}'>{{newsList[2].addtime.split(" ")[0]}}</div>
	    </div>
	    <img :style='{"width":"240px","objectFit":"cover","borderRadius":"100%","height":"240px"}' :src="baseUrl + newsList[2].picture" >
	  </div>
	  <div @click="toDetail('newsDetail', newsList[3])" v-if="newsList.length>3" :style='{"padding":"10px","margin":"0 0px 0","borderRadius":"8px","background":"none","display":"flex","width":"49%","justifyContent":"space-between","height":"auto"}' class="list-item animation-box">
	    <img :style='{"width":"240px","objectFit":"cover","borderRadius":"100%","height":"240px"}' :src="baseUrl + newsList[3].picture" >
	    <div :style='{"width":"calc(100% - 260px)","padding":"10px 40px","borderRadius":"30%","background":"rgba(255,255,255,.9)","height":"auto"}'>
	      <div :style='{"whiteSpace":"nowrap","overflow":"hidden","color":"#333","textAlign":"center","fontSize":"14px","lineHeight":"24px","textOverflow":"ellipsis","fontWeight":"bold"}'>{{newsList[3].title}}</div>
	      <div :style='{"overflow":"hidden","color":"#666","background":"none","fontSize":"14px","lineHeight":"24px","textIndent":"2em","height":"168px"}'>{{newsList[3].introduction}}</div>
	      <div :style='{"fontSize":"12px","lineHeight":"24px","color":"#999","textAlign":"center"}'>{{newsList[3].addtime.split(" ")[0]}}</div>
	    </div>
	  </div>
	</div>
	
	
	
	<div @click="moreBtn('news')" :style='{"border":"0px solid #ffa100","cursor":"pointer","boxShadow":"0px 0px 0px #ddd5c6,inset 0px 0px 0px 0px #ffa100","padding":"0 20px","margin":"40px auto 40px","borderRadius":"0px","textAlign":"center","background":"#00adb5","display":"block","width":"130px","lineHeight":"44px"}'>
		<span :style='{"color":"#fff","background":"none","fontSize":"16px"}'>查看更多</span>
		<i v-if="true" :style='{"color":"#fff","fontSize":"16px","display":"inline-block"}' class="el-icon-d-arrow-right"></i>
	</div>
	
</div>

	<!-- 系统简介 -->
	<div :style='{"border":"1px solid #eee","padding":"10px 0 0","boxShadow":"0px 0px 0px #eee","margin":"40px 30px 0","overflow":"hidden","borderRadius":"4px","background":"#fff","width":"320px","position":"relative","height":"654px","order":"7"}'>
	  <div :style='{"padding":"0px 20px 0px  20px ","margin":"0 auto","color":"#fff","textAlign":"center","background":"url(http://codegen.caihongy.cn/20221123/8ac6eb514177419daf62911e596cd805.png) no-repeat center top","display":"block","width":"calc(100% - 20px)","lineHeight":"50px","fontSize":"24px","height":"50px"}'>{{systemIntroductionDetail.title}}</div>
	  <div :style='{"padding":"0px 20px 0px  20px ","margin":"0","color":"#333","textAlign":"left","background":"#9cc1d7","display":"none","width":"50%","lineHeight":"50px","fontSize":"24px","height":"50px"}'>{{systemIntroductionDetail.subtitle}}</div>
	  <div :style='{"width":"calc(100% - 40px)","padding":"0px","margin":"20px auto 0 auto","display":"block","height":"200px"}'>
	    <img :style='{"boxShadow":"0px 0px 0px #ddd","margin":"0px","objectFit":"cover","borderRadius":"0","display":"block","width":"100%","height":"100%"}' :src="baseUrl + systemIntroductionDetail.picture1">
	    <img :style='{"boxShadow":"1px 1px 1px #ddd","margin":"0px","objectFit":"cover","borderRadius":"8px","flex":1,"display":"none","width":"265px","height":"120px"}' :src="baseUrl + systemIntroductionDetail.picture2">
	    <img :style='{"boxShadow":"1px 1px 1px #ddd","margin":"0px","objectFit":"cover","borderRadius":"8px","flex":1,"display":"none","width":"265px","height":"120px"}' :src="baseUrl + systemIntroductionDetail.picture3">
	  </div>
	  <div :style='{"padding":"40px 10px 20px 20px","boxShadow":"0px 0px 0px #f6f6f6","margin":"10px auto 0 auto","borderColor":"#ffec9d","color":"#333","display":"block","textIndent":"2em","overflow":"hidden","borderRadius":"8px","background":"url(http://codegen.caihongy.cn/20221121/26d7b56a1c064c51baff1185b7567253.png) no-repeat center bottom,url(http://codegen.caihongy.cn/20221121/93bc3a43ff834bc4b0c9bfe3faf6a622.png) no-repeat center top,#e8f5f6","borderWidth":"0px","width":"calc(100% - 40px)","lineHeight":"24px","fontSize":"15px","borderStyle":"double dotted solid double","height":"350px"}' v-html="systemIntroductionDetail.content"></div>
	  <div :style='{"width":"320px","position":"absolute","top":"80px","background":"url(http://codegen.caihongy.cn/20221121/26d7b56a1c064c51baff1185b7567253.png) no-repeat center bottom,url(http://codegen.caihongy.cn/20221121/93bc3a43ff834bc4b0c9bfe3faf6a622.png) no-repeat center top","display":"block","height":"200px"}' />
	  <div :style='{"top":"84px","left":"0","background":"#08b344","display":"none","width":"calc(100% - 0px)","position":"absolute","height":"100px","zIndex":"0"}' />
	  <div :style='{"width":"285px","background":"url(\"http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg\") 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
	  <div :style='{"width":"285px","background":"url(\"http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg\") 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
	</div>

<div class="lists" :style='{"border":"1px solid #eee","padding":"0px","boxShadow":"0px 0px 0px #eee","margin":"40px 0 0","overflow":"hidden","borderRadius":"4px","background":"#fff","width":"850px","position":"relative","height":"auto","order":"8"}'>
	<div v-if="false" class="idea" :style='{"padding":"0px","margin":"0 auto","flexWrap":"wrap","background":"none","display":"flex","width":"1200px","justifyContent":"space-between"}'>
		<div class="box1" :style='{"width":"1200px","position":"absolute","top":"74px","background":"#08b344","height":"1px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"padding":"0","margin":"10px auto","textAlign":"center","background":"url(http://codegen.caihongy.cn/20221123/8ac6eb514177419daf62911e596cd805.png) no-repeat center top","width":"calc(100% - 20px)","lineHeight":"50px","position":"relative","height":"50px"}'>
	  <span :style='{"padding":"0","fontSize":"24px","color":"#fff","textShadow":"0px 0px 0px #eee","background":"none"}'>房屋信息展示</span>
	</div>
	
	
	
	
	
	<!-- 样式四 -->
	<div class="list list4 index-pv1" :style='{"width":"100%","padding":"0px","margin":"20px 0 0","background":"#fff","height":"auto"}'>
		<div v-if="fangwuxinxiList.length>0" class="list-4-item animation-box" @click="toDetail('fangwuxinxiDetail', fangwuxinxiList[0])" :style='{"width":"570px","margin":"0 10px","position":"relative","float":"left","display":"none","height":"570px"}'>
			<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-if="preHttp(fangwuxinxiList[0].fangwutupian)" :src="fangwuxinxiList[0].fangwutupian.split(',')[0]" alt="" />
			<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-else :src="baseUrl + (fangwuxinxiList[0].fangwutupian?fangwuxinxiList[0].fangwutupian.split(',')[0]:'')" alt="" />
			<div class="list-4-item-title line1" :style='{"color":"#fff","left":"0","textAlign":"center","bottom":"0","background":"rgba(0,0,0,.3)","width":"100%","lineHeight":"44px","fontSize":"14px","position":"absolute"}'>
                <div>{{fangwuxinxiList[0].fangwumingcheng}}</div>
                <div>{{fangwuxinxiList[0].fangwuzhuangtai}}</div>
            </div>
		</div>
		<div :style='{"width":"100%","margin":"0 0 10px","display":"inline-block","height":"275px"}' class="list-4-body">
			<div v-if="fangwuxinxiList.length>1" @click="toDetail('fangwuxinxiDetail', fangwuxinxiList[1])" class="list-4-item animation-box item-2" :style='{"cursor":"pointer","width":"49%","margin":"0px","position":"relative","display":"inline-block","height":"275px"}'>
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-if="preHttp(fangwuxinxiList[1].fangwutupian)" :src="fangwuxinxiList[1].fangwutupian.split(',')[0]" alt="" />
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-else :src="baseUrl + (fangwuxinxiList[1].fangwutupian?fangwuxinxiList[1].fangwutupian.split(',')[0]:'')" alt="" />
				<div class="list-4-item-title line1" :style='{"padding":"236px 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"center","bottom":"0","overflow":"hidden","left":"0","background":"url(http://codegen.caihongy.cn/20221123/0744ada234f94fe8b693f4180b0d73f3.png) no-repeat center top","width":"100%","lineHeight":"40px","fontSize":"16px","backgroundSize":"100% 100%","position":"absolute","textOverflow":"ellipsis","height":"100%"}'>
                    <div>{{fangwuxinxiList[1].fangwumingcheng}}</div>
                    <div>{{fangwuxinxiList[1].fangwuzhuangtai}}</div>
                </div>
			</div>
			<div v-if="fangwuxinxiList.length>2" @click="toDetail('fangwuxinxiDetail', fangwuxinxiList[2])" class="list-4-item animation-box item-3" :style='{"cursor":"pointer","margin":"0px","display":"inline-block","width":"49%","position":"relative","float":"right","height":"275px"}'>
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-if="preHttp(fangwuxinxiList[2].fangwutupian)" :src="fangwuxinxiList[2].fangwutupian.split(',')[0]" alt="" />
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-else :src="baseUrl + (fangwuxinxiList[2].fangwutupian?fangwuxinxiList[2].fangwutupian.split(',')[0]:'')" alt="" />
				<div class="list-4-item-title line1" :style='{"padding":"236px 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"center","bottom":"0","overflow":"hidden","left":"0","background":"url(http://codegen.caihongy.cn/20221123/0744ada234f94fe8b693f4180b0d73f3.png) no-repeat center top","width":"100%","lineHeight":"40px","fontSize":"16px","backgroundSize":"100% 100%","position":"absolute","textOverflow":"ellipsis","height":"100%"}'>
                    <div>{{fangwuxinxiList[2].fangwumingcheng}}</div>
                    <div>{{fangwuxinxiList[2].fangwuzhuangtai}}</div>
                </div>
			</div>
		</div>
		<div :style='{"width":"100%","margin":"10px 0 0","display":"inline-block","height":"275px"}' class="list-4-body">
			<div v-if="fangwuxinxiList.length>3" @click="toDetail('fangwuxinxiDetail', fangwuxinxiList[3])" class="list-4-item animation-box item-4" :style='{"cursor":"pointer","width":"49%","margin":"0","position":"relative","display":"inline-block","height":"275px"}'>
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-if="preHttp(fangwuxinxiList[3].fangwutupian)" :src="fangwuxinxiList[3].fangwutupian.split(',')[0]" alt="" />
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-else :src="baseUrl + (fangwuxinxiList[3].fangwutupian?fangwuxinxiList[3].fangwutupian.split(',')[0]:'')" alt="" />
				<div class="list-4-item-title line1" :style='{"padding":"236px 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"center","bottom":"0","overflow":"hidden","left":"0","background":"url(http://codegen.caihongy.cn/20221123/0744ada234f94fe8b693f4180b0d73f3.png) no-repeat center top","width":"100%","lineHeight":"40px","fontSize":"16px","backgroundSize":"100% 100%","position":"absolute","textOverflow":"ellipsis","height":"100%"}'>
                    <div>{{fangwuxinxiList[3].fangwumingcheng}}</div>
                    <div>{{fangwuxinxiList[3].fangwuzhuangtai}}</div>
                </div>
			</div>
			<div v-if="fangwuxinxiList.length>4" @click="toDetail('fangwuxinxiDetail', fangwuxinxiList[4])" class="list-4-item animation-box item-5" :style='{"cursor":"pointer","margin":"0","display":"inline-block","width":"49%","position":"relative","float":"right","height":"275px"}'>
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-if="preHttp(fangwuxinxiList[4].fangwutupian)" :src="fangwuxinxiList[4].fangwutupian.split(',')[0]" alt="" />
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-else :src="baseUrl + (fangwuxinxiList[4].fangwutupian?fangwuxinxiList[4].fangwutupian.split(',')[0]:'')" alt="" />
				<div class="list-4-item-title line1" :style='{"padding":"236px 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"center","bottom":"0","overflow":"hidden","left":"0","background":"url(http://codegen.caihongy.cn/20221123/0744ada234f94fe8b693f4180b0d73f3.png) no-repeat center top","width":"100%","lineHeight":"40px","fontSize":"16px","backgroundSize":"100% 100%","position":"absolute","textOverflow":"ellipsis","height":"100%"}'>
                    <div>{{fangwuxinxiList[4].fangwumingcheng}}</div>
                    <div>{{fangwuxinxiList[4].fangwuzhuangtai}}</div>
                </div>
			</div>
		</div>
	</div>
	
	
	
	
	
	
	<div @click="moreBtn('fangwuxinxi')" :style='{"border":"0px solid #ccc","cursor":"pointer","boxShadow":"0px 0px 0px #ddd5c6,inset 0px 0px 0px 0px #ffa100","margin":"20px auto 20px -175px","borderRadius":"0px","textAlign":"center","background":"none","display":"none","width":"100%","lineHeight":"44px"}'>
		<span :style='{"padding":"0 0 0 10px","borderColor":"#ccc","margin":"0","color":"#333","background":"#eee","borderWidth":"0","display":"inline-block","width":"100px","fontSize":"16px","lineHeight":"40px","borderStyle":"solid","height":"40px"}'>查看更多</span>
		<i v-if="true" :style='{"padding":"0 20px 0 0","borderColor":"#ccc","margin":"0 0 0 -10px","color":"#333","borderWidth":"0","background":"#eee","display":"inline-block","width":"40px","fontSize":"16px","lineHeight":"40px","borderStyle":"solid","height":"40px"}' class="el-icon-d-arrow-right"></i>
	</div>
	

</div>


</div>
</template>

<script>
  export default {
    //数据集合
    data() {
      return {
        baseUrl: '',
        aboutUsDetail: {},
        systemIntroductionDetail: {},
        newsList: [],

        fangwuxinxiList: [],
      }
    },
    created() {
      this.baseUrl = this.$config.baseUrl;
      this.getNewsList();
      this.getAboutUs();
      this.getSystemIntroduction();
      this.getList();
    },
    //方法集合
    methods: {
      preHttp(str) {
          return str && str.substr(0,4)=='http';
      },
      getAboutUs() {
          this.$http.get('aboutus/detail/1', {}).then(res => {
            if(res.data.code == 0) {
              this.aboutUsDetail = res.data.data;
            }
          })
      },
      getSystemIntroduction() {
          this.$http.get('systemintro/detail/1', {}).then(res => {
            if(res.data.code == 0) {
              this.systemIntroductionDetail = res.data.data;
            }
          })
      },
		getNewsList() {
			this.$http.get('news/list', {params: {
				page: 1,
				limit: 4,
			order: 'desc'}}).then(res => {
				if (res.data.code == 0) {
					this.newsList = res.data.data.list;
					
					
				}
			});
		},
		getList() {
          let autoSortUrl = "";
			
			this.$http.get('fangwuxinxi/list', {params: {
				sort : 'faburiqi',
				order : 'asc',
				page: 1,
				limit: 5,
			}}).then(res => {
				if (res.data.code == 0) {
					this.fangwuxinxiList = res.data.data.list;
					
					// 商品列表样式五
					
				}
			});
		},
		toDetail(path, item) {
			this.$router.push({path: '/index/' + path, query: {detailObj: JSON.stringify(item)}});
		},
		moreBtn(path) {
			this.$router.push({path: '/index/' + path});
		}
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
	
		.recommend {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
        }
        
        .list5 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				filter: brightness(1.1);
				transform: rotate(0deg);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				opacity: 0.75;
				transition: all 0.3s ease-in-out 0s;
			}
		}
		
		.news {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list6 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list6 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				filter: brightness(1.1);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: all 0.3s ease-in-out 0s;
			}
		}
	
		.lists {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: #08b344;
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
        }
        
        .list3 .swiper-button-next::after {
				color: #08b344;
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-next {
            left: auto;
            right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				opacity: 0.75;
				transition: all 0.3s ease-in-out 0s;
			}
		}
	}
</style>
