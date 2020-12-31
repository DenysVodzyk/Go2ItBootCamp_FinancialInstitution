import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardServiceTest {

    @Test
    public void payWithCreditCardTrueTest() {
        CreditCard creditCard = new CreditCard(1000);
        CreditCardService creditCardService = new CreditCardService(creditCard);
        try {
            creditCardService.payWithCreditCard(100);
        } catch (LimitExceededException e) {
            e.printStackTrace();
        }
        assertEquals(900, creditCard.getCreditCardBalance());
    }

    @Test
    public void payWithCreditCardFalseTest() {
        CreditCard creditCard = new CreditCard(1000);
        CreditCardService creditCardService = new CreditCardService(creditCard);
        try {
            creditCardService.payWithCreditCard(1001);
        } catch (LimitExceededException e) {
            e.printStackTrace();
        }
        assertEquals(1000, creditCard.getCreditCardBalance());
    }

    @Test
    public void payOffCreditCardTest() {
        CreditCard creditCard = new CreditCard(1000);
        CreditCardService creditCardService = new CreditCardService(creditCard);
        creditCardService.payOffCreditCard(1000);
        assertEquals(2000, creditCard.getCreditCardBalance());
    }


}
