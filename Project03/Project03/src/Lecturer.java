import java.util.Scanner;

class Lecturer {
    private String lecId;
    private String lecName;
    private String lecAddress;

    public Lecturer() {}

    public Lecturer(String lecId, String lecName, String lecAddress) {
        this.lecId = lecId;
        this.lecName = lecName;
        this.lecAddress = lecAddress;
    }

    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter lecturer ID: ");
        lecId = sc.nextLine();
        System.out.print("Enter lecturer name: ");
        lecName = sc.nextLine();
        System.out.print("Enter lecturer address: ");
        lecAddress = sc.nextLine();
    }

    public String getLecName() {
        return lecName;
    }

    public String getLecId() {
        return lecId;
    }

    public void setLecName(String lecName) {
        this.lecName = lecName;
    }

    public void setLecAddress(String lecAddress) {
        this.lecAddress = lecAddress;
    }

    @Override
    public String toString() {
        return "Lecturer ID: " + lecId + ", Name: " + lecName + ", Address: " + lecAddress;
    }

    public void display() {
        System.out.println(toString());
    }
}
