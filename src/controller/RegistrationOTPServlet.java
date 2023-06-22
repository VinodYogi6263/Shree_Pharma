package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.sp.dao.ShreePharmaDao;
import com.sp.dao.ShreePharmaDaoImp;
import com.sp.dto.ShreePharmaDto;

public class RegistrationOTPServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String otp=request.getParameter("code");
		HttpSession session=request.getSession();
		String c=(String)session.getAttribute("C1");
		ShreePharmaDto s=(ShreePharmaDto)session.getAttribute("S1");
		
		if(otp.equals(c))
		{
			
			int r=0;
			ShreePharmaDao sp=new ShreePharmaDaoImp();
			r=sp.employeeRegistration(s);
			if(r>0)
			{
			  System.out.println("Employee Registration Completed");
			  response.sendRedirect("/Shree_Pharma/Thankyou.jsp");
			}
			else
			{
			  out.println("Failed");
			}
		}
	}

}
