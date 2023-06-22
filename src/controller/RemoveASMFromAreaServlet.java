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

public class RemoveASMFromAreaServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int Areaid=Integer.parseInt(request.getParameter("id"));
		int asmID=Integer.parseInt(request.getParameter("ASMid"));
		int ASMid=0;
		AreaAllotmentDto a=new AreaAllotmentDto();
		a.setArea_id(Areaid);
		a.setAsm_id(ASMid);
		
		ShreePharmaDao sp=new ShreePharmaDaoImp();
		ShreePharmaDto s=sp.searchEmployeeData(asmID);
		String name=s.getFirst_name()+" "+s.getLast_name();
		String to=s.getEmail_id();
		
		AreaTableDao at=new AreaTableDaoImp();
		AreaTableDto a1=at.getAreaByID(Areaid);
		String area=a1.getArea_name();
		
		AreaAllotmentDao ad=new AreaAllotmentDaoImp();
		int r=ad.removeASMFromArea(a);
		if(r>0)
		{
			System.out.println("ASM Removed");
			String msg="Hello "+name+",\nWe are sorry to inform you that you are terminated from "
					+area+" Area. Due to your bad performance. From now your are on the bench.General Manager "
					+ "will contact you soon.\n\n\n\nShree Pharma\n45,Teen Imli,Indore";
			SendResponseMail srm=new SendResponseMail();
			srm.SendMail(to, name, msg);
			response.sendRedirect("/Shree_Pharma/AreaAllotmentToASMTable.jsp");
		}
		else {
			out.println("Failed");
		}
	}

}
