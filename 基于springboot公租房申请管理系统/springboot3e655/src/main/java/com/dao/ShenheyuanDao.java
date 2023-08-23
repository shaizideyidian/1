package com.dao;

import com.entity.ShenheyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShenheyuanVO;
import com.entity.view.ShenheyuanView;


/**
 * 审核员
 * 
 * @author 
 * @email 
 * @date 2023-04-14 16:40:14
 */
public interface ShenheyuanDao extends BaseMapper<ShenheyuanEntity> {
	
	List<ShenheyuanVO> selectListVO(@Param("ew") Wrapper<ShenheyuanEntity> wrapper);
	
	ShenheyuanVO selectVO(@Param("ew") Wrapper<ShenheyuanEntity> wrapper);
	
	List<ShenheyuanView> selectListView(@Param("ew") Wrapper<ShenheyuanEntity> wrapper);

	List<ShenheyuanView> selectListView(Pagination page,@Param("ew") Wrapper<ShenheyuanEntity> wrapper);
	
	ShenheyuanView selectView(@Param("ew") Wrapper<ShenheyuanEntity> wrapper);
	

}
