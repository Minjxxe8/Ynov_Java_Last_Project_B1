package fr.ynov.expenses_Gestionnary.domain;
import java.util.ArrayList;
import java.util.List;

public class Budget {
    public double currentSpending;
    public double totalBudget;
    public List <Transaction> transactions;

    public Budget(double totalBudget) {
        this.currentSpending = 0.0;
        this.totalBudget = totalBudget;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        double newTransaction = transaction.getAmount();

        if (transaction instanceof Expenses) {
            Debts debts = new Debts();
            if (debts.getDebtsSize() > 0) {
                if (transaction.getAmount() > 10) {
                    transactions.add(transaction);
                    currentSpending += transaction.getAmount();
                    System.out.println("You have added a new expense :" + newTransaction);
                } else {
                    System.out.println("You can't add expenses, you have debts to paid before");
                }
            }
            if (newTransaction + currentSpending > totalBudget) {
                System.out.println("You can't add this transaction, with it, its more than your budget...");
            } else {
                transactions.add(transaction);
                currentSpending += transaction.getAmount();
                System.out.println("You have added a new expense :" + newTransaction);
            }
        }
    }

    public void getCurrentSpending() {
        System.out.println("Current Spending : " + currentSpending);
    }

    public void displayTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

}
