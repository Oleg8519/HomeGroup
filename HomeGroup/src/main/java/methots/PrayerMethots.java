package methots;

import models.Activity;
import models.Prayer;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.ActivityService;
import service.PrayerService;
import utils.HibernateSessionFactoryUtil;

import java.util.Scanner;

public class PrayerMethots {
    Scanner scanner = new Scanner(System.in);

    public void RegistPrayer(){
        Prayer prayer = new Prayer();
        PrayerService prayerService = new PrayerService();
        System.out.println("Введите имя лидера молитвы: ");
        String dewLeaderName = scanner.nextLine();
        prayer.setLeaderName(dewLeaderName);
        System.out.println("Введите название молитвы: ");
        String dewTitlePrayer = scanner.nextLine();
        prayer.setTitlePrayer(dewTitlePrayer);
        prayerService.savePrayer(prayer);
    }

    public void DeletePrayer(){
        PrayerService prayerService = new PrayerService();
        System.out.println("Введите id молитвы: ");
        int numberId = scanner.nextInt();
        Prayer prayer = new Prayer(+numberId);
        prayerService.deletePrayer(prayer);
    }

    public void EditingPrayer(){
        System.out.println("Введите id молитвы:");
        int numbertId = scanner.nextInt();
        Prayer prayer = new Prayer(+numbertId);
        System.out.println("Введите имя лидера молитвы:");
        String kkk = scanner.nextLine(); //Почему?????
        String dewLeaderName = scanner.nextLine();
        prayer.setLeaderName(dewLeaderName);
        System.out.println("Введите название молитвы: ");
        String dewTitlePrayer = scanner.nextLine();
        prayer.setTitlePrayer(dewTitlePrayer);
        PrayerService prayerService = new PrayerService();
        prayerService.updatePrayer(prayer);
    }

    public void ConjunctionPrayerUser(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Prayer prayer = new Prayer();
        // String ddd = scanner.nextLine();
        System.out.println("Введите имя лидера молитвы:");
       // String kkk = scanner.nextLine(); //Почему?????
        String dewLeaderName = scanner.nextLine();
        prayer.setLeaderName(dewLeaderName);
        System.out.println("Введите название молитвы: ");
        String dewTitlePrayer = scanner.nextLine();
        prayer.setTitlePrayer(dewTitlePrayer);

        for (int i = 0; i<100; i++){
            User user = new User();
            System.out.println("Введите имя человека: ");
            String dewName = scanner.nextLine();
            if (dewName.equals("stop")){
                break;
            }
            user.setFull_name(dewName);
            System.out.println("Введите дату рождения человека: ");
            String dewDate = scanner.nextLine();
            user.setDate_of_birth(dewDate);
            System.out.println("Введите номер телефона человека: ");
            Long dewPhoneNumber = scanner.nextLong();
            user.setPhone_number(dewPhoneNumber);
            String sss = scanner.nextLine();
            System.out.println("Введите email человека: ");
            String dewEmail = scanner.nextLine();
            user.setEmail(dewEmail);
            prayer.addUser(user);

            session.save(user);
            session.save(prayer);
        }
        transaction.commit();
        session.close();
    }

    public void SearchPrayer() {
        PrayerService prayerService = new PrayerService();
        System.out.println("Введите id молитвы: ");
        int numberId = scanner.nextInt();
        System.out.println(prayerService.findPrayer(numberId));
    }

    public void EverythingAPrayer() {
        PrayerService prayerService = new PrayerService();
        System.out.println(prayerService.findAllPrayer());
    }
}
