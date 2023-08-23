package com.briup.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Customer;
import com.briup.bean.OrderLine;
import com.briup.bean.Orderform;
import com.briup.bean.ShoppingCart;
import com.briup.common.BeanFactory;
import com.briup.common.exception.OrderServiceException;
import com.briup.service.IOrderService;
public class SaveOrderServlet extends HttpServlet {
//	通过BeanFactory.getBean方法获取一个IOrderService实例，并将其赋值给service变量
	private IOrderService service = (IOrderService)BeanFactory.getBean(BeanFactory.ORDERSERVICE);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
//		从会话中获取名为customer的属性值，该属性值是从会话中获取的用户对象Customer
		Customer cust = (Customer) session.getAttribute("customer");
//		从会话中获取名为cart的属性值，该属性值是从会话中获取的购物车对象
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
//		创建一个Orderform对象，并通过setCost等方法将购物车的总费用、用户对象和当前日期设置到Orderform对象的相应属性中
		Orderform orderform = new Orderform();
		orderform.setCost(cart.getCost());
		orderform.setCust(cust);
		orderform.setOrderDate(new Date());
//		使用cart.getMap().values方法获取购物车对象中所有订单项的集合，并将其转换为List类型
		Collection<OrderLine> lines = cart.getMap().values();
		List<OrderLine> list = new ArrayList<>(lines);
//		将订单项集合设置到Orderform对象的orderLines属性中，并将每个订单项设置orderform对象作为关联
		orderform.setOrderLines(list);
		for(OrderLine l:list){
			l.setOrderform(orderform);
		}
		try {
			service.saveOrder(orderform);
			response.sendRedirect("user/order.jsp");
		} catch (OrderServiceException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
