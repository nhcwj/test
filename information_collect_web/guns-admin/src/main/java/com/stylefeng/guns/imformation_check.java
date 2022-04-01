package com.stylefeng.guns;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.modular.system.dao.informationCollect.InformationCollectMapper;
import com.stylefeng.guns.modular.system.dao.informationCollect.PrescriptiMapper;
import com.stylefeng.guns.modular.system.model.informationCollect.InformationCollect;
import com.stylefeng.guns.modular.system.model.informationCollect.Prescripti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class imformation_check {
    @Autowired
    private PrescriptiMapper prescriptiMapper;
    @Autowired
    private InformationCollectMapper informationCollectMapper;

    @Scheduled(cron = "0 0 1 * * ?")
//    @Scheduled(fixedDelay = 1000*60)
    public void informationCollect_count(){
        EntityWrapper<Prescripti> entityWrapper=new EntityWrapper<>();
        List<Prescripti> list=prescriptiMapper.selectList(entityWrapper);
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
        for(Prescripti prescripti:list){
            String contract_sign_time =prescripti.getContract_sign_time();
            String contract_work_day =prescripti.getContract_work_day();
            InformationCollect informationCollect=informationCollectMapper.selectById(prescripti.getInformation_id());
            if(!informationCollect.getProject_stage().contains("交维")){
                if(contract_sign_time!=null &&!contract_sign_time.equals("")){
                    Date date = null;
                    try {
                        date = fmt.parse(contract_sign_time);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Integer worked_day =(int)((new Date().getTime()-date.getTime())/(3600000*24));
                    prescripti.setWorked_day(worked_day+"");
                    if(contract_work_day!=null && !contract_work_day.equals("")){
                        Integer time_level_compare=Integer.parseInt(contract_work_day)-worked_day;
                        prescripti.setTime_level_compare(time_level_compare+"");
                        if(time_level_compare<0){
                            informationCollect.setTime_progress_situation("落后");
                            informationCollectMapper.updateById(informationCollect);
                        }else {
                            informationCollect.setTime_progress_situation("正常");
                            informationCollectMapper.updateById(informationCollect);
                        }
                    }
                    prescriptiMapper.updateById(prescripti);
                }
            }


        }
    }
}
