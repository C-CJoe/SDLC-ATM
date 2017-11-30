package database.bankAccount;

/**
 * @author Joe Ye
 * @date November 2, 2017
 * @class name Revolving Account
 * @description 
 */

public class RevolvingAccount extends BankAccount {
    private static final double INTEREST = 0.0;
    private static final double LOANINTEREST = 0.0;
    
    private double loan;
    private double maxLoan;
    
    public RevolvingAccount(double balance, double amount) {
        super(balance);
        loan = 0;
        maxLoan = amount;
    }
    
    @Override
    public boolean deposit(double amount) {
        //loan update
        if (loan > 0)
            if (amount > loan) {
                amount -= loan;
                loan = 0;
            } else {
                loan -= amount;
                return true;
            }
        
        this.setBalance(this.inquire() + amount);
        return true;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount - this.inquire() > maxLoan) return false;
        if (amount > this.inquire()) {
            this.setBalance(0.0);
            loan = amount - this.inquire();
        } else this.setBalance(this.inquire() - amount);
        return true;
    }

    @Override
    public boolean transfer(BankAccount targetAccount, double amount) {
        if (!this.withdraw(amount)) return false;
        if (!targetAccount.deposit(amount)) {
            this.deposit(amount);
            return false;
        }
        return true;
    }
    
}
