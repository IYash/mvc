<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/5
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="config.jsp" %>
<html>
<head>
    <title>test</title>
    <script type="text/javascript" src="${jquery_js}"></script>
    <script type="text/javascript" src="${datePicker_js}"></script>
    <script type="text/javascript" src="${ajax_js}"></script>
    <script type="text/javascript">var dateTime="${dateTime}";</script>
</head>
<body>
    welcome ${username} to here!
    <br/>
    <input type="button" value="upd" id="upd"/>
    <input type="button" value="delist" id="delist"/><br/>
    创建时间：<input style="width:140px;" type="text" id="beginTime" name="beginTime" readonly="readonly" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',autoPickDate:true,startDate:'%y',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endTime\')||\'%y-%M-{%d}\'}'})" class="Wdate" />&nbsp;至&nbsp;<input type="text" id="endTime" name="endTime" readonly="readonly" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',autoPickDate:true,startDate:'%y',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-{%d}',minDate:'#F{$dp.$D(\'beginTime\')}'})" class="Wdate" style="width:140px"/>
    <br/>
    <form action="#">
        <input type="button" value="del" id="del"/>
    <input type="text" class="Wdate" runat="server" id="d4321" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'d4322\');}',autoPickDate:true})" <%--value="${dateTime}"--%>/>
    <input type="text" class="Wdate" id="d4322" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'d4321\');}',autoPickDate:true,/*maxDate:'%y-%M-{%d}'*/maxDate:'${dateTime}'})" value="${dateTime}"/>

    </form>
    <br/>

    <td width="45%" align="left">
        开始日期：
        <input name="txtBeginDate" type="text" id="txtBeginDate" readonly="readonly" size="12" maxlength="12" runat="server" />
        结束日期：
        <input name="txtEndDate" type="text" id="txtEndDate" readonly="readonly" size="12" maxlength="12" runat="server" />
    </td>

</body>
</html>
