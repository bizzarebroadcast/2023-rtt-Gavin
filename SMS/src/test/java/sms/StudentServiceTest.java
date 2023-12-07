package sms;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.StudentService;

import static org.junit.Assert.*;

import java.util.List;

public class StudentServiceTest {

    private SessionFactory sessionFactory;
    private StudentService studentService;

    @Before
    public void setUp() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml"); // Replace with your Hibernate configuration file path
        sessionFactory = configuration.buildSessionFactory();
        studentService = new StudentService(sessionFactory);
    }

    @After
    public void tearDown() {
        sessionFactory.close();
    }

    @Test
    public void testValidateStudent() {
        String validEmail = "hluckham0@google.ru";
        String validPassword = "X1uZcoIh0dj";
        assertTrue(studentService.validateStudent(validEmail, validPassword));
    }
    @Test
    public void testValidateStudentWithWrongPassword() {
        String validEmail = "hluckham0@google.ru";
        String invalidPassword = "hello";
        assertFalse(studentService.validateStudent(validEmail, invalidPassword));
    }
    @Test
    public void testValidateStudentWithWrongEmail() {
        String invalidEmail = "hello.gmail.com";
        String validPassword = "X1uZcoIh0dj";
        assertFalse(studentService.validateStudent(invalidEmail, validPassword));
    }
  
    @Test
    public void testGetStudentByEmail() {
        String studentEmail = "hluckham0@google.ru";
        Student student = studentService.getStudentByEmail(studentEmail);
        assertNotNull(student);
    }

    @Test
    public void testGetStudentCourses() {
        // Replace with an actual student's email from your database
        String studentEmail = "hluckham0@google.ru";
        List<Course> courses = studentService.getStudentCourses(studentEmail);
        assertNotNull(courses);
    }


}