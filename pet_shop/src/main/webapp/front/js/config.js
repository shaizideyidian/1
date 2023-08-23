
var projectName = '基于SSM框架的宠物商城系统';
/**
 * 轮播图配置
 */
var swiper = {
	// 设定轮播容器宽度，支持像素和百分比
	width: '100%',
	height: '400px',
	// hover（悬停显示）
	// always（始终显示）
	// none（始终不显示）
	arrow: 'none',
	// default（左右切换）
	// updown（上下切换）
	// fade（渐隐渐显切换）
	anim: 'default',
	// 自动切换的时间间隔
	// 默认3000
	interval: 2000,
	// 指示器位置
	// inside（容器内部）
	// outside（容器外部）
	// none（不显示）
	indicator: 'outside'
}

/**
 * 个人中心菜单
 */
var centerMenu = [{
	name: '个人中心',
	url: '../' + localStorage.getItem('userTable') + '/center.jsp'
}, 
{
	name: '我的发布',
	url: '../forum/list-my.jsp'
},

{
	name: '我的订单',
	url: '../shop-order/list.jsp'
},

{
	name: '我的地址',
	url: '../shop-address/list.jsp'
},

{
	name: '我的收藏',
	url: '../storeup/list.jsp'
}
]


var indexNav = [

{
	name: '商家',
	url: './pages/shangjia/list.jsp'
}, 
{
	name: '宠物商品',
	url: './pages/chongwushangpin/list.jsp'
}, 
{
	name: '领养信息',
	url: './pages/lingyangxinxi/list.jsp'
}, 

{
	name: '养宠心得',
	url: './pages/forum/list.jsp'
}, 
{
	name: '站内公告',
	url: './pages/news/list.jsp'
},
]

var adminurl =  "http://localhost:8080/jspmyg7up/index.jsp";

var cartFlag = false

var chatFlag = false


cartFlag = true


var menu = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-camera","buttons":["新增","查看","修改","删除","审核"],"menu":"商家","menuJump":"列表","tableName":"shangjia"}],"menu":"商家管理"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["新增","查看","修改","删除","审核"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"appFrontIcon":"cuIcon-form","buttons":["新增","查看","修改","删除"],"menu":"商品分类","menuJump":"列表","tableName":"shangpinfenlei"}],"menu":"商品分类管理"},{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["查看","修改","删除"],"menu":"宠物商品","menuJump":"列表","tableName":"chongwushangpin"}],"menu":"宠物商品管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","修改","删除","审核"],"menu":"领养信息","menuJump":"列表","tableName":"lingyangxinxi"}],"menu":"领养信息管理"},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看","修改","删除"],"menu":"领养记录","menuJump":"列表","tableName":"lingyangjilu"}],"menu":"领养记录管理"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["查看","修改","删除"],"menu":"联系记录","menuJump":"列表","tableName":"lianxijilu"}],"menu":"联系记录管理"},{"child":[{"appFrontIcon":"cuIcon-group","buttons":["查看","修改","删除"],"menu":"养宠心得","tableName":"forum"}],"menu":"养宠心得"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看","修改"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"站内公告","tableName":"news"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看","联系客服"],"menu":"商家列表","menuJump":"列表","tableName":"shangjia"}],"menu":"商家模块"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看"],"menu":"宠物商品列表","menuJump":"列表","tableName":"chongwushangpin"}],"menu":"宠物商品模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","申请领养"],"menu":"领养信息列表","menuJump":"列表","tableName":"lingyangxinxi"}],"menu":"领养信息模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-form","buttons":["查看","新增"],"menu":"商品分类","menuJump":"列表","tableName":"shangpinfenlei"}],"menu":"商品分类管理"},{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["新增","查看","修改","删除","查看评论"],"menu":"宠物商品","menuJump":"列表","tableName":"chongwushangpin"}],"menu":"宠物商品管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["新增","查看","修改","删除","查看评论"],"menu":"领养信息","menuJump":"列表","tableName":"lingyangxinxi"}],"menu":"领养信息管理"},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看","审核"],"menu":"领养记录","menuJump":"列表","tableName":"lingyangjilu"}],"menu":"领养记录管理"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["查看","审核"],"menu":"联系记录","menuJump":"列表","tableName":"lianxijilu"}],"menu":"联系记录管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","发货"],"menu":"已支付订单","tableName":"orders/已支付"},{"appFrontIcon":"cuIcon-news","buttons":["查看","类销额","品销额"],"menu":"已完成订单","tableName":"orders/已完成"},{"appFrontIcon":"cuIcon-news","buttons":["查看"],"menu":"已取消订单","tableName":"orders/已取消"},{"appFrontIcon":"cuIcon-medal","buttons":["查看"],"menu":"已退款订单","tableName":"orders/已退款"},{"appFrontIcon":"cuIcon-explore","buttons":["查看"],"menu":"未支付订单","tableName":"orders/未支付"},{"appFrontIcon":"cuIcon-brand","buttons":["查看"],"menu":"已发货订单","tableName":"orders/已发货"}],"menu":"订单管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看","联系客服"],"menu":"商家列表","menuJump":"列表","tableName":"shangjia"}],"menu":"商家模块"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看"],"menu":"宠物商品列表","menuJump":"列表","tableName":"chongwushangpin"}],"menu":"宠物商品模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","申请领养"],"menu":"领养信息列表","menuJump":"列表","tableName":"lingyangxinxi"}],"menu":"领养信息模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"商家","tableName":"shangjia"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看"],"menu":"领养记录","menuJump":"列表","tableName":"lingyangjilu"}],"menu":"领养记录管理"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["查看"],"menu":"联系记录","menuJump":"列表","tableName":"lianxijilu"}],"menu":"联系记录管理"},{"child":[{"appFrontIcon":"cuIcon-favor","buttons":["查看","删除"],"menu":"我的收藏管理","tableName":"storeup"}],"menu":"我的收藏管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看","联系客服"],"menu":"商家列表","menuJump":"列表","tableName":"shangjia"}],"menu":"商家模块"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看"],"menu":"宠物商品列表","menuJump":"列表","tableName":"chongwushangpin"}],"menu":"宠物商品模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","申请领养"],"menu":"领养信息列表","menuJump":"列表","tableName":"lingyangxinxi"}],"menu":"领养信息模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"}]


var isAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].backMenu.length;j++){
                for(let k=0;k<menus[i].backMenu[j].child.length;k++){
                    if(tableName==menus[i].backMenu[j].child[k].tableName){
                        let buttons = menus[i].backMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}

var isFrontAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].frontMenu.length;j++){
                for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
                    if(tableName==menus[i].frontMenu[j].child[k].tableName){
                        let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}
