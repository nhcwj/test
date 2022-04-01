
var Map = {
    id: "map",	//表格id,
    layerIndex:-1
};
var map=null;
var markers=[];
let infoBox=null;
let clickMarker=null;
let locationMarker=null;
let gc = new BMap.Geocoder();  //初始化，Geocoder类
let region='';
let zhen='';
let resource_cover_condition='';
let address='';
let inputVal='';
let searchPoint='';
let floorId=0;
function openFloor(id) {
    layerIndex=openWindow("商户具体信息",1200,600,"/qyw/FloorInfo/testSee");
}
$(function () {
    $("#FloorSlideUp").click(function () {
        //收起房屋信息窗口
        if($("#floorInfo").css('display')!='none'){
            $("#floorInfo").slideUp(500);
        }
    })
    map = new BMap.Map("container");
    map.setMinZoom(8);  //最小缩放级别
// 创建点坐标
    var opts = {offset: new BMap.Size(50, 50),anchor:BMAP_ANCHOR_BOTTOM_LEFT}  //offset: Size第一个参数表示距离右边的位置，，第二个表示距离上边的位置  anchor表示控件的停靠位置
    map.addControl(new BMap.NavigationControl());
    map.addControl(new BMap.MapTypeControl(opts));
    map.enableScrollWheelZoom(true); //支持拖放
    map.centerAndZoom(new BMap.Point(113.12826,23.027219),13);  //佛山市政府
    map.addEventListener("zoomend", function(){
    });
    getFloorList("","","","",resourceList);
    var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
        {"input" : "address"
            ,"location" : map,
            // 'types':''
        });
    ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
        var str = "";
        var _value = e.fromitem.value;
        c(e.toitem);
        var value = "";
        if (e.fromitem.index > -1) {
            value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
        }
        str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;

        value = "";
        if (e.toitem.index > -1) {
            _value = e.toitem.value;
            value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
        }
        str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
        G("searchResultPanel").innerHTML = str;
    });
    var myValue;
    ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
        var _value = e.item.value;
        myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
        G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
        setPlace(myValue);

    });

    //地图页面点击事件
    map.addEventListener( "click" , function(data){
        removeMarker();
        let suggest_point=new BMap.Point(data.point.lng,data.point.lat);
        let icon = new BMap.Icon('/static/img/point.png', new BMap.Size(32, 32), {
            anchor: new BMap.Size(10, 30)
        });
        let marker=new BMap.Marker(suggest_point,{icon:icon});
        clickMarker=marker;
        map.addOverlay(marker);    //添加标注
        gc.getLocation(suggest_point, function (rs) {   //getLocation函数用来解析地址信息，分别返回省市区街等
            var addComp = rs.addressComponents,
                province = addComp.province,//获取省份
                city = addComp.city,//获取城市
                district = addComp.district,//区
                street = addComp.street,//街
                streetNumber = addComp.streetNumber ? addComp.streetNumber + "号" : "";
                location_name = province + city + district + street + streetNumber;
                address=location_name;
                region=district;
                zhen=rs.business.split(",")[0];
        });
        marker.addEventListener("click", function (e) {
            let html='无楼宇'
            $("#floor_name").html(html)
            $("#addressName").html(address)
            $("#resource").html("无覆盖")
            $(".remark").css('display',"none")
            floorId=0;
            $("#floorInfo").slideDown(500);
             e.domEvent.stopPropagation();
        })
    });
});
function removeMarker() {
    if(clickMarker!==null){
        map.removeOverlay(clickMarker);
    }
    if(locationMarker!==null){
        map.removeOverlay(locationMarker);
    }
}
function setPlace(myValue){
    removeMarker();
    function myFun(){
        var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
        searchPoint=pp;
        var gc = new BMap.Geocoder();
        gc.getLocation(pp, function (rs) {
            let addComp = rs.addressComponents;
            $("#point_name").html('<div style="display: flex;align-items: center"><img class="marker"  src="/static/img/point.png" style="margin-right: 10px;cursor: pointer"></img>'+'<span style="font-weight: bolder;font-size: 14px">'+myValue+'</span></div>');
            let html='<div style="margin-left: 42px">'+addComp.province + addComp.city  + addComp.district + addComp.street + addComp.streetNumber+'</div>'
            $("#point_address").html(html);
            $(".marker").click(function () {
                map.centerAndZoom(searchPoint, 30);
            })
            $("#concreteInfo").css('display','');
            map.centerAndZoom(pp, 30);
            let icon = new BMap.Icon('/static/img/point.png', new BMap.Size(32, 32), {
                anchor: new BMap.Size(10, 30)
            });
            let marker=new BMap.Marker(pp,{icon:icon});
            map.addOverlay(marker);    //添加标注
            marker.addEventListener("click", function (e) {
                let html='无楼宇'
                $("#floor_name").html(html)
                $("#addressName").html(addComp.province + addComp.city  + addComp.district + addComp.street + addComp.streetNumber)
                $("#resource").html("无覆盖")
                $(".remark").css('display',"none")
                $("#floorInfo").slideDown(500);
                floorId=0;
                e.domEvent.stopPropagation();
            })
            locationMarker=marker;
        });



    }
    var local = new BMap.LocalSearch(map, { //智能搜索
        onSearchComplete: myFun
    });
    local.search(myValue);
}
function G(id) {
    return document.getElementById(id);
}
function query() {
    let region=$("#area").val();
    let zhen=$("#zhen").val();
    let road=$("#road").val();
    let floor=$("#floor").val();
    let resource=resourceList;
    getFloorList(region,zhen,road,floor,resource);
}
getFloorList=function (region,zhen,road,floor,resource_cover) {
    console.log(resource_cover);
    if(resource_cover!==null){
        resource_cover=resource_cover.join(",")
    }else{
        resource_cover=""
    }
    map.clearOverlays();    //清除地图上所有覆盖物
    $("#loadingModal").modal('show');
    $.ajax({
        type:'get',
        data:{region:region,zhen:zhen,road:road,floor:floor,resource_cover:resource_cover},
        url:Feng.ctxPath+"/qyw/FloorInfo/getFloorList",
        dataType:'json',
        success:function (data) {
            // console.log(data);
            createFloorMarker(data);
            setTimeout(function () {
                $("#loadingModal").modal('hide');
            },500)
        }
    })
}
$("#address").on("input propertychange",function () {
    inputVal=$(this).val();
    $("#concreteInfo").css('display','none');

})
$("#back").click(function () {
    if(inputVal!==''){
        $("#address").val(inputVal);
    }
    $("#concreteInfo").css('display','none');

})
createFloorMarker=function (data) {
    for (var i = 0; i < data.length; i++) {
        let point=data[i]
        var suggest_point=new BMap.Point(data[i].longtitude,data[i].latitude);
        let resource=data[i].resource_cover_condition;
        let icon = new BMap.Icon('/static/img/floor/'+resource+'.png', new BMap.Size(32, 32), {
            anchor: new BMap.Size(10, 30)
        });
        let marker=new BMap.Marker(suggest_point,{icon:icon});
        marker.floor=point;
        map.addOverlay(marker);    //添加标注
        marker.addEventListener("click", function (e) {
            let floor=this.floor;
            floorId=floor.id;
            let html='<a href="javascript:void(0)" style="color: #20BE84" onclick="openFloor()">'+floor.floor_name+'</a>'
            let floorAddress=floor.address;
            console.log(floorAddress);
            let quIndex=floorAddress.indexOf("区");
            if(quIndex==-1){
                let companyIndex=floorAddress.indexOf("分公司");
                region=floorAddress.substring(companyIndex-2,companyIndex+3);
            }else{
                region=floorAddress.substring(quIndex-2,quIndex+1);
            }
            let jiedao=floorAddress.indexOf("街道");
            let zhenIndex=floorAddress.indexOf("镇");
            if(jiedao===-1){
                zhen=floorAddress.substring(quIndex+1,zhenIndex);
            }else{
                zhen=floorAddress.substring(quIndex+1,jiedao);
            }
            resource_cover_condition=floor.resource_cover_condition;

            $("#floor_name").html(html)
            $("#addressName").html(floor.address)
            c(floor.resource_cover_condition);
            $("#resource").html(floor.resource_cover_condition)
            if(floor.resource_cover_condition.indexOf("厚覆盖")!=-1){
                $(".remark").css('display',"flex")
            }else{
                $(".remark").css('display',"none")
            }
            $("#floorInfo").slideDown(500);
            e.domEvent.stopPropagation();

        });
    }
}


