/** Personal Project: VirtualBank
 * @author: Ella Tran
 * Description: Abstract base class representing a generic bank account
 * */

public abstract class Account {
    //Attributes
    private String accountNumber;
    private String accountName;
    protected double balance;

    public Account(String accountNumber, String accountName, double initBalance){
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = initBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        }
        else if (amount <= 0){
            System.out.println("Invalid withdrawal amount.");
        }
        else {
            System.out.println("Withdrawal amount cannot exceed current balance!");
        }
    }

    public abstract void displayAccountType();
}
