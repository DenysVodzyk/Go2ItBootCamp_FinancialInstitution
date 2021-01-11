package Service;

import Entity.CreditCard;
import Entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Exception.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardServiceTest {
    Customer customer;
    CreditCard creditCard;
    CreditCardService creditCardService;

    @BeforeEach
    void setUp() {
        customer = new Customer("Elon Musk", LocalDate.of(1971, 6, 28), "111", true);
        creditCard = new CreditCard(customer, 1000, 1000);
        creditCardService = new CreditCardService(customer, creditCard);
    }

    //item price > credit card limit
    @Test
    void payWithCreditProductHighItemPriceTest() {
        try {
            creditCardService.payWithCreditProduct(2000);
        } catch (Exception e) {
            assertEquals(e.getClass(), LimitExceededException.class);
        }
    }

    //item price < credit card limit
    @Test
    void payWithCreditProductLowItemPriceTest() {
        try {
            creditCardService.payWithCreditProduct(100);
        } catch (LimitExceededException e) {
            e.printStackTrace();
        }
        assertEquals(900, creditCard.getBalance());
    }

    @Test
    void payOffCreditProductNegativeAmountTest() {
        try {
            creditCardService.payOffCreditProduct(-10);
        } catch (Exception e) {
            assertEquals("Amount to deposit cannot be negative.", e.getMessage());
        }
    }

    @Test
    void payOffCreditProductPositiveAmountTest() {
        creditCardService.payOffCreditProduct(10);
        assertEquals(1010, creditCard.getBalance());
    }

    @Test
    void provideAnnualFeeSeniorTest() {
        customer.setSenior(true);
        assertEquals(0, creditCardService.provideAnnualFee());
    }

    @Test
    void provideAnnualFeeNotSeniorTest() {
        assertEquals(10000, creditCardService.provideAnnualFee());
    }

    @Test
    void isEligibleForPromotionTrueTest() {
        customer.setAmountSpentLastMonth(500000);
        assertTrue(creditCardService.isEligibleForPromotion());
    }

    @Test
    void isEligibleForPromotionFalseTest() {
        customer.setAmountSpentLastMonth(490000);
        assertFalse(creditCardService.isEligibleForPromotion());
    }

    @Test
    void applyPromotionTrue() {
        customer.setAmountSpentLastMonth(500000);
        creditCardService.applyPromotion();
        assertEquals(6000, creditCard.getBalance());
    }

    @Test
    void applyPromotionFalse() {
        customer.setAmountSpentLastMonth(1000);
        creditCardService.applyPromotion();
        assertEquals(1000, creditCard.getBalance());
    }

    @Test
    void calculateInterestRate20Test() {
        customer.setCanadian(true);
        customer.setCreditScore(750);
        creditCardService.calculateInterestRate();
        assertEquals(20, creditCardService.getInterestRate());
    }

    @Test
    void calculateInterestRate22Test() {
        customer.setCanadian(true);
        customer.setCreditScore(300);
        creditCardService.calculateInterestRate();
        assertEquals(22, creditCardService.getInterestRate());
    }

    @Test
    void calculateInterestRate21Test() {
        customer.setCreditScore(750);
        creditCardService.calculateInterestRate();
        assertEquals(21, creditCardService.getInterestRate());
    }

    @Test
    void calculateInterestRate23Test() {
        creditCardService.calculateInterestRate();
        assertEquals(23, creditCardService.getInterestRate());
    }

}
