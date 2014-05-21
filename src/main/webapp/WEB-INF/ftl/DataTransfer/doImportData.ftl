<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>IMPORT</title>
    <link rel="stylesheet" href="/static/theme/css/commons.css">
    <link rel="stylesheet" href="/static/theme/css/import.css">
    <script src="/static/js/jquery-1.11.1.min.js"></script>
    <script src="/static/js/jquery.json-2.4.min.js"></script>
</head>
<body>
<h1>Importing </h1>
<#--<div>${mapping}</div>-->
<#if mapping?exists>
<ul>
    <#list mapping?keys as mk>
        <#if mapping[mk].title?exists>
            <li>${mk}:${mapping[mk].title}</li>
        </#if>
    <#--<td><input contentType="text" name="${tk}" value="${excelTitles[tk]}" readonly></td>-->
    </#list>
</ul>
</#if>
<progress></progress>
</body>
</html>