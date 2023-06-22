package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.sp.dao.CityAllotmentDao;
import com.sp.dao.CityAllotmentDaoImp;
import com.sp.dao.CityTableDao;
import com.sp.dao.CityTableDaoImp;
import com.sp.dao.ShreePharmaDao;
import com.sp.dao.ShreePharmaDaoImp;
import com.sp.dto.CityAllotmentDto;
import com.sp.dto.CityTableDto;
import com.sp.dto.ShreePharmaDto;
import com.sp.otp.SendResponseMail;

public class TransferOfMRServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int CityId=Integer.parseInt(request.getParameter("cid"));
		int MRid=Integer.parseInt(request.getParameter("NewMR"));
		
		CityTableDao ctd=new CityTableDaoImp();
		CityTableDto c1=ctd.getCityById(CityId);
		int Aid=c1.getAreaid();
		String city=c1.getCity_name();
		
		ShreePharmaDao sp=new ShreePharmaDaoImp();
		ShreePharmaDto s=sp.searchEmployeeData(MRid);
		String name=s.getFirst_name()+" "+s.getLast_name();
		String to=s.getEmail_id();
		
		CityAllotmentDto c=new CityAllotmentDto();
		c.setMr_id(MRid);
		c.setCity_id(CityId);
		
		CityAllotmentDao ca=new CityAllotmentDaoImp();
		int r=ca.transferOfMR(c);
		if(r>0)
		{
			System.out.println("MR Transfer Successfully");
			String msg="Hello "+name+",\nOur General Manager has transfered you in "+city+" City."
					+ "We have hope,You will join City soon.\n\n\nShree Pharma\n45,Teen Imli,Indore";
			SendResponseMail srm=new SendResponseMail();
			srm.SendMail(to, name, msg);
			response.sendRedirect("/Shree_Pharma/AreaAllotmentToMRTable.jsp?aid="+Aid);
		}
		else {
			out.println("Failed");
		}
		
	}

}
