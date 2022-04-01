package com.stylefeng.guns.modular.system.model.informationCollect;

import java.util.List;

/**
 * 用于IctHController
 * 仅用于有序输出ict_order和ict_info的JSON数据
 */
public class OrderInfoJSON {
    private Integer id;

    //订单状态（设计环节|订单确认|代付首款|施工环节|已验收待尾款|订单结束））
    private String order_status;

    //订单编号
    private String order_no;

    //下单时间
    private String order_time;

    private String first_verify_time;

    private String design_time;

    private String confirm_time;

    private String order_verify_time;

    //公司名称
    private String company_name;

    //客户名称
    private String client_name;

    //客户邮箱
    private String client_email;

    private double project_budget;

    private String is_need_support;

    private Integer ict_num;

    //客户联系方式
    private String client_link_phone;

    //工单所属区域
    private String order_region;

    //详细地址
    private String address;

    //ICT产品类别
    private String ict_type;

    //需求描述
    private String need_desc;

    //前勘人员
    private String pre_people;

    //前勘人员联系方式
    private String pre_people_phone;

    //实施人员
    private String implement_people;

    //实施人员联系方式
    private String implement_people_phone;

    //厂家
    private String factory;

    //厂家联系方式
    private String factory_phone;

    //客户经理
    private Integer client_manager_id;

    //客户经理
    private String client_manager;

    //客户经理联系方式
    private String client_manager_phone;

    //集团编码
    private String company_no;

    //服务包名称
    private String service_name;

    //服务包数量
    private Integer service_num;

    //服务包单价
    private double service_price;

    //服务包总价
    private double service_total_price;

    //项目方案附件
    private String project_scheme_files;

    //项目报价附件
    private String project_quote_files;

    //客户合同附件
    private String client_contract_files;

    //客户合同附件
    private String own_company_files;

    //建设完成时间
    private String build_finish_time;

    //项目总价
    private double project_total_price;

    //订单确认（是否通过）
    private String order_is_pass;

    //订单确认（意见）
    private String order_pass_suggest;

    //    付款子表id
    private String info_order_id;

    //上传签署后的合同
    private String order_confirm_files;

    //签署后的合同是否通过
    private String contract_is_pass;

    //    是否客户最新更改
    private String is_change_client;

    //    是否中台最新更改
    private String is_change;

    private String apply_phone;

    private String support_type;

    private String is_manager_register;

    private String wg;

    private String order_amount;

    private String fgs;

    private String wait_pay_time;

    //首款/全款确认提交时间
    private String pay_confrim_time;

    //施工环节提交时间
    private String work_time;

    //已验收待尾款提交时间
    private String over_pay_time;

    //尾款确认提交时间
    private String over_pay_confrim_time;

    //购买方名称
    private String is_pay_all;

    //购买方名称
    private String buy_name;

    //购买方纳税人识别号
    private String buy_tax_payer_no;

    //购买方地址
    private String buy_address;

    //购买方电话
    private String buy_phone;

    //购买方开户行
    private String buy_open_hang;

    //购买方账号
    private String buy_account;

    //客户验收证明附件
    private String client_receive_files;

    //客户付款证明附件
    private String client_pay_files;

    //首款/全款确认是否通过
    private String first_is_pass;

    //首款/全款确认意见
    private String first_suggest;

    //尾款确认是否通过
    private String last_is_pass;

    //尾款确认意见
    private String last_suggest;

    //客户提供的尾款证明
    private String last_pay_files;

    private List<LogJSON> logList;

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

    public String getFirst_verify_time() {
        return first_verify_time;
    }

    public void setFirst_verify_time(String first_verify_time) {
        this.first_verify_time = first_verify_time;
    }

    public String getDesign_time() {
        return design_time;
    }

    public void setDesign_time(String design_time) {
        this.design_time = design_time;
    }

    public String getConfirm_time() {
        return confirm_time;
    }

    public void setConfirm_time(String confirm_time) {
        this.confirm_time = confirm_time;
    }

    public String getOrder_verify_time() {
        return order_verify_time;
    }

    public void setOrder_verify_time(String order_verify_time) {
        this.order_verify_time = order_verify_time;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_email() {
        return client_email;
    }

    public void setClient_email(String client_email) {
        this.client_email = client_email;
    }

    public double getProject_budget() {
        return project_budget;
    }

    public void setProject_budget(double project_budget) {
        this.project_budget = project_budget;
    }

    public String getIs_need_support() {
        return is_need_support;
    }

    public void setIs_need_support(String is_need_support) {
        this.is_need_support = is_need_support;
    }

    public Integer getIct_num() {
        return ict_num;
    }

    public void setIct_num(Integer ict_num) {
        this.ict_num = ict_num;
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

    public Integer getClient_manager_id() {
        return client_manager_id;
    }

    public void setClient_manager_id(Integer client_manager_id) {
        this.client_manager_id = client_manager_id;
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

    public String getOwn_company_files() {
        return own_company_files;
    }

    public void setOwn_company_files(String own_company_files) {
        this.own_company_files = own_company_files;
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

    public String getInfo_order_id() {
        return info_order_id;
    }

    public void setInfo_order_id(String info_order_id) {
        this.info_order_id = info_order_id;
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

    public String getIs_change_client() {
        return is_change_client;
    }

    public void setIs_change_client(String is_change_client) {
        this.is_change_client = is_change_client;
    }

    public String getIs_change() {
        return is_change;
    }

    public void setIs_change(String is_change) {
        this.is_change = is_change;
    }

    public String getApply_phone() {
        return apply_phone;
    }

    public void setApply_phone(String apply_phone) {
        this.apply_phone = apply_phone;
    }

    public String getSupport_type() {
        return support_type;
    }

    public void setSupport_type(String support_type) {
        this.support_type = support_type;
    }

    public String getIs_manager_register() {
        return is_manager_register;
    }

    public void setIs_manager_register(String is_manager_register) {
        this.is_manager_register = is_manager_register;
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

    public String getFgs() {
        return fgs;
    }

    public void setFgs(String fgs) {
        this.fgs = fgs;
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

    public String getIs_pay_all() {
        return is_pay_all;
    }

    public void setIs_pay_all(String is_pay_all) {
        this.is_pay_all = is_pay_all;
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

    public String getLast_pay_files() {
        return last_pay_files;
    }

    public void setLast_pay_files(String last_pay_files) {
        this.last_pay_files = last_pay_files;
    }

    public List<LogJSON> getLogList() {
        return logList;
    }

    public void setLogList(List<LogJSON> logList) {
        this.logList = logList;
    }

    @Override
    public String toString() {
        return "OrderInfoJSON{" +
                "id=" + id +
                ", order_status='" + order_status + '\'' +
                ", order_no='" + order_no + '\'' +
                ", order_time='" + order_time + '\'' +
                ", first_verify_time='" + first_verify_time + '\'' +
                ", design_time='" + design_time + '\'' +
                ", confirm_time='" + confirm_time + '\'' +
                ", order_verify_time='" + order_verify_time + '\'' +
                ", company_name='" + company_name + '\'' +
                ", client_name='" + client_name + '\'' +
                ", client_email='" + client_email + '\'' +
                ", project_budget=" + project_budget +
                ", is_need_support='" + is_need_support + '\'' +
                ", ict_num=" + ict_num +
                ", client_link_phone='" + client_link_phone + '\'' +
                ", order_region='" + order_region + '\'' +
                ", address='" + address + '\'' +
                ", ict_type='" + ict_type + '\'' +
                ", need_desc='" + need_desc + '\'' +
                ", pre_people='" + pre_people + '\'' +
                ", pre_people_phone='" + pre_people_phone + '\'' +
                ", implement_people='" + implement_people + '\'' +
                ", implement_people_phone='" + implement_people_phone + '\'' +
                ", factory='" + factory + '\'' +
                ", factory_phone='" + factory_phone + '\'' +
                ", client_manager_id=" + client_manager_id +
                ", client_manager='" + client_manager + '\'' +
                ", client_manager_phone='" + client_manager_phone + '\'' +
                ", company_no='" + company_no + '\'' +
                ", service_name='" + service_name + '\'' +
                ", service_num=" + service_num +
                ", service_price=" + service_price +
                ", service_total_price=" + service_total_price +
                ", project_scheme_files='" + project_scheme_files + '\'' +
                ", project_quote_files='" + project_quote_files + '\'' +
                ", client_contract_files='" + client_contract_files + '\'' +
                ", own_company_files='" + own_company_files + '\'' +
                ", build_finish_time='" + build_finish_time + '\'' +
                ", project_total_price=" + project_total_price +
                ", order_is_pass='" + order_is_pass + '\'' +
                ", order_pass_suggest='" + order_pass_suggest + '\'' +
                ", info_order_id='" + info_order_id + '\'' +
                ", order_confirm_files='" + order_confirm_files + '\'' +
                ", contract_is_pass='" + contract_is_pass + '\'' +
                ", is_change_client='" + is_change_client + '\'' +
                ", is_change='" + is_change + '\'' +
                ", apply_phone='" + apply_phone + '\'' +
                ", support_type='" + support_type + '\'' +
                ", is_manager_register='" + is_manager_register + '\'' +
                ", wg='" + wg + '\'' +
                ", order_amount='" + order_amount + '\'' +
                ", fgs='" + fgs + '\'' +
                ", wait_pay_time='" + wait_pay_time + '\'' +
                ", pay_confrim_time='" + pay_confrim_time + '\'' +
                ", work_time='" + work_time + '\'' +
                ", over_pay_time='" + over_pay_time + '\'' +
                ", over_pay_confrim_time='" + over_pay_confrim_time + '\'' +
                ", is_pay_all='" + is_pay_all + '\'' +
                ", buy_name='" + buy_name + '\'' +
                ", buy_tax_payer_no='" + buy_tax_payer_no + '\'' +
                ", buy_address='" + buy_address + '\'' +
                ", buy_phone='" + buy_phone + '\'' +
                ", buy_open_hang='" + buy_open_hang + '\'' +
                ", buy_account='" + buy_account + '\'' +
                ", client_receive_files='" + client_receive_files + '\'' +
                ", client_pay_files='" + client_pay_files + '\'' +
                ", first_is_pass='" + first_is_pass + '\'' +
                ", first_suggest='" + first_suggest + '\'' +
                ", last_is_pass='" + last_is_pass + '\'' +
                ", last_suggest='" + last_suggest + '\'' +
                ", last_pay_files='" + last_pay_files + '\'' +
                ", logList=" + logList +
                '}';
    }
}
