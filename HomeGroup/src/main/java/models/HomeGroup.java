package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "home_groups")
public class HomeGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "adress")
    private String adress;

    @Column(name = "leader_name")
    private String leaderName;


    @OneToMany(mappedBy = "homeGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> userList;

    public void addUser(User user) {
        user.setHomeGroup(this);
        userList.add(user);
    }

    public void removeUser(User user) {
        userList.remove(user);
    }
    //=======================================================================================
    @ManyToMany
    @JoinTable(name="home_group_home_group_date",
            joinColumns = @JoinColumn(name="home_group_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="home_group_date_id", referencedColumnName="id")
    )
    private Set<HomeGroupDate> homeGroupDateSet = new HashSet<HomeGroupDate>();

    public void addHomeGroupDate(HomeGroupDate homeGroupDate) {
        homeGroupDateSet.add(homeGroupDate);
    }
    //=======================================================================================
    public HomeGroup() {
    }

    public HomeGroup(int id) {
        this.id = id;
    }


    public HomeGroup(String adress, String leaderName) {
        this.adress = adress;
        this.leaderName = leaderName;
        userList = new ArrayList<User>();
    }

    public HomeGroup(String adress, String leaderName, Set<HomeGroupDate> homeGroupDateSet) {
        this.adress = adress;
        this.leaderName = leaderName;
        this.homeGroupDateSet = homeGroupDateSet;
    }

    public HomeGroup(String adress, String leaderName, List<User> userList, Set<HomeGroupDate> homeGroupDateSet) {
        this.adress = adress;
        this.leaderName = leaderName;
        this.userList = userList;
        this.homeGroupDateSet = homeGroupDateSet;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Set<HomeGroupDate> getHomeGroupDateSet() {
        return homeGroupDateSet;
    }

    public void setHomeGroupDateSet(Set<HomeGroupDate> homeGroupDateSet) {
        this.homeGroupDateSet = homeGroupDateSet;
    }

    @Override
    public String toString() {
        return "HomeGroup{" +
                "id=" + id +
                ", adress='" + adress + '\'' +
                ", leaderName='" + leaderName +
                '}';
    }
}

