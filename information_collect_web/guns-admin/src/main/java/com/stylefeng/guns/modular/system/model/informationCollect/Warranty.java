package com.stylefeng.guns.modular.system.model.informationCollect;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("j_warranty_order")
public class Warranty {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("order_num")
    private String order_num;

    @TableField("type")
    private String type;


    @TableField("appler_name")
    private String appler_name;


    @TableField("appler_phone")
    private String appler_phone;

    @TableField("problem")
    private String problem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrder_num() {
        return order_num;
    }

    public void setOrder_num(String order_num) {
        this.order_num = order_num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAppler_name() {
        return appler_name;
    }

    public void setAppler_name(String appler_name) {
        this.appler_name = appler_name;
    }

    public String getAppler_phone() {
        return appler_phone;
    }

    public void setAppler_phone(String appler_phone) {
        this.appler_phone = appler_phone;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }
}
