package com.briup.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Customer;
import com.briup.bean.CustomerMapper;
import com.briup.common.MybatisSessionFactory;
import com.briup.dao.ICustomerDao;

public class CustomerDaoImpl 
implements ICustomerDao{

	@Override
	public void saveCustomer(Customer customer) throws Exception {
//		通过调用MybatisSessionFactory.getSession获取当前线程中的sqlSession对象
		SqlSession session = MybatisSessionFactory.getSession();
//		通过session.getMapper方法获取一个实现了CustomerMapper接口的代理对象，用来执行针对Customer实体的数据库操作
		CustomerMapper cm = 
			session.getMapper(CustomerMapper.class);
//		通过调用CustomerMapper接口中的insertCustomer方法向数据库中插入一个customer对象
		cm.insertCustomer(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
	}

	@Override
	public Customer findCustomerByName(String name) throws Exception {
		SqlSession session = MybatisSessionFactory.getSession();
		CustomerMapper cm = 
			session.getMapper(CustomerMapper.class);
		return cm.selectCustomerByName(name);
	}
}
