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
<form action="/Shree_Pharma/transfercity">
<jsp:include page="Header.jsp"></jsp:include>
<p><br></p>
<%
int Cityid=Integer.parseInt(request.getParameter("cid"));
int MRid=Integer.parseInt(request.getParameter("MRid"));
CityTableDao ct=new CityTableDaoImp();
CityTableDto c=ct.getCityById(Cityid);
 
 ShreePharmaDao sp=new ShreePharmaDaoImp();
 ShreePharmaDto s=sp.searchEmployeeData(MRid);
%>
<div class="table">
<div class="card">
<div class="side">
<table style="width: 329px; height: 312px">
<tr>
<th colspan="2">MR Transfer</th>
</tr>
<tr>
<td>City Name:</td><td><select name="cid" style="width: 190px; height: 30px ">
<option value="<%= c.getCity_id() %>"><%= c.getCity_name() %></option>
</select></td>
</tr>
<tr>
<td>Current MR:</td><td><select style="width: 190px; height: 30px ">
<option><%= s.getFirst_name()+" "+s.getLast_name() %></option>
</select></td>
</tr>
<tr>
<td>Select New MR:</td><td><select name="NewMR" style="width: 190px; height: 30px ">
<option>Select New MR</option>
<%
List<ShreePharmaDto> l=sp.searchASMByRole("MR");
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
<jsp:include page="Footer.jsp"></jsp:include>
</form>
</body>
</html>