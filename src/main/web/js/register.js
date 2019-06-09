function a(){
    var form={};
    var phone = $("#phone").val();
    var password = $("#password").val();
    var name=$("#name").val();
    form["phone"]=phone;
    form["password"]=password;
    form["name"]=name;
    console.log(JSON.stringify(form));
    $.ajax({
        type:'POST',
        contentType: "application/json; charset=utf-8",
        dataType:'json',
        url:"/api/admin/register",
        success:function(data){
            if(data.success()){
                $.toast('注册成功！');}
            else{
                $.toast('注册失败！'+data.errMsg);
            }
        }
    });
}
