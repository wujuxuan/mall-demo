package com.wubaba.gulimallcoupon.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wubaba.gulimallcoupon.dao.SmsMemberPriceDao;
import com.wubaba.gulimallcoupon.entity.SmsMemberPriceEntity;
import com.wubaba.gulimallcoupon.service.SmsMemberPriceService;


@Service("smsMemberPriceService")
public class SmsMemberPriceServiceImpl extends ServiceImpl<SmsMemberPriceDao, SmsMemberPriceEntity> implements SmsMemberPriceService {
}