<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.sp.dao.*,com.sp.dto.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker1" ).datepicker({ dateFormat: 'dd-mm-yy' });
  } );
  $( function() {
    $( "#datepicker2" ).datepicker({ dateFormat: 'dd-mm-yy' });
  } );
  </script>
</head>
<body>
<form action="ViewReportListByDate.jsp">
<jsp:include page="Header.jsp"></jsp:include>
<br><br><br><br>

<table align="center" style="width: 691px; ">
<tr>
<td colspan="5" align="center"><h2>Search Report List By Date</h2></td>
</tr>
<tr>
<td align="right">Enter Date From:</td><td align="center"><input type="text" name="d1" id="datepicker1"></td>
<td>To:</td><td><input type="text" name="d2" id="datepicker2"></td>
<td><input type="submit" value="Search"></td>
</tr>
</table>
</from>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>