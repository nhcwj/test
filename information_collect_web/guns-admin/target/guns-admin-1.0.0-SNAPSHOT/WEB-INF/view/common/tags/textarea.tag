@/*

@*/
<div class="form-group">
    <label class="col-sm-3 control-label">${name}</label>
    <div class="col-sm-9">
        <textarea class="form-control" id="${id}" name="${id}" rows="${row}"
                  @if(isNotEmpty(disabled)){
                  disabled="${disabled}"
                  @}
        >
                @if(isNotEmpty(value)){
                    ${tool.dateType(value)}
               @}

        </textarea>
    </div>
</div>
@if(isNotEmpty(underline) && underline == 'true'){
<div class="hr-line-dashed"></div>
@}


