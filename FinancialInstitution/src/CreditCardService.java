public class CreditCardService {
    private CreditCard creditCard;

    public CreditCardService(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public boolean payWithCreditCard(int itemPrice) throws LimitExceededException {
        if (itemPrice > creditCard.getCreditCardLimit()) {
            throw new LimitExceededException("You cannot exceed credit card limit.");
        }
        creditCard.setCreditCardLimit(creditCard.getCreditCardLimit() - itemPrice);
        return true;
    }

    public void payOffCreditCard(int amountToDeposit) {
        creditCard.setCreditCardLimit(creditCard.getCreditCardLimit() + amountToDeposit);
    }

}
