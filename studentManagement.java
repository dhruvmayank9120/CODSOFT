import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println("Name: " + student.getName() +
                               ", Roll Number: " + student.getRollNumber() +
                               ", Grade: " + student.getGrade());
        }
    }
}

public class studentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter grade: ");
                    String grade = sc.nextLine();
                    sms.addStudent(new Student(name, rollNumber, grade));
                    System.out.println("Student added.");
                    break;
                case 2:
                    System.out.print("Enter roll number to remove: ");
                    int rollToRemove = sc.nextInt();
                    sms.removeStudent(rollToRemove);
                    System.out.println("Student removed.");
                    break;
                case 3:
                    System.out.print("Enter roll number to search: ");
                    int rollToSearch = sc.nextInt();
                    Student student = sms.searchStudent(rollToSearch);
                    if (student != null) {
                        System.out.println("Name: " + student.getName() +
                                           ", Roll Number: " + student.getRollNumber() +
                                           ", Grade: " + student.getGrade());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    sms.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
