package com.dao;

import com.entity.HuanfangshenqingjiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HuanfangshenqingjiluVO;
import com.entity.view.HuanfangshenqingjiluView;


/**
 * 换房申请记录
 * 
 * @author 
 * @email 
 * @date 2023-04-14 16:40:14
 */
public interface HuanfangshenqingjiluDao extends BaseMapper<HuanfangshenqingjiluEntity> {
	
	List<HuanfangshenqingjiluVO> selectListVO(@Param("ew") Wrapper<HuanfangshenqingjiluEntity> wrapper);
	
	HuanfangshenqingjiluVO selectVO(@Param("ew") Wrapper<HuanfangshenqingjiluEntity> wrapper);
	
	List<HuanfangshenqingjiluView> selectListView(@Param("ew") Wrapper<HuanfangshenqingjiluEntity> wrapper);

	List<HuanfangshenqingjiluView> selectListView(Pagination page,@Param("ew") Wrapper<HuanfangshenqingjiluEntity> wrapper);
	
	HuanfangshenqingjiluView selectView(@Param("ew") Wrapper<HuanfangshenqingjiluEntity> wrapper);
	

}
