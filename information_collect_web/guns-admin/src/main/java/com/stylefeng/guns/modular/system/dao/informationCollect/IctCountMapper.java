package com.stylefeng.guns.modular.system.dao.informationCollect;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.modular.system.model.informationCollect.IctCount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface IctCountMapper extends BaseMapper<IctCount> {
    List<Map<String,Object>> select_date();

    Map<String,Object> select_count_by_date(@Param("enter_time")String enter_time);
}
