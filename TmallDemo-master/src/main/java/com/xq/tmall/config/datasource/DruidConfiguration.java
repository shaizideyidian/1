package com.xq.tmall.config.datasource;


import javax.sql.DataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @description:Druid监控数据源
 */
//@Configuration注解是Spring的注解，该注解的作用是声明一个类为配置类
@Configuration
//@PropertySource注解用于指定资源文件的路径，以加载配置属性，后面跟需要加载的配置文件的路径和文件名
@PropertySource(value = "classpath:application-dev.yml")
public class DruidConfiguration {
/**
 * 创建一个DataSource连接
 * */
	@Bean
//	@ConfigurationProperties是springboot的注解，他用于配置与数据库的连接池
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource druidDataSource() {
		DruidDataSource druidDataSource = new DruidDataSource();
		return druidDataSource;
	}

	/**
	 * 注册一个StatViewServlet
	 * 因为SpringBoot默认是不支持JSP的，想用JSP就必须使用外部容器来运行，不能使用嵌入式的Tomcat或Jetty。所以SpringBoot需要注册Servlet
	 * @return
	 */
	@Bean
	public ServletRegistrationBean druidStatViewServlet(){
		//org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
//		ServletRegistrationBean是springboot框架中的一个组件，它帮助我们再Web应用程序中注册Servlet
//		ServletRegistrationBean是注册一个servlet类，第一个参数指servlet的实例，urlMapping指映射路径，
//		StatViewServlet用途：提供监控信息展示的html页面，提供监控信息的JSON API
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");

		//添加初始化参数：initParams
		//白名单：
		servletRegistrationBean.addInitParameter("allow","127.0.0.1");
		//IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
		servletRegistrationBean.addInitParameter("deny","");
		//登录查看信息的账号密码.
		servletRegistrationBean.addInitParameter("loginUsername","admin");
		servletRegistrationBean.addInitParameter("loginPassword","123456");
		//是否能够重置数据.
		servletRegistrationBean.addInitParameter("resetEnable","false");
		return servletRegistrationBean;
	}

	/**
	 * 注册一个：filterRegistrationBean
	 * @return
	 */
	@Bean
	public FilterRegistrationBean druidStatFilter(){

		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());

		//添加过滤规则.
		filterRegistrationBean.addUrlPatterns("/*");

		//添加不需要忽略的格式信息.
		filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}
}
