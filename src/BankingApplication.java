import java.util.Scanner;

class BankAccount {
    private final String accountHolderName;
    private double balance;

    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: $" +balance);
    }

    public void accountSummary() {
        System.out.println("\n---- Account Summary ----");
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current balance: $" +balance);
    }

}

public class BankingApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial deposit amount: ");
        double initialDeposit = scanner.nextDouble();
        BankAccount account = new BankAccount(name, initialDeposit);

        while (true) {
            System.out.println("\n=== Banking Menu ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Summary");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    account.accountSummary();
                    break;
                case 5:
                    System.out.println("Thank you for using the banking application. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
