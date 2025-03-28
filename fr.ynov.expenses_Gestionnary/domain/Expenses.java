package fr.ynov.expenses_Gestionnary.domain;

public class Expenses extends Transaction{

    public Expenses(double amount, String description) {
        super(amount, description);
    }


    @Override
    public double getChange() {
        return amount;
    }
}
