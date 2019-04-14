package model;

import entity.FeedBack;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;



public class FeedbackModel {

    static Session sessionObj;
    static SessionFactory sessionFactoryObj;


    private static SessionFactory buildSessionFactory() {
        sessionFactoryObj = new Configuration().configure().buildSessionFactory();
        return sessionFactoryObj;
    }

    public boolean insert(FeedBack feedBack) {
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            sessionObj.save(feedBack);
            sessionObj.getTransaction().commit();
            sessionObj.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String id) {
        sessionObj = buildSessionFactory().openSession();
        sessionObj.beginTransaction();
        Query query = sessionObj.createQuery("UPDATE FROM FeedBack set status = -1 WHERE id = :id");
        query.setParameter("id", Integer.valueOf(id));
        int re = query.executeUpdate();
        sessionObj.close();
        return re == -1 ? false : true;
    }

    public boolean apccept(String id) {
        sessionObj = buildSessionFactory().openSession();
        sessionObj.beginTransaction();
        Query query = sessionObj.createQuery("UPDATE FeedBack set status = 1 WHERE id = :id");
        query.setParameter("id", Integer.valueOf(id));
        int re = query.executeUpdate();
        sessionObj.close();
        return re == -1 ? false : true;
    }

    public ArrayList<FeedBack> getFeedback(String sql) {
        sessionObj = buildSessionFactory().openSession();
        sessionObj.beginTransaction();
        Query query = sessionObj.createQuery(sql);
        ArrayList<FeedBack> list = (ArrayList<FeedBack>) query.list();
        sessionObj.close();
        return list;
    }

    public ArrayList<FeedBack> getAll() {
        return getFeedback("FROM FeedBack where status != -1 ORDER BY status");
    }

    public ArrayList<FeedBack> getAccepted() {
        return getFeedback("FROM FeedBack where status = 1");
    }


}
