package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "activityes")

public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "favorite_activity")
    private String favoriteActivity;

    @Column(name = "leader_name")
    private String leaderName;

    @ManyToMany
    @JoinTable(name="users_activitys",
            joinColumns = @JoinColumn(name="activity_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="user_id", referencedColumnName="id")
    )

    private Set<User> users = new HashSet<User>();

    public void addUser(User user) {
        users.add(user);
    }

    public Activity() {
    }

    public Activity(int id) {
        this.id = id;
    }

    public Activity(String favoriteActivity, String leaderName) {
        this.favoriteActivity = favoriteActivity;
        this.leaderName = leaderName;
    }

    public Activity(String favoriteActivity, String leaderName, Set<User> users) {
        this.favoriteActivity = favoriteActivity;
        this.leaderName = leaderName;
        this.users = users;
    }

    public Activity(Set<User> users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFavoriteActivity() {
        return favoriteActivity;
    }

    public void setFavoriteActivity(String favoriteActivity) {
        this.favoriteActivity = favoriteActivity;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", favoriteActivity='" + favoriteActivity + '\'' +
                ", leaderName='" + leaderName + '\'' +
                '}';
    }
}
