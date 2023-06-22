<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.sp.dao.*, com.sp.dto.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">
<jsp:include page="Header.jsp"></jsp:include>
<br><br><br><br><br><br><br><br>
<form action="/Shree_Pharma/assignASMTarget">
<table align="center" style="height: 396px; ">
<tr>
<td colspan="4" align="center" style="height: 41px; background: linear-gradient(90deg, #00C9FF 0%, #92FE9D 100%); color: white; "><h2>ASM Target</h2></td>
</tr>
<tr>
<td>Target Mode:</td><td><select name="tm" style="width: 183px; height: 28px; ">
<option>Select Option</option>
<option value="Quarterly">Quarterly</option>
<option value="Yearly">Yearly</option>
</select></td>
<td>Target Quarterly/Yearly:</td><td><input type="text" name="Q/Y" placeholder="QTR=1-2023,YR(2023-24)" style="width: 180px; height: 20px ">
</tr>
<tr>
<td>Target:</td><td><input type="text" name="target" placeholder="Exa:- 2000" style="width: 180px; height: 20px "></td>
<td>Select ASM:</td><td><select name="id" style="width: 183px; height: 28px; ">
<option>Select name</option>
<%
HttpSession session1=request.getSession();
String id=(String)session1.getAttribute("id");
 ShreePharmaDao sp=new ShreePharmaDaoImp();
ShreePharmaDto s=null;
 List<ShreePharmaDto> l=sp.searchASMByRole("ASM");
 Iterator it=l.iterator();
 while(it.hasNext())
 {
	 s=(ShreePharmaDto)it.next();
%>
<option value="<%= s.getUser_id() %>"><%= s.getFirst_name()+" "+s.getLast_name() %></option>
<%
 }
%>
</select></td>
</tr>
<tr>
<td colspan="4" align="center" style="height: 56px; "><Button style="width: 75px; height: 35px; ">Submit</Button></td>
</tr>
</table>
</form>
<table style="width: 1029px; " align="center">
<tr style="height: 41px; background: linear-gradient(0deg, rgba(34,193,195,1) 0%, rgba(253,187,45,1) 100%); color: white; width: 839px">
<td colspan="6" align="center"><h2>Recent Target</h2></td>
<td align="center"><a href="/Shree_Pharma/GM_Page.jsp?id=<%= id %>"><button  style="background-color: white;">Home</button></a>
</tr>
<tr style=" background: radial-gradient(circle, rgba(63,94,251,1) 0%, rgba(252,70,107,1) 100%); color: white;">
<th>Target ID</th><th>Target Mode</th><th>Target Year</th><th style="width: 137px; ">Target</th><th>ASM Name</th><th colspan="2"></th>
</tr>
<%
ASMTargetDao at=new ASMTargetDaoImp();
List<ASMTargetDto> l1=at.viewASMTargetData();

Iterator<ASMTargetDto> itr=l1.iterator();
while(itr.hasNext())
{
	ASMTargetDto a=(ASMTargetDto)itr.next();
	ShreePharmaDao sp1=new ShreePharmaDaoImp();
	ShreePharmaDto s1=sp1.searchEmployeeData(a.getAsm_id());
	
	HttpSession session3=request.getSession();
	session3.setAttribute("ASMname", s1.getFirst_name()+" "+s1.getLast_name());
	session3.setAttribute("tmail", s1.getEmail_id());
	
%>
<tr>
<td align="center"><%= a.getTarget_id() %></td><td align="center"><%= a.getTarget_mode() %></td><td align="center"><%= a.getTarget_qtr_yr() %></td>
<td align="center"><%= a.getTarget() %></td><td align="center"><%= s1.getFirst_name()+" "+s1.getLast_name() %></td>
<td colspan="2" align="center"><a href="/Shree_Pharma/deleteTarget?id=<%=a.getTarget_id() %>"><button>Delete</button></a></td>
</tr>
<%
}
%>
</table>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>