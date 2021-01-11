package Entity;

import Exception.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class MortgageTest {
    Customer customer;
    Mortgage mortgage;
    DebitCard debitCard;

    @BeforeEach
    void setUp() {
        customer = new Customer("Elon Musk", LocalDate.of(1971, 6, 28), "111", true);
    }

    @Test
    void isCustomerEligibleForMortgageTrueTest() {
        customer.setCreditScore(660);
        debitCard = new DebitCard(customer, 550000);
        try {
            mortgage = new Mortgage(customer, 500000, debitCard, 5);
            assertTrue(mortgage.isEligible());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void isCustomerEligibleForMortgageLowCreditScoreTest() {
        customer.setCreditScore(659);
        debitCard = new DebitCard(customer, 550000);
        try {
            mortgage = new Mortgage(customer, 500000, debitCard, 5);
        } catch (Exception e) {
            e.printStackTrace();
            assertEquals(e.getClass(), AccessDeniedException.class);
        }
    }

    @Test
    void isCustomerEligibleForMortgageLowBalanceTest() {
        customer.setCreditScore(700);
        debitCard = new DebitCard(customer, 500000);
        try {
            mortgage = new Mortgage(customer, 500000, debitCard, 5);
        } catch (Exception e) {
            e.printStackTrace();
            assertEquals(e.getClass(), AccessDeniedException.class);
        }
    }
}
