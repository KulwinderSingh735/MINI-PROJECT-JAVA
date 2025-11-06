package com.example.sms.model;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    private String courseName;
    private int duration;

    public Course() {}
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public int getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    @Override
    public String toString() {
        return "Course [ID=" + courseId + ", Name=" + courseName + ", Duration=" + duration + "]";
    }
}
