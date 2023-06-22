<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.sp.dao.*,com.sp.dto.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="Stylesheet" href="ProductData.css" >
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<p><br></p>
<%
int id=Integer.parseInt(request.getParameter("id"));
CityTableDao ct=new CityTableDaoImp();
List<CityTableDto> l=ct.viewCitiesById(id);
%>
<div class="table">
<h3>City Table</h3>
<a href="AddNewCityTable.jsp?id=<%= id %>"><button style="width: 120px; height: 37px; background-color: blue; color: white; ">add New City</button></a>
<p><br></p>
<div class="card">
<table border="1" cellspacing="0">
<tr>
<th>City ID</th>
<th>City Name</th>
<th colspan="3">Button</th>
</tr>
<%
Iterator<CityTableDto> it=l.iterator();
while(it.hasNext())
{
	CityTableDto c=it.next();
%>
<tr>
<td><%= c.getCity_id() %></td>
<td><%= c.getCity_name() %></td>
<td style="width: 15%;" align="center"><a style="color: blue;" href="/Shree_Pharma/EditCityTable.jsp?id=<%= c.getCity_id() %>"><button style="background-color: lightblue;">Edit</button></a></td>
<td style="width: 15%;" align="center"><a style="color: Red;" href="/Shree_Pharma/deletecity?id=<%= c.getCity_id() %>"><button style="background-color: Red;">Delete</button></a></td>
</tr>
<%
}
%>
</table>
</div>

</div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>