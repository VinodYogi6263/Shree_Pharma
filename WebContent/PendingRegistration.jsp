<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.sp.dto.*, com.sp.dao.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<p><br><br></p>
<%
 ShreePharmaDao sp=new ShreePharmaDaoImp();
 List<ShreePharmaDto> l=sp.searchNewRegistrationByStatus("InActive");
%>
<table align="center">
<tr>
<td colspan="6"align="center" style="height: 41px; background: linear-gradient(90deg, #00C9FF 0%, #92FE9D 100%); color: white; width: 973px"><h2>Pending Registration</h2></td>
</tr>
<tr>
<th align="left">Employee Name</th><th align="center">Current Status</th><th align="center">Qualification</th><th align="center">Experience</th><th align="center">Apply for</th>
</tr>
<%
 Iterator<ShreePharmaDto> it=l.iterator();
while(it.hasNext())
{
	ShreePharmaDto s=it.next();
%>
<tr>
<td><p><b><%= s.getFirst_name()+" "+s.getLast_name() %></b></p></td><td align="center"><%= s.getStatus() %></td>
<td align="center"><%= s.getQualification() %></td><td align="center"><%= s.getExperience() %></td><td align="center"><%= s.getRole() %></td>
<td align="right"><a href="RegistrationApproval.jsp?id=<%=s.getUser_id() %>"><button>View</button></a> <a href="/Shree_Pharma/deleteEmployeeDetail?id=<%= s.getUser_id() %>"><button>Delete</button></a>
<a href="/Shree_Pharma/reject?id=<%= s.getUser_id() %>"><button style="background-color: red; color: white;">Reject</button></a></td>
</tr>
<%
}
%>
</table>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>