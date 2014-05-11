<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>hello.ftl</title>
    <link rel="stylesheet" href="/static/theme/css/jquery-ui.css">
    <script src="/static/js/jquery-1.11.1.min.js"></script>
    <script src="/static/js/jquery-ui.min.js"></script>
    <script src="/static/js/jquery.json-2.4.min.js"></script>
<#--<link rel="stylesheet" href="/resources/demos/style.css">-->
    <style>
    </style>
    <script>
        $(document).ready(function () {
            $("#btn_back").click(function () {
                var data = JSON.stringify($("form").serializeObject());
                $("#result").html(data);
                $.ajax({
                    type: "POST",
                    contentType: "application/json; charset=utf-8",
                    url: "/ajax/dataMapping",
                    dataType: "json",
                    anysc: false,
                    data: data,
                    success: function (s) {
                        $("#r").html(s);
                    }
                });
            });
        });
        $.fn.serializeObject = function () {
            var o = {};
            var a = this.serializeArray();
            $.each(a, function () {
                if (o[this.name] !== undefined) {
                    if (!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            });
            return o;
        };
        function isNum(e) {
            var k = window.event ? e.keyCode : e.which;
            if (!(((k >= 48) && (k <= 57)) || k == 8 || k == 0)) {
                if (window.event) {
                    window.event.returnValue = false;
                }
                else {
                    e.preventDefault();//for firefox
                }
            }
        }
    </script>
</head>
<body>
<button id="btn_back" style="width: 100px"/>
Back</button>
<div id="r"></div>
<div id="result">this is a test div</div>
<table border="1" align="center" width="800px">
<#list exceltitles as title>
    <#if (title_index+1)%5==1>
    <tr></#if>
    <td>${title}</td>
    <#if (title_index+1)%5==0></tr></#if>
</#list>
</table>
<form id="dataMapping" action="/dataTransfer/Step3" method="post">
    <div id="mapping">
        <table border="1" align="center" width="800px">
        <#list classfields?keys as fk>
            <#if (fk_index+1)%3==1>
            <tr></#if>
            <td>${classfields[fk]}:${fk}</td>
            <td><input type="text" name="${fk}" maxlength="3" size="3" onkeypress="isNum(event)"></td>
            <#if (fk_index+1)%3==0></tr></#if>
        </#list>
        </table>
    </div>
    <input type="submit" name="submit" value="Next" style="width: 100px;"/>
</form>

</body>
</html>