<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>UPLOAD</title>
</head>
<body>
<form action="upload/file" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <input type="submit" value="Upload"/>
</form>
</body>
</html>