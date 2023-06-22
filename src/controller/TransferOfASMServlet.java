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

public class TransferOfASMServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int AreaID=Integer.parseInt(request.getParameter("aid"));
		int ASMid=Integer.parseInt(request.getParameter("NewASM"));
		AreaAllotmentDto a=new AreaAllotmentDto();
		a.setArea_id(AreaID);
		a.setAsm_id(ASMid);
		
		ShreePharmaDao sp=new ShreePharmaDaoImp();
		ShreePharmaDto s=sp.searchEmployeeData(ASMid);
		String name=s.getFirst_name()+" "+s.getLast_name();
		String to=s.getEmail_id();
		
		AreaTableDao at=new AreaTableDaoImp();
		AreaTableDto a1=at.getAreaByID(AreaID);
		String area=a1.getArea_name();
		
		AreaAllotmentDao ad=new AreaAllotmentDaoImp();
	    int r=ad.TransferOfASM(a);
	    if(r>0)
	    {
	    	System.out.println("Transfered successfully");
	    	String msg="Hello "+name+",\nOur General Manager has transfered you in "+area+". "
					+ "We have hope,You will join New Area soon.\n\n\nShree Pharma\n45,Teen Imli,Indore";
			SendResponseMail srm=new SendResponseMail();
			srm.SendMail(to, name, msg);
	    	response.sendRedirect("/Shree_Pharma/AreaAllotmentToASMTable.jsp");
	    }
	    else {
	    	out.println("Failed");
	    }
	}

}
