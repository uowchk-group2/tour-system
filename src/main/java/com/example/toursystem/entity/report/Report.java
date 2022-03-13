package com.example.toursystem.entity.report;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Report {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "date")
    private Timestamp date;
    @Basic
    @Column(name = "report_nature")
    private String reportNature;
    @Basic
    @Column(name = "tour_id")
    private int tourId;
    @Basic
    @Column(name = "report_status")
    private Byte reportStatus;
    @Basic
    @Column(name = "tourist_username")
    private String touristUsername;
    @Basic
    @Column(name = "host_username")
    private String hostUsername;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getReportNature() {
        return reportNature;
    }

    public void setReportNature(String reportNature) {
        this.reportNature = reportNature;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public Byte getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(Byte reportStatus) {
        this.reportStatus = reportStatus;
    }

    public String getTouristUsername() {
        return touristUsername;
    }

    public void setTouristUsername(String touristUsername) {
        this.touristUsername = touristUsername;
    }

    public String getHostUsername() {
        return hostUsername;
    }

    public void setHostUsername(String hostUsername) {
        this.hostUsername = hostUsername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Report report = (Report) o;

        if (id != report.id) return false;
        if (tourId != report.tourId) return false;
        if (date != null ? !date.equals(report.date) : report.date != null) return false;
        if (reportNature != null ? !reportNature.equals(report.reportNature) : report.reportNature != null)
            return false;
        if (reportStatus != null ? !reportStatus.equals(report.reportStatus) : report.reportStatus != null)
            return false;
        if (touristUsername != null ? !touristUsername.equals(report.touristUsername) : report.touristUsername != null)
            return false;
        if (hostUsername != null ? !hostUsername.equals(report.hostUsername) : report.hostUsername != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (reportNature != null ? reportNature.hashCode() : 0);
        result = 31 * result + tourId;
        result = 31 * result + (reportStatus != null ? reportStatus.hashCode() : 0);
        result = 31 * result + (touristUsername != null ? touristUsername.hashCode() : 0);
        result = 31 * result + (hostUsername != null ? hostUsername.hashCode() : 0);
        return result;
    }
}
