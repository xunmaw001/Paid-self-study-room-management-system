package com.controller;

import java.text.SimpleDateFormat;
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

import com.entity.DiscusszixishiEntity;
import com.entity.view.DiscusszixishiView;

import com.service.DiscusszixishiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 自习室评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2022-11-09 17:25:52
 */
@RestController
@RequestMapping("/discusszixishi")
public class DiscusszixishiController {
    @Autowired
    private DiscusszixishiService discusszixishiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusszixishiEntity discusszixishi, 
		HttpServletRequest request){

        EntityWrapper<DiscusszixishiEntity> ew = new EntityWrapper<DiscusszixishiEntity>();


		PageUtils page = discusszixishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszixishi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusszixishiEntity discusszixishi, 
		HttpServletRequest request){
        EntityWrapper<DiscusszixishiEntity> ew = new EntityWrapper<DiscusszixishiEntity>();

		PageUtils page = discusszixishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszixishi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusszixishiEntity discusszixishi){
       	EntityWrapper<DiscusszixishiEntity> ew = new EntityWrapper<DiscusszixishiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusszixishi, "discusszixishi")); 
        return R.ok().put("data", discusszixishiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusszixishiEntity discusszixishi){
        EntityWrapper< DiscusszixishiEntity> ew = new EntityWrapper< DiscusszixishiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusszixishi, "discusszixishi")); 
		DiscusszixishiView discusszixishiView =  discusszixishiService.selectView(ew);
		return R.ok("查询自习室评论表成功").put("data", discusszixishiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusszixishiEntity discusszixishi = discusszixishiService.selectById(id);
        return R.ok().put("data", discusszixishi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusszixishiEntity discusszixishi = discusszixishiService.selectById(id);
        return R.ok().put("data", discusszixishi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusszixishiEntity discusszixishi, HttpServletRequest request){
    	discusszixishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusszixishi);

        discusszixishiService.insert(discusszixishi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusszixishiEntity discusszixishi, HttpServletRequest request){
    	discusszixishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusszixishi);

        discusszixishiService.insert(discusszixishi);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscusszixishiEntity discusszixishi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusszixishi);
        discusszixishiService.updateById(discusszixishi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusszixishiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<DiscusszixishiEntity> wrapper = new EntityWrapper<DiscusszixishiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discusszixishiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	








}
