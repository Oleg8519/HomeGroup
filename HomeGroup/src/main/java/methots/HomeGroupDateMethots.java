package methots;

import models.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.ActivityService;
import service.HomeGroupDateService;
import utils.HibernateSessionFactoryUtil;

import java.util.Scanner;

public class HomeGroupDateMethots {
    Scanner scanner = new Scanner(System.in);

//регистрация даты проведения ДГ
    public void RegistHomeGroupDate(){
        HomeGroupDate homeGroupDate = new HomeGroupDate();
        HomeGroupDateService homeGroupDateService = new HomeGroupDateService();
        System.out.println("Введите дату проведения ДГ: ");
        String dewDate = scanner.nextLine();
        homeGroupDate.setData(dewDate);
        System.out.println("Введите время проведения ДГ: ");
        String dewTime = scanner.nextLine();
        homeGroupDate.setTime(dewTime);
        homeGroupDateService.saveHomeGroupDate(homeGroupDate);
    }
// удаление даты проведения ДГ
    public void DeleteHomeGroupDate(){
        HomeGroupDateService homeGroupDateService = new HomeGroupDateService();
        System.out.println("Введите id даты проведения ДГ: ");
        int numberId = scanner.nextInt();
        HomeGroupDate homeGroupDate = new HomeGroupDate(+numberId);
        homeGroupDateService.deleteHomeGroupDate(homeGroupDate);
    }
// редактирование даты проведения ДГ
    public void EditingHomeGroupDate(){
        System.out.println("Введите id даты проведения ДГ:");
        int numbertId = scanner.nextInt();
        HomeGroupDate homeGroupDate = new HomeGroupDate(+numbertId);
        System.out.println("Введите дату проведения ДГ:");
        String kkk = scanner.nextLine(); //Почему?????
        String dewData = scanner.nextLine();
        homeGroupDate.setData(dewData);
        System.out.println("Введите время проведения ДГ: ");
        String dewTime = scanner.nextLine();
        homeGroupDate.setTime(dewTime);
        HomeGroupDateService homeGroupDateService = new HomeGroupDateService();
        homeGroupDateService.updateHomeGroupDate(homeGroupDate);
    }

    //Связь Дата посещения ДГ и человека
    public void ConjunctionHomeGroupDateUser(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        HomeGroupDate homeGroupDate = new HomeGroupDate();
        // String ddd = scanner.nextLine();
        System.out.println("Введите дату проведения ДГ: ");
        String dewDate = scanner.nextLine();
        homeGroupDate.setData(dewDate);
        System.out.println("Введите время проведения ДГ: ");
        String dewTime = scanner.nextLine();
        homeGroupDate.setTime(dewTime);

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
            homeGroupDate.addUser(user);

            session.save(user);
            session.save(homeGroupDate);
        }
        transaction.commit();
        session.close();
    }
    //===========================================================================================
    //Связь Даты проведения ДГ и Дг
    public void ConjunctionHomeGroupDateHomeGroup(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        HomeGroupDate homeGroupDate = new HomeGroupDate();
        // String ddd = scanner.nextLine();
        System.out.println("Введите дату проведения ДГ: ");
        String dewDate = scanner.nextLine();
        homeGroupDate.setData(dewDate);
        System.out.println("Введите время проведения ДГ: ");
        String dewTime = scanner.nextLine();
        homeGroupDate.setTime(dewTime);

        for (int i = 0; i<100; i++){
            HomeGroup homeGroup = new HomeGroup();
            System.out.println("Введите адресс ДГ: ");
            String dewAdress = scanner.nextLine();
            if (dewAdress.equals("stop")){
                break;
            }
            homeGroup.setAdress(dewAdress);
            System.out.println("Введите имя лидера ДГ: ");
            String dewLeaderName = scanner.nextLine();
            homeGroup.setLeaderName(dewLeaderName);
            homeGroupDate.addHomeGroup(homeGroup);
            session.save(homeGroup);
            session.save(homeGroupDate);
        }
        transaction.commit();
        session.close();
    }

    public void SearchHomeGroupDate() {
        HomeGroupDateService homeGroupDateService = new HomeGroupDateService();
        System.out.println("Введите id даты проведения ДГ: ");
        int numberId = scanner.nextInt();
        System.out.println(homeGroupDateService.findHomeGroupDate(numberId));
    }

    //Связь Дата посещения молитвы и человека
    public void ConjunctionPrayerDateUser(){
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
}
