import methots.*;
import models.HomeGroupDate;
import models.PrayerDate;
import service.ActivityService;
import service.HomeGroupService;
import service.PrayerService;
import service.UserService;

import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        UserService userService = new UserService();
        HomeGroupService homeGroupService = new HomeGroupService();
        ActivityService activityService = new ActivityService();
        PrayerService prayerService = new PrayerService();
        HomeGroupDate homeGroupDate = new HomeGroupDate();
        PrayerDate prayerDate = new PrayerDate();

        Scanner scanner = new Scanner(System.in);

        UserMethots userMethots = new UserMethots();
        HomeGroupMethots homeGroupMethots = new HomeGroupMethots();
        ActivityMethots activityMethots = new ActivityMethots();
        PrayerMethots prayerMethots = new PrayerMethots();
        HomeGroupDateMethots homeGroupDateMethots = new HomeGroupDateMethots();
        PrayerDateMethots prayerDateMethots = new PrayerDateMethots();

        System.out.println("Выберите раздел с методами:\n  \nМетоды User, \nМетоды HomeGroup, \nМетоды Activity, \nМетоды Prayer, \nМетоды HomeGroupDate, \nМетоды PrayerDate");
        System.out.println("==============================================================================");
        System.out.println("Введите вашу команду:");
        String request = scanner.nextLine();

        if (request.equals("Методы User")){
            System.out.println("Список методов класса User:\n  \nРегистрация человека, \nУдаление человека, \nРедактирование данных человека, \nПоиск человека по id, \nВсе люди, \nСвязь человек-служение, \nСвязь человек-молитвы, \nСвязь человек-дата проведения ДГ");
            System.out.println("==========================================================");
            System.out.println("Введите вашу команду: ");
            String dewRequest = scanner.nextLine();


            if (dewRequest.equals("Регистрация человека")){
                userMethots.RegistUser();
            }

            else if (dewRequest.equals("Удаление человека")) {
                userMethots.DeleteUser();
            }

            else if (dewRequest.equals("Редактирование данных человека")) {
                userMethots.EditingUser();
            }

            else if (dewRequest.equals("Поиск человека по id")){
                System.out.println("Введите id человека: ");
                int numberId = scanner.nextInt();
                System.out.println(userService.findUser(numberId));
            }

            else if (dewRequest.equals("Все люди")){
                userMethots.EverythingUser();
            }

            else if (dewRequest.equals("Связь человек-служение")) {
                userMethots.ConjunctionUserActivity();
            }

            else if (dewRequest.equals("Связь человек-молитвы")) {
                userMethots.ConjunctionUserPrayer();
            }

            else if (dewRequest.equals("Связь человек-дата посещения ДГ")) {
                userMethots.ConjunctionUserHomeGroupDate();
            }

            else if (dewRequest.equals("Связь человек-дата посещения молитвы")) {
                userMethots.ConjunctionUserPrayerDate();
            }

        }

        else if (request.equals("Методы HomeGroup")){
            System.out.println("Список методов класса HomeGroup:\n  \nРегистрация ДГ, \nУдаление ДГ, \nРедактирование данных ДГ, \nПоиск ДГ по id, \nВсе ДГ, ");
            System.out.println("==========================================================");
            System.out.println("Введите вашу команду: ");
            String dewRequest = scanner.nextLine();

            if (dewRequest.equals("Регистрация ДГ")){
                homeGroupMethots.RegistHomeGroup();
            }

            else if (dewRequest.equals("Удаление ДГ")) {
                homeGroupMethots.DeleteHomeGroup();
            }
            else if (dewRequest.equals("Редактирование данных ДГ")) {
                homeGroupMethots.EditingHomeGroup();
            }

            else if (dewRequest.equals("Поиск ДГ по id")) {
                homeGroupMethots.SearchHomeGroup();
            }

            else if (dewRequest.equals("Все ДГ")){
                homeGroupMethots.EverythingHomeGroup();
            }
        }

        else if (request.equals("Методы Activity")){
            System.out.println("Список методов класса Activity:\n  \nРегистрация служения, \nУдаление служения, \nРедактирование данных служения, \nСвязь служение-человек, \nПоиск служения по id, \nВсе служения");
            System.out.println("==========================================================");
            System.out.println("Введите вашу команду: ");
            String dewRequest = scanner.nextLine();

            if (dewRequest.equals("Регистрация служения")){
                activityMethots.RegistActivity();
            }

            else if (dewRequest.equals("Удаление служения")) {
                activityMethots.DeleteActivity();
            }
            else if (dewRequest.equals("Редактирование данных служения")) {
                activityMethots.EditingActivity();
            }

            else if (dewRequest.equals("Связь служение-человек")) {
                activityMethots.ConjunctionActivityUser();
            }

            else if (dewRequest.equals("Поиск служения по id")){
                activityMethots.SearchActivity();
            }

            else if (dewRequest.equals("Все служения")){
                activityMethots.EverythingActivity();
            }
        }

        else if (request.equals("Методы Prayer")){
            System.out.println("Список методов класса Prayer:\n \nРегистрация молитвы, \nУдаление молитвы, \nРедактирование данных молитвы, \nСвязь молитвы-человек, \nПоиск молитвы по id, \nВсе молитвы");
            System.out.println("==========================================================");
            System.out.println("Введите вашу команду: ");
            String dewRequest = scanner.nextLine();

            if (dewRequest.equals("Регистрация молитвы")){
                prayerMethots.RegistPrayer();
            }

            else if (dewRequest.equals("Удаление молитвы")) {
                prayerMethots.DeletePrayer();
            }
            else if (dewRequest.equals("Редактирование данных молитвы")) {
                prayerMethots.EditingPrayer();
            }

            else if (dewRequest.equals("Связь молитвы-человек")) {
                prayerMethots.ConjunctionPrayerUser();
            }

            else if (dewRequest.equals("Поиск молитвы по id")){
                prayerMethots.SearchPrayer();
            }

            else if (dewRequest.equals("Все молитвы")){
                prayerMethots.EverythingAPrayer();
            }
        }

        else if (request.equals("Методы HomeGroupDate")){
            System.out.println("Список методов класса HomeGroupDate:\n  \nРегистрация даты проведения ДГ, \nУдаление даты проведения ДГ, \nРедактирование данных проведения ДГ, \nПоиск даты проведения ДГ по id, \nСвязь ДГ-дата проведения ДГ, \nСвязь даты проведения ДГ-ДГ, \nСвязь дата проведения ДГ-человек");
            System.out.println("==========================================================");
            System.out.println("Введите вашу команду: ");
            String dewRequest = scanner.nextLine();

            if (dewRequest.equals("Регистрация даты проведения ДГ")){
                homeGroupDateMethots.RegistHomeGroupDate();
            }

            else if (dewRequest.equals("Удаление даты проведения ДГ")) {
                homeGroupDateMethots.DeleteHomeGroupDate();
            }

            else if (dewRequest.equals("Редактирование данных проведения ДГ")) {
                homeGroupDateMethots.EditingHomeGroupDate();
            }

            else if (dewRequest.equals("Связь дата посещения ДГ-человек")) {
                homeGroupDateMethots.ConjunctionHomeGroupDateUser();
            }

            else if (dewRequest.equals("Поиск даты посещения ДГ по id")){
                homeGroupDateMethots.SearchHomeGroupDate();
            }

            else if (dewRequest.equals("Связь ДГ-дата проведения ДГ")){
                homeGroupMethots.ConjunctionHomeGroupHomeGroupDate();
            }

            else if (dewRequest.equals("Связь даты проведения ДГ-ДГ")){
                homeGroupDateMethots.ConjunctionHomeGroupDateHomeGroup();
            }

            else if (dewRequest.equals("Поиск даты проведения ДГ по id")){
                homeGroupDateMethots.SearchHomeGroupDate();
            }
        }

        else if (request.equals("Методы PrayerDate")){
            System.out.println("Список методов класса HomeGroupDate:\n  \nРегистрация даты проведения молитвы, \nУдаление даты проведения молитвы, \nРедактирование данных проведения молитвы, \nПоиск даты проведения молитвы по id, \nСвязь молитва-дата проведения молитвы, \nСвязь даты проведения молитвы-молитва, \nСвязь дата посещения молитвы-человек");
            System.out.println("==========================================================");
            System.out.println("Введите вашу команду: ");
            String dewRequest = scanner.nextLine();

            if (dewRequest.equals("Регистрация даты проведения молитвы")){
                prayerDateMethots.RegistPrayerDate();
            }

            else if (dewRequest.equals("Удаление даты проведения молитвы")) {
                prayerDateMethots.DeletePrayerDate();
            }

            else if (dewRequest.equals("Редактирование данных проведения молитвы")) {
                prayerDateMethots.EditingPrayerDate();
            }

            else if (dewRequest.equals("Связь дата посещения молитвы-человек")) {
                prayerDateMethots.ConjunctionPrayerDateUser();
            }

            else if (dewRequest.equals("Поиск даты посещения молитвы по id")){
                prayerDateMethots.SearchPrayerDate();
            }

            else if (dewRequest.equals("Связь молитва-дата проведения молитвы")){
                prayerDateMethots.ConjunctionPrayerDatePrayer();
            }

            else if (dewRequest.equals("Поиск даты проведения молитвы по id")){
                prayerDateMethots.SearchPrayerDate();
            }
        }
    }
}
