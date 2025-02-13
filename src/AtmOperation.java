package com.atmproj;

public interface AtmOperation {
    void viewBalance();
    void withdrawAmount(double amount);
    void depositAmount(double amount);
    void viewMiniStatement();
}