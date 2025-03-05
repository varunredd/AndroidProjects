abstract class BankAccount { 
    private int accountNumber;
    private double balance;
    private final String accountType;

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public BankAccount(int accountNumber, double initialBalance, String accountType) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.accountType = accountType;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Invalid withdrawal amount");
        } else if (amount > balance) {
            throw new Exception("Insufficient balance");
        } else {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }

    public abstract void showAccountDetails();

    public void validateBalance() {
        assert balance >= 0 : "Balance can't be negative";
    }
}

// CheckingAccount.java
class CheckingAccount extends BankAccount {
    private static final double OVERDRAFT_LIMIT = 500;

    public CheckingAccount(int accountNumber, double initialBalance) {
        super(accountNumber, initialBalance, "Checking");
    }

    @Override
    public void showAccountDetails() {
        System.out.println("Account Type: " + getAccountType());
        System.out.println("Account Number: " + getAccountNumber());
    }

    public void applyOverdraft() {
        System.out.println("Applying overdraft limit: " + OVERDRAFT_LIMIT);
    }

    public synchronized void makeTransaction(double amount) {
        System.out.println("Transaction initiated with amount: " + amount);
    }
}

enum AccountType {
    CHECKING, SAVINGS;
}

class SavingsAccount extends BankAccount {
    private volatile double interestRate;

    public SavingsAccount(int accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance, "Savings");
        this.interestRate = interestRate;
    }

    @Override
    public void showAccountDetails() {
        System.out.println("Account Type: " + getAccountType());
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Interest Rate: " + interestRate);
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        super.deposit(interest);
        System.out.println("Interest Applied: " + interest);
    }
}

// Customer.java
class Customer {
    private String name;
    private BankAccount account;

    public Customer(String name, BankAccount account) {
        this.name = name;
        this.account = account;
    }

    public void makeDeposit(double amount) {
        account.deposit(amount);
    }

    public void makeWithdrawal(double amount) {
        try {
            account.withdraw(amount);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewAccountDetails() {
        System.out.println("Customer Name: " + name);
        account.showAccountDetails();
    }

    public boolean isCheckingAccount() {
        return account instanceof CheckingAccount;
    }

    public void processTransactions(double[] amounts) {
        for (double amount : amounts) {
            if (amount < 0) {
                continue;
            }
            makeDeposit(amount);
        }
    }

    public void applyAccountInterest() {
        if (account instanceof SavingsAccount) {
            ((SavingsAccount) account).applyInterest();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount checking = new CheckingAccount(12345, 1000);
        Customer customer1 = new Customer("Alice", checking);
        customer1.viewAccountDetails();
        customer1.makeDeposit(200);
        customer1.makeWithdrawal(300);
        double[] transactions = {200, -50, 100, 500};
        customer1.processTransactions(transactions);

        BankAccount savings = new SavingsAccount(67890, 5000, 0.02);

        Customer customer2 = new Customer("Bob", savings);
        customer2.viewAccountDetails();
        customer2.makeDeposit(500);
        customer2.makeWithdrawal(1000);

        ((SavingsAccount) savings).applyInterest();



        checking.validateBalance();
        savings.validateBalance();

        String action = "deposit";
        switch (action) {
            case "deposit":
                customer1.makeDeposit(150);
                break;
            case "withdraw":
                customer1.makeWithdrawal(100);
                break;
            default:
                System.out.println("Invalid action");
        }

        // Finally, apply overdraft limit and transaction methods
        CheckingAccount checkingAccount = (CheckingAccount) checking;
        checkingAccount.applyOverdraft();
        checkingAccount.makeTransaction(250);
    }
}
