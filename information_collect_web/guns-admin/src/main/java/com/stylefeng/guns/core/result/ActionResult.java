package com.stylefeng.guns.core.result;

/**
 * @author MK_H
 * @date 2021/2/23
 */
public class ActionResult {
    private boolean ok = true;
    private String msg;
    private Object data;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
