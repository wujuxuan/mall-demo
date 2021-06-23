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
import com.wubaba.gulimallcoupon.entity.SmsMemberPriceEntity;
import com.wubaba.gulimallcoupon.service.SmsMemberPriceService;




/**
 * 商品会员价格
 *
 * @author wujuxuan
 * @email 
 * @date 2021-06-23 15:18:04
 */
@RestController
@RequestMapping("gulimallcoupon/smsmemberprice")
public class SmsMemberPriceController {
    @Autowired
    private SmsMemberPriceService smsMemberPriceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(Page pageForm, SmsMemberPriceEntity smsMemberPrice){
        Page page = smsMemberPriceService.page(pageForm, Wrappers.query(smsMemberPrice));
        return R.success("查询成功",page);
    }


    /**
     * 查询一条
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		SmsMemberPriceEntity smsMemberPrice = smsMemberPriceService.getById(id);

       // return R.ok().put("smsMemberPrice", smsMemberPrice);
        return R.success("查询成功",smsMemberPrice);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SmsMemberPriceEntity smsMemberPrice){
		smsMemberPriceService.save(smsMemberPrice);

        return R.success("保存成功");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SmsMemberPriceEntity smsMemberPrice){
		smsMemberPriceService.updateById(smsMemberPrice);

        return R.success("修改成功");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		smsMemberPriceService.removeByIds(Arrays.asList(ids));
        return R.success("删除成功");
    }


}
