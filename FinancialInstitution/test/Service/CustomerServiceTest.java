package Service;

import Entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Exception.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("Elon Musk", LocalDate.of(1971, 6, 28), "111", true);
    }

    @Test
    void isCustomerCredentialValidTrueTest() {
        CustomerCredentials trueCustomerCredentials = new CustomerCredentials("Elon Musk", "111");
        customer.setCustomerCredentials(trueCustomerCredentials);
        try {
            assertTrue(CustomerService.isCustomerCredentialValid(customer));
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void isCustomerCredentialValidFalseNameTest() {
        CustomerCredentials trueCustomerCredentials = new CustomerCredentials("Elon Muks", "111");
        customer.setCustomerCredentials(trueCustomerCredentials);
        try {
            CustomerService.isCustomerCredentialValid(customer);
        } catch (Exception e) {
            e.printStackTrace();
            assertEquals(e.getClass(), AccessDeniedException.class);
        }
    }

    @Test
    void isCustomerCredentialValidFalsePasswordTest() {
        CustomerCredentials trueCustomerCredentials = new CustomerCredentials("Elon Musk", "1111");
        customer.setCustomerCredentials(trueCustomerCredentials);
        try {
            CustomerService.isCustomerCredentialValid(customer);
        } catch (Exception e) {
            e.printStackTrace();
            assertEquals(e.getClass(), AccessDeniedException.class);
        }
    }

    @Test
    void addFamilyMemberTrueTest() {
        FamilyMember familyMember = new FamilyMember("Kimbal Musk", LocalDate.of(1972, 9, 20), "Brother");
        try {
            CustomerService.addFamilyMember(customer, familyMember);
            assertEquals(1, customer.getFamilyMembers().size());
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void addFamilyMemberFalseTest() {
        customer.setAgreeToShareFamilyInfo(false);
        FamilyMember familyMember = new FamilyMember("Kimbal Musk", LocalDate.of(1972, 9, 20), "Brother");
        try {
            CustomerService.addFamilyMember(customer, familyMember);
        } catch (Exception e) {
            e.printStackTrace();
            assertEquals(e.getClass(), AccessDeniedException.class);
        }
    }

    @Test
    void addFinancialProductTest() {
        CreditCard creditCard = new CreditCard(customer, 1000, 1000);
        CustomerService.addFinancialProduct(customer, creditCard);
        assertEquals(1, customer.getFinancialInstitutionProducts().size());
    }
}




