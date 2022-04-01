package com.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhirongrui123
 * @since 2018-06-28
 */
@TableName("t_guns_file")
public class GunsFile extends Model<GunsFile> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 文件id，唯一标识
     */
    @TableField("file_id")
    private String fileId;
    /**
     * 文件名称
     */
    private String filename;
    /**
     * 文件保存路径
     */
    @TableField("file_path")
    private String filePath;
    @TableField("mime_type")
    private String mimeType;
    /**
     * 略缩图地址，文件则省略该字段、视频则为图片地址
     */
    @TableField("thumb_path")
    private String thumbPath;
    /**
     * 文件大小
     */
    private Long size;
    /**
     * 添加时间
     */
    @TableField("add_time")
    private Date addTime;
    /**
     * 文件md5值
     */
    private String md5;



    private String type;


    @TableField("node")
    private String node;

    @TableField("upload_people")
    private String upload_people;

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getUpload_people() {
        return upload_people;
    }

    public void setUpload_people(String upload_people) {
        this.upload_people = upload_people;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getThumbPath() {
        return thumbPath;
    }

    public void setThumbPath(String thumbPath) {
        this.thumbPath = thumbPath;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "GunFile{" +
                "id=" + id +
                ", fileId='" + fileId + '\'' +
                ", filename='" + filename + '\'' +
                ", filePath='" + filePath + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", thumbPath='" + thumbPath + '\'' +
                ", size=" + size +
                ", addTime=" + addTime +
                ", md5='" + md5 + '\'' +
                ", type='" + type + '\'' +

                '}';
    }
}
