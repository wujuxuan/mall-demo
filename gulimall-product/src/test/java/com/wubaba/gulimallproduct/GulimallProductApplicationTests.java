package com.wubaba.gulimallproduct;

import com.wubaba.gulimallproduct.entity.PmsBrandEntity;
import com.wubaba.gulimallproduct.service.PmsBrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GulimallProductApplicationTests {
    @Autowired
    PmsBrandService brandService;

    @Test
    void contextLoads() {
        PmsBrandEntity brandEntity = new PmsBrandEntity();
        brandEntity.setBrandId(1L);
        brandEntity.setDescript("修改");
        brandService.updateById(brandEntity);

    }

}
