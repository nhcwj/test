@/*
    表单中input框标签中各个参数的说明:

    hidden : input hidden框的id
    id : input框id
    name : input框名称
    readonly : readonly属性
    clickFun : 点击事件的方法名
    style : 附加的css属性
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
        <input class="form-control"  id="${id}" name="${id}"
               @if(isNotEmpty(style)){
               style="${style}"
               @}
               @if(isNotEmpty(value)){
                    value="${tool.dateType(value)}"
               @}
               @if(isNotEmpty(type)){
                    type="${type}"
               @}else{
                    type="text"
               @}
               @if(isNotEmpty(readonly)){
                    readonly="${readonly}"
               @}
               @if(isNotEmpty(clickFun)){
                    onclick="${clickFun}"
               @}
               @if(isNotEmpty(disabled)){
                    disabled="${disabled}"
               @}
               @if(isNotEmpty(placeholder)){
               placeholder="${placeholder}"
               @}

        >
        @if(isNotEmpty(hidden)){
            <input class="form-control" type="hidden" id="${hidden}" value="${hiddenValue!}">
        @}

        @if(isNotEmpty(selectFlag)){
            <div id="${selectId}" style="display: none; position: absolute; z-index: 200;">
                <ul id="${selectTreeId}" class="ztree tree-box" style="${selectStyle!}"></ul>
            </div>
        @}
    </div>
</div>
@if(isNotEmpty(underline) && underline == 'true'){
    <div class="hr-line-dashed"></div>
@}



