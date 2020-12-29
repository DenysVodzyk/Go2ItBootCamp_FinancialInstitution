import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Customer {
    private String name;
    private LocalDate dOb;
    private boolean canadian;
    private int creditScore;
    private int amountSpentLastMonth;
    private boolean consentToProvideFamilyMemberDetails;
    private Set<FamilyMember> familyMembers;

    public Customer(String name, LocalDate dOB, boolean canadian, int creditScore, int amountSpentLastMonth, boolean consentToProvideFamilyMemberDetails){
        this.name = name;
        this.dOb = dOB;
        this.canadian = canadian;
        this.creditScore = creditScore;
        this.amountSpentLastMonth = amountSpentLastMonth;
        this.consentToProvideFamilyMemberDetails = consentToProvideFamilyMemberDetails;
        this.familyMembers = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getdOb() {
        return dOb;
    }

    public void setdOb(LocalDate dOb) {
        this.dOb = dOb;
    }

    public boolean isCanadian() {
        return canadian;
    }

    public void setCanadian(boolean canadian) {
        this.canadian = canadian;
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

    public boolean isConsentToProvideFamilyMemberDetails() {
        return consentToProvideFamilyMemberDetails;
    }

    public void setConsentToProvideFamilyMemberDetails(boolean consentToProvideFamilyMemberDetails) {
        this.consentToProvideFamilyMemberDetails = consentToProvideFamilyMemberDetails;
    }

    public Set<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(Set<FamilyMember> familyMembers) {
        this.familyMembers = familyMembers;
    }
}
