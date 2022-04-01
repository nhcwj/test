package com.stylefeng.guns.modular.system.model.informationCollect;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.math.BigDecimal;

/**
 * @Auther: biu
 * @Date: 2021/10/22 09:39
 * @Description:
 */
@TableName("f_information_collect_budget_info")
public class BudgetInfo {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("information_collect_id")
    private Integer information_collect_id;

    @TableField("ict_no")
    private String ict_no;

    @TableField("is_apply_budget")
    private String is_apply_budget;

    @TableField("is_out_account")
    private String is_out_account;

    @TableField("collection_condition")
    private String collection_condition;

    @TableField("collection_progress")
    private String collection_progress;

    @TableField("payment_progress")
    private String payment_progress;

    @TableField("is_owe")
    private String is_owe;

    @TableField("owe_reason")
    private String owe_reason;

    @TableField("out_account_price")
    private BigDecimal out_account_price;


    @TableField("budget_no")
    private String budget_no;

    @TableField("owner_contract_no")
    private String owner_contract_no;

    @TableField("supplier_contract_no")
    private String supplier_contract_no;

    @TableField("bill_product_name")
    private String bill_product_name;

    @TableField("bill_price")
    private BigDecimal bill_price;

    @TableField("bill_date")
    private String bill_date;

    @TableField("remark")
    private String remark;


    public String getBudget_no() {
        return budget_no;
    }

    public void setBudget_no(String budget_no) {
        this.budget_no = budget_no;
    }

    public String getOwner_contract_no() {
        return owner_contract_no;
    }

    public void setOwner_contract_no(String owner_contract_no) {
        this.owner_contract_no = owner_contract_no;
    }

    public String getSupplier_contract_no() {
        return supplier_contract_no;
    }

    public void setSupplier_contract_no(String supplier_contract_no) {
        this.supplier_contract_no = supplier_contract_no;
    }

    public String getBill_product_name() {
        return bill_product_name;
    }

    public void setBill_product_name(String bill_product_name) {
        this.bill_product_name = bill_product_name;
    }

    public BigDecimal getBill_price() {
        return bill_price;
    }

    public void setBill_price(BigDecimal bill_price) {
        this.bill_price = bill_price;
    }

    public String getBill_date() {
        return bill_date;
    }

    public void setBill_date(String bill_date) {
        this.bill_date = bill_date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInformation_collect_id() {
        return information_collect_id;
    }

    public void setInformation_collect_id(Integer information_collect_id) {
        this.information_collect_id = information_collect_id;
    }

    public String getIct_no() {
        return ict_no;
    }

    public void setIct_no(String ict_no) {
        this.ict_no = ict_no;
    }

    public String getIs_apply_budget() {
        return is_apply_budget;
    }

    public void setIs_apply_budget(String is_apply_budget) {
        this.is_apply_budget = is_apply_budget;
    }

    public String getIs_out_account() {
        return is_out_account;
    }

    public void setIs_out_account(String is_out_account) {
        this.is_out_account = is_out_account;
    }

    public String getCollection_condition() {
        return collection_condition;
    }

    public void setCollection_condition(String collection_condition) {
        this.collection_condition = collection_condition;
    }

    public String getCollection_progress() {
        return collection_progress;
    }

    public void setCollection_progress(String collection_progress) {
        this.collection_progress = collection_progress;
    }

    public String getPayment_progress() {
        return payment_progress;
    }

    public void setPayment_progress(String payment_progress) {
        this.payment_progress = payment_progress;
    }

    public String getIs_owe() {
        return is_owe;
    }

    public void setIs_owe(String is_owe) {
        this.is_owe = is_owe;
    }

    public String getOwe_reason() {
        return owe_reason;
    }

    public void setOwe_reason(String owe_reason) {
        this.owe_reason = owe_reason;
    }

    public BigDecimal getOut_account_price() {
        return out_account_price;
    }

    public void setOut_account_price(BigDecimal out_account_price) {
        this.out_account_price = out_account_price;
    }
}
