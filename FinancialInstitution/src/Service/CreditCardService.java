package Service;

import Entity.Customer;
import Exception.*;
import Entity.CreditCard;


public class CreditCardService extends FinancialInstitutionProductService {
    private CreditCard creditCard;
    private double interestRate;

    public CreditCardService(Customer customer, CreditCard creditCard) {
        super(customer);
        this.creditCard = creditCard;
    }


    public void payOffCreditCard(int amountToDeposit) {
        if (amountToDeposit < 0) {
            throw new IllegalArgumentException("Amount to deposit cannot be negative.");
        }
        creditCard.setBalance(creditCard.getBalance() + amountToDeposit);
    }

    public boolean payWithCreditCard(int itemPrice) throws LimitExceededException {
        if (itemPrice > creditCard.getBalance()) {
            throw new LimitExceededException("You cannot exceed credit card limit.");
        }
        creditCard.setBalance(creditCard.getBalance() - itemPrice);
        return true;
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
            creditCard.setBalance(creditCard.getBalance() + 5000);
        }
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void calculateInterestRate() {
        int customerCreditScore = getCustomer().getCreditScore();
        boolean isCanadian = getCustomer().isCanadian();

        if (isCanadian && customerCreditScore >= 750) {
            interestRate = 20;
        } else if (isCanadian && customerCreditScore < 750) {
            interestRate = 22;
        } else if (!isCanadian && customerCreditScore >= 750) {
            interestRate = 21;
        } else {
            interestRate = 23;
        }
    }
}
