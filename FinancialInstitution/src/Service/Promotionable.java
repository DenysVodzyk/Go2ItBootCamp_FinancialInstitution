package Service;

import Entity.CreditProduct;
import Entity.Customer;

public interface Promotionable {

    boolean isEligibleForPromotion(Customer customer);

    void applyPromotion(Customer customer, CreditProduct creditProduct);
}
