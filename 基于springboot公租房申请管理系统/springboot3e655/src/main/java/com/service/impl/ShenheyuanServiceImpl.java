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


import com.dao.ShenheyuanDao;
import com.entity.ShenheyuanEntity;
import com.service.ShenheyuanService;
import com.entity.vo.ShenheyuanVO;
import com.entity.view.ShenheyuanView;

@Service("shenheyuanService")
public class ShenheyuanServiceImpl extends ServiceImpl<ShenheyuanDao, ShenheyuanEntity> implements ShenheyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShenheyuanEntity> page = this.selectPage(
                new Query<ShenheyuanEntity>(params).getPage(),
                new EntityWrapper<ShenheyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShenheyuanEntity> wrapper) {
		  Page<ShenheyuanView> page =new Query<ShenheyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShenheyuanVO> selectListVO(Wrapper<ShenheyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShenheyuanVO selectVO(Wrapper<ShenheyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShenheyuanView> selectListView(Wrapper<ShenheyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShenheyuanView selectView(Wrapper<ShenheyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
