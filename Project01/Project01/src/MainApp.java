import java.io.*;
import java.util.*;

public class MainApp {
    // Fields for storing accounts using different collection types
    private BankAccount[] accountArray;
    private Vector<BankAccount> accountVector;
    private Hashtable<String, BankAccount> accountHashTable;
    private ArrayList<BankAccount> accountList;

    // Constructor to initialize collections
    public MainApp() {
        accountArray = new BankAccount[10]; // Default size
        accountVector = new Vector<>();
        accountHashTable = new Hashtable<>();
        accountList = new ArrayList<>();
    }

    // initBank method
    public void initBank() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How would you like to initialize accounts?");
        System.out.println("1. Enter manually");
        System.out.println("2. Load from file");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        switch (choice) {
            case 1:
                System.out.println("How many accounts do you want to create?");
                int count = scanner.nextInt();
                scanner.nextLine(); // Consume the newline
                for (int i = 0; i < count; i++) {
                    BankAccount account = new BankAccount();
                    System.out.println("Enter details for account " + (i + 1) + ":");
                    account.inputData();
                    addAccount(account);
                }
                break;

            case 2:
                System.out.println("Enter the file path:");
                String filePath = scanner.nextLine();
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split("\t");
                        if (parts.length == 4) {
                            String name = parts[0];
                            String add = parts[1];
                            String accountNo = parts[2];
                            double balance;
                            balance = Double.parseDouble(parts[3]);
                            BankAccount account = new BankAccount(name, add, accountNo, balance, 0); // Assuming 0% interest
                            addAccount(account);
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

    // Add account to all collections
    private void addAccount(BankAccount account) {
        if (account != null) {
            // Add to array (if space available)
            for (int i = 0; i < accountArray.length; i++) {
                if (accountArray[i] == null) {
                    accountArray[i] = account;
                    break;
                }
            }

            // Add to other collections
            accountVector.add(account);
            accountHashTable.put(account.getName(), account);
            accountList.add(account);
        }
    }

    // display method
    public void display() {
        System.out.println("Displaying all accounts:");
        for (BankAccount account : accountList) {
            account.display();
        }
    }

    // transferSimulation method
    public void transferSimulation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter sender account name:");
        String senderName = scanner.nextLine();
        BankAccount sender = accountHashTable.get(senderName);

        System.out.println("Enter recipient account name:");
        String recipientName = scanner.nextLine();
        BankAccount recipient = accountHashTable.get(recipientName);

        if (sender == null || recipient == null) {
            System.out.println("One or both accounts not found.");
            return;
        }

        System.out.print("Enter transfer amount: ");
        double amount = scanner.nextDouble();

        if (sender.transferMoney(recipient, amount)) {
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Transfer failed.");
        }
    }

    // withDrawSimulation method
    public void withDrawSimulation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter account name:");
        String name = scanner.nextLine();
        BankAccount account = accountHashTable.get(name);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();

        if (account.doWithdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Withdrawal failed.");
        }
    }

    // depositSimulation method
    public void depositSimulation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter account name:");
        String name = scanner.nextLine();
        BankAccount account = accountHashTable.get(name);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();

        account.doDeposit(amount);
        System.out.println("Deposit successful.");
    }

    // Main method to test all functionalities
    public static void main(String[] args) {
        MainApp app = new MainApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBank Application Menu:");
            System.out.println("1. Initialize Bank Accounts");
            System.out.println("2. Display All Accounts");
            System.out.println("3. Simulate Money Transfer");
            System.out.println("4. Simulate Withdrawal");
            System.out.println("5. Simulate Deposit");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    app.initBank();
                    break;
                case 2:
                    app.display();
                    break;
                case 3:
                    app.transferSimulation();
                    break;
                case 4:
                    app.withDrawSimulation();
                    break;
                case 5:
                    app.depositSimulation();
                    break;
                case 6:
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
