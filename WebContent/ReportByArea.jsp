<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.sp.dao.*,com.sp.dto.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ViewReportByArea.jsp">
<jsp:include page="Header.jsp"></jsp:include>
<br><br><br><br>
<table align="center">
<tr>
<td colspan="2"><h1>Search Area Report</h1></td>
</tr>
<tr>
<td>Select Area Name</td><td><select name="aid">
<option>select area</option>
<%
  AreaAllotmentDao aa=new AreaAllotmentDaoImp();
  List<AreaAllotmentDto> l1=aa.getAllAreaAndASMId();
  Iterator<AreaAllotmentDto> itr=l1.iterator();
  while(itr.hasNext())
  {
	  AreaAllotmentDto a=(AreaAllotmentDto)itr.next();
	  
	  AreaTableDao at=new AreaTableDaoImp();
	  AreaTableDto a1=at.getAreaByID(a.getArea_id());
%>
<option value="<%= a1.getArea_id()%>"><%= a1.getArea_name()%></option>
<%
  }
%>
</select></td>
<td><input type="submit" value="Search"></td>
</tr>
</table>
</form>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>