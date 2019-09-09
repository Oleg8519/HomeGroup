package DAO;

import models.HomeGroup;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class HomeGroupDao {
    public HomeGroup findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(HomeGroup.class, id);
    }


    public void save(HomeGroup homeGroup) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(homeGroup);
        transaction.commit();
        session.close();
    }

    public void update(HomeGroup homeGroup) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(homeGroup);
        transaction.commit();
        session.close();
    }

    public void delete(HomeGroup homeGroup) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(homeGroup);
        transaction.commit();
        session.close();
    }


    public HomeGroup findHomeGroupById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(HomeGroup.class, id);
    }

    public List<HomeGroup> findAll() {
        List<HomeGroup> homeGroupList = (List<HomeGroup>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From HomeGroup").list();
        return homeGroupList;
    }
}
