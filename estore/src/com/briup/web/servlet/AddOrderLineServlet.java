package com.briup.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Book;
import com.briup.bean.OrderLine;
import com.briup.bean.ShoppingCart;

public class AddOrderLineServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		获取一个名为bookid的参数值，该参数是从请求中获取的书籍ID
		String bookid = request.getParameter("bookid");
//		通过getServletContext方法获取ServletContext对象
		ServletContext context = getServletContext();
//		通过context.getAttribute方法从ServletContext对象中获取存储的图书列表Map<Long, Book>
		Map<Long, Book> books = (Map<Long, Book>) context.getAttribute("books");
//		根据获取到的图书列表和书籍ID，从图书列表中获取到对应的图书对象
		Book book = books.get(Long.parseLong(bookid));
//		创建一个订单项对象，并设置其属性值为获取到的图书对象和数量为1
		OrderLine line = new OrderLine();
		line.setBook(book);
		line.setNum(1L);
//		获取当前会话
		HttpSession session = request.getSession();
//		从会话中获取购物车对象ShoppingCart
		ShoppingCart sc = (ShoppingCart) session.getAttribute("cart");
//		调用购物车对象的方法，将订单项添加到购物车中
		sc.addOrderline(line);
//		使用方法将响应重定向到一个页面
		response.sendRedirect("shopcart.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
