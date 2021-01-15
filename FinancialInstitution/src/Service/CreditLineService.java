package Service;

import Entity.*;

public class CreditLineService extends CreditProductService {
    private static final double CANADIAN_RATE = 20;
    private static final double NON_CANADIAN_RATE = 22;

    @Override
    public boolean isEligibleForPromotion(Customer customer) {
        if (customer.getAmountSpentLastMonth() >= 600000) {
            System.out.println("Customer is eligible to receive 1% reduction to his line of credit rate.");
            return true;
        }
        System.out.println("Customer is not eligible for promotion.");
        return false;
    }

    @Override
    public void applyPromotion(Customer customer, CreditProduct creditProduct) {
        if (isEligibleForPromotion(customer)) {
            creditProduct.setInterestRate(creditProduct.getInterestRate() - 1);
        }
    }

    @Override
    public void calculateInterestRate(Customer customer, CreditProduct creditProduct) {
        if (customer.isCanadian()) {
            creditProduct.setInterestRate(CANADIAN_RATE);
        } else {
            creditProduct.setInterestRate(NON_CANADIAN_RATE);
        }
    }

}
