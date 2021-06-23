package com.wubaba.gulimallcoupon.controller;

import java.util.Arrays;
import java.util.Map;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wubaba.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wubaba.gulimallcoupon.entity.SmsCouponSpuRelationEntity;
import com.wubaba.gulimallcoupon.service.SmsCouponSpuRelationService;




/**
 * 优惠券与产品关联
 *
 * @author wujuxuan
 * @email 
 * @date 2021-06-23 15:18:04
 */
@RestController
@RequestMapping("gulimallcoupon/smscouponspurelation")
public class SmsCouponSpuRelationController {
    @Autowired
    private SmsCouponSpuRelationService smsCouponSpuRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(Page pageForm, SmsCouponSpuRelationEntity smsCouponSpuRelation){
        Page page = smsCouponSpuRelationService.page(pageForm, Wrappers.query(smsCouponSpuRelation));
        return R.success("查询成功",page);
    }


    /**
     * 查询一条
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		SmsCouponSpuRelationEntity smsCouponSpuRelation = smsCouponSpuRelationService.getById(id);

       // return R.ok().put("smsCouponSpuRelation", smsCouponSpuRelation);
        return R.success("查询成功",smsCouponSpuRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SmsCouponSpuRelationEntity smsCouponSpuRelation){
		smsCouponSpuRelationService.save(smsCouponSpuRelation);

        return R.success("保存成功");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SmsCouponSpuRelationEntity smsCouponSpuRelation){
		smsCouponSpuRelationService.updateById(smsCouponSpuRelation);

        return R.success("修改成功");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		smsCouponSpuRelationService.removeByIds(Arrays.asList(ids));
        return R.success("删除成功");
    }


}
