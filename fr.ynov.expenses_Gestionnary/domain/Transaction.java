package fr.ynov.expenses_Gestionnary.domain;

import java.util.List;

public abstract class Transaction {
    public double amount;
    public String description;
    public String date;
    public Category category;
    public List<Expenses> expenses;
    public List<Revenue> revenues;

    public Transaction(double amount, String description, Category category) {
        this.amount = amount;
        this.description = "";
        this.date = "";
        this.category = category;
    }

    public enum Category {
        ALIMENTATION,
        TRANSPORT,
        LOGEMENT,
        LOISIRS,
        SANTÉ,
        AUTRE
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category.name();
    }

    public abstract double getChange();

}
