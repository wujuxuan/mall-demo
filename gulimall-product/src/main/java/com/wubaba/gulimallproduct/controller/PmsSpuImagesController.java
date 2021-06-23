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
import com.wubaba.gulimallproduct.entity.PmsSpuImagesEntity;
import com.wubaba.gulimallproduct.service.PmsSpuImagesService;




/**
 * spu图片
 *
 * @author wujuxuan
 * @email 
 * @date 2021-06-23 15:05:14
 */
@RestController
@RequestMapping("gulimallproduct/pmsspuimages")
public class PmsSpuImagesController {
    @Autowired
    private PmsSpuImagesService pmsSpuImagesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(Page pageForm, PmsSpuImagesEntity pmsSpuImages){
        Page page = pmsSpuImagesService.page(pageForm, Wrappers.query(pmsSpuImages));
        return R.success("查询成功",page);
    }


    /**
     * 查询一条
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		PmsSpuImagesEntity pmsSpuImages = pmsSpuImagesService.getById(id);

       // return R.ok().put("pmsSpuImages", pmsSpuImages);
        return R.success("查询成功",pmsSpuImages);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PmsSpuImagesEntity pmsSpuImages){
		pmsSpuImagesService.save(pmsSpuImages);

        return R.success("保存成功");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PmsSpuImagesEntity pmsSpuImages){
		pmsSpuImagesService.updateById(pmsSpuImages);

        return R.success("修改成功");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		pmsSpuImagesService.removeByIds(Arrays.asList(ids));
        return R.success("删除成功");
    }


}
