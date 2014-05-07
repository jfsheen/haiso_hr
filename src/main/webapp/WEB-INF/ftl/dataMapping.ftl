<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>hello.ftl</title>
    <link rel="stylesheet" href="/static/js/theme/css/jquery-ui.css">
    <script src="/static/js/jquery-1.11.1.min.js"></script>
    <script src="/static/js/jquery-ui.min.js"></script>
<#--<link rel="stylesheet" href="/resources/demos/style.css">-->
    <style>
        #sortable {
            list-style-type: none;
            margin: 0;
            padding: 0;
            width: 60%;
        }

        #sortable li {
            margin: 0 3px 3px 3px;
            padding: 0.4em;
            padding-left: 1.5em;
            font-size: 1.4em;
            height: 18px;
        }

        #sortable li span {
            position: absolute;
            margin-left: -1.3em;
        }
    </style>
    <script>
        $(document).ready(function () {
            $("#btn_back").click(function () {
                $("#mapping").hide();
            });
        });
        //        $(document).ready(function(){
        //            $("#btn_back").click(function(){
        ////                $(".map" + " input", document.forms[0]).each(function(){alert(this.name)});
        //                alert("back");
        //            });
    </script>
</head>
<body>
<button id="btn_back" style="width: 100px"/>
Back</button>
<form name="dataMapping" action="/dataTransfer/Step3" method="post">
    <table border="1" align="center" width="800px">
    <#list exceltitles as title>
        <#if (title_index+1)%5==1>
        <tr></#if>
        <td>${title}</td>
        <#if (title_index+1)%5==0></tr></#if>
    </#list>
    </table>
    <div id="mapping">
        <table border="1" align="center" width="800px">
        <#list classfields?keys as fk>
            <#if (fk_index+1)%3==1>
            <tr></#if>
            <td>${classfields[fk]}:${fk}</td>
            <td><input type="text" name="${fk}" maxlength="3" size="3"/></td>
            <#if (fk_index+1)%3==0></tr></#if>
        </#list>
        </table>
    </div>

    <input type="submit" name="submit" value="Next" style="width: 100px;"/>
</form>

</body>
</html>