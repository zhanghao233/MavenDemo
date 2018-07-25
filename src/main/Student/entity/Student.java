package entity;
import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private int ids;
    private String id;
    private String name;
    private Date birthday;
    private String description;
    private int avgscore;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAvgscore() {
        return avgscore;
    }

    public void setAvgscore(int avgscore) {
        this.avgscore = avgscore;
    }

    public Student(int ids, String id, String name, Date birthday, String description, int avgscore) {
        this.ids = ids;
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.description = description;
        this.avgscore = avgscore;
    }

    public Student() {
    }

    public Student(String id, String name, Date birthday, String description, int avgscore) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.description = description;
        this.avgscore = avgscore;
    }

    @Override
    public String toString() {
        return "Student [ids=" + ids + ", id=" + id + ", name=" + name + ", birthday=" + birthday + ", description=" + description + ", avgscore=" + avgscore + "]";

    }
}
