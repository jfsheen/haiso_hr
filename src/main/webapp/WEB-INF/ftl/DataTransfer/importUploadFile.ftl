<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>UPLOAD</title>
    <link rel="stylesheet" href="/static/theme/css/commons.css">
    <link rel="stylesheet" href="/static/theme/css/import.css">
    <script src="/static/js/jquery-1.11.1.min.js"></script>
    <script src="/static/js/jquery.json-2.4.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#btn_upload").click(function (event) {
                event.preventDefault();
                var data = new FormData();    //todo
                data.append("file", file.files[0]);
                $.ajax({
                    url: "/ajax/uploadFile",  //Server script to process data
                    type: "POST",
                    xhr: function () {
                        var myXhr = $.ajaxSettings.xhr();
                        if (myXhr.upload) {
                            myXhr.upload.addEventListener('progress', progressHandling, false);
                        }
                        return myXhr;
                    },
//                    beforeSend: beforeSendHandler,
                    success: function (ret) {

                        if (ret.success) { //success, code, msg, content, sheets
                            $("#err-msg").html("<font color=green>" + ret.msg + "</font>");
                            $("#importFrom").empty();
                            $("#importFrom").prop("disabled", false);
                            $("#btn_import").prop("disabled", false);
                            $("#dataFile").val(ret.content);
                            $("#importFrom").append("<optgroup label=" + ret.content + "></optgroup>");
                            $.each(ret.sheets, function (i, s) {
                                $("#importFrom optgroup").append('<option value="' + i + '">' + s + '</option>');
                            });
                        }
                    },
                    error: function (ret) {
                        $("#err-msg").html("<font color=red>" + ret + "</font>");
                    },
                    data: data,
                    anysc: false,
                    dataType: "json",
                    cache: false,
                    contentType: false,
                    processData: false
                });
            });

            $("#btn_import").click(function(event){
                event.preventDefault();
                $("#settingsForm").submit();
            });
        });

        function progressHandling(e) {
            if (e.lengthComputable) {
                $('progress').attr({value: e.loaded, max: e.total});
            }
        }
    </script>
</head>
<body>
<h1>STEP 2</h1>
<fieldset>
    <legend>Upload File</legend>
    <div id="err-msg"></div>
    <form id="uploadForm" action="/ajax/uploadFile" method="post" enctype="multipart/form-data">
        <input id="file" type="file" size="60" name="file">
    </form>
    <button id="btn_upload">Ajax File Upload</button>
    <br/>
    <progress></progress>
</fieldset>
<fieldset>
    <legend>Import Settings</legend>
    <form id="settingsForm" action="/dataTransfer/import2" method="post">
        <input type="radio" id="dmsetting" name="dataMappingSettings" value="1" checked>use data mapping settings if exists
        <br/>
        <input type="radio" id="dmsetting" name="dataMappingSettings" value="0">re-mapping data settings
        <br/>
        <hr/>
        FROM:
        <input type="hidden" id="dataFile" name="dataFile">
        <select name="importFrom" id="importFrom" disabled>
            <option>(select data source)</option>
        </select>
        TO:
        <select name="importTo" id="importTo">
            <optgroup label="人员信息">
                <option value="Person">Basic Info</option>
                <option value="Education">Education Info</option>
                <option value="WorkExperience">Work Experience</option>
            </optgroup>
            <optgroup label="员工信息">
                <option value="Employee">Employee</option>
                <option value="Contract">Contract</option>
                <option value="Salary">Salary</option>
            </optgroup>
        </select>
        Title Index: <input type="text" id="titleIndex" name="titleIndex" value="0">
    </form>
    <button id="btn_import" disabled> Next >> </button>
</fieldset>
<div id="aaa"></div>
</body>
</html>
