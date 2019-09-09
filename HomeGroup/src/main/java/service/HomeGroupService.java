package service;

import DAO.HomeGroupDao;
import models.HomeGroup;

import java.util.List;

public class HomeGroupService {
    private HomeGroupDao homeGroupDao = new HomeGroupDao();

    public HomeGroupService() {
    }

    public void saveHomeGroup(HomeGroup homeGroup){
        homeGroupDao.save(homeGroup);
    }

    public void updateHomeGroup(HomeGroup homeGroup) {
        homeGroupDao.update(homeGroup);
    }


    public void deleteHomeGroup(HomeGroup homeGroup) {
        homeGroupDao.delete(homeGroup);
    }


    public List<HomeGroup> findAllHomeGroup() {
        return homeGroupDao.findAll();
    }

    public HomeGroup findHomeGroup(int id) {
        return homeGroupDao.findById(id);
    }
}
