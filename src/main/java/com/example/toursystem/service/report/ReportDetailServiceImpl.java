package com.example.toursystem.service.report;

import com.example.toursystem.dao.report.ReportDetailDAOService;
import com.example.toursystem.entity.report.ReportDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportDetailServiceImpl implements ReportDetailService {

    private ReportDetailDAOService reportDetailDAOService;

    @Autowired
    public ReportDetailServiceImpl(ReportDetailDAOService reportDetailDAOService) {
        this.reportDetailDAOService = reportDetailDAOService;
    }

    @Override
    public void saveReportDetail(ReportDetail reportDetail) {
        reportDetailDAOService.saveReportDetail(reportDetail);
    }

    @Override
    public List<ReportDetail> getReportDetailByReportId(int id) {

        return reportDetailDAOService.getReportDetailByReportId(id);
    }
}

