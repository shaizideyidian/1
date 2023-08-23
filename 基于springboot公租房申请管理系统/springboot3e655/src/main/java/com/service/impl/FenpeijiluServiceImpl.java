package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.FenpeijiluDao;
import com.entity.FenpeijiluEntity;
import com.service.FenpeijiluService;
import com.entity.vo.FenpeijiluVO;
import com.entity.view.FenpeijiluView;

@Service("fenpeijiluService")
public class FenpeijiluServiceImpl extends ServiceImpl<FenpeijiluDao, FenpeijiluEntity> implements FenpeijiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FenpeijiluEntity> page = this.selectPage(
                new Query<FenpeijiluEntity>(params).getPage(),
                new EntityWrapper<FenpeijiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FenpeijiluEntity> wrapper) {
		  Page<FenpeijiluView> page =new Query<FenpeijiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<FenpeijiluVO> selectListVO(Wrapper<FenpeijiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FenpeijiluVO selectVO(Wrapper<FenpeijiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FenpeijiluView> selectListView(Wrapper<FenpeijiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FenpeijiluView selectView(Wrapper<FenpeijiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
