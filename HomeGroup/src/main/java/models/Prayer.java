package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "prayers")
public class Prayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "leader_name")
    private String leaderName;

    @Column(name = "title_prayer")
    private String titlePrayer;

    @ManyToMany
    @JoinTable(name="users_prayers",
            joinColumns = @JoinColumn(name="prayer_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="user_id", referencedColumnName="id")
    )

    private Set<User> users = new HashSet<User>();

    public void addUser(User user) {
        users.add(user);
    }

    public Prayer() {
    }

    public Prayer(int id) {
        this.id = id;
    }

    public Prayer(String leaderName, String titlePrayer) {
        this.leaderName = leaderName;
        this.titlePrayer = titlePrayer;
    }

    public Prayer(String leaderName, String titlePrayer, Set<User> users) {
        this.leaderName = leaderName;
        this.titlePrayer = titlePrayer;
        this.users = users;
    }

    public Prayer(Set<User> users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getTitlePrayer() {
        return titlePrayer;
    }

    public void setTitlePrayer(String titlePrayer) {
        this.titlePrayer = titlePrayer;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Prayer{" +
                "id=" + id +
                ", leaderName='" + leaderName + '\'' +
                ", titlePrayer='" + titlePrayer + '\'' +
                '}';
    }
}
