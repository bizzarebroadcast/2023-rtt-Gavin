package jpa.service;
import org.hibernate.Session;
import org.hibernate.query.Query;

import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class StudentService implements StudentDAO {
    private SessionFactory sessionFactory;

    public StudentService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Student> getAllStudents() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Student", Student.class).list();
        }
    }

    @Override
    public Student getStudentByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Student.class, email);
        }
    }

    @Override
    public boolean validateStudent(String email, String password) {
        try (Session session = sessionFactory.openSession()) {
            Student student = session.get(Student.class, email);
            return student != null && student.getSPass().equals(password);
        }
    }

    @Override
    public void registerStudentToCourse(String email, int courseId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            // Load the student and course entities
            Student student = session.get(Student.class, email);
            Course course = session.get(Course.class, courseId);

            if (student != null && course != null) {
                // Check if the student is already registered for the course
                if (!student.getSCourses().contains(course)) {
                    student.getSCourses().add(course);
                }

                session.update(student);
                transaction.commit();
            }
        }
    }

    @Override
    public List<Course> getStudentCourses(String email) {
        try (Session session = sessionFactory.openSession()) {
            Student student = session.get(Student.class, email);
            if (student != null) {
                return student.getSCourses();
            }
            return null;
        }
    }
}