package fr.ynov.expenses_Gestionnary.domain;

public class Revenue extends Transaction {
    public Revenue(double amount, String description, String date, String category) {
        super(amount, description, date, category);
    }

    public double getRevenue() {
        return amount;
    }
}
