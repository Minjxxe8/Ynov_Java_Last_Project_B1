# Ynov_Java_Last_Project_B1
# Java Expense Manager

## About
Personal financial management application developed in Java. This application allows you to manage your expenses, income, debts, and claims through a graphical interface.

## Last Update
- **Author**: [@Minjxxe8](https://github.com/Minjxxe8)

## Main Features

### 1. User Profile Management
- Create and edit profile
- Monthly budget setup
- Real-time balance tracking

### 2. Transaction Tracking
- Record expenses by category
- Add income
- Transaction history
- Dashboard overview

### 3. Debt Management
- Add and track personal debts
- Repayment system
- Total debt visualization
- Detailed creditor list

### 4. Claims Management
- Record receivable amounts
- Track repayments
- Active claims overview
- Received payments management

## Technical Configuration

### Prerequisites
- Java IDE (IntelliJ IDEA)

### Project Structure
```tree
fr.ynov.expenses_Gestionnary/
├── domain/
│   ├── Budget.java         # Budget management
│   ├── DebtsManager.java   # Debts/claims management
│   ├── Expenses.java       # Expenses management
│   ├── Profile.java        # User profile
│   ├── Revenue.java        # Income management
│   └── Transaction.java    # Transactions Management
├── gui/
│   ├── LoginFrame.java     # Login interface
│   └── MainFrame.java      # Main interface
└── main/
    └── Main.java          # Application entry point