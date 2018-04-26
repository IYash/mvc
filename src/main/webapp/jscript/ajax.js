$(function () {
   $("#del").click(function(){
       $.post("/page/delete.do",function (data) {
           var jsonData=eval(data);
           alert(jsonData.msg);
       },"json")
   });
    $("#upd").click(function () {
        $.post("/page/update.do",function (data) {
            var jsonData=eval(data);
            alert(jsonData.msg);
        },"json")
    });
    $("#delist").click(function () {
        var ids = [];
       $.map([37,38,39],function (item) {
          ids.push(item+1);
       });
        var ret="" ;
        $.ajax({
            url: "/mvc/page/delist_array.do",
            traditional: true,
            dataType: "json",
            type:"POST",
            async:false,
            data: {"ids": ids},
            success: function (data) {
                var jsonData = eval(data);
                ret = data.msg;
               //console.info(data.ret);
            }
        });

        console.info("hihihihi");
        console.info(ret);
    });
});