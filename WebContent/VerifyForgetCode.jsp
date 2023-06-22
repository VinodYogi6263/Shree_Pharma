<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/Shree_Pharma/forget">
<jsp:include page="Header.jsp"></jsp:include>
<table align="center">
<tr>
<td colspan="2" align="center"><h1>Verify code</h1></td>
</tr>
<tr>
<td>Enter Verification Code:</td><td><input type="text" name="code" placeholder="enter code"></td>
</tr>
<tr>
<td colspan="2" align="right"><p style="color: red;">Incorrect OTP</p></td>
</tr>
<tr>
<td colspan="2" align="center" style="height: 66px; "><button style="width: 67px; height: 35px;">Verify</button></td>
</tr>
</table>
<jsp:include page="Footer.jsp"></jsp:include>
</form>
</body>
</html>