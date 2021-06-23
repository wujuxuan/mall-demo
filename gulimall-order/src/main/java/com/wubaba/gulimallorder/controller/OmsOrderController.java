package com.wubaba.gulimallorder.controller;

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
import com.wubaba.gulimallorder.entity.OmsOrderEntity;
import com.wubaba.gulimallorder.service.OmsOrderService;
/**
 * 订单
 *
 * @author wujuxuan
 * @email 
 * @date 2021-06-23 15:41:54
 */
@RestController
@RequestMapping("gulimallorder/omsorder")
public class OmsOrderController {
    @Autowired
    private OmsOrderService omsOrderService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(Page pageForm, OmsOrderEntity omsOrder){
        Page page = omsOrderService.page(pageForm, Wrappers.query(omsOrder));
        return R.success("查询成功",page);
    }


    /**
     * 查询一条
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		OmsOrderEntity omsOrder = omsOrderService.getById(id);

       // return R.ok().put("omsOrder", omsOrder);
        return R.success("查询成功",omsOrder);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody OmsOrderEntity omsOrder){
		omsOrderService.save(omsOrder);

        return R.success("保存成功");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody OmsOrderEntity omsOrder){
		omsOrderService.updateById(omsOrder);

        return R.success("修改成功");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		omsOrderService.removeByIds(Arrays.asList(ids));
        return R.success("删除成功");
    }


}
