package com.ktr;

import java.util.*;

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student Marks");
            System.out.println("5. Remove Student by ID");
            System.out.println("6. Sort Students by Marks");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = sc.nextInt();

                switch (choice) {
                    case 1: addStudent(); break;
                    case 2: displayStudents(); break;
                    case 3: searchStudent(); break;
                    case 4: updateMarks(); break;
                    case 5: removeStudent(); break;
                    case 6: sortStudents(); break;
                    case 7:
                        System.out.println("Thank you!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Please enter valid input.");
                sc.next(); // clear wrong input
            }
        }
    }

    // 1. Add Student
    static void addStudent() {
        try {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            for (Student s : students) {
                if (s.getId() == id) {
                    System.out.println("Student with this ID already exists!");
                    return;
                }
            }

            System.out.print("Enter Name: ");
            String name = sc.next();

            System.out.print("Enter Course: ");
            String course = sc.next();

            System.out.print("Enter Marks: ");
            double marks = sc.nextDouble();

            students.add(new Student(id, name, course, marks));
            System.out.println("Student added successfully!");

        } catch (Exception e) {
            System.out.println("Invalid input!");
            sc.next();
        }
    }

    // 2. Display Students
    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    // 3. Search Student
    static void searchStudent() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // 4. Update Marks
    static void updateMarks() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.print("Enter new marks: ");
                double marks = sc.nextDouble();
                s.setMarks(marks);
                System.out.println("Marks updated!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // 5. Remove Student
    static void removeStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        Iterator<Student> itr = students.iterator();
        while (itr.hasNext()) {
            if (itr.next().getId() == id) {
                itr.remove();
                System.out.println("Student removed!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // 6. Sort Students
    static void sortStudents() {
        students.sort(new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return Double.compare(s1.getMarks(), s2.getMarks());
            }
        });
        System.out.println("Students sorted by marks!");
    }
}
