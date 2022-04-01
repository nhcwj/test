package com.stylefeng.guns.constant.Enum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ICTRoleEnum {

    MIDDLEGROUND_MANAGER("中台管理员", Arrays.asList(new String[]{
            "商机单受理","初步订单审核","设计环节","方案审核","业务审核","订单确认","正式订单审核","待付首款/全款","首款/全款确认","施工人员指派","施工环节","已验收待尾款","尾款确认","订单结束"}),true),
    PRE_PEOPLE("前坎人员",Arrays.asList(new String[]{
        "初步订单审核","设计环节"}),true),
    WORK_PEOPLE("实施人员",Arrays.asList(new String[]{
        "初步订单审核","施工环节"}),true),
    FACTORY("厂家",Arrays.asList(new String[]{
        "初步订单审核"}),false),
    PROJECT_CHECK_PEOPLE("方案审批人员",Arrays.asList(new String[]{
            "设计环节"}),true);
    private String roleName;
    private List<String> order_status;
    private Boolean other;

    ICTRoleEnum(String name, List<String> order_status,Boolean other) {
        this.roleName = name;
        this.order_status = order_status;
        this.other = other;
    }

    public static List<ICTRoleEnum> getAll_Enum(){
        List<ICTRoleEnum> list=new ArrayList<>();
        list.add(ICTRoleEnum.MIDDLEGROUND_MANAGER);
        list.add(ICTRoleEnum.PRE_PEOPLE);
        list.add(ICTRoleEnum.WORK_PEOPLE);
        list.add(ICTRoleEnum.FACTORY);
        list.add(ICTRoleEnum.PROJECT_CHECK_PEOPLE);
        return list;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<String> getOrder_status() {
        return order_status;
    }

    public void setOrder_status(List<String> order_status) {
        this.order_status = order_status;
    }

    public Boolean getOther() {
        return other;
    }

    public void setOther(Boolean other) {
        this.other = other;
    }

    public static String getNext(String processName){
        String [] process =new String[]{
                "商机单受理","初步订单审核","设计环节","方案审核","业务审核","订单确认","正式订单审核","待付首款/全款","首款/全款确认","施工人员指派","施工环节","已验收待尾款","尾款确认","订单结束"};
        for(int i = 0; i< process.length ; i++){
            if(process[i].equals(processName)){
                return process[i-1];
            }
        }
        return "error";
    }
}
