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
 * 换房申请记录
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-04-14 16:40:14
 */
@TableName("huanfangshenqingjilu")
public class HuanfangshenqingjiluEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public HuanfangshenqingjiluEntity() {
		
	}
	
	public HuanfangshenqingjiluEntity(T t) {
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
	 * 申请单号
	 */
					
	private String shenqingdanhao;
	
	/**
	 * 小区名称
	 */
					
	private String xiaoqumingcheng;
	
	/**
	 * 房屋名称
	 */
					
	private String fangwumingcheng;
	
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
	 * 换房需求
	 */
					
	private String huanfangxuqiu;
	
	/**
	 * 换房原因
	 */
					
	private String huanfangyuanyin;
	
	/**
	 * 申请时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date shenqingshijian;
	
	/**
	 * 用户名
	 */
					
	private String yonghuming;
	
	/**
	 * 手机
	 */
					
	private String shouji;
	
	/**
	 * 身份证
	 */
					
	private String shenfenzheng;
	
	/**
	 * 跨表用户id
	 */
					
	private Long crossuserid;
	
	/**
	 * 跨表主键id
	 */
					
	private Long crossrefid;
	
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
	 * 设置：申请单号
	 */
	public void setShenqingdanhao(String shenqingdanhao) {
		this.shenqingdanhao = shenqingdanhao;
	}
	/**
	 * 获取：申请单号
	 */
	public String getShenqingdanhao() {
		return shenqingdanhao;
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
	 * 设置：换房需求
	 */
	public void setHuanfangxuqiu(String huanfangxuqiu) {
		this.huanfangxuqiu = huanfangxuqiu;
	}
	/**
	 * 获取：换房需求
	 */
	public String getHuanfangxuqiu() {
		return huanfangxuqiu;
	}
	/**
	 * 设置：换房原因
	 */
	public void setHuanfangyuanyin(String huanfangyuanyin) {
		this.huanfangyuanyin = huanfangyuanyin;
	}
	/**
	 * 获取：换房原因
	 */
	public String getHuanfangyuanyin() {
		return huanfangyuanyin;
	}
	/**
	 * 设置：申请时间
	 */
	public void setShenqingshijian(Date shenqingshijian) {
		this.shenqingshijian = shenqingshijian;
	}
	/**
	 * 获取：申请时间
	 */
	public Date getShenqingshijian() {
		return shenqingshijian;
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
	 * 设置：手机
	 */
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
	/**
	 * 设置：身份证
	 */
	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
	}
	/**
	 * 获取：身份证
	 */
	public String getShenfenzheng() {
		return shenfenzheng;
	}
	/**
	 * 设置：跨表用户id
	 */
	public void setCrossuserid(Long crossuserid) {
		this.crossuserid = crossuserid;
	}
	/**
	 * 获取：跨表用户id
	 */
	public Long getCrossuserid() {
		return crossuserid;
	}
	/**
	 * 设置：跨表主键id
	 */
	public void setCrossrefid(Long crossrefid) {
		this.crossrefid = crossrefid;
	}
	/**
	 * 获取：跨表主键id
	 */
	public Long getCrossrefid() {
		return crossrefid;
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
