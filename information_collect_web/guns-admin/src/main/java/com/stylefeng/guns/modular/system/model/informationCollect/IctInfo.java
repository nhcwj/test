package com.stylefeng.guns.modular.system.model.informationCollect;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("j_ict_info")
public class IctInfo implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    //待付首款/全款提交时间
    @TableField("wait_pay_time")
    private String wait_pay_time;

    //首款/全款确认提交时间
    @TableField("pay_confrim_time")
    private String pay_confrim_time;

    //施工环节提交时间
    @TableField("work_time")
    private String work_time;

    //已验收待尾款提交时间
    @TableField("over_pay_time")
    private String over_pay_time;

    //尾款确认提交时间
    @TableField("over_pay_confrim_time")
    private String over_pay_confrim_time;

    //购买方名称
    @TableField("is_pay_all")
    private String is_pay_all;

    //购买方名称
    @TableField("buy_name")
    private String buy_name;

    //购买方纳税人识别号
    @TableField("buy_tax_payer_no")
    private String buy_tax_payer_no;

    //购买方地址
    @TableField("buy_address")
    private String buy_address;

    //购买方电话
    @TableField("buy_phone")
    private String buy_phone;

    //购买方开户行
    @TableField("buy_open_hang")
    private String buy_open_hang;

    //购买方账号
    @TableField("buy_account")
    private String buy_account;

    @TableField("work_people_time")
    private String work_people_time;

    //客户验收证明附件
    @TableField("client_receive_files")
    private String client_receive_files;

    //客户付款证明附件
    @TableField("client_pay_files")
    private String client_pay_files;

    //上传签署后的合同
    @TableField("order_confirm_files")
    private String order_confirm_files;

    //签署后的合同是否通过
    @TableField("contract_is_pass")
    private String contract_is_pass;

    //首款/全款确认是否通过
    @TableField("first_is_pass")
    private String first_is_pass;

    //首款/全款确认意见
    @TableField("first_suggest")
    private String first_suggest;

    //尾款确认是否通过
    @TableField("last_is_pass")
    private String last_is_pass;

    //尾款确认意见
    @TableField("last_suggest")
    private String last_suggest;

    //客户提供的尾款证明
    @TableField("last_pay_files")
    private String last_pay_files;

    //产品编号
    @TableField("product_no")
    private String product_no;

    public String getProduct_no() {
        return product_no;
    }

    public void setProduct_no(String product_no) {
        this.product_no = product_no;
    }

    public String getWork_people_time() {
        return work_people_time;
    }

    public void setWork_people_time(String work_people_time) {
        this.work_people_time = work_people_time;
    }

    public String getWait_pay_time() {
        return wait_pay_time;
    }

    public void setWait_pay_time(String wait_pay_time) {
        this.wait_pay_time = wait_pay_time;
    }

    public String getPay_confrim_time() {
        return pay_confrim_time;
    }

    public void setPay_confrim_time(String pay_confrim_time) {
        this.pay_confrim_time = pay_confrim_time;
    }

    public String getWork_time() {
        return work_time;
    }

    public void setWork_time(String work_time) {
        this.work_time = work_time;
    }

    public String getOver_pay_time() {
        return over_pay_time;
    }

    public void setOver_pay_time(String over_pay_time) {
        this.over_pay_time = over_pay_time;
    }

    public String getOver_pay_confrim_time() {
        return over_pay_confrim_time;
    }

    public void setOver_pay_confrim_time(String over_pay_confrim_time) {
        this.over_pay_confrim_time = over_pay_confrim_time;
    }

    public String getBuy_name() {
        return buy_name;
    }

    public void setBuy_name(String buy_name) {
        this.buy_name = buy_name;
    }

    public String getBuy_tax_payer_no() {
        return buy_tax_payer_no;
    }

    public void setBuy_tax_payer_no(String buy_tax_payer_no) {
        this.buy_tax_payer_no = buy_tax_payer_no;
    }

    public String getBuy_address() {
        return buy_address;
    }

    public void setBuy_address(String buy_address) {
        this.buy_address = buy_address;
    }

    public String getBuy_phone() {
        return buy_phone;
    }

    public void setBuy_phone(String buy_phone) {
        this.buy_phone = buy_phone;
    }

    public String getBuy_open_hang() {
        return buy_open_hang;
    }

    public void setBuy_open_hang(String buy_open_hang) {
        this.buy_open_hang = buy_open_hang;
    }

    public String getBuy_account() {
        return buy_account;
    }

    public void setBuy_account(String buy_account) {
        this.buy_account = buy_account;
    }

    public String getClient_receive_files() {
        return client_receive_files;
    }

    public void setClient_receive_files(String client_receive_files) {
        this.client_receive_files = client_receive_files;
    }

    public String getClient_pay_files() {
        return client_pay_files;
    }

    public void setClient_pay_files(String client_pay_files) {
        this.client_pay_files = client_pay_files;
    }

    public String getOrder_confirm_files() {
        return order_confirm_files;
    }

    public void setOrder_confirm_files(String order_confirm_files) {
        this.order_confirm_files = order_confirm_files;
    }

    public String getContract_is_pass() {
        return contract_is_pass;
    }

    public void setContract_is_pass(String contract_is_pass) {
        this.contract_is_pass = contract_is_pass;
    }

    public String getFirst_is_pass() {
        return first_is_pass;
    }

    public void setFirst_is_pass(String first_is_pass) {
        this.first_is_pass = first_is_pass;
    }

    public String getFirst_suggest() {
        return first_suggest;
    }

    public void setFirst_suggest(String first_suggest) {
        this.first_suggest = first_suggest;
    }

    public String getLast_is_pass() {
        return last_is_pass;
    }

    public void setLast_is_pass(String last_is_pass) {
        this.last_is_pass = last_is_pass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLast_suggest() {
        return last_suggest;
    }

    public void setLast_suggest(String last_suggest) {
        this.last_suggest = last_suggest;
    }

    public String getLast_pay_files() {
        return last_pay_files;
    }

    public void setLast_pay_files(String last_pay_files) {
        this.last_pay_files = last_pay_files;
    }


    public String getIs_pay_all() {
        return is_pay_all;
    }

    public void setIs_pay_all(String is_pay_all) {
        this.is_pay_all = is_pay_all;
    }

}
