package com.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.stylefeng.guns.core.constant.FieldAnno;

/**
 * @Auther: biu
 * @Date: 2019/10/21 17:07
 * @Description:
 */
@TableName("t_system_property")
public class SystemProperty {
    @TableId(value = "id", type = IdType.AUTO)
    @FieldAnno(desc = "主键")
    private Integer id;

    @TableField("system_property_name")
    @FieldAnno(desc = "系统变量名称")
    private String systemPropertyName;

    @TableField("system_property_value")
    @FieldAnno(desc = "系统变量值")
    private String systemPropertyValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSystemPropertyName() {
        return systemPropertyName;
    }

    public void setSystemPropertyName(String systemPropertyName) {
        this.systemPropertyName = systemPropertyName;
    }

    public String getSystemPropertyValue() {
        return systemPropertyValue;
    }

    public void setSystemPropertyValue(String systemPropertyValue) {
        this.systemPropertyValue = systemPropertyValue;
    }

    @Override
    public String toString() {
        return "SystemProperty{" +
                "id=" + id +
                ", systemPropertyName='" + systemPropertyName + '\'' +
                ", systemPropertyValue='" + systemPropertyValue + '\'' +
                '}';
    }
}
