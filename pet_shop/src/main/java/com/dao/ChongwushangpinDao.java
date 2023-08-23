package com.dao;

import com.entity.ChongwushangpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChongwushangpinVO;
import com.entity.view.ChongwushangpinView;


/**
 * 宠物商品
 * 
 * @author 
 * @email 
 * @date 2023-03-25 09:47:18
 */
public interface ChongwushangpinDao extends BaseMapper<ChongwushangpinEntity> {
	
	List<ChongwushangpinVO> selectListVO(@Param("ew") Wrapper<ChongwushangpinEntity> wrapper);
	
	ChongwushangpinVO selectVO(@Param("ew") Wrapper<ChongwushangpinEntity> wrapper);
	
	List<ChongwushangpinView> selectListView(@Param("ew") Wrapper<ChongwushangpinEntity> wrapper);

	List<ChongwushangpinView> selectListView(Pagination page,@Param("ew") Wrapper<ChongwushangpinEntity> wrapper);
	
	ChongwushangpinView selectView(@Param("ew") Wrapper<ChongwushangpinEntity> wrapper);
	

}
