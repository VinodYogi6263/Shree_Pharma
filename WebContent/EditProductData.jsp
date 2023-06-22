<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.sp.dto.* ,com.sp.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="Stylesheet" href="EditProductData.css">
</head>
<body>
<form action="/Shree_Pharma/update">
<jsp:include page="Header.jsp"></jsp:include>
<p><br></p>
<%
String Id=request.getParameter("id");
 ProductDataDto p=new ProductDataDto();
 ProductDataDao pd=new ProductDataDaoImp();
 p=pd.getProductData(Id);
%>
<div class="table">
<div class="card">
<div class="side">
<table style="width: 329px; height: 531px">
<tr>
<th colspan="2">Update Product Details</th>
</tr>
<tr>
<td>Product ID:</td><td><input type="text" name="ID" value="<%= p.getProduct_id() %>" readonly></td>
</tr>
<tr>
<td style="width: 200px; ">Product Name:</td><td><input type="text" name="name" value="<%= p.getProduct_name() %>"></td>
</tr>
<tr>
<td>Brand Name:</td><td><input type="text" name="bn" value="<%= p.getBrand_name() %>"></td>
</tr>
<tr>
<td>Formula:</td><td><input type="text" name="f" value="<%= p.getFormula() %>"></td>
</tr>
<tr>
<td>Product Form:</td><td><input type="text" name="pf" value="<%= p.getProduct_form() %>" ></td>
</tr>
<tr>
<td>Category:</td><td><input type="text" name="c" value="<%= p.getCategory() %>" ></td>
</tr>
<tr>
<td>Price:</td><td><input type="text" name="p" value="<%= p.getPrice() %>" ></td>
</tr>
<tr>
<td>Quantity:</td><td><input type="text" name="q" value="<%= p.getQuantity() %>" ></td>
</tr>
<tr>
<td colspan="2" align="center" style="height: 73px; "><button style="width: 82px; height: 37px; ">Update</button></td>
</tr>
</table>
</div>
<div class="main">
<img alt="medicine_img" src="T:\Eclipse_Data\Shree_Pharma\WebContent\Image\medicine_img.jpg" style="width: 1035px; height: 609px" align="right">
</div>
</div>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</form>
</body>
</html>