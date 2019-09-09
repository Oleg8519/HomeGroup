package methots;

import models.Activity;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.ActivityService;
import service.UserService;
import utils.HibernateSessionFactoryUtil;

import java.util.Scanner;

public class ActivityMethots {
    Scanner scanner = new Scanner(System.in);

    public void RegistActivity(){
        Activity activity = new Activity();
        ActivityService activityService = new ActivityService();
        System.out.println("Введите название служения: ");
        String dewFavoriteActivity = scanner.nextLine();
        activity.setFavoriteActivity(dewFavoriteActivity);
        System.out.println("Введите имя лидера служения: ");
        String dewLeaderName = scanner.nextLine();
        activity.setLeaderName(dewLeaderName);
        activityService.saveActivity(activity);
    }

    public void DeleteActivity(){
        ActivityService activityService = new ActivityService();
        System.out.println("Введите id служения: ");
        int numberId = scanner.nextInt();
        Activity activity = new Activity(+numberId);
        activityService.deleteActivity(activity);
    }

    public void EditingActivity(){
        System.out.println("Введите id служения:");
        int numbertId = scanner.nextInt();
        Activity activity = new Activity(+numbertId);
        System.out.println("Введите название служения:");
        String kkk = scanner.nextLine(); //Почему?????
        String dewFavoriteActivity = scanner.nextLine();
        activity.setFavoriteActivity(dewFavoriteActivity);
        System.out.println("Введите имя лидера: ");
        String dewLeaderName = scanner.nextLine();
        activity.setLeaderName(dewLeaderName);
        ActivityService activityService = new ActivityService();
        activityService.updateActivity(activity);
    }

    public void ConjunctionActivityUser(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Activity activity = new Activity();
        // String ddd = scanner.nextLine();
        System.out.println("Введите имя лидера: ");
        String dewLeaderName = scanner.nextLine();
        activity.setLeaderName(dewLeaderName);
        System.out.println("Введите название служения: ");
        String dewFavoriteActivity = scanner.nextLine();
        activity.setFavoriteActivity(dewFavoriteActivity);

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
            activity.addUser(user);

            session.save(user);
            session.save(activity);
        }
        transaction.commit();
        session.close();
    }

    public void SearchActivity() {
        ActivityService activityService = new ActivityService();
        System.out.println("Введите id служения: ");
        int numberId = scanner.nextInt();
        System.out.println(activityService.findActivity(numberId));
    }

    public void EverythingActivity() {
        ActivityService activityService = new ActivityService();
        System.out.println(activityService.findAllActivity());
    }

}