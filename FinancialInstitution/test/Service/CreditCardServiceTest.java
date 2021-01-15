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
        creditCardService = new CreditCardService();
    }

    //item price > credit card limit
    @Test
    void payWithCreditProductHighItemPriceTest() {
        try {
            creditCardService.payWithCreditProduct(creditCard, 2000);
        } catch (Exception e) {
            assertEquals(e.getClass(), LimitExceededException.class);
        }
    }

    //item price < credit card limit
    @Test
    void payWithCreditProductLowItemPriceTest() {
        try {
            creditCardService.payWithCreditProduct(creditCard, 100);
        } catch (LimitExceededException e) {
            e.printStackTrace();
        }
        assertEquals(900, creditCard.getBalance());
    }

    @Test
    void payOffCreditProductNegativeAmountTest() {
        try {
            creditCardService.payOffCreditProduct(creditCard, -10);
        } catch (Exception e) {
            assertEquals("Amount to deposit cannot be negative.", e.getMessage());
        }
    }

    @Test
    void payOffCreditProductPositiveAmountTest() {
        creditCardService.payOffCreditProduct(creditCard, 10);
        assertEquals(1010, creditCard.getBalance());
    }

    @Test
    void provideAnnualFeeSeniorTest() {
        customer.setSenior(true);
        assertEquals(0, creditCardService.provideAnnualFee(customer));
    }

    @Test
    void provideAnnualFeeNotSeniorTest() {
        assertEquals(10000, creditCardService.provideAnnualFee(customer));
    }

    @Test
    void isEligibleForPromotionTrueTest() {
        customer.setAmountSpentLastMonth(500000);
        assertTrue(creditCardService.isEligibleForPromotion(customer));
    }

    @Test
    void isEligibleForPromotionFalseTest() {
        customer.setAmountSpentLastMonth(490000);
        assertFalse(creditCardService.isEligibleForPromotion(customer));
    }

    @Test
    void applyPromotionTrue() {
        customer.setAmountSpentLastMonth(500000);
        creditCardService.applyPromotion(customer, creditCard);
        assertEquals(6000, creditCard.getBalance());
    }

    @Test
    void applyPromotionFalse() {
        customer.setAmountSpentLastMonth(1000);
        creditCardService.applyPromotion(customer, creditCard);
        assertEquals(1000, creditCard.getBalance());
    }

    @Test
    void calculateInterestRate20Test() {
        customer.setCanadian(true);
        customer.setCreditScore(750);
        creditCardService.calculateInterestRate(customer, creditCard);
        assertEquals(20, creditCard.getInterestRate());
    }

    @Test
    void calculateInterestRate22Test() {
        customer.setCanadian(true);
        customer.setCreditScore(300);
        creditCardService.calculateInterestRate(customer, creditCard);
        assertEquals(22, creditCard.getInterestRate());
    }

    @Test
    void calculateInterestRate21Test() {
        customer.setCreditScore(750);
        creditCardService.calculateInterestRate(customer, creditCard);
        assertEquals(21, creditCard.getInterestRate());
    }

    @Test
    void calculateInterestRate23Test() {
        creditCardService.calculateInterestRate(customer, creditCard);
        assertEquals(23, creditCard.getInterestRate());
    }

}
