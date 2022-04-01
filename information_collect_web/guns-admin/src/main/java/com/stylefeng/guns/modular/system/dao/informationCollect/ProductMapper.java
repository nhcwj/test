package com.stylefeng.guns.modular.system.dao.informationCollect;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.modular.system.model.informationCollect.OrderInfo;
import com.stylefeng.guns.modular.system.model.informationCollect.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}
