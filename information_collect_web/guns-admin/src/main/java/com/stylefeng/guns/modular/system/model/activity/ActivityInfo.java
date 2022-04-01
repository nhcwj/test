package com.stylefeng.guns.modular.system.model.activity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

@TableName("t_party_activity")
public class ActivityInfo extends Model<ActivityInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("name")
    private Integer name;
    @TableField("title")
    private String title;
    @TableField("dept_id")
    private Integer dept_id;
    @TableField("place")
    private String place;
    @TableField("member_scope")
    private String member_scope;

    public String getMember_scope() {
        return member_scope;
    }

    public void setMember_scope(String member_scope) {
        this.member_scope = member_scope;
    }

    @TableField("content")
    private String content;
    @TableField("time")
    private Date time;
    @TableField("end_time")
    private Date endTime;

    public Date getEndTime() {
        return endTime;
    }

    public void setEnd_time(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEnd_time() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ActivityInfo{" +
                "id=" + id +
                ", name=" + name +
                ", title='" + title + '\'' +
                ", dept_id=" + dept_id +
                ", place='" + place + '\'' +
                ", member_scope=" + member_scope +
                ", content='" + content + '\'' +
                ", time=" + time +
                '}';
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
