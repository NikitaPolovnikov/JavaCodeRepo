package org.example;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public class ConcurrentBank {
    private final ConcurrentMap<Integer, BankAccount> accounts = new ConcurrentHashMap<>();
    private int initialAccNumber = 1;

    public synchronized BankAccount createAccount(double initialBalance) {
        int accountNumber = generateAccountNumber();
        BankAccount account = new BankAccount(initialBalance);
        accounts.put(accountNumber, account);
        return account;
    }

    public synchronized boolean transfer(BankAccount firstAcc, BankAccount secondAcc, double amount) {
        try {
            try {
                if (firstAcc.getBalance() < amount) {
                    return false;
                }
                firstAcc.withdraw(amount);
                secondAcc.deposit(amount);
                return true;
            } catch (Exception e){
                System.out.println("");
                return false;
            }
        } catch (Exception e){
            System.out.println("");
            return false;
        }
    }

    public synchronized double getTotalBalance() {
        try {
            return accounts.values().stream()
                    .mapToDouble(BankAccount::getBalance)
                    .sum();
        } catch (Exception e){
            System.out.println("");
            return 0;
        }
    }
    private int generateAccountNumber() {
        return initialAccNumber++;
    }
}