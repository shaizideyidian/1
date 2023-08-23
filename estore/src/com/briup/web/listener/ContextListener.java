package com.briup.web.listener;

import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.briup.bean.Book;
import com.briup.common.BeanFactory;
import com.briup.common.exception.OrderServiceException;
import com.briup.service.IOrderService;
//定义一个监听器类
public class ContextListener implements ServletContextListener{
//	通过BeanFactory.getBean方法获取一个IOrderService实例，并将其赋值给service变量
	private IOrderService service = (IOrderService)BeanFactory.getBean(BeanFactory.ORDERSERVICE);

	@Override
//	在该方法中实现了监听器的初始化逻辑
	public void contextInitialized(ServletContextEvent sce) {
//		try块中调用了service对象的listAllBook方法，获取一个Map类型的图书列表
		try {
			Map<Long, Book> map = service.listAllBook();
//			使用ServletContextEvent对象的getServletContext方法获取ServletContext对象，并通过setAttribute方法将图书列表保存在ServletContext对象中，以便在整个应用程序范围内共享
			sce.getServletContext().setAttribute("books", map);
		} catch (OrderServiceException e) {
			e.printStackTrace();
		}
	}

	@Override
//	实现了监听器的销毁逻辑
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
