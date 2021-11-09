public class Account {
    private int id, balance;
    private double annualInterestRate;

    public Account() {
        this.id = 0;
        this.balance = 0;
        this.annualInterestRate = 0.0;
    }

    public Account(int id, int balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public double getMonthlyInterestRate() {
        return (annualInterestRate * 100)/ 12;
    }

    public double getMonthlyInterestAmount() {
        return balance * getMonthlyInterestRate();
    }

    public void withdraws(double amount) {
        if (balance - amount > 0 ) {
            balance -= amount;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) balance -= amount;
    }
}
