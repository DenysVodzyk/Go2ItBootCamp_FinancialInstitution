package Service;

import Entity.CreditProduct;
import Entity.Customer;
import Exception.*;

public abstract class CreditProductService extends FinancialInstitutionProductService implements Promotionable {
    private CreditProduct creditProduct;
    private double interestRate;

    public CreditProductService(Customer customer, CreditProduct creditProduct) {
        super(customer);
        this.creditProduct = creditProduct;
    }

    public CreditProduct getCreditProduct() {
        return creditProduct;
    }

    public void setCreditProduct(CreditProduct creditProduct) {
        this.creditProduct = creditProduct;
    }

    public boolean payWithCreditProduct(int itemPrice) throws LimitExceededException {
        if (itemPrice > creditProduct.getBalance()) {
            throw new LimitExceededException("You cannot exceed credit card limit.");
        }
        creditProduct.setBalance(creditProduct.getBalance() - itemPrice);
        return true;
    }

    public void payOffCreditProduct(int amountToDeposit) {
        if (amountToDeposit < 0) {
            throw new IllegalArgumentException("Amount to deposit cannot be negative.");
        }
        creditProduct.setBalance(creditProduct.getBalance() + amountToDeposit);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public abstract void calculateInterestRate();

}
