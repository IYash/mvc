<%
final String context = request.getContextPath();
final String source = context;

final String css = source + "/css";
final String myStyle = css +"/my.css";
final String scripts = source+"/jscript";


//js
final String jquery_js = scripts+"/jquery-1.8.1.min.js";
final String login_js = scripts+"/login.js";
final String ajax_js = scripts+"/ajax.js";
    final String datePicker_js=scripts+"/my97DatePicker/WdatePicker.js";

pageContext.setAttribute("source",source);
pageContext.setAttribute("context",context);
pageContext.setAttribute("jquery_js",jquery_js);
pageContext.setAttribute("login_js",login_js);
pageContext.setAttribute("ajax_js",ajax_js);
    pageContext.setAttribute("datePicker_js",datePicker_js);
    pageContext.setAttribute("myStyle",myStyle);
%>