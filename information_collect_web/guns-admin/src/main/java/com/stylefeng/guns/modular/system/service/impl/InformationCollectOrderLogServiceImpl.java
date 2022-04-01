package com.stylefeng.guns.modular.system.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.shiro.ShiroUser;
import com.stylefeng.guns.modular.system.dao.DeptMapper;
import com.stylefeng.guns.modular.system.dao.UserMapper;
import com.stylefeng.guns.modular.system.dao.informationCollect.InformationCollectMapper;
import com.stylefeng.guns.modular.system.dao.informationCollect.InformationCollectOrderLogMapper;
import com.stylefeng.guns.modular.system.model.User;
import com.stylefeng.guns.modular.system.model.informationCollect.InformationCollectOrderLog;
import com.stylefeng.guns.modular.system.service.IInformationCollectOrderLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class InformationCollectOrderLogServiceImpl extends ServiceImpl<InformationCollectOrderLogMapper, InformationCollectOrderLog> implements IInformationCollectOrderLogService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private InformationCollectOrderLogMapper informationCollectOrderLogMapper;

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public void insertLog(Integer order_id, String content, String operate) {
       InformationCollectOrderLog informationCollectOrderLog=new InformationCollectOrderLog();
       User user =  userMapper.selectById(ShiroKit.getUser().getId());
       informationCollectOrderLog.setOrder_id(order_id);
       informationCollectOrderLog.setOperate(operate);
       informationCollectOrderLog.setContent(content);
       informationCollectOrderLog.setUser_dept(deptMapper.selectById(user.getDeptid()).getSimplename());
       informationCollectOrderLog.setUser_name(user.getName());
       informationCollectOrderLog.setUser_phone(user.getPhone());
       informationCollectOrderLog.setUser_id(user.getId());
       informationCollectOrderLog.setTime(get_now_time());
       informationCollectOrderLogMapper.insert(informationCollectOrderLog);
    }

    public String get_now_time(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }
}
