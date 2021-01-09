package Service;

import Exception.*;
import Entity.*;

public class CreditLineService extends FinancialInstitutionProductService {
    private CreditLine creditLine;
    private double rate;
    private static final double CANADIAN_RATE = 20;
    private static final double NON_CANADIAN_RATE = 22;

    public CreditLineService(Customer customer, CreditLine creditLine) {
        super(customer);
        this.creditLine = creditLine;
    }

    public double calculateRate() throws AccessDeniedException {
        if (!creditLine.isCustomerEligibleForCreditLine()) {
            throw new AccessDeniedException("Access denied.");
        }
        if (getCustomer().isCanadian()) {
            setRate(CANADIAN_RATE);
            System.out.println("Your line of credit interest will be " + rate + "%");
            return rate;
        } else {
            setRate(NON_CANADIAN_RATE);
            System.out.println("Your line of credit interest will be " + rate + "%");
            return rate;
        }
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
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
            setRate(rate - 1);
        }
    }
}
