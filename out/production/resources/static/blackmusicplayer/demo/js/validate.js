
function loginUser() {

    var flag_name = document.getElementById("userName").value;
    var flag_password = document.getElementById("password").value;

    //alert(flag_name);
    //alert(flag_pawword);
    var reg = /^1[34578][0-9]{9}/;
    var reg1 = /[a-zA-Z0-9]{1,10}@[a-zA-Z0-9]{1,5}\.[a-zA-Z0-9]{1,5}/;

    var reg2 = /^[A-Za-z0-9]{6,16}$/;
    if (!reg.test(flag_name) && !reg1.test(flag_name)) {
        alert("请正确填写手机号码和邮箱！");
        document.getElementById("userName").value="";
        return;
    }
    if (!reg2.test(flag_password)) {
        alert("密码必须由 6-16位字母、数字组成.");
        document.getElementById("password").value="";
        return;
    }
}


