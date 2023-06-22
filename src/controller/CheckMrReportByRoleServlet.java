package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.sp.dao.ReportDao;
import com.sp.dao.ReportDaoImp;
import com.sp.dto.ReportDto;

public class CheckMrReportByRoleServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession session7=request.getSession();
		int reportID=(Integer)session7.getAttribute("rid");
		String from=(String)session7.getAttribute("d1");
		String to=(String)session7.getAttribute("d2");
		
		String status="Checked";
		String remark=request.getParameter("remark");
		
		ReportDto r=new ReportDto();
		r.setReport_id(reportID);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
		r.setStatus(status);
		r.setRemark(remark);
		
		ReportDao rd=new ReportDaoImp();
		int n=rd.checkMrReport(r);
		if(n>0)
		{
			System.out.println("Report Checked");
			response.sendRedirect("/Shree_Pharma/ViewReportByDateBetween.jsp?d1="+from+"&d2="+to);
		}
		else {
			out.println("Failed");
		}
	}

}
