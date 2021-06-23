package com.wubaba.gulimallorder.controller;

import java.util.Arrays;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wubaba.gulimallorder.entity.MqMessageEntity;
import com.wubaba.gulimallorder.service.MqMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wubaba.util.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;




/**
 * 
 *
 * @author wujuxuan
 * @email 
 * @date 2021-06-23 15:41:54
 */
@RestController
@RequestMapping("gulimallorder/mqmessage")
public class MqMessageController {
    @Autowired
    private MqMessageService mqMessageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(Page pageForm, MqMessageEntity mqMessage){
        Page page = mqMessageService.page(pageForm, Wrappers.query(mqMessage));
        return R.success("查询成功",page);
    }


    /**
     * 查询一条
     */
    @RequestMapping("/info/{messageId}")
    public R info(@PathVariable("messageId") String messageId){
		MqMessageEntity mqMessage = mqMessageService.getById(messageId);

       // return R.ok().put("mqMessage", mqMessage);
        return R.success("查询成功",mqMessage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MqMessageEntity mqMessage){
		mqMessageService.save(mqMessage);

        return R.success("保存成功");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MqMessageEntity mqMessage){
		mqMessageService.updateById(mqMessage);

        return R.success("修改成功");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] messageIds){
		mqMessageService.removeByIds(Arrays.asList(messageIds));
        return R.success("删除成功");
    }


}
