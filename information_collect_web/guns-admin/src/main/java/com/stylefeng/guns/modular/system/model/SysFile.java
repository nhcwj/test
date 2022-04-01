package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
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
 * @since 2018-06-28
 */
@TableName("t_sys_file")
public class SysFile extends Model<SysFile> {

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


    @TableField("blob_address")
    private Object blob_address;

    @TableField("partyfile_type")
    private Integer partyfileType;
    @TableField("party_stage")
    private Integer partyStage;

    @TableField("user_id")
    private String userId;

    public Integer getPartyfileType() {
        return partyfileType;
    }

    public void setPartyfileType(Integer partyfileType) {
        this.partyfileType = partyfileType;
    }

    public Integer getPartyStage() {
        return partyStage;
    }

    public void setPartyStage(Integer partyStage) {
        this.partyStage = partyStage;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Object getBlob_address() {
        return blob_address;
    }

    public void setBlob_address(Object blob_address) {
        this.blob_address = blob_address;
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
        return "SysFile{" +
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
                ", blog_address=" + blob_address +
                ", partyfileType=" + partyfileType +
                ", partyStage=" + partyStage +
                ", userId=" + userId +
                "}";
    }
}
