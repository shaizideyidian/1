package com.briup.common.exception;

//定义一个异常类，异常类用于在程序发生错误或异常情况时抛出和处理异常
public class CustomerServiceException extends Exception {

//	无参构造方法
	public CustomerServiceException() {
		// TODO Auto-generated constructor stub
	}

//	接受一个参数字符串arg0的构造方法
	public CustomerServiceException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

//	接受一个参数Throwable arg0的构造方法
//	Throwable是一个基类，他是Exception和Error的父类
	public CustomerServiceException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

//	接受两个参数字符串arg0, Throwable arg1的构造方法
	public CustomerServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
