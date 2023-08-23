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


import com.dao.DiscusslingyangxinxiDao;
import com.entity.DiscusslingyangxinxiEntity;
import com.service.DiscusslingyangxinxiService;
import com.entity.vo.DiscusslingyangxinxiVO;
import com.entity.view.DiscusslingyangxinxiView;

@Service("discusslingyangxinxiService")
public class DiscusslingyangxinxiServiceImpl extends ServiceImpl<DiscusslingyangxinxiDao, DiscusslingyangxinxiEntity> implements DiscusslingyangxinxiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusslingyangxinxiEntity> page = this.selectPage(
                new Query<DiscusslingyangxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscusslingyangxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusslingyangxinxiEntity> wrapper) {
		  Page<DiscusslingyangxinxiView> page =new Query<DiscusslingyangxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusslingyangxinxiVO> selectListVO(Wrapper<DiscusslingyangxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusslingyangxinxiVO selectVO(Wrapper<DiscusslingyangxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusslingyangxinxiView> selectListView(Wrapper<DiscusslingyangxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusslingyangxinxiView selectView(Wrapper<DiscusslingyangxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
