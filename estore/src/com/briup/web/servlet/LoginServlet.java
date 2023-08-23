package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Customer;
import com.briup.bean.ShoppingCart;
import com.briup.common.BeanFactory;
import com.briup.common.exception.CustomerServiceException;
import com.briup.service.ICustomerService;

public class LoginServlet extends HttpServlet {
//	通过BeanFactory.getBean方法获取一个ICustomerService实例，并将其赋值给service变量
	private ICustomerService service = 
			(ICustomerService) BeanFactory.getBean(BeanFactory.CUSTOMERSERVICE);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		设置请求和响应的字符编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
//		获取名为userid和password的参数值，从请求中获取用户名和密码
		String name = request.getParameter("userid");
		String password = request.getParameter("password");
//		调用service.login方法，将用户名和密码作为参数传递给该方法，用于用户登录
		try {
			Customer cus =
					service.login(name, password);
//			如果登陆成功获取当前会话，并使用setAttribute方法将登陆成功Customer对象存储在会话中，属性名为customer
			HttpSession session = request.getSession();
			session.setAttribute("customer", cus);
//			调用response.sendRedirect方法响应重定向
			response.sendRedirect("index.jsp");
		} catch (CustomerServiceException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
//			将请求转发给login.jsp页面，以便在登陆页面显示错误信息
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
