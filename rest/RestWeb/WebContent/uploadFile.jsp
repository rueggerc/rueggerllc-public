<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>RestWeb</title>
</head>
<body>
<H1>Upload File</H1>

<form action="uploadServlet" method="post" enctype="multipart/form-data">
    <input type="text" name="description" />
    <input type="file" name="file" />
    <br/>
    <input type="submit" />
</form>


</body>
</html>