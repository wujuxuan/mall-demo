package com.wubaba.gulimallproduct.controller;

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
import com.wubaba.gulimallproduct.entity.PmsAttrEntity;
import com.wubaba.gulimallproduct.service.PmsAttrService;




/**
 * 商品属性
 *
 * @author wujuxuan
 * @email 
 * @date 2021-06-23 15:05:14
 */
@RestController
@RequestMapping("gulimallproduct/pmsattr")
public class PmsAttrController {
    @Autowired
    private PmsAttrService pmsAttrService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(Page pageForm, PmsAttrEntity pmsAttr){
        Page page = pmsAttrService.page(pageForm, Wrappers.query(pmsAttr));
        return R.success("查询成功",page);
    }


    /**
     * 查询一条
     */
    @RequestMapping("/info/{attrId}")
    public R info(@PathVariable("attrId") Long attrId){
		PmsAttrEntity pmsAttr = pmsAttrService.getById(attrId);

        return R.success("查询成功",pmsAttr);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PmsAttrEntity pmsAttr){
		pmsAttrService.save(pmsAttr);

        return R.success("保存成功");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PmsAttrEntity pmsAttr){
		pmsAttrService.updateById(pmsAttr);

        return R.success("修改成功");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] attrIds){
		pmsAttrService.removeByIds(Arrays.asList(attrIds));
        return R.success("删除成功");
    }


}
