@/*

@*/
<div class="form-group">
    <label class="col-sm-3 control-label">${name}</label>
    <div class="col-sm-9">
        <div class="input-group">
            <input type="text" class="form-control" id="${inputId}" readonly >
            <span class="input-group-btn">
                        <button id="${btnId}" class="btn btn-primary" type="button">${btnName}</button>
            </span>
        </div>
    </div>
</div>
@if(isNotEmpty(underline) && underline == 'true'){
<div class="hr-line-dashed"></div>
@}


