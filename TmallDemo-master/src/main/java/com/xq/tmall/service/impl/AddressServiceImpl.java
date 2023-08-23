package com.xq.tmall.service.impl;

import com.xq.tmall.dao.AddressMapper;
import com.xq.tmall.entity.Address;
import com.xq.tmall.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressMapper addressMapper;
    public void setAddressMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }
//Transactional注解用于标识一个方法或类需要在事务中执行
//    用在方法上表示该方法需要在一个新的事务中执行，并且在捕获到异常时进行回滚操作
//    propagation = Propagation.REQUIRED指定事务的传播行为REQUIRED，表示如果当前已存在事务，方法将在该事务内执行，如果当前没有事务，则会创建一个新的事务
//    rollbackFor = Exception.class指定在捕获到Exception及其子类异常时进行事务回滚
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public boolean add(Address address) {
        return addressMapper.insertOne(address)>0;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public boolean update(Address address) {
        return addressMapper.updateOne(address)>0;
    }

    @Override
    public List<Address> getList(String address_name, String address_regionId) {
        return addressMapper.select(address_name,address_regionId);
    }

    @Override
    public Address get(String address_areaId) {
        return addressMapper.selectOne(address_areaId);
    }

    @Override
    public List<Address> getRoot() {
        return addressMapper.selectRoot();
    }
}
