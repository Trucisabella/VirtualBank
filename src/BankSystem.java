/** Personal Project: VirtualBank
 * @author: Ella Tran
 * Description: This class manages user interactions, account creation, and transactions.
 * */

import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem {
    private ArrayList<Account> accounts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n~~~ Menu ~~~");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            if (option == 1){
                createAccount();
            }
            else if (option == 2){
                deposit();
            }
            else if (option == 3){
                withdraw();
            }
            else if (option == 4){
                checkBalance();
            }
            else if (option == 5){
                System.out.println("Thank you for using VirtualBank!");
                return;
            }
            else {
                System.out.println("Invalid choice. Try again!");
            }
        }
    }

    private void createAccount() {
        System.out.println("\n~~~ Create Account ~~~");
        System.out.print("Enter Account Holder Name: ");
        scanner.nextLine();
        String holder = scanner.nextLine();

        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Choose Account Type:\n\t 1. Savings\n\t 2. Checking\nOption: ");
        int type = scanner.nextInt();

        System.out.print("Enter Initial Balance: $");
        double initialBalance = scanner.nextDouble();

        if (type == 1) {
            System.out.print("Enter Interest Rate (%): ");
            double interestRate = scanner.nextDouble();
            accounts.add(new Savings(accountNumber, holder, initialBalance, interestRate));
            System.out.println("Savings Account created successfully!");
        }
        else if (type == 2) {
            System.out.print("Enter Overdraft Limit: $");
            double overdraftLimit = scanner.nextDouble();
            accounts.add(new Chequing(accountNumber, holder, initialBalance, overdraftLimit));
            System.out.println("Chequing Account created successfully!");
        }
        else {
            System.out.println("Invalid account type.");
        }
    }

    private Account findAccount(String accountNumber) {
        return accounts.stream()
                .filter(acc -> acc.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElse(null);
    }

    private void deposit() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.next();
        Account account = findAccount(accountNumber);

        if (account != null) {
            System.out.print("Enter Amount to Deposit: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        }
        else {
            System.out.println("Account not found!");
        }
    }

    private void withdraw() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.next();
        Account account = findAccount(accountNumber);

        if (account != null) {
            System.out.print("Enter Amount to Withdraw: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        }
        else {
            System.out.println("Account not found!");
        }
    }

    private void checkBalance() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.next();
        Account account = findAccount(accountNumber);

        if (account != null) {
            System.out.println("Account Holder: " + account.getAccountName());
            System.out.println("Balance: $" + account.getBalance());
        }
        else {
            System.out.println("Account not found!");
        }
    }
}
