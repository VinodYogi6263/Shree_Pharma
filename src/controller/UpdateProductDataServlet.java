package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.sp.dao.ProductDataDao;
import com.sp.dao.ProductDataDaoImp;
import com.sp.dto.ProductDataDto;

public class UpdateProductDataServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String P_id=request.getParameter("ID");
		String Name=request.getParameter("name");
		String Bname=request.getParameter("bn");
		String formula=request.getParameter("f");
		String Pform=request.getParameter("pf");
		String Categoey=request.getParameter("c");
		Double Price=Double.parseDouble(request.getParameter("p"));
		int Quantity=Integer.parseInt(request.getParameter("q"));
		
		ProductDataDto p=new ProductDataDto();
		p.setProduct_id(P_id);
		p.setProduct_name(Name);
		p.setBrand_name(Bname);
		p.setFormula(Pform);
		p.setProduct_form(Pform);
		p.setCategory(Categoey);
		p.setPrice(Price);
		p.setQuantity(Quantity);
		
		ProductDataDao pd=new ProductDataDaoImp();
		int r=pd.updateProductData(p);
		if(r>0)
		{
			System.out.println("Data Updated");
			response.sendRedirect("/Shree_Pharma/ProductData.jsp");
		}
		else {
			out.println("Failed");
		}
	}
}
