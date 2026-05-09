package org.example.springsyatem.springbank.Model;

public class BankAccount {
    private long accountNumber;
    private String name;
    private double balance;

    public BankAccount() {
    }

 public BankAccount(long accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        System.out.println("BankAccount Create Successful");
    }
