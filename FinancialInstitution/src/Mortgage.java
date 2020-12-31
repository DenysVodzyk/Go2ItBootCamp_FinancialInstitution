public class Mortgage {
    private Customer customer;
    private MortgageService mortgageService;
    private boolean isEligible;

    public Mortgage(Customer customer) throws AccessDeniedException {
        this.customer = customer;
        this.mortgageService = new MortgageService();
        this.isEligible = mortgageService.isCustomerEligibleForMortgage(customer);
    }

    public void provideRateInformation() throws AccessDeniedException {
        if (!isEligible) {
            throw new AccessDeniedException("Access denied.");
        }
        if (customer.isCanadian()) {
            System.out.println("Your mortgage interest will be 2%");
        } else {
            System.out.println("Your mortgage interest will be 4%");
        }
    }
}
