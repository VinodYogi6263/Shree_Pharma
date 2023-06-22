<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<p><br><br><br><br></p>
<%
HttpSession session3=request.getSession();
String name=(String)session3.getAttribute("Tname");
%>
<p>Hello <b><%= name %></b>,<br>Thankyou for showing intrest in our company.We will check your 
details and contact you soon...
 </p>
 <a href="Home.jsp"><button>back to Home</button></a>
 <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>