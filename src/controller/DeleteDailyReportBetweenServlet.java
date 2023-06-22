package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.sp.dao.ReportDao;
import com.sp.dao.ReportDaoImp;

public class DeleteDailyReportBetweenServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int rid=Integer.parseInt(request.getParameter("id"));
		HttpSession session7=request.getSession();
		String from=(String)session7.getAttribute("d1");
		String to=(String)session7.getAttribute("d2");
		
		ReportDao rd=new ReportDaoImp();
		int r=rd.deleteMrReport(rid);
		if(r>0)
		{
			System.out.println("Report Deleted");
			response.sendRedirect("/Shree_Pharma/ViewReportByDateBetween.jsp?d1="+from+"&d2="+to);
		}
		else {
			out.println("Failed");
		}
	}

}
