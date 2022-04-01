package com.stylefeng.guns.core.common.constant.dictmap;

import com.stylefeng.guns.core.common.constant.dictmap.base.AbstractDictMap;

/**
 * @Auther: biu
 * @Date: 2020/1/15 10:02
 * @Description:
 */
public class LandInfoDict extends AbstractDictMap {
    @Override
    public void init() {
        put("remarks","备注");
        put("landNumber","土地编码");

        put("","");
    }

    @Override
    protected void initBeWrapped() {

    }
}
