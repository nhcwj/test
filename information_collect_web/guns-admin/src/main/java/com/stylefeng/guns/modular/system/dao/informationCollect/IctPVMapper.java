package com.stylefeng.guns.modular.system.dao.informationCollect;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.modular.system.model.informationCollect.IctCount;
import com.stylefeng.guns.modular.system.model.informationCollect.IctPV;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface IctPVMapper extends BaseMapper<IctPV> {
}
