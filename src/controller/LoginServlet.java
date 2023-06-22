package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;
import com.sp.dao.ShreePharmaDao;
import com.sp.dao.ShreePharmaDaoImp;
import com.sp.dto.ShreePharmaDto;

public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		String Password=request.getParameter("pass");
			
		ShreePharmaDao sp = new ShreePharmaDaoImp();
		
		
     try { 
    	 ShreePharmaDto s=sp.checkLogin(id, Password);
		  if(!s.equals(null))
		  {
			  String ID=Integer.toString(s.getUser_id());
		    HttpSession session=request.getSession();
		    session.setAttribute("id", ID);
		    session.setAttribute("name", s.getFirst_name()+" "+s.getLast_name());
		    session.setAttribute("role", s.getRole());
		    session.setAttribute("status", s.getStatus());
		
		    if((s.getStatus()).equals("Active"))
		     {
		       if(s.getRole().equals("GM"))
		   	     {
				   response.sendRedirect("/Shree_Pharma/GM_Page.jsp");
			     }
			   if(s.getRole().equals("ASM"))
			     {
				   response.sendRedirect("/Shree_Pharma/ASM_Page.jsp");
			     }
			   if(s.getRole().equals("MR"))
			    {
			   	  response.sendRedirect("/Shree_Pharma/MR_Page.jsp");
			    }
		     }
		   else {
			   out.println("Sorry you are InActive Employee");
		      }
		
           }
         }
          catch(NullPointerException e)
            {
	          response.sendRedirect("/Shree_Pharma/EmployeeLogin01.jsp");
            }
		
	}

}
