package com.stylefeng.guns.modular.system.model.payment;

import java.util.Date;

//每个党员缴费情况
public class UserPay {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String name;
    private String userid;
    //每次缴费金额
    private Double payamount;


    //缴费日期
    private Date paytime;

    public UserPay() {
    }

    public Double getPayamount() {
        return payamount;
    }

    public void setPayamount(Double payamount) {
        this.payamount = payamount;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    //当月缴费总额
    private Double totalpay;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotalpay() {
        return totalpay;
    }

    public void setTotalpay(Double totalpay) {
        this.totalpay = totalpay;
    }
}
