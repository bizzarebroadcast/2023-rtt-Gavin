package jpa.entitymodels;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int cID; // Unique course identifier

    @Column(name = "name", length = 50)
    private String cName; // Provides the name of the course

    @Column(name = "instructor", length = 50)
    private String cInstructorName; // Provides the name of the instructor

    // Constructors, getters, and setters for cID, cName, and cInstructorName
    // ...

    public int getCID() {
        return cID;
    }

    public void setCID(int cID) {
        this.cID = cID;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getCInstructorName() {
        return cInstructorName;
    }

    public void setCInstructorName(String cInstructorName) {
        this.cInstructorName = cInstructorName;
    }

    // Override equals and hashCode methods if necessary for comparisons
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return cID == course.cID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cID);
    }
}