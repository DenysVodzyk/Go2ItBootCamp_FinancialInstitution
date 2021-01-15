package Service;

import Entity.Customer;
import Entity.DebitCard;
import Entity.Mortgage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Exception.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MortgageServiceTest {

    Customer customer;
    Mortgage mortgage;
    DebitCard debitCard;
    MortgageService mortgageService;

    @BeforeEach
    void setUp() {
        customer = new Customer("Elon Musk", LocalDate.of(1971, 6, 28), "111", true);
        customer.setCreditScore(800);
        debitCard = new DebitCard(customer, 500000000);
        try {
            mortgage = new Mortgage(customer, 50000000, debitCard, 25);
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        }
        mortgageService = new MortgageService();
    }

    //amount to pay is < mortgage balance
    @Test
    void payOffMortgageTrueTest() {
        mortgageService.payOffMortgage(mortgage,1000);
        System.out.println("Balance on debit card after payment: " + debitCard.getBalance());
        assertEquals(50000000 - 1000, mortgage.getBalance());
    }

    //amount to pay is > mortgage balance
    @Test
    void payOffMortgageTrue2Test() {
        mortgageService.payOffMortgage(mortgage,60000000);
        System.out.println("Balance on debit card after payment: " + debitCard.getBalance());
        assertEquals(0, mortgage.getBalance());
    }

    @Test
    void payOffMortgageFalseTest() {
        debitCard.setBalance(550000);
        assertFalse(mortgageService.payOffMortgage(mortgage,60000000));
    }

    //interest rate is 1.8%
    @Test
    void calculateInterestRate1Test() {
        customer.setCanadian(true);
        customer.setCreditScore(750);
        mortgageService.provideRateInformation(customer, mortgage);
        assertEquals(1.8, mortgage.getInterestRate());
    }

    //interest rate is 2.2%
    @Test
    void calculateInterestRate2Test() {
        customer.setCanadian(true);
        customer.setCreditScore(300);
        mortgageService.provideRateInformation(customer, mortgage);
        assertEquals(2.2, mortgage.getInterestRate());
    }

    //interest rate is 1.9%
    @Test
    void calculateInterestRate3Test() {
        customer.setCreditScore(750);
        mortgageService.provideRateInformation(customer, mortgage);
        assertEquals(1.9, mortgage.getInterestRate());
    }

    //interest rate is 2.4%
    @Test
    void calculateInterestRate4Test() {
        customer.setCreditScore(300);
        mortgageService.provideRateInformation(customer, mortgage);
        assertEquals(2.4, mortgage.getInterestRate());
    }

}





