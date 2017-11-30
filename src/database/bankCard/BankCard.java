package database.bankCard;

import database.bankAccount.BankAccount;

import java.util.ArrayList;

/**
 * @author Joe Ye
 * @date November 2, 2017
 * @class name Card
 * @description 
 */

public abstract class BankCard {
    private final String number;
    private String PIN;
    private boolean activate;
    private static int wrongPINTimes = 0;
    private static final int MAXWRONGPINTIMES = 5;
    
    private ArrayList<BankAccount> accounts;
    
    public BankCard(String number, String PIN) { //card number generator
        this.number = number;
        this.PIN = PIN;
        activate = true;
    }
    
    public String cardNumber() { return number; }
    
    public boolean changePIN(String newPIN) {
        PIN = newPIN;
        return true;
    }
    
    public boolean is_activated() { return activate; }
    
    public boolean deativate() {
        activate = false;
        return true;
    }
    
    public boolean enter(String PIN) {
        if (!this.PIN.equals(PIN)) {
            if (++wrongPINTimes > MAXWRONGPINTIMES) this.deativate();
            return false;
        }
        wrongPINTimes = 0;
        return true;
    }
    
    protected ArrayList<BankAccount> accounts() { return accounts; }
    
    public abstract boolean link(BankAccount account);
    public abstract boolean remove(BankAccount account);
}
