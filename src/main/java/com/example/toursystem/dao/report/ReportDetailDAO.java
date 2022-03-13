package com.example.toursystem.dao.report;

import com.example.toursystem.entity.report.Report;
import com.example.toursystem.entity.report.ReportDetail;

import java.util.List;

public interface ReportDetailDAO {

    public void saveReportDetail(ReportDetail reportDetail);

    public List<ReportDetail> getReportDetailByReportId(int id);

}
