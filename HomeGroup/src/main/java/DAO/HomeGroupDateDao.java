package DAO;

import models.HomeGroup;
import models.HomeGroupDate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class HomeGroupDateDao {
    public HomeGroupDate findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(HomeGroupDate.class, id);
    }


    public void save(HomeGroupDate homeGroupDate) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(homeGroupDate);
        transaction.commit();
        session.close();
    }

    public void update(HomeGroupDate homeGroupDate) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(homeGroupDate);
        transaction.commit();
        session.close();
    }

    public void delete(HomeGroupDate homeGroupDate) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(homeGroupDate);
        transaction.commit();
        session.close();
    }


    public HomeGroupDate findHomeGroupDateById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(HomeGroupDate.class, id);
    }

    public List<HomeGroupDate> findAll() {
        List<HomeGroupDate> homeGroupDateList = (List<HomeGroupDate>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From HomeGroupDate").list();
        return homeGroupDateList;
    }
}
