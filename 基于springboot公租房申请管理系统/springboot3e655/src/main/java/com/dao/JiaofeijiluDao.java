package com.dao;

import com.entity.JiaofeijiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiaofeijiluVO;
import com.entity.view.JiaofeijiluView;


/**
 * 缴费记录
 * 
 * @author 
 * @email 
 * @date 2023-04-14 16:40:14
 */
public interface JiaofeijiluDao extends BaseMapper<JiaofeijiluEntity> {
	
	List<JiaofeijiluVO> selectListVO(@Param("ew") Wrapper<JiaofeijiluEntity> wrapper);
	
	JiaofeijiluVO selectVO(@Param("ew") Wrapper<JiaofeijiluEntity> wrapper);
	
	List<JiaofeijiluView> selectListView(@Param("ew") Wrapper<JiaofeijiluEntity> wrapper);

	List<JiaofeijiluView> selectListView(Pagination page,@Param("ew") Wrapper<JiaofeijiluEntity> wrapper);
	
	JiaofeijiluView selectView(@Param("ew") Wrapper<JiaofeijiluEntity> wrapper);
	

}
