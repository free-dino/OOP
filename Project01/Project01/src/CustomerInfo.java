import java.util.Scanner;

public class CustomerInfo {
    private String customerName;
    private String customerAdd;

    public CustomerInfo(String customerName, String customerAdd) {
        this.customerName = customerName;
        this.customerAdd = customerAdd;
    }

    public CustomerInfo() {
    }

    public String getName() {
        return customerName;
    }

    public void setName(String customerName) {
        this.customerName = customerName;
    }

    public String getAdd() {
        return customerAdd;
    }

    public void setAdd(String customerAdd) {
        this.customerAdd = customerAdd;
    }

    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter customer name: ");
        this.customerName = sc.nextLine();
        System.out.println("Enter customer add: ");
        this.customerAdd = sc.nextLine();
    }

    public String toString() {
        return customerName + ", " + customerAdd;
    }

    public void display() {
        System.out.println(this.toString());
    }
}
