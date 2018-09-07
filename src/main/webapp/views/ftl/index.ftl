<html>
<body>
<h2>Hello World!----->From FTL</h2>
<input type="text" name="clock" id="clock" value="" style="width: 500px;"/>
<button id="stop" onclick="timer=window.clearInterval(timer)">停止时间函数</button>
<script type="text/javascript">
    function clock(){
        var t = new Date();
        document.getElementById('clock').value = t;
    }
    var timer = setInterval(clock, 50);
    var stop = document.getElementById('stop');
    stop.onclick = function(){
        clearInterval(timer);
    }
    function show(){
        console.log("每隔一秒我就会显示一次");
    }
    var sh;
    sh=setInterval(show,1000);

    clearInterval(sh);
</script>
</body>
</html>
