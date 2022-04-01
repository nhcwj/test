package com.stylefeng.guns.modular.system.model.informationCollect;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("j_file_role")
public class FileRole {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("information_id")
    private Integer information_id;

    @TableField("file_id")
    private String file_id;

    @TableField("state")
    private String state;

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


    public String getFile_id() {
        return file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
