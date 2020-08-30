<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>User List</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<script type="text/javascript">
function addUser(){
	//alert("adduser");
    document.getElementById("userForm").action="/userservice/user";
    document.getElementById("userForm").target="_self";   
    document.getElementById("userForm").method = "post";
    document.getElementById("userForm").submit();
}
function upload(){
		document.getElementById("userForm").action="/userservice/upload";
	    document.getElementById("userForm").target="_self";   
	    document.getElementById("userForm").method = "get";
	    document.getElementById("userForm").submit();
}

function exportToExcel(){
	 	document.getElementById("userForm").action="/userservice/excel";
	    document.getElementById("userForm").target="_self";   
	    document.getElementById("userForm").method = "get";
	    document.getElementById("userForm").submit();
}
</script>
</head>
<body>

<form:form method="post" id="userForm" name="userForm"
	modelAttribute="userForm">
	<h1><b>User's List</b></h1>
	<div>
	<table border="1" cellspacing="0" cellpadding="0" width="400px">
		<tr>
			<th width="100px">User ID</th>
			<th width="150px">User Name</th>
			<th width="150px">Role</th>
		</tr>
		<c:choose>
			<c:when test="${userForm.userList ne null}">
				<c:forEach items="${userForm.userList}" var="userObject">
					<tr >
						<td width="100px"><c:out value="${userObject.userId}" /></td>
						<td width="150px"><c:out value="${userObject.userName}" /></td>
						<td width="150px"><c:out value="${userObject.role}" /></td>
					</tr>

				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td  colspan="4" height="60" align="center"><font color="red">No User are available</font></td>
				</tr>
			</c:otherwise>
		</c:choose>

	</table>
	</div>
	<div class="clear"></div>
	<table border="1" cellspacing="0" cellpadding="0" width="400px">
		<tr>
			<th width="60px"><div><input type="button" value="Add New User" onclick="javascript:addUser();"/></div></th>
			<th width="100px"><div><input type="button" value="Upload Attachments" onclick="javascript:upload();"/></div></th>
			<th width="100px"><div><input type="button" value="Export to Excel" onclick="javascript:exportToExcel();"/></div></th>
		</tr>
	</table>
</form:form>
</body>
</html>
