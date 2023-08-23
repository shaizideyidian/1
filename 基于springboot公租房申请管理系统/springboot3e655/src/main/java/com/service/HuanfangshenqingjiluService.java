package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuanfangshenqingjiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HuanfangshenqingjiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HuanfangshenqingjiluView;


/**
 * 换房申请记录
 *
 * @author 
 * @email 
 * @date 2023-04-14 16:40:14
 */
public interface HuanfangshenqingjiluService extends IService<HuanfangshenqingjiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuanfangshenqingjiluVO> selectListVO(Wrapper<HuanfangshenqingjiluEntity> wrapper);
   	
   	HuanfangshenqingjiluVO selectVO(@Param("ew") Wrapper<HuanfangshenqingjiluEntity> wrapper);
   	
   	List<HuanfangshenqingjiluView> selectListView(Wrapper<HuanfangshenqingjiluEntity> wrapper);
   	
   	HuanfangshenqingjiluView selectView(@Param("ew") Wrapper<HuanfangshenqingjiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuanfangshenqingjiluEntity> wrapper);
   	

}

