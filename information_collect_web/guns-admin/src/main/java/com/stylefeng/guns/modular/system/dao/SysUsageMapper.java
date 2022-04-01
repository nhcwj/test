package com.stylefeng.guns.modular.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.core.node.ZTreeNode;
import com.stylefeng.guns.modular.system.model.SysUsage;
import com.stylefeng.guns.modular.system.model.addMinusType;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2017-07-11
 */
@Component
public interface SysUsageMapper extends BaseMapper<SysUsage> {

    /**
     * 获取ztree的节点列表
     */
    List<ZTreeNode> tree();



}