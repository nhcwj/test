
function openWindow(title,width,height,path,offset) {
    let obj={
        type: 2,
        title: title,
        area: [width+"px", height+"px"], //宽高
        shadeClose:true,
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + path
    }
    if(typeof offset !=="undefined"){
        let scrollTop = window.parent.document.documentElement.scrollTop || window.parent.document.body.scrollTop;
        let clientHeight=getClientHeight();
        if(scrollTop===0){
            //外层传了组件offset.top值
            if(offset>=clientHeight){
                //未嵌套页面
                // 如果组件位置超过可视区域，则垂直水平居中。
                let clientHeight=Math.ceil((getClientHeight()-height)/2)
                scrollTop=scrollTop+clientHeight;
            }else{
                //外层没传组件offset.top值
                //嵌套页面，滚动条没有滚动
                //距离顶部50px
                 scrollTop=50;
            }
        }
        obj['offset']=scrollTop+"px";
    }
    let index=layer.open(obj);
    return index;

}
function rowStyle(row,index) {
    // if (row['status']==0){
    //     return {css:{'background-color':'#FFFFE0'}}
    // }
    if(row['status']==1){
        return {css:{'background-color':'#90EE90'}}
    }else{
        return {css:{'background-color':'#87CEFA'}}
    }
}

function getOpenWindow(title,width,height,openPath,query,postPath) {

    $.ajax({
        type: 'POST',
        url: postPath,//发送请求
        data: query,
        dataType:"html",
        success: function (result) {
            var index=layer.open({
                type: 2,
                title: title,
                area: [width+"px", height+"px"], //宽高
                shadeClose:true,
                fix: false, //不固定
                maxmin: true,
                content: Feng.ctxPath + openPath
            });
            return index;
        }
    })
}

function postOpenWindow(title,width,height,path,query) {
    $.ajax({
        type: 'POST',
        url: path,//发送请求
        data: query,
        dataType: "html",
        success: function (result) {
            var htmlCont = result;//返回的结果页面
            layer.open({
                type: 1,//弹出框类型
                title: title,
                shadeClose: true, //点击遮罩关闭层
                area: [width+"px", height+"px"], //宽高
                shift: 1,
                content: htmlCont,//将结果页面放入layer弹出层中
                success: function (layero, index) {

                }
            });
        }
    })
}
function getClientHeight()
{
    var clientHeight=0;
    if(document.body.clientHeight&&document.documentElement.clientHeight)
    {
        var clientHeight = (document.body.clientHeight<document.documentElement.clientHeight)?document.body.clientHeight:document.documentElement.clientHeight;
    }
    else
    {
        var clientHeight = (document.body.clientHeight>document.documentElement.clientHeight)?document.body.clientHeight:document.documentElement.clientHeight;
    }
    return clientHeight;
}
const { ['log']: c } = console;



