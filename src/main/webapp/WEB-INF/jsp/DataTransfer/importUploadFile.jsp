<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>UPLOAD</title>
    <link rel="stylesheet" href="/static/theme/css/import.css">
    <link rel="stylesheet" href="/static/theme/css/jquery-ui.css">
    <script src="/static/js/jquery-1.11.1.min.js"></script>
    <script src="/static/js/jquery-ui.min.js"></script>
    <script src="/static/js/jquery.json-2.4.min.js"></script>
    <script>
        //        $(document).ready(function () {
        //            $("input[type='submit']").click(function(){
        //
        //            });
        //        });
    </script>
</head>
<body>
<h1>STEP 2</h1>

<form action="/dataTransfer/import2" method="post" enctype="multipart/form-data">
    <fieldset>
        <legend>Import Settings</legend>
        <input type="radio" name="dataMappingSettings" value="useIfExists" checked>use data mapping settings if exists
        <br/>
        <input type="radio" name="dataMappingSettings" value="reMapping">re-mapping data settings
        <br/>
        <hr/>
        FROM:<select name="importFrom">
        <option value="xls" selected>MS Excel</option>
        <option value="txt">Text file</option>
        <option value="csv">CSV file</option>
    </select>
        TO:<select name="importTo" id="importTo">
        <optgroup label="人员信息">
            <option value="com.haiso.hr.entity.person.Person">Basic Info</option>
            <option value="com.haiso.hr.entity.person.Education">Education Info</option>
            <option value="com.haiso.hr.entity.person.WorkExperience">Work Experience</option>
        </optgroup>
        <optgroup label="员工信息">
            <option value="com.haiso.hr.entity.employee.Employee">Employee</option>
            <option value="com.haiso.hr.entity.employee.Contract">Contract</option>
            <option value="com.haiso.hr.entity.employee.salary.Salary">Salary</option>
        </optgroup>
    </select>
    </fieldset>

    <fieldset>
        <legend>Upload File</legend>
        <span>${msg}</span><br/>
        <input type="file" name="file"/>
        <input type="submit" value="Upload"/>
    </fieldset>
</form>
</body>
</html>