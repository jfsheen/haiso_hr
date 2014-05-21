<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>hello.ftl</title>
    <link rel="stylesheet" href="/static/theme/css/commons.css">
    <script src="/static/js/jquery-1.11.1.min.js"></script>
    <script src="/static/js/jquery.json-2.4.min.js"></script>
<#--<link rel="stylesheet" href="/resources/demos/style.css">-->
    <style>
    </style>
    <script>
        $(document).ready(function () {
            $("#btn_back").click(function () {
                var mapFrom = $("#mapFrom :input").serializeObject();
                var mapTo = $("#mapTo :input").serializeObject();
                var o = new Object();
                o.importTo = $("#importTo").text();
                o.mapFrom = mapFrom;
                o.mapTo = mapTo;
                var data = JSON.stringify(o);
                $.ajax({
                    type: "POST",
                    url: "/ajax/dataMapping",
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    anysc: false,
                    data: data,
                    success: function (ret) {}
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
<#--<div id="result">this is a test div</div>-->
<p>Import data to <span id="importTo">${importTo}</span></p>

<form id="dataMapping" action="/dataTransfer/import3" method="post">
    <input type="hidden" id="importTo" value="${importTo}">
    <div id="mapFrom">
        <table border="1" align="center" width="800px">
        <#if excelTitles?exists>
            <#list excelTitles?keys as tk>
                <#if (tk_index+1)%3==1>
                <tr></#if>
                <td>${tk}</td>
                <td><input type="text" name="${tk}" value="${excelTitles[tk]}" readonly></td>
                <#if (tk_index+1)%3==0></tr></#if>
            </#list>
        </#if>
        </table>
    </div>
    <div id="mapTo">
        <table border="1" align="center" width="800px">
        <#if classFields?exists>
            <#list classFields as cf>
                <#if (cf_index+1)%3==1>
                <tr></#if>
                <td>${cf}</td>
                <td><input type="text" name="${cf}" maxlength="3" size="3" onkeypress="isNum(event)"></td>
                <#if (cf_index+1)%3==0></tr></#if>
            </#list>
        </#if>
        </table>
    </div>
    <button id="btn_back">Go Next Step >></button>
</form>
<div id="r"></div>
</body>
</html>