package com.example.sms.service;

import com.example.sms.dao.StudentDAO;
import com.example.sms.model.Student;
import org.springframework.transaction.annotation.Transactional;

public class FeeService {
    private final StudentDAO studentDAO;

    public FeeService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Transactional
    public void payFees(int studentId, double amount) {
        Student s = studentDAO.get(studentId);
        if (s == null) throw new RuntimeException("Student not found!");
        if (s.getBalance() < amount) throw new RuntimeException("Insufficient balance!");
        s.setBalance(s.getBalance() - amount);
        studentDAO.update(s);
        System.out.println("✅ Payment successful. Remaining balance: " + s.getBalance());
    }

    @Transactional
    public void refundFees(int studentId, double amount) {
        Student s = studentDAO.get(studentId);
        if (s == null) throw new RuntimeException("Student not found!");
        s.setBalance(s.getBalance() + amount);
        studentDAO.update(s);
        System.out.println("💰 Refund successful. New balance: " + s.getBalance());
    }
}
