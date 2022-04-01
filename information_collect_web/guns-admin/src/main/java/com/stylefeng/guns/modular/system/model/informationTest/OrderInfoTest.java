package com.stylefeng.guns.modular.system.model.informationTest;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * @Auther: biu
 * @Date: 2022/1/13 14:51
 * @Description:
 */
@TableName("j_information_collect_test")
public class OrderInfoTest {


    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    //订单状态（设计环节|订单确认|代付首款|施工环节|已验收待尾款|订单结束））
    @TableField("order_status")
    private String order_status;

    //订单编号
    @TableField("order_no")
    private String order_no;

    //下单时间
    @TableField("order_time")
    private String order_time;

    //公司名称
    @TableField("company_name")
    private String company_name;

    //客户名称
    @TableField("client_name")
    private String client_name;

    //客户邮箱
    @TableField("client_email")
    private String client_email;

    //客户联系方式
    @TableField("client_link_phone")
    private String client_link_phone;

    //工单所属区域
    @TableField("order_region")
    private String order_region;

    //详细地址
    @TableField("address")
    private String address;

    //ICT产品类别
    @TableField("ict_type")
    private String ict_type;

    //需求描述
    @TableField("need_desc")
    private String need_desc;

    //前勘人员
    @TableField("pre_people")
    private String pre_people;

    //前勘人员联系方式
    @TableField("pre_people_phone")
    private String pre_people_phone;

    //实施人员
    @TableField("implement_people")
    private String implement_people;

    //实施人员联系方式
    @TableField("implement_people_phone")
    private String implement_people_phone;

    //厂家
    @TableField("factory")
    private String factory;

    //厂家联系方式
    @TableField("factory_phone")
    private String factory_phone;

    //客户经理
    @TableField("client_manager_id")
    private Integer client_manager_id;

    //客户经理
    @TableField("client_manager")
    private String client_manager;

    //客户经理联系方式
    @TableField("client_manager_phone")
    private String client_manager_phone;

    //集团编码
    @TableField("company_no")
    private String company_no;

    //服务包名称
    @TableField("service_name")
    private String service_name;

    //服务包数量
    @TableField("service_num")
    private Integer service_num;

    //服务包单价
    @TableField("service_price")
    private double service_price;

    //服务包总价
    @TableField("service_total_price")
    private double service_total_price;

    //项目方案附件
    @TableField("project_scheme_files")
    private String project_scheme_files;

    //项目报价附件
    @TableField("project_quote_files")
    private String project_quote_files;


    //客户合同附件
    @TableField("client_contract_files")
    private String client_contract_files;



    //建设完成时间
    @TableField("build_finish_time")
    private String build_finish_time;

    //项目总价
    @TableField("project_total_price")
    private double project_total_price;

    //是否支付全款
    @TableField("is_pay_all")
    private String is_pay_all;

    //我司的附件信息
    @TableField("own_company_files")
    private String own_company_files;

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

    //客户验收证明附件
    @TableField("client_receive_files")
    private String client_receive_files;

    //客户付款证明附件
    @TableField("client_pay_files")
    private String client_pay_files;

    //订单确认（是否通过）
    @TableField("order_is_pass")
    private String order_is_pass;

    //订单确认（意见）
    @TableField("order_pass_suggest")
    private String order_pass_suggest;

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

    //项目预算
    @TableField("project_budget")
    private double project_budget;

    //项目预算
    @TableField("ict_num")
    private Integer ict_num;

    //项目预算
    @TableField("apply_phone")
    private String apply_phone;

    //项目预算
    @TableField("is_need_support")
    private String is_need_support;

    //项目预算
    @TableField("support_type")
    private String support_type;

    @TableField("is_manager_register")
    private String is_manager_register;

    @TableField("fgs")
    private String fgs;

    @TableField("wg")
    private String wg;

    @TableField("order_amount")
    private String order_amount;

    @TableField("order_type")
    private String order_type;

    @TableField("is_add_records_client")
    private String is_add_records_client;

    @TableField("status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIs_add_records_client() {
        return is_add_records_client;
    }

    public void setIs_add_records_client(String is_add_records_client) {
        this.is_add_records_client = is_add_records_client;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getFgs() {
        return fgs;
    }

    public void setFgs(String fgs) {
        this.fgs = fgs;
    }

    public String getWg() {
        return wg;
    }

    public void setWg(String wg) {
        this.wg = wg;
    }

    public String getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(String order_amount) {
        this.order_amount = order_amount;
    }

    public double getProject_budget() {
        return project_budget;
    }

    public void setProject_budget(double project_budget) {
        this.project_budget = project_budget;
    }

    public Integer getIct_num() {
        return ict_num;
    }

    public void setIct_num(Integer ict_num) {
        this.ict_num = ict_num;
    }

    public String getApply_phone() {
        return apply_phone;
    }

    public void setApply_phone(String apply_phone) {
        this.apply_phone = apply_phone;
    }

    public String getIs_need_support() {
        return is_need_support;
    }

    public void setIs_need_support(String is_need_support) {
        this.is_need_support = is_need_support;
    }

    public String getSupport_type() {
        return support_type;
    }

    public void setSupport_type(String support_type) {
        this.support_type = support_type;
    }

    public String getLast_pay_files() {
        return last_pay_files;
    }

    public void setLast_pay_files(String last_pay_files) {
        this.last_pay_files = last_pay_files;
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

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getClient_email() {
        return client_email;
    }

    public void setClient_email(String client_email) {
        this.client_email = client_email;
    }

    public String getClient_link_phone() {
        return client_link_phone;
    }

    public void setClient_link_phone(String client_link_phone) {
        this.client_link_phone = client_link_phone;
    }

    public String getOrder_region() {
        return order_region;
    }

    public void setOrder_region(String order_region) {
        this.order_region = order_region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIct_type() {
        return ict_type;
    }

    public void setIct_type(String ict_type) {
        this.ict_type = ict_type;
    }

    public String getNeed_desc() {
        return need_desc;
    }

    public void setNeed_desc(String need_desc) {
        this.need_desc = need_desc;
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

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getFactory_phone() {
        return factory_phone;
    }

    public void setFactory_phone(String factory_phone) {
        this.factory_phone = factory_phone;
    }

    public String getClient_manager() {
        return client_manager;
    }

    public void setClient_manager(String client_manager) {
        this.client_manager = client_manager;
    }

    public String getClient_manager_phone() {
        return client_manager_phone;
    }

    public void setClient_manager_phone(String client_manager_phone) {
        this.client_manager_phone = client_manager_phone;
    }

    public String getCompany_no() {
        return company_no;
    }

    public void setCompany_no(String company_no) {
        this.company_no = company_no;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public Integer getService_num() {
        return service_num;
    }

    public void setService_num(Integer service_num) {
        this.service_num = service_num;
    }

    public double getService_price() {
        return service_price;
    }

    public void setService_price(double service_price) {
        this.service_price = service_price;
    }

    public double getService_total_price() {
        return service_total_price;
    }

    public void setService_total_price(double service_total_price) {
        this.service_total_price = service_total_price;
    }

    public String getProject_scheme_files() {
        return project_scheme_files;
    }

    public void setProject_scheme_files(String project_scheme_files) {
        this.project_scheme_files = project_scheme_files;
    }

    public String getProject_quote_files() {
        return project_quote_files;
    }

    public void setProject_quote_files(String project_quote_files) {
        this.project_quote_files = project_quote_files;
    }

    public String getClient_contract_files() {
        return client_contract_files;
    }

    public void setClient_contract_files(String client_contract_files) {
        this.client_contract_files = client_contract_files;
    }

    public String getBuild_finish_time() {
        return build_finish_time;
    }

    public void setBuild_finish_time(String build_finish_time) {
        this.build_finish_time = build_finish_time;
    }

    public double getProject_total_price() {
        return project_total_price;
    }

    public void setProject_total_price(double project_total_price) {
        this.project_total_price = project_total_price;
    }

    public String getIs_pay_all() {
        return is_pay_all;
    }

    public void setIs_pay_all(String is_pay_all) {
        this.is_pay_all = is_pay_all;
    }

    public String getOwn_company_files() {
        return own_company_files;
    }

    public void setOwn_company_files(String own_company_files) {
        this.own_company_files = own_company_files;
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

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public Integer getClient_manager_id() {
        return client_manager_id;
    }

    public void setClient_manager_id(Integer client_manager_id) {
        this.client_manager_id = client_manager_id;
    }

    public String getOrder_is_pass() {
        return order_is_pass;
    }

    public void setOrder_is_pass(String order_is_pass) {
        this.order_is_pass = order_is_pass;
    }

    public String getOrder_pass_suggest() {
        return order_pass_suggest;
    }

    public void setOrder_pass_suggest(String order_pass_suggest) {
        this.order_pass_suggest = order_pass_suggest;
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

    public String getLast_suggest() {
        return last_suggest;
    }

    public void setLast_suggest(String last_suggest) {
        this.last_suggest = last_suggest;
    }

    public String getIs_manager_register() {
        return is_manager_register;
    }

    public void setIs_manager_register(String is_manager_register) {
        this.is_manager_register = is_manager_register;
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", order_status:'" + order_status + '\'' +
                ", order_no:'" + order_no + '\'' +
                ", order_time:'" + order_time + '\'' +
                ", company_name:'" + company_name + '\'' +
                ", client_name:'" + client_name + '\'' +
                ", client_email:'" + client_email + '\'' +
                ", client_link_phone:'" + client_link_phone + '\'' +
                ", order_region:'" + order_region + '\'' +
                ", address:'" + address + '\'' +
                ", ict_type:'" + ict_type + '\'' +
                ", need_desc:'" + need_desc + '\'' +
                ", pre_people:'" + pre_people + '\'' +
                ", pre_people_phone:'" + pre_people_phone + '\'' +
                ", implement_people:'" + implement_people + '\'' +
                ", implement_people_phone:'" + implement_people_phone + '\'' +
                ", factory:'" + factory + '\'' +
                ", factory_phone:'" + factory_phone + '\'' +
                ", client_manager_id:" + client_manager_id +
                ", client_manager:'" + client_manager + '\'' +
                ", client_manager_phone:'" + client_manager_phone + '\'' +
                ", company_no:'" + company_no + '\'' +
                ", service_name:'" + service_name + '\'' +
                ", service_num:" + service_num +
                ", service_price:" + service_price +
                ", service_total_price:" + service_total_price +
                ", project_scheme_files:'" + project_scheme_files + '\'' +
                ", project_quote_files:'" + project_quote_files + '\'' +
                ", client_contract_files:'" + client_contract_files + '\'' +
                ", build_finish_time:'" + build_finish_time + '\'' +
                ", project_total_price:" + project_total_price +
                ", is_pay_all:'" + is_pay_all + '\'' +
                ", own_company_files:'" + own_company_files + '\'' +
                ", buy_name:'" + buy_name + '\'' +
                ", buy_tax_payer_no:'" + buy_tax_payer_no + '\'' +
                ", buy_address:'" + buy_address + '\'' +
                ", buy_phone:'" + buy_phone + '\'' +
                ", buy_open_hang:'" + buy_open_hang + '\'' +
                ", buy_account:'" + buy_account + '\'' +
                ", client_receive_files:'" + client_receive_files + '\'' +
                ", client_pay_files:'" + client_pay_files + '\'' +
                ", order_is_pass:'" + order_is_pass + '\'' +
                ", order_pass_suggest:'" + order_pass_suggest + '\'' +
                ", order_confirm_files:'" + order_confirm_files + '\'' +
                ", contract_is_pass:'" + contract_is_pass + '\'' +
                ", first_is_pass:'" + first_is_pass + '\'' +
                ", first_suggest:'" + first_suggest + '\'' +
                ", last_is_pass:'" + last_is_pass + '\'' +
                ", last_suggest:'" + last_suggest + '\'' +
                ", last_pay_files:'" + last_pay_files + '\'' +
                ", project_budget:" + project_budget +
                ", ict_num:" + ict_num +
                ", apply_phone:'" + apply_phone + '\'' +
                ", is_need_support:'" + is_need_support + '\'' +
                ", support_type:'" + support_type + '\'' +
                ", is_manager_register:'" + is_manager_register + '\'' +
                '}';
    }
}
