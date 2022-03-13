package com.example.toursystem.dao.report;

import com.example.toursystem.entity.report.Report;
import com.example.toursystem.entity.report.ReportDetail;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class ReportDetailDAOService implements ReportDetailDAO{

    private EntityManager entityManager;

    @Autowired
    public ReportDetailDAOService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveReportDetail(ReportDetail reportDetail) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(reportDetail);
    }
    @Override
    public List<ReportDetail> getReportDetailByReportId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        String hql = "FROM ReportDetail r WHERE r.reportId = '"+id+"'";
        Query query = currentSession.createQuery(hql, ReportDetail.class);
        List<ReportDetail> resultList = query.getResultList();
        return resultList;
    }
}
