package org.example.model;

import java.util.UUID;

public class Course {
    private UUID courseId;
    private String courseName;
    private String description;
    private UUID teacherId;

    public Course(){}
    public Course(UUID courseId, String courseName, String description, UUID teacherId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.description = description;
        this.teacherId = teacherId;
    }


    public UUID getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDescription() {
        return description;
    }

    public UUID getTeacherId() {
        return teacherId;
    }

    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTeacherId(UUID teacherId) {
        this.teacherId = teacherId;
    }
}
