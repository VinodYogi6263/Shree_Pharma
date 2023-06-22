<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/Shree_Pharma/login">
	<jsp:include page="Header.jsp"></jsp:include>
		<table width: 291px" align="center">
			<tr>
				<td colspan="2"><h2 align="center">Employee Login</h2></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><p style="color: red;">Incorrect
						ID or Password</p></td>
			</tr>
			<tr>
				<td>Enter Employee ID:</td>
				<td><input type="text" name="id" id="t1" value=""></td>
			</tr>
			<tr>
				<td>Enter Password:</td>
				<td><input type="Password" name="pass" id="t2" value=""></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><a href="/Shree_Pharma/ForgetPassword.jsp" style="color: blue">Forget
						Password</a></td>
			</tr>
			<tr>
				<td colspan="2" align="center" style="height: 79px;"><button
						style="width: 67px; height: 35px;" onclick="fun1()">Login</button></td>
			</tr>
		</table>
		<script>
			function fun1() {
				var name = document.getElementById('t1').value;
				var Password = document.getElementById("t2").value;
				if (name == "") {
					alert("Please enter your ID")
				}
				if (Password == "") {
					alert("Please enter your Password")
				} else {

				}
			}
		</script>
	</form>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>