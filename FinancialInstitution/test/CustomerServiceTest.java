import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerServiceTest {

    @Test
    public void addFamilyMemberTrueTest() {
        Customer customer = new Customer("Nick", "1111", LocalDate.of(2020, 1, 1), true);
        FamilyMember familyMember1 = new FamilyMember("Mike", LocalDate.of(1970, 5, 1), "Father");
        CustomerService customerService = new CustomerService();

        try {
            customerService.addFamilyMember(customer, familyMember1);
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        }
        assertEquals(1, customer.getFamilyMembers().size());
    }

    @Test
    public void addFamilyMemberFalseTest() {
        Customer customer = new Customer("Nick", "1111", LocalDate.of(2020, 1, 1), false);
        FamilyMember familyMember1 = new FamilyMember("Mike", LocalDate.of(1970, 5, 1), "Father");
        CustomerService customerService = new CustomerService();

        try {
            customerService.addFamilyMember(customer, familyMember1);
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        }
        assertEquals(0, customer.getFamilyMembers().size());
    }

    @Test
    public void isCustomerCredentialValidTrueTest() {
        Customer customer = new Customer("Nick", "1111", LocalDate.of(2020, 1, 1), false);
        TrueCustomerCredentials trueCustomerCredentials = new TrueCustomerCredentials("Nick", "1111");
        customer.setTrueCustomerCredentials(trueCustomerCredentials);
        boolean result = false;
        CustomerService customerService = new CustomerService();
        try {
            result = customerService.isCustomerCredentialValid(customer);
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        }
        assertTrue(result);
    }

    @Test
    public void isCustomerCredentialValidFalseTest() {
        String actualMessage = "Access denied. Invalid Username or Password";
        String exceptionMessage = "";
        Customer customer = new Customer("Nick", "1111", LocalDate.of(2020, 1, 1), false);
        TrueCustomerCredentials trueCustomerCredentials = new TrueCustomerCredentials("Nick", "222");
        customer.setTrueCustomerCredentials(trueCustomerCredentials);
        boolean result = false;
        CustomerService customerService = new CustomerService();
        try {
            result = customerService.isCustomerCredentialValid(customer);
        } catch (AccessDeniedException e) {
            e.printStackTrace();
            exceptionMessage = e.getMessage();
        }
        assertTrue(exceptionMessage.equals(actualMessage));
    }


    @Test
    public void isCustomerEligibleForPromotionTrueTest() {
        Customer customer = new Customer("Nick", "1111", LocalDate.of(2020, 1, 1), false);
        customer.setAmountSpentLastMonth(500000);
        boolean result = false;
        CustomerService customerService = new CustomerService();
        try {
            result = customerService.isCustomerEligibleForPromotion(customer);
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        }
        assertTrue(result);
    }

    @Test
    public void isCustomerEligibleForPromotionFalseTest() {
        Customer customer = new Customer("Nick", "1111", LocalDate.of(2020, 1, 1), false);
        customer.setAmountSpentLastMonth(4);
        boolean result = false;
        CustomerService customerService = new CustomerService();
        try {
            result = customerService.isCustomerEligibleForPromotion(customer);
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        }
        assertFalse(result);
    }
}


