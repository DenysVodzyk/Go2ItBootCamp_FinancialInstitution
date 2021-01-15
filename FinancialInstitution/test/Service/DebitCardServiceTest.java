package Service;

import Entity.Customer;
import Entity.DebitCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Exception.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DebitCardServiceTest {
    Customer customer1;
    Customer customer2;
    DebitCard debitCard1;
    DebitCard debitCard2;
    DebitCardService debitCardService;

    @BeforeEach
    void setUp() {
        customer1 = new Customer("Elon Musk", LocalDate.of(1971, 6, 28), "111", true);
        customer2 = new Customer("Jeff Bezos", LocalDate.of(1964, 1, 12), "112", true);

        debitCard1 = new DebitCard(customer1, 5000);
        debitCard2 = new DebitCard(customer2, 0);
        debitCardService = new DebitCardService();
    }


    @Test
    public void withdrawMoneyFromDebitCardTrueTest() {
        try {
            debitCardService.withdrawMoneyFromDebitCard(debitCard1,100);
            assertEquals(4900, debitCard1.getBalance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void withdrawMoneyFromDebitCardFalseTest() {
        try {
            debitCardService.withdrawMoneyFromDebitCard(debitCard1,5100);
        } catch (Exception e) {
            e.printStackTrace();
            assertEquals(e.getClass(), LimitExceededException.class);
        }
    }

    @Test
    public void depositMoneyToDebitCardTrueTest() {
        debitCardService.depositMoneyToDebitCard(debitCard1,1000);
        assertEquals(6000, debitCard1.getBalance());
    }

    @Test
    public void depositMoneyToDebitCardFalseTest() {
        try {
            debitCardService.depositMoneyToDebitCard(debitCard1,-1);
        } catch (Exception e) {
            e.getMessage();
            assertEquals(e.getClass(), IllegalArgumentException.class);
        }
    }

    @Test
    public void transferToDifferentDebitCardTrueTest() {
        try {
            debitCardService.transferToDifferentDebitCard(debitCard1, debitCard2, 1000);
            System.out.println("Debit Card #1 balance after transfer: " + debitCard1.getBalance());
            assertEquals(1000, debitCard2.getBalance());
        } catch (LimitExceededException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void transferToDifferentDebitCardFalseTest() {
        try {
            debitCardService.transferToDifferentDebitCard(debitCard1, debitCard2, 6000);
        } catch (Exception e) {
            e.printStackTrace();
            assertEquals(e.getClass(), LimitExceededException.class);
        }
    }

}
