package com.stylefeng.guns.core.base.tips;

public class TranslateTip extends Tip {

    public TranslateTip(Integer[] datas) {
        super.code = 200;
        super.message = "操作成功";
        super.datas = datas;
    }
}
