import java.time.LocalDate;
import java.util.Objects;

public class FamilyMember {
    private String name;
    private LocalDate dOb;
    private boolean customerOfBank;

    public FamilyMember(String name, LocalDate dOb) {
        this.name = name;
        this.dOb = dOb;
        this.customerOfBank = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyMember that = (FamilyMember) o;
        return customerOfBank == that.customerOfBank &&
                Objects.equals(name, that.name) &&
                Objects.equals(dOb, that.dOb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dOb, customerOfBank);
    }
}
