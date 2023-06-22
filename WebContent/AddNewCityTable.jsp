<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.sp.dto.* ,com.sp.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="Stylesheet" href="EditProductData.css">
</head>
<body>
<form action="/Shree_Pharma/addnewcity">
<jsp:include page="Header.jsp"></jsp:include>
<p><br></p>
<%
int aid=Integer.parseInt(request.getParameter("id"));
AreaTableDao at=new AreaTableDaoImp();
AreaTableDto a=at.getAreaByID(aid);
%>
<div class="table">
<div class="card">
<div class="side">
<table style="width: 329px; height: 272px">
<tr>
<th colspan="2">Add New City</th>
</tr>
<tr>
<td>Your Area ID:</td><td><input type="text" name="aid" value="<%= a.getArea_id() %>"></td>
</tr>
<tr>
<td>Your Area Name:</td><td><input type="text" name="aname" value="<%= a.getArea_name() %>"></td>
</tr>
<tr>
<td>Enter City Name:</td><td><input type="text" name="cname"></td>
</tr>
<tr>
<tr>
<td colspan="2" align="center" style="height: 73px; "><button style="width: 82px; height: 37px; ">Submit</button></td>
</tr>
</table>
</div>
<div class="main">
<img alt="medicine_img" src="T:\Eclipse_Data\Shree_Pharma\WebContent\Image\medicine_img.jpg" style="width: 975px; height: 513px" align="right">
</div>
</div>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</form>
</body>
</html>