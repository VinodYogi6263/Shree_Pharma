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
int rid=Integer.parseInt(request.getParameter("rid"));
ReportDao rd=new ReportDaoImp();
ReportDto r=rd.viewReportByReportID(rid);

HttpSession session8=request.getSession();
session8.setAttribute("rid", r.getReport_id());
%>
<form action="/Shree_Pharma/mrreportbycity">
<h1 align="center">Report</h1>
<table cellspacing="0" border="1" align="center" style="width: 935px; height: 633px">
<%	
	CityTableDao ct=new CityTableDaoImp();
	CityTableDto c=ct.getCityById(r.getCity_id());
	
	ShreePharmaDao sp=new ShreePharmaDaoImp();
	ShreePharmaDto s=sp.searchEmployeeData(r.getMr_id());
%>
<tr style="background-color: #018a8a;color: white;">
<th>ID: <%=r.getReport_id() %></th><th>Date: </th><td><%=r.getDate() %></td><th>City Name: </th><td><%=c.getCity_name() %></td>
<th>MR Name: </th><td><%=s.getFirst_name()+" "+s.getLast_name() %></td>
</tr>
<tr align="center">
<td><b>No. of Dr Visited:</b></td><td colspan="2"><%=r.getDr_visited() %></td><td><b>No. of Chemist Visited:</b></td><td><%=r.getChemist_visited() %></td><td ><b>Medicine Promoted:</b></td><td colspan="3"><%=r.getMedicine_promoted() %></td>
</tr>
<tr align="center">
<td><b>Daily Collection:</b></td><td colspan="2"><%=r.getDaily_income() %></td><td><b>Achievement:</b></td><td><%=r.getAchievement() %></td>
<td ><b>Target:</b></td><td><%=r.getAchievement() %></td>
</tr>
<tr align="center">
<td><b>Total Order:</b></td><td colspan="2"><%=r.getOrder() %></td><td><b>Status:</b></td><td><%=r.getStatus() %></td><td><b>Comment:</b></td><td><select name="comment" style="height: 26px; ">
<option>select comment</option>
<option value="5">Excellent</option>
<option value="4">Good</option>
<option value="3">Need Improvement</option>
<option value="2">Bad</option>
<option value="1">Worst</option>
</select></td>
</tr>
<tr align="center">
<td><b>Remark:</b></td><td colspan="8"><textarea name="remark" row="10" cols="41" style="width: 586px; height: 66px; "></textarea></td>
</tr>
<tr align="center">
<td colspan="10"><button class="btn-a" style="width: 102px; height: 36px; ">Submit</button></td>
</tr>
</table>
<jsp:include page="Footer.jsp"></jsp:include>
</form>
</body>
</html>