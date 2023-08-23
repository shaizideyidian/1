package com.dao;

import com.entity.LianxijiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LianxijiluVO;
import com.entity.view.LianxijiluView;


/**
 * 联系记录
 * 
 * @author 
 * @email 
 * @date 2023-03-25 09:47:18
 */
public interface LianxijiluDao extends BaseMapper<LianxijiluEntity> {
	
	List<LianxijiluVO> selectListVO(@Param("ew") Wrapper<LianxijiluEntity> wrapper);
	
	LianxijiluVO selectVO(@Param("ew") Wrapper<LianxijiluEntity> wrapper);
	
	List<LianxijiluView> selectListView(@Param("ew") Wrapper<LianxijiluEntity> wrapper);

	List<LianxijiluView> selectListView(Pagination page,@Param("ew") Wrapper<LianxijiluEntity> wrapper);
	
	LianxijiluView selectView(@Param("ew") Wrapper<LianxijiluEntity> wrapper);
	

}
