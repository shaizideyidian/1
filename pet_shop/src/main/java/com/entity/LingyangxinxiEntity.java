package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 领养信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-03-25 09:47:18
 */
@TableName("lingyangxinxi")
public class LingyangxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public LingyangxinxiEntity() {
		
	}
	
	public LingyangxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 宠物名称
	 */
					
	private String chongwumingcheng;
	
	/**
	 * 宠物分类
	 */
					
	private String chongwufenlei;
	
	/**
	 * 宠物图片
	 */
					
	private String chongwutupian;
	
	/**
	 * 宠物品种
	 */
					
	private String chongwupinzhong;
	
	/**
	 * 宠物性别
	 */
					
	private String chongwuxingbie;
	
	/**
	 * 宠物性格
	 */
					
	private String chongwuxingge;
	
	/**
	 * 宠物年龄
	 */
					
	private String chongwunianling;
	
	/**
	 * 领养要求
	 */
					
	private String lingyangyaoqiu;
	
	/**
	 * 宠物疫苗
	 */
					
	private String chongwuyimiao;
	
	/**
	 * 领养状态
	 */
					
	private String lingyangzhuangtai;
	
	/**
	 * 宠物详情
	 */
					
	private String chongwuxiangqing;
	
	/**
	 * 领养地址
	 */
					
	private String lingyangdizhi;
	
	/**
	 * 商家名称
	 */
					
	private String shangjiamingcheng;
	
	/**
	 * 咨询电话
	 */
					
	private String zixundianhua;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：宠物名称
	 */
	public void setChongwumingcheng(String chongwumingcheng) {
		this.chongwumingcheng = chongwumingcheng;
	}
	/**
	 * 获取：宠物名称
	 */
	public String getChongwumingcheng() {
		return chongwumingcheng;
	}
	/**
	 * 设置：宠物分类
	 */
	public void setChongwufenlei(String chongwufenlei) {
		this.chongwufenlei = chongwufenlei;
	}
	/**
	 * 获取：宠物分类
	 */
	public String getChongwufenlei() {
		return chongwufenlei;
	}
	/**
	 * 设置：宠物图片
	 */
	public void setChongwutupian(String chongwutupian) {
		this.chongwutupian = chongwutupian;
	}
	/**
	 * 获取：宠物图片
	 */
	public String getChongwutupian() {
		return chongwutupian;
	}
	/**
	 * 设置：宠物品种
	 */
	public void setChongwupinzhong(String chongwupinzhong) {
		this.chongwupinzhong = chongwupinzhong;
	}
	/**
	 * 获取：宠物品种
	 */
	public String getChongwupinzhong() {
		return chongwupinzhong;
	}
	/**
	 * 设置：宠物性别
	 */
	public void setChongwuxingbie(String chongwuxingbie) {
		this.chongwuxingbie = chongwuxingbie;
	}
	/**
	 * 获取：宠物性别
	 */
	public String getChongwuxingbie() {
		return chongwuxingbie;
	}
	/**
	 * 设置：宠物性格
	 */
	public void setChongwuxingge(String chongwuxingge) {
		this.chongwuxingge = chongwuxingge;
	}
	/**
	 * 获取：宠物性格
	 */
	public String getChongwuxingge() {
		return chongwuxingge;
	}
	/**
	 * 设置：宠物年龄
	 */
	public void setChongwunianling(String chongwunianling) {
		this.chongwunianling = chongwunianling;
	}
	/**
	 * 获取：宠物年龄
	 */
	public String getChongwunianling() {
		return chongwunianling;
	}
	/**
	 * 设置：领养要求
	 */
	public void setLingyangyaoqiu(String lingyangyaoqiu) {
		this.lingyangyaoqiu = lingyangyaoqiu;
	}
	/**
	 * 获取：领养要求
	 */
	public String getLingyangyaoqiu() {
		return lingyangyaoqiu;
	}
	/**
	 * 设置：宠物疫苗
	 */
	public void setChongwuyimiao(String chongwuyimiao) {
		this.chongwuyimiao = chongwuyimiao;
	}
	/**
	 * 获取：宠物疫苗
	 */
	public String getChongwuyimiao() {
		return chongwuyimiao;
	}
	/**
	 * 设置：领养状态
	 */
	public void setLingyangzhuangtai(String lingyangzhuangtai) {
		this.lingyangzhuangtai = lingyangzhuangtai;
	}
	/**
	 * 获取：领养状态
	 */
	public String getLingyangzhuangtai() {
		return lingyangzhuangtai;
	}
	/**
	 * 设置：宠物详情
	 */
	public void setChongwuxiangqing(String chongwuxiangqing) {
		this.chongwuxiangqing = chongwuxiangqing;
	}
	/**
	 * 获取：宠物详情
	 */
	public String getChongwuxiangqing() {
		return chongwuxiangqing;
	}
	/**
	 * 设置：领养地址
	 */
	public void setLingyangdizhi(String lingyangdizhi) {
		this.lingyangdizhi = lingyangdizhi;
	}
	/**
	 * 获取：领养地址
	 */
	public String getLingyangdizhi() {
		return lingyangdizhi;
	}
	/**
	 * 设置：商家名称
	 */
	public void setShangjiamingcheng(String shangjiamingcheng) {
		this.shangjiamingcheng = shangjiamingcheng;
	}
	/**
	 * 获取：商家名称
	 */
	public String getShangjiamingcheng() {
		return shangjiamingcheng;
	}
	/**
	 * 设置：咨询电话
	 */
	public void setZixundianhua(String zixundianhua) {
		this.zixundianhua = zixundianhua;
	}
	/**
	 * 获取：咨询电话
	 */
	public String getZixundianhua() {
		return zixundianhua;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}

}
