import Entity.Customer;
import Service.CreditLineService;
import org.junit.jupiter.api.Test;
import Exception.*;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class CreditLineServiceTest {
/*
    @Test
    public void isCustomerEligibleForCreditLineTrueTest() {
        boolean result = false;
        Customer customer = new Customer("Nick", "1111", LocalDate.of(2020, 1, 1), true);
        customer.setCreditScore(700);
        CreditLineService creditLineService = new CreditLineService();
        try {
            result = creditLineService.isCustomerEligibleForCreditLine(customer);
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        }
        assertTrue(result);
    }

    @Test
    public void isCustomerEligibleForCreditLineExceptionTest() {
        boolean result = false;
        String actualMessage = "Entity.Customer is not eligible for credit line. His/her credit score is less than 650.";
        String exceptionMessage = "";
        Customer customer = new Customer("Nick", "1111", LocalDate.of(2020, 1, 1), true);
        customer.setCreditScore(600);
        CreditLineService creditLineService = new CreditLineService();
        try {
            result = creditLineService.isCustomerEligibleForCreditLine(customer);
        } catch (AccessDeniedException e) {
            e.printStackTrace();
            exceptionMessage = e.getMessage();
        }
        assertTrue(exceptionMessage.equals(actualMessage));
    }*/
}


