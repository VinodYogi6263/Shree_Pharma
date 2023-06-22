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
import com.sp.dto.CityTableDto;
import com.sp.dto.ShreePharmaDto;
import com.sp.otp.SendResponseMail;

public class RemoveMRFromAreaServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int AreaId=Integer.parseInt(request.getParameter("aid"));
		int CityId=Integer.parseInt(request.getParameter("cid"));
		int MRid=Integer.parseInt(request.getParameter("MRid"));
		
		CityTableDao ct=new CityTableDaoImp();
		CityTableDto c=ct.getCityById(CityId);
		String city=c.getCity_name();
		
		ShreePharmaDao sp=new ShreePharmaDaoImp();
		ShreePharmaDto s=sp.searchEmployeeData(MRid);
		String name=s.getFirst_name()+" "+s.getLast_name();
		String to=s.getEmail_id();
		
		CityAllotmentDao ca=new CityAllotmentDaoImp();
		int r=ca.removeMRFromCityByMrID(MRid);
		if(r>0)
		{
			System.out.println("City Deleted");
			String msg="Hello "+name+",\nWe are sorry to inform you that you are terminated from "
					+city+" City. Due to your bad performance. From now your are on the bench.Your ASM "
					+ "will contact you soon.\n\n\n\nShree Pharma\n45,Teen Imli,Indore";
			SendResponseMail srm=new SendResponseMail();
			srm.SendMail(to, name, msg);
			response.sendRedirect("/Shree_Pharma/AreaAllotmentToMRTable.jsp?aid="+AreaId);
		}
		else {
			out.println("Failed");
		}
	}

}
