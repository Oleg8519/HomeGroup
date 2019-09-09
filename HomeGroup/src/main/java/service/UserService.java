package service;

import DAO.UserDao;
import models.User;

import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();

    public UserService() {
    }

    public void saveUser(User user){
        userDao. save(user);
    }

    public void updateUser(User user) {
        userDao.update(user);
    }


    public void deleteUser(User user) {
        userDao.delete(user);
    }


    public List<User> findAllUser() {
        return userDao.findAll();
    }

    public User findUser(int id) {
        return userDao.findById(id);
    }
}
