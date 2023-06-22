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
AreaTableDao at=new AreaTableDaoImp();
List<AreaTableDto> l=at.viewAreaTable();
%>
<div class="table">
<h3>Area Table</h3>
<a href="AddNewAreaTable.jsp"><button style="width: 120px; height: 37px; background-color: blue; color: white; ">add New Area</button></a>
<p><br></p>
<div class="card">
<table border="1" cellspacing="0">
<tr>
<th>Area ID</th>
<th>Area Name</th>
<th colspan="3">Button</th>
</tr>
<%
Iterator<AreaTableDto> it=l.iterator();
while(it.hasNext())
{
	AreaTableDto a=it.next();
%>
<tr>
<td><%= a.getArea_id() %></td>
<td><%= a.getArea_name() %></td>
<td style="width: 15%;" align="center"><a style="color: blue;" href="/Shree_Pharma/CityTable.jsp?id=<%= a.getArea_id() %>"><button>View Cities</button></a></td>
<td style="width: 15%;" align="center"><a style="color: blue;" href="/Shree_Pharma/EditAreaTable.jsp?id=<%= a.getArea_id() %>"><button style="background-color: lightblue;">Edit</button></a></td>
<td style="width: 15%;" align="center"><a style="color: Red;" href="/Shree_Pharma/deletearea?id=<%= a.getArea_id() %>"><button style="background-color: Red;">Delete</button></a></td>
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