package com.example.sms.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    private String name;
    private double balance;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;

    public Student() {}

    public Student(String name, double balance, Course course) {
        this.name = name;
        this.balance = balance;
        this.course = course;
    }

    public int getStudentId() { return studentId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    @Override
    public String toString() {
        return "Student [ID=" + studentId + ", Name=" + name + ", Balance=" + balance +
                ", Course=" + (course != null ? course.getCourseName() : "None") + "]";
    }
}
