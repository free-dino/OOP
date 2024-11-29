import java.util.Scanner;

public class BankAccount extends CustomerInfo{
    private String accountNo;
    private double accountBalance;
    private double withdrawalNum;
    private double depositNum;
    private double accountInterest;

    public BankAccount(String customerName, String customerAdd, String accountNo, double accountBalance, double accountInterest) {
        super(customerName, customerAdd);
        this.accountBalance = accountBalance;
        this.accountNo = accountNo;
        this.accountInterest = accountInterest;
    }

    public BankAccount() {
        super();
    }

    public void inputData() {
        super.inputData();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account no: ");
        this.accountNo = sc.nextLine();
        System.out.println("Enter account balance: ");
        this.accountBalance = sc.nextDouble();
        System.out.println("Enter account interest: ");
        this.accountInterest = sc.nextDouble();
    }

    public boolean doWithdraw(double amount) {
        if (amount > 0 && amount <= this.accountBalance) {
            this.accountBalance -= amount;
            this.withdrawalNum = amount;
            return true;
        }
        else {
            System.out.println("Insufficient balance or invalid amount");
            return false;
        }
    }

    public void doDeposit(double amount) {
        if (amount > 0){
            this.accountBalance += amount;
            depositNum = amount;
        }
        else {
            System.out.println("Invalid deposit amount");
        }
    }

    public double computeMonthInterest() {
        double monthlyInterest = this.accountBalance * this.accountInterest / 100;
        this.accountBalance += monthlyInterest;
        return monthlyInterest;
    }
    
    public boolean transferMoney(BankAccount destination, double amount) {
        if (destination == null){
            System.out.println("Destination is null");
            return false;
        }

        if (doWithdraw(amount)) {
            destination.doDeposit(amount);
            return true;
        }
        else {
            System.out.println("Insufficient balance");
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Account No: " + accountNo + ", Balance: " + accountBalance + ", Interest Rate: " + accountInterest + "%";
    }

    @Override
    public void display() {
        System.out.println(this.toString());
    }

    public double getWithdrawalNum() {
        return withdrawalNum;
    }

    public double getDepositNum() {
        return depositNum;
    }
}
