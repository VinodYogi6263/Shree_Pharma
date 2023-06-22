<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.sp.dao.*,com.sp.dto.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ViewReportByCity.jsp">
<jsp:include page="Header.jsp"></jsp:include>
<br><br><br><br>
<table align="center" style="width: 368px; ">
<tr>
<td colspan="3"><h2>Search Report By City</h2></td>
</tr>
<tr>
<td>Select City Name:</td><td><select name="cid">
<option>select city</option>
<%
CityTableDao ct=new CityTableDaoImp();
List<CityTableDto> l=ct.viewCityList();
Iterator<CityTableDto> it=l.iterator();
while(it.hasNext())
{
CityTableDto c=(CityTableDto)it.next();
 %>
<option value="<%=c.getCity_id() %>"><%=c.getCity_name() %></option>
<%
}
%>
</select></td>
<td align="left"><input type="submit" value="Search"></td>
</tr>
</table>
</form>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>