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


import com.dao.LingyangjiluDao;
import com.entity.LingyangjiluEntity;
import com.service.LingyangjiluService;
import com.entity.vo.LingyangjiluVO;
import com.entity.view.LingyangjiluView;

@Service("lingyangjiluService")
public class LingyangjiluServiceImpl extends ServiceImpl<LingyangjiluDao, LingyangjiluEntity> implements LingyangjiluService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LingyangjiluEntity> page = this.selectPage(
                new Query<LingyangjiluEntity>(params).getPage(),
                new EntityWrapper<LingyangjiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LingyangjiluEntity> wrapper) {
		  Page<LingyangjiluView> page =new Query<LingyangjiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LingyangjiluVO> selectListVO(Wrapper<LingyangjiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LingyangjiluVO selectVO(Wrapper<LingyangjiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LingyangjiluView> selectListView(Wrapper<LingyangjiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LingyangjiluView selectView(Wrapper<LingyangjiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
