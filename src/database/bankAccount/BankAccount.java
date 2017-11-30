package database.bankAccount;

/**
 * @author Joe Ye
 * @date November 2, 2017
 * @class name Account
 * @description
 */

public abstract class BankAccount {
    private double balance;
    //transation record
    
    public BankAccount(double amount) { balance = amount; }
    
    public abstract boolean deposit(double amount);
    public abstract boolean withdraw(double amount);
    public abstract boolean transfer(BankAccount targetAccount, double amount);
    public double inquire() { return balance; }
    protected void setBalance(double amount) { balance = amount; }
}
