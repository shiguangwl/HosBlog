function AjaxRquest(url,method,data) {
    $.ajax({
        url:url,
        type:method,
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data:JSON.stringify(data),

        success:function(res){
            resdata = res;
        }
    });
}
