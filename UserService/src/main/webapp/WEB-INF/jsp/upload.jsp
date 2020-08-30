<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Upload a file please</title>
</head>
<body>
	<h1>Please upload a file</h1>
	<form method="post" action="/userservice/saveAttachments" enctype="multipart/form-data">
	Upload Attachment : <input type="file" name="UploadDocumentFile" /> <br/>
	<input type="submit" value="Save"/>
</form>
</body>

</html>