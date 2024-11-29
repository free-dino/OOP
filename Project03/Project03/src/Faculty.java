import java.io.*;
import java.util.*;

class Faculty extends University {
    private String facultyId;
    private String facultyName;
    private List<Lecturer> lecturerList = new ArrayList<>();

    public Faculty() {}

    public Faculty(String uniName, String uniAddress, String facultyId, String facultyName) {
        super(uniName, uniAddress);
        this.facultyId = facultyId;
        this.facultyName = facultyName;
    }

    public void inputFacultyData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter faculty ID: ");
        facultyId = sc.nextLine();
        System.out.print("Enter faculty name: ");
        facultyName = sc.nextLine();
    }

    public void initFaculty() {
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

    public void display() {
        System.out.println(toString());
        System.out.println("Faculty Lecturers:");
        for (Lecturer lecturer : lecturerList) {
            lecturer.display();
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Faculty ID: " + facultyId + ", Faculty Name: " + facultyName;
    }

    public void searchByName(String name) {
        boolean found = false;
        for (Lecturer lecturer : lecturerList) {
            if (lecturer.getLecName().equalsIgnoreCase(name)) {
                lecturer.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No lecturer found with the name: " + name);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a Faculty instance
        Faculty faculty = new Faculty();
        faculty.inputData();
        faculty.inputFacultyData();
        faculty.initFaculty();

        // Display Faculty and Lecturer List
        System.out.println("\n--- Faculty Information ---");
        faculty.display();

        // Search for a Lecturer by Name
        System.out.print("\nEnter lecturer name to search: ");
        String searchName = sc.nextLine();
        System.out.println("\n--- Search Results ---");
        faculty.searchByName(searchName);
    }
}
