package com.example.toursystem.controller.api;

import com.example.toursystem.dao.report.ReportDAOService;
import com.example.toursystem.entity.report.Report;
import com.example.toursystem.entity.report.ReportDetail;
import com.example.toursystem.service.report.ReportDetailService;
import com.example.toursystem.service.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/report")
public class ReportAPIController {

    private ReportService reportService;
    private ReportDetailService reportDetailService;

    @Autowired
    public ReportAPIController(ReportService reportService, ReportDetailService reportDetailService) {
        this.reportService = reportService;
        this.reportDetailService = reportDetailService;
    }

    @GetMapping("/reports")
    public List<Report> getAllReports() {
        return reportService.getAllReports();
    }

    @PostMapping("/report")
    public String saveReport(@RequestBody Report report) {
        try {
            reportService.saveReport(report);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping("/reportOfHost/{username}")
    public List<Report> getReportOfHost(@PathVariable String username) {
        return reportService.getReportsByHostUsername(username);
    }

    @GetMapping("/reportOfTourist/{username}")
    public List<Report> getReportOfTourist(@PathVariable String username) {
        return reportService.getReportsByTouristUsername(username);
    }

    @GetMapping("/reportById/{id}")
    public Report getReportOfHost(@PathVariable int id) {
        return reportService.getReportById(id);
    }


    //    For Detail
    @PostMapping("/reportDetail")
    public String saveReportDetailWithReportId(@RequestBody ReportDetail reportDetail) {
        try {
            reportDetailService.saveReportDetail(reportDetail);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping("reportDetail/{id}")
    public List<ReportDetail> getReportDetailOfReportId(@PathVariable int id){
        try {
            List<ReportDetail> reportDetails = reportDetailService.getReportDetailByReportId(id);
            return reportDetails;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}
