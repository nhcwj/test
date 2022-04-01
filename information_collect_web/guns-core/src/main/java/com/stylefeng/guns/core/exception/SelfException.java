package com.stylefeng.guns.core.exception;

/**
 * 自定义异常
 * @Auther: biu
 * @Date: 2019/1/24 15:48
 * @Description:
 */
public class SelfException extends RuntimeException {
    private Integer code;

    private String message;

    public SelfException(SelfExceptionEnum serviceExceptionEnum) {
        this.code = serviceExceptionEnum.getCode();
        this.message = serviceExceptionEnum.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SelfException(String message) {
        super(message);
    }
}
