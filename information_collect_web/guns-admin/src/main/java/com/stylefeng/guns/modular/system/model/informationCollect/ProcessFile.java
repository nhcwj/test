package com.stylefeng.guns.modular.system.model.informationCollect;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("j_process_file")
public class ProcessFile {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("information_id")
    private Integer information_id;

    @TableField("file_list_id")
    private Integer file_list_id;

    @TableField("file")
    private String file;

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

    public Integer getFile_list_id() {
        return file_list_id;
    }

    public void setFile_list_id(Integer file_list_id) {
        this.file_list_id = file_list_id;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
