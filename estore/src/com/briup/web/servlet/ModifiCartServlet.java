package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.ShoppingCart;

public class ModifiCartServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookid = request.getParameter("productid");
		String number = request.getParameter("number");
		HttpSession session = request.getSession();
//		从会话中获取购物车对象ShoppingCart
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
//		调用购物车对象方法，将产品ID的数量作为参数传递给该方法，以修改购物车中的某一订单项的数量
		cart.modifyLine(Long.parseLong(bookid),Long.parseLong(number));
		response.sendRedirect("shopcart.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
