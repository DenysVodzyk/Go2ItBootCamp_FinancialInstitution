package Entity;

public class CreditProduct extends FinancialInstitutionProduct {
    private int limit;

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

    @Override
    public String toString() {
        return "CreditProduct{" + super.toString() +
                "limit=" + limit +
                '}';
    }
}
