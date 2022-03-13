package com.example.toursystem.dao.report;

import com.example.toursystem.entity.report.Report;

import java.util.List;

public interface ReportDAO {

    public void saveReport(Report report);

    public List<Report> getAllReports();

    public List<Report> getReportsByTouristUsername(String username);

    public List<Report> getReportsByHostUsername(String username);

    public Report getReportById(int id);


}
