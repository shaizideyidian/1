package com.briup.common.exception;

public class OrderServiceException extends Exception {

//	无参构造方法
	public OrderServiceException() {
		// TODO Auto-generated constructor stub
	}

//	接受一个参数message的构造方法
	public OrderServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

//	接受一个参数Throwable cause的构造方法
	public OrderServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

//	接收两个参数message, Throwable cause的构造方法
	public OrderServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
