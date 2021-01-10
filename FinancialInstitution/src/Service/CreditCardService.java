package Service;

import Entity.CreditCard;
import Entity.Customer;


public class CreditCardService extends CreditProductService {

    public CreditCardService(Customer customer, CreditCard creditCard) {
        super(customer, creditCard);
    }

    public int provideAnnualFee() {
        if (getCustomer().isSenior()) {
            return 0;
        }
        return 10000;
    }

    @Override
    public boolean isEligibleForPromotion() {
        if (getCustomer().getAmountSpentLastMonth() >= 500000) {
            System.out.println("Customer is eligible to receive $50 bonus, since he spent $5000 last month.");
            return true;
        }
        System.out.println("Customer is not eligible for promotion. To be eligible customer has to spend $5000 or more.");
        return false;
    }

    @Override
    public void applyPromotion() {
        if (isEligibleForPromotion()) {
            getCreditProduct().setBalance(getCreditProduct().getBalance() + 5000);
        }
    }

    @Override
    public void calculateInterestRate() {
        int customerCreditScore = getCustomer().getCreditScore();
        boolean isCanadian = getCustomer().isCanadian();

        if (isCanadian && customerCreditScore >= 750) {
            setInterestRate(20);
        } else if (isCanadian) {
            setInterestRate(22);
        } else if (customerCreditScore >= 750) {
            setInterestRate(21);
        } else {
            setInterestRate(23);
        }
    }

}
