package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.sp.dao.ShreePharmaDao;
import com.sp.dao.ShreePharmaDaoImp;
import com.sp.dto.ShreePharmaDto;
import com.sp.otp.SendResponseMail;

public class ApproveEmployeeRegServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int Eid=Integer.parseInt(request.getParameter("id"));
		String Password=request.getParameter("pass");
		String Role=request.getParameter("role");
		String Status=request.getParameter("status");
		
		//For sending gmail...
		HttpSession session2=request.getSession();
		String EmpName=(String)session2.getAttribute("Ename");
		String EmpID=(String)session2.getAttribute("EID");
		String EmpGmail=(String)session2.getAttribute("Egmail");
		//GM name from GM_Page
		String GMname=(String)session2.getAttribute("name");
		
		ShreePharmaDto s=new ShreePharmaDto();
		s.setUser_id(Eid);
		s.setPassword(Password);
		s.setRole(Role);
		s.setStatus(Status);
		
		ShreePharmaDao sp=new ShreePharmaDaoImp();
		int r=sp.approveEmployeeRegistrationByID(s);
		if(r>0)
		{
			System.out.println("Employee Registered Successfully");
			if(Status.equals("Active"))
			{
			String msg="Hello "+EmpName+",\nThis is "+GMname+", General Manager of Shree Pharma."
					+ " I am very glad to welcoming you in our Company.\nYou are selected for the "
					+ "post of "+Role+",Your Employee ID: "+EmpID+" & Password: "+Password+" . I suggest you"
					+ " Please change your Password and create new one. we will contact you Soon...\n\n\n"
					+ "\nShree Pharma\n45,Teen Imli,Indore";
			SendResponseMail stm=new SendResponseMail();
			stm.SendMail(EmpGmail, EmpName, msg);
			}
			response.sendRedirect("/Shree_Pharma/PendingRegistration.jsp");
		}
		else {
			System.out.println("Failed");
		}
	}

}
