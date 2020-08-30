<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Attachment List</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<script type="text/javascript">
function preview(documentId){
	//alert("documentId:"+documentId);
	document.getElementById("documentId").value = documentId;
    document.getElementById("uploadForm").action="/userservice/previewDocument";
    document.getElementById("uploadForm").target="_self";   
    document.getElementById("uploadForm").method = "post";
    document.getElementById("uploadForm").submit();
}

function userList(){
	//alert("documentId:"+documentId);
	document.getElementById("uploadForm").action="/userservice/users";
    document.getElementById("uploadForm").target="_self";   
    document.getElementById("uploadForm").method = "post";
    document.getElementById("uploadForm").submit();
}
</script>
</head>
<body>

<form:form method="post" id="uploadForm" name="uploadForm"
	modelAttribute="uploadForm">
	<form:hidden path="documentId"/>
	<h1><b>Attachment List</b></h1>
	<div>
	<table border="1" cellspacing="0" cellpadding="0" width="400px">
		<tr>
			<th width="150px">Attachment Id</th>
			<th width="300px">Attachment Name</th>
			<th width="150px">Attachment Size (kb)</th>
		</tr>
		<c:choose>
			<c:when test="${uploadForm.attachmentList ne null}">
				<c:forEach items="${uploadForm.attachmentList}" var="attachmentObject">
					<tr >
						<td width="150px"><c:out value="${attachmentObject.documentId}" /></td>
						<td width="300px"><a href="javascript:preview(${attachmentObject.documentId});"><c:out value="${attachmentObject.documentName}" /></a></td>
						<td width="150px"><c:out value="${attachmentObject.documentSize}" /></td>
					</tr>

				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td  colspan="4" height="60" align="center"><font color="red">No Attachments are available</font></td>
				</tr>
			</c:otherwise>
		</c:choose>

	</table>
	<a href="javascript:userList();">User List</a>
	</div>
	<div class="clear"></div>
</form:form>
</body>
</html>
