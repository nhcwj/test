package com.stylefeng.guns.core.constant;

public enum TableEnum {
    FLOOR_INFO("t_floor_info","com.stylefeng.guns.modular.system.model.FloorInfo","楼层信息",20),
    LAND_INFO("t_land_info","com.stylefeng.guns.modular.system.model.LandInfo","土地信息",60),
    SELF_HOME("t_self_home","com.stylefeng.guns.modular.system.model.SelfHome","自有房屋",66),
    BUILD_FIRE("t_building_firefighting_info","","",22),
    KEY_LOCATION("t_key_location_of_fire_safety","","",12),
    FLOOR_USE("t_floor_use","com.stylefeng.guns.modular.system.model.FloorUse","楼层用途",29),
    EQUIPMENT_INFO("t_firefighting_equipment_info","","",35),
    RENT_HOME("t_rent_home","com.stylefeng.guns.modular.system.model.RentHome","租入房屋",17),
    POST_OFFICE_HOME("t_post_office_home","com.stylefeng.guns.modular.system.model.PostOfficeHome","邮政房屋",19),
    RENT_INFO("t_rent_info","com.stylefeng.guns.modular.system.model.RentInfo","出租信息",12),
    ROOM_USE("t_room_use","com.stylefeng.guns.modular.system.model.RoomUse","房间用途",6);
    private String tableName;
    private String packageName;
    private String sheetName;
    private Integer len;

    private TableEnum(String areaName,String packageName,String sheetName , Integer key) {
        this.tableName = areaName;
        this.packageName=packageName;
        this.sheetName=sheetName;
        this.len = key;
    }
    public static TableEnum getEnumBysheetName(String sheetName){
        TableEnum e=null;
        for(TableEnum t:TableEnum.values()){
            if(t.getSheetName().equals(sheetName)){
                e=t;
                break;
            }
        }
        return e;
    }
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getLen() {
        return len;
    }

    public void setLen(Integer len) {
        this.len = len;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }
}
