package Service;

import Entity.CreditLine;
import Entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Exception.*;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

class CreditLineServiceTest {
    Customer customer;
    CreditLine creditLine;
    CreditLineService creditLineService;

    @BeforeEach
    void setUp() {
        customer = new Customer("Elon Musk", LocalDate.of(1971, 6, 28), "111", true);
        customer.setCreditScore(800);
        try {
            creditLine = new CreditLine(customer, 10000, 10000);
            creditLineService = new CreditLineService(customer, creditLine);
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        }
    }

    //item price > credit card limit
    @Test
    void payWithCreditProductHighItemPriceTest() {
        try {
            creditLineService.payWithCreditProduct(20000);
        } catch (Exception e) {
            assertEquals(e.getClass(), LimitExceededException.class);
        }
    }

    //item price < credit card limit
    @Test
    void payWithCreditProductLowItemPriceTest() {
        try {
            creditLineService.payWithCreditProduct(1000);
        } catch (LimitExceededException e) {
            e.printStackTrace();
        }
        assertEquals(9000, creditLine.getBalance());
    }

    @Test
    void payOffCreditProductNegativeAmountTest() {
        try {
            creditLineService.payOffCreditProduct(-10);
        } catch (Exception e) {
            assertEquals("Amount to deposit cannot be negative.", e.getMessage());
        }
    }

    @Test
    void payOffCreditProductPositiveAmountTest() {
        creditLineService.payOffCreditProduct(10);
        assertEquals(10010, creditLine.getBalance());
    }

    @Test
    void isEligibleForPromotionTrueTest() {
        customer.setAmountSpentLastMonth(600000);
        assertTrue(creditLineService.isEligibleForPromotion());
    }

    @Test
    void isEligibleForPromotionFalseTest() {
        customer.setAmountSpentLastMonth(490000);
        assertFalse(creditLineService.isEligibleForPromotion());
    }

    @Test
    void applyPromotionTrue() {
        customer.setAmountSpentLastMonth(600000);
        creditLineService.setInterestRate(20);
        creditLineService.applyPromotion();
        assertEquals(19, creditLineService.getInterestRate());
    }

    @Test
    void applyPromotionFalse() {
        customer.setAmountSpentLastMonth(10000);
        creditLineService.setInterestRate(22);
        creditLineService.applyPromotion();
        assertEquals(22, creditLineService.getInterestRate());
    }

    @Test
    void calculateInterestRateCanadianRateTest() {
        customer.setCanadian(true);
        creditLineService.calculateInterestRate();
        assertEquals(20, creditLineService.getInterestRate());
    }

    @Test
    void calculateInterestRateNonCanadianRateTest() {
        customer.setCanadian(false);
        creditLineService.calculateInterestRate();
        assertEquals(22, creditLineService.getInterestRate());
    }
}


