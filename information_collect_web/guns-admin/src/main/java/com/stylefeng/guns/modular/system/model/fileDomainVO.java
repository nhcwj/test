package com.stylefeng.guns.modular.system.model;

import java.util.Date;

public class fileDomainVO {
    //创建fileDomainVO实体类
    //复制好后,记得添加set,get方法
    private Integer id;
    private Date time;  //操作时间
    private String filename;  //原文件名
    private String fileNameAfter;  //转换后文件名
    private String filesize;   //原文件大小
    private String filetype;   //原文件类型
    private String filetypeafter;  //后文件类型
    private String details;     //操作详情
    private String outputfile;  //保存路径
    private String inputfile;   //原文件路径
    private Integer pageno;
    private Integer pages;
    private Integer rid;
    private Integer pageoperation;
    private Integer pagestart;
    private Integer pageend;
    private String fileSizeAfter;  //后  文件大小
    private Integer status;  //操作状态
    private Integer afterpages;
    private String detail;
    private String timeConsuming; //消耗时长

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileNameAfter() {
        return fileNameAfter;
    }

    public void setFileNameAfter(String fileNameAfter) {
        this.fileNameAfter = fileNameAfter;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public String getFiletypeafter() {
        return filetypeafter;
    }

    public void setFiletypeafter(String filetypeafter) {
        this.filetypeafter = filetypeafter;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getOutputfile() {
        return outputfile;
    }

    public void setOutputfile(String outputfile) {
        this.outputfile = outputfile;
    }

    public String getInputfile() {
        return inputfile;
    }

    public void setInputfile(String inputfile) {
        this.inputfile = inputfile;
    }

    public Integer getPageno() {
        return pageno;
    }

    public void setPageno(Integer pageno) {
        this.pageno = pageno;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getPageoperation() {
        return pageoperation;
    }

    public void setPageoperation(Integer pageoperation) {
        this.pageoperation = pageoperation;
    }

    public Integer getPagestart() {
        return pagestart;
    }

    public void setPagestart(Integer pagestart) {
        this.pagestart = pagestart;
    }

    public Integer getPageend() {
        return pageend;
    }

    public void setPageend(Integer pageend) {
        this.pageend = pageend;
    }

    public String getFileSizeAfter() {
        return fileSizeAfter;
    }

    public void setFileSizeAfter(String fileSizeAfter) {
        this.fileSizeAfter = fileSizeAfter;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAfterpages() {
        return afterpages;
    }

    public void setAfterpages(Integer afterpages) {
        this.afterpages = afterpages;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTimeConsuming() {
        return timeConsuming;
    }

    public void setTimeConsuming(String timeConsuming) {
        this.timeConsuming = timeConsuming;
    }
}
