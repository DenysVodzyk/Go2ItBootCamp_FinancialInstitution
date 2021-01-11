import Entity.*;
import Exception.*;
import Service.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Elon Musk", LocalDate.of(1971, 6, 28), "111", true);
        CustomerCredentials customerCredentials = new CustomerCredentials("Elon Musk", "111");
        customer.setCustomerCredentials(customerCredentials);

        try {
            CustomerService.isCustomerCredentialValid(customer);
            FamilyMember familyMember = new FamilyMember("Kimbal Musk", LocalDate.of(1972, 9, 20), "Brother");

            customer.setCreditScore(800);
            customer.setCanadian(true);
            customer.setAmountSpentLastMonth(50000000);

            DebitCard debitCard = new DebitCard(customer, 100000000);
            CreditCard creditCard = new CreditCard(customer, 500000, 500000);
            try {
                CreditLine creditLine = new CreditLine(customer, 5000000, 5000000);
                CustomerService.addFinancialProduct(customer, creditLine);
            } catch (AccessDeniedException e) {
                e.printStackTrace();
            }
            try {
                Mortgage mortgage = new Mortgage(customer, 100000000, debitCard, 5);
                CustomerService.addFinancialProduct(customer, mortgage);
            } catch (AccessDeniedException e) {
                e.printStackTrace();
            }

            CustomerService.addFinancialProduct(customer, debitCard);
            CustomerService.addFinancialProduct(customer, creditCard);

            System.out.println(customer.getFinancialInstitutionProducts());

        } catch (AccessDeniedException e) {
            e.printStackTrace();
        }

    }
}
