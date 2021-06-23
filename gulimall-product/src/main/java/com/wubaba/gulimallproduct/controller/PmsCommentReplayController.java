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
import com.wubaba.gulimallproduct.entity.PmsCommentReplayEntity;
import com.wubaba.gulimallproduct.service.PmsCommentReplayService;




/**
 * 商品评价回复关系
 *
 * @author wujuxuan
 * @email 
 * @date 2021-06-23 15:05:14
 */
@RestController
@RequestMapping("gulimallproduct/pmscommentreplay")
public class PmsCommentReplayController {
    @Autowired
    private PmsCommentReplayService pmsCommentReplayService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(Page pageForm, PmsCommentReplayEntity pmsCommentReplay){
        Page page = pmsCommentReplayService.page(pageForm, Wrappers.query(pmsCommentReplay));
        return R.success("查询成功",page);
    }


    /**
     * 查询一条
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		PmsCommentReplayEntity pmsCommentReplay = pmsCommentReplayService.getById(id);

       // return R.ok().put("pmsCommentReplay", pmsCommentReplay);
        return R.success("查询成功",pmsCommentReplay);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PmsCommentReplayEntity pmsCommentReplay){
		pmsCommentReplayService.save(pmsCommentReplay);

        return R.success("保存成功");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PmsCommentReplayEntity pmsCommentReplay){
		pmsCommentReplayService.updateById(pmsCommentReplay);

        return R.success("修改成功");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		pmsCommentReplayService.removeByIds(Arrays.asList(ids));
        return R.success("删除成功");
    }


}
