package com.example.sms;

import com.example.sms.config.AppConfig;
import com.example.sms.model.Course;
import com.example.sms.service.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        StudentService studentService = context.getBean(StudentService.class);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Online Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Pay Fees");
            System.out.println("6. Refund Fees");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = sc.next();
                        System.out.print("Enter balance: ");
                        double balance = sc.nextDouble();
                        System.out.print("Enter course name: ");
                        String cname = sc.next();
                        Course c = new Course(cname, 6);
                        studentService.addStudent(name, balance, c);
                        break;
                    case 2:
                        studentService.listStudents();
                        break;
                    case 3:
                        System.out.print("Enter student ID: ");
                        int id = sc.nextInt();
                        System.out.print("Enter new name: ");
                        String newName = sc.next();
                        studentService.updateStudent(id, newName);
                        break;
                    case 4:
                        System.out.print("Enter student ID to delete: ");
                        studentService.deleteStudent(sc.nextInt());
                        break;
                    case 5:
                        System.out.print("Enter student ID: ");
                        int sid = sc.nextInt();
                        System.out.print("Enter amount: ");
                        double amt = sc.nextDouble();
                        studentService.payFees(sid, amt);
                        break;
                    case 6:
                        System.out.print("Enter student ID: ");
                        sid = sc.nextInt();
                        System.out.print("Enter amount: ");
                        amt = sc.nextDouble();
                        studentService.refundFees(sid, amt);
                        break;
                    case 0:
                        System.out.println("👋 Exiting...");
                        context.close();
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("⚠️ Error: " + e.getMessage());
            }
        }
    }
}
