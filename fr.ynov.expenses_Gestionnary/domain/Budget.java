package fr.ynov.expenses_Gestionnary.domain;
import java.util.ArrayList;
import java.util.List;

public class Budget {
    public double currentSpending;
    public double totalBudget;
    public List <Expenses> expenses;
    public List <Revenue> revenues;

    public Budget(double totalBudget) {
        this.currentSpending = currentSpending;
        this.totalBudget = totalBudget;
        this.expenses = new ArrayList<>();
    }

    public Boolean addExpenses(Expenses expense) {
        if (expense.getAmount() + currentSpending >= totalBudget) {
            System.out.println("You cannot add this expenses, its more than you're budget");
            return false;
        }
        expenses.add(expense);
        totalBudget -= expense.getAmount();
        System.out.println("You have budgeted " + expense.getAmount());
        return true;
    }

    public Boolean addRevenue(Revenue revenue) {
        if (currentSpending - revenue.getRevenue() < 0.0) {
            totalBudget = totalBudget;
            System.out.println("Your budget is now to : " + revenue.getRevenue());
            return false;
        }
        revenues.add(revenue);
        currentSpending -= revenue.getRevenue();;
        return true;
    }

}
