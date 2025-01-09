/** Personal Project: VirtualBank
 * @author: Ella Tran
 * Description: This class represents a checking account with overdraft protection
 * */

public class Chequing extends Account {
    private double overdraftLimit;

    public Chequing(String accountNumber, String accountName, double initBalance, double overdraftLimit) {
        super(accountNumber, accountName, initBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        }
        else if (amount > 0 && amount > balance && amount <= overdraftLimit){
            balance -= amount;
            System.out.println("Overdrawn: $" + amount);
        }
        else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Chequing Account");
    }
}
