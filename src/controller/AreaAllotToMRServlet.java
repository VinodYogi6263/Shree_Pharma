package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.sp.dao.AreaTableDao;
import com.sp.dao.AreaTableDaoImp;
import com.sp.dao.CityAllotmentDao;
import com.sp.dao.CityAllotmentDaoImp;
import com.sp.dao.CityTableDao;
import com.sp.dao.CityTableDaoImp;
import com.sp.dao.ShreePharmaDao;
import com.sp.dao.ShreePharmaDaoImp;
import com.sp.dto.AreaTableDto;
import com.sp.dto.CityAllotmentDto;
import com.sp.dto.CityTableDto;
import com.sp.dto.ShreePharmaDto;
import com.sp.otp.SendResponseMail;

public class AreaAllotToMRServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int mrid=Integer.parseInt(request.getParameter("MRid"));
		int cid=Integer.parseInt(request.getParameter("cid"));
		
		ShreePharmaDao sp=new ShreePharmaDaoImp();
		ShreePharmaDto s=sp.searchEmployeeData(mrid);
		String name=s.getFirst_name()+" "+s.getLast_name();
		String to=s.getEmail_id();
		
		CityTableDao ct=new CityTableDaoImp();
		CityTableDto c=ct.getCityById(cid);
		String city=c.getCity_name();
		
		HttpSession session6=request.getSession();
		String aid=(String)session6.getAttribute("areaID");
		int AreaId=Integer.parseInt(aid);
		
		AreaTableDao at=new AreaTableDaoImp();
		AreaTableDto a1=at.getAreaByID(AreaId);
		String area=a1.getArea_name();
		
		CityAllotmentDto a=new CityAllotmentDto();
		a.setMr_id(mrid);
		a.setCity_id(cid);
		a.setAreaid(AreaId);
		
		CityAllotmentDao ca=new CityAllotmentDaoImp();
		int r=ca.CityAllotToMR(a);
		if(r>0)
		{
			System.out.println("City Alloted to MR");
			String msg="Hello "+name+",\nWe have selected you for the post of MR in "+city+"."
					+ "You will work under the Area of "+area+" in city "+city+". Your area ASM will contact "
				    + "you soon We have hope,You will join your post & City soon.\n\n\nShree Pharma\n45,Teen Imli,Indore";
			SendResponseMail srm=new SendResponseMail();
			srm.SendMail(to, name, msg);
			response.sendRedirect("/Shree_Pharma/AreaAllotmentToMRTable.jsp?aid="+AreaId);
		}
	}

}
