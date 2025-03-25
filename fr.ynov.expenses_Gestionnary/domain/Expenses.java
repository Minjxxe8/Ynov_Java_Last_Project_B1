package fr.ynov.expenses_Gestionnary.domain;

public class Expenses extends Transaction{

    public Expenses(double amount, String description, String date, String category) {
        super(amount, description, date, category);
    }

    public double getAmount() {
        return amount;
    }
}
