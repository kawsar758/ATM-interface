package com.atmproj;

public class ATM {
    private double balance;

    // Default constructor
    public ATM() {
        this.balance = 0.0;
    }

    // Get current balance
    public double getBalance() {
        return balance;
    }

    // Update balance after deposit or withdrawal
    public void updateBalance(double amount) {
        this.balance += amount;
    }
}
