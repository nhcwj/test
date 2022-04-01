package com.stylefeng.guns.modular.system.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.IService;
import com.stylefeng.guns.modular.system.model.informationCollect.InformationCollectOrderLog;

public interface IInformationCollectOrderLogService extends IService<InformationCollectOrderLog> {
    /**
     * operate:新建、查询清单、查看工单、修改
     * content:"基本信息/时效/周报/收支情况/满意度"
     * order_id:主表id*/
//    content 含有
    void insertLog(Integer order_id, String content, String operate);
}
