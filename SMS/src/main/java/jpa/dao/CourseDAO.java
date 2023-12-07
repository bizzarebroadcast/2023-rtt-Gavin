package jpa.dao;
import java.util.List;

import jpa.entitymodels.Course;

public interface CourseDAO {
    // Retrieve all courses from the database
    List<Course> getAllCourses();
	Course getCourseById(int courseId);
}