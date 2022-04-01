package com.stylefeng.guns.modular.system.model.informationCollect;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("j_file_list")
public class FileList {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("project_state")
    private String project_state;

    @TableField("file_name")
    private String file_name;

    @TableField("add_time")
    private String add_time;

    @TableField("status")
    private String status;

    @TableField("is_need")
    private String is_need;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProject_state() {
        return project_state;
    }

    public void setProject_state(String project_state) {
        this.project_state = project_state;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIs_need() {
        return is_need;
    }

    public void setIs_need(String is_need) {
        this.is_need = is_need;
    }

    @Override
    public String toString() {
        return "FileList{" +
                "id=" + id +
                ", project_state='" + project_state + '\'' +
                ", file_name='" + file_name + '\'' +
                ", add_time='" + add_time + '\'' +
                ", status='" + status + '\'' +
                ", is_need='" + is_need + '\'' +
                '}';
    }
}
