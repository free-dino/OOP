import java.util.Scanner;

class Student extends Person {
    private String studentId;
    private String lecId;
    private String topicTitle;
    private double grade;

    public Student() {}

    public Student(String name, String address, String studentId, String lecId, String topicTitle, double grade) {
        super(name, address);
        this.studentId = studentId;
        this.lecId = lecId;
        this.topicTitle = topicTitle;
        this.grade = grade;
    }

    @Override
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        studentId = sc.nextLine();
        System.out.print("Enter name: ");
        name = sc.nextLine();
        System.out.print("Enter address: ");
        address = sc.nextLine();
        System.out.print("Enter lecturer ID: ");
        lecId = sc.nextLine();
        System.out.print("Enter topic title: ");
        topicTitle = sc.nextLine();
        System.out.print("Enter grade: ");
        grade = sc.nextDouble();
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return super.toString() + ", Student ID: " + studentId + ", Lecturer ID: " + lecId + ", Topic: " + topicTitle + ", Grade: " + grade;
    }

    @Override
    public void display() {
        System.out.println(toString());
    }
}
