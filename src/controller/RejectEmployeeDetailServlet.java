package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.sp.dao.ShreePharmaDao;
import com.sp.dao.ShreePharmaDaoImp;
import com.sp.dto.ShreePharmaDto;
import com.sp.otp.SendResponseMail;

public class RejectEmployeeDetailServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int Id=Integer.parseInt(request.getParameter("id"));
		
		ShreePharmaDao sp=new ShreePharmaDaoImp();
		ShreePharmaDto s=sp.searchEmployeeData(Id);
	    String name=(s.getFirst_name()+" "+s.getLast_name());
	    String gmail=s.getEmail_id();
	    String role=s.getRole();
		
		
		int r=sp.deleteNewRegistration(Id);
		if(r>0)
		{
			System.out.println("Candidate detail deleted");
			
			String msg="Hello "+name+",\nYou are not selected for "+role+" Post. Thankyou for visiting our company.\n\n\n"
					+ "Shree Pharma\n45,Teen Imli,Indore";
			SendResponseMail stm=new SendResponseMail();
			stm.SendMail(gmail, name, msg);
			
			response.sendRedirect("/Shree_Pharma/PendingRegistration.jsp");
		}
		
		else {
			System.out.println("Failed");
		}
	}

}
