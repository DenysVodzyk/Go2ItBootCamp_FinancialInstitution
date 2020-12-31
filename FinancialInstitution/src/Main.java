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

        //Credit card

        CreditCard creditCard1 = new CreditCard(100000);
        CreditCard creditCard3 = new CreditCard(100000);


        // Created obj of customer for each of 3 customers
        Customer customer1 = new Customer("John", "1111", LocalDate.of(2000, 1, 10), true);
        Customer customer2 = new Customer("John2", "2222", LocalDate.of(2000, 1, 10), false);
        Customer customer3 = new Customer("John3", "3333", LocalDate.of(2000, 1, 10), true, 680, 5000, true, customer3_Credentials, debitCard3, creditCard3);


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
            System.out.println("Customer 3 balance: " + customer3.getDebitCardBalance());
            customer1.setDebitCard(debitCard1);

            DebitCardService debitCardService = new DebitCardService(debitCard1);
            System.out.println("Customer 1 balance: " + customer1.getDebitCardBalance());
            try {
                debitCardService.transferToDifferentDebitCard(100000, customer3.getDebitCard());
            } catch (LimitExceededException e) {
                e.printStackTrace();
            }
            System.out.println("After transfer, customer1 balance: " + customer1.getDebitCardBalance());
            System.out.println("After transfer, customer3 balance: " + customer3.getDebitCardBalance());

            //check customer eligibility for promotion
            try {
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


        //Credit Card functionality check
        CreditCardService creditCardService1 = new CreditCardService(creditCard1);
        customer1.setCreditCard(creditCard1);

        System.out.println("Initial cc balance: " + creditCard1.getCreditCardBalance());
        try {
            creditCardService1.payWithCreditCard(100);
            creditCardService1.payOffCreditCard(1);
            creditCardService1.payWithCreditCard(9999999);
        } catch (LimitExceededException e) {
            e.printStackTrace();
        }
        System.out.println("cc balance after purchase: " + creditCard1.getCreditCardBalance());

        //Check if mortgage functionality works

        System.out.println("Customer 1 eligibility for mortgage:");
        try {
            Mortgage mortgage = new Mortgage(customer1);
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        }

        System.out.println("Customer 3 eligibility for mortgage:");
        try {
            Mortgage mortgage = new Mortgage(customer3);
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        }

        //Check if credit line functionality works

        System.out.println("Customer 1 eligibility for credit line:");
        try {
            CreditLine creditLine1 = new CreditLine(customer1);
            creditLine1.provideRateInformation();
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        }

        System.out.println("Customer 3 eligibility for credit line:");
        try {
            CreditLine creditLine3 = new CreditLine(customer3);
            creditLine3.provideRateInformation();
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        }


    }
}
