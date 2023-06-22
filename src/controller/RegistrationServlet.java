package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.sp.dao.ShreePharmaDao;
import com.sp.dao.ShreePharmaDaoImp;
import com.sp.dto.ShreePharmaDto;
import com.sp.otp.CreateOTP;
import com.sp.otp.SendOTPMail;

public class RegistrationServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		try {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String Fname=request.getParameter("fn");
		String Lname=request.getParameter("ln");
		
		String A1=request.getParameter("v/c");
		String A2=request.getParameter("post");
		String A3=request.getParameter("d");
		String A4=request.getParameter("s");
		String A5=request.getParameter("country");
		String A6=request.getParameter("pin");
		String Address=(A1+","+A2+","+A3+","+A4+","+A5+","+A6);
		
		String Contact=request.getParameter("c");
		String email=request.getParameter("e");
		
		String qualification=request.getParameter("q");
		String Experience=request.getParameter("exp");
		
		String Role=request.getParameter("role");
		String Status=request.getParameter("status");
		
		ShreePharmaDto s=new ShreePharmaDto();
		s.setFirst_name(Fname);
		s.setLast_name(Lname);
		s.setAddress(Address);
		s.setContact_number(Contact);
		s.setEmail_id(email);
		s.setQualification(qualification);
		s.setExperience(Experience);
		s.setRole(Role);
		s.setStatus(Status);
		
		CreateOTP c=new CreateOTP();
		String c1=c.generateOTP();
		
		SendOTPMail som=new SendOTPMail();
		som.SendMail(email, Fname, c1);
		
		HttpSession session=request.getSession();
		session.setAttribute("C1", c1);
		session.setAttribute("S1", s);
		session.setAttribute("Tname", (Fname+" "+Lname));
		
		response.sendRedirect("/Shree_Pharma/VerifyRegistrationCode.jsp");
	  }
	catch(NumberFormatException e)
	{
		response.sendRedirect("/Shree_Pharma/registration.jsp");
	}
	}

}
