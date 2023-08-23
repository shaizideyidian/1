package com.entity.model;

import com.entity.JiaofeijiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 缴费记录
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-04-14 16:40:14
 */
public class JiaofeijiluModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 缴费月份
	 */
	
	private String jiaofeiyuefen;
		
	/**
	 * 缴费名称
	 */
	
	private String jiaofeimingcheng;
		
	/**
	 * 缴费类型
	 */
	
	private String jiaofeileixing;
		
	/**
	 * 缴费金额
	 */
	
	private Integer jiaofeijine;
		
	/**
	 * 缴费内容
	 */
	
	private String jiaofeineirong;
		
	/**
	 * 添加日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date tianjiariqi;
		
	/**
	 * 小区名称
	 */
	
	private String xiaoqumingcheng;
		
	/**
	 * 房屋楼号
	 */
	
	private String fangwulouhao;
		
	/**
	 * 房屋房号
	 */
	
	private String fangwufanghao;
		
	/**
	 * 用户名
	 */
	
	private String yonghuming;
		
	/**
	 * 是否支付
	 */
	
	private String ispay;
				
	
	/**
	 * 设置：缴费月份
	 */
	 
	public void setJiaofeiyuefen(String jiaofeiyuefen) {
		this.jiaofeiyuefen = jiaofeiyuefen;
	}
	
	/**
	 * 获取：缴费月份
	 */
	public String getJiaofeiyuefen() {
		return jiaofeiyuefen;
	}
				
	
	/**
	 * 设置：缴费名称
	 */
	 
	public void setJiaofeimingcheng(String jiaofeimingcheng) {
		this.jiaofeimingcheng = jiaofeimingcheng;
	}
	
	/**
	 * 获取：缴费名称
	 */
	public String getJiaofeimingcheng() {
		return jiaofeimingcheng;
	}
				
	
	/**
	 * 设置：缴费类型
	 */
	 
	public void setJiaofeileixing(String jiaofeileixing) {
		this.jiaofeileixing = jiaofeileixing;
	}
	
	/**
	 * 获取：缴费类型
	 */
	public String getJiaofeileixing() {
		return jiaofeileixing;
	}
				
	
	/**
	 * 设置：缴费金额
	 */
	 
	public void setJiaofeijine(Integer jiaofeijine) {
		this.jiaofeijine = jiaofeijine;
	}
	
	/**
	 * 获取：缴费金额
	 */
	public Integer getJiaofeijine() {
		return jiaofeijine;
	}
				
	
	/**
	 * 设置：缴费内容
	 */
	 
	public void setJiaofeineirong(String jiaofeineirong) {
		this.jiaofeineirong = jiaofeineirong;
	}
	
	/**
	 * 获取：缴费内容
	 */
	public String getJiaofeineirong() {
		return jiaofeineirong;
	}
				
	
	/**
	 * 设置：添加日期
	 */
	 
	public void setTianjiariqi(Date tianjiariqi) {
		this.tianjiariqi = tianjiariqi;
	}
	
	/**
	 * 获取：添加日期
	 */
	public Date getTianjiariqi() {
		return tianjiariqi;
	}
				
	
	/**
	 * 设置：小区名称
	 */
	 
	public void setXiaoqumingcheng(String xiaoqumingcheng) {
		this.xiaoqumingcheng = xiaoqumingcheng;
	}
	
	/**
	 * 获取：小区名称
	 */
	public String getXiaoqumingcheng() {
		return xiaoqumingcheng;
	}
				
	
	/**
	 * 设置：房屋楼号
	 */
	 
	public void setFangwulouhao(String fangwulouhao) {
		this.fangwulouhao = fangwulouhao;
	}
	
	/**
	 * 获取：房屋楼号
	 */
	public String getFangwulouhao() {
		return fangwulouhao;
	}
				
	
	/**
	 * 设置：房屋房号
	 */
	 
	public void setFangwufanghao(String fangwufanghao) {
		this.fangwufanghao = fangwufanghao;
	}
	
	/**
	 * 获取：房屋房号
	 */
	public String getFangwufanghao() {
		return fangwufanghao;
	}
				
	
	/**
	 * 设置：用户名
	 */
	 
	public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
	}
	
	/**
	 * 获取：用户名
	 */
	public String getYonghuming() {
		return yonghuming;
	}
				
	
	/**
	 * 设置：是否支付
	 */
	 
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}
			
}
