package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private double balance;
    public final Lock lock = new ReentrantLock();

    public BankAccount(double initialBalance) {

        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Сумма не может быть отрицательным");
            }
            balance += amount;
        } finally {
            lock.unlock();
        }

    }

    public void withdraw(double amount) {
        lock.lock();
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Сумма не может быть отрицательным");
            }
            if (balance < amount) {
                throw new IllegalStateException("Недостаточно средств");
            }
            balance -= amount;
        } finally {
            lock.unlock();
        }
    }

    public double getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }

}
