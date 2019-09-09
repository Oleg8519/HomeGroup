package service;

import DAO.HomeGroupDateDao;
import models.HomeGroup;
import models.HomeGroupDate;

import java.util.List;

public class HomeGroupDateService {
    private HomeGroupDateDao homeGroupDateDao = new HomeGroupDateDao();

    public HomeGroupDateService() {
    }

    public void saveHomeGroupDate(HomeGroupDate homeGroupDate){
        homeGroupDateDao.save(homeGroupDate);
    }

    public void updateHomeGroupDate(HomeGroupDate homeGroupDate) {
        homeGroupDateDao.update(homeGroupDate);
    }


    public void deleteHomeGroupDate(HomeGroupDate homeGroupDate) {
        homeGroupDateDao.delete(homeGroupDate);
    }


    public List<HomeGroupDate> findAllHomeGroupDate() {
        return homeGroupDateDao.findAll();
    }

    public HomeGroupDate findHomeGroupDate(int id) {
        return homeGroupDateDao.findById(id);
    }
}