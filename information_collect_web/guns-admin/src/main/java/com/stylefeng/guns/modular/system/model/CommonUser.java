package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhirongrui123
 * @since 2018-08-01
 */
@TableName("t_user")
public class CommonUser extends Model<CommonUser> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户ID
     */
    private String userid;
    /**
     * 姓名
     */
    private String name;
    /**
     * 职位
     */
    private String position;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 性别，1男，2女，0未知
     */
    private Integer gender;
    /**
     * 邮箱地址
     */
    private String email;
    /**
     * 微信账号ID
     */
    private String weixinid;
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * 用户状态,1已关注，2已冻结，4未关注
     */
    private Integer status;
    /**
     * 所属部门
     */
    private String department;
    /**
     * 部门ID
     */
    private Integer deptid;
    @TableField("sport_push")
    private Integer sportPush;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeixinid() {
        return weixinid;
    }

    public void setWeixinid(String weixinid) {
        this.weixinid = weixinid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getSportPush() {
        return sportPush;
    }

    public void setSportPush(Integer sportPush) {
        this.sportPush = sportPush;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "CommonUser{" +
        "id=" + id +
        ", userid=" + userid +
        ", name=" + name +
        ", position=" + position +
        ", mobile=" + mobile +
        ", gender=" + gender +
        ", email=" + email +
        ", weixinid=" + weixinid +
        ", avatar=" + avatar +
        ", status=" + status +
        ", department=" + department +
        ", deptid=" + deptid +
        ", sportPush=" + sportPush +
        "}";
    }
}
