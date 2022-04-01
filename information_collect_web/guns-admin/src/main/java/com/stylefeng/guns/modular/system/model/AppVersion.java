package com.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("app_version")
public class AppVersion {
    @TableId(value="id", type= IdType.AUTO)
    private Integer id;

    @TableField("version")
    private String version;

    @TableField("content")
    private String content;

    @TableField("apptype")
    private String apptype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }



    public String getApptype() {
        return apptype;
    }

    public void setApptype(String apptype) {
        this.apptype = apptype;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AppVersion{" +
                "id=" + id +
                ", version='" + version + '\'' +
                ", content='" + content + '\'' +
                ", apptype='" + apptype + '\'' +
                '}';
    }
}
