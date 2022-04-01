var Feng = {
    ctxPath: "",
    addCtx: function (ctx) {
        if (this.ctxPath == "") {
            this.ctxPath = ctx;
        }
    },
    confirm: function (tip, ensure) {//询问框
        parent.layer.confirm(tip, {
            btn: ['确定', '取消']
        }, function (index) {
            ensure();
            parent.layer.close(index);
        }, function (index) {
            parent.layer.close(index);
        });
    },
    confirmDel:function (tip,ensure) {
        layer.confirm(tip, {
            btn: ['确定', '取消']
        }, function (index) {
            ensure();
            layer.close(index);
        }, function (index) {
            layer.close(index);
        });
    },
    log: function (info) {
        console.log(info);
    },
    alert: function (info, iconIndex) {
        parent.layer.msg(info, {
            icon: iconIndex
        });
    },
    info: function (info) {
        Feng.alert(info, 0);
    },
    success: function (info) {
        Feng.alert(info, 1);
    },
    error: function (info) {
        Feng.alert(info, 2);
    },
    infoDetail: function (title, info) {
        var display = "";
        if (typeof info == "string") {
            display = info;
        } else {
            if (info instanceof Array) {
                for (var x in info) {
                    display = display + info[x] + "<br/>";
                }
            } else {
                display = info;
            }
        }
        parent.layer.open({
            title: title,
            type: 1,
            skin: 'layui-layer-rim', //加上边框
            area: ['950px', '600px'], //宽高
            content: '<div style="padding: 20px;">' + display + '</div>'
        });
    },
    writeObj: function (obj) {
        var description = "";
        for (var i in obj) {
            var property = obj[i];
            description += i + " = " + property + ",";
        }
        layer.alert(description, {
            skin: 'layui-layer-molv',
            closeBtn: 0
        });
    },
    showInputTree: function (inputId, inputTreeContentId, leftOffset, rightOffset) {
        var onBodyDown = function (event) {
            if (!(event.target.id == "menuBtn" || event.target.id == inputTreeContentId || $(event.target).parents("#" + inputTreeContentId).length > 0)) {
                $("#" + inputTreeContentId).fadeOut("fast");
                $("body").unbind("mousedown", onBodyDown);// mousedown当鼠标按下就可以触发，不用弹起
            }
        };

        if(leftOffset == undefined && rightOffset == undefined){
            var inputDiv = $("#" + inputId);
            var inputDivOffset = $("#" + inputId).offset();
            $("#" + inputTreeContentId).css({
                left: inputDivOffset.left + "px",
                top: inputDivOffset.top + inputDiv.outerHeight() + "px"
            }).slideDown("fast");
        }else{
            $("#" + inputTreeContentId).css({
                left: leftOffset + "px",
                top: rightOffset + "px"
            }).slideDown("fast");
        }

        $("body").bind("mousedown", onBodyDown);
    },
    baseAjax: function (url, tip) {
        var ajax = new $ax(Feng.ctxPath + url, function (data) {
            Feng.success(tip + "成功!");
        }, function (data) {
            Feng.error(tip + "失败!" + data.responseJSON.message + "!");
        });
        return ajax;
    },
    changeAjax: function (url) {
        return Feng.baseAjax(url, "修改");
    },
    zTreeCheckedNodes: function (zTreeId) {
        var zTree = $.fn.zTree.getZTreeObj(zTreeId);
        var nodes = zTree.getCheckedNodes();
        var ids = "";
        for (var i = 0, l = nodes.length; i < l; i++) {
            ids += "," + nodes[i].id;
        }
        return ids.substring(1);
    },
    eventParseObject: function (event) {//获取点击事件的源对象
        event = event ? event : window.event;
        var obj = event.srcElement ? event.srcElement : event.target;
        return $(obj);
    },
    sessionTimeoutRegistry: function () {
        $.ajaxSetup({
            contentType: "application/x-www-form-urlencoded;charset=utf-8",
            complete: function (XMLHttpRequest, textStatus) {
                //通过XMLHttpRequest取得响应头，sessionstatus，
                var sessionstatus = XMLHttpRequest.getResponseHeader("sessionstatus");
                if (sessionstatus == "timeout") {
                    //如果超时就处理 ，指定要跳转的页面
                    window.location = Feng.ctxPath + "/global/sessionError";
                }
            }
        });
    },
    initValidator: function(formId,fields){
        $('#' + formId).bootstrapValidator({
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: fields,
            live: 'enabled',
            message: '该字段不能为空'
        });
    },
    underLineToCamel: function (str) {
        var strArr = str.split('_');
        for (var i = 1; i < strArr.length; i++) {
            strArr[i] = strArr[i].charAt(0).toUpperCase() + strArr[i].substring(1);
        }
        var result = strArr.join('');
        return result.charAt(0).toUpperCase() + result.substring(1);
    },
    //接口列表
    apiList:{
        //自由房屋api
        SelfHomeApi:{
            get_self_home_list: "/self_home/SelfHomeList", //获取房屋列表api （查看）
            get_arrange_self_home_list: "/self_home/list", //获取房屋列表api （指派）
            edit_self_home: "/self_home/uploadFile", //录入房屋信息
            upload_self_home_excel_data: "/self_home/uploadExcelFile", //批量导入房屋数据
            get_self_home_area_info: "/self_home/getHomeAreaInfo",  //获取房屋三大面积数据 （自用，空闲，出租）
            get_self_home_cert_info: "/self_home/homeCertInfo",  //获取房屋产权证数据
            get_self_home_source_info: "/self_home/homeSourceInfo",  //获取房产来源数据
            get_five_region_info:"/self_home/getFiveRegionInfo", //获取五区饼图汇总数据
            get_home_stack_info:"/self_home/getHomeStackInfo" //获取五区三大面积堆叠数据
        },
        //土地信息api
        LandInfoApi:{
            get_land_info_list:"/land_info/landList", //获取土地信息列表 （查看）
            get_arrange_land_info_list:"/land_info/list", //获取土地信息列表 （指派）
            edit_land_info: "/land_info/uploadFile", //录入土地信息
            upload_excel_data: "/land_info/uploadExcelFile", //批量导入土地数据
            get_land_home_area_info: "/land_info/getHomeLandAreaInfo", //获取土地房屋总面积数据
            get_land_area_info: "/land_info/getLandAreaInfo", //获取土地三大面积数据,
            get_apply_land_info_list: "/land_info/applyList"
        }
    },
    zhenList:{
        "市属集团":[
            "乐从","陈村","北滘","容桂","大良","伦教","勒流","龙江","均安","杏坛",
            "桂城","平洲","大沥","黄岐","盐步","里水","和顺","罗村","官窑","松岗",
            "狮山","小塘","西樵","沙头","九江","丹灶","金沙","张槎","南庄","石湾",
            "祖庙","西南云东海","白坭","乐平","大塘","芦苞","荷城","杨和","明城","更合"
        ],
        "禅城分公司":[
            "张槎","南庄","石湾", "祖庙"
        ],
        "南海分公司":[
            "桂城","平洲","大沥","黄岐","盐步","里水","和顺","罗村","官窑","松岗",
            "狮山","小塘","西樵","沙头","九江","丹灶","金沙"
        ],
        "顺德分公司":[
            "乐从","陈村","北滘","容桂","大良","伦教","勒流","龙江","均安","杏坛"
        ],
        "三水分公司":[
            "西南云东海","白坭","乐平","大塘","芦苞"
        ],
        "高明分公司":[
            "荷城","杨和","明城","更合"
        ],
        "省级":[
            "乐从","陈村","北滘","容桂","大良","伦教","勒流","龙江","均安","杏坛",
            "桂城","平洲","大沥","黄岐","盐步","里水","和顺","罗村","官窑","松岗",
            "狮山","小塘","西樵","沙头","九江","丹灶","金沙","张槎","南庄","石湾",
            "祖庙","西南云东海","白坭","乐平","大塘","芦苞","荷城","杨和","明城","更合"
        ],
    },

    zhen_new_List:{
        "市属":[
            "乐从","陈村","北滘","容桂","大良","伦教","勒流","龙江","均安","杏坛",
            "桂城","平洲","大沥","黄岐","盐步","里水","和顺","罗村","官窑","松岗",
            "狮山","小塘","西樵","沙头","九江","丹灶","金沙","张槎","南庄","石湾",
            "祖庙","西南云东海","白坭","乐平","大塘","芦苞","荷城","杨和","明城","更合"
        ],
        "禅城":[
            "张槎","南庄","石湾", "祖庙"
        ],
        "南海":[
            "桂城","平洲","大沥","黄岐","盐步","里水","和顺","罗村","官窑","松岗",
            "狮山","小塘","西樵","沙头","九江","丹灶","金沙"
        ],
        "顺德":[
            "乐从","陈村","北滘","容桂","大良","伦教","勒流","龙江","均安","杏坛"
        ],
        "三水":[
            "西南云东海","白坭","乐平","大塘","芦苞"
        ],
        "高明":[
            "荷城","杨和","明城","更合"
        ],
    }

};
