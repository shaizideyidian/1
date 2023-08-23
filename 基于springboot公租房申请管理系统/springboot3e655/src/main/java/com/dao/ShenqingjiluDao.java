package com.dao;

import com.entity.ShenqingjiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShenqingjiluVO;
import com.entity.view.ShenqingjiluView;


/**
 * 申请记录
 * 
 * @author 
 * @email 
 * @date 2023-04-14 16:40:14
 */
public interface ShenqingjiluDao extends BaseMapper<ShenqingjiluEntity> {
	
	List<ShenqingjiluVO> selectListVO(@Param("ew") Wrapper<ShenqingjiluEntity> wrapper);
	
	ShenqingjiluVO selectVO(@Param("ew") Wrapper<ShenqingjiluEntity> wrapper);
	
	List<ShenqingjiluView> selectListView(@Param("ew") Wrapper<ShenqingjiluEntity> wrapper);

	List<ShenqingjiluView> selectListView(Pagination page,@Param("ew") Wrapper<ShenqingjiluEntity> wrapper);
	
	ShenqingjiluView selectView(@Param("ew") Wrapper<ShenqingjiluEntity> wrapper);
	

}
