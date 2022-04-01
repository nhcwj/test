package com.stylefeng.guns.modular.system.model.informationCollect;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("j_product")
public class Product {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField("introduce")
    private String introduce;
    @TableField("application")
    private String application;
    @TableField("model")
    private String model;
    @TableField("advantage_one")
    private String advantage_one;
    @TableField("advantage_two")
    private String advantage_two;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAdvantage_one() {
        return advantage_one;
    }

    public void setAdvantage_one(String advantage_one) {
        this.advantage_one = advantage_one;
    }

    public String getAdvantage_two() {
        return advantage_two;
    }

    public void setAdvantage_two(String advantage_two) {
        this.advantage_two = advantage_two;
    }
}
