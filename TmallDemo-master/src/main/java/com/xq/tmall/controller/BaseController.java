package com.xq.tmall.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;

/**
 * 基控制器
 */
public class BaseController {
    //log4j
//    这段代码创建饿了一个Logger的对象，使用log4j2日志框架的LogManager.getLogger方法来获取
//    LogManager.ROOT_LOGGER_NAME方法获取根日志记录器，根据默认的配置文件配置的日志记录器
    protected Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    //检查管理员权限
    protected Object checkAdmin(HttpSession session){
        Object o = session.getAttribute("adminId");
        if(o==null){
            logger.info("无管理权限，返回管理员登陆页");
            return null;
        }
        logger.info("权限验证成功，管理员ID：{}",o);
        return o;
    }

    //检查用户是否登录
    protected Object checkUser(HttpSession session){
        Object o = session.getAttribute("userId");
        if(o==null){
            logger.info("用户未登录");
            return null;
        }
        logger.info("用户已登录，用户ID：{}", o);
        return o;
    }
}
