package com.entity.view;

import com.entity.DiscusschongwushangpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 宠物商品评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-25 09:47:18
 */
@TableName("discusschongwushangpin")
public class DiscusschongwushangpinView  extends DiscusschongwushangpinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusschongwushangpinView(){
	}
 
 	public DiscusschongwushangpinView(DiscusschongwushangpinEntity discusschongwushangpinEntity){
 	try {
			BeanUtils.copyProperties(this, discusschongwushangpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
