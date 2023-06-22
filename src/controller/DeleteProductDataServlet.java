package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.sp.dao.ProductDataDao;
import com.sp.dao.ProductDataDaoImp;
import com.sp.dto.ProductDataDto;

public class DeleteProductDataServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String Id=request.getParameter("id");
		ProductDataDto p=new ProductDataDto();
		p.setProduct_id(Id);
		
		ProductDataDao pd=new ProductDataDaoImp();
		int r=pd.deleteProductData(p);
		if(r>0)
		{
			System.out.println("Row Deleted");
			response.sendRedirect("/Shree_Pharma/ProductData.jsp");
		}
		else {
			out.println("failed");
		}
		

		
		
	}

}
