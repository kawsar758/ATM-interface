package com.atmproj;

import java.util.LinkedHashMap;
import java.util.Map;

public class Atmopimpl implements AtmOperation {
    private final ATM atm = new ATM();
    private final Map<Double, String> ministmt = new LinkedHashMap<>();
    private int atmPin = 123;

    // Change PIN
    public void changePin(int newPin) {
        this.atmPin = newPin;
        ministmt.put(0.0, "PIN Changed Successfully");
        System.out.println("PIN changed successfully.");
    }

    // View balance
    @Override
    public void viewBalance() {
        System.out.println("Available Balance: " + atm.getBalance());
    }

    // Withdraw amount
    @Override
    public void withdrawAmount(double amount) {
        if (amount % 500 != 0) {
            System.out.println("Please enter the amount in multiples of 500.");
        } else if (amount > atm.getBalance()) {
            System.out.println("Insufficient balance.");
        } else {
            atm.updateBalance(-amount);
            ministmt.put(amount, "Amount Withdrawn");
            System.out.println("Collect the cash: " + amount);
            viewBalance();
        }
    }

    // Deposit amount
    @Override
    public void depositAmount(double amount) {
        atm.updateBalance(amount);
        ministmt.put(amount, "Amount Deposited");
        System.out.println(amount + " deposited successfully.");
        viewBalance();
    }

    // View mini statement
    @Override
    public void viewMiniStatement() {
        if (ministmt.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            ministmt.forEach((k, v) -> System.out.println(k + " - " + v));
        }
    }

    // Get current PIN
    public int getAtmPin() {
        return atmPin;
    }
}