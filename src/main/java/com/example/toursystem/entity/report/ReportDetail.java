package com.example.toursystem.entity.report;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "report_detail", schema = "tour_system", catalog = "")
public class ReportDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "date")
    private Timestamp date;
    @Basic
    @Column(name = "report_id")
    private int reportId;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "message")
    private String message;
    @Basic
    @Column(name = "document")
    private String document;

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

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReportDetail that = (ReportDetail) o;

        if (id != that.id) return false;
        if (reportId != that.reportId) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (document != null ? !document.equals(that.document) : that.document != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + reportId;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (document != null ? document.hashCode() : 0);
        return result;
    }
}
