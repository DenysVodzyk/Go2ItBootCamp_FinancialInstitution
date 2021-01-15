package Entity;

import java.util.Objects;

public abstract class Product {
    private Customer customer;
    private int balance;


    public Product(Customer customer, int balance) {
        this.customer = customer;
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "FinancialInstitutionProduct{" + "Customer=" + customer.getName() +
                ", balance=" + balance +
                '}';
    }

}
