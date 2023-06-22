package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.sp.dao.*;
import com.sp.dto.AreaTableDto;

public class AddNewAreaTableServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int Aid=Integer.parseInt(request.getParameter("aid"));
		String Aname=request.getParameter("aname");
		
		AreaTableDto a=new AreaTableDto();
		a.setArea_id(Aid);
		a.setArea_name(Aname);
		
		AreaTableDao at=new AreaTableDaoImp();
		int r=at.addNewArea(a);
		if(r>0)
		{
			System.out.println("New Area Submitted");
	        response.sendRedirect("/Shree_Pharma/AreaTable.jsp");
		}
		else {
			System.out.println("Failed");
		}
	}

}
