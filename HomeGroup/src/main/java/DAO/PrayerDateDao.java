package DAO;

import models.HomeGroupDate;
import models.PrayerDate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class PrayerDateDao {
    public PrayerDate findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(PrayerDate.class, id);
    }


    public void save(PrayerDate prayerDate) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(prayerDate);
        transaction.commit();
        session.close();
    }

    public void update(PrayerDate prayerDate) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(prayerDate);
        transaction.commit();
        session.close();
    }

    public void delete(PrayerDate prayerDate) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(prayerDate);
        transaction.commit();
        session.close();
    }


    public PrayerDate findPrayerDateById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(PrayerDate.class, id);
    }

    public List<PrayerDate> findAll() {
        List<PrayerDate> prayerDateList = (List<PrayerDate>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From PrayerDate").list();
        return prayerDateList;
    }
}

