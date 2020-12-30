public class DebitCardService {
    private DebitCard debitCard;

    public DebitCardService(DebitCard debitCard) {
        this.debitCard = debitCard;
    }

    public boolean withdrawMoneyFromDebitCard(int amountToWithdraw) throws LimitExceededException {
        if (amountToWithdraw > debitCard.getBalanceOnDebitCard()) {
            throw new LimitExceededException("Not enough money on the card.");
        }
        debitCard.setBalanceOnDebitCard(debitCard.getBalanceOnDebitCard() - amountToWithdraw);
        return true;
    }

    public void depositMoneyToDebitCard(int amountToDeposit) {
        debitCard.setBalanceOnDebitCard(debitCard.getBalanceOnDebitCard() + amountToDeposit);
    }

    public boolean transferToDifferentDebitCard(int amountToTransfer, DebitCard debitCard) throws LimitExceededException {
        if (withdrawMoneyFromDebitCard(amountToTransfer)) {
            debitCard.setBalanceOnDebitCard(debitCard.getBalanceOnDebitCard() + amountToTransfer);
            return true;
        }
        return false;
    }
}
