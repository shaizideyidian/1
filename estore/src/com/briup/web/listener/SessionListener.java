package com.briup.web.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.briup.bean.ShoppingCart;

//定义一个监听器类
public class SessionListener implements HttpSessionListener {
    //    在sessionCreated方法中实现了监听器的会话创建逻辑
    public void sessionCreated(HttpSessionEvent se) {
//        通过HttpSessionEvent对象的getSession方法获取HttpSession对象
        HttpSession session = se.getSession();
//        创建一个ShoppingCart对象用于购物车功能
        ShoppingCart sc = new ShoppingCart();
//        调用HttpSession对象的setAttribute方法，将购物车对象存储在会话中，属性名为cart
        session.setAttribute("cart", sc);
        System.out.println("session listener");
    }
//方法实现了监听器的会话销毁逻辑
    public void sessionDestroyed(HttpSessionEvent se) {
    }
}
