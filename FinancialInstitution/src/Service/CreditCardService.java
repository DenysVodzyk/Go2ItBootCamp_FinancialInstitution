public class CreditCardService {
    private CreditCard creditCard;

    public CreditCardService(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public boolean payWithCreditCard(int itemPrice) throws LimitExceededException {
        if (itemPrice > creditCard.getCreditCardBalance()) {
            throw new LimitExceededException("You cannot exceed credit card limit.");
        }
        creditCard.setCreditCardBalance(creditCard.getCreditCardBalance() - itemPrice);
        return true;
    }

    public void payOffCreditCard(int amountToDeposit) {
        creditCard.setCreditCardBalance(creditCard.getCreditCardBalance() + amountToDeposit);
    }

}
