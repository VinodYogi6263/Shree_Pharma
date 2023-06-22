package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.sp.dao.ShreePharmaDao;
import com.sp.dao.ShreePharmaDaoImp;
import com.sp.dto.ShreePharmaDto;
import com.sp.otp.CreateOTP;
import com.sp.otp.SendOTPMail;

public class ForgetOTPServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("id");
		int ID=Integer.parseInt(id);
		String pass=request.getParameter("ps1");
		
		ShreePharmaDto s;
		ShreePharmaDao sp=new ShreePharmaDaoImp();
		s=sp.searchEmployeeData(ID);
		
	    String gmail=s.getEmail_id();
	    String name=(s.getFirst_name()+" "+s.getLast_name());
	    
	    CreateOTP c=new CreateOTP();
	    String otp=c.generateOTP();
	    
	    HttpSession session=request.getSession();
	    session.setAttribute("OTP", otp);
	    session.setAttribute("Pass", pass);
	    session.setAttribute("Id", id);
	    
	    SendOTPMail send=new SendOTPMail();
	    send.SendMail(gmail, name, otp);
	    
	    response.sendRedirect("/Shree_Pharma/VerifyCode.jsp");
	    
	}

}
