package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.sp.dao.*;
import com.sp.dto.ASMTargetDto;
import com.sp.otp.SendResponseMail;

public class AssignASMTargetServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String tmode=request.getParameter("tm");
		String t_Qy=request.getParameter("Q/Y");
		String target=request.getParameter("target");
		int ASM_ID=Integer.parseInt(request.getParameter("id"));
		
		HttpSession session4=request.getSession();
		String name=(String)session4.getAttribute("ASMname");
		String to=(String)session4.getAttribute("tmail");
		
		ASMTargetDto a=new ASMTargetDto();
		a.setTarget_mode(tmode);
		a.setTarget_qtr_yr(t_Qy);
		a.setTarget(target);
		a.setAsm_id(ASM_ID);
		ASMTargetDao at=new ASMTargetDaoImp();
		int r=at.assignTargetToASM(a);
		if(r>0)
		{
			System.out.println("Target Upload");
			String msg="Hello "+name+",\nGeneral Manager assign you new target.Your "+tmode+"("+t_Qy+") target is Rs."+target+"."
					+ "Please complete the Target on time.\n\n\n\nShree Pharma\n45,Teen Imli,Indore";
			SendResponseMail srm=new SendResponseMail();
			srm.SendMail(to, name, msg);
			response.sendRedirect("/Shree_Pharma/ASM_Target.jsp");
		}
		else {
			System.out.println("Failed");
		}
	}

}
