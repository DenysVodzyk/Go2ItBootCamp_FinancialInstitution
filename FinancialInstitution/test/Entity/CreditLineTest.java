package Entity;

import Exception.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CreditLineTest {

    Customer customer;
    CreditLine creditLine;

    @BeforeEach
    void setUp() {
        customer = new Customer("Elon Musk", LocalDate.of(1971, 6, 28), "111", true);
    }

    @Test
    void testCreditLineClassInitializedTrue() {
        customer.setCreditScore(800);
        try {
            creditLine = new CreditLine(customer, 1000, 1000);
            assertTrue(creditLine.isEligible());
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testCreditLineClassInitializedFalse() {
        customer.setCreditScore(599);
        try {
            creditLine = new CreditLine(customer, 1000, 1000);
        } catch (AccessDeniedException e) {
            e.printStackTrace();
            assertEquals(e.getClass(), AccessDeniedException.class);
        }
    }
}
