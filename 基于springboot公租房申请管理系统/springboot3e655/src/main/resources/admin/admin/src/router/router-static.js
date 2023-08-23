import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import huanfangshenqingjilu from '@/views/modules/huanfangshenqingjilu/list'
    import aboutus from '@/views/modules/aboutus/list'
    import shenheyuan from '@/views/modules/shenheyuan/list'
    import shenqingjilu from '@/views/modules/shenqingjilu/list'
    import fangwuxinxi from '@/views/modules/fangwuxinxi/list'
    import systemintro from '@/views/modules/systemintro/list'
    import jiaofeijilu from '@/views/modules/jiaofeijilu/list'
    import yonghu from '@/views/modules/yonghu/list'
    import chat from '@/views/modules/chat/list'
    import messages from '@/views/modules/messages/list'
    import xiaoquxinxi from '@/views/modules/xiaoquxinxi/list'
    import fenpeijilu from '@/views/modules/fenpeijilu/list'
    import config from '@/views/modules/config/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '政策新闻',
        component: news
      }
      ,{
	path: '/huanfangshenqingjilu',
        name: '换房申请记录',
        component: huanfangshenqingjilu
      }
      ,{
	path: '/aboutus',
        name: '关于我们',
        component: aboutus
      }
      ,{
	path: '/shenheyuan',
        name: '审核员',
        component: shenheyuan
      }
      ,{
	path: '/shenqingjilu',
        name: '申请记录',
        component: shenqingjilu
      }
      ,{
	path: '/fangwuxinxi',
        name: '房屋信息',
        component: fangwuxinxi
      }
      ,{
	path: '/systemintro',
        name: '系统简介',
        component: systemintro
      }
      ,{
	path: '/jiaofeijilu',
        name: '缴费记录',
        component: jiaofeijilu
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/chat',
        name: '人工客服',
        component: chat
      }
      ,{
	path: '/messages',
        name: '留言反馈',
        component: messages
      }
      ,{
	path: '/xiaoquxinxi',
        name: '小区信息',
        component: xiaoquxinxi
      }
      ,{
	path: '/fenpeijilu',
        name: '分配记录',
        component: fenpeijilu
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '系统首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
