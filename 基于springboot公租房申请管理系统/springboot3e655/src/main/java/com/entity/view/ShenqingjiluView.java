package com.entity.view;

import com.entity.ShenqingjiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 申请记录
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-14 16:40:14
 */
@TableName("shenqingjilu")
public class ShenqingjiluView  extends ShenqingjiluEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShenqingjiluView(){
	}
 
 	public ShenqingjiluView(ShenqingjiluEntity shenqingjiluEntity){
 	try {
			BeanUtils.copyProperties(this, shenqingjiluEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
