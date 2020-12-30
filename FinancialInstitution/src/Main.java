import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Object of Customer service class
        CustomerService customerService = new CustomerService();


        // Created valid credentials "name" and "password" for each customer
        TrueCustomerCredentials customer1_Credentials = new TrueCustomerCredentials("John", "1111");
        TrueCustomerCredentials customer2_Credentials = new TrueCustomerCredentials("John2", "2222");
        TrueCustomerCredentials customer3_Credentials = new TrueCustomerCredentials("John3", "3333");

        //Debit card
        DebitCard debitCard1 = new DebitCard(1000000);
        DebitCard debitCard3 = new DebitCard(10000);


        // Created obj of customer for each of 3 customers
        Customer customer1 = new Customer("John", "1111", LocalDate.of(2000, 1, 10), true);
        Customer customer2 = new Customer("John2", "2222", LocalDate.of(2000, 1, 10), false);
        Customer customer3 = new Customer("John3", "3333", LocalDate.of(2000, 1, 10), true, 640, 5000, true, customer3_Credentials, debitCard3);


        // Created 2 objects of family member
        FamilyMember familyMember1 = new FamilyMember("Mike", LocalDate.of(1970, 5, 1), "Father");
        FamilyMember familyMember2 = new FamilyMember("Jessica", LocalDate.of(1974, 4, 24), "Mother");


        //set customer 1 properties and added family members to the database. Print out family members
        customer1.setTrueCustomerCredentials(customer1_Credentials);
        try {
            customerService.isCustomerCredentialValid(customer1);
            customer1.setAmountSpentLastMonth(500000);
            customer1.setCanadian(false);
            customer1.setCreditScore(700);
            try {
                customerService.addFamilyMember(customer1, familyMember1);
                customerService.addFamilyMember(customer1, familyMember2);
            } catch (AccessDeniedException e) {
                e.printStackTrace();
            }
            //Print out family members
            System.out.println(customer1.getFamilyMembers());


            //Check DebitCard functionality
            System.out.println("Customer 3 balance: " + customer3.getDebitCard().getBalanceOnDebitCard());
            customer1.setDebitCard(debitCard1);

            DebitCardService debitCardService = new DebitCardService(debitCard1);
            System.out.println("Customer 1 balance: " + customer1.getDebitCard().getBalanceOnDebitCard());
            try {
                debitCardService.transferToDifferentDebitCard(1000001, customer3.getDebitCard());
            } catch (LimitExceededException e) {
                e.printStackTrace();
            }
            System.out.println("After transfer, customer1 balance: " + customer1.getDebitCard().getBalanceOnDebitCard());
            System.out.println("After transfer, customer3 balance: " + customer3.getDebitCard().getBalanceOnDebitCard());

            //check customer eligibility for credit line and promotion
            try {
                customerService.isCustomerEligibleForCreditLine(customer1);
                customerService.isCustomerEligibleForPromotion(customer1);
            } catch (AccessDeniedException e) {
                e.printStackTrace();
            }

        } catch (AccessDeniedException e) {
            e.getMessage();
        }

        //set customer 2 properties and added family members to the database. Print out family members.

        try {
            customerService.addFamilyMember(customer2, familyMember1);
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        }
        System.out.println(customer2.getFamilyMembers());

    }
}
