package fr.ynov.expenses_Gestionnary.domain;

public class Budget {
    public double amount;
    public double currentSpending;

    public Budget(double amount) {
        this.amount = amount;
        this.currentSpending = amount;
    }
}
