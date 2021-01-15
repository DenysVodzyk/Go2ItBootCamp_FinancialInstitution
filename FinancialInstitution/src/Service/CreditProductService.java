package Service;

import Entity.CreditProduct;
import Entity.Customer;
import Exception.*;

public abstract class CreditProductService extends FinancialInstitutionProductService implements Promotionable {

    public boolean payWithCreditProduct(CreditProduct creditProduct, int itemPrice) throws LimitExceededException {
        if (itemPrice > creditProduct.getBalance()) {
            throw new LimitExceededException("You cannot exceed credit card limit.");
        }
        creditProduct.setBalance(creditProduct.getBalance() - itemPrice);
        return true;
    }

    public void payOffCreditProduct(CreditProduct creditProduct, int amountToDeposit) {
        if (amountToDeposit < 0) {
            throw new IllegalArgumentException("Amount to deposit cannot be negative.");
        }
        creditProduct.setBalance(creditProduct.getBalance() + amountToDeposit);
    }

    public abstract void calculateInterestRate(Customer customer, CreditProduct creditProduct);

}
