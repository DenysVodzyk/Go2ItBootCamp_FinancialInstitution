package Entity;

import java.time.LocalDate;

public abstract class Person {
    private String name;
    private LocalDate dOb;

    public Person(String name, LocalDate dOb) {
        this.name = name;
        this.dOb = dOb;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dOb=" + dOb +
                '}';
    }
}
