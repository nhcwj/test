package com.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: biu
 * @Date: 2019/5/10 15:53
 * @Description:
 */
@TableName("t_task")
public class Task extends Model<Task> {
    @Override
    protected Serializable pkVal() {
        return null;
    }
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //任务ID
    @TableField("task_id")
    private Integer taskId;

    //任务表名
    @TableField("task_name")
    private String taskName;

    //任务状态
    @TableField("task_status")
    private Integer taskStatus;

    //信息收集员ID
    @TableField("user_id")
    private Integer userId;

    //开始时间
    @TableField("start_time")
    private Date startTime;

    //完成时间
    @TableField("finished_time")
    private Date finishedTime;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(Date finishedTime) {
        this.finishedTime = finishedTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
