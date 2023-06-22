package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.sp.dao.CityTableDao;
import com.sp.dao.CityTableDaoImp;
import com.sp.dto.CityTableDto;

public class DeleteCityFromCityTableByIdServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int cid=Integer.parseInt(request.getParameter("id"));
		
		CityTableDao ct=new CityTableDaoImp();
		CityTableDto c=new CityTableDto();
		c=ct.getCityById(cid);
		
		int r=ct.deleteCityFromCityTable(cid);
		if(r>0)
		{
			System.out.println("City Deleted");			
			response.sendRedirect("/Shree_Pharma/CityTable.jsp?id="+c.getAreaid());
		}
		else {
			System.out.println("Failed");
		}
	}

}
