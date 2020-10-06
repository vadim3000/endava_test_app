import java.util.Calendar;

public class User {
    static final String STATUS_ACTIVE = "active";
    static final String STATUS_INACTIVE = "inactive";
    static final String STATUS_BLOCKED = "blocked";
    static final String STATUS_NEW = "new";

    private String firstname;
    private String lastname;
    private String email;
    private String status;
    private int age;
    private Calendar createdAt;

    public User(String firstname, String lastname, String email, int age, String status, Calendar createdAt) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
        this.status = status;
        this.createdAt = createdAt;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    public String toString() {
        return this.firstname + " " + this.lastname + " " + this.age + " " + this.email + " " + this.status + " " + this.createdAt.getTime();
    }
}
