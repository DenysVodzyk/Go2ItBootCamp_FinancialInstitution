import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DebitCardServiceTest {

    @Test
    public void withdrawMoneyFromDebitCardTrueTest() {
        DebitCard debitCard = new DebitCard(5000);
        DebitCardService debitCardService = new DebitCardService(debitCard);
        boolean result = false;

        try {
            result = debitCardService.withdrawMoneyFromDebitCard(100);
        } catch (LimitExceededException e) {
            e.printStackTrace();
        }
        assertTrue(result);
    }

    @Test
    public void withdrawMoneyFromDebitCardFalseTest() {
        DebitCard debitCard = new DebitCard(5000);
        DebitCardService debitCardService = new DebitCardService(debitCard);
        boolean result = false;

        try {
            result = debitCardService.withdrawMoneyFromDebitCard(5001);
        } catch (LimitExceededException e) {
            e.printStackTrace();
        }
        assertFalse(result);
    }

    @Test
    public void depositMoneyToDebitCardTest() {
        DebitCard debitCard = new DebitCard(5000);
        DebitCardService debitCardService = new DebitCardService(debitCard);
        debitCardService.depositMoneyToDebitCard(1000);
        assertEquals(6000, debitCard.getBalanceOnDebitCard());
    }

    @Test
    public void transferToDifferentDebitCardTrueTest() {
        DebitCard debitCard1 = new DebitCard(5000);
        DebitCard debitCardToReceiveTransfer = new DebitCard(0);
        DebitCardService debitCardService = new DebitCardService(debitCard1);

        try {
            debitCardService.transferToDifferentDebitCard(1000, debitCardToReceiveTransfer);
        } catch (LimitExceededException e) {
            e.printStackTrace();
        }
        System.out.println("DebitCard1 balance after transfer: " + debitCard1.getBalanceOnDebitCard());
        assertEquals(1000, debitCardToReceiveTransfer.getBalanceOnDebitCard());
    }

    @Test
    public void transferToDifferentDebitCardFalseTest() {
        String actualMessage = "Not enough money on the card.";
        String exceptionMessage = "";
        DebitCard debitCard1 = new DebitCard(5000);
        DebitCard debitCardToReceiveTransfer = new DebitCard(0);
        DebitCardService debitCardService = new DebitCardService(debitCard1);

        try {
            debitCardService.transferToDifferentDebitCard(5100, debitCardToReceiveTransfer);
        } catch (LimitExceededException e) {
            e.printStackTrace();
            exceptionMessage = e.getMessage();
        }
        assertTrue(exceptionMessage.equals(actualMessage));
    }

}
