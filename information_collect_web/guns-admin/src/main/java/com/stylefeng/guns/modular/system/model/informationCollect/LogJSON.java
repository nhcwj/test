package com.stylefeng.guns.modular.system.model.informationCollect;

/**
 * 仅用于数据接口ict_order集合log输出
 */
public class LogJSON {

    private String name;

    private String process;

    private String content;

    private String operate_time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOperate_time() {
        return operate_time;
    }

    public void setOperate_time(String operate_time) {
        this.operate_time = operate_time;
    }


    @Override
    public String toString() {
        return "LogJSON{" +
                "name='" + name + '\'' +
                ", process='" + process + '\'' +
                ", content='" + content + '\'' +
                ", operate_time='" + operate_time + '\'' +
                '}';
    }
}
