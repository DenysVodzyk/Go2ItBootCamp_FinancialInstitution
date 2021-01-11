package Service;

import Exception.*;
import Entity.*;

public class DebitCardService extends FinancialInstitutionProductService {
    private DebitCard debitCard;

    public DebitCardService(Customer customer, DebitCard debitCard) {
        super(customer);
        this.debitCard = debitCard;
    }

    public boolean withdrawMoneyFromDebitCard(int amountToWithdraw) throws LimitExceededException {
        if (amountToWithdraw > debitCard.getBalance()) {
            throw new LimitExceededException("Not enough money on the card.");
        }
        debitCard.setBalance(debitCard.getBalance() - amountToWithdraw);
        return true;
    }

    public void depositMoneyToDebitCard(int amountToDeposit) {
        if (amountToDeposit >= 0) {
            debitCard.setBalance(debitCard.getBalance() + amountToDeposit);
        } else {
            throw new IllegalArgumentException("Cannot deposit negative amount");
        }

    }

    public boolean transferToDifferentDebitCard(int amountToTransfer, DebitCard debitCardToReceive) throws LimitExceededException {
        if (withdrawMoneyFromDebitCard(amountToTransfer)) {
            debitCardToReceive.setBalance(debitCardToReceive.getBalance() + amountToTransfer);
            return true;
        }
        return false;
    }
}
