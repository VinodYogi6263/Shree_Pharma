package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.sp.dao.*;
import com.sp.dto.AreaTableDto;

public class UpdateAreaTableServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
	   response.setContentType("text/html");
	   PrintWriter out=response.getWriter();
	   
	   int areaid=Integer.parseInt(request.getParameter("aid"));
	   String areaname=request.getParameter("aname");
	   
	   AreaTableDto a=new AreaTableDto();
	   a.setArea_id(areaid);
	   a.setArea_name(areaname);
	   AreaTableDao at=new AreaTableDaoImp();
	   int r=at.updateAreaByAreaID(a);
	   if(r>0)
	   {
		   System.out.println("Area Updated");
		   response.sendRedirect("/Shree_Pharma/AreaTable.jsp");
	   }
	   else
	   {
		   System.out.println("Failed");
	   }
	}

}
