package Service;

import Exception.*;
import Entity.*;

public class DebitCardService extends FinancialInstitutionProductService {

    public boolean withdrawMoneyFromDebitCard(DebitCard debitCard, int amountToWithdraw) throws LimitExceededException {
        if (amountToWithdraw > debitCard.getBalance()) {
            throw new LimitExceededException("Not enough money on the card.");
        }
        debitCard.setBalance(debitCard.getBalance() - amountToWithdraw);
        return true;
    }

    public void depositMoneyToDebitCard(DebitCard debitCard, int amountToDeposit) {
        if (amountToDeposit >= 0) {
            debitCard.setBalance(debitCard.getBalance() + amountToDeposit);
        } else {
            throw new IllegalArgumentException("Cannot deposit negative amount");
        }

    }

    public boolean transferToDifferentDebitCard(DebitCard debitCardToWithdraw, DebitCard debitCardToReceive, int amountToTransfer) throws LimitExceededException {
        if (withdrawMoneyFromDebitCard(debitCardToWithdraw, amountToTransfer)) {
            debitCardToReceive.setBalance(debitCardToReceive.getBalance() + amountToTransfer);
            return true;
        }
        return false;
    }
}
