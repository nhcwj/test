package com.stylefeng.guns.modular.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.stylefeng.guns.modular.system.model.informationCollect.IctOther;

public interface IIctOtherService extends IService<IctOther> {
    public void insert_ictOther(String ict_id,String order_status,String status,String content);
}
