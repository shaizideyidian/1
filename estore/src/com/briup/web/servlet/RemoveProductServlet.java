package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.ShoppingCart;

public class RemoveProductServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getParameter方法获取名为productid的参数值，并使用Long.parseLong方法将其转换为long类型
		Long bookid = Long.parseLong(request.getParameter("productid"));
//		使用request.getSession().getAttribute方法获取名为cart的属性值，该属性值是从会话中获取的购物车对象
		ShoppingCart sc = (ShoppingCart) request.getSession().getAttribute("cart");
//		调用购物车对象的dropLine方法，将bookid作为参数传递给该方法，以删除购物车中与bookid匹配的订单项
		sc.dropLine(bookid);
		response.sendRedirect("shopcart.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
