package com.stylefeng.guns.core.bean;

/**
 * Created by Administrator on 2017/7/14.
 */
public class FileParam {

    private Boolean thumb = true; //是否需要略缩图
    private String type = "image"; //文件类型，默认为图片
    private String size = "250";

    private Boolean createBlob=false; //是否需要创建二进制文件

    public Boolean getCreateBlob() {
        return createBlob;
    }

    public void setCreateBlob(Boolean createBlob) {
        this.createBlob = createBlob;
    }

    public Boolean getThumb() {
        return thumb;
    }

    public void setThumb(Boolean thumb) {
        this.thumb = thumb;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
