@/*
    表单中input框标签中各个参数的说明:

    hidden : input hidden框的id
    id : input框id
    name : input框名称
    readonly : readonly属性
    clickFun : 点击事件的方法名
    style : 附加的css属性
@*/
<div>
        <label style="margin-bottom: 2px"  id="${id}" class="col-sm-offset-1 col-sm-11 control-label "><p class="text-left "><strong><span class="text-primary" style="font-size: 12px;
		color: #4C4B4B;
		font-family: 微软雅黑;
		padding: 0;margin: 0;text-align: right">${name}</span> : <span class="text-danger">${value}</span></strong></p></label>
</div>
@if(isNotEmpty(underline) && underline == 'true'){
    <div class="hr-line-dashed"></div>
@}


