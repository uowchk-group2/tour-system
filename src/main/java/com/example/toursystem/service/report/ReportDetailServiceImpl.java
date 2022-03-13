package com.example.toursystem.service.report;

import com.example.toursystem.dao.report.ReportDetailDAOService;
import com.example.toursystem.entity.report.ReportDetail;

import java.util.List;

public class ReportDetailServiceImpl implements ReportDetailService{

    private ReportDetailDAOService reportDetailDAOService;

    public ReportDetailServiceImpl(ReportDetailDAOService reportDetailDAOService) {
        this.reportDetailDAOService = reportDetailDAOService;
    }

    @Override
    public void savereportDetail(ReportDetail reportDetail) {
        reportDetailDAOService.saveReportDetail(reportDetail);
    }

    @Override
    public List<ReportDetail> getReportDetailByReportId(int id) {

         return reportDetailDAOService.getReportDetailByReportId(id);
    }
}

