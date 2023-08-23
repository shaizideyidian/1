package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusschongwushangpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusschongwushangpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusschongwushangpinView;


/**
 * 宠物商品评论表
 *
 * @author 
 * @email 
 * @date 2023-03-25 09:47:18
 */
public interface DiscusschongwushangpinService extends IService<DiscusschongwushangpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusschongwushangpinVO> selectListVO(Wrapper<DiscusschongwushangpinEntity> wrapper);
   	
   	DiscusschongwushangpinVO selectVO(@Param("ew") Wrapper<DiscusschongwushangpinEntity> wrapper);
   	
   	List<DiscusschongwushangpinView> selectListView(Wrapper<DiscusschongwushangpinEntity> wrapper);
   	
   	DiscusschongwushangpinView selectView(@Param("ew") Wrapper<DiscusschongwushangpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusschongwushangpinEntity> wrapper);
   	

}

