package com.trckstr;

public class BankAccount {

    private String name;
    private double balance;
    public static double commission = 0;


    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    // 0.5% commission
    public void add(double money) {
        balance = (balance + money) * ((100 - 0.5) / 100);
        commission += (balance + money) - (balance + money) * ((100 - 0.5) / 100);
        System.out.println("Начальный баланс аккаунта " + getName() + " " + getBalance());
        //balance += 99.5
    }

    // 1% commission
    public void transfer(BankAccount otherPerson, double money) {
        balance = getBalance() - money;
        otherPerson.balance += money*0.99;
        commission += money - money*0.99;
        System.out.println("Баланс аккаунта " + otherPerson.getName() + " " + otherPerson.getBalance());
    }
}