package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "prayer_dates")

public class PrayerDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data")
    private String data;

    @Column(name = "time")
    private String time;

    @ManyToMany
    @JoinTable(name = "prayer_prayer_date",
    joinColumns = @JoinColumn(name = "prayer_date_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "prayer_id", referencedColumnName = "id"))
    private Set<Prayer> prayerSet = new HashSet<Prayer>();

    public void addPrayer(Prayer prayer){
        prayerSet.add(prayer);
    }

    @ManyToMany
    @JoinTable(name = "user_prayer_date",
    joinColumns = @JoinColumn(name = "prayer_date_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private Set<User> userSet = new HashSet<User>();

    public void addUser(User user){
        userSet.add(user);
    }

    public PrayerDate() {
    }

    public PrayerDate(int id){
        this.id = id;
    }

    public PrayerDate(String data, String time) {
        this.data = data;
        this.time = time;
    }

    public PrayerDate(String data, String time, Set<Prayer> prayerSet) {
        this.data = data;
        this.time = time;
        this.prayerSet = prayerSet;
    }

    public PrayerDate(String data, String time, Set<Prayer> prayerSet, Set<User> userSet) {
        this.data = data;
        this.time = time;
        this.prayerSet = prayerSet;
        this.userSet = userSet;
    }

    //геттеры и сеттеры

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

    public Set<Prayer> getPrayerSet() {
        return prayerSet;
    }

    public void setPrayerSet(Set<Prayer> prayerSet) {
        this.prayerSet = prayerSet;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    @Override
    public String toString() {
        return "PrayerDate{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
