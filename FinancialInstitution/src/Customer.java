import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Customer {
    private String name;
    private String password;
    private TrueCustomerCredentials trueCustomerCredentials;
    private DebitCard debitCard;
    private LocalDate dOb;
    private boolean canadian;
    private int creditScore;
    private int amountSpentLastMonth;
    private boolean consentToProvideFamilyMemberDetails;
    private Set<FamilyMember> familyMembers = new HashSet<>();

    public Customer(String name, String password, LocalDate dOb, boolean consentToProvideFamilyMemberDetails) {
        this.name = name;
        this.password = password;
        this.dOb = dOb;
        this.consentToProvideFamilyMemberDetails = consentToProvideFamilyMemberDetails;
    }

    public Customer(String name, String password, LocalDate dOb, boolean consentToProvideFamilyMemberDetails, int creditScore, int amountSpentLastMonth, boolean canadian, TrueCustomerCredentials trueCustomerCredentials, DebitCard debitCard) {
        this(name, password, dOb, consentToProvideFamilyMemberDetails);
        this.creditScore = creditScore;
        this.amountSpentLastMonth = amountSpentLastMonth;
        this.canadian = canadian;
        this.trueCustomerCredentials = trueCustomerCredentials;
        this.debitCard = debitCard;
    }

    public TrueCustomerCredentials getTrueCustomerCredentials() {
        return trueCustomerCredentials;
    }

    public void setTrueCustomerCredentials(TrueCustomerCredentials trueCustomerCredentials) {
        this.trueCustomerCredentials = trueCustomerCredentials;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public DebitCard getDebitCard() {
        return debitCard;
    }

    public void setDebitCard(DebitCard debitCard) {
        this.debitCard = debitCard;
    }
}
