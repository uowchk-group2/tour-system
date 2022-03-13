package com.example.toursystem.service.report;

import com.example.toursystem.entity.report.ReportDetail;

import java.util.List;

public interface ReportDetailService {

    public static void saveReportDetail(ReportDetail reportDetail) {

    }

    void savereportDetail(ReportDetail reportDetail);

    public List<ReportDetail> getReportDetailByReportId(int id);


}
