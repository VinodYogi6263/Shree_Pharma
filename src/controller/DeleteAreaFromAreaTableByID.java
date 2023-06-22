package controller;

import javax.servlet.http.HttpServlet;

import com.sp.dao.AreaTableDao;
import com.sp.dao.AreaTableDaoImp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class DeleteAreaFromAreaTableByID extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int ID=Integer.parseInt(request.getParameter("id"));
		
		AreaTableDao at=new AreaTableDaoImp();
		int a=at.deleteAreaFromAreaTable(ID);
		if(a>0)
		{
			System.out.println("Area Deleted From Table");
			response.sendRedirect("/Shree_Pharma/AreaTable.jsp");
		}
		else {
			System.out.println("Failed");
		}
		
	}

}
