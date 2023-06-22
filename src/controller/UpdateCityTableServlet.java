package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.sp.dao.CityTableDao;
import com.sp.dao.CityTableDaoImp;
import com.sp.dto.CityTableDto;

public class UpdateCityTableServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int CityId=Integer.parseInt(request.getParameter("cid"));
		String CityName=request.getParameter("cname");
		
		CityTableDto c=new CityTableDto();
		c.setCity_id(CityId);
		c.setCity_name(CityName);
		
		CityTableDao ct=new CityTableDaoImp();
		int r=ct.updateCityNameById(c);
		
		if(r>0)
		{
			System.out.println("City Name Updated");
			c=ct.getCityById(CityId);
			
			response.sendRedirect("/Shree_Pharma/CityTable.jsp?id="+c.getAreaid());
		}
		else {
			out.println("Failed");
		}
	}

}
