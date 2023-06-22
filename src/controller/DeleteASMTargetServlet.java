package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.sp.dao.ASMTargetDao;
import com.sp.dao.ASMTargetDaoImp;
import com.sp.dto.ASMTargetDto;
import com.sp.otp.SendResponseMail;

public class DeleteASMTargetServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		HttpSession session3=request.getSession();
		String name=(String)session3.getAttribute("ASMname");
		String to=(String)session3.getAttribute("tmail");
		
		ASMTargetDao at=new ASMTargetDaoImp();
		int r=at.deleteASMTarget(id);
		if(r>0)
		{
			System.out.println("Target deleted");
			String msg="Hello "+name+",\nYour target has been withdraw by General Manager.We will give you new target soon...\n\n\n"
					+ "Shree Pharma\n45,Teen Imli,Indore";
			SendResponseMail srm=new SendResponseMail();
			srm.SendMail(to, name, msg);
			response.sendRedirect("/Shree_Pharma/ASM_Target.jsp");
		}
		else {
			System.out.println("Failed");
		}
	}

}
