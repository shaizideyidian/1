package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LianxijiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LianxijiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LianxijiluView;


/**
 * 联系记录
 *
 * @author 
 * @email 
 * @date 2023-03-25 09:47:18
 */
public interface LianxijiluService extends IService<LianxijiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LianxijiluVO> selectListVO(Wrapper<LianxijiluEntity> wrapper);
   	
   	LianxijiluVO selectVO(@Param("ew") Wrapper<LianxijiluEntity> wrapper);
   	
   	List<LianxijiluView> selectListView(Wrapper<LianxijiluEntity> wrapper);
   	
   	LianxijiluView selectView(@Param("ew") Wrapper<LianxijiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LianxijiluEntity> wrapper);
   	

}

