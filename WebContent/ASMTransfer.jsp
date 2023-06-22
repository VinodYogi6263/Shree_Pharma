<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.sp.dto.* ,com.sp.dao.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="Stylesheet" href="EditProductData.css">
</head>
<body>
<form action="/Shree_Pharma/transferarea">
<jsp:include page="Header.jsp"></jsp:include>
<p><br></p>
<%
int Areaid=Integer.parseInt(request.getParameter("aid"));
int ASMid=Integer.parseInt(request.getParameter("ASMid"));
 AreaTableDao at=new AreaTableDaoImp();
 AreaTableDto a=at.getAreaByID(Areaid);
 
 ShreePharmaDao sp=new ShreePharmaDaoImp();
 ShreePharmaDto s=sp.searchEmployeeData(ASMid);
%>
<div class="table">
<div class="card">
<div class="side">
<table style="width: 329px; height: 312px">
<tr>
<th colspan="2">ASM Transfer</th>
</tr>
<tr>
<td>Area Name:</td><td><select name="aid" style="width: 190px; height: 30px ">
<option value="<%= a.getArea_id() %>"><%= a.getArea_name() %></option>
</select></td>
</tr>
<tr>
<td>Current ASM:</td><td><select style="width: 190px; height: 30px ">
<option><%= s.getFirst_name()+" "+s.getLast_name() %></option>
</select></td>
</tr>
<tr>
<td>Select New ASM:</td><td><select name="NewASM" style="width: 190px; height: 30px ">
<option>Select New ASM</option>
<%
List<ShreePharmaDto> l=sp.searchASMByRole("ASM");
Iterator<ShreePharmaDto> it=l.iterator();
while(it.hasNext())
{
	ShreePharmaDto s1=(ShreePharmaDto)it.next();
%>
<option value="<%= s1.getUser_id() %>"><%= s1.getFirst_name()+" "+s1.getLast_name() %></option>
<%
}
%>
</select></td>
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
</form>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>