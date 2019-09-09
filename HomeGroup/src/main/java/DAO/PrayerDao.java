package DAO;

import models.Prayer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class PrayerDao {
    public void save(Prayer prayer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(prayer);
        transaction.commit();
        session.close();
    }

    public void update(Prayer prayer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(prayer);
        transaction.commit();
        session.close();
    }

    public void delete(Prayer prayer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(prayer);
        transaction.commit();
        session.close();
    }


    public Prayer findPrayerById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Prayer.class, id);
    }

    public List<Prayer> findAll() {
        List<Prayer> prayerList = (List<Prayer>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Prayer").list();
        return prayerList;
    }


}

