<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.sp.dto.ShreePharmaDto, com.sp.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="Stylesheet" href="#" >
</head>
<body style="background-color:white"align="center">
<form action="/Shree_Pharma/updateProfile">
<jsp:include page="Header.jsp"></jsp:include>
<p><br></p>
<%
int id=Integer.parseInt(request.getParameter("id"));
ShreePharmaDao sp=new ShreePharmaDaoImp();
ShreePharmaDto s=sp.searchEmployeeData(id);
HttpSession session3=request.getSession();
String ID=Integer.toString(s.getUser_id());
session.setAttribute("editID", ID);
%>
<div class="table">
<div class="card">
<table align="center" style="height: 719px; ">
<tr>
<td colspan="6" align="center" style="height: 41px; background: linear-gradient(90deg, #00C9FF 0%, #92FE9D 100%); color: white; "><h2>Edit Employee Profile</h2></td>
</tr>
<tr>
<td style="width: 130px; ">Employee ID:</td><td><b><%= s.getUser_id() %></b></td>
<td style="width: 130px; ">Status:</td><td><b><%= s.getStatus() %></b></td>
<td style="width: 130px; ">Designation:</td><td><b><%= s.getRole() %></b></td>
</tr>
<tr>
<td style="width: 130px; ">First Name:</td><td style="width: 250px; " colspan="2"><input type="text" name="fn" value="<%= s.getFirst_name() %>" style="width: 180px; height: 20px "/></td>
<td style="width: 130px; ">Last Name:</td><td colspan="2"><input type="text" name="ln" value="<%= s.getLast_name() %>" style="width: 180px; height: 20px"/></td>
</tr>
<tr style="height: 54px; ">
<td>Address:</td><td colspan="5"><input type="text" name="add" value="<%= s.getAddress() %>" row="10" cols="41" style="width: 561px; height: 54px"></td>
</tr>
<tr>
<td style="width: 130px; ">Contact:</td><td colspan="2"><input type="text" name="c" value="<%= s.getContact_number() %>" style="width: 180px; height: 20px "/></td>
<td style="width: 130px; ">Email:</td><td colspan="2"><input type="text" name="e" value="<%= s.getEmail_id() %>" style="width: 180px; height: 20px "/></td>
</tr>
<tr>
<td style="width: 130px; ">Qualification:</td><td colspan="2"><input type="text" name="q" value="<%= s.getQualification() %>" style="width: 180px; height: 20px "/></td>
<td style="width: 130px; ">Experience:</td><td colspan="2"><input type="text" name="exp" value="<%= s.getExperience() %>" style="width: 180px; height: 20px "/></td>
</tr>
<tr>
<td style="width: 130px; ">Choice Designation:</td><td colspan="2"><select name="role" style="width: 190px; height: 30px ">
<option>Select Option</option>
<option value="GM">General Manager</option>
<option value="ASM">Area Manager</option>
<option value="MR">Marketing Representatives</option>
</select>
</td>
<td>Status:</td><td colspan="2"><select name="status" style="width: 190px; height: 30px ">
<option>Select Option</option>
<option value="Active">Active</option>
<option value="InActive">InActive</option>
</select>
</td>
</tr>
<tr>
<td colspan="6" align="center" style="height: 54px; "><button style="width: 80px; height: 40px;">Submit</button></td>
</tr>
</table>
</div>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</form>
</body>
</html>