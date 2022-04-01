package com.stylefeng.guns.modular.system.model.payment;

public class PartyCountPay {

    private Integer id;
    private String partyname;
    private Double totalpay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartyname() {
        return partyname;
    }

    public void setPartyname(String partyname) {
        this.partyname = partyname;
    }

    public Double getTotalpay() {
        return totalpay;
    }

    public void setTotalpay(Double totalpay) {
        this.totalpay = totalpay;
    }
}
