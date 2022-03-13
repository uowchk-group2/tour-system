package com.example.toursystem.dao.report;

import com.example.toursystem.entity.Review;
import com.example.toursystem.entity.User;
import com.example.toursystem.entity.report.Report;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ReportDAOService implements ReportDAO{

    private EntityManager entityManager;

    @Autowired
    public ReportDAOService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveReport(Report report) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(report);
    }

    @Override
    public List<Report> getReportsByTouristUsername(String username) {
        Session currentSession = entityManager.unwrap(Session.class);
        String hql = "FROM Report r WHERE r.touristUsername = '"+username+"'";
        Query query = currentSession.createQuery(hql, Report.class);
        List<Report> resultList = query.getResultList();

        return resultList;
    }

    @Override
    public List<Report> getReportsByHostUsername(String username) {
        Session currentSession = entityManager.unwrap(Session.class);
        String hql = "FROM Report r WHERE r.hostUsername = '"+username+"'";
        Query query = currentSession.createQuery(hql, Report.class);
        List<Report> resultList = query.getResultList();

        return resultList;
    }

    @Override
    public Report getReportById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Report report = currentSession.get(Report.class, id);
        return report;
    }
}
