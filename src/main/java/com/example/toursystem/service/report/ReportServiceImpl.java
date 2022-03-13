package com.example.toursystem.service.report;

import com.example.toursystem.dao.report.ReportDAOService;
import com.example.toursystem.entity.report.Report;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReportServiceImpl implements ReportService {

    private ReportDAOService reportDAOService;

    @Autowired
    public ReportServiceImpl(ReportDAOService reportDAOService) {

        this.reportDAOService = reportDAOService;

    }

    @Override
    public void saveReport(Report report) {

    }

    @Override
    public List<Report> getReportsByTouristUsername(String username) {

        return reportDAOService.getReportsByTouristUsername(username);

    }

    @Override
    public List<Report> getReportsByHostUsername(String username) {

        return reportDAOService.getReportsByHostUsername(username);

    }

    @Override
    public Report getReportById(int id) {

        return reportDAOService.getReportById(id);

    }
}
