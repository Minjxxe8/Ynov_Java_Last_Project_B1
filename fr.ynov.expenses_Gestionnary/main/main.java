package fr.ynov.expenses_Gestionnary.main;

import fr.ynov.expenses_Gestionnary.gui.MainFrame;
import fr.ynov.expenses_Gestionnary.gui.LoginFrame;
import javax.swing.*;


public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
        });
    }
}