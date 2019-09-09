package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "home_group_dates")

public class HomeGroupDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data")
    private String data;

    @Column(name = "time")
    private String time;

    @ManyToMany
    @JoinTable(name="users_home_group_date",
            joinColumns = @JoinColumn(name="home_group_date_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="user_id", referencedColumnName="id")
    )

    private Set<User> userSet = new HashSet<User>();

    public void addUser(User user) {
        userSet.add(user);
    }

//====================================================================================================================

    @ManyToMany
    @JoinTable(name="home_group_home_group_date",
            joinColumns = @JoinColumn(name="home_group_date_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="home_group_id", referencedColumnName="id")
    )

    private Set<HomeGroup> homeGroupSet = new HashSet<HomeGroup>();

    public void addHomeGroup(HomeGroup homeGroup) {
        homeGroupSet.add(homeGroup);
    }

//====================================================================================================================
    public HomeGroupDate() {
    }

    public HomeGroupDate(int id) {
        this.id = id;
    }

    public HomeGroupDate(String data, String time) {
        this.data = data;
        this.time = time;
    }

    public HomeGroupDate(String data, String time, Set<User> userSet) {
        this.data = data;
        this.time = time;
        this.userSet = userSet;
    }

    public HomeGroupDate(String data, String time, Set<User> userSet, Set<HomeGroup> homeGroupSet) {
        this.data = data;
        this.time = time;
        this.userSet = userSet;
        this.homeGroupSet = homeGroupSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public Set<HomeGroup> getHomeGroupSet() {
        return homeGroupSet;
    }

    public void setHomeGroupSet(Set<HomeGroup> homeGroupSet) {
        this.homeGroupSet = homeGroupSet;
    }

    @Override
    public String toString() {
        return "HomeGroupDate{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", time='" + time + '\'' +
                ", homeGroupSet=" + homeGroupSet +
                '}';
    }
}