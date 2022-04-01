package com.stylefeng.guns.modular.system.warpper;

import com.stylefeng.guns.core.base.warpper.BaseControllerWarpper;
import com.stylefeng.guns.core.util.ToolUtil;

import java.util.Map;

public class PartyActivityWarpper extends BaseControllerWarpper {

    public PartyActivityWarpper(Object list) {
        super(list);
    }

    @Override
    protected void warpTheMap(Map<String, Object> map) {
        String content = (String) map.get("content");

        //如果信息过长,则只截取前100位字符串
        if (ToolUtil.isNotEmpty(content) && content.length() >= 30) {
            String subContent = content.substring(0, 30) + "...";
            map.put("content", subContent);
        }
        map.put("regularContent",content);

    }
}
