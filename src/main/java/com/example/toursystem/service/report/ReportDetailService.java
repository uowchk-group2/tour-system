package com.example.toursystem.service.report;

import com.example.toursystem.entity.report.ReportDetail;

import java.util.List;

public interface ReportDetailService {

    void saveReportDetail(ReportDetail reportDetail);

    public List<ReportDetail> getReportDetailByReportId(int id);


}
