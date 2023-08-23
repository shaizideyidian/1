import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Messages from '../pages/messages/list'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import shenheyuanList from '../pages/shenheyuan/list'
import shenheyuanDetail from '../pages/shenheyuan/detail'
import shenheyuanAdd from '../pages/shenheyuan/add'
import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import xiaoquxinxiList from '../pages/xiaoquxinxi/list'
import xiaoquxinxiDetail from '../pages/xiaoquxinxi/detail'
import xiaoquxinxiAdd from '../pages/xiaoquxinxi/add'
import fangwuxinxiList from '../pages/fangwuxinxi/list'
import fangwuxinxiDetail from '../pages/fangwuxinxi/detail'
import fangwuxinxiAdd from '../pages/fangwuxinxi/add'
import shenqingjiluList from '../pages/shenqingjilu/list'
import shenqingjiluDetail from '../pages/shenqingjilu/detail'
import shenqingjiluAdd from '../pages/shenqingjilu/add'
import fenpeijiluList from '../pages/fenpeijilu/list'
import fenpeijiluDetail from '../pages/fenpeijilu/detail'
import fenpeijiluAdd from '../pages/fenpeijilu/add'
import jiaofeijiluList from '../pages/jiaofeijilu/list'
import jiaofeijiluDetail from '../pages/jiaofeijilu/detail'
import jiaofeijiluAdd from '../pages/jiaofeijilu/add'
import huanfangshenqingjiluList from '../pages/huanfangshenqingjilu/list'
import huanfangshenqingjiluDetail from '../pages/huanfangshenqingjilu/detail'
import huanfangshenqingjiluAdd from '../pages/huanfangshenqingjilu/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'messages',
					component: Messages
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'shenheyuan',
					component: shenheyuanList
				},
				{
					path: 'shenheyuanDetail',
					component: shenheyuanDetail
				},
				{
					path: 'shenheyuanAdd',
					component: shenheyuanAdd
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'xiaoquxinxi',
					component: xiaoquxinxiList
				},
				{
					path: 'xiaoquxinxiDetail',
					component: xiaoquxinxiDetail
				},
				{
					path: 'xiaoquxinxiAdd',
					component: xiaoquxinxiAdd
				},
				{
					path: 'fangwuxinxi',
					component: fangwuxinxiList
				},
				{
					path: 'fangwuxinxiDetail',
					component: fangwuxinxiDetail
				},
				{
					path: 'fangwuxinxiAdd',
					component: fangwuxinxiAdd
				},
				{
					path: 'shenqingjilu',
					component: shenqingjiluList
				},
				{
					path: 'shenqingjiluDetail',
					component: shenqingjiluDetail
				},
				{
					path: 'shenqingjiluAdd',
					component: shenqingjiluAdd
				},
				{
					path: 'fenpeijilu',
					component: fenpeijiluList
				},
				{
					path: 'fenpeijiluDetail',
					component: fenpeijiluDetail
				},
				{
					path: 'fenpeijiluAdd',
					component: fenpeijiluAdd
				},
				{
					path: 'jiaofeijilu',
					component: jiaofeijiluList
				},
				{
					path: 'jiaofeijiluDetail',
					component: jiaofeijiluDetail
				},
				{
					path: 'jiaofeijiluAdd',
					component: jiaofeijiluAdd
				},
				{
					path: 'huanfangshenqingjilu',
					component: huanfangshenqingjiluList
				},
				{
					path: 'huanfangshenqingjiluDetail',
					component: huanfangshenqingjiluDetail
				},
				{
					path: 'huanfangshenqingjiluAdd',
					component: huanfangshenqingjiluAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
