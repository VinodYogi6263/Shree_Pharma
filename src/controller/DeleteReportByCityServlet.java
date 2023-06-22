package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.sp.dao.ReportDao;
import com.sp.dao.ReportDaoImp;
import com.sp.dto.ReportDto;

public class DeleteReportByCityServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int rid=Integer.parseInt(request.getParameter("id"));
		
		ReportDao rd=new ReportDaoImp();
		ReportDto r1=rd.viewReportByReportID(rid);
		
		int r=rd.deleteMrReport(rid);
		if(r>0)
		{
			System.out.println("Report Deleted");
			response.sendRedirect("/Shree_Pharma/ViewReportListByCity.jsp?Cid="+r1.getCity_id());
		}
		else {
			out.println("Failed");
		}
	}

}
