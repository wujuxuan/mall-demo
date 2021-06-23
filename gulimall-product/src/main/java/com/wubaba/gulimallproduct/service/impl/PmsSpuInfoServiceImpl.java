package com.wubaba.gulimallproduct.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wubaba.gulimallproduct.dao.PmsSpuInfoDao;
import com.wubaba.gulimallproduct.entity.PmsSpuInfoEntity;
import com.wubaba.gulimallproduct.service.PmsSpuInfoService;


@Service("pmsSpuInfoService")
public class PmsSpuInfoServiceImpl extends ServiceImpl<PmsSpuInfoDao, PmsSpuInfoEntity> implements PmsSpuInfoService {
}