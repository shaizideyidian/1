package com.briup.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Customer;
import com.briup.common.BeanFactory;
import com.briup.common.MybatisSessionFactory;
import com.briup.common.exception.CustomerServiceException;
import com.briup.dao.ICustomerDao;
import com.briup.service.ICustomerService;

public class CustomerServiceImpl 
implements ICustomerService{
	private ICustomerDao dao = 
		(ICustomerDao) BeanFactory.getBean(BeanFactory.CUSTOMERDAO);
	@Override
	public void register(Customer customer) throws CustomerServiceException {
//		通过调用MybatisSessionFactory.getSession获取当前线程中的sqlsession对象
		SqlSession session = 
				MybatisSessionFactory.getSession();
		//根据用户名查询用户
		try {
//			通过调用dao对象的findCustomerByName方法根据用户名查询用户信息
			Customer cus =
				dao.findCustomerByName(
						customer.getName());
//			如果查询到的cus对象不为null，抛出一个异常
			if(cus!=null){
				throw new CustomerServiceException("用户名已被占用");
			}
//			通过调用dao对象的saveCustomer方法，保存customer对象到数据库中
			dao.saveCustomer(customer);
//			手动调用session对象的commit方法，提交事务，将数据持久化到数据库中
			session.commit();
//			如果捕获到CustomerServiceException异常，在异常处理中打印异常堆栈跟踪，并进行事务回滚
		} catch(CustomerServiceException e){
			e.printStackTrace();
			session.rollback();
			throw e;
//			如果捕获到其他异常，在异常处打印异常堆栈跟踪，并进行事务回滚
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
	}

	@Override
	public Customer login(String name, String password) throws CustomerServiceException {
		try {
//			通过调用dao.findCustomerByName根据用户名查询用户信息
			Customer cus = 
				dao.findCustomerByName(name);
//			如果查询到的cus对象为null，抛出一个异常
			if(cus==null){
				throw new CustomerServiceException("当前用户名无效");
			}else{
//				如果给定的密码与查询到的用户密码匹配，则直接返回查询到的cus对象，表示验证成功
				if(password.equals(cus.getPassword())){
					return cus;
				}else{
//					如果密码不匹配，抛出一个异常
					throw new CustomerServiceException("密码不正确");
				}
			}
			
		}catch (CustomerServiceException e) {
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Customer customer) throws CustomerServiceException {
		
	}

}
