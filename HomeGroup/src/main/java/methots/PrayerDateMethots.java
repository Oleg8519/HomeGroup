package methots;

import models.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.HomeGroupDateService;
import service.PrayerDateService;
import utils.HibernateSessionFactoryUtil;

import java.util.Scanner;

public class PrayerDateMethots {

    Scanner scanner = new Scanner(System.in);

    //регистрация даты проведения молитвы
    public void RegistPrayerDate(){
        PrayerDate prayerDate = new PrayerDate();
        PrayerDateService prayerDateService = new PrayerDateService();
        System.out.println("Введите дату проведения молитвы: ");
        String dewDate = scanner.nextLine();
        prayerDate.setData(dewDate);
        System.out.println("Введите время проведения молитвы: ");
        String dewTime = scanner.nextLine();
        prayerDate.setTime(dewTime);
        prayerDateService.savePrayerDate(prayerDate);
    }

    // удаление даты проведения молитвы
    public void DeletePrayerDate(){
        PrayerDateService prayerDateService = new PrayerDateService();
        System.out.println("Введите id даты проведения молитвы: ");
        int numberId = scanner.nextInt();
        PrayerDate prayerDate = new PrayerDate(numberId);
        prayerDateService.deletePrayerDate(prayerDate);
    }

    // редактирование даты проведения молитвы
    public void EditingPrayerDate(){
        System.out.println("Введите id даты проведения молитвы:");
        int numbertId = scanner.nextInt();
        PrayerDate prayerDate = new PrayerDate(+numbertId);
        System.out.println("Введите дату проведения молитвы:");
        String kkk = scanner.nextLine(); //Почему?????
        String dewData = scanner.nextLine();
        prayerDate.setData(dewData);
        System.out.println("Введите время проведения молитвы: ");
        String dewTime = scanner.nextLine();
        prayerDate.setTime(dewTime);
        PrayerDateService prayerDateService = new PrayerDateService();
        prayerDateService.updatePrayerDate(prayerDate);
    }

    //Связь Дата посещения молитвы и человека
    public void ConjunctionPrayerDateUser(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        PrayerDate prayerDate = new PrayerDate();
        //
        System.out.println("Введите дату посещения молитвы: ");
        String dewDate = scanner.nextLine();
        prayerDate.setData(dewDate);
        System.out.println("Введите время посещения молитвы: ");
        String dewTime = scanner.nextLine();
        String ddd = scanner.nextLine();
        prayerDate.setTime(dewTime);

        for (int i = 0; i<100; i++){
            User user = new User();
            System.out.println("Введите имя человека: ");
            String dewName = scanner.nextLine();
            if (dewName.equals("stop")){
                break;
            }
            user.setFull_name(dewName);
            System.out.println("Введите дату рождения человека: ");
            String dewDateBirth = scanner.nextLine();
            user.setDate_of_birth(dewDateBirth);
            System.out.println("Введите номер телефона человека: ");
            Long dewPhoneNumber = scanner.nextLong();
            user.setPhone_number(dewPhoneNumber);
            String sss = scanner.nextLine();
            System.out.println("Введите email человека: ");
            String dewEmail = scanner.nextLine();
            user.setEmail(dewEmail);
            prayerDate.addUser(user);

            session.save(user);
            session.save(prayerDate);
        }
        transaction.commit();
        session.close();
    }
    //===========================================================================================
    //Связь Даты проведения молитвы и молитвы
    public void ConjunctionPrayerDatePrayer(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        PrayerDate prayerDate = new PrayerDate();
        // String ddd = scanner.nextLine();
        System.out.println("Введите дату проведения молитвы: ");
        String dewDate = scanner.nextLine();
        prayerDate.setData(dewDate);
        System.out.println("Введите время проведения молитвы: ");
        String dewTime = scanner.nextLine();
        prayerDate.setTime(dewTime);

        for (int i = 0; i<100; i++){
            Prayer prayer = new Prayer();

            System.out.println("Введите имя лидера молитвы:");
            // String kkk = scanner.nextLine(); //Почему?????
            String dewLeaderName = scanner.nextLine();
            if (dewLeaderName.equals("stop")){
                break;
            }
            prayer.setLeaderName(dewLeaderName);
            System.out.println("Введите название молитвы: ");
            String dewTitlePrayer = scanner.nextLine();
            prayer.setTitlePrayer(dewTitlePrayer);
            session.save(prayer);
            session.save(prayerDate);
        }
        transaction.commit();
        session.close();
    }

    public void SearchPrayerDate() {
        PrayerDateService prayerDateService = new PrayerDateService();
        System.out.println("Введите id даты проведения молитвы: ");
        int numberId = scanner.nextInt();
        System.out.println(prayerDateService.findPrayerDate(numberId));
    }

}

