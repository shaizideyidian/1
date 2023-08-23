package com.dao;

import com.entity.DiscusslingyangxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusslingyangxinxiVO;
import com.entity.view.DiscusslingyangxinxiView;


/**
 * 领养信息评论表
 * 
 * @author 
 * @email 
 * @date 2023-03-25 09:47:18
 */
public interface DiscusslingyangxinxiDao extends BaseMapper<DiscusslingyangxinxiEntity> {
	
	List<DiscusslingyangxinxiVO> selectListVO(@Param("ew") Wrapper<DiscusslingyangxinxiEntity> wrapper);
	
	DiscusslingyangxinxiVO selectVO(@Param("ew") Wrapper<DiscusslingyangxinxiEntity> wrapper);
	
	List<DiscusslingyangxinxiView> selectListView(@Param("ew") Wrapper<DiscusslingyangxinxiEntity> wrapper);

	List<DiscusslingyangxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusslingyangxinxiEntity> wrapper);
	
	DiscusslingyangxinxiView selectView(@Param("ew") Wrapper<DiscusslingyangxinxiEntity> wrapper);
	

}
