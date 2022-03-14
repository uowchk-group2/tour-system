package com.example.toursystem.service.report;

import com.example.toursystem.dao.report.ReportDAOService;
import com.example.toursystem.entity.report.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private ReportDAOService reportDAOService;

    @Autowired
    public ReportServiceImpl(ReportDAOService reportDAOService) {

        this.reportDAOService = reportDAOService;

    }

    @Override
    @Transactional
    public List<Report> getAllReports() {
        return reportDAOService.getAllReports();
    }

    @Override
    @Transactional
    public void saveReport(Report report) {
        reportDAOService.saveReport(report);
    }

    @Override
    @Transactional
    public List<Report> getReportsByTouristUsername(String username) {

        return reportDAOService.getReportsByTouristUsername(username);

    }

    @Override
    @Transactional
    public List<Report> getReportsByHostUsername(String username) {

        return reportDAOService.getReportsByHostUsername(username);

    }

    @Override
    @Transactional
    public Report getReportById(int id) {

        return reportDAOService.getReportById(id);

    }
}
