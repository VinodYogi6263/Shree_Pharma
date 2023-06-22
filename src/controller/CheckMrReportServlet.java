package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.sp.dao.ReportDao;
import com.sp.dao.ReportDaoImp;
import com.sp.dto.ReportDto;

public class CheckMrReportServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int comment=Integer.parseInt(request.getParameter("comment"));
		String Remark=request.getParameter("remark");
		
		HttpSession session7=request.getSession();
		int reportID=(Integer)session7.getAttribute("rid");
		String da1=(String)session7.getAttribute("date1");
		String da2=(String)session7.getAttribute("date2");
		
		String status="Checked";
		
		
		ReportDto r=new ReportDto();
		r.setReport_id(reportID);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
		r.setStatus(status);
		r.setRemark(Remark);
		r.setComment(comment);
		
		ReportDao rd=new ReportDaoImp();
		int n=rd.checkMrReport(r);
		if(n>0)
		{
			System.out.println("Report Checked");
			
			r=rd.viewReportByReportID(reportID);
			response.sendRedirect("/Shree_Pharma/ViewReportListByDate.jsp?d1="+da1+"&d2="+da2);
		}
		else {
			out.println("Failed");
		}
	}

}
