package com.sp.dao;

import java.util.List;

import com.sp.dto.ReportDto;

public interface ReportDao {
	public List<ReportDto> viewReports();
	public List<ReportDto> viewReportByCity(int id);
	public ReportDto viewReportByReportID(int id);
	public int checkMrReport(ReportDto r);
	public int deleteMrReport(int id);
	public List<ReportDto> checkLimitedReport(String from,String to);
	public ReportDto getReportByCityID(int id);
	public ReportDto getMaxMRAchReport(int id);
}