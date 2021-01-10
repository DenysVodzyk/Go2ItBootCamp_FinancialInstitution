package Service;

import Entity.Customer;

public interface Promotionable {

    boolean isEligibleForPromotion();

    void applyPromotion();
}
