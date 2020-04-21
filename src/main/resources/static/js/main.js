(function(){
    console.log("Hello World!");

    var h1 = $("<h1></h1>").text("加入會員");
    var form1 = $("<form></form>").attr("action","/user-insert");
    form1.attr("method","post");
    $("body").append(h1,form1);

    var br = "</br>";
    var in_id = $("<input>").attr("name","id");
    var in_password = $("<input>").attr("name","password");
    var in_name = $("<input>").attr("name","name");
    var in_email = $("<input>").attr("name","email");
    var in_button = $("<button>").text("完成");
    form1.append("帳號",in_id,br,"密碼",in_password,br,
                 "暱稱",in_name,br,"信箱",in_email,br,in_button);

    var h2 = $("<h1></h1>").text("修改資料");
    var form2 = $("<form></form>").attr("action","/user-update");
    form2.attr("method","post");
    $("body").append(h2,form2);

    var upd_id = $("<input>").attr("name","id");
    var upd_password = $("<input>").attr("name","password");
    var upd_name = $("<input>").attr("name","name");
    var upd_email = $("<input>").attr("name","email");
    var upd_button = $("<button>").text("完成");
    form2.append("帳號",upd_id,br,"密碼",upd_password,br,
        "暱稱",upd_name,br,"信箱",upd_email,br,upd_button);

    var h3 = $("<h1></h1>").text("查詢會員");
    var form3 = $("<form></form>").attr("action","/user-find");
    form3.attr("method","get");
    $("body").append(h3,form3);

    var find_id = $("<input>").attr("name","id");
    var find_button = $("<button>").text("完成");
    form3.append("帳號",find_id,br,find_button);

    var h4 = $("<h1></h1>").text("刪除會員");
    var form4 = $("<form></form>").attr("action","/user-delete");
    form4.attr("method","get");
    $("body").append(h4,form4);

    var del_id = $("<input>").attr("name","id");
    var del_button = $("<button>").text("完成");

    form4.append("帳號",del_id,br,del_button);
})();