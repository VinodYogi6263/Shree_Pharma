package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.sp.dao.ShreePharmaDao;
import com.sp.dao.ShreePharmaDaoImp;
import com.sp.dto.ShreePharmaDto;

public class ForgetPasswordServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String code=request.getParameter("code");
		
		HttpSession session=request.getSession();
		String OTP=(String)session.getAttribute("OTP");
		String Pass=(String)session.getAttribute("Pass");
		int ID=Integer.parseInt((String)session.getAttribute("Id"));
		
		if(OTP.equals(code))
		{
		ShreePharmaDto s=new ShreePharmaDto();
		s.setUser_id(ID);
		s.setPassword(Pass);
		
		ShreePharmaDao sp=new ShreePharmaDaoImp();
		int r=sp.forgetEmployeePassword(s);
		if(r>0)
		{
			System.out.println("Password changed");
			out.println("<html>");
			out.println("<head>");
			out.println("<title></title>");
			out.println("</head>");
			out.println("<body align="+"center"+">");
			out.println("<table align="+"center"+">");
			out.println("<tr>");
			out.println("<td align="+""+"center"+""+">");
			out.println("<h1>Password Changed<h1>");
			out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td align="+""+"center"+""+">");
			out.println("<a href="+""+"/Shree_Pharma/EmployeeLogin.jsp"+""+">Login</a>");
			out.println("</td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</body>");
		}
		else {
			out.println("Failed");
		}
		}
		else {
			response.sendRedirect("/Shree_Pharma/VerifyForgetCode.jsp");
		}
	}

}
