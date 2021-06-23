package com.wubaba.gulimallcoupon.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wubaba.gulimallcoupon.dao.SmsSeckillSessionDao;
import com.wubaba.gulimallcoupon.entity.SmsSeckillSessionEntity;
import com.wubaba.gulimallcoupon.service.SmsSeckillSessionService;


@Service("smsSeckillSessionService")
public class SmsSeckillSessionServiceImpl extends ServiceImpl<SmsSeckillSessionDao, SmsSeckillSessionEntity> implements SmsSeckillSessionService {
}