package com.briup.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Book;
import com.briup.bean.OrderLine;
import com.briup.bean.Orderform;
import com.briup.common.BeanFactory;
import com.briup.common.MybatisSessionFactory;
import com.briup.common.exception.OrderServiceException;
import com.briup.dao.IOrderDao;
import com.briup.service.IOrderService;

public class OrderServiceImpl implements IOrderService{
	private IOrderDao dao = 
		(IOrderDao) BeanFactory.getBean(BeanFactory.ORDERDAO);
	@Override
	public void saveOrder(Orderform order) throws OrderServiceException {
//		通过调用MybatisSessionFactory.getSession方法获取当前线程中的sqlsession对象
		SqlSession session = 
				MybatisSessionFactory.getSession();
		try {
//			通过调用dao对象的saveOrder方法，保存order对象到数据库中
			dao.saveOrder(order);
//			从order对象中获取订单项列表
			List<OrderLine> lines =
					order.getOrderLines();
//			对于订单项列表中的每一个订单项，用saveOrderLine保存到数据库中
			for(OrderLine line:lines){
				saveOrderLine(line);
			}
//			提交事务
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
	}
	@Override
	public void saveOrderLine(OrderLine line) {
		dao.saveOrderLine(line);
	}

	@Override
	public void delOrder(Long orderid) throws OrderServiceException {
		
	}

	@Override
	public Map<Long, Orderform> listAllOrder(Long customerid) throws OrderServiceException {
		return null;
	}

	@Override
	public Orderform findOrderById(Long orderid) throws OrderServiceException {
		return null;
	}

	@Override
	public Map<Long, Book> listAllBook() throws OrderServiceException {
		try {
			Map<Long,Book> map = dao.findAllBook();
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
