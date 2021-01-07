public class CreditCard {
    private int creditCardBalance;

    public CreditCard(int creditCardLimit){
        this.creditCardBalance = creditCardLimit;
    }

    public int getCreditCardBalance() {
        return creditCardBalance;
    }

    public void setCreditCardBalance(int creditCardBalance) {
        this.creditCardBalance = creditCardBalance;
    }

}
