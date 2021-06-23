package com.wubaba.gulimallware.controller;

import java.util.Arrays;
import java.util.Map;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wubaba.util.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wubaba.gulimallware.entity.WmsWareInfoEntity;
import com.wubaba.gulimallware.service.WmsWareInfoService;




/**
 * 仓库信息
 *
 * @author wujuxuan
 * @email 
 * @date 2021-06-23 15:59:32
 */
@RestController
@RequestMapping("gulimallware/wmswareinfo")
public class WmsWareInfoController {
    @Autowired
    private WmsWareInfoService wmsWareInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(Page pageForm, WmsWareInfoEntity wmsWareInfo){
        Page page = wmsWareInfoService.page(pageForm, Wrappers.query(wmsWareInfo));
        return R.success("查询成功",page);
    }


    /**
     * 查询一条
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		WmsWareInfoEntity wmsWareInfo = wmsWareInfoService.getById(id);

       // return R.ok().put("wmsWareInfo", wmsWareInfo);
        return R.success("查询成功",wmsWareInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WmsWareInfoEntity wmsWareInfo){
		wmsWareInfoService.save(wmsWareInfo);

        return R.success("保存成功");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody WmsWareInfoEntity wmsWareInfo){
		wmsWareInfoService.updateById(wmsWareInfo);

        return R.success("修改成功");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		wmsWareInfoService.removeByIds(Arrays.asList(ids));
        return R.success("删除成功");
    }


}
