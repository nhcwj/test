package com.stylefeng.guns.modular.system.model.informationCollect;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("f_information_collect_weekly_report")
public class WeeklyReport {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("information_collect_id")
    private Integer information_collect_id;

    @TableField("report_info")
    private String report_info;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReport_info() {
        return report_info;
    }

    public void setReport_info(String report_info) {
        this.report_info = report_info;
    }

    public Integer getInformation_collect_id() {
        return information_collect_id;
    }

    public void setInformation_collect_id(Integer information_collect_id) {
        this.information_collect_id = information_collect_id;
    }
}
