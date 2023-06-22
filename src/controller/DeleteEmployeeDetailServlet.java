package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.sp.dao.ShreePharmaDao;
import com.sp.dao.ShreePharmaDaoImp;
import com.sp.dto.ShreePharmaDto;

public class DeleteEmployeeDetailServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int Id=Integer.parseInt(request.getParameter("id"));
		
		ShreePharmaDao sp=new ShreePharmaDaoImp();
		int r=sp.deleteNewRegistration(Id);
		if(r>0)
		{
			System.out.println("Candidate detail deleted");
			response.sendRedirect("/Shree_Pharma/PendingRegistration.jsp");
		}
		
		else {
			System.out.println("Failed");
		}
	}

}
