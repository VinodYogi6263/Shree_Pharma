package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.sp.dao.ShreePharmaDao;
import com.sp.dao.ShreePharmaDaoImp;
import com.sp.dto.ShreePharmaDto;

public class EditEmployeeProfileServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session3=request.getSession();
		int id=Integer.parseInt((String)session3.getAttribute("editID"));
		
		String fname=request.getParameter("fn");
		String lname=request.getParameter("ln");
		String address=request.getParameter("add");
		String contact=request.getParameter("c");
		String email=request.getParameter("e");
		String qualification=request.getParameter("q");
		String Experience=request.getParameter("exp");
		String role=request.getParameter("role");
		String status=request.getParameter("status");
		
		ShreePharmaDto s=new ShreePharmaDto();
		s.setUser_id(id);
		s.setFirst_name(fname);
		s.setLast_name(lname);
		s.setRole(role);
		s.setStatus(status);
		s.setAddress(address);
		s.setContact_number(contact);
		s.setEmail_id(email);
		s.setQualification(qualification);
		s.setExperience(Experience);
		
		ShreePharmaDao sp=new ShreePharmaDaoImp();
		int r=sp.editEmployeeProfile(s);
		if(r>0)
		{
			System.out.println("Profile updated");
			response.sendRedirect("/Shree_Pharma/GM_Page.jsp");
		}
		else {
			out.println("Failed");
		}
	}

}
