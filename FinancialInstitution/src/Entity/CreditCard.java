package Entity;

public class CreditCard extends CreditProduct {

    public CreditCard(Customer customer, int balance, int creditCardLimit) {
        super(customer, balance, creditCardLimit);
    }

    @Override
    public String toString() {
        return "Credit Card: " + super.toString();
    }
}
