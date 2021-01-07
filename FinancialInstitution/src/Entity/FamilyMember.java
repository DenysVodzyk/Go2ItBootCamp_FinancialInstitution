package Entity;

import java.time.LocalDate;

public class FamilyMember extends Person {
    private String relationship;

    public FamilyMember(String name, LocalDate dOb, String relationship) {
        super(name, dOb);
        this.relationship = relationship;
    }

    @Override
    public String toString() {
        return "FamilyMember{" + super.toString() +
                " relationship='" + relationship + '\'' +
                '}';
    }
}
