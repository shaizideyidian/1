package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiaofeijiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiaofeijiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaofeijiluView;


/**
 * 缴费记录
 *
 * @author 
 * @email 
 * @date 2023-04-14 16:40:14
 */
public interface JiaofeijiluService extends IService<JiaofeijiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaofeijiluVO> selectListVO(Wrapper<JiaofeijiluEntity> wrapper);
   	
   	JiaofeijiluVO selectVO(@Param("ew") Wrapper<JiaofeijiluEntity> wrapper);
   	
   	List<JiaofeijiluView> selectListView(Wrapper<JiaofeijiluEntity> wrapper);
   	
   	JiaofeijiluView selectView(@Param("ew") Wrapper<JiaofeijiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaofeijiluEntity> wrapper);
   	

}

