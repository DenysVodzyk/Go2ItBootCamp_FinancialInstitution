package Entity;

public class CreditProduct extends Product {
    private int limit;
    private double interestRate;

    public CreditProduct(Customer customer, int balance, int limit) {
        super(customer, balance);
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "CreditProduct{" + super.toString() +
                "limit=" + limit +
                '}';
    }
}
