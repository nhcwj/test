package com.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

@TableName("t_synchronization_sql")
public class SynchonizationSql extends Model<SynchonizationSql> {

    public static final String INSERT = "insert";
    public static final String UPDATE = "update";

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("type")
    private String type;
    @TableField("exec_sql")
    private String exec_sql;
    @TableField("add_time")
    private Date add_time;
    @TableField("remark")
    private String remark;
    @TableField("is_exec")
    private Integer is_exec;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExec_sql() {
        return exec_sql;
    }

    public void setExec_sql(String exec_sql) {
        this.exec_sql = exec_sql;
    }

    public Date getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Date add_time) {
        this.add_time = add_time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIs_exec() {
        return is_exec;
    }

    @Override
    public String toString() {
        return "SynchonizationSql{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", exec_sql='" + exec_sql + '\'' +
                ", add_time=" + add_time +
                ", remark='" + remark + '\'' +
                ", is_exec=" + is_exec +
                '}';
    }

    public void setIs_exec(Integer is_exec) {
        this.is_exec = is_exec;
    }


    @Override
    protected Serializable pkVal() {
        return null;
    }
}
