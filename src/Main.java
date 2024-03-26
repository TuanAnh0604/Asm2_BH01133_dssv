import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println(" STUDENT MANAGEMENT PROGRAM ");
            System.out.println(" 1. Enter student list ");
            System.out.println(" 2. Find student by last name ");
            System.out.println(" 3. Find and edit student by full name ");
            System.out.println(" 4. Quit ");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    enterStudentList();
                    break;
                case 2:
                    findStudentByLastName();
                    break;
                case 3:
                    findAndEditStudentByFullName();
                    break;
                case 4:
                    System.out.println("Program terminated.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void enterStudentList() {
        System.out.println(" ENTER STUDENT LIST ");
        System.out.print(" Enter number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine();
        studentList.add(new Student("Nguyen Tuan Anh", 19));
        studentList.add(new Student("Tran Son", 34));
        studentList.add(new Student("Dinh Thi Bao Ngoc", 18));
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter information for student " + (i + 2) + ":");
            System.out.print("Full name: ");
            String fullName = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Discard the newline

            Student student = new Student(fullName, age);
            studentList.add(student);
        }
    }

    private static void findStudentByLastName() {
        System.out.println(" FIND STUDENT BY LAST NAME ");
        System.out.print(" Enter last name to find: ");
        String lastName = scanner.nextLine();
        boolean found = false;

        for (Student student : studentList) {
            if (student.getLastName().toLowerCase().startsWith(lastName.toLowerCase())) {
                System.out.println(student);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No student found with last name " + lastName);
        }
    }


    private static void findAndEditStudentByFullName() {
        System.out.println(" FIND AND EDIT STUDENT BY FULL NAME ");
        System.out.print(" Enter full name to find and edit: ");
        String fullName = scanner.nextLine();
        boolean found = false;

        for (Student student : studentList) {
            if (student.getFullName().equalsIgnoreCase(fullName)) {
                System.out.println(" Information of the student to be edited:");
                System.out.println(student);
                System.out.print(" Enter new full name: ");
                String newFullName = scanner.nextLine();
                student.setFullName(newFullName);
                System.out.println(" Edit successful.");
                found = true;
                break; // Only need to edit one student
            }
        }

        if (!found) {
            System.out.println("No student found with full name " + fullName);
        }
    }
}

class Student {
    private String fullName;
    private int age;

    public Student(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        String[] nameParts = fullName.split("\\s+");
        // Trả về phần tử cuối cùng của mảng nameParts
        return nameParts[0];
    }



    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Full name: " + fullName + ", Age: " + age;
    }
}
