
@/*
select标签中各个参数的说明:
name : select的名称
id : select的id
underline : 是否带分割线
@*/
<div class="form-group"
     @if(isNotEmpty(top)){
     style="display: flex;align-items: center;margin-top: 20px">
    @}else{
    style="display: flex;align-items: center;">
    @}

    <label class="col-sm-${labelWidth} control-label" style="font-size: 12px;
		color: #4C4B4B;
		font-family: 微软雅黑;
		padding: 0;margin: 0;text-align: right">
        @if(isNotEmpty(required)){
            <span style="color:red;font-size: 16px;vertical-align: sub;text-align: right">*</span><text>${name}</text>
        @}else{
            <text style="margin: 0;padding: 0">${name}</text>
        @}
    </label>
    <div class="col-sm-${inputWidth}" style="margin:0;">
        <select class="form-control" id="${id}" name="${id}">
            ${tagBody!}
        </select>
        @if(isNotEmpty(hidden)){
        <input class="form-control" type="hidden" id="${hidden}" value="${hiddenValue!}">
        @}
    </div>
</div>
@if(isNotEmpty(underline) && underline == 'true'){
<div class="hr-line-dashed"></div>
@}
