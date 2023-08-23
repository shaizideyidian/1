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


import com.dao.ChongwushangpinDao;
import com.entity.ChongwushangpinEntity;
import com.service.ChongwushangpinService;
import com.entity.vo.ChongwushangpinVO;
import com.entity.view.ChongwushangpinView;

@Service("chongwushangpinService")
public class ChongwushangpinServiceImpl extends ServiceImpl<ChongwushangpinDao, ChongwushangpinEntity> implements ChongwushangpinService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChongwushangpinEntity> page = this.selectPage(
                new Query<ChongwushangpinEntity>(params).getPage(),
                new EntityWrapper<ChongwushangpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChongwushangpinEntity> wrapper) {
		  Page<ChongwushangpinView> page =new Query<ChongwushangpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChongwushangpinVO> selectListVO(Wrapper<ChongwushangpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChongwushangpinVO selectVO(Wrapper<ChongwushangpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChongwushangpinView> selectListView(Wrapper<ChongwushangpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChongwushangpinView selectView(Wrapper<ChongwushangpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
