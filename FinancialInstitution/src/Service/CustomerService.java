package Service;

import Exception.*;
import Entity.*;

public class CustomerService {

    public static boolean isCustomerCredentialValid(Customer customer) throws AccessDeniedException {
        String customerGivenName = customer.getName();
        String customerAuthenticName = customer.getCustomerCredentials().getAuthenticCustomerName();
        String customerGivenPassword = customer.getPassword();
        String customerAuthenticPassword = customer.getCustomerCredentials().getAuthenticCustomerPassword();

        if (!customerGivenName.equals(customerAuthenticName) || !customerGivenPassword.equals(customerAuthenticPassword)) {
            throw new AccessDeniedException("Access denied. Invalid Username or Password");
        }
        System.out.println("Access Granted! Welcome " + customer.getName() + "!");
        return true;
    }

    public static void addFinancialProduct(Customer customer, Product financialInstitutionProduct){
        customer.getFinancialInstitutionProducts().add(financialInstitutionProduct);
    }

    public static void addFamilyMember(Customer customer, FamilyMember familyMember) throws AccessDeniedException {
        if (!customer.isAgreeToShareFamilyInfo()) {
            throw new AccessDeniedException("You don't have customer permission to add family members.");
        }
        customer.getFamilyMembers().add(familyMember);
    }

}
