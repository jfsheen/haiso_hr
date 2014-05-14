<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>UPLOAD</title>
    <link rel="stylesheet" href="/static/theme/css/commons.css">
    <link rel="stylesheet" href="/static/theme/css/import.css">
    <link rel="stylesheet" href="/static/theme/css/jquery-ui.css">
    <script src="/static/js/jquery-1.11.1.min.js"></script>
    <script src="/static/js/jquery-ui.min.js"></script>
    <script src="/static/js/jquery.json-2.4.min.js"></script>
<#--<script src="/static/js/jquery-fileupload.min.js"></script>-->
    <script>
        $(document).ready(function () {
            $("#btn_upload").click(function (e) {
                e.preventDefault();
                var data = new FormData();
                data.append("file", file.files[0]);
                $.ajax({
                    url: "/ajax/uploadFile",  //Server script to process data
                    type: "POST",
                    xhr: function () {  // Custom XMLHttpRequest
                        var myXhr = $.ajaxSettings.xhr();
                        if (myXhr.upload) { // Check if upload property exists
                            myXhr.upload.addEventListener('progress', progressHandling, false); // For handling the progress of the upload
                        }
                        return myXhr;
                    },
                    //Ajax events
//                    beforeSend: beforeSendHandler,
                    success: function (msg) {
                        $("err-msg").html(msg);
                    },
                    error: function (msg) {
                        $("err-msg").html(msg);
                    },
                    // Form data
                    data: data,
                    dataType: "text", //important !!!!!!!
                    //Options to tell jQuery not to process data or worry about content-type.
                    cache: false,
                    contentType: false,
                    processData: false
                });
            });
        });
        function progressHandling(e) {
            if (e.lengthComputable) {
                $('progress').attr({value: e.loaded, max: e.total});
            }
        }
        /*$("#file").change(function(){
            var file = this.files[0];
            var name = file.name;
            var size = file.size;
            var type = file.type;
            $("#btn_upload").html(name);
        });*/
    </script>
</head>
<body>
<h1>STEP 2</h1>
<fieldset>
    <legend>Upload File</legend>
    <div class="err-msg"></div>
    <form id="uploadForm" action="/ajax/uploadFile" method="post" enctype="multipart/form-data">
        <input id="file" type="file" size="60" name="file">
        <button id="btn_upload">Ajax File Upload</button>
    </form>
    <progress></progress>
</fieldset>
<form id="settingsForm" action="/dataTransfer/import2" method="post">
    <fieldset>
        <legend>Import Settings</legend>
        <input type="radio" name="dataMappingSettings" value="useIfExists" checked>use data mapping settings if exists
        <br/>
        <input type="radio" name="dataMappingSettings" value="reMapping">re-mapping data settings
        <br/>
        <hr/>
        FROM:
        <select name="importFrom" disabled>
            <option value="xls" selected>MS Excel</option>
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
    </fieldset>
    <button id="btn_import">Import</button>
</form>
</body>
</html>