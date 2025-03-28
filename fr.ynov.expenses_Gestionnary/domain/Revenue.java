package fr.ynov.expenses_Gestionnary.domain;

public class Revenue extends Transaction {
    public Revenue(double amount, String description) {
        super(amount, description);
    }

    @Override
    public double getChange() {
        return -amount;
    }
}
