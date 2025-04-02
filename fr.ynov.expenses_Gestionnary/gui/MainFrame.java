package fr.ynov.expenses_Gestionnary.gui;

import fr.ynov.expenses_Gestionnary.domain.*;
import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class MainFrame extends JFrame {
    private Profile profile;
    private Budget budget;
    private JLabel balanceLabel;
    private JLabel budgetLabel;
    private JPanel transactionsPanel;
    private JPanel debtsPanel;

    public MainFrame(Profile profile, double budgetAmount) {
        this.profile = profile;
        this.budget = new Budget(profile, budgetAmount);
        profile.budget = this.budget;

        setTitle("Expenses Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel userInfoPanel = createUserInfoPanel();
        mainPanel.add(userInfoPanel, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel(new GridLayout(1, 2));

        transactionsPanel = createTransactionsPanel();
        JScrollPane transactionsScroll = new JScrollPane(transactionsPanel);
        centerPanel.add(transactionsScroll);

        debtsPanel = createDebtsPanel();
        JScrollPane debtsScroll = new JScrollPane(debtsPanel);
        centerPanel.add(debtsScroll);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        JPanel buttonPanel = createButtonPanel();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        updateDisplay();
    }

    private JPanel createUserInfoPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("LastName: " + profile.lastName));
        panel.add(new JLabel(" | Name: " + profile.name));
        balanceLabel = new JLabel(" | Balance: " + profile.balance + "€");
        panel.add(balanceLabel);
        budgetLabel = new JLabel(" | Monthly Budget: " + budget.totalBudget + "€" +
                " | Actual Expenses: " + budget.currentSpending + "€");
        panel.add(budgetLabel);

        return panel;
    }

    private JPanel createTransactionsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Transactions"));
        return panel;
    }

    private JPanel createDebtsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Debts and Claims"));
        return panel;
    }

    private void showAddExpenseDialog() {
        JTextField amountField = new JTextField();
        JTextField descriptionField = new JTextField();
        JComboBox<Transaction.Category> categoryBox = new JComboBox<>(Transaction.Category.values());

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Amount:"));
        panel.add(amountField);
        panel.add(new JLabel("Description:"));
        panel.add(descriptionField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryBox);

        int result = JOptionPane.showConfirmDialog(this, panel,
                "New Expense : ", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                double amount = Double.parseDouble(amountField.getText());
                String description = descriptionField.getText();
                Transaction.Category category = (Transaction.Category) categoryBox.getSelectedItem();

                Expenses expense = new Expenses(amount, description, category);
                budget.addTransaction(expense);
                updateDisplay();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid amount",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showAddDebtDialog() {
        JTextField nameField = new JTextField();
        JTextField amountField = new JTextField();
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Amount:"));
        panel.add(amountField);

        int result = JOptionPane.showConfirmDialog(this, panel,
                "New Debts", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String name = nameField.getText();
                double amount = Double.parseDouble(amountField.getText());
                budget.debtsManager.addDebts(name, amount);
                updateDisplay();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid amount",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showAddRevenueDialog() {
        JTextField amountField = new JTextField();
        JTextField descriptionField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Amount:"));
        panel.add(amountField);
        panel.add(new JLabel("Description:"));
        panel.add(descriptionField);

        int result = JOptionPane.showConfirmDialog(this, panel,
                "New revenue", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                double amount = Double.parseDouble(amountField.getText());
                String description = descriptionField.getText();
                Revenue revenue = new Revenue(amount, description, Transaction.Category.AUTRE);
                profile.addRevenue(revenue);
                updateDisplay();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid amount",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();

        JButton addExpenseButton = new JButton("Add Expense");
        addExpenseButton.addActionListener(e -> showAddExpenseDialog());

        JButton addDebtButton = new JButton("Add Debt");
        addDebtButton.addActionListener(e -> showAddDebtDialog());

        JButton addClaimButton = new JButton("Add Claim");
        addClaimButton.addActionListener(e -> showAddClaimDialog());

        JButton addRevenueButton = new JButton("Add Revenue");
        addRevenueButton.addActionListener(e -> showAddRevenueDialog());

        panel.add(addExpenseButton);
        panel.add(addDebtButton);
        panel.add(addClaimButton);
        panel.add(addRevenueButton);

        return panel;
    }

    private void showAddClaimDialog() {
        JTextField nameField = new JTextField();
        JTextField amountField = new JTextField();
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Amount:"));
        panel.add(amountField);

        int result = JOptionPane.showConfirmDialog(this, panel,
                "New Claim", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String name = nameField.getText();
                double amount = Double.parseDouble(amountField.getText());
                budget.debtsManager.addClaims(name, amount);
                updateDisplay();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid amount",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateDisplay() {
        // Mise à jour des labels
        balanceLabel.setText(" | Balance : " + profile.balance + "€");
        budgetLabel.setText(" | Monthly Budget :" + budget.totalBudget + "€" +
                " | Actual Expenses : " + budget.currentSpending + "€");

        transactionsPanel.removeAll();

        transactionsPanel.add(new JLabel("Expenses:"));
        if (budget.transactions != null) {
            for (Transaction transaction : budget.transactions) {
                if (transaction instanceof Expenses) {
                    JPanel transactionLine = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    transactionLine.add(new JLabel("Expense: " + transaction.getAmount() +
                            "€ - " + transaction.getDescription() + " (" + transaction.getCategory() + ")"));
                    transactionsPanel.add(transactionLine);
                }
            }
        }

        transactionsPanel.add(new JLabel("Revenue:"));
        if (profile.transactions != null) {
            for (Transaction transaction : profile.transactions) {
                if (transaction instanceof Revenue) {
                    JPanel transactionLine = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    transactionLine.add(new JLabel("Revenue: " + transaction.getAmount() +
                            "€ - " + transaction.getDescription()));
                    transactionsPanel.add(transactionLine);
                }
            }
        }

        debtsPanel.removeAll();
        if (budget.debtsManager != null) {
            debtsPanel.add(new JLabel("Your Debts:"));
            for (Map.Entry<String, Double> debt : budget.debtsManager.debts.entrySet()) {
                JPanel debtLine = new JPanel(new FlowLayout(FlowLayout.LEFT));
                debtLine.add(new JLabel(debt.getKey() + ": " + debt.getValue() + "€"));
                debtsPanel.add(debtLine);
            }

            debtsPanel.add(new JLabel("Your Claims:"));
            for (Map.Entry<String, Double> claim : budget.debtsManager.claims.entrySet()) {
                JPanel claimLine = new JPanel(new FlowLayout(FlowLayout.LEFT));
                claimLine.add(new JLabel(claim.getKey() + ": " + claim.getValue() + "€"));
                debtsPanel.add(claimLine);
            }
            debtsPanel.add(new JLabel("Total of debts: " + budget.debtsManager.allDebts + "€"));
            debtsPanel.add(new JLabel("Total of claims: " + budget.debtsManager.allClaims + "€"));
        }

        revalidate();
        repaint();
    }
}