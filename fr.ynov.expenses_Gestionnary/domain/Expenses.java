package fr.ynov.expenses_Gestionnary.domain;

public class Expenses extends Transaction{

    public Expenses(double amount, String description, Category category) {
        super(amount, description, Category.AUTRE);
    }


    @Override
    public double getChange() {
        return amount;
    }
}
