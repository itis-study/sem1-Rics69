package org.example.DAO;

import org.example.model.Course;

import java.util.List;
import java.util.UUID;

public interface CourseDAO {
    public void addCourse(Course course);
    public void deleteCourse(Course course);
    public List<Course> getAllCourses();
    public List<Course> getCoursesByTeacherId(UUID teacherId);
}
