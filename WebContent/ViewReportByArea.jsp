<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.sp.dto.*,com.sp.dao.*, java.util.Iterator, java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="ViewReportByArea.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<br><br><br>
<%
int Aid=Integer.parseInt(request.getParameter("aid"));
AreaAllotmentDaoImp aad=new AreaAllotmentDaoImp();
AreaAllotmentDto aa=aad.searchEmpByAreaID(Aid);

ShreePharmaDao sp=new ShreePharmaDaoImp();
ShreePharmaDto s=sp.searchEmployeeData(aa.getAsm_id());
%>
<div class="design">
<div class="card">
<div class="row">
<div class="left-side">
<img class="card-img-left example-card-img-responsive" src="T:\Eclipse_Data\Shree_Pharma\WebContent\Image\employee.png" style="width: 218px; height: 220px; "/>
</div>
<div class="middle">
<h2><%= s.getUser_id()+","+s.getFirst_name()+" "+s.getLast_name() %></h2>
<p><b>Status: <%=s.getStatus() %></b></p>
<p>Rating:</p>
<%
ASMTargetDao atd1=new ASMTargetDaoImp();
try{
ASMTargetDto at1=atd1.searchTargetByASMID(aa.getAsm_id());

String str1 = at1.getTarget() ;
str1 = str1.replace(",","");
int target1=Integer.parseInt(str1);

CityAllotmentDao cad1=new CityAllotmentDaoImp();
int sum=0;
List<CityAllotmentDto> l1=cad1.ShowMRListByAreaID(aa.getArea_id());
Iterator<CityAllotmentDto> itr1=l1.iterator();
while(itr1.hasNext())
{
	CityAllotmentDto ca=(CityAllotmentDto)itr1.next();
	
	ReportDao rd1=new ReportDaoImp();
	ReportDto r1=rd1.getMaxMRAchReport(ca.getMr_id());
	
	sum=sum+r1.getAchievement();

}
int per=((sum*100)/target1);
%>
 <div class="container">
  <h3>Target: <%= sum %> / <%= at1.getTarget() %> Completed = <%= per %>%</h3>
  <div class="progress">
    <div class="progress-bar" role="progressbar" aria-valuenow="<%= sum %>" aria-valuemin="0" aria-valuemax="<%= at1.getTarget() %>" style="width:<%= per %>%">
      <span class="sr-only">70% Complete</span>
    </div>
  </div>
</div>
</div>
<div  class="right-side">
  
  
</div>
</div>
<%
}
catch(NullPointerException e)
{
	out.println("--");
}
ASMTargetDao atd=new ASMTargetDaoImp();
ASMTargetDto at=atd.searchTargetByASMID(s.getUser_id());
String str = at.getTarget() ;
str = str.replace(",","");
int target=Integer.parseInt(str);
%>
</div>
<br><br><br>
<h3>MR List</h3>
<table>
<tr>
<%
CityAllotmentDao cad=new CityAllotmentDaoImp();
try{
List<CityAllotmentDto> l=cad.ShowMRListByAreaID(aa.getArea_id());
if(l.size()!=0)
{
Iterator<CityAllotmentDto> itr=l.iterator();
while(itr.hasNext())
{
	CityAllotmentDto ca=(CityAllotmentDto)itr.next();
	
	ShreePharmaDto s1=sp.searchEmployeeData(ca.getMr_id());
	
	CityTableDao ctd=new CityTableDaoImp();
	CityTableDto ct=ctd.getCityById(ca.getCity_id());
%>
<td>
 <div class="card1" url="ViewReportListByCity.jsp?Cid=<%= ca.getCity_id() %>">
 <div class="r1">
 <div class="side">
 <img alt="MR" src="T:\Eclipse_Data\Shree_Pharma\WebContent\Image\employee.png" style="width: 128px; height: 131px; ">
 </div>
 <div class="main">
 <h3>City: <%= ct.getCity_name() %></h3>
 <p><b><%= s1.getUser_id()+","+s1.getFirst_name()+" "+s1.getLast_name() %></b></p>
 <p>Status: <%= s1.getStatus() %></p>
 <p>Rating</p>
 </div>
 </div>
 <%
 MRTargetDao mtd=new MRTargetDaoImp();
 MRTargetDto mt=mtd.getMrTargetByMRid(ca.getMr_id());
 
 ReportDao rd=new ReportDaoImp();
 ReportDto r=rd.getMaxMRAchReport(ca.getMr_id());
 %>
 <label for="file">Target:  <%= r.getAchievement() %> / <%= mt.getTarget() %> Completed = <%= (r.getAchievement()*100)/mt.getTarget()%>%</label>	 
<progress id="file" value="<%= r.getAchievement() %>" max="<%= mt.getTarget() %>"> 32% </progress>
 </div></td>
 <%
}
}
else{
	out.println("No MR is here under ASM");
}
}
catch(NullPointerException e)
{
	out.println("0");
}
 %>
 </tr>
 </table>
 </div>
 <script type="text/javascript">
 
	 $(".card1").click(function (){

	 window.location= $(this).attr ("url");

	 });
 </script>
<br><br><br>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>