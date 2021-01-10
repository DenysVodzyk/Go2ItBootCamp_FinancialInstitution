package Entity;

import Exception.*;

public class CreditLine extends CreditProduct {
    private boolean isEligible;

    public CreditLine(Customer customer, int balance, int creditLineLimit) throws AccessDeniedException {
        super(customer, balance, creditLineLimit);
        isEligible = isCustomerEligibleForCreditLine();
    }

    public boolean isCustomerEligibleForCreditLine() throws AccessDeniedException {
        if (getCustomer().getCreditScore() < 600) {
            throw new AccessDeniedException("Customer is not eligible for credit line. His/her credit score is less than 600.");
        }
        System.out.println("Customer is eligible for credit line!");
        return true;
    }

    public boolean isEligible() {
        return isEligible;
    }

    @Override
    public String toString() {
        return "Credit Line: " + super.toString();
    }
}
