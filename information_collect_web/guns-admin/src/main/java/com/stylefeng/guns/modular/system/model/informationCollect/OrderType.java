package com.stylefeng.guns.modular.system.model.informationCollect;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("j_order_type")
public class OrderType {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("ict_order_id")
    private Integer ict_order_id;

    @TableField("type_id")
    private Integer type_id;

    @TableField("pre_people")
    private String pre_people;

    @TableField("pre_people_phone")
    private String pre_people_phone;

    @TableField("implement_people")
    private String implement_people;

    @TableField("implement_people_phone")
    private String implement_people_phone;

    @TableField("pre_people_id")
    private Integer pre_people_id;

    @TableField("implement_people_id")
    private Integer implement_people_id;

    @TableField("over_files")
    private String over_files;

    @TableField("package_num")
    private Integer package_num;

    @TableField("build_over_time")
    private String build_over_time;

    @TableField("sell_money")
    private String sell_money;

    @TableField("sell_no_tax_money")
    private String sell_no_tax_money;

    public String getOver_files() {
        return over_files;
    }

    public void setOver_files(String over_files) {
        this.over_files = over_files;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIct_order_id() {
        return ict_order_id;
    }

    public void setIct_order_id(Integer ict_order_id) {
        this.ict_order_id = ict_order_id;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public String getPre_people() {
        return pre_people;
    }

    public void setPre_people(String pre_people) {
        this.pre_people = pre_people;
    }

    public String getPre_people_phone() {
        return pre_people_phone;
    }

    public void setPre_people_phone(String pre_people_phone) {
        this.pre_people_phone = pre_people_phone;
    }

    public String getImplement_people() {
        return implement_people;
    }

    public void setImplement_people(String implement_people) {
        this.implement_people = implement_people;
    }

    public String getImplement_people_phone() {
        return implement_people_phone;
    }

    public void setImplement_people_phone(String implement_people_phone) {
        this.implement_people_phone = implement_people_phone;
    }

    public Integer getPre_people_id() {
        return pre_people_id;
    }

    public void setPre_people_id(Integer pre_people_id) {
        this.pre_people_id = pre_people_id;
    }

    public Integer getImplement_people_id() {
        return implement_people_id;
    }

    public void setImplement_people_id(Integer implement_people_id) {
        this.implement_people_id = implement_people_id;
    }

    public Integer getPackage_num() {
        return package_num;
    }

    public void setPackage_num(Integer package_num) {
        this.package_num = package_num;
    }

    public String getBuild_over_time() {
        return build_over_time;
    }

    public void setBuild_over_time(String build_over_time) {
        this.build_over_time = build_over_time;
    }

    public String getSell_money() {
        return sell_money;
    }

    public void setSell_money(String sell_money) {
        this.sell_money = sell_money;
    }

    public String getSell_no_tax_money() {
        return sell_no_tax_money;
    }

    public void setSell_no_tax_money(String sell_no_tax_money) {
        this.sell_no_tax_money = sell_no_tax_money;
    }

    @Override
    public String toString() {
        return "OrderType{" +
                "id=" + id +
                ", ict_order_id=" + ict_order_id +
                ", type_id=" + type_id +
                ", pre_people='" + pre_people + '\'' +
                ", pre_people_phone='" + pre_people_phone + '\'' +
                ", implement_people='" + implement_people + '\'' +
                ", implement_people_phone='" + implement_people_phone + '\'' +
                ", pre_people_id=" + pre_people_id +
                ", implement_people_id=" + implement_people_id +
                ", over_files='" + over_files + '\'' +
                ", package_num=" + package_num +
                ", build_over_time='" + build_over_time + '\'' +
                ", sell_money='" + sell_money + '\'' +
                ", sell_no_tax_money='" + sell_no_tax_money + '\'' +
                '}';
    }
}
