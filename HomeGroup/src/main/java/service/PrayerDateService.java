package service;

import DAO.PrayerDateDao;
import models.HomeGroupDate;
import models.PrayerDate;

import java.util.List;

public class PrayerDateService {
   private PrayerDateDao prayerDateDao = new PrayerDateDao();

    public PrayerDateService(){
    }

    public void savePrayerDate(PrayerDate prayerDate){
        prayerDateDao.save(prayerDate);
    }

    public void updatePrayerDate(PrayerDate prayerDate){
        prayerDateDao.update(prayerDate);
    }

    public void deletePrayerDate(PrayerDate prayerDate){
        prayerDateDao.delete(prayerDate);
    }

    public List<PrayerDate> findAllPrayerDate() {
        return prayerDateDao.findAll();
    }

    public PrayerDate findPrayerDate(int id) {
        return prayerDateDao.findById(id);
    }
}
