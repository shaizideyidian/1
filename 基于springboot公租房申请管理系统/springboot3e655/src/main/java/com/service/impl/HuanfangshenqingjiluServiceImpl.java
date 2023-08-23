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


import com.dao.HuanfangshenqingjiluDao;
import com.entity.HuanfangshenqingjiluEntity;
import com.service.HuanfangshenqingjiluService;
import com.entity.vo.HuanfangshenqingjiluVO;
import com.entity.view.HuanfangshenqingjiluView;

@Service("huanfangshenqingjiluService")
public class HuanfangshenqingjiluServiceImpl extends ServiceImpl<HuanfangshenqingjiluDao, HuanfangshenqingjiluEntity> implements HuanfangshenqingjiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuanfangshenqingjiluEntity> page = this.selectPage(
                new Query<HuanfangshenqingjiluEntity>(params).getPage(),
                new EntityWrapper<HuanfangshenqingjiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuanfangshenqingjiluEntity> wrapper) {
		  Page<HuanfangshenqingjiluView> page =new Query<HuanfangshenqingjiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HuanfangshenqingjiluVO> selectListVO(Wrapper<HuanfangshenqingjiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuanfangshenqingjiluVO selectVO(Wrapper<HuanfangshenqingjiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuanfangshenqingjiluView> selectListView(Wrapper<HuanfangshenqingjiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuanfangshenqingjiluView selectView(Wrapper<HuanfangshenqingjiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
