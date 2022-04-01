package com.stylefeng.guns.modular.system.model.informationCollect;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("j_information_collect_appraise")
public class Appraise {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("order_id")
    private Integer order_id;

    @TableField("client_appraise")
    private String client_appraise;

    @TableField("need_dept_appraise")
    private String need_dept_appraise;

    @TableField("collect_dept_appraise")
    private String collect_dept_appraise;

    @TableField("end_dept_appraise")
    private String end_dept_appraise;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getClient_appraise() {
        return client_appraise;
    }

    public void setClient_appraise(String client_appraise) {
        this.client_appraise = client_appraise;
    }

    public String getNeed_dept_appraise() {
        return need_dept_appraise;
    }

    public void setNeed_dept_appraise(String need_dept_appraise) {
        this.need_dept_appraise = need_dept_appraise;
    }

    public String getCollect_dept_appraise() {
        return collect_dept_appraise;
    }

    public void setCollect_dept_appraise(String collect_dept_appraise) {
        this.collect_dept_appraise = collect_dept_appraise;
    }

    public String getEnd_dept_appraise() {
        return end_dept_appraise;
    }

    public void setEnd_dept_appraise(String end_dept_appraise) {
        this.end_dept_appraise = end_dept_appraise;
    }

    @Override
    public String toString() {
        return "appraise{" +
                "id=" + id +
                ", order_id=" + order_id +
                ", client_appraise='" + client_appraise + '\'' +
                ", need_dept_appraise='" + need_dept_appraise + '\'' +
                ", collect_dept_appraise='" + collect_dept_appraise + '\'' +
                ", end_dept_appraise='" + end_dept_appraise + '\'' +
                '}';
    }
}
