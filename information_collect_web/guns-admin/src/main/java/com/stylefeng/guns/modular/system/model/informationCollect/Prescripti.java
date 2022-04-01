package com.stylefeng.guns.modular.system.model.informationCollect;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("j_prescripti")
public class Prescripti {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("information_id")
    private Integer information_id;

    @TableField("contract_sign_time")
    private String contract_sign_time;

    @TableField("plan_pay_time")
    private String plan_pay_time;

    @TableField("project_stage")
    private String project_stage;

    @TableField("stage_activity")
    private String stage_activity;

    @TableField("project_reality_time")
    private String project_reality_time;

    @TableField("contract_work_day")
    private String contract_work_day;

    @TableField("worked_day")
    private String worked_day;

    @TableField("time_level_compare")
    private String time_level_compare;

    @TableField("progress_write")
    private String progress_write;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInformation_id() {
        return information_id;
    }

    public void setInformation_id(Integer information_id) {
        this.information_id = information_id;
    }

    public String getContract_sign_time() {
        return contract_sign_time;
    }

    public void setContract_sign_time(String contract_sign_time) {
        this.contract_sign_time = contract_sign_time;
    }

    public String getPlan_pay_time() {
        return plan_pay_time;
    }

    public void setPlan_pay_time(String plan_pay_time) {
        this.plan_pay_time = plan_pay_time;
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

    public String getProject_reality_time() {
        return project_reality_time;
    }

    public void setProject_reality_time(String project_reality_time) {
        this.project_reality_time = project_reality_time;
    }

    public String getContract_work_day() {
        return contract_work_day;
    }

    public void setContract_work_day(String contract_work_day) {
        this.contract_work_day = contract_work_day;
    }

    public String getWorked_day() {
        return worked_day;
    }

    public void setWorked_day(String worked_day) {
        this.worked_day = worked_day;
    }

    public String getTime_level_compare() {
        return time_level_compare;
    }

    public void setTime_level_compare(String time_level_compare) {
        this.time_level_compare = time_level_compare;
    }

    public String getProgress_write() {
        return progress_write;
    }

    public void setProgress_write(String progress_write) {
        this.progress_write = progress_write;
    }

    @Override
    public String toString() {
        return "Prescripti{" +
                "id=" + id +
                ", information_id=" + information_id +
                ", contract_sign_time='" + contract_sign_time + '\'' +
                ", plan_pay_time='" + plan_pay_time + '\'' +
                ", project_stage='" + project_stage + '\'' +
                ", stage_activity='" + stage_activity + '\'' +
                ", project_reality_time='" + project_reality_time + '\'' +
                ", contract_work_day='" + contract_work_day + '\'' +
                ", worked_day='" + worked_day + '\'' +
                ", time_level_compare='" + time_level_compare + '\'' +
                ", progress_write='" + progress_write + '\'' +
                '}';
    }
}
