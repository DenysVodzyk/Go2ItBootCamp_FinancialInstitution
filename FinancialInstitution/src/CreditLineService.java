public class CreditLineService {

    public CreditLineService() {
    }

    public boolean isCustomerEligibleForCreditLine(Customer customer) throws AccessDeniedException {
        if (customer.getCreditScore() < 650) {
            throw new AccessDeniedException("Customer is not eligible for credit line. His/her credit score is less than 650.");
        }
        System.out.println("Customer is eligible for credit line!");
        return true;
    }

}
