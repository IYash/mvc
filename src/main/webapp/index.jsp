<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/views/config.jsp" %>
<html>
<head>
    <title>index</title>
    <link rel="stylesheet" href="${myStyle}"/>
    <script type="text/javascript" src="${jquery_js}"></script>
    <script type="text/javascript">
        $(function() {
            var j = [{
                id: 1,
                name: "a", //爷爷
                child: [{
                    id: "1-1",
                    name: "a-1", //爸爸
                    child: [{
                        id: "1-1-1",
                        name: "a-1-1"
                    }, //儿子
                        {
                            id: "1-1-2",
                            name: "a-1-2"
                        }
                    ]
                }, //儿子
                    {
                        id: "1-2",
                        name: "a-2"
                    }
                ]
            }, //叔叔
                {
                    id: 2,
                    name: "b"
                }, //二爷爷
                {
                    id: 3,
                    name: "c"
                }
            ]; //三爷爷
            digui(j);

            function digui(obj, fatherid) {
                var a = "gen"
                if (fatherid != null) a = fatherid;
                $.each(obj, function(index, childobj) {
                    $("#" + a).append('<ul id="' + childobj.id + '"><input type="checkbox" value=""					index="' + childobj.id + '">' + childobj.name + '</ul>');
//                    if (fatherid != null){
//                        if (index == 0){
//                            $("#" + a).append('<ul id="' + childobj.id + '"><input type="checkbox" style = "margin-left: 15px;" value="" index="' + childobj.id + '"><label style="width:150px;display: inline-block">' + childobj.name + '</label></ul>');
//                            fatherid = childobj.id;
//                        }else{
//                            $("#"+fatherid).append('<input type="checkbox" style = "margin-left: 15px;" value="" index="' + childobj.id + '"><label style="width:150px;display: inline-block">'+ childobj.name+'</label>');
//                        }
//                        if ((index+1)%3 == 0)
//                            $("#"+fatherid).append('<br/>');
//                    }else {
//                        $("#" + a).append('<ul id="' + childobj.id + '"><input type="checkbox" style = "margin-left: 15px;" value="" index="' + childobj.id + '"><label style="width:150px;display: inline-block">' + childobj.name + '</label></ul>');
//                    }修改嵌套逻辑
                    if (childobj.child != undefined) {
                        digui(childobj.child, childobj.id);
                    }
                });
            }
        });

        //判断关系确定checked
        $(function() {
            $(":checkbox").click(function() {
                //判断儿子
                var index = $(this).attr("index");
                //根据index开头的判断
                $(":checkbox[index^=" + index + "]").attr("checked", $(this).is(":checked"));
                //将index减少2判断父亲叔叔
                var index1 = index.substring(0, index.length - 2);
                $(":checkbox[index=" + index1 + "]").attr("checked", false);
                var check1 = false;
                $(":checkbox[index^=" + index1 + "]").each(function(i) {
                    if ($(this).is(":checked")) {
                        check1 = true;
                    }
                });
                $(":checkbox[index=" + index1 + "]").attr("checked", check1);
                //将index继续减少2判断爷爷
                var index2 = index.substring(0, index1.length - 2);
                var check2 = false;
                $(":checkbox[index=" + index2 + "]").attr("checked", check2);
                $(":checkbox[index^=" + index2 + "]").each(function(i) {
                    if ($(this).is(":checked")) {
                        check2 = true;
                    }
                });
                $(":checkbox[index=" + index2 + "]").attr("checked", check2);
            });
        });
    </script>
</head>
<body>
<h2>Hello World!---->From JSP111</h2>
    <div class="field_choose_con" id="all">
    <dl class="clearfix">
        <dt>订单信息：</dt>
        <dd id="allorderCreateDate1" class="active" data-value="orderCreateDate"><span><i
                class="mylvmama_icon checkbox_icon"></i>下单日期</span></dd>
        <dd id="allorderCreateDate2" class="active" data-value="orderCreateDate"><span><i
                class="mylvmama_icon checkbox_icon"></i>下单日期</span></dd>
        <dd id="allorderCreateDate3" class="active" data-value="orderCreateDate"><span><i
                class="mylvmama_icon checkbox_icon"></i>下单日期</span></dd>
    </dl>
    </div>

<ul id="gen">
</ul>

</body>
</html>
