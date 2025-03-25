package fr.ynov.expenses_Gestionnary.domain;

public class Transaction {
    public double amount;
    public String description;
    public String date;
    public String category;

    public Transaction(double amount, String description, String date, String category) {
        this.amount = 0.0;
        this.description = "";
        this.date = "";
        this.category = "";
    }

}
