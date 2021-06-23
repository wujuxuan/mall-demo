package com.wubaba.gulimallorder.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wubaba.gulimallorder.dao.OmsOrderDao;
import com.wubaba.gulimallorder.entity.OmsOrderEntity;
import com.wubaba.gulimallorder.service.OmsOrderService;


@Service("omsOrderService")
public class OmsOrderServiceImpl extends ServiceImpl<OmsOrderDao, OmsOrderEntity> implements OmsOrderService {
}