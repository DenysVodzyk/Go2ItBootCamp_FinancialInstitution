public class MortgageService {

    public boolean isCustomerEligibleForMortgage(Customer customer) throws AccessDeniedException {
        if (customer.getCreditScore() < 660 || customer.getDebitCardBalance() < 550000) {
            throw new AccessDeniedException("Customer is not eligible for mortgage.");
        }
        System.out.println("Customer is eligible for mortgage!");
        return true;
    }
}
