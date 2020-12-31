import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class MortgageServiceTest {

    @Test
    public void isCustomerEligibleForMortgageTrueTest() {
        Customer customer = new Customer("Nick", "1111", LocalDate.of(2020, 1, 1), true);
        customer.setCreditScore(700);
        DebitCard debitCard = new DebitCard(550000);
        customer.setDebitCard(debitCard);
        MortgageService mortgageService = new MortgageService();
        boolean result = false;

        try {
            result = mortgageService.isCustomerEligibleForMortgage(customer);
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        }
        assertTrue(result);

    }

    @Test
    public void isCustomerEligibleForMortgageFalseTest() {
        Customer customer = new Customer("Nick", "1111", LocalDate.of(2020, 1, 1), true);
        customer.setCreditScore(50);
        DebitCard debitCard = new DebitCard(5500000);
        customer.setDebitCard(debitCard);
        MortgageService mortgageService = new MortgageService();
        boolean result = false;

        try {
            result = mortgageService.isCustomerEligibleForMortgage(customer);
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        }
        assertFalse(result);

    }
}
