<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.sp.dao.*,com.sp.dto.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">
<jsp:include page="Header.jsp"></jsp:include>
<br><br><br><br><br><br>
<form action="/Shree_Pharma/areaallottoASM">
<table align="center" style="height: 167px; width: 711px">
<tr>
<td colspan="5" style="height: 41px; background: linear-gradient(90deg, #00C9FF 0%, #92FE9D 100%); color: white; "><h2 align="center">Assign Area to ASM</h2></td>
</tr>
<tr>
<td style="width: 95px; ">Area Name:</td><td style="width: 221px; "><select name="Aid" style="width: 183px; height: 28px; ">
<option>Select Area</option>
<%
AreaTableDao at=new AreaTableDaoImp();
List<AreaTableDto> l=at.viewAreaTable();
Iterator<AreaTableDto> it=l.iterator();
while(it.hasNext())
{
	AreaTableDto a=(AreaTableDto)it.next();
%>
<option value="<%= a.getArea_id() %>"><%= a.getArea_name() %></option>
<%
}
%>
</select></td>
<td style="width: 108px; ">ASM Name:</td><td><select name="ASMid" style="width: 183px; height: 28px; ">
<option>Select ASM</option>
<%
 ShreePharmaDao sp=new ShreePharmaDaoImp();
 List<ShreePharmaDto> l1=sp.searchASMByRole("ASM");
 Iterator<ShreePharmaDto> it1=l1.iterator();
 while(it1.hasNext())
 {
	 ShreePharmaDto s=(ShreePharmaDto)it1.next();
%>
<option value="<%= s.getUser_id() %>"><%= s.getFirst_name()+" "+s.getLast_name() %></option>
<%
}
%>
</select></td>
<td colspan="4" align="center"><button>Submit</button></td>
</tr>
</table>
</form>
<form action="/Shree_Pharma/AreaAllotmentToMRTable.jsp">
<table align="center" style="height: 167px; width: 711px">
<tr>
<td colspan="5" style="height: 41px; background: linear-gradient(90deg, #00C9FF 0%, #92FE9D 100%); color: white; "><h2 align="center">Assign City to MR</h2></td>
</tr> 
<tr>
<td style="width: 155px; ">Select Area:</td><td><select name="aid" style="width: 400px; height: 28px; ">
<option>Area Name</option>
<%
Iterator<AreaTableDto> it2=l.iterator();
while(it2.hasNext())
{
AreaTableDto atd=(AreaTableDto)it2.next();
%>
<option value="<%= atd.getArea_id() %>"><%= atd.getArea_name() %></option>
<%
}
%>
</select></td>
<td><button>Go</button></td>
</tr>
</table>
</form>
<table style="width: 100%; ">
<tr>
<h2 style="background: linear-gradient(to right, rgba(106,133,182,1), rgba(186,200,224,1)); color: white; height: 30px;">Area Alloted to ASM</h2>
</tr>
<tr align="center" style="background: linear-gradient(to right, rgba(250,112,154,1), rgba(254,225,64,1)); height: 41px; color: white ">
<th>Area ID</th><th>Area Name</th><th>ASM ID</th><th>ASM Name</th><th colspan="2"></th>
</tr>
<%
 AreaAllotmentDao aa=new AreaAllotmentDaoImp();
List<AreaAllotmentDto> l2=aa.getAllAreaAndASMId();
Iterator<AreaAllotmentDto> itr1=l2.iterator();
while(itr1.hasNext())
{
	AreaAllotmentDto ad=(AreaAllotmentDto)itr1.next();
	
	AreaTableDao at1=new AreaTableDaoImp();
	AreaTableDto a1=at1.getAreaByID(ad.getArea_id());
	
	ShreePharmaDao sp1=new ShreePharmaDaoImp();
	ShreePharmaDto s=sp1.searchEmployeeData(ad.getAsm_id());
%>
<tr>
<td align="center"><%= a1.getArea_id() %></td><td align="center"><%= a1.getArea_name() %></td>
<td align="center"><%= s.getUser_id() %></td><td align="center"><%= s.getFirst_name()+" "+ s.getLast_name()%></td>
<td align="center"><a href="ASMTransfer.jsp?aid=<%= a1.getArea_id() %>&ASMid=<%= s.getUser_id() %>"><button>Change</button></a></td>
<td align="center"><a href="/Shree_Pharma/removeASM?id=<%=a1.getArea_id() %>&ASMid=<%= s.getUser_id() %>"><button style="background-color: red;">Delete</button></a></td>
</tr>
<%
 }
%>
</table>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>