/** Personal Project: VirtualBank
 * @author: Ella Tran
 * Description: This class represents a savings account with an interest rate
 * */

public class Savings extends Account {
    private double interestRate;

    public Savings(String accountNumber, String accountName, double initBalance, double interest) {
        super(accountNumber, accountName, initBalance);
        this.interestRate = interest;
    }

    public void applyInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest paid: $" + interest);
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
    }
}
