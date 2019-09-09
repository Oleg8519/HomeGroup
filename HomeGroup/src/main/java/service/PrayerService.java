package service;

import DAO.PrayerDao;
import models.Prayer;

import java.util.List;

public class PrayerService {
    private PrayerDao prayerDao = new PrayerDao();

    public PrayerService() {
    }

    public void savePrayer(Prayer prayer){
        prayerDao. save(prayer);
    }

    public void updatePrayer(Prayer prayer) {
        prayerDao.update(prayer);
    }


    public void deletePrayer(Prayer prayer) {
        prayerDao.delete(prayer);
    }


    public List<Prayer> findAllPrayer() {
        return prayerDao.findAll();
    }

    public Prayer findPrayer(int id) {
        return prayerDao.findPrayerById(id);
    }
}
