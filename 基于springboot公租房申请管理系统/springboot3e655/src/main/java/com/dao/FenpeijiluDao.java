package com.dao;

import com.entity.FenpeijiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FenpeijiluVO;
import com.entity.view.FenpeijiluView;


/**
 * 分配记录
 * 
 * @author 
 * @email 
 * @date 2023-04-14 16:40:14
 */
public interface FenpeijiluDao extends BaseMapper<FenpeijiluEntity> {
	
	List<FenpeijiluVO> selectListVO(@Param("ew") Wrapper<FenpeijiluEntity> wrapper);
	
	FenpeijiluVO selectVO(@Param("ew") Wrapper<FenpeijiluEntity> wrapper);
	
	List<FenpeijiluView> selectListView(@Param("ew") Wrapper<FenpeijiluEntity> wrapper);

	List<FenpeijiluView> selectListView(Pagination page,@Param("ew") Wrapper<FenpeijiluEntity> wrapper);
	
	FenpeijiluView selectView(@Param("ew") Wrapper<FenpeijiluEntity> wrapper);
	

}
