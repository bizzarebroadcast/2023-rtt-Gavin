package jpa.entitymodels;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "email", length = 50)
    private String sEmail; // Student’s current school email, unique student identifier

    @Column(name = "name", length = 50)
    private String sName; // The full name of the student

    @Column(name = "password", length = 50)
    private String sPass; // Student's password for logging in

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_email", referencedColumnName = "email"),
        inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id")
    )
    private List<Course> sCourses; // All the courses that the student is registered for

    // Constructors, getters, and setters for sEmail, sName, sPass, and sCourses
    // ...

    // Getters and setters for sEmail, sName, and sPass
    public String getSEmail() {
        return sEmail;
    }

    public void setSEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String getSPass() {
        return sPass;
    }

    public void setSPass(String sPass) {
        this.sPass = sPass;
    }

    public List<Course> getSCourses() {
        return sCourses;
    }

    public void setSCourses(List<Course> sCourses) {
        this.sCourses = sCourses;
    }
}