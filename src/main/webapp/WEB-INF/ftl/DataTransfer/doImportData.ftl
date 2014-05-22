<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>IMPORT</title>
    <link rel="stylesheet" href="/static/theme/css/commons.css">
    <link rel="stylesheet" href="/static/theme/css/import.css">
    <script src="/static/js/jquery-1.11.1.min.js"></script>
    <script src="/static/js/jquery.json-2.4.min.js"></script>
<script>
    $.(document).ready(function(){
        $("#btn_import").click(funciton(event){
            event.preventDefault();
            var to = $("input:hidden").val();
            $.ajax({
                url: "/ajax/importing",
                type:post,
                data: to,
                anysc: false,
                dataType: "json",
                cache: false,
                contentType: false,
                processData: false,
                success:function(){},
                error:function(){}
            });
        });
    });
</script>
</head>
<body>
<h1>Importing </h1>
<#--<div>${mapping}</div>-->
<#if mapping?exists>
<ul>
    <#list mapping?keys as mk>
        <#if mapping[mk]!="">
            <li>${mk}<br/>${mapping[mk]}</li>
        </#if>
    </#list>
</ul>
</#if>
<div id="importMsg"></div>
<progress></progress>
<form action="/ajax/dataImporting" method="post">
    <input type="hidden" id="importTo" name="importTo" value="${importTo}">
</form>
<button id="btn_import">Confirm and Import</button>
</body>
</html>