package methots;

import models.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.UserService;
import utils.HibernateSessionFactoryUtil;

import java.util.Scanner;

public class UserMethots {
    Scanner scanner = new Scanner(System.in);

    public void RegistUser(){

        UserService userService = new UserService();
        System.out.println("Введите имя человека: ");
        String dewName = scanner.nextLine();
        System.out.println("Введите дату рождения человека: ");
        String dewDate = scanner.nextLine();
        System.out.println("Введите номер телефона человека: ");
        Long dewPhoneNumber = scanner.nextLong();
        String sss = scanner.nextLine();
        System.out.println("Введите email человека: ");
        String dewEmail = scanner.nextLine();
        User user = new User(""+dewName, ""+dewDate, +dewPhoneNumber, ""+dewEmail);
        userService.saveUser(user);

    }

    public void DeleteUser(){
        UserService userService = new UserService();
        System.out.println("Введите id человека: ");
        int numberId = scanner.nextInt();
        User user = new User(+numberId);
        userService.deleteUser(user);
    }

    public void EditingUser(){
        System.out.println("Введите id пользователя:");
        int numbertId = scanner.nextInt();
        User user = new User(+numbertId);
        System.out.println("Введите имя человека:");
        String kkk = scanner.nextLine(); //Почему?????
        String dewName = scanner.nextLine();
        user.setFull_name(""+dewName);


        System.out.println("Введите дату рождения: ");
        String dewDateOfBirth = scanner.nextLine();
        user.setDate_of_birth(""+dewDateOfBirth);

        System.out.println("Введите номер телефона: ");
        Long dewPhoneNumber = scanner.nextLong();
        user.setPhone_number(dewPhoneNumber);
        String qqq = scanner.nextLine();
        System.out.println("Введите email человека: ");
        String dewEmail = scanner.nextLine();
        user.setEmail(dewEmail);

        UserService userService = new UserService();
        userService.updateUser(user);
    }

    public void ConjunctionUserActivity(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        User user = new User();
        System.out.println("Введите имя человека: ");
        String dewName = scanner.nextLine();
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

        for (int i = 0; i<100; i++){
            Activity activity = new Activity();
            // String ddd = scanner.nextLine();
            System.out.println("Введите имя лидера: ");
            String dewLeaderName = scanner.nextLine();
            if (dewLeaderName.equals("stop")){
                break;
            }
            activity.setLeaderName(dewLeaderName);
            System.out.println("Введите название служения: ");
            String dewFavoriteActivity = scanner.nextLine();
            activity.setFavoriteActivity(dewFavoriteActivity);
            user.addActivity(activity);

            session.save(activity);
            session.save(user);
        }
        transaction.commit();
        session.close();
    }

    public void ConjunctionUserPrayer(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        User user = new User();
        System.out.println("Введите имя человека: ");
        String dewName = scanner.nextLine();
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

        for (int i = 0; i<100; i++){
            Prayer prayer = new Prayer();
            // String ddd = scanner.nextLine();
            System.out.println("Введите имя лидера: ");
            String dewLeaderName = scanner.nextLine();
            if (dewLeaderName.equals("stop")){
                break;
            }
            prayer.setLeaderName(dewLeaderName);
            System.out.println("Введите название молитвы: ");
            String dewTitlePrayer = scanner.nextLine();
            prayer.setTitlePrayer(dewTitlePrayer);
            user.addPrayer(prayer);

            session.save(prayer);
            session.save(user);
        }
        transaction.commit();
        session.close();
    }

    public void ConjunctionUserHomeGroupDate(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        User user = new User();
        System.out.println("Введите имя человека: ");
        String dewName = scanner.nextLine();
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

        for (int i = 0; i<100; i++){
            HomeGroupDate homeGroupDate = new HomeGroupDate();
            // String ddd = scanner.nextLine();
            System.out.println("Введите дату проведения ДГ: ");
            String dewDate = scanner.nextLine();
            if (dewDate.equals("stop")){
                break;
            }
            homeGroupDate.setData(dewDate);
            System.out.println("Введите время проведения ДГ: ");
            String dewTime = scanner.nextLine();
            homeGroupDate.setTime(dewTime);
            user.addHomeGroupDate(homeGroupDate);

            session.save(homeGroupDate);
            session.save(user);
        }
        transaction.commit();
        session.close();
    }

    public void ConjunctionUserPrayerDate(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        User user = new User();
        System.out.println("Введите имя человека: ");
        String dewName = scanner.nextLine();
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

        for (int i = 0; i<100; i++){
            PrayerDate prayerDate = new PrayerDate();
            // String ddd = scanner.nextLine();
            System.out.println("Введите дату проведения молитвы: ");
            String dewDate = scanner.nextLine();
            if (dewDate.equals("stop")){
                break;
            }
            prayerDate.setData(dewDate);
            System.out.println("Введите время проведения молитвы: ");
            String dewTime = scanner.nextLine();
            prayerDate.setTime(dewTime);
            user.addPrayerDate(prayerDate);

            session.save(prayerDate);
            session.save(user);
        }
        transaction.commit();
        session.close();
    }

    public void EverythingUser() {
        UserService userService = new UserService();
        System.out.println(userService.findAllUser());
    }

}