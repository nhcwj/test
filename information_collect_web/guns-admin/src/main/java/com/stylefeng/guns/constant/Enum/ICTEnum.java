package com.stylefeng.guns.constant.Enum;

public enum ICTEnum {

    NORMAL("正常",1),
    HANG_VERIFY("挂起审核",2),
    HANG("挂起",3),
    BACK_VERIFY("退单审核",4),
    CANCEL_VERIFY("退回上一步审核",5),
    CANCEL("作废",6);

    private String name;

    private Integer status;

    ICTEnum(String name, Integer status) {
        this.name = name;
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getStatusName(Integer status) {
        for (ICTEnum ict : ICTEnum.values()) {
            if (ict.getStatus() == status) {
                return ict.getName();
            }
        }
        return "";
    }
}
