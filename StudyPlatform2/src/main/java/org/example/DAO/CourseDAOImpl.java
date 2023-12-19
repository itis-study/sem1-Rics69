package org.example.DAO;

import org.example.model.Course;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CourseDAOImpl implements CourseDAO {

    @Override
    public void addCourse(Course course) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "INSERT INTO Course (course_id, course_name, description, teacher_id) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setObject(1, course.getCourseId());
            statement.setString(2, course.getCourseName());
            statement.setString(3, course.getDescription());
            statement.setObject(4, course.getTeacherId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCourse(Course course) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "DELETE FROM Course WHERE course_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setObject(1, course.getCourseId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection()) {
            String query = "SELECT * FROM Course";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Course course = new Course();
                course.setCourseId(UUID.fromString(resultSet.getString("course_id")));
                course.setCourseName(resultSet.getString("course_name"));
                course.setDescription(resultSet.getString("description"));
                course.setTeacherId(UUID.fromString(resultSet.getString("teacher_id")));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public List<Course> getCoursesByTeacherId(UUID teacherId) {
        List<Course> courses = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection()) {
            String query = "SELECT * FROM Course WHERE teacher_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setObject(1, teacherId, java.sql.Types.OTHER);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Course course = new Course();
                course.setCourseId(UUID.fromString(resultSet.getString("course_id")));
                course.setCourseName(resultSet.getString("course_name"));
                course.setDescription(resultSet.getString("description"));
                course.setTeacherId(UUID.fromString(resultSet.getString("teacher_id")));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
}
