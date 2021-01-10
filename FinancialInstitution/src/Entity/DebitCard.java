package Entity;

public class DebitCard extends FinancialInstitutionProduct {

    public DebitCard(Customer customer, int balanceOnDebitCard) {
        super(customer, balanceOnDebitCard);
    }

    @Override
    public String toString() {
        return "Debit Card: " + super.toString();
    }


}
