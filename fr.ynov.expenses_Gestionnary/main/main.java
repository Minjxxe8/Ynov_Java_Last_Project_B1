package fr.ynov.expenses_Gestionnary.main;

import fr.ynov.expenses_Gestionnary.domain.Budget;
import fr.ynov.expenses_Gestionnary.domain.Expenses;
import fr.ynov.expenses_Gestionnary.domain.Revenue;
import fr.ynov.expenses_Gestionnary.domain.Transaction;

public class main {
    public static void main(String[] args) {

        Budget budget = new Budget(500.0);
        Revenue salary = new Revenue(20.0, "Space");
        Expenses space = new Expenses(40.5, "yeah");
        Expenses yeah = new Expenses(40.5, "yeah");

        budget.getCurrentSpending();
        budget.addTransaction(space);
        budget.addTransaction(salary);
        budget.getCurrentSpending();
        budget.displayTransactions();

    }
}
