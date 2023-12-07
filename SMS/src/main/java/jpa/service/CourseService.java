package jpa.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

import java.util.List;

public class CourseService implements CourseDAO {
    private SessionFactory sessionFactory;

    public CourseService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Course> getAllCourses() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Course", Course.class).list();
        }
    }
    @Override
    public Course getCourseById(int courseId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Course.class, courseId);
        }
    }
}