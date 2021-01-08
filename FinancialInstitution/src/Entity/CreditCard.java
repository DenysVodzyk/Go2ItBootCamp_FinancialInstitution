package Entity;

public class CreditCard extends FinancialInstitutionProduct {
    private int creditCardLimit;
    private int annualFee;


    public CreditCard(Customer customer, int balance, int creditCardLimit) {
        super(customer, balance);
        this.creditCardLimit = creditCardLimit;
    }

    public int getCreditCardLimit() {
        return creditCardLimit;
    }

    public void setCreditCardLimit(int creditCardLimit) {
        this.creditCardLimit = creditCardLimit;
    }

    public int getAnnualFee() {
        if (getCustomer().isSenior()) {
            return 0;
        }
        return 10000;
    }

}
