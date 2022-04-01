package com.stylefeng.guns.modular.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.stylefeng.guns.modular.system.model.activity.ActivityInfo;

import java.util.List;
import java.util.Map;

public interface IPartyActivityService extends IService<ActivityInfo> {
    List<Map<String, Object>> getPartyActivity(String year);



    List<Map<String, Object>> getBranchActivity(String year, String deptId);

    List<Map<String, Object>> getBranchSub(String year);

    List<Map<String, Object>> getBranchActInfo(String year, String branchId);
}
