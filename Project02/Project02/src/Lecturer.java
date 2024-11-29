import java.util.Scanner;

class Lecturer extends Person {
    private String lecId;

    public Lecturer() {}

    public Lecturer(String name, String address, String lecId) {
        super(name, address);
        this.lecId = lecId;
    }

    @Override
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter lecturer ID: ");
        lecId = sc.nextLine();
        System.out.print("Enter name: ");
        name = sc.nextLine();
        System.out.print("Enter address: ");
        address = sc.nextLine();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return super.toString() + ", Lecturer ID: " + lecId;
    }

    @Override
    public void display() {
        System.out.println(toString());
    }
}
