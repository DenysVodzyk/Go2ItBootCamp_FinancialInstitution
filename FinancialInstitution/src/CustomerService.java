public class CustomerService {


    public void addFamilyMember(Customer customer, FamilyMember familyMember) throws AccessDeniedException {
        if (!customer.isConsentToProvideFamilyMemberDetails()) {
            throw new AccessDeniedException("You don't have customer permission to add family members.");
        }
        customer.getFamilyMembers().add(familyMember);
    }

    public boolean isCustomerCredentialValid(Customer customer) throws AccessDeniedException {
        String customerGivenName = customer.getName();
        String customerAuthenticName = customer.getTrueCustomerCredentials().getAuthenticCustomerName();
        String customerGivenPassword = customer.getPassword();
        String customerAuthenticPassword = customer.getTrueCustomerCredentials().getAuthenticCustomerPassword();

        if (!customerGivenName.equals(customerAuthenticName) || !customerGivenPassword.equals(customerAuthenticPassword)) {
            throw new AccessDeniedException("Access denied. Invalid Username or Password");
        }
        System.out.println("Access Granted! Welcome " + customer.getName() + "!");
        return true;
    }

    public boolean isCustomerEligibleForPromotion(Customer customer) throws AccessDeniedException {
        if (customer.getAmountSpentLastMonth() < 500000) {
            throw new AccessDeniedException("Customer is not eligible for promotion. He/she hasn't spent $5000 last month.");
        }
        System.out.println("Customer is eligible for promotion!");
        return true;
    }

    public boolean isCustomerEligibleForCreditLine(Customer customer) throws AccessDeniedException {
        if (customer.getCreditScore() < 650) {
            throw new AccessDeniedException("Customer is not eligible for credit line. His/her credit score is less than 650.");
        }
        System.out.println("Customer is eligible for credit line!");
        return true;
    }
}
