package fr.ynov.expenses_Gestionnary.domain;

public class Profile {
    public String name;
    public String lastName;
    public Budget budget;
    public double balance;
    public double debts;
    public double revenue;

    public Profile(String name, String lastName, double balance) {
        this.name = name;
        this.lastName = lastName;
        this.balance = balance;
        this.budget = null;
        this.debts = 0;
        this.revenue = 0;
    }

}
