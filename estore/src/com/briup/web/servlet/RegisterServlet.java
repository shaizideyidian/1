package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Customer;
import com.briup.common.BeanFactory;
import com.briup.common.MybatisSessionFactory;
import com.briup.common.exception.CustomerServiceException;
import com.briup.service.ICustomerService;

public class RegisterServlet extends HttpServlet {
//	通过BeanFactory.getBean方法获取一个ICustomerService实例，并将其赋值给service变量
	private ICustomerService service = 
		(ICustomerService) BeanFactory.getBean(BeanFactory.CUSTOMERSERVICE);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("userid");
		String password = request.getParameter("password");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String street1 = request.getParameter("street1");
		String zip = request.getParameter("zip");
		String telephone = request.getParameter("cellphone");
		String email = request.getParameter("email");
//		创建一个Customer对象
		Customer cus = new Customer();
		cus.setName(name);
		cus.setAddress(province+";"+city+";"+street1);
		cus.setEmail(email);
		cus.setPassword(password);
		cus.setTelephone(telephone);
		cus.setZip(zip);
//		调用service.register方法，将Customer对象作为参数传递给该方法，用于用户注册
		try {
			service.register(cus);
			response.sendRedirect("login.jsp");
		} catch (CustomerServiceException e) {
			e.printStackTrace();
//			将异常消息存储在请求中，属性名为message
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
