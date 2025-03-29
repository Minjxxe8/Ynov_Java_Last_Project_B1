package fr.ynov.expenses_Gestionnary.main;

import fr.ynov.expenses_Gestionnary.domain.Budget;
import fr.ynov.expenses_Gestionnary.domain.Expenses;
import fr.ynov.expenses_Gestionnary.domain.Profile;
import fr.ynov.expenses_Gestionnary.domain.Revenue;
import fr.ynov.expenses_Gestionnary.domain.Transaction;

public class main {
    public static void main(String[] args) {

        Profile profile = new Profile("Léna", "Ricard", 600);
        profile.displayBalance();
        Budget budget = new Budget(300);
        Expenses pizza = new Expenses(20, "pizzaaaa", Transaction.Category.ALIMENTATION);
        Revenue salaire = new Revenue(400, "salaire", Transaction.Category.AUTRE);
        budget.addTransaction(pizza);
        profile.addRevenue(salaire);
        profile.displayBalance();

        budget.debtsManager.addDebts("Ambre", 3);
        budget.debtsManager.addDebts("Evan", 50 );
        budget.debtsManager.addDebts("Jean", 50 );
        budget.debtsManager.getAlleDebts();
        budget.debtsManager.displayDebts();

        budget.debtsManager.addClaims("Pascalou", 80);
        budget.debtsManager.addClaims("Isa", 90);
        budget.debtsManager.getAllClaims();
        budget.debtsManager.displayClaims();
        budget.debtsManager.displayDebtsSize();

        Expenses birthday = new Expenses(34, "birthday", Transaction.Category.AUTRE);
        budget.addTransaction(birthday);

        budget.getCurrentSpending();
        profile.displayBalance();
    }
}
