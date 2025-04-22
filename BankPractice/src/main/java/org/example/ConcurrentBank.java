package org.example;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ConcurrentBank {
    private final ConcurrentMap<Integer, BankAccount> accounts = new ConcurrentHashMap<>();
    private final Lock bankLock = new ReentrantLock();
    private int initialAccNumber = 1;

    public BankAccount createAccount(double initialBalance) {
        int accountNumber = generateAccountNumber();
        BankAccount account = new BankAccount(initialBalance);
        accounts.put(accountNumber, account);
        return account;
    }

    public boolean transfer(BankAccount firstAcc, BankAccount secondAcc, double amount) {
        if (firstAcc == null || secondAcc == null) {
            throw new IllegalArgumentException("Отсутствует аккаунт");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма не может быть отрицательной");
        }
        firstAcc.lock.lock();
        try {
            secondAcc.lock.lock();
            try {
                if (firstAcc.getBalance() < amount) {
                    return false;
                }
                firstAcc.withdraw(amount);
                secondAcc.deposit(amount);
                return true;
            } finally {
                secondAcc.lock.unlock();
            }
        } finally {
            firstAcc.lock.unlock();
        }
    }

    public double getTotalBalance() {
        bankLock.lock();
        try {
            return accounts.values().stream()
                    .mapToDouble(BankAccount::getBalance)
                    .sum();
        } finally {
            bankLock.unlock();
        }
    }
    private int generateAccountNumber() {
        return initialAccNumber++;
    }
}