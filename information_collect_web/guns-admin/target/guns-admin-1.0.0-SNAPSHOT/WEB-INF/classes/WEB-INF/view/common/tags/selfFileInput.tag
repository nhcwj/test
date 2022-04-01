@/*
表单中fileInput框标签中各个参数的说明:

id : input框id
name : input框名称
clickFun : 点击事件的方法名
@*/
<div class="form-group " id="${divId}">
    <div class="col-sm-12">
        <input  type = "file" id="${id}" name="file"  multiple = "multiple"
                @if(isNotEmpty(clickFun)){
                onclick="${clickFun}"
                @}
                @if(isNotEmpty(disabled)){
                disabled="${disabled}"
                @}
                @if(isNotEmpty(value)){
                value="${value}"
                @}
        >
        @if(isNotEmpty(picRemind) &&picRemind=='true'){
        <span id = "picRemind" style="color:red;font-size:12px;" hidden = "hidden">*请上传图片！</span>
        @}
        @if(isNotEmpty(fileRemind) &&fileRemind=='true'){
        <span id = "fileRemind" style="color:red;font-size:12px;" hidden = "hidden">*请上传非图片类型文件！</span>
        @}
    </div>
</div>
@if(isNotEmpty(underline) && underline == 'true'){
<div class="hr-line-dashed"></div>
@}


