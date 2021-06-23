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
import com.wubaba.gulimallcoupon.entity.SmsSeckillSkuRelationEntity;
import com.wubaba.gulimallcoupon.service.SmsSeckillSkuRelationService;




/**
 * 秒杀活动商品关联
 *
 * @author wujuxuan
 * @email 
 * @date 2021-06-23 15:18:04
 */
@RestController
@RequestMapping("gulimallcoupon/smsseckillskurelation")
public class SmsSeckillSkuRelationController {
    @Autowired
    private SmsSeckillSkuRelationService smsSeckillSkuRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(Page pageForm, SmsSeckillSkuRelationEntity smsSeckillSkuRelation){
        Page page = smsSeckillSkuRelationService.page(pageForm, Wrappers.query(smsSeckillSkuRelation));
        return R.success("查询成功",page);
    }


    /**
     * 查询一条
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		SmsSeckillSkuRelationEntity smsSeckillSkuRelation = smsSeckillSkuRelationService.getById(id);

       // return R.ok().put("smsSeckillSkuRelation", smsSeckillSkuRelation);
        return R.success("查询成功",smsSeckillSkuRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SmsSeckillSkuRelationEntity smsSeckillSkuRelation){
		smsSeckillSkuRelationService.save(smsSeckillSkuRelation);

        return R.success("保存成功");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SmsSeckillSkuRelationEntity smsSeckillSkuRelation){
		smsSeckillSkuRelationService.updateById(smsSeckillSkuRelation);

        return R.success("修改成功");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		smsSeckillSkuRelationService.removeByIds(Arrays.asList(ids));
        return R.success("删除成功");
    }


}
