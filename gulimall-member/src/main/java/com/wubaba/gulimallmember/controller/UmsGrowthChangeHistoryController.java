package com.wubaba.gulimallmember.controller;

import java.util.Arrays;
import java.util.Map;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wubaba.gulimallmember.entity.UmsMemberEntity;
import com.wubaba.gulimallmember.feign.CouponFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wubaba.util.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wubaba.gulimallmember.entity.UmsGrowthChangeHistoryEntity;
import com.wubaba.gulimallmember.service.UmsGrowthChangeHistoryService;




/**
 * 成长值变化历史记录
 *
 * @author wujuxuan
 * @email 
 * @date 2021-06-23 15:35:26
 */
@RestController
@RequestMapping("gulimallmember/umsgrowthchangehistory")
public class UmsGrowthChangeHistoryController {
    @Autowired
    private UmsGrowthChangeHistoryService umsGrowthChangeHistoryService;

    @Autowired
    CouponFeignService couponFeignService;

    @RequestMapping("/coupons")
    public R test(){
        UmsMemberEntity memberEntity = new UmsMemberEntity();
        memberEntity.setNickname("会员昵称张三");
        R membercoupons = couponFeignService.membercoupons();//假设张三去数据库查了后返回了张三的优惠券信息

        //打印会员和优惠券信息
//        return R.ok().put("member",memberEntity).put("coupons",membercoupons.get("coupons"));
        return R.success("查询成功",membercoupons);
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(Page pageForm, UmsGrowthChangeHistoryEntity umsGrowthChangeHistory){
        Page page = umsGrowthChangeHistoryService.page(pageForm, Wrappers.query(umsGrowthChangeHistory));
        return R.success("查询成功",page);
    }


    /**
     * 查询一条
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		UmsGrowthChangeHistoryEntity umsGrowthChangeHistory = umsGrowthChangeHistoryService.getById(id);

       // return R.ok().put("umsGrowthChangeHistory", umsGrowthChangeHistory);
        return R.success("查询成功",umsGrowthChangeHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody UmsGrowthChangeHistoryEntity umsGrowthChangeHistory){
		umsGrowthChangeHistoryService.save(umsGrowthChangeHistory);

        return R.success("保存成功");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody UmsGrowthChangeHistoryEntity umsGrowthChangeHistory){
		umsGrowthChangeHistoryService.updateById(umsGrowthChangeHistory);

        return R.success("修改成功");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		umsGrowthChangeHistoryService.removeByIds(Arrays.asList(ids));
        return R.success("删除成功");
    }


}
