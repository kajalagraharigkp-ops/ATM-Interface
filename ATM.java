import java.util.Scanner;

/**
 * ATM represents the ATM machine.
 * It shows the menu, reads user input and calls BankAccount methods.
 */
public class ATM {

    // Object composition/association: ATM "has a" BankAccount
    private BankAccount account;
    private Scanner scanner;

    // Constructor: connects the ATM with a bank account
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Starts the ATM: shows the menu repeatedly until the user exits
    public void start() {
        boolean running = true;

        System.out.println("=================================");
        System.out.println("        WELCOME TO ATM");
        System.out.println("=================================");
        System.out.println();
        System.out.println("Account Holder: " + account.getAccountHolderName());

        while (running) {
            displayMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    System.out.println();
                    account.checkBalance();
                    break;
                case 2:
                    double withdrawAmount = readDouble("\nEnter amount to withdraw: ");
                    if (!Double.isNaN(withdrawAmount)) {
                        System.out.println();
                        account.withdraw(withdrawAmount);
                    }
                    break;
                case 3:
                    double depositAmount = readDouble("\nEnter amount to deposit: ");
                    if (!Double.isNaN(depositAmount)) {
                        System.out.println();
                        account.deposit(depositAmount);
                    }
                    break;
                case 4:
                    System.out.println("\nThank you for using our ATM.");
                    System.out.println("Have a nice day!");
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid choice! Please enter a number from 1 to 4.");
            }

            if (running) {
                System.out.println("\n---------------------------------");
            }
        }
        scanner.close();
    }

    // Prints the menu
    private void displayMenu() {
        System.out.println();
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Exit");
        System.out.println();
    }

    // Reads an integer safely. Returns -1 if the input is not a number.
    private int readInt(String message) {
        System.out.print(message);
        String input = scanner.nextLine().trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;   // falls into the "invalid choice" case
        }
    }

    // Reads a double safely. Returns NaN if the input is not a valid number.
    private double readDouble(String message) {
        System.out.print(message);
        String input = scanner.nextLine().trim();
        try {
            double value = Double.parseDouble(input);
            if (Double.isNaN(value) || Double.isInfinite(value)) {
                throw new NumberFormatException();
            }
            return value;
        } catch (NumberFormatException e) {
            System.out.println("\nInvalid input! Please enter a numeric amount.");
            return Double.NaN;
        }
    }
}
