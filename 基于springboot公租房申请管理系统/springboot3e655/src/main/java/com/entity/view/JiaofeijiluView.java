package com.entity.view;

import com.entity.JiaofeijiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 缴费记录
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-14 16:40:14
 */
@TableName("jiaofeijilu")
public class JiaofeijiluView  extends JiaofeijiluEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiaofeijiluView(){
	}
 
 	public JiaofeijiluView(JiaofeijiluEntity jiaofeijiluEntity){
 	try {
			BeanUtils.copyProperties(this, jiaofeijiluEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
