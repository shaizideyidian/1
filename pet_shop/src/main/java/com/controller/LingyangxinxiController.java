package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.LingyangxinxiEntity;
import com.entity.view.LingyangxinxiView;

import com.service.LingyangxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 领养信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-03-25 09:47:18
 */
@RestController
@RequestMapping("/lingyangxinxi")
public class LingyangxinxiController {
    @Autowired
    private LingyangxinxiService lingyangxinxiService;


    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LingyangxinxiEntity lingyangxinxi, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			lingyangxinxi.setShangjiamingcheng((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LingyangxinxiEntity> ew = new EntityWrapper<LingyangxinxiEntity>();

    	PageUtils page = lingyangxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lingyangxinxi), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LingyangxinxiEntity lingyangxinxi, 
		HttpServletRequest request){
        EntityWrapper<LingyangxinxiEntity> ew = new EntityWrapper<LingyangxinxiEntity>();

    	PageUtils page = lingyangxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lingyangxinxi), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LingyangxinxiEntity lingyangxinxi){
       	EntityWrapper<LingyangxinxiEntity> ew = new EntityWrapper<LingyangxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( lingyangxinxi, "lingyangxinxi")); 
        return R.ok().put("data", lingyangxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LingyangxinxiEntity lingyangxinxi){
        EntityWrapper< LingyangxinxiEntity> ew = new EntityWrapper< LingyangxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( lingyangxinxi, "lingyangxinxi")); 
		LingyangxinxiView lingyangxinxiView =  lingyangxinxiService.selectView(ew);
		return R.ok("查询领养信息成功").put("data", lingyangxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LingyangxinxiEntity lingyangxinxi = lingyangxinxiService.selectById(id);
        return R.ok().put("data", lingyangxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LingyangxinxiEntity lingyangxinxi = lingyangxinxiService.selectById(id);
        return R.ok().put("data", lingyangxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LingyangxinxiEntity lingyangxinxi, HttpServletRequest request){
    	lingyangxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lingyangxinxi);

        lingyangxinxiService.insert(lingyangxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LingyangxinxiEntity lingyangxinxi, HttpServletRequest request){
    	lingyangxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lingyangxinxi);

        lingyangxinxiService.insert(lingyangxinxi);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LingyangxinxiEntity lingyangxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(lingyangxinxi);
        lingyangxinxiService.updateById(lingyangxinxi);//全部更新
        return R.ok();
    }

    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        lingyangxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<LingyangxinxiEntity> wrapper = new EntityWrapper<LingyangxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			wrapper.eq("shangjiamingcheng", (String)request.getSession().getAttribute("username"));
		}

		int count = lingyangxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	








}
