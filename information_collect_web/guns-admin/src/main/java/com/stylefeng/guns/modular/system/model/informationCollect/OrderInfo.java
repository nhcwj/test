package com.stylefeng.guns.modular.system.model.informationCollect;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("j_order_info")
public class OrderInfo {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("order_status")
    private String order_status;

    @TableField("curren_process")
    private String curren_process;

    @TableField("order_number")
    private String order_number;

    @TableField("down_order_time")
    private String down_order_time;

    @TableField("company_name")
    private String company_name;

    @TableField("custom_name")
    private String custom_name;

    @TableField("custom_phone")
    private String custom_phone;

    @TableField("custom_manager")
    private String custom_manager;

    @TableField("custom_manager_phone")
    private String custom_manager_phone;

    @TableField("request_describe")
    private String request_describe;

    @TableField("company_city")
    private String company_city;

    @TableField("company_address")
    private String company_address;

    @TableField("ICT_product")
    private String ICT_product;

    @TableField("ICT_product_name")
    private String ICT_product_name;

    @TableField("ICT_product_quantity")
    private String ICT_product_quantity;

    @TableField("group_code")
    private String group_code;

    @TableField("applyer_phone")
    private String applyer_phone;

    @TableField("client_manager_id")
    private String client_manager_id;

    @TableField("apply_time")
    private String apply_time;

    @TableField("design_time")
    private String design_time;

    @TableField("work_time")
    private String work_time;

    @TableField("end_time")
    private String end_time;

    @TableField("files")
    private String files;

    @TableField("is_read")
    private String is_read;

    @TableField("qk_info")
    private String qk_info;

    @TableField("ss_info")
    private String ss_info;

    @TableField("contract_money")
    private String contract_money;

    @TableField("contract_file")
    private String contract_file;

    @TableField("is_need_apply")
    private String is_need_apply;

    @TableField("apply_type")
    private String apply_type;

    @TableField("project_file")
    private String project_file;

    @TableField("money_file")
    private String money_file;

    @TableField("is_pass_client")
    private String is_pass_client;

    @TableField("client_contract_file")
    private String client_contract_file;

    @TableField("client_idea")
    private String client_idea;

    @TableField("email")
    private String email;

    @TableField("qk_phone")
    private String qk_phone;

    @TableField("ss_phone")
    private String ss_phone;

    @TableField("cj")
    private String cj;

    @TableField("cj_phone")
    private String cj_phone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIs_pass_client() {
        return is_pass_client;
    }

    public void setIs_pass_client(String is_pass_client) {
        this.is_pass_client = is_pass_client;
    }

    public String getClient_contract_file() {
        return client_contract_file;
    }

    public void setClient_contract_file(String client_contract_file) {
        this.client_contract_file = client_contract_file;
    }

    public String getClient_idea() {
        return client_idea;
    }

    public void setClient_idea(String client_idea) {
        this.client_idea = client_idea;
    }

    public String getContract_money() {
        return contract_money;
    }

    public void setContract_money(String contract_money) {
        this.contract_money = contract_money;
    }

    public String getContract_file() {
        return contract_file;
    }

    public void setContract_file(String contract_file) {
        this.contract_file = contract_file;
    }

    public String getIs_need_apply() {
        return is_need_apply;
    }

    public void setIs_need_apply(String is_need_apply) {
        this.is_need_apply = is_need_apply;
    }

    public String getApply_type() {
        return apply_type;
    }

    public void setApply_type(String apply_type) {
        this.apply_type = apply_type;
    }

    public String getProject_file() {
        return project_file;
    }

    public void setProject_file(String project_file) {
        this.project_file = project_file;
    }

    public String getMoney_file() {
        return money_file;
    }

    public void setMoney_file(String money_file) {
        this.money_file = money_file;
    }

    public String getQk_info() {
        return qk_info;
    }

    public void setQk_info(String qk_info) {
        this.qk_info = qk_info;
    }

    public String getSs_info() {
        return ss_info;
    }

    public void setSs_info(String ss_info) {
        this.ss_info = ss_info;
    }

    public String getIs_read() {
        return is_read;
    }

    public void setIs_read(String is_read) {
        this.is_read = is_read;
    }

    public String getCompany_address() {
        return company_address;
    }

    public void setCompany_address(String company_address) {
        this.company_address = company_address;
    }

    public String getApply_time() {
        return apply_time;
    }

    public void setApply_time(String apply_time) {
        this.apply_time = apply_time;
    }

    public String getDesign_time() {
        return design_time;
    }

    public void setDesign_time(String design_time) {
        this.design_time = design_time;
    }

    public String getWork_time() {
        return work_time;
    }

    public void setWork_time(String work_time) {
        this.work_time = work_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getCompany_city() {
        return company_city;
    }

    public void setCompany_city(String company_city) {
        this.company_city = company_city;
    }


    public String getICT_product() {
        return ICT_product;
    }

    public void setICT_product(String ICT_product) {
        this.ICT_product = ICT_product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getCurren_process() {
        return curren_process;
    }

    public void setCurren_process(String curren_process) {
        this.curren_process = curren_process;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public String getDown_order_time() {
        return down_order_time;
    }

    public void setDown_order_time(String down_order_time) {
        this.down_order_time = down_order_time;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCustom_name() {
        return custom_name;
    }

    public void setCustom_name(String custom_name) {
        this.custom_name = custom_name;
    }

    public String getCustom_phone() {
        return custom_phone;
    }

    public void setCustom_phone(String custom_phone) {
        this.custom_phone = custom_phone;
    }

    public String getCustom_manager() {
        return custom_manager;
    }

    public void setCustom_manager(String custom_manager) {
        this.custom_manager = custom_manager;
    }

    public String getCustom_manager_phone() {
        return custom_manager_phone;
    }

    public void setCustom_manager_phone(String custom_manager_phone) {
        this.custom_manager_phone = custom_manager_phone;
    }

    public String getRequest_describe() {
        return request_describe;
    }

    public void setRequest_describe(String request_describe) {
        this.request_describe = request_describe;
    }

    public String getICT_product_name() {
        return ICT_product_name;
    }

    public void setICT_product_name(String ICT_product_name) {
        this.ICT_product_name = ICT_product_name;
    }

    public String getICT_product_quantity() {
        return ICT_product_quantity;
    }

    public void setICT_product_quantity(String ICT_product_quantity) {
        this.ICT_product_quantity = ICT_product_quantity;
    }

    public String getGroup_code() {
        return group_code;
    }

    public void setGroup_code(String group_code) {
        this.group_code = group_code;
    }

    public String getApplyer_phone() {
        return applyer_phone;
    }

    public void setApplyer_phone(String applyer_phone) {
        this.applyer_phone = applyer_phone;
    }

    public String getClient_manager_id() {
        return client_manager_id;
    }

    public void setClient_manager_id(String client_manager_id) {
        this.client_manager_id = client_manager_id;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public String getQk_phone() {
        return qk_phone;
    }

    public void setQk_phone(String qk_phone) {
        this.qk_phone = qk_phone;
    }

    public String getSs_phone() {
        return ss_phone;
    }

    public void setSs_phone(String ss_phone) {
        this.ss_phone = ss_phone;
    }

    public String getCj() {
        return cj;
    }

    public void setCj(String cj) {
        this.cj = cj;
    }

    public String getCj_phone() {
        return cj_phone;
    }

    public void setCj_phone(String cj_phone) {
        this.cj_phone = cj_phone;
    }
}
