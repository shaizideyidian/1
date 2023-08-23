package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShenheyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShenheyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShenheyuanView;


/**
 * 审核员
 *
 * @author 
 * @email 
 * @date 2023-04-14 16:40:14
 */
public interface ShenheyuanService extends IService<ShenheyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShenheyuanVO> selectListVO(Wrapper<ShenheyuanEntity> wrapper);
   	
   	ShenheyuanVO selectVO(@Param("ew") Wrapper<ShenheyuanEntity> wrapper);
   	
   	List<ShenheyuanView> selectListView(Wrapper<ShenheyuanEntity> wrapper);
   	
   	ShenheyuanView selectView(@Param("ew") Wrapper<ShenheyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShenheyuanEntity> wrapper);
   	

}

