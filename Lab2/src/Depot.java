import java.util.Objects;

class Depot {
    public String name;
    public Depot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Depot depot = (Depot) o;
        return name.equals(depot.name);
    }

    public int hashCode() {
        return Objects.hash(name);
    }
}
