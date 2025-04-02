package fr.ynov.expenses_Gestionnary.gui;

import fr.ynov.expenses_Gestionnary.domain.Profile;
import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private JTextField nameField;
    private JTextField lastNameField;
    private JTextField initialBalanceField;
    private JTextField budgetField;

    public LoginFrame() {
        setTitle("Login - Expense Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        mainPanel.add(new JLabel("LastName:"));
        nameField = new JTextField();
        mainPanel.add(nameField);

        mainPanel.add(new JLabel("Name:"));
        lastNameField = new JTextField();
        mainPanel.add(lastNameField);

        mainPanel.add(new JLabel("Initial Balance :"));
        initialBalanceField = new JTextField();
        mainPanel.add(initialBalanceField);

        mainPanel.add(new JLabel("Mensual budget :"));
        budgetField = new JTextField();
        mainPanel.add(budgetField);

        JButton loginButton = new JButton("Connexion");
        loginButton.addActionListener(e -> login());

        mainPanel.add(new JLabel(""));
        mainPanel.add(loginButton);

        add(mainPanel);
    }

    private void login() {
        try {
            String name = nameField.getText().trim();
            String lastName = lastNameField.getText().trim();
            double balance = Double.parseDouble(initialBalanceField.getText().trim());
            double budgetAmount = Double.parseDouble(budgetField.getText().trim());

            if (name.isEmpty() || lastName.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "please complete all fields",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Profile profile = new Profile(name, lastName, balance);
            MainFrame mainFrame = new MainFrame(profile, budgetAmount);
            mainFrame.setVisible(true);
            this.dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Please enter valid amounts",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}