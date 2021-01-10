package Service;

import Entity.Customer;

public abstract class FinancialInstitutionProductService {
    private Customer customer;

    public FinancialInstitutionProductService(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
