<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.sp.dao.*, com.sp.dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:white"align="center">
<form action="/Shree_Pharma/approvereg">
<jsp:include page="Header.jsp"></jsp:include>
<%
 int id=Integer.parseInt(request.getParameter("id"));
 ShreePharmaDao sp=new ShreePharmaDaoImp();
 ShreePharmaDto s=sp.searchEmployeeData(id);
%>
<p><br><br></p>
<table align="center" style="height: 591px; ">
<tr>
<td colspan="4" align="center" style="height: 41px; background: linear-gradient(90deg, #00C9FF 0%, #92FE9D 100%); color: white; "><h2>Employee Registration Form</h2></td>
</tr>
<tr>
<td style="width: 130px; ">Employee ID:</td><td style="width: 315px; "><input type="text" name="id" readonly value="<%= s.getUser_id() %>" style="width: 180px; height: 20px "/></td>
<td style="width: 130px; ">Create Employee Password:</td><td><input type="text" name="pass" placeholder="Exa:-Shree@123" style="width: 180px; height: 20px "/></td>
</tr>
<tr>
<td style="width: 130px; ">First Name:</td><td><input type="text" name="fn" value="<%= s.getFirst_name() %>" style="width: 180px; height: 20px "/></td>
<td style="width: 130px; ">Last Name:</td><td><input type="text" name="ln" value="<%= s.getLast_name() %>" style="width: 180px; height: 20px "/></td>
</tr>
<tr>
<td style="width: 130px; ">Permanent Address:</td><td colspan="3"><input type="text" name="add" value="<%= s.getAddress() %>" style="width: 630px; height: 20px "/></td>
</tr>
<tr>
<td style="width: 130px; ">Contact:</td><td><input type="text" name="c" value="<%= s.getContact_number() %>" style="width: 180px; height: 20px "/></td>
<td style="width: 130px; ">Email:</td><td><input type="gmail" name="e" value="<%= s.getEmail_id() %>" style="width: 180px; height: 20px "/></td>
</tr>
<tr>
<td style="width: 130px; ">Qualification:</td><td><input type="text" name="q" value="<%= s.getQualification() %>" style="width: 180px; height: 20px "/></td>
<td style="width: 130px; ">Experience:</td><td><input type="text" name="exp" value="<%= s.getExperience() %>" style="width: 180px; height: 20px "/></td>
</tr>
<tr>
<td style="width: 130px; ">Designation:</td><td><select name="role" style="width: 183px; height: 28px; ">
<option><%= s.getRole() %></option>
<option value="GM">General Manager</option>
<option value="ASM">Area Manager</option>
<option value="MR">Marketing Representatives</option>
</select></td>
<td style="width: 130px; ">Status:</td><td><select name="status" style="width: 183px; height: 28px; ">
<option>Select Option</option>
<option value="Active">Active</option>
<option value="InActive">InActive</option>
</select>
</td>
</tr>
<tr>
<td colspan="4" align="center" style="height: 95px; "><button style="width: 80px; height: 40px;">Submit</button></td>
</tr>
</table>
<%
String Eid=Integer.toString(s.getUser_id());
HttpSession session2=request.getSession();
session2.setAttribute("Ename", s.getFirst_name()+" "+s.getLast_name());
session2.setAttribute("EID", Eid);
session2.setAttribute("Egmail", s.getEmail_id());
%>
<jsp:include page="Footer.jsp"></jsp:include>
</form>
</body>
</html>