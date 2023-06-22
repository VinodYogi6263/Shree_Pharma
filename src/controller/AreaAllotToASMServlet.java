package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.sp.dao.AreaAllotmentDao;
import com.sp.dao.AreaAllotmentDaoImp;
import com.sp.dao.AreaTableDao;
import com.sp.dao.AreaTableDaoImp;
import com.sp.dao.ShreePharmaDao;
import com.sp.dao.ShreePharmaDaoImp;
import com.sp.dto.AreaAllotmentDto;
import com.sp.dto.AreaTableDto;
import com.sp.dto.ShreePharmaDto;
import com.sp.otp.SendResponseMail;

public class AreaAllotToASMServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int aid=Integer.parseInt(request.getParameter("Aid"));
		int uid=Integer.parseInt(request.getParameter("ASMid"));
		
		ShreePharmaDao sp=new ShreePharmaDaoImp();
		ShreePharmaDto s=sp.searchEmployeeData(uid);
		
		String name=s.getFirst_name()+" "+s.getLast_name();
	    String to=s.getEmail_id();
	    
		AreaTableDao at=new AreaTableDaoImp();
		AreaTableDto a=at.getAreaByID(aid);
		
		String Area=a.getArea_name();
		
		AreaAllotmentDto aa=new AreaAllotmentDto();
		aa.setAsm_id(uid);
		aa.setArea_id(aid);
		
		AreaAllotmentDao a1=new AreaAllotmentDaoImp();
		int r=a1.assignAreaToASM(aa);
		if(r>0)
		{
			System.out.println("Area Alloted");
			String msg="Hello "+name+",\nWe have selected you for the post of ASM in "+Area+". "
					+ "We have hope,You will join your post & area soon.\n\n\nShree Pharma\n45,Teen Imli,Indore";
			SendResponseMail srm=new SendResponseMail();
			srm.SendMail(to, name, msg);
			response.sendRedirect("/Shree_Pharma/AreaAllotmentToASMTable.jsp");
		}
		else {
			out.println("Falied");
		}
	}

}
