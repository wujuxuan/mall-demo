package com.wubaba.gulimallorder.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wubaba.gulimallorder.dao.MqMessageDao;
import com.wubaba.gulimallorder.entity.MqMessageEntity;
import com.wubaba.gulimallorder.service.MqMessageService;


@Service("mqMessageService")
public class MqMessageServiceImpl extends ServiceImpl<MqMessageDao, MqMessageEntity> implements MqMessageService {
}