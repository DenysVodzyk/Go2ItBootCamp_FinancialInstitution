package Service;

import Entity.*;

public class CreditLineService extends CreditProductService {
    private static final double CANADIAN_RATE = 20;
    private static final double NON_CANADIAN_RATE = 22;

    public CreditLineService(Customer customer, CreditLine creditLine) {
        super(customer, creditLine);
    }


    @Override
    public boolean isEligibleForPromotion() {
        if (getCustomer().getAmountSpentLastMonth() >= 600000) {
            System.out.println("Customer is eligible to receive 1% reduction to his line of credit rate.");
            return true;
        }
        System.out.println("Customer is not eligible for promotion.");
        return false;
    }

    @Override
    public void applyPromotion() {
        if (isEligibleForPromotion()) {
            setInterestRate(getInterestRate() - 1);
        }
    }

    @Override
    public void calculateInterestRate() {
        if (getCustomer().isCanadian()) {
            setInterestRate(CANADIAN_RATE);
        } else {
            setInterestRate(NON_CANADIAN_RATE);
        }
    }

}
