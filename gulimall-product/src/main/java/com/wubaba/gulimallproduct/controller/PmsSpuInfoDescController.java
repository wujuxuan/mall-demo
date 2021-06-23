package com.wubaba.gulimallproduct.controller;

import java.util.Arrays;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wubaba.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wubaba.gulimallproduct.entity.PmsSpuInfoDescEntity;
import com.wubaba.gulimallproduct.service.PmsSpuInfoDescService;




/**
 * spu信息介绍
 *
 * @author wujuxuan
 * @email 
 * @date 2021-06-23 15:05:14
 */
@RestController
@RequestMapping("gulimallproduct/pmsspuinfodesc")
public class PmsSpuInfoDescController {
    @Autowired
    private PmsSpuInfoDescService pmsSpuInfoDescService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(Page pageForm, PmsSpuInfoDescEntity pmsSpuInfoDesc){
        Page page = pmsSpuInfoDescService.page(pageForm, Wrappers.query(pmsSpuInfoDesc));
        return R.success("查询成功",page);
    }


    /**
     * 查询一条
     */
    @RequestMapping("/info/{spuId}")
    public R info(@PathVariable("spuId") Long spuId){
		PmsSpuInfoDescEntity pmsSpuInfoDesc = pmsSpuInfoDescService.getById(spuId);

       // return R.ok().put("pmsSpuInfoDesc", pmsSpuInfoDesc);
        return R.success("查询成功",pmsSpuInfoDesc);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PmsSpuInfoDescEntity pmsSpuInfoDesc){
		pmsSpuInfoDescService.save(pmsSpuInfoDesc);

        return R.success("保存成功");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PmsSpuInfoDescEntity pmsSpuInfoDesc){
		pmsSpuInfoDescService.updateById(pmsSpuInfoDesc);

        return R.success("修改成功");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] spuIds){
		pmsSpuInfoDescService.removeByIds(Arrays.asList(spuIds));
        return R.success("删除成功");
    }


}
