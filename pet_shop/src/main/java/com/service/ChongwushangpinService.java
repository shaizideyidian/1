package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChongwushangpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChongwushangpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChongwushangpinView;


/**
 * 宠物商品
 *
 * @author 
 * @email 
 * @date 2023-03-25 09:47:18
 */
public interface ChongwushangpinService extends IService<ChongwushangpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChongwushangpinVO> selectListVO(Wrapper<ChongwushangpinEntity> wrapper);
   	
   	ChongwushangpinVO selectVO(@Param("ew") Wrapper<ChongwushangpinEntity> wrapper);
   	
   	List<ChongwushangpinView> selectListView(Wrapper<ChongwushangpinEntity> wrapper);
   	
   	ChongwushangpinView selectView(@Param("ew") Wrapper<ChongwushangpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChongwushangpinEntity> wrapper);
   	

}

