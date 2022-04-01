package com.stylefeng.guns.modular.system.model.informationCollect;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("j_order_log")
public class InformationCollectOrderLog {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("user_name")
    private String user_name;

    @TableField("user_dept")
    private String user_dept;
    @TableField("user_phone")
    private String user_phone;
    @TableField("user_id")
    private Integer user_id;
    @TableField("content")
    private String content;
    @TableField("operate")
    private String operate;
    @TableField("order_id")
    private Integer order_id;

    @TableField("time")
    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_dept() {
        return user_dept;
    }

    public void setUser_dept(String user_dept) {
        this.user_dept = user_dept;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }


    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "InformationCollectOrderLog{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", user_dept='" + user_dept + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_id='" + user_id + '\'' +
                ", content='" + content + '\'' +
                ", operate='" + operate + '\'' +
                ", order_id='" + order_id + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
