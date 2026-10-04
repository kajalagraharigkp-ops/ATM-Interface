/**
 * Main contains the main() method - the entry point of the program.
 */
public class Main {
    public static void main(String[] args) {

        // 1. Create a BankAccount object (name, account number, opening balance)
        BankAccount account = new BankAccount("Deeksha", "1234567890", 20000);

        // 2 & 3. Create an ATM object and connect it with the account
        ATM atm = new ATM(account);

        // 4. Start the ATM menu
        atm.start();
    }
}
