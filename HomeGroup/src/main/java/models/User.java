package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name")
    private String full_name;

    @Column(name = "date_of_birth")
    private String date_of_birth;

    @Column(name = "phone_number")
    private Long phone_number;

    @Column(name = "email")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private HomeGroup homeGroup;


    @ManyToMany
    @JoinTable(name="users_activitys",
            joinColumns = @JoinColumn(name="user_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="activity_id", referencedColumnName="id")
    )
    private Set<Activity> activitySet = new HashSet<Activity>();

    public void addActivity(Activity activity) {
        activitySet.add(activity);
    }

    @ManyToMany
    @JoinTable(name="users_prayers",
            joinColumns = @JoinColumn(name="user_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="prayer_id", referencedColumnName="id")
    )
    private Set<Prayer> prayerSet = new HashSet<Prayer>();

    public void addPrayer(Prayer prayer) {
        prayerSet.add(prayer);
    }

    @ManyToMany
    @JoinTable(name="users_home_group_date",
            joinColumns = @JoinColumn(name="user_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="home_group_date_id", referencedColumnName="id")
    )
    private Set<HomeGroupDate> homeGroupDateSet = new HashSet<HomeGroupDate>();

    public void addHomeGroupDate(HomeGroupDate homeGroupDate) {
        homeGroupDateSet.add(homeGroupDate);
    }


    @ManyToMany
    @JoinTable(name="users_prayer_date",
            joinColumns = @JoinColumn(name="user_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="prayer_date_id", referencedColumnName="id")
    )
    private Set<PrayerDate> prayerDateSet = new HashSet<PrayerDate>();

    public void addPrayerDate(PrayerDate prayerDate) {prayerDateSet.add(prayerDate);
    }


    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(String full_name, String date_of_birth, Long phone_number, String email) {
        this.full_name = full_name;
        this.date_of_birth = date_of_birth;
        this.phone_number = phone_number;
        this.email = email;
    }

    public User(String full_name, String date_of_birth, Long phone_number, String email, Set<Activity> activitySet) {
        this.full_name = full_name;
        this.date_of_birth = date_of_birth;
        this.phone_number = phone_number;
        this.email = email;
        this.activitySet = activitySet;
    }

    public User(String full_name, Long phone_number, String date_of_birth, String email, Set<Prayer> prayerSet) {
        this.full_name = full_name;
        this.date_of_birth = date_of_birth;
        this.phone_number = phone_number;
        this.email = email;
        this.prayerSet = prayerSet;
    }

    public User(String full_name, String date_of_birth, Long phone_number, String email, HomeGroup homeGroup) {
        this.full_name = full_name;
        this.date_of_birth = date_of_birth;
        this.phone_number = phone_number;
        this.email = email;
        this.homeGroup = homeGroup;
    }

    public User(String full_name, String date_of_birth, Long phone_number, String email, HomeGroup homeGroup, Set<Activity> activitySet, Set<Prayer> prayerSet, Set<HomeGroupDate> homeGroupDateSet) {
        this.full_name = full_name;
        this.date_of_birth = date_of_birth;
        this.phone_number = phone_number;
        this.email = email;
        this.homeGroup = homeGroup;
        this.activitySet = activitySet;
        this.prayerSet = prayerSet;
        this.homeGroupDateSet = homeGroupDateSet;
    }

    public User(String full_name, String date_of_birth, Long phone_number, String email, HomeGroup homeGroup, Set<HomeGroupDate> homeGroupDateSet) {
        this.full_name = full_name;
        this.date_of_birth = date_of_birth;
        this.phone_number = phone_number;
        this.email = email;
        this.homeGroup = homeGroup;
        this.homeGroupDateSet = homeGroupDateSet;
    }

    public User(String full_name, String date_of_birth, Long phone_number, String email, HomeGroup homeGroup, Set<Activity> activitySet, Set<Prayer> prayerSet, Set<HomeGroupDate> homeGroupDateSet, Set<PrayerDate> prayerDateSet) {
        this.full_name = full_name;
        this.date_of_birth = date_of_birth;
        this.phone_number = phone_number;
        this.email = email;
        this.homeGroup = homeGroup;
        this.activitySet = activitySet;
        this.prayerSet = prayerSet;
        this.homeGroupDateSet = homeGroupDateSet;
        this.prayerDateSet = prayerDateSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Long phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public HomeGroup getHomeGroup() {
        return homeGroup;
    }

    public void setHomeGroup(HomeGroup homeGroup) {
        this.homeGroup = homeGroup;
    }

    public Set<Activity> getActivitySet() {
        return activitySet;
    }

    public void setActivitySet(Set<Activity> activitySet) {
        this.activitySet = activitySet;
    }

    public Set<Prayer> getPrayerSet() {
        return prayerSet;
    }

    public void setPrayerSet(Set<Prayer> prayerSet) {
        this.prayerSet = prayerSet;
    }

    public Set<HomeGroupDate> getHomeGroupDateSet() {
        return homeGroupDateSet;
    }

    public void setHomeGroupDateSet(Set<HomeGroupDate> homeGroupDateSet) {
        this.homeGroupDateSet = homeGroupDateSet;
    }

    public Set<PrayerDate> getPrayerDateSet() {
        return prayerDateSet;
    }

    public void setPrayerDateSet(Set<PrayerDate> prayerDateSet) {
        this.prayerDateSet = prayerDateSet;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", full_name='" + full_name + '\'' +
                ", date_of_birth='" + date_of_birth + '\'' +
                ", phone_number=" + phone_number +
                ", email='" + email + '\'' +
                ", homeGroup=" + homeGroup +
                ", activitySet=" + activitySet +
                ", prayerSet=" + prayerSet +
                ", homeGroupDateSet=" + homeGroupDateSet +
                ", prayerDateSet=" + prayerDateSet +
                '}';
    }
}

