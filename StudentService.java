package com.example.sms.service;

import com.example.sms.dao.StudentDAO;
import com.example.sms.model.Course;
import com.example.sms.model.Student;
import java.util.List;

public class StudentService {
    private final StudentDAO studentDAO;
    private final FeeService feeService;

    public StudentService(StudentDAO studentDAO, FeeService feeService) {
        this.studentDAO = studentDAO;
        this.feeService = feeService;
    }

    public void addStudent(String name, double balance, Course course) {
        studentDAO.save(new Student(name, balance, course));
        System.out.println("✅ Student added successfully!");
    }

    public void updateStudent(int id, String newName) {
        Student s = studentDAO.get(id);
        if (s != null) {
            s.setName(newName);
            studentDAO.update(s);
            System.out.println("📝 Student updated!");
        } else System.out.println("❌ Student not found!");
    }

    public void deleteStudent(int id) {
        studentDAO.delete(id);
        System.out.println("🗑️ Student deleted!");
    }

    public void listStudents() {
        List<Student> students = studentDAO.list();
        students.forEach(System.out::println);
    }

    public void payFees(int studentId, double amount) {
        feeService.payFees(studentId, amount);
    }

    public void refundFees(int studentId, double amount) {
        feeService.refundFees(studentId, amount);
    }
}
