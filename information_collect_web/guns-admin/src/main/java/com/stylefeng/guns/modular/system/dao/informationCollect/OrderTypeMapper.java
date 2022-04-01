package com.stylefeng.guns.modular.system.dao.informationCollect;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.modular.system.model.informationCollect.OrderType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface OrderTypeMapper extends BaseMapper<OrderType> {
    List<Map<String,Object>> getOrderTypeMap(Integer id);

}
