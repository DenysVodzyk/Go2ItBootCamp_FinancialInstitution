import java.time.LocalDate;
import java.util.Objects;

public class FamilyMember {
    private String name;
    private LocalDate dOb;
    private String relationship;

    public FamilyMember(String name, LocalDate dOb, String relationship) {
        this.name = name;
        this.dOb = dOb;
        this.relationship = relationship;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyMember that = (FamilyMember) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(dOb, that.dOb) &&
                Objects.equals(relationship, that.relationship);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dOb, relationship);
    }

    @Override
    public String toString() {
        return "FamilyMember{" +
                "name='" + name + '\'' +
                ", dOb=" + dOb +
                ", relationship='" + relationship + '\'' +
                '}';
    }
}
