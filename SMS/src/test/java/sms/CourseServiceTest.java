package sms;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jpa.entitymodels.Course;
import jpa.service.CourseService;

import static org.junit.Assert.*;

public class CourseServiceTest {

    private SessionFactory sessionFactory;
    private CourseService courseService;

    @Before
    public void setUp() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml"); // Replace with your Hibernate configuration file path
        sessionFactory = configuration.buildSessionFactory();
        courseService = new CourseService(sessionFactory);
    }

    @After
    public void tearDown() {
        sessionFactory.close();
    }

    @Test
    public void testGetCourseById() {
        // Replace with an actual course ID from your database
        int courseId = 1;
        Course course = courseService.getCourseById(courseId);
        assertNotNull(course);
    }

}