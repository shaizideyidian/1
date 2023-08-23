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


import com.dao.ShenqingjiluDao;
import com.entity.ShenqingjiluEntity;
import com.service.ShenqingjiluService;
import com.entity.vo.ShenqingjiluVO;
import com.entity.view.ShenqingjiluView;

@Service("shenqingjiluService")
public class ShenqingjiluServiceImpl extends ServiceImpl<ShenqingjiluDao, ShenqingjiluEntity> implements ShenqingjiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShenqingjiluEntity> page = this.selectPage(
                new Query<ShenqingjiluEntity>(params).getPage(),
                new EntityWrapper<ShenqingjiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShenqingjiluEntity> wrapper) {
		  Page<ShenqingjiluView> page =new Query<ShenqingjiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShenqingjiluVO> selectListVO(Wrapper<ShenqingjiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShenqingjiluVO selectVO(Wrapper<ShenqingjiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShenqingjiluView> selectListView(Wrapper<ShenqingjiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShenqingjiluView selectView(Wrapper<ShenqingjiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
