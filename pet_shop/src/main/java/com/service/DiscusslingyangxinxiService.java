package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusslingyangxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusslingyangxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusslingyangxinxiView;


/**
 * 领养信息评论表
 *
 * @author 
 * @email 
 * @date 2023-03-25 09:47:18
 */
public interface DiscusslingyangxinxiService extends IService<DiscusslingyangxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusslingyangxinxiVO> selectListVO(Wrapper<DiscusslingyangxinxiEntity> wrapper);
   	
   	DiscusslingyangxinxiVO selectVO(@Param("ew") Wrapper<DiscusslingyangxinxiEntity> wrapper);
   	
   	List<DiscusslingyangxinxiView> selectListView(Wrapper<DiscusslingyangxinxiEntity> wrapper);
   	
   	DiscusslingyangxinxiView selectView(@Param("ew") Wrapper<DiscusslingyangxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusslingyangxinxiEntity> wrapper);
   	

}

