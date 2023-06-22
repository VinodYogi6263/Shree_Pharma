<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="Stylesheet" href="#" >
</head>
<body style="background-color:white"align="center">
<form action="/Shree_Pharma/reg">
<jsp:include page="Header.jsp"></jsp:include>
<p><br></p>
<div class="table">
<div class="card">
<table align="center" style="height: 870px; ">
<tr>
<td colspan="4" align="center" style="height: 41px; background: linear-gradient(90deg, #00C9FF 0%, #92FE9D 100%); color: white; "><h2>Employee Registration Form</h2></td>
</tr>
<tr>
<td style="width: 130px; ">Enter First Name:</td><td style="width: 250px; "><input type="text" name="fn" placeholder="first name" style="width: 180px; height: 20px "/></td>
<td style="width: 130px; ">Enter Last Name:</td><td><input type="text" name="ln" placeholder="last name" style="width: 180px; height: 20px"/></td>
</tr>
<tr>
<td style="width: 130px; ">Enter Village/City:</td><td><input type="text" name="v/c" placeholder="village/city name" style="width: 180px; height: 20px"/></td>
<td style="width: 130px; ">Enter Post:</td><td><input type="text" name="post" placeholder="post office" style="width: 180px; height: 20px"/></td>
</tr>
<tr>
<td style="width: 130px; ">Enter District:</td><td><input type="text" name="d" placeholder="district" style="width: 180px; height: 20px "/></td>
<td style="width: 130px; ">Enter State:</td><td><input type="text" name="s" placeholder="state" style="width: 180px; height: 20px "/></td>
</tr>
<tr>
<tr>
<td style="width: 130px; ">Enter Pincode:</td><td><input type="text" name="pin" placeholder="pin code" style="width: 180px; height: 20px "/></td>
<td style="width: 130px; ">Country Name:</td><td><input type="text" name="country" value="India" style="width: 180px; height: 20px "/></td>
</tr>
<tr>
<td style="width: 130px; ">Contact:</td><td><input type="text" name="c" placeholder="except zero" style="width: 180px; height: 20px "/></td>
<td style="width: 130px; ">Email:</td><td><input type="text" name="e" placeholder="only lower case" style="width: 180px; height: 20px "/></td>
</tr>
<tr>
<td style="width: 130px; ">Qualification:</td><td><input type="text" name="q" placeholder="qualification" style="width: 180px; height: 20px "/></td>
<td style="width: 130px; ">Experience:</td><td><input type="text" name="exp" placeholder="experience" style="width: 180px; height: 20px "/></td>
</tr>
<tr>
<td style="width: 130px; ">Choice Designation:</td><td><select name="role" style="width: 190px; height: 30px ">
<option>Select Option</option>
<option value="GM">General Manager</option>
<option value="ASM">Area Manager</option>
<option value="MR">Marketing Representatives</option>
</select>
</td>
<td>Status:</td><td colspan="3"><select name="status" style="width: 190px; height: 30px ">
<option value="InActive">InActive</option>
</select>
</td>
</tr>
<tr>
<td style="width: 82px; " align="center"><input type="checkbox" name="r" style="width: 30px; height: 30px;"></td><td colspan="3" style="height: 48px; "><P>I certify that the information I have written,I have submitted to be true and accurate.<br>
If any information is found wrong then the form will be rejected </P></td>
</tr>
<tr>
<td colspan="4" align="center" style="height: 54px; "><button style="width: 80px; height: 40px;">Submit</button></td>
</tr>
</table>
</div>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</form>
</body>
</html>