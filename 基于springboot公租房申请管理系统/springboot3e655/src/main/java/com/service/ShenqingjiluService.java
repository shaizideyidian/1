package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShenqingjiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShenqingjiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShenqingjiluView;


/**
 * 申请记录
 *
 * @author 
 * @email 
 * @date 2023-04-14 16:40:14
 */
public interface ShenqingjiluService extends IService<ShenqingjiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShenqingjiluVO> selectListVO(Wrapper<ShenqingjiluEntity> wrapper);
   	
   	ShenqingjiluVO selectVO(@Param("ew") Wrapper<ShenqingjiluEntity> wrapper);
   	
   	List<ShenqingjiluView> selectListView(Wrapper<ShenqingjiluEntity> wrapper);
   	
   	ShenqingjiluView selectView(@Param("ew") Wrapper<ShenqingjiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShenqingjiluEntity> wrapper);
   	

}

