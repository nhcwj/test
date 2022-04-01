package com.stylefeng.guns.modular.system.model.informationCollect;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

@TableName("j_ict_other_handle")
public class IctOther implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("ict_id")
    private String ict_id;

    @TableField("order_status")
    private String order_status;

    @TableField("content")
    private String content;

    @TableField("user_id")
    private String user_id;

    @TableField("status")
    private String status;

    @TableField("other")
    private String other;

    @TableField("handle_time")
    private String handle_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIct_id() {
        return ict_id;
    }

    public void setIct_id(String ict_id) {
        this.ict_id = ict_id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getHandle_time() {
        return handle_time;
    }

    public void setHandle_time(String handle_time) {
        this.handle_time = handle_time;
    }
}
