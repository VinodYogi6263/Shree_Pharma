<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/Shree_Pharma/fos">
<jsp:include page="Header.jsp"></jsp:include>
<table align="center">
<tr>
<td colspan="2" align="center"><h2>Create New Password</h2></td>
</tr>
<tr>
<td>Enter Employee ID:</td><td><input type="text" name="id" placeholder="enter employee id"></td>
</tr>
<tr>
<td>Enter New Password:</td><td><input type="text" name="ps1" placeholder="enter new password"></td>
</tr>
<tr>
<td>Enter Confirm Password:</td><td><input type="text" name="ps2" placeholder="enter confirm password"></td>
</tr>
<tr>
<td colspan="2" align="center" style="height: 106px; "><button style="width: 67px; height: 35px;" >Submit</button></td>
</tr>
</table>
</form>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>