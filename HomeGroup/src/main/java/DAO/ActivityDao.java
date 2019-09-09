package DAO;

import models.Activity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class ActivityDao {
    public Activity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Activity.class, id);
    }


    public void save(Activity activity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(activity);
        transaction.commit();
        session.close();
    }

    public void update(Activity activity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(activity);
        transaction.commit();
        session.close();
    }

    public void delete(Activity activity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(activity);
        transaction.commit();
        session.close();
    }


    public Activity findActivityById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Activity.class, id);
    }

    public List<Activity> findAll() {
        List<Activity> activitiesList = (List<Activity>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Activity").list();
        return activitiesList;
    }
}
