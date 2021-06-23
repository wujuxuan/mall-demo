package com.wubaba.gulimallmember.controller;

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
import com.wubaba.gulimallmember.entity.UmsMemberLoginLogEntity;
import com.wubaba.gulimallmember.service.UmsMemberLoginLogService;




/**
 * 会员登录记录
 *
 * @author wujuxuan
 * @email 
 * @date 2021-06-23 15:35:26
 */
@RestController
@RequestMapping("gulimallmember/umsmemberloginlog")
public class UmsMemberLoginLogController {
    @Autowired
    private UmsMemberLoginLogService umsMemberLoginLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(Page pageForm, UmsMemberLoginLogEntity umsMemberLoginLog){
        Page page = umsMemberLoginLogService.page(pageForm, Wrappers.query(umsMemberLoginLog));
        return R.success("查询成功",page);
    }


    /**
     * 查询一条
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		UmsMemberLoginLogEntity umsMemberLoginLog = umsMemberLoginLogService.getById(id);

       // return R.ok().put("umsMemberLoginLog", umsMemberLoginLog);
        return R.success("查询成功",umsMemberLoginLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody UmsMemberLoginLogEntity umsMemberLoginLog){
		umsMemberLoginLogService.save(umsMemberLoginLog);

        return R.success("保存成功");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody UmsMemberLoginLogEntity umsMemberLoginLog){
		umsMemberLoginLogService.updateById(umsMemberLoginLog);

        return R.success("修改成功");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		umsMemberLoginLogService.removeByIds(Arrays.asList(ids));
        return R.success("删除成功");
    }


}
