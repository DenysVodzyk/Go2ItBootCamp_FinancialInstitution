package Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Customer extends Person {
    private String password;
    private CustomerCredentials CustomerCredentials;
    private Set<FamilyMember> familyMembers = new HashSet<>();
    private boolean isCanadian;
    private int creditScore;
    private int amountSpentLastMonth;
    private boolean isAgreeToShareFamilyInfo;
    private List<Product> financialInstitutionProducts = new ArrayList<>();
    private boolean isSenior;


    public Customer(String name, LocalDate dOb, String password, boolean isAgreeToShareFamilyInfo) {
        super(name, dOb);
        this.password = password;
        this.isAgreeToShareFamilyInfo = isAgreeToShareFamilyInfo;
    }

    public Customer(String name, LocalDate dOb, String password, boolean isAgreeToShareFamilyInfo, int creditScore, int amountSpentLastMonth, boolean isCanadian) {
        this(name, dOb, password, isAgreeToShareFamilyInfo);
        this.creditScore = creditScore;
        this.amountSpentLastMonth = amountSpentLastMonth;
        this.isCanadian = isCanadian;
    }

    public void setCustomerCredentials(CustomerCredentials customerCredentials) {
        this.CustomerCredentials = customerCredentials;
    }

    public CustomerCredentials getCustomerCredentials() {
        return CustomerCredentials;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isCanadian() {
        return isCanadian;
    }

    public void setCanadian(boolean canadian) {
        this.isCanadian = canadian;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public int getAmountSpentLastMonth() {
        return amountSpentLastMonth;
    }

    public void setAmountSpentLastMonth(int amountSpentLastMonth) {
        this.amountSpentLastMonth = amountSpentLastMonth;
    }

    public boolean isAgreeToShareFamilyInfo() {
        return isAgreeToShareFamilyInfo;
    }

    public void setAgreeToShareFamilyInfo(boolean agreeToShareFamilyInfo) {
        this.isAgreeToShareFamilyInfo = agreeToShareFamilyInfo;
    }

    public Set<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }

    public List<Product> getFinancialInstitutionProducts() {
        return financialInstitutionProducts;
    }

    public boolean isSenior() {
        return isSenior;
    }

    public void setSenior(boolean senior) {
        isSenior = senior;
    }

    @Override
    public String toString() {
        return "Customer{" + "Name=" + super.getName() + ", " +
                "isCanadian=" + isCanadian +
                '}';
    }
}
