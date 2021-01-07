package Entity;

public class CustomerCredentials {
    private String authenticCustomerName;
    private String authenticCustomerPassword;

    public CustomerCredentials(String name, String password) {
        this.authenticCustomerName = name;
        this.authenticCustomerPassword = password;
    }

    public String getAuthenticCustomerName() {
        return authenticCustomerName;
    }

    public void setAuthenticCustomerName(String authenticCustomerName) {
        this.authenticCustomerName = authenticCustomerName;
    }

    public String getAuthenticCustomerPassword() {
        return authenticCustomerPassword;
    }

    public void setAuthenticCustomerPassword(String authenticCustomerPassword) {
        this.authenticCustomerPassword = authenticCustomerPassword;
    }
}
