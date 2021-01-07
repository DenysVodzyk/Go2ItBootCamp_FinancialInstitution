package Entity;

public class FinancialInstitutionProduct {
    private int balance;

    public FinancialInstitutionProduct(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "FinancialInstitutionProduct{" +
                "balance=" + balance +
                '}';
    }
}
