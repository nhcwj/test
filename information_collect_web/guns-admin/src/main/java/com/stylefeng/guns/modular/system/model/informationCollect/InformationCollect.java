package com.stylefeng.guns.modular.system.model.informationCollect;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("f_information_collect")
public class InformationCollect {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("project_name")
    private String project_name;

    @TableField("DICI_system_num")
    private String DICI_system_num;

    @TableField("dept")
    private String dept;

    @TableField("pay_manager")
    private String pay_manager;

    @TableField("pay_assistant")
    private String pay_assistant;

    @TableField("contract_num")
    private String contract_num;

    @TableField("project_money")
    private String project_money;

    @TableField("project_stage")
    private String project_stage;

    @TableField("stage_activity")
    private String stage_activity;

    @TableField("time_progress_situation")
    private String time_progress_situation;

    @TableField("project_manager_name")
    private String project_manager_name;

    @TableField("part_leader")
    private String part_leader;

    @TableField("project_manager_phone")
    private String project_manager_phone;

    @TableField("net_ICT_hold_specialist")
    private String net_ICT_hold_specialist;

    @TableField("is_deep_integration")
    private String is_deep_integration;

    @TableField("hurry_level")
    private String hurry_level;

    @TableField("profession")
    private String profession;

    @TableField("is_select")
    private String is_select;

    @TableField("integration_name")
    private String integration_name;

    @TableField("money_mode")
    private String money_mode;

    @TableField("manage_unit")
    private String manage_unit;

    @TableField("pay_mode")
    private String pay_mode;

    @TableField("current_process")
    private String current_process;

    @TableField("apply_user")
    private String apply_user;

    @TableField("is_important")
    private String is_important;

    @TableField("pass_user")
    private String pass_user;

    @TableField("choose_dept")
    private String choose_dept;

    @TableField("back_idea")
    private String back_idea;

    @TableField("verify_idea")
    private String verify_idea;

    @TableField("verify_time")
    private String verify_time;

    @TableField("back_time")
    private String back_time;

    @TableField("apply_time")
    private String apply_time;

    @TableField("pass_process")
    private String pass_process;

    @TableField("verify_user")
    private String verify_user;

    @TableField("apply_verify_idea")
    private String apply_verify_idea;

    @TableField("other_file")
    private String other_file;


    @TableField("project_start_plan_finish_time")
    private String project_start_plan_finish_time;

    @TableField("project_program_plan_finish_time")
    private String project_program_plan_finish_time;

    @TableField("project_implement_plan_finish_time")
    private String project_implement_plan_finish_time;

    @TableField("initial_plan_finish_time")
    private String initial_plan_finish_time;

    @TableField("run_plan_finish_time")
    private String run_plan_finish_time;

    @TableField("end_plan_finish_time")
    private String end_plan_finish_time;

    @TableField("archive_plan_finish_time")
    private String archive_plan_finish_time;

    @TableField("modify_user_id")
    private Integer modify_user_id;

    @TableField("modify_idea")
    private String modify_idea;

    public String getModify_idea() {
        return modify_idea;
    }

    public void setModify_idea(String modify_idea) {
        this.modify_idea = modify_idea;
    }

    public Integer getModify_user_id() {
        return modify_user_id;
    }

    public void setModify_user_id(Integer modify_user_id) {
        this.modify_user_id = modify_user_id;
    }

    public String getProject_start_plan_finish_time() {
        return project_start_plan_finish_time;
    }

    public void setProject_start_plan_finish_time(String project_start_plan_finish_time) {
        this.project_start_plan_finish_time = project_start_plan_finish_time;
    }

    public String getProject_program_plan_finish_time() {
        return project_program_plan_finish_time;
    }

    public void setProject_program_plan_finish_time(String project_program_plan_finish_time) {
        this.project_program_plan_finish_time = project_program_plan_finish_time;
    }

    public String getProject_implement_plan_finish_time() {
        return project_implement_plan_finish_time;
    }

    public void setProject_implement_plan_finish_time(String project_implement_plan_finish_time) {
        this.project_implement_plan_finish_time = project_implement_plan_finish_time;
    }

    public String getInitial_plan_finish_time() {
        return initial_plan_finish_time;
    }

    public void setInitial_plan_finish_time(String initial_plan_finish_time) {
        this.initial_plan_finish_time = initial_plan_finish_time;
    }

    public String getRun_plan_finish_time() {
        return run_plan_finish_time;
    }

    public void setRun_plan_finish_time(String run_plan_finish_time) {
        this.run_plan_finish_time = run_plan_finish_time;
    }

    public String getEnd_plan_finish_time() {
        return end_plan_finish_time;
    }

    public void setEnd_plan_finish_time(String end_plan_finish_time) {
        this.end_plan_finish_time = end_plan_finish_time;
    }

    public String getArchive_plan_finish_time() {
        return archive_plan_finish_time;
    }

    public void setArchive_plan_finish_time(String archive_plan_finish_time) {
        this.archive_plan_finish_time = archive_plan_finish_time;
    }

    public String getOther_file() {
        return other_file;
    }

    public void setOther_file(String other_file) {
        this.other_file = other_file;
    }

    public String getApply_verify_idea() {
        return apply_verify_idea;
    }

    public void setApply_verify_idea(String apply_verify_idea) {
        this.apply_verify_idea = apply_verify_idea;
    }

    public String getVerify_user() {
        return verify_user;
    }

    public void setVerify_user(String verify_user) {
        this.verify_user = verify_user;
    }

    public String getPass_process() {
        return pass_process;
    }

    public void setPass_process(String pass_process) {
        this.pass_process = pass_process;
    }

    public String getVerify_time() {
        return verify_time;
    }

    public void setVerify_time(String verify_time) {
        this.verify_time = verify_time;
    }

    public String getBack_time() {
        return back_time;
    }

    public void setBack_time(String back_time) {
        this.back_time = back_time;
    }

    public String getApply_time() {
        return apply_time;
    }

    public void setApply_time(String apply_time) {
        this.apply_time = apply_time;
    }

    public String getVerify_idea() {
        return verify_idea;
    }

    public void setVerify_idea(String verify_idea) {
        this.verify_idea = verify_idea;
    }

    public String getBack_idea() {
        return back_idea;
    }

    public void setBack_idea(String back_idea) {
        this.back_idea = back_idea;
    }

    public String getChoose_dept() {
        return choose_dept;
    }

    public void setChoose_dept(String choose_dept) {
        this.choose_dept = choose_dept;
    }

    public String getPass_user() {
        return pass_user;
    }

    public void setPass_user(String pass_user) {
        this.pass_user = pass_user;
    }

    public String getIs_important() {
        return is_important;
    }

    public void setIs_important(String is_important) {
        this.is_important = is_important;
    }

    public String getPay_mode() {
        return pay_mode;
    }

    public void setPay_mode(String pay_mode) {
        this.pay_mode = pay_mode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getDICI_system_num() {
        return DICI_system_num;
    }

    public void setDICI_system_num(String DICI_system_num) {
        this.DICI_system_num = DICI_system_num;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPay_manager() {
        return pay_manager;
    }

    public void setPay_manager(String pay_manager) {
        this.pay_manager = pay_manager;
    }

    public String getPay_assistant() {
        return pay_assistant;
    }

    public void setPay_assistant(String pay_assistant) {
        this.pay_assistant = pay_assistant;
    }

    public String getContract_num() {
        return contract_num;
    }

    public void setContract_num(String contract_num) {
        this.contract_num = contract_num;
    }

    public String getProject_money() {
        return project_money;
    }

    public void setProject_money(String project_money) {
        this.project_money = project_money;
    }

    public String getProject_stage() {
        return project_stage;
    }

    public void setProject_stage(String project_stage) {
        this.project_stage = project_stage;
    }

    public String getStage_activity() {
        return stage_activity;
    }

    public void setStage_activity(String stage_activity) {
        this.stage_activity = stage_activity;
    }

    public String getTime_progress_situation() {
        return time_progress_situation;
    }

    public void setTime_progress_situation(String time_progress_situation) {
        this.time_progress_situation = time_progress_situation;
    }

    public String getProject_manager_name() {
        return project_manager_name;
    }

    public void setProject_manager_name(String project_manager_name) {
        this.project_manager_name = project_manager_name;
    }

    public String getPart_leader() {
        return part_leader;
    }

    public void setPart_leader(String part_leader) {
        this.part_leader = part_leader;
    }

    public String getProject_manager_phone() {
        return project_manager_phone;
    }

    public void setProject_manager_phone(String project_manager_phone) {
        this.project_manager_phone = project_manager_phone;
    }

    public String getNet_ICT_hold_specialist() {
        return net_ICT_hold_specialist;
    }

    public void setNet_ICT_hold_specialist(String net_ICT_hold_specialist) {
        this.net_ICT_hold_specialist = net_ICT_hold_specialist;
    }

    public String getIs_deep_integration() {
        return is_deep_integration;
    }

    public void setIs_deep_integration(String is_deep_integration) {
        this.is_deep_integration = is_deep_integration;
    }

    public String getHurry_level() {
        return hurry_level;
    }

    public void setHurry_level(String hurry_level) {
        this.hurry_level = hurry_level;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getIs_select() {
        return is_select;
    }

    public void setIs_select(String is_select) {
        this.is_select = is_select;
    }

    public String getIntegration_name() {
        return integration_name;
    }

    public void setIntegration_name(String integration_name) {
        this.integration_name = integration_name;
    }

    public String getMoney_mode() {
        return money_mode;
    }

    public void setMoney_mode(String money_mode) {
        this.money_mode = money_mode;
    }

    public String getManage_unit() {
        return manage_unit;
    }

    public void setManage_unit(String manage_unit) {
        this.manage_unit = manage_unit;
    }


    public String getCurrent_process() {
        return current_process;
    }

    public void setCurrent_process(String current_process) {
        this.current_process = current_process;
    }

    public String getApply_user() {
        return apply_user;
    }

    public void setApply_user(String apply_user) {
        this.apply_user = apply_user;
    }
}
