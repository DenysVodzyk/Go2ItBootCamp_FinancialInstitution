public class CreditLine {
    private Customer customer;
    private CreditLineService creditLineService;
    private boolean isEligible;

    public CreditLine(Customer customer) throws AccessDeniedException {
        this.customer = customer;
        this.creditLineService = new CreditLineService();
        this.isEligible = creditLineService.isCustomerEligibleForCreditLine(customer);
    }

    public void provideRateInformation() throws AccessDeniedException {
        if (!isEligible) {
            throw new AccessDeniedException("Access denied.");
        }
        if (customer.isCanadian()) {
            System.out.println("Your line of credit interest will be 20%");
        } else {
            System.out.println("Your line of credit interest will be 22%");
        }
    }

}
