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


import com.dao.JiaofeijiluDao;
import com.entity.JiaofeijiluEntity;
import com.service.JiaofeijiluService;
import com.entity.vo.JiaofeijiluVO;
import com.entity.view.JiaofeijiluView;

@Service("jiaofeijiluService")
public class JiaofeijiluServiceImpl extends ServiceImpl<JiaofeijiluDao, JiaofeijiluEntity> implements JiaofeijiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiaofeijiluEntity> page = this.selectPage(
                new Query<JiaofeijiluEntity>(params).getPage(),
                new EntityWrapper<JiaofeijiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiaofeijiluEntity> wrapper) {
		  Page<JiaofeijiluView> page =new Query<JiaofeijiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JiaofeijiluVO> selectListVO(Wrapper<JiaofeijiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiaofeijiluVO selectVO(Wrapper<JiaofeijiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiaofeijiluView> selectListView(Wrapper<JiaofeijiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiaofeijiluView selectView(Wrapper<JiaofeijiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
