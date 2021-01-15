package Service;

import Entity.CreditProduct;
import Entity.Customer;


public class CreditCardService extends CreditProductService {

    public int provideAnnualFee(Customer customer) {
        if (customer.isSenior()) {
            return 0;
        }
        return 10000;
    }

    @Override
    public boolean isEligibleForPromotion(Customer customer) {
        if (customer.getAmountSpentLastMonth() >= 500000) {
            System.out.println("Customer is eligible to receive $50 bonus, since he spent $5000 last month.");
            return true;
        }
        System.out.println("Customer is not eligible for promotion. To be eligible customer has to spend $5000 or more.");
        return false;
    }

    @Override
    public void applyPromotion(Customer customer, CreditProduct creditProduct) {
        if (isEligibleForPromotion(customer)) {
            creditProduct.setBalance(creditProduct.getBalance() + 5000);
        }
    }

    @Override
    public void calculateInterestRate(Customer customer, CreditProduct creditProduct) {
        int customerCreditScore = customer.getCreditScore();
        boolean isCanadian = customer.isCanadian();

        if (isCanadian && customerCreditScore >= 750) {
            creditProduct.setInterestRate(20);
        } else if (isCanadian) {
            creditProduct.setInterestRate(22);
        } else if (customerCreditScore >= 750) {
            creditProduct.setInterestRate(21);
        } else {
            creditProduct.setInterestRate(23);
        }
    }

}
