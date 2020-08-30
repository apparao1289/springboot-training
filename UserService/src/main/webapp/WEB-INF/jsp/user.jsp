<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
</head>
<body>
<script type="text/javascript">
function addUser(){
	//alert("adduser");
    document.getElementById("userForm").action="/userservice/userList";
    document.getElementById("userForm").target="_self";   
    document.getElementById("userForm").method = "post";
    document.getElementById("userForm").submit();
}

</script>
<form:form method="post" id="userForm" name="userForm"
	modelAttribute="userForm">
	<div>
	<table border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td >User Id:</td>
			<td >&nbsp;</td>
			<td ><form:input path="userId" id="userId"
				 style="width:255px" maxlength="3"></form:input></td>
			<td class="error">&nbsp;<font color="red"><form:errors path="userId" /></font></td>
		</tr>
		<tr>
			<td >User Name:</td>
			<td >&nbsp;</td>
			<td ><form:input path="userName" id="userName"
				 style="width:255px"></form:input></td>
			<td class="error">&nbsp;<font color="red"><form:errors path="userName" /></font></td>
		</tr>
		<tr>
			<td >User Role:</td>
			<td >&nbsp;</td>
			<td ><form:input path="role" id="role"
				 style="width:255px"></form:input></td>
			<td class="error">&nbsp;<font color="red"><form:errors path="role" /></font></td>
		</tr>
		<tr><td colspan="1"><input type="button" value="Add User" onclick="javascript:addUser();"/></td>
		<td colspan="2">&nbsp;</td></tr>
	</table>
	</div>
</form:form>
</body>
</html>