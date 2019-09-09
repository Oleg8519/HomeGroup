package service;

import DAO.ActivityDao;
import models.Activity;

import java.util.List;

public class ActivityService {
    private ActivityDao activityDao = new ActivityDao();

    public ActivityService() {
    }

    public void saveActivity(Activity activity){
        activityDao.save(activity);
    }

    public void updateActivity(Activity activity) {
        activityDao.update(activity);
    }

    public void deleteActivity(Activity activity) {
        activityDao.delete(activity);
    }

    public List<Activity> findAllActivity() {
        return activityDao.findAll();
    }

    public Activity findActivity(int id) {
        return activityDao.findById(id);
    }
}
