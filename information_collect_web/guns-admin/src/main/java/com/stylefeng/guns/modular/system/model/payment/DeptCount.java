package com.stylefeng.guns.modular.system.model.payment;

//每个党委/支部提交缴费的支部统计数量
public class DeptCount {

    private Integer id;
    private String partyname;


    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    public String getPartyname() {
        return partyname;
    }

    public void setPartyname(String partyname) {
        this.partyname = partyname;
    }
}
