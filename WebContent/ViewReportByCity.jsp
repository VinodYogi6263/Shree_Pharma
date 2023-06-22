<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.sp.dao.*,com.sp.dto.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<br><br><br><br><br>
<table border="1"cellspacing="0" align="center" style="width: 992px; ">
<tr style="background-color: #018a8a;color: white;">
<%
int Cid=Integer.parseInt(request.getParameter("cid"));
try{
	CityAllotmentDao cad=new CityAllotmentDaoImp();
	CityAllotmentDto ca=cad.getCityDetailByCityID(Cid);
	
  if(!ca.equals(null))
   {
	CityTableDao ct=new CityTableDaoImp();
	CityTableDto c=ct.getCityById(ca.getCity_id());
	
	ShreePharmaDao sp=new ShreePharmaDaoImp();
	ShreePharmaDto s=sp.searchEmployeeData(ca.getMr_id());
%>
<td align="center"><b>City:</b></td><td><%=c.getCity_name() %></td>
<td align="center"><b>MR ID:</b></td><td><%=ca.getMr_id() %></td>
<td align="center"><b>MR Name:</b></td><td><%=s.getFirst_name()+" "+s.getLast_name() %></td>
</tr>
<tr style="background-color: #018a8a;color: white;">
<td align="center">Total reports:</td><td>500</td><td align="center">MR Performance:</td><td>80%</td><td></td><td></td>
</tr>
<%
 }
  }
catch(NullPointerException e)
{
	out.println("No Data Available");
}

ReportDao rd=new ReportDaoImp();

List<ReportDto> l=rd.viewReportByCity(Cid);
Iterator<ReportDto> it=l.iterator();
while(it.hasNext())
{
	ReportDto r1=(ReportDto)it.next();
%>
<tr>
<th rowspan="2"><%=r1.getReport_id() %></th><td><b>date:</b> <%=r1.getDate() %></td><td colspan="2"><b>No of DR Visited:</b> <%=r1.getDr_visited() %></td><td colspan="2"><b>No of Chemist Visited:</b> <%=r1.getChemist_visited() %></td>
</tr>
<tr>
<td><b>Daily Collection:</b> <%=r1.getDaily_income() %></td><td colspan="2"><b>Achievement:</b> <%=r1.getAchievement() %></td><td><b>Total Order:</b> <%=r1.getOrder() %></td><td><b>Status:</b> <%=r1.getStatus() %></td>
</tr>
<%
}
%>
</table>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>