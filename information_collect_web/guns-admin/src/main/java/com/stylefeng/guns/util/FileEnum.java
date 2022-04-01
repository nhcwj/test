package com.stylefeng.guns.util;

/**读取文件contenttype类型，尚未跑出效果*/
public enum FileEnum {

    docx("application/msword"),

    doc("application/msword"),

    txt("text/plain"),

    xls("application/vnd.ms-excel"),

    pdf("application/pdf"),

    ppt("application/vnd.ms-powerpoint"),

    pptx("application/vnd.ms-powerpoint");

    private String type;

    FileEnum(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
