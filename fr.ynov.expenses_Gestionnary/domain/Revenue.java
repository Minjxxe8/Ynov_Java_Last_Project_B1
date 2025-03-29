package fr.ynov.expenses_Gestionnary.domain;

public class Revenue extends Transaction {
    public Revenue(double amount, String description, Category category) {
        super(amount, description, Category.AUTRE);
    }

    @Override
    public double getChange() {
        return -    amount;
    }
}
