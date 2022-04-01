package com.stylefeng.guns.modular.system.model.informationCollect;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("j_services_package")
public class ServicesPackage {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("services_package")
    private String services_package;

    @TableField("services_package_son")
    private String services_package_son;

    @TableField("unit")
    private String unit;

    @TableField("company")
    private String company;

    @TableField("give_company_no_tax_money")
    private String give_company_no_tax_money;

    @TableField("give_company_money")
    private String give_company_money;

    @TableField("client_no_tax_down_money")
    private String client_no_tax_down_money;

    @TableField("client_down_money")
    private String client_down_money;

    @TableField("client_no_tax_money")
    private String client_no_tax_money;

    @TableField("client_money")
    private String client_money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServices_package() {
        return services_package;
    }

    public void setServices_package(String services_package) {
        this.services_package = services_package;
    }

    public String getServices_package_son() {
        return services_package_son;
    }

    public void setServices_package_son(String services_package_son) {
        this.services_package_son = services_package_son;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getGive_company_no_tax_money() {
        return give_company_no_tax_money;
    }

    public void setGive_company_no_tax_money(String give_company_no_tax_money) {
        this.give_company_no_tax_money = give_company_no_tax_money;
    }

    public String getGive_company_money() {
        return give_company_money;
    }

    public void setGive_company_money(String give_company_money) {
        this.give_company_money = give_company_money;
    }

    public String getClient_no_tax_down_money() {
        return client_no_tax_down_money;
    }

    public void setClient_no_tax_down_money(String client_no_tax_down_money) {
        this.client_no_tax_down_money = client_no_tax_down_money;
    }

    public String getClient_down_money() {
        return client_down_money;
    }

    public void setClient_down_money(String client_down_money) {
        this.client_down_money = client_down_money;
    }

    public String getClient_no_tax_money() {
        return client_no_tax_money;
    }

    public void setClient_no_tax_money(String client_no_tax_money) {
        this.client_no_tax_money = client_no_tax_money;
    }

    public String getClient_money() {
        return client_money;
    }

    public void setClient_money(String client_money) {
        this.client_money = client_money;
    }

    @Override
    public String toString() {
        return "ServicesPackage{" +
                "id=" + id +
                ", services_package='" + services_package + '\'' +
                ", services_package_son='" + services_package_son + '\'' +
                ", unit='" + unit + '\'' +
                ", company='" + company + '\'' +
                ", give_company_no_tax_money='" + give_company_no_tax_money + '\'' +
                ", give_company_money='" + give_company_money + '\'' +
                ", client_no_tax_down_money='" + client_no_tax_down_money + '\'' +
                ", client_down_money='" + client_down_money + '\'' +
                ", client_no_tax_money='" + client_no_tax_money + '\'' +
                ", client_money='" + client_money + '\'' +
                '}';
    }
}
