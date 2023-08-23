package com.entity.view;

import com.entity.ShenheyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 审核员
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-14 16:40:14
 */
@TableName("shenheyuan")
public class ShenheyuanView  extends ShenheyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShenheyuanView(){
	}
 
 	public ShenheyuanView(ShenheyuanEntity shenheyuanEntity){
 	try {
			BeanUtils.copyProperties(this, shenheyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
