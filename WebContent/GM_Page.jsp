<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.sp.dao.*,com.sp.dto.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="GM_Page.css">
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<%
HttpSession session1=request.getSession();
String name=(String)session1.getAttribute("name");
String id=(String)session1.getAttribute("id");
String Role=(String)session1.getAttribute("role");
String Status=(String)session1.getAttribute("status");
%>
<p><br></p>
<div class="row">
<div class="left-side">
<div class="card">
<h3>Employee Profile</h3>
<img alt="employee_img" src="T:\Eclipse_Data\Shree_Pharma\WebContent\Image\employee.png" style="width: 100%;">
<div class="container">
<h4><b><%= name %></b></h4>
<p>ID : <%= id %> </p>
<p>Designation : <%= Role %></p>
<p>Status : <%= Status %></p>
<a href="EditEmployeeProfile.jsp?id=<%= id %>"><button style="color: blue;">Edit</button></a>
</div>
</div>
</div>
<%
ReportDao rd=new ReportDaoImp();
List<ReportDto> l=rd.viewReports();
%>
<div class="middle">
<h3>Daily Reports</h3>
<div class="card2">
<table cellspacing="0" border="1" width="100%" cellspacing="2px" cellpadding="2px" align="center">
<tr>
<th>Date</th>
<th>City Name</th>
<th>Employee Name</th>
<th>Area Visited</th>
<th style="width: 34px; ">No of Doctor Visited</th>
<th style="width: 77px; ">No of Chemist Visited</th>
<th>Medicine Promoted</th>
<th>Order</th>
<th>Daily Income</th>
</tr>
<%
Iterator<ReportDto> it=l.iterator();
while(it.hasNext())
{
	ReportDto r=it.next();
	
	CityTableDao ct=new CityTableDaoImp();
	CityTableDto c=ct.getCityById(r.getCity_id());
	
	ShreePharmaDao sp=new ShreePharmaDaoImp();
	ShreePharmaDto s=sp.searchEmployeeData(r.getMr_id());
	
%>
<tr>
<td><%= r.getDate() %></td>
<td><%= c.getCity_name() %></td>
<td><%= s.getFirst_name()+" "+s.getLast_name() %></td>
<td><%= r.getArea_visited() %></td>
<td><%= r.getDr_visited() %></td>
<td><%= r.getChemist_visited() %></td>
<td><%= r.getMedicine_promoted() %></td>
<td><%= r.getOrder() %></td>
<td><%= r.getDaily_income() %></td>
</tr>
<%
}
%>
</table>
</div>
</div>
<div class="right-side">
<h2>GM Work</h2>
<div class="card1">
<a href="AreaAllotmentToASMTable.jsp"><h3><b>Allot Area to ASM</b></h3></a>
</div>
<div class="card1">
<a href="#"><h3><b>Allot Area to MR</b></h3></a>
</div>
<div class="card1">
<a href="AreaTable.jsp"><h3><b>Area Table</b></h3></a>
</div>
<div class="card1">
<a href="ASM_Target.jsp"><h3><b>ASM Target</b></h3></a>
</div>
<div class="card1">
<a href="PendingRegistration.jsp"><h3><b>Registration Approval</b></h3></a>
</div>
<div class="card1">
<a href="ProductData.jsp"><h3><b>Product Data</b></h3></a>
</div>
<div class="card1">
<div class="dropup">
  <button class="dropbtn"><b>View Reports</b></button>
  <div class="dropup-content">
    <a href="ReportByArea.jsp">View Report By Area</a>
    <a href="ReportByCity.jsp">View Report By City</a>
    <a href="ReportListByDate.jsp">View Report By Date</a>
  </div>
</div>
</div>
</div>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>