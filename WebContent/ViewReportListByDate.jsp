<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.sp.dao.*,com.sp.dto.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="ViewReportByDate.css">
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<br><br><br><br>
<%
String from=request.getParameter("d1");
String to=request.getParameter("d2");

HttpSession session7=request.getSession();
session7.setAttribute("date1", from);
session7.setAttribute("date2", to);

ReportDao rd=new ReportDaoImp();
List<ReportDto> l=rd.checkLimitedReport(from, to);
%>
<table cellspacing="0" align="center" style="width: 935px; height: 202px">
<tr>
<td colspan="7"><h3>Report From: <%=from %> To: <%=to %></h3></td>
</tr>
<tr style="background-color: #018a8a;color: white;">
<th>ID</th><th>Date</th><th>City Name</th><th>MR Name</th><th>Status</th><th></th><th></th>
</tr>
<%
Iterator<ReportDto> it=l.iterator();
while(it.hasNext())
{
	ReportDto r=(ReportDto)it.next();
	
	CityTableDao ct=new CityTableDaoImp();
	CityTableDto c=ct.getCityById(r.getCity_id());
	
	ShreePharmaDao sp=new ShreePharmaDaoImp();
	ShreePharmaDto s=sp.searchEmployeeData(r.getMr_id());
%>
<tr align="center">
<td><%=r.getReport_id() %></td><td><%=r.getDate() %></td><td><%=c.getCity_name() %></td>
<td><%=s.getFirst_name()+" "+s.getLast_name() %></td><td><%=r.getStatus() %></td>
<td><a href="/Shree_Pharma/ViewFullMrReportByDate.jsp?rid=<%= r.getReport_id()%>"><button class="btn-a">View</button></a></td>
<td><a href="/Shree_Pharma/deletedailyreport?id=<%= r.getReport_id()%>"><button class="btn-b">Delete</button></a></td>
</tr>
<%
}
%>
</table>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>