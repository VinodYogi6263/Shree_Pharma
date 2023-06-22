package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.sp.dao.*;
import com.sp.dto.ProductDataDto;

public class AddNewProductDataServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String Pi=request.getParameter("pid");
		String Pn=request.getParameter("pname");
		String Bn=request.getParameter("bname");
		String Formula=request.getParameter("f");
		String Pf=request.getParameter("pf");
		String Catogery=request.getParameter("c");
		Double Price=Double.parseDouble(request.getParameter("p"));
		int Quantity=Integer.parseInt(request.getParameter("q"));
		
		ProductDataDto p=new ProductDataDto();
		p.setProduct_id(Pi);
		p.setProduct_name(Pn);
		p.setBrand_name(Bn);
		p.setFormula(Formula);
		p.setProduct_form(Pf);
		p.setCategory(Catogery);
		p.setPrice(Price);
		p.setQuantity(Quantity);
		
	    ProductDataDao pd=new ProductDataDaoImp();
	    int r=pd.addProductData(p);
	    if(r>0)
	    {
	    	System.out.println("Product Data Added");
	    	response.sendRedirect("/Shree_Pharma/ProductData.jsp");
	    }
	    else {
	    	System.out.println("Failed");
	    }
		
	}

}
