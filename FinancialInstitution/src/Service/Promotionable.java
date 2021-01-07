package Service;

import Entity.Customer;

public interface Promotionable {

    boolean isEligibleForPromotion(Customer customer);

    void applyPromotion(Customer customer);
}
