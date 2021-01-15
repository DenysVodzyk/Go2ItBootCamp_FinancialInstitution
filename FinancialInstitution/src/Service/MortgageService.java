package Service;

import Entity.*;

public class MortgageService extends FinancialInstitutionProductService {

    public boolean payOffMortgage(Mortgage mortgage, int amountToPay) {
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

    public void provideRateInformation(Customer customer, Mortgage mortgage) {
        int customerCreditScore = customer.getCreditScore();
        boolean isCanadian = customer.isCanadian();

        if (isCanadian && customerCreditScore >= 750) {
            mortgage.setInterestRate(1.8);
        } else if (isCanadian) {
            mortgage.setInterestRate(2.2);
        } else if (customerCreditScore >= 750) {
            mortgage.setInterestRate(1.9);
        } else {
            mortgage.setInterestRate(2.4);
        }
    }
}
