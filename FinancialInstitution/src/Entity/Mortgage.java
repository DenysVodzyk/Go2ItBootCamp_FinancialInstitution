package Entity;

import Exception.*;

public class Mortgage extends FinancialInstitutionProduct {
    private boolean isEligible;
    private DebitCard debitCard;

    public Mortgage(Customer customer, int balance, DebitCard debitCard, int mortgageTermLength) throws AccessDeniedException {
        super(customer, balance);
        this.debitCard = debitCard;
        this.isEligible = isCustomerEligibleForMortgage();
    }

    public boolean isCustomerEligibleForMortgage() throws AccessDeniedException {
        if (getCustomer().getCreditScore() < 660 || debitCard.getBalance() < 550000) {
            throw new AccessDeniedException("Customer is not eligible for mortgage.");
        }
        System.out.println("Customer is eligible for mortgage!");
        return true;
    }

    public DebitCard getDebitCard() {
        return debitCard;
    }

    public boolean isEligible() {
        return isEligible;
    }

    @Override
    public String toString() {
        return "Mortgage: " + super.toString();
    }

}
