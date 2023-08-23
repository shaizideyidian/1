package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LingyangjiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LingyangjiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LingyangjiluView;


/**
 * 领养记录
 *
 * @author 
 * @email 
 * @date 2023-03-25 09:47:18
 */
public interface LingyangjiluService extends IService<LingyangjiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LingyangjiluVO> selectListVO(Wrapper<LingyangjiluEntity> wrapper);
   	
   	LingyangjiluVO selectVO(@Param("ew") Wrapper<LingyangjiluEntity> wrapper);
   	
   	List<LingyangjiluView> selectListView(Wrapper<LingyangjiluEntity> wrapper);
   	
   	LingyangjiluView selectView(@Param("ew") Wrapper<LingyangjiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LingyangjiluEntity> wrapper);
   	

}

