package com.example.sms.dao;

import com.example.sms.model.Student;
import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student get(int id);
    List<Student> list();
    void update(Student student);
    void delete(int id);
}
