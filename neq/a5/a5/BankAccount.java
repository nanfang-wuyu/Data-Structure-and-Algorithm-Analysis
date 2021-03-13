package a5.a5;

import a5.a5.Customer;

public class BankAccount {
    private Customer owner;
    private double balance;

    public BankAccount(Customer customer, double balance) {
        setOwner(customer);
        setBalance(balance);
    }

    public Customer getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setOwner(Customer customer) {
        owner = customer;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
