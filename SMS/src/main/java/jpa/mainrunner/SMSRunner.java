package jpa.mainrunner;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;

public class SMSRunner {

    private Scanner sin;
    private StringBuilder sb;

    private CourseService courseService;
    private StudentService studentService;
    private Student currentStudent;

    public SMSRunner() {
        sin = new Scanner(System.in);
        sb = new StringBuilder();
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml"); // Provide the path to your Hibernate configuration file
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        courseService = new CourseService(sessionFactory);
        studentService = new StudentService(sessionFactory);
    }

    public static void main(String[] args) {
        SMSRunner sms = new SMSRunner();
        sms.run();
    }

    private void run() {
        while (true) {
            switch (menu1()) {
                case 1:
                    if (studentLogin()) {
                        studentMenu();
                    }
                    break;
                case 2:
                    System.out.println("Signed out");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }

    private int menu1() {
        sb.append("\n1. Student Login\n2. Quit Application\nPlease Enter Selection: ");
        System.out.print(sb.toString());
        sb.delete(0, sb.length());
        return sin.nextInt();
    }

    private boolean studentLogin() {
        System.out.print("Enter your email address: ");
        String email = sin.next();
        System.out.print("Enter your password: ");
        String password = sin.next();

        if (studentService.validateStudent(email, password)) {
            currentStudent = studentService.getStudentByEmail(email);
            return true;
        } else {
            System.out.println("User Validation failed. Goodbye!");
            return false;
        }
    }

    private void studentMenu() {
        while (true) {
        	viewRegisteredCourses();
            System.out.println("1. Register for a Course\n2. Logout");
            System.out.print("Please Enter Selection: ");
            int choice = sin.nextInt();
            switch (choice) {
                case 1:
                	registerForCourse();
                    break;
                case 2:
                	currentStudent = null;
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }

    private void viewRegisteredCourses() {
        List<Course> courses = studentService.getStudentCourses(currentStudent.getSEmail());
        if (courses.isEmpty()) {
            System.out.println("You are not registered for any courses.");
        } else {
            System.out.println("My Classes:");
            System.out.println("#  Course Name  Instructor Name");
            System.out.println("--------------------------------");
            for (Course course : courses) {
                System.out.println(course.getCID()+ "  " + course.getCName()+ "  " + course.getCInstructorName());
            }
        }
    }

    private void registerForCourse() {
        List<Course> allCourses = courseService.getAllCourses();
        List<Course> studentCourses = studentService.getStudentCourses(currentStudent.getSEmail());
        allCourses.removeAll(studentCourses);

        if (allCourses.isEmpty()) {
            System.out.println("You are already registered for all available courses.");
        } else {
            System.out.printf("%5s%15s%15s\n", "ID", "Course", "Instructor");
            for (Course course : allCourses) {
                System.out.println(course.getCID()+ "  " + course.getCName()+ "  " + course.getCInstructorName());
            }

            System.out.print("Enter Course ID to Register: ");
            int courseId = sin.nextInt();

            Course selectedCourse = courseService.getCourseById(courseId);
            if (selectedCourse != null) {
                studentService.registerStudentToCourse(currentStudent.getSEmail(), courseId);
                System.out.println("You have been registered for the course: " + selectedCourse.getCName());
            } else {
                System.out.println("Invalid Course ID.");
            }
        }
        viewRegisteredCourses();
        System.out.println("You have been registered, signing out");
        System.exit(0);
    }
}