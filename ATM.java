import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}

// ATM Machine class with interface
public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    // Step 3: Methods
    public void withdraw(double amount) {
        account.withdraw(amount);
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + account.getBalance());
    }

    // Main UI
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== ATM Menu =====");
            System.out.println(">>>>>Wellcome to the ATM<<<<<");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);

        scanner.close();
    }

    // Main method to run the program
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(10000.00); // starting with ₹10,000
        ATM atm = new ATM(userAccount);
        atm.showMenu();
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }
}


