package Service;

import Entity.*;

public class MortgageService extends FinancialInstitutionProductService {
    private Mortgage mortgage;
    private double interestRate;

    public MortgageService(Customer customer, Mortgage mortgage) {
        super(customer);
        this.mortgage = mortgage;
    }

    public boolean payOffMortgage(int amountToPay) {
        if (mortgage.getDebitCard().getBalance() > amountToPay) {
            if (mortgage.getBalance() > amountToPay) {
                mortgage.getDebitCard().setBalance(mortgage.getDebitCard().getBalance() - amountToPay);
                mortgage.setBalance(mortgage.getBalance() - amountToPay);
            } else {
                //in case if mortgage leftover is smaller than the amount customer wants to pay.
                mortgage.getDebitCard().setBalance(mortgage.getDebitCard().getBalance() - mortgage.getBalance());
                mortgage.setBalance(0);
            }
            return true;
        } else {
            System.out.println("Not enough money on the debit card.");
            return false;
        }
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void provideRateInformation() {
        int customerCreditScore = getCustomer().getCreditScore();
        boolean isCanadian = getCustomer().isCanadian();

        if (isCanadian && customerCreditScore >= 750) {
            interestRate = 1.8;
        } else if (isCanadian) {
            interestRate = 2.2;
        } else if (customerCreditScore >= 750) {
            interestRate = 1.9;
        } else {
            interestRate = 2.4;
        }
    }
}
