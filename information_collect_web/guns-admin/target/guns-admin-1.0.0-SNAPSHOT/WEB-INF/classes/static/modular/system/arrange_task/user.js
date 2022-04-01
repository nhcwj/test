/**
 * 系统管理--用户管理的单例对象
 */
var MgrUser = {
    id: "SysUserTable",//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1,
    deptid:0
};

/**
 * 初始化表格的列
 */
MgrUser.initColumn = function () {
    var columns = [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '账号', field: 'account', align: 'center', valign: 'middle', sortable: true},
        {title: '姓名', field: 'name', align: 'center', valign: 'middle', sortable: true},
        {title: '性别', field: 'sexName', align: 'center', valign: 'middle', sortable: true},
        {title: '角色', field: 'roleName', align: 'center', valign: 'middle', sortable: true},
        {title: '部门', field: 'deptName', align: 'center', valign: 'middle', sortable: true},
        {title: '邮箱', field: 'email', align: 'center', valign: 'middle', sortable: true},
        {title: '电话', field: 'phone', align: 'center', valign: 'middle', sortable: true},
        {title: '创建时间', field: 'createtime', align: 'center', valign: 'middle', sortable: true},
        {title: '状态', field: 'statusName', align: 'center', valign: 'middle', sortable: true}];
    return columns;
};

/**
 * 检查是否选中
 */
MgrUser.arrange = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先指定一个信息收集员！");
        return false;
    } else {
        var userId=selected[0].id;
        var taskInfo=window.parent.taskInfo;
        var tableName=window.parent.tableName;
        $.ajax({
            url:Feng.ctxPath+"/arrange_task/addTask",
            data:{taskInfo:taskInfo,tableName:tableName,userId:userId},
            type:"post",
            dataType:"json",
            success:function (data) {
                if(data.code==200){
                    Feng.success("指派成功");
                    window.parent.layer.close(window.parent.layerIndex);
                }else{
                    Feng.error(data.message);
                    window.parent.layer.close(window.parent.layerIndex);
                }
            }
        })


    }
};

MgrUser.resetSearch = function () {
    $("#name").val("");
    $("#beginTime").val("");
    $("#endTime").val("");

    MgrUser.search();
}

MgrUser.search = function () {
    var queryData = {};
    queryData['deptid'] = MgrUser.deptid;
    MgrUser.table.refresh({query: queryData});
}

MgrUser.onClickDept = function (e, treeId, treeNode) {
    MgrUser.deptid = treeNode.id;
    MgrUser.search();
};

$(function () {
    var defaultColunms = MgrUser.initColumn();
    var table = new BSTable("SysUserTable", "/arrange_task/list?roleid=3", defaultColunms);
    table.setPaginationType("client");
    MgrUser.table = table.init();
    var ztree = new $ZTree("deptTree", "/partyDept/tree");
    ztree.bindOnClick(MgrUser.onClickDept);
    ztree.init();
});
