<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>hello.ftl</title>
</head>
<body>

<form name="dataMapping" action="/dataTransfer/Step3" method="post">
    <ul>
    <#list classfields?keys as fk>
        <li>${classfields[fk]}:${fk}
            <select>
                <#list exceltitles?keys as tk>
                    <option value="${tk}">${exceltitles[tk]}</option>
                </#list>
            </select>
        </li>
    </#list>
    </ul>
    <input type="submit" name="Next"/>
</form>
</body>
</html>