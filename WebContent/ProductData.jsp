<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.sp.dao.*,com.sp.dto.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="Stylesheet" href="ProductData.css" >
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<p><br></p>
<%
ProductDataDao pd=new ProductDataDaoImp();
List<ProductDataDto> l=pd.viewProductData();
%>
<div class="table">
<h3>Product Data</h3>
<a href="AddNewProductData.jsp"><button style="width: 56px; height: 37px; background-color: blue; color: white; ">add</button></a>
<p><br></p>
<div class="card">
<table border="1" cellspacing="0">
<tr>
<th>Product ID</th>
<th>Product Name</th>
<th>Brand Name</th>
<th>Formula</th>
<th>Product Form</th>
<th>Category</th>
<th>Price</th>
<th>Quantity</th>
<th>Button</th>
</tr>
<%
Iterator<ProductDataDto> it=l.iterator();
while(it.hasNext())
{
	ProductDataDto p=it.next();
%>
<tr>
<td><%= p.getProduct_id() %></td>
<td><%= p.getProduct_name() %></td>
<td><%= p.getBrand_name() %></td>
<td><%= p.getFormula() %></td>
<td><%= p.getProduct_form() %></td>
<td><%= p.getCategory() %></td>
<td><%= p.getPrice() %></td>
<td><%= p.getQuantity() %></td>
<td style="width: 15%;"><a style="color: blue;" href="/Shree_Pharma/EditProductData.jsp?id=<%= p.getProduct_id() %>">Edit</a><a style="color: Red;" href="/Shree_Pharma/deleteProduct?id=<%= p.getProduct_id() %>"> Delete</a></td>
</tr>
<%
}
%>
</table>
</div>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>