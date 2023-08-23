package com.dao;

import com.entity.DiscusschongwushangpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusschongwushangpinVO;
import com.entity.view.DiscusschongwushangpinView;


/**
 * 宠物商品评论表
 * 
 * @author 
 * @email 
 * @date 2023-03-25 09:47:18
 */
public interface DiscusschongwushangpinDao extends BaseMapper<DiscusschongwushangpinEntity> {
	
	List<DiscusschongwushangpinVO> selectListVO(@Param("ew") Wrapper<DiscusschongwushangpinEntity> wrapper);
	
	DiscusschongwushangpinVO selectVO(@Param("ew") Wrapper<DiscusschongwushangpinEntity> wrapper);
	
	List<DiscusschongwushangpinView> selectListView(@Param("ew") Wrapper<DiscusschongwushangpinEntity> wrapper);

	List<DiscusschongwushangpinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusschongwushangpinEntity> wrapper);
	
	DiscusschongwushangpinView selectView(@Param("ew") Wrapper<DiscusschongwushangpinEntity> wrapper);
	

}
