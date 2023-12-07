package jpa.dao;
import java.util.List;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public interface StudentDAO {
    // Retrieve all students from the database
    List<Student> getAllStudents();

    // Retrieve a student by their email
    Student getStudentByEmail(String email);

    // Validate student credentials (email and password)
    boolean validateStudent(String email, String password);

    // Register a student for a course
    void registerStudentToCourse(String email, int courseId);

    // Retrieve all courses a student is registered for
    List<Course> getStudentCourses(String email);
}