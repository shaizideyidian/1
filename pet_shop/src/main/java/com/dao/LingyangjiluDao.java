package com.dao;

import com.entity.LingyangjiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LingyangjiluVO;
import com.entity.view.LingyangjiluView;


/**
 * 领养记录
 * 
 * @author 
 * @email 
 * @date 2023-03-25 09:47:18
 */
public interface LingyangjiluDao extends BaseMapper<LingyangjiluEntity> {
	
	List<LingyangjiluVO> selectListVO(@Param("ew") Wrapper<LingyangjiluEntity> wrapper);
	
	LingyangjiluVO selectVO(@Param("ew") Wrapper<LingyangjiluEntity> wrapper);
	
	List<LingyangjiluView> selectListView(@Param("ew") Wrapper<LingyangjiluEntity> wrapper);

	List<LingyangjiluView> selectListView(Pagination page,@Param("ew") Wrapper<LingyangjiluEntity> wrapper);
	
	LingyangjiluView selectView(@Param("ew") Wrapper<LingyangjiluEntity> wrapper);
	

}
