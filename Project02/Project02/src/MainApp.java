import java.io.*;
import java.util.*;

public class MainApp {
    private static List<Lecturer> lecturerList = new ArrayList<>();
    private static List<Student> studentList = new ArrayList<>();

    public static void initLecturer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Initialize Lecturer List:");
        System.out.println("1. From Keyboard");
        System.out.println("2. From Text File");
        System.out.print("Choose input method (1/2): ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter number of lecturers: ");
                int n = sc.nextInt();
                sc.nextLine();
                for (int i = 0; i < n; i++) {
                    Lecturer lecturer = new Lecturer();
                    lecturer.inputData();
                    lecturerList.add(lecturer);
                }
                break;

            case 2:
                System.out.print("Enter file path for lecturer data: ");
                String filePath = sc.nextLine();
                try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] data = line.split("\t");
                        if (data.length == 3) {
                            Lecturer lecturer = new Lecturer(data[0], data[1], data[2]);
                            lecturerList.add(lecturer);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error reading file: " + e.getMessage());
                }
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void initStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Initialize Student List:");
        System.out.println("1. From Keyboard");
        System.out.println("2. From Text File");
        System.out.print("Choose input method (1/2): ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter number of students: ");
                int n = sc.nextInt();
                sc.nextLine();
                for (int i = 0; i < n; i++) {
                    Student student = new Student();
                    student.inputData();
                    studentList.add(student);
                }
                break;

            case 2:
                System.out.print("Enter file path for student data: ");
                String filePath = sc.nextLine();
                try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] data = line.split("\t");
                        if (data.length == 6) {
                            String name = data[0];
                            String address = data[1];
                            String studentId = data[2];
                            String lecId = data[3];
                            String topicTitle = data[4];
                            double grade = Double.parseDouble(data[5]);
                            Student student = new Student(name, address, studentId, lecId, topicTitle, grade);
                            studentList.add(student);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error reading file: " + e.getMessage());
                }
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void displayLecturers() {
        System.out.println("Lecturer List:");
        for (Lecturer lecturer : lecturerList) {
            lecturer.display();
        }
    }

    public static void displayStudents() {
        System.out.println("Student List:");
        for (Student student : studentList) {
            student.display();
        }
    }

    public static void searchStudentByName(String name) {
        boolean found = false;
        for (Student student : studentList) {
            if (student.name.equalsIgnoreCase(name)) {
                student.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found with the name: " + name);
        }
    }

    public static void searchMaxGrade() {
        if (studentList.isEmpty()) {
            System.out.println("Student list is empty.");
            return;
        }

        Student maxGradeStudent = studentList.get(0);
        for (Student student : studentList) {
            if (student.getGrade() > maxGradeStudent.getGrade()) {
                maxGradeStudent = student;
            }
        }
        System.out.println("Student with the highest grade:");
        maxGradeStudent.display();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        initLecturer();
        initStudent();

        System.out.println("\n--- Lecturer List ---");
        displayLecturers();

        System.out.println("\n--- Student List ---");
        displayStudents();

        System.out.print("\nEnter student name to search: ");
        String name = sc.nextLine();
        searchStudentByName(name);

        System.out.println("\n--- Searching for Student with Max Grade ---");
        searchMaxGrade();
    }
}
