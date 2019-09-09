package methots;

import models.HomeGroup;
import models.HomeGroupDate;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.HomeGroupService;
import utils.HibernateSessionFactoryUtil;

import java.util.Scanner;

public class HomeGroupMethots {
    Scanner scanner = new Scanner(System.in);

    public void RegistHomeGroup(){
        HomeGroupService homeGroupService = new HomeGroupService();
        System.out.println("Введите адресс ДГ: ");
        String dewAdress = scanner.nextLine();
        System.out.println("Введите имя лидера: ");
        String dewLeaderName = scanner.nextLine();
        HomeGroup homeGroup = new HomeGroup(""+dewAdress, ""+dewLeaderName);
        for (int i = 0; i<666; i++){
            System.out.println("Введите ФИО человека: ");
            String dewFullName = scanner.nextLine();
            if (dewFullName.equals("stop")){
                break;
            }
            System.out.println("Введите дату роджения человека: ");
            String dewDateOfBirth = scanner.nextLine();
            System.out.println("Введите номер телефона человека: ");
            Long dewPhoneNumber = scanner.nextLong();
            String ttt = scanner.nextLine();
            System.out.println("Введите email человека: ");
            String dewEmail = scanner.nextLine();
            User user = new User(""+dewFullName, ""+dewDateOfBirth, +dewPhoneNumber, ""+dewEmail);

            user.setHomeGroup(homeGroup);
            homeGroup.addUser(user);
        }
        homeGroupService.saveHomeGroup(homeGroup);
    }

    public void DeleteHomeGroup(){
        HomeGroupService homeGroupService = new HomeGroupService();
        System.out.println("Введите id ДГ: ");
        int numberId = scanner.nextInt();
        HomeGroup homeGroup = new HomeGroup(+numberId);
        homeGroupService.deleteHomeGroup(homeGroup);
    }

    public void EditingHomeGroup(){
        System.out.println("Введите id ДГ:");
        int numbertId = scanner.nextInt();
        HomeGroup homeGroup = new HomeGroup(+numbertId);
        System.out.println("Введите адресс ДГ:");
        String kkk = scanner.nextLine(); //Почему?????
        String dewAdress = scanner.nextLine();
        homeGroup.setAdress(""+dewAdress);

        System.out.println("Введите имя лидера ДГ: ");
        String dewLeaderName = scanner.nextLine();
        homeGroup.setLeaderName(""+dewLeaderName);

        HomeGroupService homeGroupService = new HomeGroupService();
        homeGroupService.updateHomeGroup(homeGroup);
    }

    public void SearchHomeGroup() {
        HomeGroupService homeGroupService = new HomeGroupService();
        System.out.println("Введите id домашней группы: ");
        int numberId = scanner.nextInt();
        System.out.println(homeGroupService.findHomeGroup(numberId));
    }

    public void EverythingHomeGroup() {
        HomeGroupService homeGroupService = new HomeGroupService();
        System.out.println(homeGroupService.findAllHomeGroup());
    }
    //==============================================================================================
    //Связь Домашняя Группа и Дата проведения Домашней Группы
    public void ConjunctionHomeGroupHomeGroupDate(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        HomeGroup homeGroup = new HomeGroup();
        System.out.println("Введите адресс ДГ: ");
        String dewAdress = scanner.nextLine();
        homeGroup.setAdress(dewAdress);
        System.out.println("Введите имя лидера ДГ: ");
        String dewLeaderName = scanner.nextLine();
        homeGroup.setLeaderName(dewLeaderName);

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
            homeGroup.addHomeGroupDate(homeGroupDate);

            session.save(homeGroupDate);
            session.save(homeGroup);
        }
        transaction.commit();
        session.close();
    }
}
