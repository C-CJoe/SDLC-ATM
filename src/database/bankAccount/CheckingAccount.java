package database.bankAccount;

/**
 * @author Joe Ye
 * @date November 2, 2017
 * @class name Checking Account
 * @description
 */
public class CheckingAccount extends BankAccount {

    private static final double INTEREST = 0.0;

    public CheckingAccount(double balance) {
        super(balance);
    }

    @Override
    public boolean deposit(double amount) {
        this.setBalance(this.inquire() + amount);
        return true;
    }

    @Override
    public boolean withdraw(double amount) {
        if (this.inquire() < amount) {
            return false;
        }
        this.setBalance(this.inquire() - amount);
        return true;
    }

    @Override
    public boolean transfer(BankAccount targetAccount, double amount) {
        if (!this.withdraw(amount)) {
            return false;
        }
        if (!targetAccount.deposit(amount)) {
            this.deposit(amount);
            return false;
        }
        return true;
    }

}
