package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.sp.dao.CityTableDao;
import com.sp.dao.CityTableDaoImp;
import com.sp.dto.CityTableDto;

public class AddNewCityTableServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int AreaId=Integer.parseInt(request.getParameter("aid"));
		String CityName=request.getParameter("cname");
		
		CityTableDto c=new CityTableDto();
		c.setAreaid(AreaId);
		c.setCity_name(CityName);
		
		CityTableDao ct=new CityTableDaoImp();
		int r=ct.addNewCity(c);
		if(r>0)
		{
			System.out.println("New City Added");
			response.sendRedirect("/Shree_Pharma/CityTable.jsp?id="+AreaId);
		}
	}

}
