package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FenpeijiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FenpeijiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FenpeijiluView;


/**
 * 分配记录
 *
 * @author 
 * @email 
 * @date 2023-04-14 16:40:14
 */
public interface FenpeijiluService extends IService<FenpeijiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FenpeijiluVO> selectListVO(Wrapper<FenpeijiluEntity> wrapper);
   	
   	FenpeijiluVO selectVO(@Param("ew") Wrapper<FenpeijiluEntity> wrapper);
   	
   	List<FenpeijiluView> selectListView(Wrapper<FenpeijiluEntity> wrapper);
   	
   	FenpeijiluView selectView(@Param("ew") Wrapper<FenpeijiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FenpeijiluEntity> wrapper);
   	

}

