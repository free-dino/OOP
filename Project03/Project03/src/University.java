import java.util.Scanner;

class University {
    protected String uniName;
    protected String uniAddress;

    public University() {}

    public University(String uniName, String uniAddress) {
        this.uniName = uniName;
        this.uniAddress = uniAddress;
    }

    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter university name: ");
        uniName = sc.nextLine();
        System.out.print("Enter university address: ");
        uniAddress = sc.nextLine();
    }

    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "University Name: " + uniName + ", Address: " + uniAddress;
    }
}
