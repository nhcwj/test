package com.stylefeng.guns.modular.system.service.impl;

import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.shiro.ShiroUser;
import com.stylefeng.guns.modular.system.dao.UserMapper;
import com.stylefeng.guns.modular.system.dao.informationCollect.IctLogMapper;
import com.stylefeng.guns.modular.system.dao.informationCollect.IctOrderMapper;
import com.stylefeng.guns.modular.system.dao.informationCollect.IctOtherMapper;
import com.stylefeng.guns.modular.system.model.User;
import com.stylefeng.guns.modular.system.model.informationCollect.IctLog;
import com.stylefeng.guns.modular.system.model.informationCollect.IctOrder;
import com.stylefeng.guns.modular.system.model.informationCollect.IctOther;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.modular.system.service.IIctOtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Transactional
public class IctOtherServiceImpl extends ServiceImpl<IctOtherMapper,IctOther> implements IIctOtherService {
    @Autowired
    private IctOtherMapper ictOtherMapper;

    @Autowired
    private IctLogMapper ictLogMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IctOrderMapper ictOrderMapper;

    @Override
    public void insert_ictOther(String ict_id, String order_status, String status, String content) {
        String user_id = ShiroKit.getUser().getId()+"";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String today = simpleDateFormat.format(new Date());
        IctOther ictOther=new IctOther();
        ictOther.setIct_id(ict_id);
        ictOther.setContent(content);
        ictOther.setStatus(status);
        ictOther.setOrder_status(order_status);
        ictOther.setHandle_time(today);
        ictOther.setUser_id(user_id);
        ictOtherMapper.insert(ictOther);

        IctLog ictLog=new IctLog();
        User user=userMapper.selectById(ShiroKit.getUser());
        ictLog.setName(user.getName());
        ictLog.setPhone(user.getPhone());
        ictLog.setOrder_id(ict_id);
        ictLog.setOperate_time(today);
        ictLog.setContent(status);
        ictLog.setProcess(ictOrderMapper.selectById(ict_id).getOrder_status());
        ictLogMapper.insert(ictLog);
    }
}
