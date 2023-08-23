package com.entity.model;

import com.entity.FangwuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 房屋信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-04-14 16:40:14
 */
public class FangwuxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 小区类型
	 */
	
	private String xiaoquleixing;
		
	/**
	 * 小区位置
	 */
	
	private String xiaoquweizhi;
		
	/**
	 * 房屋名称
	 */
	
	private String fangwumingcheng;
		
	/**
	 * 房屋图片
	 */
	
	private String fangwutupian;
		
	/**
	 * 房屋楼号
	 */
	
	private String fangwulouhao;
		
	/**
	 * 房屋房号
	 */
	
	private String fangwufanghao;
		
	/**
	 * 建筑面积
	 */
	
	private String jianzhumianji;
		
	/**
	 * 房屋租金
	 */
	
	private Integer fangwuzujin;
		
	/**
	 * 房屋状态
	 */
	
	private String fangwuzhuangtai;
		
	/**
	 * 表格文件
	 */
	
	private String biaogewenjian;
		
	/**
	 * 登记信息
	 */
	
	private String dengjixinxi;
		
	/**
	 * 发布日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date faburiqi;
				
	
	/**
	 * 设置：小区类型
	 */
	 
	public void setXiaoquleixing(String xiaoquleixing) {
		this.xiaoquleixing = xiaoquleixing;
	}
	
	/**
	 * 获取：小区类型
	 */
	public String getXiaoquleixing() {
		return xiaoquleixing;
	}
				
	
	/**
	 * 设置：小区位置
	 */
	 
	public void setXiaoquweizhi(String xiaoquweizhi) {
		this.xiaoquweizhi = xiaoquweizhi;
	}
	
	/**
	 * 获取：小区位置
	 */
	public String getXiaoquweizhi() {
		return xiaoquweizhi;
	}
				
	
	/**
	 * 设置：房屋名称
	 */
	 
	public void setFangwumingcheng(String fangwumingcheng) {
		this.fangwumingcheng = fangwumingcheng;
	}
	
	/**
	 * 获取：房屋名称
	 */
	public String getFangwumingcheng() {
		return fangwumingcheng;
	}
				
	
	/**
	 * 设置：房屋图片
	 */
	 
	public void setFangwutupian(String fangwutupian) {
		this.fangwutupian = fangwutupian;
	}
	
	/**
	 * 获取：房屋图片
	 */
	public String getFangwutupian() {
		return fangwutupian;
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
	 * 设置：建筑面积
	 */
	 
	public void setJianzhumianji(String jianzhumianji) {
		this.jianzhumianji = jianzhumianji;
	}
	
	/**
	 * 获取：建筑面积
	 */
	public String getJianzhumianji() {
		return jianzhumianji;
	}
				
	
	/**
	 * 设置：房屋租金
	 */
	 
	public void setFangwuzujin(Integer fangwuzujin) {
		this.fangwuzujin = fangwuzujin;
	}
	
	/**
	 * 获取：房屋租金
	 */
	public Integer getFangwuzujin() {
		return fangwuzujin;
	}
				
	
	/**
	 * 设置：房屋状态
	 */
	 
	public void setFangwuzhuangtai(String fangwuzhuangtai) {
		this.fangwuzhuangtai = fangwuzhuangtai;
	}
	
	/**
	 * 获取：房屋状态
	 */
	public String getFangwuzhuangtai() {
		return fangwuzhuangtai;
	}
				
	
	/**
	 * 设置：表格文件
	 */
	 
	public void setBiaogewenjian(String biaogewenjian) {
		this.biaogewenjian = biaogewenjian;
	}
	
	/**
	 * 获取：表格文件
	 */
	public String getBiaogewenjian() {
		return biaogewenjian;
	}
				
	
	/**
	 * 设置：登记信息
	 */
	 
	public void setDengjixinxi(String dengjixinxi) {
		this.dengjixinxi = dengjixinxi;
	}
	
	/**
	 * 获取：登记信息
	 */
	public String getDengjixinxi() {
		return dengjixinxi;
	}
				
	
	/**
	 * 设置：发布日期
	 */
	 
	public void setFaburiqi(Date faburiqi) {
		this.faburiqi = faburiqi;
	}
	
	/**
	 * 获取：发布日期
	 */
	public Date getFaburiqi() {
		return faburiqi;
	}
			
}
