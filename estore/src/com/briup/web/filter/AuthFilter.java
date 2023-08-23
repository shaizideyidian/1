package com.briup.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Customer;

/**
 * Servlet Filter implementation class AuthFilter
 */
//定义一个过滤器类
public class AuthFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
//	需要实现的过滤器的逻辑
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		做两个对象类型强转
		HttpServletRequest req =
				(HttpServletRequest) request;
		HttpServletResponse resp = 
				(HttpServletResponse) response;
//		获取当前会话
		HttpSession session = req.getSession();
//		从会话中获取名为“customer”的属性，并将其强制转换为Customer类型
		Customer cus = 
				(Customer)session.getAttribute("customer");
//		调用chain.doFilter方法继续处理请求
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
