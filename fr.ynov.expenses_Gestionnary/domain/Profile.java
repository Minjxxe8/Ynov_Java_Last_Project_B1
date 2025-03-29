package fr.ynov.expenses_Gestionnary.domain;

import java.util.ArrayList;
import java.util.List;

public class Profile {
    public String name;
    public String lastName;
    public Budget budget;
    public double balance;
    public DebtsManager debtsManager;
    public Revenue revenue;
    public List<Transaction> transactions;

    public Profile(String name, String lastName, double balance) {
        this.name = name;
        this.lastName = lastName;
        this.balance = balance;
        this.budget = null;
        this.debtsManager = null;
        this.revenue = null;
        this.transactions = new ArrayList<>();
    }

    public void addRevenue(Transaction transaction) {
        if (transaction instanceof Revenue) {
            if (transaction.getAmount() == 0) {
                System.out.println("There is no revenue...");
            } else {
                transactions.add(transaction);
                balance += transaction.getAmount();
                System.out.println("Revenue : " + transaction.getAmount());
            }
        }
    }

    public void displayBalance() {
        System.out.println("Balance : " + balance);
    }

}
